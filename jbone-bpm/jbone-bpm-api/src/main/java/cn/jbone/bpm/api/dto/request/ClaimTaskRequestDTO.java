package cn.jbone.bpm.api.dto.request;

import lombok.Data;

/**
 * 申领任务
 */
@Data
public class ClaimTaskRequestDTO {
    /**
     * 任务ID
     */
    private String taskId;
    /**
     * 申领人
     */
    private String operator;

    public String getTaskId() {
        return taskId;
    }

    public void setTaskId(String taskId) {
        this.taskId = taskId;
    }

    public String getOperator() {
        return operator;
    }

    public void setOperator(String operator) {
        this.operator = operator;
    }

}
