/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package sp.izvestaji;

/**
 *
 * @author dobri
 */
public class SVI_RADNICI_SUMA_SATA_ZA_PERIOD {

    private int idk;
    private int idfirma;
    private int idorgjed;
    private int idradnik;
    private int fk_idstatus;
    private String sifrastatusa;
    private float sati;

    @Override
    public String toString() {
        return idk + ", " + idfirma + ", " + idorgjed + ", " + idradnik + ", " + fk_idstatus + ", " + sifrastatusa + ", " + sati;
    }

    public SVI_RADNICI_SUMA_SATA_ZA_PERIOD() {
    }

    public SVI_RADNICI_SUMA_SATA_ZA_PERIOD(int idk, int idfirma, int idorgjed, int idradnik, int fk_idstatus, String sifrastatusa, float sati) {
        this.idk = idk;
        this.idfirma = idfirma;
        this.idorgjed = idorgjed;
        this.idradnik = idradnik;
        this.fk_idstatus = fk_idstatus;
        this.sifrastatusa = sifrastatusa;
        this.sati = sati;
    }

    public int getIdk() {
        return idk;
    }

    public void setIdk(int idk) {
        this.idk = idk;
    }

    public int getIdfirma() {
        return idfirma;
    }

    public void setIdfirma(int idfirma) {
        this.idfirma = idfirma;
    }

    public int getIdorgjed() {
        return idorgjed;
    }

    public void setIdorgjed(int idorgjed) {
        this.idorgjed = idorgjed;
    }

    public int getFk_idstatus() {
        return fk_idstatus;
    }

    public void setFk_idstatus(int fk_idstatus) {
        this.fk_idstatus = fk_idstatus;
    }

    public String getSifrastatusa() {
        return sifrastatusa;
    }

    public void setSifrastatusa(String sifrastatusa) {
        this.sifrastatusa = sifrastatusa;
    }

    public float getSati() {
        return sati;
    }

    public void setSati(float sati) {
        this.sati = sati;
    }

    public int getIdradnik() {
        return idradnik;
    }

    public void setIdradnik(int idradnik) {
        this.idradnik = idradnik;
    }
}
