package com.majunwei.jbone.sys.service.model.permission;

import lombok.Data;

@Data
public class PermissionUpdateModel extends PermissionCreateModel {
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    private int id;
}
