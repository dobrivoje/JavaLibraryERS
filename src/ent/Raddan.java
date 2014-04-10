/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ent;

import java.io.Serializable;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author dobri
 */
@Entity
@Table(name = "RADDAN")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Raddan.findAll", query = "SELECT r FROM Raddan r"),
    @NamedQuery(name = "Raddan.EvidencijaRadnikaZaDatum", query = "SELECT r FROM Raddan r WHERE r.fKIDRadnik = :Radnik AND r.datum = :Datum ORDER BY r.datum ASC, r.rbrstanja ASC"),
    @NamedQuery(name = "Raddan.EvidencijaSvihRadnikaOrgJedZaDatum", query = "SELECT r FROM Raddan r WHERE r.fKIDRadnik.fKIDOrgjed = :Orgjed AND  r.datum = :Datum ORDER BY r.datum ASC, r.rbrstanja ASC"),
    @NamedQuery(name = "Raddan.EvidencijaSvihRadnikaFirmeZaDatum", query = "SELECT r FROM Raddan r WHERE r.fKIDRadnik.fKIDOrgjed.fKIDFirma = :Firma AND r.datum = :Datum ORDER BY r.fKIDRadnik.iDRadnik ASC, r.rbrstanja ASC"),
    @NamedQuery(name = "Raddan.IDRadnikOpsegDatuma", query = "SELECT r FROM Raddan r WHERE r.fKIDRadnik.iDRadnik = :IDRadnik AND r.datum BETWEEN :DatumOd AND :DatumDo ORDER BY r.datum ASC, r.rbrstanja ASC"),
    @NamedQuery(name = "Raddan.FirmeZaDatum", query = "SELECT DISTINCT r.fKIDRadnik.fKIDOrgjed.fKIDFirma FROM Raddan r WHERE r.datum = :Datum"),
    @NamedQuery(name = "Raddan.OrgjedZaDatum", query = "SELECT DISTINCT r.fKIDRadnik.orgjed FROM Raddan r WHERE r.datum = :Datum"),
    @NamedQuery(name = "Raddan.RadniciZaDatum", query = "SELECT DISTINCT r.fKIDRadnik FROM Raddan r WHERE r.datum = :Datum"),
    //
    @NamedQuery(name = "Raddan.findByDatum", query = "SELECT r FROM Raddan r WHERE r.datum = :datum"),
    @NamedQuery(name = "Raddan.findByMesec", query = "SELECT r FROM Raddan r WHERE r.mesec = :mesec"),
    @NamedQuery(name = "Raddan.findByGodina", query = "SELECT r FROM Raddan r WHERE r.godina = :godina"),
    @NamedQuery(name = "Raddan.findByNalog", query = "SELECT r FROM Raddan r WHERE r.nalog = :nalog")})
