package ru.kpfu.itis.khayrullin.util.transformers;

import ru.kpfu.itis.khayrullin.model.Schedule;
import ru.kpfu.itis.khayrullin.util.forms.ScheduleForm;

import java.util.function.Function;

public class ScheduleFormToScheduleTransformer implements Function<ScheduleForm, Schedule> {
    @Override
    public Schedule apply(ScheduleForm scheduleForm) {
        Schedule schedule = new Schedule();
        schedule.setMonday(scheduleForm.getMonday());
        schedule.setTuesday(scheduleForm.getTuesday());
        schedule.setWednesday(scheduleForm.getWednesday());
        schedule.setThursday(scheduleForm.getThursday());
        schedule.setFriday(scheduleForm.getFriday());
        schedule.setSaturday(scheduleForm.getSaturday());
        schedule.setSunday(scheduleForm.getSunday());
        return schedule;
    }
}
