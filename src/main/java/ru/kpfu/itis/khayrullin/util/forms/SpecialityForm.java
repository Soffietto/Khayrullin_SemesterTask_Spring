package ru.kpfu.itis.khayrullin.util.forms;

import ru.kpfu.itis.khayrullin.model.City;

public class SpecialityForm {

    private String name;

    private City city;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public City getCity() {
        return city;
    }

    public void setCity(City city) {
        this.city = city;
    }
}
