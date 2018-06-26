package cn.jbone.sys.core.service.model.user;

import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotBlank;

import lombok.Data;

@Data
public class CreateUserModel {
    @NotBlank(message = "用户名不能为空")
    @Length(max = 20, message = "用户名最长不能超过20")
    private String username;
    @Length(max = 100, message = "密码最长不能超过100")
    @NotBlank(message = "密码不能为空")
    private String password;
    @Length(max = 20, message = "真实名字最长不能超过20")
    @NotBlank(message = "真实名字不能为空")
    private String realname;
    private String avatar;
    private String phone;
    private String email;
    private int sex;
    private int locked;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getRealname() {
        return realname;
    }

    public void setRealname(String realname) {
        this.realname = realname;
    }

    public String getAvatar() {
        return avatar;
    }

    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getSex() {
        return sex;
    }

    public void setSex(int sex) {
        this.sex = sex;
    }

    public int getLocked() {
        return locked;
    }

    public void setLocked(int locked) {
        this.locked = locked;
    }
}
