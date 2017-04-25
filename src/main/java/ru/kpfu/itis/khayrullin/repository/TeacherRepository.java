package ru.kpfu.itis.khayrullin.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.kpfu.itis.khayrullin.model.Teacher;

import java.util.List;

public interface TeacherRepository extends JpaRepository<Teacher, Long> {

    List<Teacher> findAllByStudioAndSpecialtyAndCity(String studio, String specialty, String city);

}
