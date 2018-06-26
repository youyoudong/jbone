package cn.jbone.bpm.api.dto.request;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import cn.jbone.bpm.api.enums.TaskAuditEnum;
import lombok.Data;

/**
 * 完成任务DTO
 */
@Data
public class ClaimAndCompleteTaskRequestDTO {
    private String processInstanceId; // 流程实例ID
    private String taskId; // 任务ID
    private String taskDefinitionKey; // 任务Key
    private TaskAuditEnum audit; // 审核意见(pass/reject)
    private String reason; // 原因说明
    private String selectUser; // 指定下一步办理人
    private String operator; // 当前办理人
    private int priority; // 指定优先级
    private String isOverDue; // 是否过期
    private Date validDate; // 流程操作有效时间
    private Map<String, Object> variables = new HashMap<>();// 流程运行时参数

    public String getProcessInstanceId() {
        return processInstanceId;
    }

    public void setProcessInstanceId(String processInstanceId) {
        this.processInstanceId = processInstanceId;
    }

    public String getTaskId() {
        return taskId;
    }

    public void setTaskId(String taskId) {
        this.taskId = taskId;
    }

    public String getTaskDefinitionKey() {
        return taskDefinitionKey;
    }

    public void setTaskDefinitionKey(String taskDefinitionKey) {
        this.taskDefinitionKey = taskDefinitionKey;
    }

    public TaskAuditEnum getAudit() {
        return audit;
    }

    public void setAudit(TaskAuditEnum audit) {
        this.audit = audit;
    }

    public String getReason() {
        return reason;
    }

    public void setReason(String reason) {
        this.reason = reason;
    }

    public String getSelectUser() {
        return selectUser;
    }

    public void setSelectUser(String selectUser) {
        this.selectUser = selectUser;
    }

    public String getOperator() {
        return operator;
    }

    public void setOperator(String operator) {
        this.operator = operator;
    }

    public int getPriority() {
        return priority;
    }

    public void setPriority(int priority) {
        this.priority = priority;
    }

    public String getIsOverDue() {
        return isOverDue;
    }

    public void setIsOverDue(String isOverDue) {
        this.isOverDue = isOverDue;
    }

    public Date getValidDate() {
        return validDate;
    }

    public void setValidDate(Date validDate) {
        this.validDate = validDate;
    }

    public Map<String, Object> getVariables() {
        return variables;
    }

    public void setVariables(Map<String, Object> variables) {
        this.variables = variables;
    }
}
