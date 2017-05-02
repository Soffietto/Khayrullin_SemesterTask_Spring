package ru.kpfu.itis.khayrullin.service;

import ru.kpfu.itis.khayrullin.model.City;

import java.util.List;

public interface CityService {

    void add(City city);

    City findOneById(Long id);

    City findOneByName(String name);

    List<City> getAll();

    void delete(Long id);
}
