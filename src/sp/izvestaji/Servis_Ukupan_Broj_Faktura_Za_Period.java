/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package sp.izvestaji;

/**
 *
 * @author dobri
 */
public class Servis_Ukupan_Broj_Faktura_Za_Period {

    private int UkBrojFaktura;
    private String Datum;

    public Servis_Ukupan_Broj_Faktura_Za_Period() {
    }

    public Servis_Ukupan_Broj_Faktura_Za_Period(int UkBrojFaktura, String Datum) {
        this.UkBrojFaktura = UkBrojFaktura;
        this.Datum = Datum;
    }

    public int getUkBrojFaktura() {
        return UkBrojFaktura;
    }

    public void setUkBrojFaktura(int UkBrojFaktura) {
        this.UkBrojFaktura = UkBrojFaktura;
    }

    public String getDatum() {
        return Datum;
    }

    public void setDatum(String Datum) {
        this.Datum = Datum;
    }

    @Override
    public String toString() {
        return getDatum() + " - " + getUkBrojFaktura();
    }
}
