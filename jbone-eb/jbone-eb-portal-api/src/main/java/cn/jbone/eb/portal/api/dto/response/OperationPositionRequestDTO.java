package cn.jbone.eb.portal.api.dto.response;

import lombok.Data;

/**
 * @author hongxiangbin
 * @version 1.0.0
 * @email 862217801@qq.com
 * @date 2018/4/14 13:19
 */
@Data
public class OperationPositionRequestDTO extends OperationPostionBaseInfoDTO {
    private String imgUrl;
    private String linkUrl;
    private String description;
    private int sortNum;

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

}
