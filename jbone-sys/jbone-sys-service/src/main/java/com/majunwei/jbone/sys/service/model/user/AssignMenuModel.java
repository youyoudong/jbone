package com.majunwei.jbone.sys.service.model.user;

import javax.validation.constraints.Min;

import lombok.Data;

@Data
public class AssignMenuModel {
    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public int getSystemId() {
        return systemId;
    }

    public void setSystemId(int systemId) {
        this.systemId = systemId;
    }

    public int[] getUserMenu() {
        return userMenu;
    }

    public void setUserMenu(int[] userMenu) {
        this.userMenu = userMenu;
    }

    @Min(value = 1, message = "用户ID必须大于0")
    private int userId;
    private int systemId;
    private int[] userMenu;

}
