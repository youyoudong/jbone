package cn.jbone.bpm.api.dto.request;

import lombok.Data;

/**
 * 终止流程DTO
 */
@Data
public class StopProcessRequestDTO {
    /**
     * 操作者
     */
    private String operator;
    /**
     * 流程实例ID
     */
    private String processInstanceId;
    /**
     * 终止原因
     */
    private String reason;

    public String getOperator() {
        return operator;
    }

    public void setOperator(String operator) {
        this.operator = operator;
    }

    public String getProcessInstanceId() {
        return processInstanceId;
    }

    public void setProcessInstanceId(String processInstanceId) {
        this.processInstanceId = processInstanceId;
    }

    public String getReason() {
        return reason;
    }

    public void setReason(String reason) {
        this.reason = reason;
    }

}
