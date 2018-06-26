package cn.jbone.bpm.api.dto.request;

import lombok.Data;

/**
 * 挂起任务DTO
 */
@Data
public class ReactiveTaskRequestDTO {
    /**
     * 任务ID
     */
    private String taskId;
    /**
     * 操作人
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
