package cn.jbone.sys.core.service.model.menu;

import java.util.List;

import lombok.Data;

@Data
public class TreeMenuModel extends MenuBaseInfoModel {
    public List<TreeMenuModel> getChildren() {
        return children;
    }

    public void setChildren(List<TreeMenuModel> children) {
        this.children = children;
    }

    private List<TreeMenuModel> children;
}
