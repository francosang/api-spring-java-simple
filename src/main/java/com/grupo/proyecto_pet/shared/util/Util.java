package com.grupo.proyecto_pet.shared.util;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class Util {

    private static final Logger logger = LoggerFactory.getLogger(Util.class);

    public static final DateFormat TIME = new SimpleDateFormat("HH:mm");
    public static final DateFormat DATE = new SimpleDateFormat("dd:MM:yyyy");
    public static final DateFormat DATE_TIME = new SimpleDateFormat("dd:MM:yyyy HH:mm");

    public static Date formatTime(String time) {
        try {
            Calendar calendar = Calendar.getInstance();
            calendar.setTime(TIME.parse(time));
            calendar.set(Calendar.YEAR, 0);
            calendar.set(Calendar.MONTH, 0);
            calendar.set(Calendar.DAY_OF_MONTH, 0);
            return calendar.getTime();
        } catch (ParseException e) {
            return null;
        }
    }

    public static String formatTime(Date desde) {
        if (desde == null) {
            return null;
        }
        return TIME.format(desde);
    }

    public static Date formatDate(String date) {
        try {
            Calendar calendar = Calendar.getInstance();
            calendar.setTime(DATE.parse(date));
            calendar.set(Calendar.HOUR_OF_DAY, 0);
            calendar.set(Calendar.MINUTE, 0);
            calendar.set(Calendar.SECOND, 0);
            calendar.set(Calendar.MILLISECOND, 0);
            return calendar.getTime();
        } catch (ParseException e) {
            logger.error(e.getMessage(), e);
            return null;
        }
    }

    public static String formatDate(Date date) {
        if (date == null) {
            return null;
        }
        return DATE.format(date);
    }

    public static Date formatDateTime(String dateTime) {
        try {
            Calendar calendar = Calendar.getInstance();
            calendar.setTime(DATE_TIME.parse(dateTime));
            return calendar.getTime();
        } catch (ParseException e) {
            logger.error(e.getMessage(), e);
            return null;
        }
    }

    public static String formatDateTime(Date dateTime) {
        if (dateTime == null) {
            return null;
        }
        return DATE_TIME.format(dateTime);
    }

    public static boolean equalsTime(Date one, Date other) {
        return formatTime(one).equals(formatTime(other));
    }

    public static boolean equalsDate(Date one, Date other) {
        return formatDate(one).equals(formatDate(other));
    }

    public static boolean equalsDateTime(Date one, Date other) {
        return formatDateTime(one).equals(formatDateTime(other));
    }
}
