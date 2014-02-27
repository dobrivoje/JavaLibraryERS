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
public class Servis_Fakturisani_Nalozi_Po_PC {

    private String pcentar;
    private double ukupno;
    private static DecimalFormat df = new DecimalFormat("#,###.00");

    public Servis_Fakturisani_Nalozi_Po_PC() {
    }

    public Servis_Fakturisani_Nalozi_Po_PC(String pcentar, double ukupno) {
        this.pcentar = pcentar;
        this.ukupno = ukupno;
    }

    public String getPcentar() {
        return pcentar;
    }

    public void setPcentar(String pcentar) {
        this.pcentar = pcentar;
    }

    public synchronized double getUkupno() {
        return ukupno;
    }

    public synchronized void setUkupno(double ukupno) {
        this.ukupno = ukupno;
    }

    @Override
    public synchronized String toString() {
        return "Profitni centar : " + getPcentar()
                + ", ukupno : " + df.format(getUkupno());
    }
}
