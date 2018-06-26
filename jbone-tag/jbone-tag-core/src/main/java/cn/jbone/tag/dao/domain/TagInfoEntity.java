package cn.jbone.tag.dao.domain;

import java.io.Serializable;
import java.sql.Date;
import java.sql.Timestamp;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Version;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import lombok.Data;

/**
 * 标签信息实体
 * 
 * @author HoldDie
 * @version 1.0.0
 * @email holddie@163.com
 * @date 2018/3/22 2:00
 */
@Entity
@Data
@Table(name = "tag_info")
public class TagInfoEntity implements Serializable {
    /**
     * 物理主键
     */
    @Id
    @Column(name = "id", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    /**
     * 标签名
     */
    @Basic
    @Column(name = "name")
    private String name;

    /**
     * 作用域，有限枚举，一旦新增，不能修改。 1：店铺 2：商品 3：CMS文章 4：CMS专题 5：CMS栏目
     */
    @Basic
    @Column(name = "target")
    private Integer target;

    /**
     * 状态 0：删除 1：正常
     */
    @Basic
    @Column(name = "status")
    private Integer status;

    /**
     * 是否前台展示，一旦新增，不能修改。 0：不展示 1：展示
     */
    @Basic
    @Column(name = "is_show")
    private Integer isShow;

    /**
     * 标签图标
     */
    @Basic
    @Column(name = "icon")
    private String icon;

    /**
     * icon类型 1：CSS图标 2：图片
     */
    @Basic
    @Column(name = "icon_type")
    private String icon_type;

    /**
     * 点击后的跳转链接，如jbone-cms.majunwei.com/topic/111。
     */
    @Basic
    @Column(name = "click_target")
    private String click_target;

    /**
     * 是否设置标签有效期，一旦新增，不能修改。 0：不设置有效期 1：设置有效期
     */
    @Basic
    @Column(name = "time_validity")
    private Integer time_validity;

    /**
     * 当“timeValidity”为1时，改值必填，有效期的开始时间。
     */
    @Basic
    @Column(name = "start_time")
    private Date start_time;

    /**
     * 当“timeValidity”为1时，改值必填，有效期的结束时间。
     */
    @Basic
    @Column(name = "end_time")
    private Date end_time;

    /**
     * 预留扩展信息，json格式
     */
    @Basic
    @Column(name = "extend")
    private String extend;

    /**
     * 申请人
     */
    @Basic
    @Column(name = "applier")
    private String applier;

    /**
     * 申请说明
     */
    @Basic
    @Column(name = "apply_reason")
    private String apply_reason;

    /**
     * 添加时间
     */
    @CreationTimestamp
    @Basic
    @Column(name = "add_time")
    private Timestamp add_time;

    /**
     * 最近修改时间
     */
    @UpdateTimestamp
    @Basic
    @Column(name = "update_time")
    private Timestamp update_time;

    /**
     * 版本号
     */
    @Version
    @Column(name = "version")
    private Integer version;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

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

    public Date getStart_time() {
        return start_time;
    }

    public void setStart_time(Date start_time) {
        this.start_time = start_time;
    }

    public Date getEnd_time() {
        return end_time;
    }

    public void setEnd_time(Date end_time) {
        this.end_time = end_time;
    }

    public String getExtend() {
        return extend;
    }

    public void setExtend(String extend) {
        this.extend = extend;
    }

    public String getApplier() {
        return applier;
    }

    public void setApplier(String applier) {
        this.applier = applier;
    }

    public String getApply_reason() {
        return apply_reason;
    }

    public void setApply_reason(String apply_reason) {
        this.apply_reason = apply_reason;
    }

    public Timestamp getAdd_time() {
        return add_time;
    }

    public void setAdd_time(Timestamp add_time) {
        this.add_time = add_time;
    }

    public Timestamp getUpdate_time() {
        return update_time;
    }

    public void setUpdate_time(Timestamp update_time) {
        this.update_time = update_time;
    }

    public Integer getVersion() {
        return version;
    }

    public void setVersion(Integer version) {
        this.version = version;
    }

}
