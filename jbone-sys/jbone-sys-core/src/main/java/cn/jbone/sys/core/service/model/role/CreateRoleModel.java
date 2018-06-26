package cn.jbone.sys.core.service.model.role;

import org.hibernate.validator.constraints.NotBlank;

import lombok.Data;

@Data
public class CreateRoleModel {
    @NotBlank(message = "角色名称不能为空")
    private String name;
    @NotBlank(message = "角色标题不能为空")
    private String title;
    private String description;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
