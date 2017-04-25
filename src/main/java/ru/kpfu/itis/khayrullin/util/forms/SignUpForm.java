package ru.kpfu.itis.khayrullin.util.forms;

import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotBlank;

public class SignUpForm {

    private static final String BLANK_MESSAGE = "This field is mendatory!";

    @NotBlank(message = BLANK_MESSAGE)
    @Email
    private String email;

    private String name;

    @NotBlank(message = BLANK_MESSAGE)
    private String password;

    public static String getBlankMessage() {
        return BLANK_MESSAGE;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
