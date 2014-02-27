/*
 * To change this template, choose Tools | Templates
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
@Table(name = "TIP_RADNIKA")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "TipRadnika.sviTipoviRadnika", query = "SELECT t FROM TipRadnika t"),
    @NamedQuery(name = "TipRadnika.findByIDTip", query = "SELECT t FROM TipRadnika t WHERE t.iDT = :IDTip"),
    @NamedQuery(name = "TipRadnika.findByNaziv", query = "SELECT t FROM TipRadnika t WHERE t.naziv = :Naziv")})
public class TipRadnika implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "IDT")
    private Integer iDT;
    @Basic(optional = false)
    @Column(name = "NazivFunkcije")
    private String naziv;

    public TipRadnika() {
    }

    public TipRadnika(Integer iDT) {
        this.iDT = iDT;
    }

    public Integer getIDT() {
        return iDT;
    }

    public void setIDT(Integer iDT) {
        this.iDT = iDT;
    }

    public String getNaziv() {
        return naziv;
    }

    public void setNaziv(String naziv) {
        this.naziv = naziv;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (iDT != null ? iDT.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TipRadnika)) {
            return false;
        }
        TipRadnika other = (TipRadnika) object;
        if ((this.iDT == null && other.iDT != null) || (this.iDT != null && !this.iDT.equals(other.iDT))) {
            return false;
        }
        return true;
    }

    @Override
    public synchronized String toString() {
        return "[ID-" + getIDT() + "] " + getNaziv();
    }
}
