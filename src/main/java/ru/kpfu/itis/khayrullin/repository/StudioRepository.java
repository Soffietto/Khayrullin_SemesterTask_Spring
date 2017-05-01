package ru.kpfu.itis.khayrullin.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.kpfu.itis.khayrullin.model.Studio;

import java.util.List;

public interface StudioRepository extends JpaRepository<Studio, Long> {

    List<Studio> findAllByCityId(Long cityId);
}
