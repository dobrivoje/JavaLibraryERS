/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package sp.izvestaji;

/**
 *
 * @author dobri
 */
public class SVI_RADNICI_UK_MESECNI_SATI_ZA_SVE_STATUSE {

    private long idradnik;
    private String ime;
    private String prezime;
    private String status;
    private String znacenje;
    private int mesec;
    private float sati;

    @Override
    public String toString() {
        return "idradnik-" + getIdradnik() + ", "
                + "ime-" + getIme() + ", "
                + "prezime-" + getPrezime() + ", "
                + "status-" + getStatus() + ", "
                + "znacenje-" + getZnacenje() + ", "
                + "mesec-" + getMesec() + ", "
                + "sati-" + getSati();
    }

    public SVI_RADNICI_UK_MESECNI_SATI_ZA_SVE_STATUSE() {
    }

    public long getIdradnik() {
        return idradnik;
    }

    public void setIdradnik(long idradnik) {
        this.idradnik = idradnik;
    }

    public String getIme() {
        return ime;
    }

    public void setIme(String ime) {
        this.ime = ime;
    }

    public String getPrezime() {
        return prezime;
    }

    public void setPrezime(String prezime) {
        this.prezime = prezime;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getZnacenje() {
        return znacenje;
    }

    public void setZnacenje(String znacenje) {
        this.znacenje = znacenje;
    }

    public int getMesec() {
        return mesec;
    }

    public void setMesec(int mesec) {
        this.mesec = mesec;
    }

    public float getSati() {
        return sati;
    }

    public void setSati(float sati) {
        this.sati = sati;
    }
}
