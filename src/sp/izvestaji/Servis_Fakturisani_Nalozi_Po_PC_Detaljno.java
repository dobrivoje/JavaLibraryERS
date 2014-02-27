/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package sp.izvestaji;

/**
 *
 * @author dobri
 */
public class Servis_Fakturisani_Nalozi_Po_PC_Detaljno {

    private String pcentar;
    private String fakturisan;
    private float rad;
    private float rabatSati;
    private float materijal;
    private float rabatMaterijal;
    private float ukupno;

    public Servis_Fakturisani_Nalozi_Po_PC_Detaljno(String pcentar, String fakturisan, float rad, float rabatSati, float materijal, float rabatMaterijal, float ukupno) {
        this.pcentar = pcentar;
        this.fakturisan = fakturisan;
        this.rad = rad;
        this.rabatSati = rabatSati;
        this.materijal = materijal;
        this.rabatMaterijal = rabatMaterijal;
        this.ukupno = ukupno;
    }

    public String getPcentar() {
        return pcentar;
    }

    public void setPcentar(String pcentar) {
        this.pcentar = pcentar;
    }

    public String getFakturisan() {
        return fakturisan;
    }

    public void setFakturisan(String fakturisan) {
        this.fakturisan = fakturisan;
    }

    public float getRad() {
        return rad;
    }

    public void setRad(float rad) {
        this.rad = rad;
    }

    public float getRabatSati() {
        return rabatSati;
    }

    public void setRabatSati(float rabatSati) {
        this.rabatSati = rabatSati;
    }

    public float getMaterijal() {
        return materijal;
    }

    public void setMaterijal(float materijal) {
        this.materijal = materijal;
    }

    public float getRabatMaterijal() {
        return rabatMaterijal;
    }

    public void setRabatMaterijal(float rabatMaterijal) {
        this.rabatMaterijal = rabatMaterijal;
    }

    public float getUkupno() {
        return ukupno;
    }

    public void setUkupno(float ukupno) {
        this.ukupno = ukupno;
    }

    @Override
    public String toString() {
        return getPcentar() + " - "
                + getFakturisan() + ", "
                + getRad() + ", "
                + getRabatSati() + ", "
                + getMaterijal() + ", "
                + getRabatMaterijal() + ", "
                + getUkupno();
    }
}
