package com.majunwei.jbone.sys.service.model.menu;

import org.hibernate.validator.constraints.NotBlank;

import lombok.Data;

@Data
public class CreateMenuModel {
    public Integer getSystemId() {
        return systemId;
    }

    public void setSystemId(Integer systemId) {
        this.systemId = systemId;
    }

    public Integer getPid() {
        return pid;
    }

    public void setPid(Integer pid) {
        this.pid = pid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getTarget() {
        return target;
    }

    public void setTarget(String target) {
        this.target = target;
    }

    public String getIcon() {
        return icon;
    }

    public void setIcon(String icon) {
        this.icon = icon;
    }

    public long getOrders() {
        return orders;
    }

    public void setOrders(long orders) {
        this.orders = orders;
    }

    private Integer systemId;
    private Integer pid;
    @NotBlank(message = "名字不能为空")
    private String name;
    @NotBlank(message = "URL不能为空")
    private String url;
    private String target;
    private String icon;
    private long orders;
}
