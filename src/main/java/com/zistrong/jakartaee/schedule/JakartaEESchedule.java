package com.zistrong.jakartaee.schedule;

import jakarta.ejb.Schedule;
import jakarta.ejb.Singleton;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.text.DateFormat;
import java.util.Date;
import java.util.Locale;

@Singleton
public class JakartaEESchedule {
    private static final Logger LOGGER = LoggerFactory.getLogger(JakartaEESchedule.class);

    @Schedule(second = "30", minute = "*", hour = "*", persistent = false)
    public void scheduleRun() {
        LOGGER.info("now = {}", DateFormat.getDateInstance(2, Locale.getDefault()).format(new Date()));
    }
}
