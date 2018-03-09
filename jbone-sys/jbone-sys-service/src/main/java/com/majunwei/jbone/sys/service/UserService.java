package com.majunwei.jbone.sys.service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Path;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.majunwei.jbone.common.exception.JboneException;
import com.majunwei.jbone.sys.api.model.Menu;
import com.majunwei.jbone.sys.api.model.UserModel;
import com.majunwei.jbone.sys.dao.domain.RbacMenuEntity;
import com.majunwei.jbone.sys.dao.domain.RbacOrganizationEntity;
import com.majunwei.jbone.sys.dao.domain.RbacPermissionEntity;
import com.majunwei.jbone.sys.dao.domain.RbacRoleEntity;
import com.majunwei.jbone.sys.dao.domain.RbacSystemEntity;
import com.majunwei.jbone.sys.dao.domain.RbacUserEntity;
import com.majunwei.jbone.sys.dao.repository.RbacMenuRepository;
import com.majunwei.jbone.sys.dao.repository.RbacOrganizationRepository;
import com.majunwei.jbone.sys.dao.repository.RbacPermissionRepository;
import com.majunwei.jbone.sys.dao.repository.RbacRoleRepository;
import com.majunwei.jbone.sys.dao.repository.RbacSystemRepository;
import com.majunwei.jbone.sys.dao.repository.RbacUserRepository;
import com.majunwei.jbone.sys.dao.repository.RbacUserRoleRepository;
import com.majunwei.jbone.sys.service.model.common.AssignPermissionModel;
import com.majunwei.jbone.sys.service.model.user.AssignMenuModel;
import com.majunwei.jbone.sys.service.model.user.AssignOrganizationModel;
import com.majunwei.jbone.sys.service.model.user.AssignRoleModel;
import com.majunwei.jbone.sys.service.model.user.CreateUserModel;
import com.majunwei.jbone.sys.service.model.user.UpdateUserModel;
import com.majunwei.jbone.sys.service.model.user.UserBaseInfoModel;

@Transactional
@Service
public class UserService {
    @Autowired
    RbacUserRepository userRepository;

    @Autowired
    RbacSystemRepository systemRepository;

    @Autowired
    RbacMenuRepository menuRepository;

    @Autowired
    RbacUserRoleRepository userRoleRepository;

    @Autowired
    RbacRoleRepository roleRepository;

    @Autowired
    RbacPermissionRepository permissionRepository;

    @Autowired
    RbacOrganizationRepository organizationRepository;

    /**
     * 查询用户详情 1、用户基本信息 2、用户权限 3、用户角色 4、用户菜单 注：如果没有传服务名，则不加载用户菜单
     * 
     * @param username
     *            用户名
     * @param serverName
     *            服务名
     * @return 用户详细信息
     */
    public UserModel getUserDetailByNameAndServerName(String username, String serverName) {
        UserModel userModel = new UserModel();
        Set<String> permissions = new HashSet<String>();
        Set<String> roles = new HashSet<String>();

        RbacUserEntity userEntity = userRepository.findByUsername(username);

        // 用户角色
        List<RbacRoleEntity> roleEntities = userEntity.getRoles();
        if (roleEntities != null && !roleEntities.isEmpty()) {
            for (RbacRoleEntity roleEntity : roleEntities) {
                roles.add(roleEntity.getName());

                // 角色对应的权限
                List<RbacPermissionEntity> permissionEntities = roleEntity.getPermissions();
                if (permissionEntities != null && !permissionEntities.isEmpty()) {
                    for (RbacPermissionEntity permissionEntity : permissionEntities) {
                        permissions.add(permissionEntity.getPermissionValue());
                    }
                }
            }
        }

        // 用户权限
        List<RbacPermissionEntity> permissionEntities = userEntity.getPermissions();
        if (permissionEntities != null && !permissionEntities.isEmpty()) {
            for (RbacPermissionEntity permissionEntity : permissionEntities) {
                permissions.add(permissionEntity.getPermissionValue());
            }
        }

        BeanUtils.copyProperties(userEntity, userModel);
        userModel.setPermissions(permissions);
        userModel.setRoles(roles);

        // 如果不包含服务名，则不加载菜单信息
        if (!StringUtils.isBlank(serverName)) {
            // 解析前用户拥有的菜单
            List<Menu> menuList = new ArrayList<Menu>();
            List<RbacMenuEntity> correctMenuList = new ArrayList<RbacMenuEntity>();

            RbacSystemEntity systemEntity = systemRepository.findByName(serverName);
            List<RbacUserEntity> userCondition = new ArrayList<RbacUserEntity>();
            userCondition.add(userEntity);

            // 获取用户和对应角色拥有的系统菜单
            List<RbacMenuEntity> roleMenus = menuRepository.findDistinctByRolesInAndPidAndSystemIdOrderByOrdersDesc(
                    userEntity.getRoles(), 0, systemEntity.getId());
            List<RbacMenuEntity> userMenus = menuRepository
                    .findDistinctByUsersInAndPidAndSystemIdOrderByOrdersDesc(userCondition, 0, systemEntity.getId());
            correctMenuList.addAll(roleMenus);
            correctMenuList.addAll(userMenus);

            for (RbacMenuEntity menuEntity : correctMenuList) {
                Menu menu = new Menu();
                BeanUtils.copyProperties(menuEntity, menu);
                if (isContains(menuList, menu)) {
                    continue;
                }
                List<RbacMenuEntity> childRoleMenus = menuRepository
                        .findDistinctByRolesInAndPidAndSystemIdOrderByOrdersDesc(userEntity.getRoles(),
                                menuEntity.getId(), systemEntity.getId());
                List<RbacMenuEntity> childUserMenus = menuRepository
                        .findDistinctByUsersInAndPidAndSystemIdOrderByOrdersDesc(userCondition, menuEntity.getId(),
                                systemEntity.getId());
                List<RbacMenuEntity> childMenus = new ArrayList<RbacMenuEntity>();
                childMenus.addAll(childRoleMenus);
                childMenus.addAll(childUserMenus);

                if (!childMenus.isEmpty()) {
                    List<Menu> childMenuList = new ArrayList<Menu>();
                    for (RbacMenuEntity childMenuEntity : childMenus) {
                        Menu childMenu = new Menu();
                        BeanUtils.copyProperties(childMenuEntity, childMenu);
                        if (isContains(childMenuList, childMenu)) {
                            continue;
                        }
                        childMenuList.add(childMenu);

                    }
                    Collections.sort(childMenuList);
                    menu.setChildMenus(childMenuList);
                }

                menuList.add(menu);

            }
            Collections.sort(menuList);
            userModel.setMenus(menuList);
        }

        return userModel;
    }

