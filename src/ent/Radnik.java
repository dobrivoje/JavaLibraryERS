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
@Table(name = "RADNIK")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Radnik.findAll", query = "SELECT r FROM Radnik r"),
    @NamedQuery(name = "Radnik.findByIDRadnik", query = "SELECT r FROM Radnik r WHERE r.iDRadnik = :iDRadnik"),
    //
    @NamedQuery(name = "Radnik.RadnikFunkcija",
            query = "SELECT r FROM Radnik r WHERE r.fKIDT.iDT = :IDTipRadnika"),
    @NamedQuery(name = "Radnik.RadniciKompanije",
            query = "SELECT r FROM Radnik r WHERE r.fKIDOrgjed.fKIDFirma.fkIdk.idk = :idk"),
    @NamedQuery(name = "Radnik.radniciKompanijeZaDatum",
            query = "SELECT DISTINCT rd.fKIDRadnik FROM Raddan rd WHERE rd.fKIDRadnik.fKIDOrgjed.fKIDFirma.fkIdk = :Kompanija AND rd.datum = :Datum"),
    @NamedQuery(name = "Radnik.RadniciFirmeZaDatum",
            query = "SELECT DISTINCT rd FROM Raddan rd WHERE rd.fKIDRadnik.fKIDOrgjed.fKIDFirma = :Firma AND rd.datum = :Datum"),
    @NamedQuery(name = "Radnik.RadniciOrgJedZaDatum",
            query = "SELECT DISTINCT rd.fKIDRadnik FROM Raddan rd WHERE  rd.fKIDRadnik.radnik = TRUE AND rd.fKIDRadnik.fKIDOrgjed = :Orgjed AND rd.datum = :Datum"),
    @NamedQuery(name = "Radnik.AktivniRadniciFirme",
            query = "SELECT r FROM Radnik r WHERE r.fKIDOrgjed.fKIDFirma= :Firma AND r.aktivan = TRUE AND r.radnik = TRUE"),
    @NamedQuery(name = "Radnik.AktivniRadniciFirme",
            query = "SELECT r FROM Radnik r WHERE r.fKIDOrgjed.fKIDFirma= :Firma AND r.aktivan = TRUE AND r.radnik = TRUE"),
    @NamedQuery(name = "Radnik.AktivniRadniciOrgjed",
            query = "SELECT r FROM Radnik r WHERE r.fKIDOrgjed = :Orgjed AND r.aktivan = TRUE AND r.radnik = TRUE"),
    @NamedQuery(name = "Radnik.AktivniRadniciAktivneFirme",
            query = "SELECT r FROM Radnik r WHERE r.fKIDOrgjed.fKIDFirma.aktivna = :AktivneFirme AND r.aktivan = :AktivniRadnici"),
    @NamedQuery(name = "Radnik.RadniciOrgJed",
            query = "SELECT r FROM Radnik r WHERE r.fKIDOrgjed = :ORGJED AND r.radnik = TRUE"),
    @NamedQuery(name = "Radnik.RadniciOrgJedPoIDOrgJed", query = "SELECT r FROM Radnik r WHERE r.fKIDOrgjed.iDOrgjed = :IDOrgJed"),
    @NamedQuery(name = "Radnik.AktivniRadniciOrgJedPoID", query = "SELECT r FROM Radnik r WHERE r.fKIDOrgjed.iDOrgjed = :IDOrgJed AND r.aktivan = :Aktivan"),
    @NamedQuery(name = "Radnik.AktivniRadniciOrgJed", query = "SELECT r FROM Radnik r WHERE r.fKIDOrgjed = :ORGJED AND r.aktivan = :Aktivan AND r.radnik = TRUE"),
    @NamedQuery(name = "Radnik.findByIme", query = "SELECT r FROM Radnik r WHERE r.ime = :ime"),
    @NamedQuery(name = "Radnik.findByPrezime", query = "SELECT r FROM Radnik r WHERE r.prezime = :prezime"),

    @NamedQuery(name = "Radnik.DelimicanNaziv", query = "SELECT r FROM Radnik r WHERE r.ime LIKE :Naziv OR r.prezime LIKE :Naziv"),
    @NamedQuery(name = "Radnik.AktivniDelimicanNaziv", query = "SELECT r FROM Radnik r WHERE r.aktivan=TRUE AND r.radnik=TRUE AND r.ime LIKE :Naziv OR r.prezime LIKE :Naziv"),

    @NamedQuery(name = "Radnik.PretragaRadnika", query = "SELECT r FROM Radnik r WHERE (r.aktivan=:SamoAktivni OR r.aktivan <>:SamoNeaktivni) AND (r.radnik=:SamoRadnici OR r.radnik<> :SamoOstaliNalozi) AND r.ime LIKE :Naziv OR r.prezime LIKE :Naziv"),
    @NamedQuery(name = "Radnik.SviAktivniRadnici",
            query = "SELECT r FROM Radnik r WHERE r.radnik = TRUE AND r.aktivan = TRUE AND r.ime LIKE :Naziv OR r.prezime LIKE :Naziv"),

    @NamedQuery(name = "Radnik.findByKoeficijent", query = "SELECT r FROM Radnik r WHERE r.koeficijent = :koeficijent"),
    @NamedQuery(name = "Radnik.findByOrgjed", query = "SELECT r FROM Radnik r WHERE r.orgjed = :orgjed"),
    @NamedQuery(name = "Radnik.findByAktivan", query = "SELECT r FROM Radnik r WHERE r.aktivan = :aktivan"),
    @NamedQuery(name = "Radnik.findByGrupa", query = "SELECT r FROM Radnik r WHERE r.grupa = :grupa"),
    @NamedQuery(name = "Radnik.findBySifraINFSISTEM", query = "SELECT r FROM Radnik r WHERE r.SifraINFSISTEM = :SifraINFSISTEM"),
    @NamedQuery(name = "Radnik.SifraINFSISTEM_za_ID", query = "SELECT r.SifraINFSISTEM FROM Radnik r WHERE r.iDRadnik = :ID"),
    @NamedQuery(name = "Radnik.findBySifraradnikaOLD", query = "SELECT r FROM Radnik r WHERE r.sifraradnikaOLD = :sifraradnikaOLD")})
