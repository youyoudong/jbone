package cn.jbone.sys.api.dto.response;

import java.io.Serializable;

import lombok.Data;

@Data
public class UserSecurityQuestionsResponseDTO implements Serializable {
    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getQuestion() {
        return question;
    }

    public void setQuestion(String question) {
        this.question = question;
    }

    public String getAnswer() {
        return answer;
    }

    public void setAnswer(String answer) {
        this.answer = answer;
    }

    private int userId;

    private String question;

    private String answer;
}
