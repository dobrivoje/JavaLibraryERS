/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ERS.Beans.FakturisaneUsluge;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

/**
 *
 * @author dobri
 */
public class FUExcelBean {

    private String Radnik;
    private double Sati;
    private String RadniNalog;
    private Date DatumRacuna;
    private String ProfitniCentar;

    private static final String[] kolone = new String[]{"Radnik", "Sati", "RadniNalog", "DatumRacuna", "ProfitniCentar"};

    public static List<String> getColumns() {
        return new ArrayList<>(Arrays.asList(kolone));
    }

    public String[] getStrColumns() {
        return kolone;
    }

    //<editor-fold defaultstate="collapsed" desc="Konstruktori, getters/setters">
    public FUExcelBean() {
    }

    public FUExcelBean(String Radnik, double Sati, String RadniNalog, Date DatumRacuna, String ProfitniCentar) {
        this.Radnik = Radnik;
        this.Sati = Sati;
        this.RadniNalog = RadniNalog;
        this.DatumRacuna = DatumRacuna;
        this.ProfitniCentar = ProfitniCentar;
    }

    public FUExcelBean(String Radnik, double Sati, String RadniNalog, String DatumRacuna, String ProfitniCentar) throws ParseException {
        this.Radnik = Radnik;
        this.Sati = Sati;
        this.RadniNalog = RadniNalog;
        this.DatumRacuna = new SimpleDateFormat("yyyy-MM-dd").parse(DatumRacuna);
        this.ProfitniCentar = ProfitniCentar;
    }

    public String getRadnik() {
        return Radnik;
    }

    public void setRadnik(String Radnik) {
        this.Radnik = Radnik;
    }

    public double getSati() {
        return Sati;
    }

    public void setSati(double Sati) {
        this.Sati = Sati;
    }

    public String getRadniNalog() {
        return RadniNalog;
    }

    public void setRadniNalog(String RadniNalog) {
        this.RadniNalog = RadniNalog;
    }

    public Date getDatumRacuna() {
        return DatumRacuna;
    }

    public void setDatumRacuna(Date DatumRacuna) {
        this.DatumRacuna = DatumRacuna;
    }

    public void setDatumRacuna(String DatumRacuna) throws ParseException {
        this.DatumRacuna = new SimpleDateFormat("yyyy-MM-dd").parse(DatumRacuna);
    }

    public String getProfitniCentar() {
        return ProfitniCentar;
    }

    public void setProfitniCentar(String ProfitniCentar) {
        this.ProfitniCentar = ProfitniCentar;
    }
    //</editor-fold>

    @Override
    public String toString() {
        return "[" + Radnik + "]"
                + "[" + Sati + "]"
                + "[" + RadniNalog + "]"
                + "[" + new SimpleDateFormat("d.M.yyyy").format(DatumRacuna) + "]"
                + "[" + ProfitniCentar + "]";
    }
}
