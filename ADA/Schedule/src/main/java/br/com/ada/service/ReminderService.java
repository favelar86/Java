package br.com.ada.service;

import br.com.ada.config.interfaces.SchedulerOperations;
import br.com.ada.model.Reminder;

import java.time.LocalDate;

public class ReminderService implements SchedulerOperations<Reminder, LocalDate> {

    @Override
    public Reminder cancel(Reminder reminder) {
        reminder.setActive(false);
        return reminder;
    }

    @Override
    public Reminder changeDate(Reminder reminder, LocalDate date) {
        reminder.setDate(date);
        return reminder;
    }
}
