package ru.kpfu.itis.khayrullin.service;

import ru.kpfu.itis.khayrullin.model.Specialty;

import java.util.List;

public interface SpecialityService {

    void add(Specialty specialty);

    List<Specialty> findAllByCity(String city);
}
