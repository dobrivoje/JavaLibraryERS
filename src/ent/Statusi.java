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
@Table(name = "STATUSI")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Statusi.findAll", query = "SELECT s FROM Statusi s"),
    @NamedQuery(name = "Statusi.findByIDStatus", query = "SELECT s FROM Statusi s WHERE s.iDStatus = :iDStatus"),
    @NamedQuery(name = "Statusi.findByStatus", query = "SELECT s FROM Statusi s WHERE s.status = :status"),
    @NamedQuery(name = "Statusi.findByZnacenje", query = "SELECT s FROM Statusi s WHERE s.znacenje = :znacenje"),
    @NamedQuery(name = "Statusi.findByBoja", query = "SELECT s FROM Statusi s WHERE s.boja = :boja"),
    @NamedQuery(name = "Statusi.findByOznaka", query = "SELECT s FROM Statusi s WHERE s.oznaka = :oznaka"),
    @NamedQuery(name = "Statusi.findByNapomena", query = "SELECT s FROM Statusi s WHERE s.napomena = :napomena"),
    @NamedQuery(name = "Statusi.findByUnosNaloga", query = "SELECT s FROM Statusi s WHERE s.unosNaloga = :unosNaloga")})
public class Statusi implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "IDStatus")
    private Integer iDStatus;
    @Column(name = "Status")
    private String status;
    @Column(name = "Znacenje")
    private String znacenje;
    @Column(name = "boja")
    private String boja;
    @Column(name = "Red")
    private Short red;
    @Column(name = "Green")
    private Short green;
    @Column(name = "Blue")
    private Short blue;
    @Column(name = "oznaka")
    private Integer oznaka;
    @Column(name = "Napomena")
    private String napomena;
    @Column(name = "unos_naloga")
    private Boolean unosNaloga;
    @Column(name = "Produktivno")
    private Boolean produktivno;
    @Column(name = "Prisustvo")
    private Boolean prisustvo;
    @OneToMany(mappedBy = "fKIDStatus")
    private List<Raddan> raddanList;

    public Statusi() {
    }

    public Statusi(Integer iDStatus) {
        this.iDStatus = iDStatus;
    }

    public Integer getIDStatus() {
        return iDStatus;
    }

    public void setIDStatus(Integer iDStatus) {
        this.iDStatus = iDStatus;
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

    public String getBoja() {
        return boja;
    }

    public void setBoja(String boja) {
        this.boja = boja;
    }

    public Short getRed() {
        return red;
    }

    public void setRed(Short red) {
        this.red = red;
    }

    public Short getGreen() {
        return green;
    }

    public void setG(Short green) {
        this.green = green;
    }

    public Short getBlue() {
        return blue;
    }

    public void setB(Short blue) {
        this.blue = blue;
    }

    public Integer getOznaka() {
        return oznaka;
    }

    public void setOznaka(Integer oznaka) {
        this.oznaka = oznaka;
    }

    public String getNapomena() {
        return napomena;
    }

    public void setNapomena(String napomena) {
        this.napomena = napomena;
    }

    public Boolean getUnosNaloga() {
        return unosNaloga;
    }

    public void setUnosNaloga(Boolean unosNaloga) {
        this.unosNaloga = unosNaloga;
    }

    @XmlTransient
    public List<Raddan> getRaddanList() {
        return raddanList;
    }

    public void setRaddanList(List<Raddan> raddanList) {
        this.raddanList = raddanList;
    }

    public Boolean getProduktivno() {
        return produktivno;
    }

    public void setProduktivno(Boolean produktivno) {
        this.produktivno = produktivno;
    }

    public Boolean getPrisustvo() {
        return prisustvo;
    }

    public void setPrisustvo(Boolean prisustvo) {
        this.prisustvo = prisustvo;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (iDStatus != null ? iDStatus.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Statusi)) {
            return false;
        }
        Statusi other = (Statusi) object;
        return (this.iDStatus != null || other.iDStatus == null) && (this.iDStatus == null || this.iDStatus.equals(other.iDStatus));
    }

    @Override
    public String toString() {
        return "[ID-" + getIDStatus() + "] " + getStatus() + " - " + getZnacenje();
    }
}
