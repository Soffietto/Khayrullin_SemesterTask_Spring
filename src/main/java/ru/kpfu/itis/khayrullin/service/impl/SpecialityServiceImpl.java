package ru.kpfu.itis.khayrullin.service.impl;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.kpfu.itis.khayrullin.model.Specialty;
import ru.kpfu.itis.khayrullin.repository.SpecialityRepository;
import ru.kpfu.itis.khayrullin.service.SpecialityService;

import java.util.List;

@Service
@Transactional
public class SpecialityServiceImpl implements SpecialityService {

    private final SpecialityRepository specialityRepository;

    public SpecialityServiceImpl(SpecialityRepository specialityRepository) {
        this.specialityRepository = specialityRepository;
    }

    @Override
    public void add(Specialty specialty) {
        specialityRepository.save(specialty);
    }

    @Override
    public List<Specialty> findAllByCity(String city) {
        return specialityRepository.findAllByCity(city);
    }
}
