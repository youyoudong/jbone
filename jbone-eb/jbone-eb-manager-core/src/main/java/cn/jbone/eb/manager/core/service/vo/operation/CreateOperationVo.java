package cn.jbone.eb.manager.core.service.vo.operation;

import javax.validation.constraints.Min;

import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotBlank;

import lombok.Data;

@Data
public class CreateOperationVo {
    @Min(value = 1, message = "运营位类型不能为空")
    private int type;
    @Length(max = 200, message = "运营位标题最长不能超过200")
    @NotBlank(message = "运营位标题不能为空")
    private String title;
    @Length(max = 200, message = "运营图URL最长不能超过200")
    @NotBlank(message = "运营图URL不能为空")
    private String imgUrl;
    @Length(max = 200, message = "运营跳转链接最长不能超过200")
    @NotBlank(message = "运营跳转链接不能为空")
    private String linkUrl;
    @Length(max = 500, message = "运营描述最长不能超过500")
    private String description;
    @Min(value = 0, message = "运营排序号不能为空,且不能小于0")
    private int sortNum;
    private int status;
    private String operator;

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getImgUrl() {
        return imgUrl;
    }

    public void setImgUrl(String imgUrl) {
        this.imgUrl = imgUrl;
    }

    public String getLinkUrl() {
        return linkUrl;
    }

    public void setLinkUrl(String linkUrl) {
        this.linkUrl = linkUrl;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getSortNum() {
        return sortNum;
    }

    public void setSortNum(int sortNum) {
        this.sortNum = sortNum;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public String getOperator() {
        return operator;
    }

    public void setOperator(String operator) {
        this.operator = operator;
    }
}
