package br.com.ada.service;

import br.com.ada.model.Schedule;
import br.com.ada.model.User;

public class ScheduleService {

    UserService userService = new UserService();

    public Schedule addSchedule(Long scheduleId, String scheduleTitle, Long userId){
        Schedule schedule = new Schedule(scheduleId, scheduleTitle);
        User user = userService.getUser(userId);
        user.addSchedules(schedule);
        return schedule;
    }
}
