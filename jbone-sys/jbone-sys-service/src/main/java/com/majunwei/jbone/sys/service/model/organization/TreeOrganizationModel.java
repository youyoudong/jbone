package com.majunwei.jbone.sys.service.model.organization;

import java.util.List;

import lombok.Data;

@Data
public class TreeOrganizationModel extends OrganizationBaseInfoModel {
    public List<TreeOrganizationModel> getChildren() {
        return children;
    }

    public void setChildren(List<TreeOrganizationModel> children) {
        this.children = children;
    }

    private List<TreeOrganizationModel> children;
}