public class Raddan implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "IDRaddan")
    private Long iDRaddan;
    @Column(name = "rbrstanja")
    private Integer rbrstanja;
    @Column(name = "datum")
    private String datum;
    @Column(name = "dan_u_mes")
    private Short danUMes;
    @Column(name = "mesec")
    private Short mesec;
    @Column(name = "godina")
    private Short godina;
    @Column(name = "nalog")
    private String nalog;
    @Column(name = "poc_stanja")
    private String pocStanja;
    @Column(name = "kraj_stanja")
    private String krajStanja;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "trajanje")
    private Float trajanje;
    @Column(name = "norma_trajanja")
    private Integer normaTrajanja;
    @Column(name = "poslovnica")
    private String poslovnica;
    @JoinColumn(name = "FK_IDStatus", referencedColumnName = "IDStatus")
    @ManyToOne
    private Statusi fKIDStatus;
    @JoinColumn(name = "FK_IDRadnik", referencedColumnName = "IDRadnik")
    @ManyToOne
    private Radnik fKIDRadnik;

    public Raddan() {
    }

    public Raddan(Long iDRaddan) {
        this.iDRaddan = iDRaddan;
    }

    public Long getIDRaddan() {
        return iDRaddan;
    }

    public void setIDRaddan(Long iDRaddan) {
        this.iDRaddan = iDRaddan;
    }

    public Integer getRbrstanja() {
        return rbrstanja;
    }

    public void setRbrstanja(Integer rbrstanja) {
        this.rbrstanja = rbrstanja;
    }

    public String getDatum() {
        return datum;
    }

    public void setDatum(String datum) {
        this.datum = datum;
    }

    public Short getDanUMes() {
        return danUMes;
    }

    public void setDanUMes(Short danUMes) {
        this.danUMes = danUMes;
    }

    public Short getMesec() {
        return mesec;
    }

    public void setMesec(Short mesec) {
        this.mesec = mesec;
    }

    public Short getGodina() {
        return godina;
    }

    public void setGodina(Short godina) {
        this.godina = godina;
    }

    public String getNalog() {
        return nalog;
    }

    public void setNalog(String nalog) {
        this.nalog = nalog;
    }

    public String getPocStanja() {
        return pocStanja;
    }

    public void setPocStanja(String pocStanja) {
        this.pocStanja = pocStanja;
    }

    public String getKrajStanja() {
        return krajStanja;
    }

    public void setKrajStanja(String krajStanja) {
        this.krajStanja = krajStanja;
    }

    public Float getTrajanje() {
        return trajanje;
    }

    public void setTrajanje(Float trajanje) {
        this.trajanje = trajanje;
    }

    public Integer getNormaTrajanja() {
        return normaTrajanja;
    }

    public void setNormaTrajanja(Integer normaTrajanja) {
        this.normaTrajanja = normaTrajanja;
    }

    public String getPoslovnica() {
        return poslovnica;
    }

    public void setPoslovnica(String poslovnica) {
        this.poslovnica = poslovnica;
    }

    public Statusi getFKIDStatus() {
        return fKIDStatus;
    }

    //<editor-fold defaultstate="collapsed" desc="Dodato za čitanje u OutLineView objektu.">
    public String getStatus() {
        return fKIDStatus.getStatus();
    }

    public String getStatusZnacenje() {
        return fKIDStatus.getZnacenje();
    }
    //</editor-fold>

    //<editor-fold defaultstate="collapsed" desc="Dodato za čitanje u OutLineView objektu.">
    public Long getIDRadnik() {
        return fKIDRadnik.getIDRadnik();
    }

    public String getImeRadnika() {
        return fKIDRadnik.getIme();
    }

    public String getPrezimeRadnika() {
        return fKIDRadnik.getPrezime();
    }
    //</editor-fold>

    public void setFKIDStatus(Statusi fKIDStatus) {
        this.fKIDStatus = fKIDStatus;
    }

    public Radnik getFKIDRadnik() {
        return fKIDRadnik;
    }

    public void setFKIDRadnik(Radnik fKIDRadnik) {
        this.fKIDRadnik = fKIDRadnik;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (iDRaddan != null ? iDRaddan.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Raddan)) {
            return false;
        }
        Raddan other = (Raddan) object;
        if ((this.iDRaddan == null && other.iDRaddan != null) || (this.iDRaddan != null && !this.iDRaddan.equals(other.iDRaddan))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "[" + fKIDRadnik.getIme() + " " + fKIDRadnik.getPrezime() + " ] "
                + "[" + datum + " ] "
                + "[" + pocStanja + " - " + krajStanja + " ] "
                + "[" + trajanje + " ] "
                + "[" + fKIDStatus.getStatus() + "-" + fKIDStatus.getZnacenje() + " ] ";

    }

    public Long getStartTimeInSec() {
        if (this.getTrajanje() != null) {
            try {
                return new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").parse(getDatum() + " " + getPocStanja()).getTime();
            } catch (ParseException ex) {
                return null;
            }
        } else {
            return null;
        }

    }

    public Long getEndTimeInSec() {
        if (this.getTrajanje() != null) {
            try {
                return new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").parse(getDatum() + " " + getKrajStanja()).getTime();
            } catch (ParseException ex) {
                return null;
            }
        } else {
            return null;
        }
    }
}
