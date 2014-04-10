/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ent;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author dobri
 */
@Entity
@Table(name = "temp_FaktSati")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "TempFaktSati.findAll", query = "SELECT t FROM TempFaktSati t"),
    @NamedQuery(name = "TempFaktSati.findByIdfs", query = "SELECT t FROM TempFaktSati t WHERE t.idfs = :idfs"),
    @NamedQuery(name = "TempFaktSati.findByFKIDRadnik", query = "SELECT t FROM TempFaktSati t WHERE t.fKIDRadnik = :fKIDRadnik"),
    @NamedQuery(name = "TempFaktSati.findByNalog", query = "SELECT t FROM TempFaktSati t WHERE t.nalog = :nalog"),
    @NamedQuery(name = "TempFaktSati.findBySati", query = "SELECT t FROM TempFaktSati t WHERE t.sati = :sati"),
    @NamedQuery(name = "TempFaktSati.findByDatum", query = "SELECT t FROM TempFaktSati t WHERE t.datum = :datum"),
    @NamedQuery(name = "TempFaktSati.findByPCentar", query = "SELECT t FROM TempFaktSati t WHERE t.pCentar = :pCentar")})
public class TempFaktSati implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(nullable = false)
    private Long idfs;
    @Basic(optional = false)
    @Column(name = "FK_IDRadnik", nullable = false)
    private long fKIDRadnik;
    @Column(length = 30)
    private String nalog;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(precision = 53, scale = 0)
    private Double sati;
    @Column(length = 12)
    private String datum;
    @Column(length = 12)
    private String pCentar;

    public TempFaktSati() {
    }

    public TempFaktSati(Long idfs) {
        this.idfs = idfs;
    }

    public TempFaktSati(Long idfs, long fKIDRadnik) {
        this.idfs = idfs;
        this.fKIDRadnik = fKIDRadnik;
    }

    public Long getIdfs() {
        return idfs;
    }

    public void setIdfs(Long idfs) {
        this.idfs = idfs;
    }

    public long getFKIDRadnik() {
        return fKIDRadnik;
    }

    public void setFKIDRadnik(long fKIDRadnik) {
        this.fKIDRadnik = fKIDRadnik;
    }

    public String getNalog() {
        return nalog;
    }

    public void setNalog(String nalog) {
        this.nalog = nalog;
    }

    public Double getSati() {
        return sati;
    }

    public void setSati(Double sati) {
        this.sati = sati;
    }

    public String getDatum() {
        return datum;
    }

    public void setDatum(String datum) {
        this.datum = datum;
    }

    public String getPCentar() {
        return pCentar;
    }

    public void setPCentar(String pCentar) {
        this.pCentar = pCentar;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idfs != null ? idfs.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TempFaktSati)) {
            return false;
        }
        TempFaktSati other = (TempFaktSati) object;
        if ((this.idfs == null && other.idfs != null) || (this.idfs != null && !this.idfs.equals(other.idfs))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "[" + datum + "] "
                + "[" + idfs.toString() + "] "
                + "[" + nalog + "] "
                + "[" + sati.toString() + "]";
    }

}
