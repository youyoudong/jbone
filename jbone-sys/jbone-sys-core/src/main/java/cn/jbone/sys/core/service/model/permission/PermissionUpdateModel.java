package cn.jbone.sys.core.service.model.permission;

import lombok.Data;

@Data
public class PermissionUpdateModel extends PermissionCreateModel {
    private int id;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
