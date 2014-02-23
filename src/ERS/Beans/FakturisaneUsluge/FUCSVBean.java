/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ERS.Beans.FakturisaneUsluge;

import java.text.DateFormat;
import java.text.NumberFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Locale;

/**
 *
 * @author dobri
 */
public class FUCSVBean implements ICVSAble {

    private String Radnik;
    private String Sati;
    private String RadniNalog;
    private String DatumRacuna;
    private String ProfitniCentar;

    private static final String[] kolone = new String[]{"Radnik", "Sati", "RadniNalog", "DatumRacuna", "ProfitniCentar"};

    @Override
    public List<String> getColumns() {
        return new ArrayList<>(Arrays.asList(kolone));
    }

    //<editor-fold defaultstate="collapsed" desc="Konstruktori, getters/setters">
    public FUCSVBean() {
    }

    public FUCSVBean(String Radnik, String Sati, String RadniNalog, String DatumRacuna, String ProfitniCentar) {
        this.Radnik = Radnik;
        this.Sati = Sati;
        this.RadniNalog = RadniNalog;
        this.DatumRacuna = DatumRacuna;
        this.ProfitniCentar = ProfitniCentar;
    }

    public String getRadnik() {
        return Radnik;
    }

    public void setRadnik(String Radnik) {
        this.Radnik = Radnik;
    }

    public String getSati() {
        return Sati;
    }

    public double getSatiN() throws ParseException {
        NumberFormat nf = NumberFormat.getInstance(Locale.GERMANY);
        return nf.parse(Sati).doubleValue();
    }

    public void setSati(String Sati) {
        this.Sati = Sati;
    }

    public String getRadniNalog() {
        return RadniNalog;
    }

    public void setRadniNalog(String RadniNalog) {
        this.RadniNalog = RadniNalog;
    }

    public String getDatumRacuna() {
        return DatumRacuna;
    }

    public String getDatumRacunaN() throws ParseException {
        DateFormat df = DateFormat.getDateInstance(DateFormat.SHORT, Locale.GERMANY);
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        return sdf.format(df.parse(DatumRacuna));
    }

    public void setDatumRacuna(String DatumRacuna) {
        this.DatumRacuna = DatumRacuna;
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
                + "[" + DatumRacuna + "]"
                + "[" + ProfitniCentar + "]";
    }

}