    /**
     * 获取用户实体
     * 
     * @param username
     * @return
     */
    public UserBaseInfoModel findByUserName(String username) {
        RbacUserEntity userEntity = userRepository.findByUsername(username);
        if (userEntity == null) {
            throw new JboneException("没有找到用户");
        }
        UserBaseInfoModel userBaseInfoModel = new UserBaseInfoModel();
        BeanUtils.copyProperties(userEntity, userBaseInfoModel);
        return userBaseInfoModel;
    }

    private boolean isContains(List<Menu> menuEntities, Menu menu) {
        for (Menu rbacMenuEntity : menuEntities) {
            if (menu.getId() == rbacMenuEntity.getId()) {
                return true;
            }
        }
        return false;
    }

    /**
     * 新增用户
     * 
     * @param userModel
     */
    public void save(CreateUserModel userModel) {
        RbacUserEntity userEntity = new RbacUserEntity();
        BeanUtils.copyProperties(userModel, userEntity);
        userRepository.save(userEntity);
    }

    /**
     * 更新用户
     * 
     * @param userModel
     */
    public void update(UpdateUserModel userModel) {
        RbacUserEntity userEntity = userRepository.findOne(userModel.getId());
        if (userEntity == null) {
            throw new JboneException("没有找到用户");
        }
        BeanUtils.copyProperties(userModel, userEntity);
        userRepository.save(userEntity);
    }

    /**
     * 删除用户
     * 
     * @param ids
     */
    public void delete(String ids) {
        String[] idArray = ids.split(",");
        for (String id : idArray) {
            if (StringUtils.isBlank(id)) {
                continue;
            }
            userRepository.delete(Integer.parseInt(id));
        }
    }

    /**
     * 根据ID查询用户
     * 
     * @param id
     * @return
     */
    public RbacUserEntity findById(int id) {
        RbacUserEntity userEntity = userRepository.findOne(id);
        if (userEntity == null) {
            throw new JboneException("没有找到用户");
        }
        return userEntity;
    }

    /**
     * 分配角色
     *
     * 1、全部删除 2、重新赋值
     * 
     * @param assignRoleModel
     */
    public void assignRole(AssignRoleModel assignRoleModel) {
        RbacUserEntity userEntity = userRepository.findOne(assignRoleModel.getUserId());
        List<RbacRoleEntity> roleEntities = roleRepository.findByIdIn(assignRoleModel.getUserRole());
        userEntity.setRoles(roleEntities);
    }

