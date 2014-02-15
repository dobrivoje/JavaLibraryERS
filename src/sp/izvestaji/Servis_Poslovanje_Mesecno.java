/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package sp.izvestaji;

import java.text.DecimalFormat;

/**
 *
 * @author dobri
 */
public class Servis_Poslovanje_Mesecno {

    private String pcentar;
    private int mesec;
    private int godina;
    private double ukupno;
    //
    private static DecimalFormat df = new DecimalFormat("#,###.00");

    public String getPcentar() {
        return pcentar;
    }

    public void setPcentar(String pcentar) {
        this.pcentar = pcentar;
    }

    public int getMesec() {
        return mesec;
    }

    public void setMesec(int mesec) {
        this.mesec = mesec;
    }

    public int getGodina() {
        return godina;
    }

    public void setGodina(int godina) {
        this.godina = godina;
    }

    public synchronized double getUkupno() {
        return ukupno;
    }

    public synchronized void setUkupno(double ukupno) {
        this.ukupno = ukupno;
    }

    public Servis_Poslovanje_Mesecno(String pcentar, int mesec, int godina, double ukupno) {
        this.pcentar = pcentar;
        this.mesec = mesec;
        this.godina = godina;
        this.ukupno = ukupno;
    }

    @Override
    public synchronized String toString() {
        return getPcentar() + " - "
                + getGodina() + "."
                + getMesec() + " -> "
                + df.format(getUkupno());
    }
}
