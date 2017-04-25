package ru.kpfu.itis.khayrullin.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.kpfu.itis.khayrullin.model.Specialty;

import java.util.List;

public interface SpecialityRepository extends JpaRepository<Specialty, Long> {

    List<Specialty> findAllByCity(String city);
}
