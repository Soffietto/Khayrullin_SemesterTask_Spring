package ru.kpfu.itis.khayrullin.service.impl;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.kpfu.itis.khayrullin.model.Teacher;
import ru.kpfu.itis.khayrullin.repository.TeacherRepository;
import ru.kpfu.itis.khayrullin.service.TeacherService;

import java.util.List;

@Service
@Transactional
public class TeacherServiceImpl implements TeacherService {

    private final TeacherRepository teacherRepository;

    public TeacherServiceImpl(TeacherRepository teacherRepository) {
        this.teacherRepository = teacherRepository;
    }

    @Override
    public void add(Teacher teacher) {
        teacherRepository.save(teacher);
    }

    @Override
    public List<Teacher> findAllByStudioIdAndSpecialtyNameAndCityId(Long studioId, String specialty, Long cityId) {
        return teacherRepository.findAllByStudioIdAndSpecialtyNameAndCityId(studioId, specialty, cityId);
    }

    @Override
    public Teacher findOneByStudioIdAndSpecialtyNameAndCityIdAndLastName(Long studioId, String specialty, Long cityId, String lastName) {
        return teacherRepository.findOneByStudioIdAndSpecialtyNameAndCityIdAndLastName(studioId, specialty, cityId, lastName);
    }

    @Override
    public List<Teacher> getAll() {
        return teacherRepository.findAll();
    }

    @Override
    public Teacher findOneById(Long id) {
        return teacherRepository.findOne(id);
    }

    @Override
    public void delete(Long id) {
        teacherRepository.delete(id);
    }
}
