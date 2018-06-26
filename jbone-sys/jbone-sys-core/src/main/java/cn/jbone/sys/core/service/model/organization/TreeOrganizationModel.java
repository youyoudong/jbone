package cn.jbone.sys.core.service.model.organization;

import java.util.List;

import lombok.Data;

@Data
public class TreeOrganizationModel extends OrganizationBaseInfoModel {
    private List<TreeOrganizationModel> children;

    public List<TreeOrganizationModel> getChildren() {
        return children;
    }

    public void setChildren(List<TreeOrganizationModel> children) {
        this.children = children;
    }
}
