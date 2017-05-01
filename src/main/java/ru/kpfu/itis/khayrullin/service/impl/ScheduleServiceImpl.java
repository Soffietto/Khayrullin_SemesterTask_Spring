package ru.kpfu.itis.khayrullin.service.impl;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.kpfu.itis.khayrullin.model.Schedule;
import ru.kpfu.itis.khayrullin.repository.ScheduleRepository;
import ru.kpfu.itis.khayrullin.service.ScheduleService;

import java.util.List;

@Service
@Transactional
public class ScheduleServiceImpl implements ScheduleService {

    private final ScheduleRepository scheduleRepository;

    public ScheduleServiceImpl(ScheduleRepository scheduleRepository) {
        this.scheduleRepository = scheduleRepository;
    }

    @Override
    public void add(Schedule schedule) {
        scheduleRepository.save(schedule);
    }

    @Override
    public Schedule findOneById(Long id) {
        return scheduleRepository.findOne(id);
    }

    @Override
    public List<Schedule> getAll() {
        return scheduleRepository.findAll();
    }

    @Override
    public Schedule findOneByTeacherId(Long teacherId) {
        return scheduleRepository.findOneByTeacherId(teacherId);
    }

    @Override
    public void deleteByTeacherId(Long teacherId) {
        scheduleRepository.deleteByTeacherId(teacherId);
    }


}
