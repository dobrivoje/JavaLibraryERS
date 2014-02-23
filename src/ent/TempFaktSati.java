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
 * @author root
 */
@Entity
@Table(name = "temp_FaktSati2")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "TempFaktSati.findAll", query = "SELECT t FROM TempFaktSati t"),
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
    @Column(name = "FK_IDRadnik")
    private Long fKIDRadnik;
    private String nalog;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    private Double sati;
    private String datum;
    private String pCentar;

    public TempFaktSati() {
    }

    public TempFaktSati(Long fKIDRadnik) {
        this.fKIDRadnik = fKIDRadnik;
    }

    public Long getFKIDRadnik() {
        return fKIDRadnik;
    }

    public void setFKIDRadnik(Long fKIDRadnik) {
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
        hash += (fKIDRadnik != null ? fKIDRadnik.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TempFaktSati)) {
            return false;
        }
        TempFaktSati other = (TempFaktSati) object;
        if ((this.fKIDRadnik == null && other.fKIDRadnik != null) || (this.fKIDRadnik != null && !this.fKIDRadnik.equals(other.fKIDRadnik))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "ent.TempFaktSati[ fKIDRadnik=" + fKIDRadnik + " ]";
    }
    
}
