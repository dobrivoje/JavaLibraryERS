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
@Table(name = "FIRMA")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Firma.findAll", query = "SELECT f FROM Firma f"),
    @NamedQuery(name = "Firma.findByIDFirma", query = "SELECT f FROM Firma f WHERE f.iDFirma = :iDFirma"),
    @NamedQuery(name = "Firma.findByNaziv", query = "SELECT f FROM Firma f WHERE f.naziv = :naziv"),
    @NamedQuery(name = "Firma.FirmeKompanije", query = "SELECT f FROM Firma f WHERE f.fkIdk = :Kompanija"),
    @NamedQuery(name = "Firma.AktivneFirme", query = "SELECT f FROM Firma f WHERE f.aktivna = :Aktivna"),
    @NamedQuery(name = "Firma.FirmeKompanijeID", query = "SELECT f FROM Firma f WHERE f.fkIdk.idk = :KompanijaID"),
    @NamedQuery(name = "Firma.findByGrad", query = "SELECT f FROM Firma f WHERE f.grad = :grad"),
    @NamedQuery(name = "Firma.findByAdresa", query = "SELECT f FROM Firma f WHERE f.adresa = :adresa"),
    @NamedQuery(name = "Firma.findByPostanskiBroj", query = "SELECT f FROM Firma f WHERE f.postanskiBroj = :postanskiBroj"),
    @NamedQuery(name = "Firma.findByPib", query = "SELECT f FROM Firma f WHERE f.pib = :pib"),
    @NamedQuery(name = "Firma.Podrazumevana", query = "SELECT f FROM Firma f WHERE f.podrazumevana = TRUE"),
    @NamedQuery(name = "Firma.findByMatbr", query = "SELECT f FROM Firma f WHERE f.matbr = :matbr")})
public class Firma implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "IDFirma")
    private Integer iDFirma;
    @Basic(optional = false)
    @Column(name = "Naziv")
    private String naziv;
    @Basic(optional = false)
    @Column(name = "Grad")
    private String grad;
    @Column(name = "Kod")
    private String kod;
    @Column(name = "Adresa")
    private String adresa;
    @Column(name = "PostanskiBroj")
    private String postanskiBroj;
    @Column(name = "PIB")
    private String pib;
    @Column(name = "MATBR")
    private String matbr;

    @OneToMany(mappedBy = "fKIDFirma")
    private List<Orgjed> orgjedList;
    @JoinColumn(name = "FK_IDK", referencedColumnName = "IDK")
    @ManyToOne(optional = false)
    private Kompanija fkIdk;

    @Basic(optional = false)
    @Column(name = "Aktivna")
    private boolean aktivna;

    @Basic(optional = false)
    @Column(name = "Podrazumevana")
    private boolean podrazumevana;

    public Firma() {
    }

    public Firma(Integer iDFirma) {
        this.iDFirma = iDFirma;
    }

    public Firma(Integer iDFirma, String adresa) {
        this.iDFirma = iDFirma;
        this.adresa = adresa;
    }

    public Integer getIDFirma() {
        return iDFirma;
    }

    public void setIDFirma(Integer iDFirma) {
        this.iDFirma = iDFirma;
    }

    public String getNaziv() {
        return naziv;
    }

    public void setNaziv(String naziv) {
        this.naziv = naziv;
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

    public String getPostanskiBroj() {
        return postanskiBroj;
    }

    public void setPostanskiBroj(String postanskiBroj) {
        this.postanskiBroj = postanskiBroj;
    }

    public String getPib() {
        return pib;
    }

    public void setPib(String pib) {
        this.pib = pib;
    }

    public String getMatbr() {
        return matbr;
    }

    public void setMatbr(String matbr) {
        this.matbr = matbr;
    }

    @XmlTransient
    public List<Orgjed> getOrgjedList() {
        return orgjedList;
    }

    public void setOrgjedList(List<Orgjed> orgjedList) {
        this.orgjedList = orgjedList;
    }

    public Kompanija getFkIdk() {
        return fkIdk;
    }

    public void setFkIdk(Kompanija fkIdk) {
        this.fkIdk = fkIdk;
    }

    public String getKod() {
        return kod;
    }

    public void setKod(String kod) {
        this.kod = kod;
    }

    public boolean isAktivna() {
        return aktivna;
    }

    public void setAktivna(boolean aktivna) {
        this.aktivna = aktivna;
    }

    public boolean isPodrazumevana() {
        return aktivna;
    }

    public void setPodrazumevana(boolean podrazumevana) {
        this.podrazumevana = podrazumevana;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (iDFirma != null ? iDFirma.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Firma)) {
            return false;
        }
        Firma other = (Firma) object;
        if ((this.iDFirma == null && other.iDFirma != null) || (this.iDFirma != null && !this.iDFirma.equals(other.iDFirma))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "[ID-" + iDFirma + "] " + naziv;
    }

    public String toStringDescription() {
        return "[ID-" + iDFirma + "], "
                + "Naziv - " + naziv + ", "
                + "Kod - " + kod + ", "
                + "Grad - " + grad + ", "
                + "Adresa - " + adresa + ", "
                + "Poštanski broj - " + postanskiBroj + ", "
                + "PIB - " + pib + ", "
                + "Matični Broj - " + matbr + ", "
                + "Aktivna (prikaz svih org. jedinica firme ?) - " + aktivna
                + "Podrazumevana za prikaz ? - " + podrazumevana;
    }
}
