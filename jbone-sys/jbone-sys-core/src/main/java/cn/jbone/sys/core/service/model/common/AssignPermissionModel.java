package cn.jbone.sys.core.service.model.common;

import javax.validation.constraints.Min;

import lombok.Data;

@Data
public class AssignPermissionModel {
    @Min(value = 1, message = "ID必须大于0")
    private int id;
    private int systemId;
    private int[] permission;

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

}
