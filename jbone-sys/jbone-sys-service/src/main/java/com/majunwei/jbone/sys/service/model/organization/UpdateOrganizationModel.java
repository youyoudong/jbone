package com.majunwei.jbone.sys.service.model.organization;

import javax.validation.constraints.Min;

import lombok.Data;

@Data
public class UpdateOrganizationModel extends CreateOrganizationModel {
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Min(value = 1, message = "ID不能为空，且必须大于0")
    private int id;
}