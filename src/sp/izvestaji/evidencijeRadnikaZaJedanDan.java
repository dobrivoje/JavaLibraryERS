/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package sp.izvestaji;

/**
 *
 * @author dobri
 */
public class evidencijeRadnikaZaJedanDan {

    private long fk_idradnik;
    private int rbrstanja;
    private String datum;
    private String znacenje;
    private String status;
    private String nalog;
    private String poc_stanja;
    private String kraj_stanja;
    private float trajanje;

    public evidencijeRadnikaZaJedanDan() {
    }

    @Override
    public String toString() {
        return "[ID] " + getFk_idradnik() + ", "
                + "[rbr.] " + getRbrstanja() + ", "
                + "[datum] " + getDatum() + ", "
                + getZnacenje() + ", "
                + getStatus() + ", "
                + (getNalog().length() > 1 ? "[nalog] " + getNalog() : "") + ", "
                + "[početak] " + getPoc_stanja() + ", "
                + "[kraj] " + getKraj_stanja() + ", "
                + "[trajanje] " + getTrajanje();
    }

    public long getFk_idradnik() {
        return fk_idradnik;
    }

    public void setFk_idradnik(long fk_idradnik) {
        this.fk_idradnik = fk_idradnik;
    }

    public int getRbrstanja() {
        return rbrstanja;
    }

    public void setRbrstanja(int rbrstanja) {
        this.rbrstanja = rbrstanja;
    }

    public String getDatum() {
        return datum;
    }

    public void setDatum(String datum) {
        this.datum = datum;
    }

    public String getZnacenje() {
        return znacenje;
    }

    public void setZnacenje(String znacenje) {
        this.znacenje = znacenje;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getNalog() {
        return nalog;
    }

    public void setNalog(String nalog) {
        this.nalog = nalog;
    }

    public String getPoc_stanja() {
        return poc_stanja;
    }

    public void setPoc_stanja(String poc_stanja) {
        this.poc_stanja = poc_stanja;
    }

    public String getKraj_stanja() {
        return kraj_stanja;
    }

    public void setKraj_stanja(String kraj_stanja) {
        this.kraj_stanja = kraj_stanja;
    }

    public float getTrajanje() {
        return trajanje;
    }

    public void setTrajanje(float trajanje) {
        this.trajanje = trajanje;
    }
}
