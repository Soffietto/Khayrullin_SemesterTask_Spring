package ru.kpfu.itis.khayrullin.service;

import ru.kpfu.itis.khayrullin.model.Schedule;

import java.util.List;

public interface ScheduleService {

    void add(Schedule schedule);

    Schedule findOneById(Long id);

    List<Schedule> getAll();

    Schedule findOneByTeacherId(Long teacherId);

    void deleteByTeacherId(Long teacherId);
}
