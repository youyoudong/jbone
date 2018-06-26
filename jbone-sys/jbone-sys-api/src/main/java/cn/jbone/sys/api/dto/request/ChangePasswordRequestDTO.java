package cn.jbone.sys.api.dto.request;

import java.io.Serializable;

import lombok.Data;

@Data
public class ChangePasswordRequestDTO implements Serializable {
    private String password;

    private String confirmedPassword;

    private String username;

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getConfirmedPassword() {
        return confirmedPassword;
    }

    public void setConfirmedPassword(String confirmedPassword) {
        this.confirmedPassword = confirmedPassword;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

}
