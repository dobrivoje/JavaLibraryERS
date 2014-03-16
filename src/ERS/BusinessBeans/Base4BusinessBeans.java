/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ERS.BusinessBeans;

import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.Calendar;

/**
 *
 * @author root
 */
public class Base4BusinessBeans {

    protected int year;
    protected int month;
    protected int day;

    protected static final Calendar c = Calendar.getInstance();
    protected static int lastDayOfMonth;
    protected final NumberFormat decimalFormat = new DecimalFormat("#,##0.00");

    public static int getLastDayOfMonth(int year, int month) {
        c.set(year, month - 1, 1);
        lastDayOfMonth = c.getActualMaximum(Calendar.DAY_OF_MONTH);

        return lastDayOfMonth;
    }

    //<editor-fold defaultstate="collapsed" desc="kontruktor, getters/setters">
    public Base4BusinessBeans(int year, int month, int day) {
        this.year = year;
        this.month = month;
        this.day = day;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public int getMonth() {
        return month;
    }

    public void setMonth(int month) {
        this.month = month;
    }

    public int getDay() {
        return day;
    }

    public void setDay(int day) {
        this.day = day;
    }

    public static int getLastDayOfMonth() {
        return lastDayOfMonth;
    }

    public static void setLastDayOfMonth(int lastDayOfMonth) {
        Base4BusinessBeans.lastDayOfMonth = lastDayOfMonth;
    }
    //</editor-fold>
}
