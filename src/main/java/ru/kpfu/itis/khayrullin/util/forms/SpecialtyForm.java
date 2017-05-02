package ru.kpfu.itis.khayrullin.util.forms;

import org.hibernate.validator.constraints.NotBlank;

public class SpecialtyForm {

    private static final String BLANK_MESSAGE = "This field is mendatory!";

    @NotBlank(message = BLANK_MESSAGE)
    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
