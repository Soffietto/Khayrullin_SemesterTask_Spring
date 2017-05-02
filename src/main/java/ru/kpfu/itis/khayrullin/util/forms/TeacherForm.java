package ru.kpfu.itis.khayrullin.util.forms;

import org.hibernate.validator.constraints.NotBlank;

public class TeacherForm {

    private static final String BLANK_MESSAGE = "This field is mendatory!";

    @NotBlank(message = BLANK_MESSAGE)
    private String firstName;

    @NotBlank(message = BLANK_MESSAGE)
    private String lastName;

    private Integer age;

    private Integer seniority;

    private String regalia;

    @NotBlank(message = BLANK_MESSAGE)
    private String phone;

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public Integer getSeniority() {
        return seniority;
    }

    public void setSeniority(int seniority) {
        this.seniority = seniority;
    }

    public String getRegalia() {
        return regalia;
    }

    public void setRegalia(String regalia) {
        this.regalia = regalia;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }
}
