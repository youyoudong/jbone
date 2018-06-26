package cn.jbone.bpm.api.dto.request;

import java.io.Serializable;
import java.util.Map;

import lombok.Data;

/**
 * 启动流程DTO
 */
@Data
public class StartProcessRequestDTO implements Serializable {
    public String getProcessDefinitionKey() {
        return processDefinitionKey;
    }

    public void setProcessDefinitionKey(String processDefinitionKey) {
        this.processDefinitionKey = processDefinitionKey;
    }

    public String getOperator() {
        return operator;
    }

    public void setOperator(String operator) {
        this.operator = operator;
    }

    public String getFormId() {
        return formId;
    }

    public void setFormId(String formId) {
        this.formId = formId;
    }

    public Map<String, Object> getVariables() {
        return variables;
    }

    public void setVariables(Map<String, Object> variables) {
        this.variables = variables;
    }

    /**
     * 流程定义key
     */
    private String processDefinitionKey;

    /**
     * 操作人
     */
    private String operator;

    /**
     * 业务主键
     */
    private String formId;

    /**
     * 流程变量
     */
    private Map<String, Object> variables;
}
