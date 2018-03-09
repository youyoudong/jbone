package com.majunwei.jbone.sys.service.model.common;

import javax.validation.constraints.Min;

import lombok.Data;

@Data
public class AssignPermissionModel {
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getSystemId() {
        return systemId;
    }

    public void setSystemId(int systemId) {
        this.systemId = systemId;
    }

    public int[] getPermission() {
        return permission;
    }

    public void setPermission(int[] permission) {
        this.permission = permission;
    }

    @Min(value = 1, message = "ID必须大于0")
    private int id;
    private int systemId;
    private int[] permission;

}
