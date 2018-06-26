package cn.jbone.bpm.api.dto.request;

import java.util.Map;

import lombok.Data;

/**
 * 跳转任务请求，用于动态跳转流程(非标准审批)
 */
@Data
public class SkipTaskRequestDTO {

    /**
     * 任务ID
     */
    private String taskId;

    /**
     * 目标节点key
     */
    private String targetNode;

    /**
     * 跳转原因
     */
    private String reason;

    /**
     * 操作人
     */
    private String operator;

    /**
     * 流程变量
     */
    private Map<String, Object> variables;

    public String getTaskId() {
        return taskId;
    }

    public void setTaskId(String taskId) {
        this.taskId = taskId;
    }

    public String getTargetNode() {
        return targetNode;
    }

    public void setTargetNode(String targetNode) {
        this.targetNode = targetNode;
    }

    public String getReason() {
        return reason;
    }

    public void setReason(String reason) {
        this.reason = reason;
    }

    public String getOperator() {
        return operator;
    }

    public void setOperator(String operator) {
        this.operator = operator;
    }

    public Map<String, Object> getVariables() {
        return variables;
    }

    public void setVariables(Map<String, Object> variables) {
        this.variables = variables;
    }
}
