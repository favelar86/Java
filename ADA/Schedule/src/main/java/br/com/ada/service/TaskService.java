package br.com.ada.service;

import br.com.ada.config.interfaces.SchedulerOperations;
import br.com.ada.model.Schedule;
import br.com.ada.model.Task;
import br.com.ada.model.User;
import br.com.ada.utils.LoggerSchedule;

import java.time.LocalDate;

public class TaskService implements SchedulerOperations<Task, LocalDate> {

    UserService userService = new UserService();

    public  Task createTask(Long taskId, String taskName, String taskDescription, LocalDate taskDate, Long scheduleId, Long userId){

        Task task = new Task(taskId, taskName, taskDescription, taskDate);
        LoggerSchedule.log("task criada");
        LoggerSchedule.log(taskId);

        User user = userService.getUser(userId);
        Schedule schedule = user.getSchedules().get(scheduleId);
        schedule.addScheduleItem(task);

        return  task;
    }

    @Override
    public Task cancel(Task task) {
        task.setStatus("CANCEL");
        return task;
    }

    @Override
    public Task changeDate(Task task, LocalDate date) {
        task.setDate(date);
        return task;
    }
}
