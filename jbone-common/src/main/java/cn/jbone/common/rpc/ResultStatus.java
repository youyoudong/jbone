package cn.jbone.common.rpc;

import java.io.Serializable;

import lombok.Data;

@Data
public class ResultStatus implements Serializable {
    private int code = 0; // 状态码

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    private String message = ""; // 提示信息

}
