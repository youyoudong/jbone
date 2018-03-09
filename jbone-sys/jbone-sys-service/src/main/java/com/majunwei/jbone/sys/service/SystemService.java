package com.majunwei.jbone.sys.service;

import java.util.List;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Path;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import com.majunwei.jbone.sys.dao.domain.RbacSystemEntity;
import com.majunwei.jbone.sys.dao.repository.RbacSystemRepository;
import com.majunwei.jbone.sys.service.model.system.CreateSystemModel;
import com.majunwei.jbone.sys.service.model.system.UpdateSystemModel;

@Service
public class SystemService {

    @Autowired
    private RbacSystemRepository rbacSystemRepository;

    public void save(CreateSystemModel systemModel) {
        RbacSystemEntity systemEntity = new RbacSystemEntity();
        BeanUtils.copyProperties(systemModel, systemEntity);
        rbacSystemRepository.save(systemEntity);
    }

    public void update(UpdateSystemModel systemModel) {
        RbacSystemEntity systemEntity = rbacSystemRepository.findOne(systemModel.getId());
        BeanUtils.copyProperties(systemModel, systemEntity);
        rbacSystemRepository.save(systemEntity);
    }

    public void delete(String ids) {
        String[] idArray = ids.split(",");
        for (String id : idArray) {
            if (StringUtils.isBlank(id)) {
                continue;
            }
            rbacSystemRepository.delete(Integer.parseInt(id));
        }
    }

    public RbacSystemEntity get(int id) {
        return rbacSystemRepository.getOne(id);
    }

    public List<RbacSystemEntity> findAll() {
        return rbacSystemRepository.findAll();
    }

    /**
     * 这里的service即casFilter
     * 
     * @param service
     * @return
     */
    public String findServiceTheme(String service) {
        List<RbacSystemEntity> systemEntities = rbacSystemRepository
                .findByServiceCasFilterOrderByServiceEvaluationOrderDesc(service);

        if (systemEntities != null && !systemEntities.isEmpty()) {
            RbacSystemEntity entity = systemEntities.get(0);
            return entity.getServiceThemePath();
        }

        return "cas-theme-default";
    }

    public Page<RbacSystemEntity> findPage(String condition, Pageable pageable) {
        return rbacSystemRepository.findAll(new SystemSpecification(condition), pageable);
    }

    private class SystemSpecification implements Specification<RbacSystemEntity> {
        private String condition;

        public SystemSpecification(String condition) {
            this.condition = condition;
        }

        public Predicate toPredicate(Root<RbacSystemEntity> root, CriteriaQuery<?> criteriaQuery,
                CriteriaBuilder criteriaBuilder) {
            if (StringUtils.isBlank(condition)) {
                return criteriaQuery.getRestriction();
            }
            Path<String> name = root.get("name");
            Path<String> title = root.get("title");
            Path<String> basepath = root.get("basepath");
            Predicate predicate = criteriaBuilder.or(criteriaBuilder.like(name, "%" + condition + "%"),
                    criteriaBuilder.like(title, "%" + condition + "%"),
                    criteriaBuilder.like(basepath, "%" + condition + "%"));
            return predicate;
        }
    }
}
