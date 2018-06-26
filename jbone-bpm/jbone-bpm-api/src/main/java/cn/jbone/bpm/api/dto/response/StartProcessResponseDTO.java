package cn.jbone.bpm.api.dto.response;

import java.io.Serializable;
import java.util.Date;

import lombok.Data;

/**
 * 启动流程响应
 */
@Data
public class StartProcessResponseDTO implements Serializable {

    /**
     * 流程实例Id
     */
    private String processInstanceId;

    /**
     * 流程名称
     */
    private String processName;

    /**
     * 启动时间
     */
    private Date startTime;

    /**
     * 流程发起人
     */
    private String owner;

    /**
     * 业务主键
     */
    private String businessKey;

    public String getProcessInstanceId() {
        return processInstanceId;
    }

    public void setProcessInstanceId(String processInstanceId) {
        this.processInstanceId = processInstanceId;
    }

    public String getProcessName() {
        return processName;
    }

    public void setProcessName(String processName) {
        this.processName = processName;
    }

    public Date getStartTime() {
        return startTime;
    }

    public void setStartTime(Date startTime) {
        this.startTime = startTime;
    }

    public String getOwner() {
        return owner;
    }

    public void setOwner(String owner) {
        this.owner = owner;
    }

    public String getBusinessKey() {
        return businessKey;
    }

    public void setBusinessKey(String businessKey) {
        this.businessKey = businessKey;
    }

}
