package cn.jbone.sys.core.service.model.role;

import javax.validation.constraints.Min;

import lombok.Data;

@Data
public class AssignMenuModel {
    public int getRoleId() {
        return roleId;
    }

    public void setRoleId(int roleId) {
        this.roleId = roleId;
    }

    public int getSystemId() {
        return systemId;
    }

    public void setSystemId(int systemId) {
        this.systemId = systemId;
    }

    public int[] getRoleMenu() {
        return roleMenu;
    }

    public void setRoleMenu(int[] roleMenu) {
        this.roleMenu = roleMenu;
    }

    @Min(value = 1, message = "角色ID必须大于0")
    private int roleId;
    private int systemId;
    private int[] roleMenu;

}
