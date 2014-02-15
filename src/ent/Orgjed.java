/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ent;

import java.io.Serializable;
import java.util.List;
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
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author dobri
 */
@Entity
@Table(name = "ORGJED")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Orgjed.findAll", query = "SELECT o FROM Orgjed o"),
    @NamedQuery(name = "Orgjed.findByIDOrgjed", query = "SELECT o FROM Orgjed o WHERE o.iDOrgjed = :IDOrgJed"),
    @NamedQuery(name = "Orgjed.orgJedFirme", query = "SELECT o FROM Orgjed o WHERE o.fKIDFirma = :Firma"),
    @NamedQuery(name = "Orgjed.orgJedFirmeZaDatum",
            query = "SELECT DISTINCT rd.fKIDRadnik.fKIDOrgjed FROM Raddan rd WHERE rd.fKIDRadnik.fKIDOrgjed.fKIDFirma = :Firma AND rd.datum = :Datum"),
    @NamedQuery(name = "Orgjed.orgJedFirmeID", query = "SELECT o FROM Orgjed o WHERE o.fKIDFirma.iDFirma = :FirmaID"),
    @NamedQuery(name = "Orgjed.findBySifra", query = "SELECT o FROM Orgjed o WHERE o.sifra = :sifra"),
    @NamedQuery(name = "Orgjed.findByNaziv", query = "SELECT o FROM Orgjed o WHERE o.naziv = :naziv")})
public class Orgjed implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "IDOrgjed")
    private Integer iDOrgjed;
    @Basic(optional = false)
    @Column(name = "Sifra")
    private String sifra;
    @Basic(optional = false)
    @Column(name = "Naziv")
    private String naziv;
    @Basic(optional = false)
    @Column(name = "Mehanika")
    private boolean mehanika;
    @JoinColumn(name = "FK_IDFirma", referencedColumnName = "IDFirma")
    @ManyToOne
    private Firma fKIDFirma;
    @OneToMany(mappedBy = "fKIDOrgjed")
    private List<Radnik> radnikList;

    public Orgjed() {
    }

    public Orgjed(Integer iDOrgjed) {
        this.iDOrgjed = iDOrgjed;
    }

    public Integer getIDOrgjed() {
        return iDOrgjed;
    }

    public void setIDOrgjed(Integer iDOrgjed) {
        this.iDOrgjed = iDOrgjed;
    }

    public String getSifra() {
        return sifra;
    }

    public void setSifra(String sifra) {
        this.sifra = sifra;
    }

    public String getNaziv() {
        return naziv;
    }

    public void setNaziv(String naziv) {
        this.naziv = naziv;
    }

    public Firma getFKIDFirma() {
        return fKIDFirma;
    }

    public void setFKIDFirma(Firma fKIDFirma) {
        this.fKIDFirma = fKIDFirma;
    }

    @XmlTransient
    public List<Radnik> getRadnikList() {
        return radnikList;
    }

    public void setRadnikList(List<Radnik> radnikList) {
        this.radnikList = radnikList;
    }

    public boolean isMehanika() {
        return mehanika;
    }

    public void setMehanika(boolean mehanika) {
        this.mehanika = mehanika;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (iDOrgjed != null ? iDOrgjed.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Orgjed)) {
            return false;
        }
        Orgjed other = (Orgjed) object;
        if ((this.iDOrgjed == null && other.iDOrgjed != null) || (this.iDOrgjed != null && !this.iDOrgjed.equals(other.iDOrgjed))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "[ID-" + iDOrgjed + "] " + naziv;
    }
}
