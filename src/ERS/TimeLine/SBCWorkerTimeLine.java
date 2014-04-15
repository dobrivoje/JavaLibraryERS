/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ERS.TimeLine;

import ERS.queries.ERSQuery;
import ent.Radnik;
import ent.Statusi;
import java.text.DecimalFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.concurrent.TimeUnit;

/**
 * SBCWorkerTimeLine - Stacked Bar Category TimeLine
 *
 */
public class SBCWorkerTimeLine {

    // Definicije vremena koje se prati na vremenskoj liniji !
    public static final String MIN_SYSTEM_TIME = ERSQuery.getActiveTimeScheme().getSystemTimeMin();
    public static final String MAX_SYSTEM_TIME = ERSQuery.getActiveTimeScheme().getSystemTimeMax();

    // Definicija markera za kraj
    public static final Statusi NON_WORKING_PERIOD = ERSQuery.NE_NADGLEDANA_AKTIVNOST;

    private final Radnik radnik;
    private final Statusi status;
    private String nalog;
    private final String datum;
    private final String vremePocetka;
    private final String vremeKraja;
    private final Float trajanje;

    private final int satPocetak;
    private final int satKraj;
    private final float minutPocetak;
    private final float minutKraj;

    private Number vremePocetakDecimal;
    private Number vremeKrajDecimal;

    private static final Calendar c = Calendar.getInstance();
    private static final DecimalFormat df1 = new DecimalFormat("#.##");

    //<editor-fold defaultstate="collapsed" desc="konstruktor">
    /**
     *
     * @param radnik
     * @param status
     * @param nalog
     * @param datum npr. "2014-04-21"
     * @param vremePocetka npr. "10:15:00"
     * @param vremeKraja npr. "10:22:21"
     * @param trajanje (prema gornjim podacima) 7 !
     */
    public SBCWorkerTimeLine(Radnik radnik, Statusi status, String nalog, String datum, String vremePocetka, String vremeKraja, Float trajanje) {
        this.radnik = radnik;
        this.status = status;
        this.nalog = nalog;
        this.datum = datum;
        this.vremePocetka = vremePocetka;
        this.vremeKraja = vremeKraja;
        this.trajanje = trajanje;

        c.setTime(toDate(vremePocetka));
        satPocetak = c.get(Calendar.HOUR_OF_DAY);
        minutPocetak = c.get(Calendar.MINUTE);

        c.setTime(toDate(vremeKraja));
        satKraj = c.get(Calendar.HOUR_OF_DAY);
        minutKraj = c.get(Calendar.MINUTE);

        vremePocetakDecimal = satPocetak + minutPocetak / 60;
        vremeKrajDecimal = satKraj + minutKraj / 60;

        try {
            vremePocetakDecimal = df1.parse(df1.format(vremePocetakDecimal));
            vremeKrajDecimal = df1.parse(df1.format(vremeKrajDecimal));
        } catch (ParseException ex) {
        }
    }
    //</editor-fold>

    //<editor-fold defaultstate="collapsed" desc="getters">
    public Radnik getRadnik() {
        return radnik;
    }

    public Statusi getStatus() {
        return status;
    }

    public Float getTrajanje() {
        return trajanje;
    }

    public int getSatPocetak() {
        return satPocetak;
    }

    public int getSatKraj() {
        return satKraj;
    }

    public float getMinutPocetak() {
        return minutPocetak;
    }

    public float getMinutKraj() {
        return minutKraj;
    }

    public Number getVremePocetakDecimal() {
        return vremePocetakDecimal;
    }

    public Number getVremeKrajDecimal() {
        return vremeKrajDecimal;
    }
    //</editor-fold>

    //<editor-fold defaultstate="collapsed" desc="setters">
    public void setNalog(String nalog) {
        this.nalog = nalog;
    }
        //</editor-fold>

    //<editor-fold defaultstate="collapsed" desc="toDate">
    /**
     * Funkcija vraća Date od String-a Ukoliko dođe do izuzetka, vraća se
     * MAX_SYSTEM_TIME
     *
     * @param time npr. "10:15:32"
     * @return
     */
    public static Date toDate(String time) {
        try {
            return (new SimpleDateFormat("HH:mm:ss")).parse(time);
        } catch (ParseException | NullPointerException ex) {
            return new Date(toDate(MAX_SYSTEM_TIME).getTime());
        }
    }

    public static synchronized long timeDifferenceInMinutes(String startTime, String endTime) {
        long L = TimeUnit.MILLISECONDS.toMinutes(toDate(endTime).getTime() - toDate(startTime).getTime());;
        if (L < 0) {
            // throw new Exception("Time difference must not be negative !");
        } else {
            // return L;
        }

        return L;
    }
    //</editor-fold>

    //<editor-fold defaultstate="collapsed" desc="toString">
    @Override
    public String toString() {
        return "[" + datum + "] "
                + "[" + radnik.getImePrezime() + "] "
                + "[" + status.getStatus() + "] "
                + "[" + status.getColorhex() + "] "
                + (status.getUnosNaloga() ? "[" + this.nalog + "] " : "")
                + "[" + this.vremePocetka + "] "
                + "[" + this.vremeKraja + "] "
                + "[" + this.getTrajanje() + "] "
                + "  >>>> [" + this.vremePocetakDecimal + "] <-> [" + this.vremeKrajDecimal + "]";
    }
    //</editor-fold>
}
