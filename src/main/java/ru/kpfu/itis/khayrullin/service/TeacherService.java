package ru.kpfu.itis.khayrullin.service;

import ru.kpfu.itis.khayrullin.model.Teacher;

import java.util.List;

public interface TeacherService {

    void add(Teacher teacher);

    List<Teacher> findAllByStudioAndSpecialtyAndCity(String studio, String specialty, String city);
}