    /**
     * 分页查询
     * 
     * @return
     */
    public Page<RbacUserEntity> findPage(String condition, PageRequest pageRequest) {
        // 分页查找
        return userRepository.findAll(new UserSpecification(condition), pageRequest);
    }

    /**
     * 分配菜单
     * 
     * @param assignMenuModel
     */
    public void assignMenu(AssignMenuModel assignMenuModel) {
        // 首先删除用户在该系统下的所有菜单
        RbacUserEntity userEntity = this.findById(assignMenuModel.getUserId());
        List<RbacMenuEntity> menuEntities = userEntity.getMenus();
        if (menuEntities != null && !menuEntities.isEmpty()) {
            for (int i = 0; i < menuEntities.size(); i++) {
                RbacMenuEntity menuEntity = menuEntities.get(i);
                if (menuEntity.getSystemId() == assignMenuModel.getSystemId()) {
                    menuEntities.remove(menuEntity);
                    i--;
                }
            }
        }

        // 然后插入用户菜单
        if (assignMenuModel.getUserMenu() != null && assignMenuModel.getUserMenu().length > 0) {
            List<RbacMenuEntity> newMenus = menuRepository.findByIdIn(assignMenuModel.getUserMenu());
            menuEntities.addAll(newMenus);
        }
    }

    /**
     * 分配权限
     * 
     * @param permissionModel
     */
    public void assignPermission(AssignPermissionModel permissionModel) {
        // 首先删除该系统下所有菜单
        RbacUserEntity userEntity = userRepository.findOne(permissionModel.getId());
        List<RbacPermissionEntity> permissionEntities = userEntity.getPermissions();
        if (permissionEntities != null && !permissionEntities.isEmpty()) {
            for (int i = 0; i < permissionEntities.size(); i++) {
                RbacPermissionEntity permissionEntity = permissionEntities.get(i);
                if (permissionEntity.getSystemId() == permissionModel.getSystemId()) {
                    permissionEntities.remove(permissionEntity);
                    i--;
                }
            }
        }

        // 然后插入权限
        if (permissionModel.getPermission() != null && permissionModel.getPermission().length > 0) {
            List<RbacPermissionEntity> newPermissions = permissionRepository
                    .findByIdIn(permissionModel.getPermission());
            permissionEntities.addAll(newPermissions);
        }
    }

    /**
     * 分配组织机构
     */
    public void assignOrganization(AssignOrganizationModel assignOrganizationModel) {
        // 首先删除用户在该系统下的所有菜单
        RbacUserEntity userEntity = this.findById(assignOrganizationModel.getUserId());
        List<RbacOrganizationEntity> organizationEntities = userEntity.getOrganizations();
        organizationEntities.clear();
        // 然后插入用户菜单
        if (assignOrganizationModel.getUserOrganization() != null
                && assignOrganizationModel.getUserOrganization().length > 0) {
            List<RbacOrganizationEntity> newOganizations = organizationRepository
                    .findByIdIn(assignOrganizationModel.getUserOrganization());
            organizationEntities.addAll(newOganizations);
        }

    }

    /**
     * 用户查询声明，用于模糊查询分页
     */
    private class UserSpecification implements Specification<RbacUserEntity> {
        private String condition;

        public UserSpecification(String condition) {
            this.condition = condition;
        }

        public Predicate toPredicate(Root<RbacUserEntity> root, CriteriaQuery<?> criteriaQuery,
                CriteriaBuilder criteriaBuilder) {
            if (StringUtils.isBlank(condition)) {
                return criteriaQuery.getRestriction();
            }
            Path<String> username = root.get("username");
            Path<String> realname = root.get("realname");
            Path<String> phone = root.get("phone");
            Path<String> email = root.get("email");
            Predicate predicate = criteriaBuilder.or(criteriaBuilder.like(username, "%" + condition + "%"),
                    criteriaBuilder.like(realname, "%" + condition + "%"),
                    criteriaBuilder.like(phone, "%" + condition + "%"),
                    criteriaBuilder.like(email, "%" + condition + "%"));
            return predicate;
        }
    }

    public List<UserBaseInfoModel> getUserBaseInfos(List<RbacUserEntity> userEntities) {
        List<UserBaseInfoModel> userBaseInfoModelList = new ArrayList<UserBaseInfoModel>();
        if (userEntities == null || userEntities.isEmpty()) {
            return userBaseInfoModelList;
        }
        for (RbacUserEntity userEntity : userEntities) {
            UserBaseInfoModel userBaseInfoModel = new UserBaseInfoModel();
            BeanUtils.copyProperties(userEntity, userBaseInfoModel);
            userBaseInfoModelList.add(userBaseInfoModel);
        }
        return userBaseInfoModelList;
    }

}
