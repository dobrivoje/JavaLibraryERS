/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ent;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
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
@Table(name = "KOMPANIJA")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Kompanija.findAll", query = "SELECT k FROM Kompanija k"),
    @NamedQuery(name = "Kompanija.findByIdk", query = "SELECT k FROM Kompanija k WHERE k.idk = :idk"),
    @NamedQuery(name = "Kompanija.findByNazivKompanije", query = "SELECT k FROM Kompanija k WHERE k.nazivKompanije = :nazivKompanije"),
    @NamedQuery(name = "Kompanija.findByVlasnik", query = "SELECT k FROM Kompanija k WHERE k.vlasnik = :vlasnik"),
    @NamedQuery(name = "Kompanija.findByGrad", query = "SELECT k FROM Kompanija k WHERE k.grad = :grad"),
    @NamedQuery(name = "Kompanija.findByAdresa", query = "SELECT k FROM Kompanija k WHERE k.adresa = :adresa")})
public class Kompanija implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "IDK")
    private Integer idk;
    @Basic(optional = false)
    @Column(name = "NazivKompanije")
    private String nazivKompanije;
    @Column(name = "Vlasnik")
    private String vlasnik;
    @Column(name = "Grad")
    private String grad;
    @Column(name = "Adresa")
    private String adresa;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "fkIdk")
    private List<Firma> firmaList;

    public Kompanija() {
    }

    public Kompanija(Integer idk) {
        this.idk = idk;
    }

    public Integer getIdk() {
        return idk;
    }

    public void setIdk(Integer idk) {
        this.idk = idk;
    }

    public String getNazivKompanije() {
        return nazivKompanije;
    }

    public void setNazivKompanije(String nazivKompanije) {
        this.nazivKompanije = nazivKompanije;
    }

    public String getVlasnik() {
        return vlasnik;
    }

    public void setVlasnik(String vlasnik) {
        this.vlasnik = vlasnik;
    }

    public String getGrad() {
        return grad;
    }

    public void setGrad(String grad) {
        this.grad = grad;
    }

    public String getAdresa() {
        return adresa;
    }

    public void setAdresa(String adresa) {
        this.adresa = adresa;
    }

    @XmlTransient
    public List<Firma> getFirmaList() {
        return firmaList;
    }

    public void setFirmaList(List<Firma> firmaList) {
        this.firmaList = firmaList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idk != null ? idk.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Kompanija)) {
            return false;
        }
        Kompanija other = (Kompanija) object;
        if ((this.idk == null && other.idk != null) || (this.idk != null && !this.idk.equals(other.idk))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "[ID-" + idk + "] " + nazivKompanije;
    }
}
