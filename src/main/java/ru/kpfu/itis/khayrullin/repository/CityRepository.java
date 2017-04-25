package ru.kpfu.itis.khayrullin.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.kpfu.itis.khayrullin.model.City;

public interface CityRepository extends JpaRepository<City, Long> {

    City findOneById(Long id);

    City findOneByName(String name);

}
