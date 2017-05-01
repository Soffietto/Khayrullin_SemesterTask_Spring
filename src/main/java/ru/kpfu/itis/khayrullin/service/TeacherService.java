package ru.kpfu.itis.khayrullin.service;

import ru.kpfu.itis.khayrullin.model.Teacher;

import java.util.List;

public interface TeacherService {

    void add(Teacher teacher);

    List<Teacher> findAllByStudioIdAndSpecialtyIdAndCityId(Long studioId, Long specialtyId, Long cityId);

    List<Teacher> getAll();

    Teacher findOneById(Long id);

    void delete(Long id);
}
