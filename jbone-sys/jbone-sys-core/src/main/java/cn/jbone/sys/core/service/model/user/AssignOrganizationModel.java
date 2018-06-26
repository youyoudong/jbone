package cn.jbone.sys.core.service.model.user;

import javax.validation.constraints.Min;

import lombok.Data;

@Data
public class AssignOrganizationModel {
    @Min(value = 1, message = "用户ID必须大于0")
    private int userId;
    private int[] userOrganization;

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public int[] getUserOrganization() {
        return userOrganization;
    }

    public void setUserOrganization(int[] userOrganization) {
        this.userOrganization = userOrganization;
    }

}