public class Radnik implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "IDRadnik")
    private Long iDRadnik;
    @Basic(optional = false)
    @Column(name = "Ime", nullable = false)
    private String ime;
    @Basic(optional = false)
    @Column(name = "Prezime")
    private String prezime;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "Koeficijent")
    private Double koeficijent;
    @Column(name = "Orgjed")
    private String orgjed;
    @Basic(optional = false)
    @Column(name = "Radnik")
    private boolean radnik;
    @Basic(optional = false)
    @Column(name = "Aktivan")
    private boolean aktivan;
    @Column(name = "Grupa")
    private String grupa;
    @Column(name = "sifra_radnika_OLD")
    private int sifraradnikaOLD;
    @Column(name = "Sifra_INFSISTEM")
    private String SifraINFSISTEM;
    @JoinColumn(name = "FK_IDOrgjed", referencedColumnName = "IDOrgjed")
    @ManyToOne
    private Orgjed fKIDOrgjed;
    @JoinColumn(name = "FK_IDT", referencedColumnName = "IDT")
    @ManyToOne
    private TipRadnika fKIDT;
    @OneToMany(mappedBy = "fKIDRadnik")
    private List<Raddan> raddanList;

    public Radnik() {
    }

    public Radnik(Long iDRadnik) {
        this.iDRadnik = iDRadnik;
    }

    public Radnik(Long iDRadnik, boolean aktivan, int sifraradnikaOLD) {
        this.iDRadnik = iDRadnik;
        this.aktivan = aktivan;
        this.sifraradnikaOLD = sifraradnikaOLD;
    }

    public boolean isRadnik() {
        return radnik;
    }

    public void setRadnik(boolean radnik) {
        this.radnik = radnik;
    }

    public Long getIDRadnik() {
        return iDRadnik;
    }

    public void setIDRadnik(Long iDRadnik) {
        this.iDRadnik = iDRadnik;
    }

    public String getIme() {
        return ime;
    }

    public void setIme(String ime) {
        this.ime = ime;
    }

    public String getPrezime() {
        return prezime;
    }

    public void setPrezime(String prezime) {
        this.prezime = prezime;
    }

    public String getImePrezime() {
        return ime + " " + prezime;
    }

    public Double getKoeficijent() {
        return koeficijent;
    }

    public void setKoeficijent(Double koeficijent) {
        this.koeficijent = koeficijent;
    }

    public String getOrgjed() {
        return orgjed;
    }

    public void setOrgjed(String orgjed) {
        this.orgjed = orgjed;
    }

    public boolean getAktivan() {
        return aktivan;
    }

    public void setAktivan(boolean aktivan) {
        this.aktivan = aktivan;
    }

    public String getGrupa() {
        return grupa;
    }

    public void setGrupa(String grupa) {
        this.grupa = grupa;
    }

    public int getSifraradnikaOLD() {
        return sifraradnikaOLD;
    }

    public void setSifraradnikaOLD(int sifraradnikaOLD) {
        this.sifraradnikaOLD = sifraradnikaOLD;
    }

    public Orgjed getFKIDOrgjed() {
        return fKIDOrgjed;
    }

    public void setFKIDOrgjed(Orgjed fKIDOrgjed) {
        this.fKIDOrgjed = fKIDOrgjed;
    }

    public TipRadnika getFKIDVrsta() {
        return fKIDT;
    }

    public void setFKIDVrsta(TipRadnika fKIDVrsta) {
        this.fKIDT = fKIDVrsta;
    }

    public void setSifraINFSISTEM(String SifraINFSISTEM) {
        this.SifraINFSISTEM = SifraINFSISTEM;
    }

    public String getSifraINFSISTEM() {
        return this.SifraINFSISTEM;
    }

    @XmlTransient
    public List<Raddan> getRaddanList() {
        return raddanList;
    }

    public void setRaddanList(List<Raddan> raddanList) {
        this.raddanList = raddanList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (iDRadnik != null ? iDRadnik.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Radnik)) {
            return false;
        }
        Radnik other = (Radnik) object;
        return (this.iDRadnik != null || other.iDRadnik == null) && (this.iDRadnik == null || this.iDRadnik.equals(other.iDRadnik));
    }

    @Override
    public String toString() {
        return "[ID-" + iDRadnik + "] " + ime + " " + prezime + " [Aktivan] " + aktivan + " [Radnik] " + radnik;
    }

    public String toStringDescription() {
        return "Radnik[" + iDRadnik + "]"
                + ", " + ime
                + " " + prezime
                + ", Aktivan-" + aktivan
                + ", Radnik ? - " + Boolean.toString(radnik)
                + ", Org. jed-" + fKIDOrgjed.getNaziv()
                + ", Firma-" + fKIDOrgjed.getFKIDFirma().getNaziv();
    }
}
