package ru.kpfu.itis.khayrullin.service.impl;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.kpfu.itis.khayrullin.model.City;
import ru.kpfu.itis.khayrullin.repository.CityRepository;
import ru.kpfu.itis.khayrullin.service.CityService;

import java.util.List;

@Service
@Transactional
public class CityServiceImpl implements CityService {

    private final CityRepository cityRepository;

    public CityServiceImpl(CityRepository cityRepository) {
        this.cityRepository = cityRepository;
    }

    @Override
    public void add(City city) {
        cityRepository.save(city);
    }

    @Override
    public City findOneById(Long id) {
        return cityRepository.findOneById(id);
    }

    @Override
    public City findOneByName(String name) {
        return cityRepository.findOneByName(name);
    }

    @Override
    public List<City> getAll() {
        return cityRepository.findAll();
    }
}
