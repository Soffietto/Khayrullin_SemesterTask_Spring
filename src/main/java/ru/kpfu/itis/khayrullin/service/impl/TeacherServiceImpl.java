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
    public List<Teacher> findAllByStudioIdAndSpecialtyIdAndCityId(Long studioId, Long specialtyId, Long cityId) {
        return teacherRepository.findAllByStudioIdAndSpecialtyIdAndCityId(studioId, specialtyId, cityId);
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
