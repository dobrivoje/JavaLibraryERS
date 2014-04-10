/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ent;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
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
@Table(name = "FaktSati")
@XmlRootElement
@NamedQueries({
    // JavaFX - Upiti !!!
    // Querz ispod me je zezao 7 dana, zato što sam umesto 'datum'
    // stavio 'Datum' !!!!
    @NamedQuery(name = "FaktSati.UKDnevnaFakturisanost",
            query = "SELECT NEW ERS.BusinessBeans.DnevnoSATI_UK("
            + "FUNCTION('YEAR',f.datum), FUNCTION('MONTH',f.datum), FUNCTION('DAY',f.datum), SUM(f.sati) "
            + ") "
            + "FROM FaktSati f "
            + "WHERE FUNCTION('YEAR',f.datum) = :Godina AND FUNCTION('MONTH',f.datum) = :Mesec "
            // + "AND FUNCTION('DAY', f.datum) = :Dan   "
            + "GROUP BY FUNCTION('YEAR',f.datum), FUNCTION('MONTH',f.datum), FUNCTION('DAY',f.datum)"
            // + " GROUP BY FUNCTION('YEAR',f.datum), FUNCTION('MONTH',f.datum)"
    ),

    @NamedQuery(name = "FaktSati.UKSati",
            query = "SELECT SUM(f.sati) FROM FaktSati f "
            + "WHERE FUNCTION('YEAR', f.datum) = :Godina "
            + "AND FUNCTION('MONTH', f.datum) = :Mesec "
            + "GROUP BY FUNCTION('MONTH', f.datum)"
    ),

    @NamedQuery(name = "FaktSati.findByNalog", query = "SELECT f FROM FaktSati f WHERE f.nalog = :nalog"),
    @NamedQuery(name = "FaktSati.findByDatum", query = "SELECT f FROM FaktSati f WHERE f.datum = :datum"),
    @NamedQuery(name = "FaktSati.zaRadnikaZaDatum", query = "SELECT f FROM FaktSati f WHERE f.fKIDRadnik = :Radnik AND f.datum = :Datum"),
    @NamedQuery(name = "FaktSati.findByFKIDRadnik", query = "SELECT f FROM FaktSati f WHERE f.fKIDRadnik = :fKIDRadnik")})
public class FaktSati implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "IDFS")
    private Long idfs;
    @Column(name = "Nalog")
    private String nalog;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "Sati")
    private Double sati;
    @Column(name = "Datum")
    private String datum;
    @JoinColumn(name = "FK_IDRadnik", referencedColumnName = "IDRadnik")
    @ManyToOne
    private Radnik fKIDRadnik;

    public FaktSati() {
    }

    public FaktSati(Long idfs) {
        this.idfs = idfs;
    }

    public Long getIdfs() {
        return idfs;
    }

    public void setIdfs(Long idfs) {
        this.idfs = idfs;
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

    public Radnik getfKIDRadnik() {
        return fKIDRadnik;
    }

    public void setfKIDRadnik(Radnik fKIDRadnik) {
        this.fKIDRadnik = fKIDRadnik;
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
        if (!(object instanceof FaktSati)) {
            return false;
        }
        FaktSati other = (FaktSati) object;
        if ((this.idfs == null && other.idfs != null) || (this.idfs != null && !this.idfs.equals(other.idfs))) {
            return false;
        }
        return true;
    }

    @Override
    public synchronized String toString() {
        return this.fKIDRadnik.getIDRadnik() + ", "
                + this.getDatum() + ", "
                + this.getNalog() + ", "
                + this.getSati();
    }
}
