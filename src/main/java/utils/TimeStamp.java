package utils;

import org.apache.log4j.Logger;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Calendar;
import java.util.Date;

public class TimeStamp {
    private static final Logger LOG = Logger.getLogger(RandomCharacters.class);

    private String formatDate(LocalDate date, String format) {
        return date.format(DateTimeFormatter.ofPattern(format));
    }

    public String getCurrentDate() {
        return getCurrentDate("dd/MM/yyyy");
    }

    public String getCurrentDate(String formatDate) {
        String currentDate = formatDate(LocalDate.now(), formatDate);
        LOG.info("Returned Current Date: " + currentDate);
        return currentDate;
    }

    public String getPreviousDate(String format, int days) {
        String previousDate = formatDate(LocalDate.now().minusDays(days), format);
        LOG.info("Returned Previous Date: " + previousDate);
        return previousDate;
    }

    public String getFutureDate(String format, int days) {
        String futureDate = formatDate(LocalDate.now().plusDays(days), format);
        LOG.info("Returned Future Date: " + futureDate);
        return futureDate;
    }

    public String getConvertedDate(String oldFormat, String newFormat, String oldDate) throws Exception {
        DateTimeFormatter oldFormatter = DateTimeFormatter.ofPattern(oldFormat);
        DateTimeFormatter newFormatter = DateTimeFormatter.ofPattern(newFormat);
        LocalDate date = LocalDate.parse(oldDate, oldFormatter);
        String newDate = date.format(newFormatter).toUpperCase();
        LOG.info("Returned New Format Date: " + newDate);
        return newDate;
    }

    public String getFirstDateOfMonth(String format, Date date) {
        Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        cal.set(Calendar.DAY_OF_MONTH, 1);
        String firstDate = new SimpleDateFormat(format).format(cal.getTime());
        LOG.info("Returned the First Date of Month: " + firstDate);
        return firstDate;
    }

    public String getLastDateOfMonth(String format, Date date) {
        Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        cal.set(Calendar.DAY_OF_MONTH, cal.getActualMaximum(Calendar.DAY_OF_MONTH));
        String lastDate = new SimpleDateFormat(format).format(cal.getTime());
        LOG.info("Returned the Last Date of Month: " + lastDate);
        return lastDate;
    }

    public String getPreviousMonth(String format, Date date, int numOfMonth) {
        Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        cal.add(Calendar.MONTH, -numOfMonth);
        String previousDate = new SimpleDateFormat(format).format(cal.getTime());
        LOG.info("Returned Previous Month Date: " + previousDate);
        return previousDate;
    }

    public String getNextDay(String date) throws ParseException {
        DateFormat dateFormat = new SimpleDateFormat("MM/dd/yyyy");
        Date myDate = dateFormat.parse(date);
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(myDate);
        calendar.add(Calendar.DAY_OF_MONTH, 1);
        String nextDate = dateFormat.format(calendar.getTime());
        LOG.info("Returned the Next Day: " + nextDate);
        return nextDate;
    }

    public String getNextDay(String format, Date date) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        calendar.add(Calendar.DAY_OF_MONTH, 1);
        String nextDate = new SimpleDateFormat(format).format(calendar.getTime());
        LOG.info("Returned the Next Day: " + nextDate);
        return nextDate;
    }

    public String getDayOfPrevMonth(String format, Date date, int numOfMonth, int day) {
        Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        cal.add(Calendar.MONTH, -numOfMonth);
        cal.set(Calendar.DAY_OF_MONTH, day);
        String prevDate = new SimpleDateFormat(format).format(cal.getTime());
        LOG.info("Returned the Date: " + prevDate);
        return prevDate;
    }
}
