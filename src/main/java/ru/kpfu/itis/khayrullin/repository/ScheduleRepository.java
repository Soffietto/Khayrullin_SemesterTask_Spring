package ru.kpfu.itis.khayrullin.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.kpfu.itis.khayrullin.model.Schedule;

public interface ScheduleRepository extends JpaRepository<Schedule, Long> {

    Schedule findOneByTeacherId(Long teacherId);

    void deleteByTeacherId(Long teacherId);
}
