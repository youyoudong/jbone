package cn.jbone.sys.core.service.model.organization;

import javax.validation.constraints.Min;

import lombok.Data;

@Data
public class UpdateOrganizationModel extends CreateOrganizationModel {
    @Min(value = 1, message = "ID不能为空，且必须大于0")
    private int id;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
