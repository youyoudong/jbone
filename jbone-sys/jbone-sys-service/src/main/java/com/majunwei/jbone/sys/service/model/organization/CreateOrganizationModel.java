package com.majunwei.jbone.sys.service.model.organization;

import org.hibernate.validator.constraints.NotBlank;

import lombok.Data;

@Data
public class CreateOrganizationModel {
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

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    private Integer pid;
    @NotBlank(message = "组织名称不能为空")
    private String name;
    private String description;
}
