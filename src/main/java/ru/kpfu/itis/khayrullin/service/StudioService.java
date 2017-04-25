package ru.kpfu.itis.khayrullin.service;

import ru.kpfu.itis.khayrullin.model.Studio;

import java.util.List;

public interface StudioService {

    void add(Studio studio);

    List<Studio> findAllByCityId(Long city);

    List<Studio> getAll();
}
