package cn.jbone.bpm.core.service.vo.processinstance;

import java.util.Date;

import lombok.Data;

@Data
public class ProcessInstanceListVo {
    private String processInstanceId; // 流程实例ID
    private String owner; // 流程发起人
    private String processDefinitionKey;// 流程定义Key
    private String status; // 状态，正常active，结束stop
    private String processInstanceName; // 流程名字
    private Date startedBefore; // XXX之前启动
    private Date startedAfter; // XXX之后启动
    private Date endBefore; // XXX之前结束
    private Date endAfter; // XXX之后结束
    private String orderBy; // 排序字段
    private String sort; // 排序规则

    public String getProcessInstanceId() {
        return processInstanceId;
    }

    public void setProcessInstanceId(String processInstanceId) {
        this.processInstanceId = processInstanceId;
    }

    public String getOwner() {
        return owner;
    }

    public void setOwner(String owner) {
        this.owner = owner;
    }

    public String getProcessDefinitionKey() {
        return processDefinitionKey;
    }

    public void setProcessDefinitionKey(String processDefinitionKey) {
        this.processDefinitionKey = processDefinitionKey;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getProcessInstanceName() {
        return processInstanceName;
    }

    public void setProcessInstanceName(String processInstanceName) {
        this.processInstanceName = processInstanceName;
    }

    public Date getStartedBefore() {
        return startedBefore;
    }

    public void setStartedBefore(Date startedBefore) {
        this.startedBefore = startedBefore;
    }

    public Date getStartedAfter() {
        return startedAfter;
    }

    public void setStartedAfter(Date startedAfter) {
        this.startedAfter = startedAfter;
    }

    public Date getEndBefore() {
        return endBefore;
    }

    public void setEndBefore(Date endBefore) {
        this.endBefore = endBefore;
    }

    public Date getEndAfter() {
        return endAfter;
    }

    public void setEndAfter(Date endAfter) {
        this.endAfter = endAfter;
    }

    public String getOrderBy() {
        return orderBy;
    }

    public void setOrderBy(String orderBy) {
        this.orderBy = orderBy;
    }

    public String getSort() {
        return sort;
    }

    public void setSort(String sort) {
        this.sort = sort;
    }

    public static String ACTIVE_STATUS = "active";
    public static String STOP_STATUS = "stop";
    public static String SORT_ASC = "asc"; // 正序
    public static String SORT_DESC = "desc"; // 倒叙
}
