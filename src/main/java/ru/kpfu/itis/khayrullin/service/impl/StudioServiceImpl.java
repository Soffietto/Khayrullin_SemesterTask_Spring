package ru.kpfu.itis.khayrullin.service.impl;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.kpfu.itis.khayrullin.model.Studio;
import ru.kpfu.itis.khayrullin.repository.StudioRepository;
import ru.kpfu.itis.khayrullin.service.StudioService;

import java.util.List;

@Service
@Transactional
public class StudioServiceImpl implements StudioService {

    private final StudioRepository studioRepository;

    public StudioServiceImpl(StudioRepository studioRepository) {
        this.studioRepository = studioRepository;
    }

    @Override
    public void add(Studio studio) {
        studioRepository.save(studio);
    }

    @Override
    public Studio findOneById(Long id) {
        return studioRepository.findOne(id);
    }

    @Override
    public Studio findOneByNameAndCityId(String name, Long cityId) {
        return studioRepository.findOneByNameAndCityId(name, cityId);
    }

    @Override
    public List<Studio> findAllByCityId(Long city) {
        return studioRepository.findAllByCityId(city);
    }

    @Override
    public List<Studio> getAll() {
        return studioRepository.findAll();
    }

    @Override
    public void delete(Long id) {
        studioRepository.delete(id);
    }
}
