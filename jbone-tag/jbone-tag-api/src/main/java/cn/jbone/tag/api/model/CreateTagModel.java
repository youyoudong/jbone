package cn.jbone.tag.api.model;

import java.io.Serializable;

import lombok.Data;

/**
 * @author HoldDie
 * @version 1.0.0
 * @email holddie@163.com
 * @date 2018/3/22 0:25
 */
@Data
public class CreateTagModel implements Serializable {

    /**
     * 标签名
     */
    private String name;

    /**
     * 作用域，有限枚举，一旦新增，不能修改。 1：店铺 2：商品 3：CMS文章 4：CMS专题 5：CMS栏目
     */
    private Integer target;

    /**
     * 状态 0：删除 1：正常
     */
    private Integer status;

    /**
     * 是否前台展示，一旦新增，不能修改。 0：不展示 1：展示
     */
    private Integer isShow;

    /**
     * 标签图标
     */
    private String icon;

    /**
     * icon类型 1：CSS图标 2：图片
     */
    private String icon_type;

    /**
     * 点击后的跳转链接，如jbone-cms.majunwei.com/topic/111。
     */
    private String click_target;

    /**
     * 是否设置标签有效期，一旦新增，不能修改。 0：不设置有效期 1：设置有效期
     */
    private Integer time_validity;

    /**
     * 时间范围
     */
    private String time_line;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getTarget() {
        return target;
    }

    public void setTarget(Integer target) {
        this.target = target;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public Integer getIsShow() {
        return isShow;
    }

    public void setIsShow(Integer isShow) {
        this.isShow = isShow;
    }

    public String getIcon() {
        return icon;
    }

    public void setIcon(String icon) {
        this.icon = icon;
    }

    public String getIcon_type() {
        return icon_type;
    }

    public void setIcon_type(String icon_type) {
        this.icon_type = icon_type;
    }

    public String getClick_target() {
        return click_target;
    }

    public void setClick_target(String click_target) {
        this.click_target = click_target;
    }

    public Integer getTime_validity() {
        return time_validity;
    }

    public void setTime_validity(Integer time_validity) {
        this.time_validity = time_validity;
    }

    public String getTime_line() {
        return time_line;
    }

    public void setTime_line(String time_line) {
        this.time_line = time_line;
    }

}
