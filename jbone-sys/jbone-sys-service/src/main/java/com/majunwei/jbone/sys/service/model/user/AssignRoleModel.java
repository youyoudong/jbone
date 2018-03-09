package com.majunwei.jbone.sys.service.model.user;

import javax.validation.constraints.Min;

import lombok.Data;

@Data
public class AssignRoleModel {
    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public int[] getUserRole() {
        return userRole;
    }

    public void setUserRole(int[] userRole) {
        this.userRole = userRole;
    }

    @Min(value = 1, message = "用户ID必须大于0")
    private int userId;
    private int[] userRole;
}
