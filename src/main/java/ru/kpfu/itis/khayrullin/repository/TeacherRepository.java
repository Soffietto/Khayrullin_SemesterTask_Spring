package ru.kpfu.itis.khayrullin.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.kpfu.itis.khayrullin.model.Teacher;

import java.util.List;

public interface TeacherRepository extends JpaRepository<Teacher, Long> {

    List<Teacher> findAllByStudioIdAndSpecialtyNameAndCityId(Long studioId, String specialtyName, Long cityId);

    Teacher findOneByStudioIdAndSpecialtyNameAndCityIdAndLastName(Long studioId, String specialtyName, Long cityId, String lastName);

}
