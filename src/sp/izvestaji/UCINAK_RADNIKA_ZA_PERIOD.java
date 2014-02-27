/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package sp.izvestaji;

/**
 *
 * @author dobri
 */
public class UCINAK_RADNIKA_ZA_PERIOD {

    private int idk;
    private String kompanija;
    private int idfirma;
    private String firma;
    private int idorgjed;
    private String orgjed;
    private long idradnik;
    private String status;
    private String znacenje;
    private float uksati;
    private float iskoriscenost;

    public UCINAK_RADNIKA_ZA_PERIOD() {
    }

    @Override
    public String toString() {
        return idk + ", " + kompanija + ", "
                + idfirma + ", " + firma + ", " + idorgjed
                + ", " + orgjed + ", " + idradnik + ", " + status
                + ", " + znacenje + ", " + uksati + ", " + iskoriscenost;
    }

    public int getIdk() {
        return idk;
    }

    public void setIdk(int idk) {
        this.idk = idk;
    }

    public String getKompanija() {
        return kompanija;
    }

    public void setKompanija(String kompanija) {
        this.kompanija = kompanija;
    }

    public int getIdfirma() {
        return idfirma;
    }

    public void setIdfirma(int idfirma) {
        this.idfirma = idfirma;
    }

    public String getFirma() {
        return firma;
    }

    public void setFirma(String firma) {
        this.firma = firma;
    }

    public int getIdorgjed() {
        return idorgjed;
    }

    public void setIdorgjed(int idorgjed) {
        this.idorgjed = idorgjed;
    }

    public String getOrgjed() {
        return orgjed;
    }

    public void setOrgjed(String orgjed) {
        this.orgjed = orgjed;
    }

    public long getIdradnik() {
        return idradnik;
    }

    public void setIdradnik(long idradnik) {
        this.idradnik = idradnik;
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

    public float getUksati() {
        return uksati;
    }

    public void setUksati(float uksati) {
        this.uksati = uksati;
    }

    public float getIskoriscenost() {
        return iskoriscenost;
    }

    public void setIskoriscenost(float iskoriscenost) {
        this.iskoriscenost = iskoriscenost;
    }
}
