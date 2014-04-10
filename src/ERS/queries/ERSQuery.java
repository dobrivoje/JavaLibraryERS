/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ERS.queries;

import ERS.Beans.FakturisaneUsluge.FUCSVBean;
import ERS.Beans.FakturisaneUsluge.FUExcelBean;
import ERS.BusinessBeans.DnevnoSATI_UK;
import ent.FaktSati;
import ent.Firma;
import ent.Kompanija;
import ent.Orgjed;
import ent.Raddan;
import ent.Radnik;
import ent.Statusi;
import ent.TempFaktSati;
import ent.TipRadnika;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.util.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.SQLTimeoutException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.RollbackException;
import sp.izvestaji.SVI_RADNICI_SUMA_SATA_ZA_PERIOD;
import sp.izvestaji.SVI_RADNICI_UK_MESECNI_SATI_ZA_SVE_STATUSE;
import sp.izvestaji.Servis_Fakturisani_Nalozi_Po_PC;
import sp.izvestaji.Servis_Fakturisani_Nalozi_Po_PC_Detaljno;
import sp.izvestaji.Servis_Poslovanje_Mesecno;
import sp.izvestaji.Servis_Ukupan_Broj_Faktura_Za_Period;
import sp.izvestaji.UCINAK_RADNIKA_ZA_PERIOD;
import sp.izvestaji.evidencijeRadnikaZaJedanDan;

/**
 *
 * @author dobri
 */
public class ERSQuery {

    private static final EntityManagerFactory emf = Persistence.createEntityManagerFactory("JavaLibraryEntitiesPU");
    private static final EntityManager em = emf.createEntityManager();

    /**
     *
     * EntityManager - getEm() : pošto vraća exception, može se iskoristiti za
     * kontrolisanje postojanja konekcije sa Persistent blokom !
     *
     * @return
     * @throws java.lang.Exception
     * @throws java.net.UnknownHostException
     * @throws java.sql.SQLException
     */
    public static synchronized EntityManager getEm()
            throws NullPointerException, Exception,
            java.net.UnknownHostException, java.sql.SQLException {

        return em;
    }

    //<editor-fold defaultstate="collapsed" desc="KOMPANIJA">
    public static synchronized List<Kompanija> listaSvihKompanija() {
        try {
            return getEm().createNamedQuery("Kompanija.findAll").getResultList();
        } catch (Exception ex) {
            return null;
        }
    }

    public static synchronized Kompanija kompanijaPoID(int ID) {
        try {
            return (Kompanija) getEm().createNamedQuery("Kompanija.findByIdk")
                    .setParameter("idk", ID)
                    .getSingleResult();
        } catch (Exception ex) {
            return null;
        }
    }

    /*    public static synchronized List<Kompanija> kompanijaNaziv(String Naziv) {
     * return getEm().createNamedQuery("Kompanija.findByNazivKompanije")
     * .setParameter("nazivKompanije", Naziv + "%")
     * .getResultList();
     * }*/
    public static synchronized void novaKompanija(String Naziv, String Vlasnik, String Adresa) {
        Kompanija novaKompanija = new Kompanija();

        novaKompanija.setNazivKompanije(Naziv);
        novaKompanija.setVlasnik(Vlasnik);
        novaKompanija.setAdresa(Adresa);

        try {
            getEm().persist(novaKompanija);
        } catch (Exception e) {
        }
    }

    public static synchronized void updateKompanija(Kompanija Kompanija, String Naziv, String Grad, String Adresa, String Vlasnik)
            throws RollbackException, Exception {

        Kompanija.setNazivKompanije(Naziv);
        Kompanija.setGrad(Grad);
        Kompanija.setAdresa(Adresa);
        Kompanija.setVlasnik(Vlasnik);

        getEm().getTransaction().begin();
        getEm().merge(Kompanija);
        getEm().getTransaction().commit();
    }
    //</editor-fold>

    //<editor-fold defaultstate="collapsed" desc="FIRMA">
    public static synchronized List<Firma> listaSvihFirmi() {
        try {
            return getEm().createNamedQuery("Firma.findAll").getResultList();
        } catch (Exception ex) {
            return null;
        }
    }

    public static synchronized List<Firma> firmeKompanije(Kompanija k) {
        try {
            return getEm().createNamedQuery("Firma.FirmeKompanije")
                    .setParameter("Kompanija", k)
                    .getResultList();
        } catch (Exception ex) {
            return null;
        }
    }

    public static synchronized List<Firma> firmeKompanijeIDK(int IDK) {
        try {
            return getEm().createNamedQuery("Firma.FirmeKompanijeID")
                    .setParameter("KompanijaID", IDK)
                    .getResultList();
        } catch (Exception ex) {
            return null;
        }
    }

    public static synchronized Firma FirmaID(int ID) {
        try {
            return (Firma) getEm().createNamedQuery("Firma.findByIDFirma")
                    .setParameter("iDFirma", ID)
                    .getSingleResult();
        } catch (Exception ex) {
            return null;
        }
    }

    // Ukoliko SQL server nije dostupan, treba izbaciti izuetak, da bi se podigla apliakcija !
    public static synchronized List<Firma> AktivneFirme(boolean Aktivna) {
        try {
            return getEm().createNamedQuery("Firma.AktivneFirme")
                    .setParameter("Aktivna", Aktivna)
                    .getResultList();
        } catch (Exception ex) {
            return null;
        }
    }

    public static synchronized List<Firma> FirmaPoNazivu(String Naziv) {
        try {
            return getEm().createNamedQuery("Firma.findByNaziv")
                    .setParameter("naziv", Naziv + "%")
                    .getResultList();
        } catch (Exception ex) {
            return null;
        }
    }

    public static synchronized void novaFirma(Kompanija kompanija, String Naziv, String Grad, String Adresa, String PostanskiBroj, String PIB, String MB, boolean aktivna)
            throws RollbackException, Exception {

        Firma novaFirma = new Firma();

        novaFirma.setFkIdk(kompanija);
        novaFirma.setNaziv(Naziv);
        novaFirma.setGrad(Grad);
        novaFirma.setAdresa(Adresa);
        novaFirma.setPostanskiBroj(PostanskiBroj);
        novaFirma.setPib(PIB);
        novaFirma.setMatbr(MB);
        novaFirma.setAktivna(aktivna);

        getEm().getTransaction().begin();
        getEm().persist(novaFirma);
        getEm().getTransaction().commit();
    }

    public static synchronized void updateFirma(Kompanija kompanija, Firma firma, String Naziv, String Grad, String Adresa, String PostanskiBroj, String PIB, String MB, boolean aktivna)
            throws RollbackException, Exception {

        firma.setFkIdk(kompanija);
        firma.setNaziv(Naziv);
        firma.setGrad(Grad);
        firma.setAdresa(Adresa);
        firma.setPostanskiBroj(PostanskiBroj);
        firma.setPib(PIB);
        firma.setMatbr(MB);
        firma.setAktivna(aktivna);

        getEm().getTransaction().begin();
        getEm().merge(firma);
        getEm().getTransaction().commit();
    }
    //</editor-fold>

    //<editor-fold defaultstate="collapsed" desc="ORG. JED.">
    public static synchronized List<Orgjed> listaSvihORGJED() {
        try {
            return getEm().createNamedQuery("Orgjed.findAll").getResultList();
        } catch (Exception ex) {
            return null;
        }
    }

    public static synchronized List<Orgjed> orgJedFirme(Firma Firma) {
        try {
            return getEm().createNamedQuery("Orgjed.orgJedFirme")
                    .setParameter("Firma", Firma)
                    .getResultList();
        } catch (Exception ex) {
            return null;
        }
    }

    public static synchronized List<Orgjed> orgJedFirmePoIDFirme(int FirmaID) {
        try {
            return getEm().createNamedQuery("Orgjed.orgJedFirmeID")
                    .setParameter("FirmaID", FirmaID)
                    .getResultList();
        } catch (Exception ex) {
            return null;
        }
    }

    // ne znam ni što sam ovo uopšte pravio ?!
    // onemogućeno 4.8.2013.
    public static synchronized List<Orgjed> orgJedFirmeZaDatum(Firma firma, String datum) {
        try {
            return getEm().createNamedQuery("Orgjed.orgJedFirmeZaDatum")
                    .setParameter("Firma", firma)
                    .setParameter("Datum", datum)
                    .getResultList();
        } catch (Exception ex) {
            return null;
        }
    }

    public static synchronized Orgjed ORGJED_ID(int IDOrgjed) {
        try {
            return (Orgjed) getEm().createNamedQuery("Orgjed.findByIDOrgjed")
                    .setParameter("IDOrgJed", IDOrgjed)
                    .getSingleResult();
        } catch (Exception ex) {
            return null;
        }
    }

    public static synchronized void novaOrgJed(Firma firma, String Naziv, String Sifra, boolean mehanika)
            throws RollbackException, Exception {

        Orgjed novaOrgJed = new Orgjed();

        novaOrgJed.setFKIDFirma(firma);
        novaOrgJed.setSifra(Sifra);
        novaOrgJed.setNaziv(Naziv);
        novaOrgJed.setMehanika(mehanika);

        getEm().getTransaction().begin();
        getEm().persist(novaOrgJed);
        getEm().getTransaction().commit();
    }

    public static synchronized void updateOrgJed(Orgjed orgjed, Firma firma, String Naziv, String Sifra, boolean mehanika)
            throws RollbackException, Exception {

        orgjed.setFKIDFirma(firma);
        orgjed.setSifra(Sifra);
        orgjed.setNaziv(Naziv);
        orgjed.setMehanika(mehanika);

        getEm().getTransaction().begin();
        getEm().merge(orgjed);
        getEm().getTransaction().commit();
    }
    //</editor-fold>

    //<editor-fold defaultstate="collapsed" desc="RADNIK">
    public static synchronized Radnik radnikID(long ID) {
        try {
            return (Radnik) getEm().createNamedQuery("Radnik.findByIDRadnik")
                    .setParameter("iDRadnik", ID)
                    .getSingleResult();
        } catch (Exception ex) {
            return null;
        }
    }

    public static synchronized Radnik radnikSifraINFSISTEM(String SifraINFSISTEM) {
        try {
            return (Radnik) getEm().createNamedQuery("Radnik.findBySifraINFSISTEM")
                    .setParameter("SifraINFSISTEM", SifraINFSISTEM)
                    .getSingleResult();
        } catch (Exception ex) {
            return null;
        }
    }

    public static synchronized String radnikSifraINFSISTEM(long ID) {
        try {
            return (String) getEm().createNamedQuery("Radnik.SifraINFSISTEM_za_ID")
                    .setParameter("ID", ID)
                    .getSingleResult();
        } catch (Exception ex) {
            return null;
        }
    }

    public static synchronized List<Radnik> radnikPoImenuIliPrezimenu(String ImeIliPrezime) {
        try {
            return getEm().createNamedQuery("Radnik.findByImeIliPrezime")
                    .setParameter("imeIliPrezime", ImeIliPrezime + "%")
                    .getResultList();
        } catch (Exception ex) {
            return null;
        }
    }

    public static synchronized List<Radnik> radniciKompanije(int idk) {
        try {
            return getEm().createNamedQuery("Radnik.RadniciKompanije")
                    .setParameter("idk", idk)
                    .getResultList();
        } catch (Exception ex) {
            return null;
        }
    }

    public static synchronized List<Radnik> radniciFirme(int iDFirma) {
        try {
            return getEm().createNamedQuery("Radnik.RadniciFirme")
                    .setParameter("iDFirma", iDFirma)
                    .getResultList();
        } catch (Exception ex) {
            return null;
        }
    }

    public static synchronized List<Radnik> aktivniRadniciOrgJed(Orgjed orgjed) {
        try {
            return getEm().createNamedQuery("Radnik.AktivniRadniciOrgjed")
                    .setParameter("Orgjed", orgjed)
                    .getResultList();
        } catch (Exception ex) {
            return null;
        }
    }

    public static synchronized List<Radnik> aktivniRadniciFirme(Firma firma) {
        try {
            return getEm().createNamedQuery("Radnik.AktivniRadniciFirme")
                    .setParameter("Firma", firma)
                    .getResultList();
        } catch (Exception ex) {
            return null;
        }
    }

    public static synchronized List<Radnik> radniciOrgJed(Orgjed orgjed) {
        try {
            return getEm().createNamedQuery("Radnik.RadniciOrgJed")
                    .setParameter("ORGJED", orgjed)
                    .getResultList();
        } catch (Exception ex) {
            return null;
        }
    }

    public static synchronized List<Radnik> radniciOrgJedPoIDOrgJed(int IDOrgJed) {
        try {
            return getEm().createNamedQuery("Radnik.RadniciOrgJedPoIDOrgJed")
                    .setParameter("IDOrgJed", IDOrgJed)
                    .getResultList();
        } catch (Exception ex) {
            return null;
        }
    }

    public static synchronized List<Radnik> aktivniRadniciOrgJedPoID(int IDOrgJed, boolean Aktivan) {
        try {
            return getEm().createNamedQuery("Radnik.AktivniRadniciOrgJedPoID")
                    .setParameter("IDOrgJed", IDOrgJed)
                    .setParameter("Aktivan", Aktivan)
                    .getResultList();
        } catch (Exception ex) {
            return null;
        }
    }

    public static synchronized List<Radnik> aktivniRadniciOrgJed(Orgjed OrgJed, boolean Aktivan) {
        try {
            return getEm().createNamedQuery("Radnik.AktivniRadniciOrgJed")
                    .setParameter("ORGJED", OrgJed)
                    .setParameter("Aktivan", Aktivan)
                    .getResultList();
        } catch (Exception ex) {
            return null;
        }
    }

    public static synchronized List<Radnik> radniciZaDatum(String datum) {
        try {
            return getEm().createNamedQuery("Raddan.RadniciZaDatum")
                    .setParameter("Datum", datum)
                    .getResultList();
        } catch (Exception ex) {
            return null;
        }
    }

    public static synchronized List<Radnik> radniciKompanijeZaDatum(Kompanija kompanija, String datum) {
        try {
            return getEm().createNamedQuery("Radnik.radniciKompanijeZaDatum")
                    .setParameter("Kompanija", kompanija)
                    .setParameter("Datum", datum)
                    .getResultList();
        } catch (Exception ex) {
            return null;
        }
    }

    public static synchronized List<Radnik> radniciFirmeZaDatum(Firma firma, String datum) {
        try {
            return getEm().createNamedQuery("Radnik.RadniciFirmeZaDatum")
                    .setParameter("Firma", firma)
                    .setParameter("Datum", datum)
                    .getResultList();
        } catch (Exception ex) {
            return null;
        }
    }

    public static synchronized List<Radnik> radniciOrgJedZaDatum(Orgjed orgjed, String datum) {
        try {
            return getEm().createNamedQuery("Radnik.RadniciOrgJedZaDatum")
                    .setParameter("Orgjed", orgjed)
                    .setParameter("Datum", datum)
                    .getResultList();
        } catch (Exception ex) {
            return null;
        }
    }

    public static synchronized List<Radnik> sviRadnici() {
        try {
            return getEm().createNamedQuery("Radnik.findAll")
                    .getResultList();
        } catch (Exception ex) {
            return null;
        }
    }

    public static synchronized List<Radnik> PretragaSvihRadnikaDelimicanNaziv(String Naziv) {
        try {
            return getEm().createNamedQuery("Radnik.DelimicanNaziv")
                    .setParameter("Naziv", "%" + Naziv + "%")
                    .getResultList();
        } catch (Exception ex) {
            return null;
        }
    }

    public static synchronized List<Radnik> PretragaRadnika(
            String radnik, boolean samoRadnici, boolean ostaliOstaliNalozi, boolean samoAktivni, boolean samoNeaktivni) {
        try {
            return getEm().createNamedQuery("Radnik.PretragaRadnika")
                    .setParameter("Naziv", "%" + radnik + "%")
                    .setParameter("SamoAktivni", samoAktivni)
                    .setParameter("Neaktivni", samoNeaktivni)
                    .setParameter("SamoRadnici", samoRadnici)
                    .setParameter("SamoOstaliNalozi", ostaliOstaliNalozi)
                    .getResultList();
        } catch (Exception ex) {
            return null;
        }
    }

    public static synchronized List<Radnik> SviAktivniRadniciFirme(String radnik) {
        try {
            return getEm().createNamedQuery("Radnik.SviAktivniRadnici")
                    .setParameter("Naziv", "%" + radnik + "%")
                    .getResultList();
        } catch (Exception ex) {
            return null;
        }
    }

    public static synchronized List<Radnik> AktivneFirmeAktivniRadnici(boolean AktivneFirme, boolean AktivniRadnici) {
        try {
            return getEm().createNamedQuery("Radnik.AktivniRadniciAktivneFirme")
                    .setParameter("AktivneFirme", AktivneFirme)
                    .setParameter("AktivniRadnici", AktivniRadnici)
                    .getResultList();
        } catch (Exception ex) {
            return null;
        }
    }

    public static synchronized void noviRadnik(Orgjed orgjed, TipRadnika tipRadnika, String Ime, String Prezime, double Koeficijent, boolean aktivan, String grupa, String sifra_infsistem)
            throws RollbackException, Exception {

        Radnik noviRadnik = new Radnik();

        noviRadnik.setFKIDOrgjed(orgjed);
        noviRadnik.setFKIDVrsta(tipRadnika);
        noviRadnik.setIme(Ime);
        noviRadnik.setPrezime(Prezime);
        noviRadnik.setKoeficijent(Koeficijent);
        noviRadnik.setOrgjed(null);
        noviRadnik.setAktivan(aktivan);
        noviRadnik.setGrupa(grupa);
        noviRadnik.setSifraradnikaOLD(-1);
        noviRadnik.setSifraINFSISTEM(sifra_infsistem);

        getEm().getTransaction().begin();
        getEm().persist(noviRadnik);
        getEm().getTransaction().commit();
    }

    public static synchronized void updateRadnik(Radnik radnik, Orgjed orgjed, TipRadnika tipRadnika, String Ime, String Prezime, double Koeficijent, boolean aktivan, String grupa, String sifra_infsistem)
            throws RollbackException, Exception {

        radnik.setFKIDOrgjed(orgjed);
        radnik.setFKIDVrsta(tipRadnika);
        radnik.setIme(Ime);
        radnik.setPrezime(Prezime);
        radnik.setKoeficijent(Koeficijent);
        radnik.setOrgjed(null);
        radnik.setAktivan(aktivan);
        radnik.setGrupa(grupa);
        radnik.setSifraradnikaOLD(-1);
        radnik.setSifraINFSISTEM(sifra_infsistem);

        getEm().getTransaction().begin();
        getEm().persist(radnik);
        getEm().getTransaction().commit();
    }

    public static synchronized void evidentirajAktivnostRadnika(Radnik radnik, String Datum, Statusi status, String Nalog) {
        try {
            if (!getEm().getTransaction().isActive()) {
                getEm().getTransaction().begin();
            }
            getEm().createNativeQuery("EXEC UPIS_RADNIK_STATUS_NALOG @IDRadnika=?1, @Datum=?2, @IDStatus=?3, @Nalog=?4")
                    .setParameter(1, radnik.getIDRadnik())
                    .setParameter(2, Datum)
                    .setParameter(3, status.getIDStatus())
                    .setParameter(4, Nalog)
                    .executeUpdate();
            getEm().getTransaction().commit();
        } catch (Exception e) {
            try {
                getEm().getTransaction().rollback();
            } catch (Exception ex) {
            }
        } finally {
            try {
                getEm().flush();
                getEm().close();
            } catch (Exception ex) {
            }
        }
    }

    public static synchronized void evidentirajAktivnostRadnika3(Radnik radnik, Date Datum, Statusi status, String Nalog) {
        try {
            if (!em.getTransaction().isActive()) {
                em.getTransaction().begin();
            }
            em.createNativeQuery("EXEC UPIS_RADNIK_STATUS_NALOG @IDRadnika=?1, @Datum=?2, @IDStatus=?3, @Nalog=?4")
                    .setParameter(1, radnik.getIDRadnik())
                    .setParameter(2, Datum)
                    .setParameter(3, status.getIDStatus())
                    .setParameter(4, Nalog)
                    .executeUpdate();
            em.getTransaction().commit();
        } catch (Exception e) {
            em.getTransaction().rollback();
        } finally {
            try {
                getEm().flush();
                getEm().close();
            } catch (Exception ex) {
            }
        }
    }

    public static synchronized void evidentirajAktivnostRadnika4(Radnik radnik, Statusi status, String Nalog) throws Exception {
        try {
            if (!getEm().getTransaction().isActive()) {
                getEm().getTransaction().begin();
            }

            Connection c = getEm().unwrap(java.sql.Connection.class);
            CallableStatement cs = c.prepareCall("{call [dbo].[UPIS_RADNIK_STATUS_NALOG](?1,?2,?3,?4)}");
            cs.setQueryTimeout(1);

            cs.setLong(1, radnik.getIDRadnik());
            cs.setDate(2, null);
            cs.setInt(3, status.getIDStatus());
            cs.setString(4, Nalog);

            cs.execute();

            em.getTransaction().commit();
        } catch (SQLTimeoutException e1) {
            em.getTransaction().rollback();
        } catch (Exception ex) {
            em.getTransaction().rollback();
        } finally {
            try {
                getEm().flush();
                getEm().close();
            } catch (Exception ex) {
            }
        }
    }

    public static synchronized void evidentirajAktivnostRadnika2(long IDRadnika, String Datum, int IDStatus, String Nalog) {
        // moramo definisati evidenciju kroz ERSQuery zato što SP na SQL Serveru
        // iako radi odlično, posle upisa ne ažurira Krajnje vreme i Trajanje kolone
        // i njihove vrednosti prikazuje kao NULL.
        //
        // dok se to ne sredi, ne bi bilo loše definisati na ovom mestu
        // metod za upis u bazu.
        try {
            if (!em.getTransaction().isActive()) {
                em.getTransaction().begin();
            }

            em.getTransaction().commit();
        } catch (Exception e) {
            if (em.getTransaction().isActive()) {
                em.getTransaction().rollback();
            }
        }
    }

    ///////////////////////////
    ///// Vrsta Radnika ///////
    ///////////////////////////
    public static synchronized List<TipRadnika> sviTipoviRadnika() {
        try {
            return getEm().createNamedQuery("TipRadnika.sviTipoviRadnika").getResultList();
        } catch (Exception ex) {
            return null;
        }
    }

    public static synchronized TipRadnika tipRadnika(int IDTipRadnika) {
        try {
            return (TipRadnika) getEm().createNamedQuery("TipRadnika.findByIDTip")
                    .setParameter("IDTip", IDTipRadnika)
                    .getSingleResult();
        } catch (Exception ex) {
            return null;
        }
    }

    public static synchronized void noviTipRadnika(String Naziv) {
        TipRadnika tr = new TipRadnika();
        tr.setNaziv(Naziv);

        try {
            getEm().persist(tr);
        } catch (Exception e) {
        }
    }

    ///////////////////////////////////////////
    ///// Fakturisani Sati          !!! ///////
    ///////////////////////////////////////////
    public static synchronized List<FaktSati> evidencijeFaktSataRadnikaZaDatum(Radnik radnik, String Datum) {
        try {
            return getEm().createNamedQuery("FaktSati.zaRadnikaZaDatum")
                    .setParameter("Radnik", radnik)
                    .setParameter("Datum", Datum)
                    .getResultList();
        } catch (Exception ex) {
            return null;
        }
    }
//</editor-fold>

    //<editor-fold defaultstate="collapsed" desc="RADDAN">
    public static synchronized List<Raddan> evidencijeRadnikaZaDatum(Radnik radnik, String Datum) {
        try {
            return getEm().createNamedQuery("Raddan.EvidencijaRadnikaZaDatum")
                    .setParameter("Radnik", radnik)
                    .setParameter("Datum", Datum)
                    .getResultList();
        } catch (Exception ex) {
            return null;
        }
    }

    public static synchronized List<Raddan> evidencijeRadnikaZaDatum6(Radnik radnik, String datum) {
        try {
            return getEm().createNamedQuery("Raddan.EvidencijaRadnikaZaDatum")
                    .setParameter("Radnik", radnik)
                    .setParameter("Datum", datum)
                    .getResultList();
        } catch (Exception ex) {
            return null;
        }
    }

    public static synchronized List<Raddan> evidencijeRadnikaZaOpsegDatuma(Radnik radnik, String DatumOd, String DatumDo) {
        try {
            return getEm().createNamedQuery("Raddan.IDRadnikOpsegDatuma")
                    .setParameter("IDRadnik", radnik.getIDRadnik())
                    .setParameter("DatumOd", DatumOd)
                    .setParameter("DatumDo", DatumDo)
                    .getResultList();
        } catch (Exception ex) {
            return null;
        }
    }

    public static synchronized List<Raddan> evidencijaSvihRadnikaOrgJedZaDatum(Orgjed orgjed, String Datum) {
        try {
            return getEm().createNamedQuery("Raddan.EvidencijaSvihRadnikaOrgJedZaDatum")
                    .setParameter("Orgjed", orgjed)
                    .setParameter("Datum", Datum)
                    .getResultList();
        } catch (Exception ex) {
            return null;
        }
    }

    public static synchronized List<Raddan> evidencijaSvihRadnikaFirmeZaDatum(Firma firma, String Datum) {
        try {
            return getEm().createNamedQuery("Raddan.EvidencijaSvihRadnikaFirmeZaDatum")
                    .setParameter("Firma", firma)
                    .setParameter("Datum", Datum)
                    .getResultList();
        } catch (Exception ex) {
            return null;
        }
    }
//</editor-fold>

    //<editor-fold defaultstate="collapsed" desc="STATUSI">
    public static synchronized List<Statusi> listaStatusa() {
        try {
            return getEm().createNamedQuery("Statusi.findAll")
                    .getResultList();
        } catch (Exception ex) {
            return null;
        }
    }

    public static synchronized Statusi statusPoOznaci(String status) {
        try {
            return (Statusi) getEm().createNamedQuery("Statusi.findByStatus")
                    .setParameter("status", status)
                    .getSingleResult();
        } catch (Exception ex) {
            return null;
        }
    }

    public static synchronized Statusi statusPoID(int idstatus) {
        try {
            return (Statusi) getEm().createNamedQuery("Statusi.findByIDStatus")
                    .setParameter("iDStatus", idstatus)
                    .getSingleResult();
        } catch (Exception ex) {
            return null;
        }
    }
//</editor-fold>

    //<editor-fold defaultstate="collapsed" desc="IZVEŠTAJI - Stored procedures">
    public static synchronized List<SVI_RADNICI_SUMA_SATA_ZA_PERIOD> Izvestaj_SVI_RADNICI_SUMA_SATA_ZA_PERIOD(String datumOD, String datumDO) {
        SVI_RADNICI_SUMA_SATA_ZA_PERIOD srss;
        List<SVI_RADNICI_SUMA_SATA_ZA_PERIOD> lista = new ArrayList<>();

        try {
            if (!getEm().getTransaction().isActive()) {
                getEm().getTransaction().begin();
            }

            Connection c = getEm().unwrap(java.sql.Connection.class);

            CallableStatement cs = c.prepareCall("{call [dbo].[UK_MESECNI_SATI_ZA_SVE_STATUSE_ORGJED_PO_SIFRAMA](?1,?2)} ");
            cs.setString(1, datumOD);
            cs.setString(2, datumDO);

            ResultSet rs = cs.executeQuery();

            while (rs.next()) {
                srss = new SVI_RADNICI_SUMA_SATA_ZA_PERIOD();

                srss.setIdk(rs.getInt(1));
                srss.setIdfirma(rs.getInt(2));
                srss.setIdorgjed(rs.getInt(3));
                srss.setIdradnik(rs.getInt(4));
                srss.setFk_idstatus(rs.getInt(5));
                srss.setSifrastatusa(rs.getString(6));
                srss.setSati(rs.getFloat(7));

                lista.add(srss);
                srss = null;
            }

            getEm().getTransaction().commit();
            return lista;
        } catch (SQLException e1) {
            try {
                getEm().getTransaction().rollback();
            } catch (Exception ex) {
            }
            return null;
        } catch (Exception e2) {
            em.getTransaction().rollback();
            return null;
        } finally {
            try {
                getEm().flush();
                getEm().close();
            } catch (Exception ex) {
            }
        }
    }

    public static synchronized List<evidencijeRadnikaZaJedanDan> Izvestaj_evidencijeRadnikaZaJedanDan(long idradnik, String datum) {
        sp.izvestaji.evidencijeRadnikaZaJedanDan erz;
        List<evidencijeRadnikaZaJedanDan> lista = new ArrayList<>();

        try {
            if (!getEm().getTransaction().isActive()) {
                getEm().getTransaction().begin();
            }

            Connection c = getEm().unwrap(java.sql.Connection.class);

            CallableStatement cs = c.prepareCall("{call [dbo].[evidencijeRadnikaZaJedanDan](?1,?2)} ");
            cs.setLong(1, idradnik);
            cs.setString(2, datum);

            ResultSet rs = cs.executeQuery();

            while (rs.next()) {
                erz = new evidencijeRadnikaZaJedanDan();

                erz.setFk_idradnik(rs.getInt(1));
                erz.setRbrstanja(rs.getInt(2));
                erz.setDatum(rs.getString(3));
                erz.setZnacenje(rs.getString(4));
                erz.setStatus(rs.getString(5));
                erz.setNalog(rs.getString(6));
                erz.setPoc_stanja(rs.getString(7));
                erz.setKraj_stanja(rs.getString(8));
                erz.setTrajanje(rs.getFloat(9));

                lista.add(erz);
                erz = null;
            }

            getEm().getTransaction().commit();
            return lista;
        } catch (SQLException e1) {
            try {
                getEm().getTransaction().rollback();
            } catch (Exception ex) {
            }
            return null;
        } catch (Exception e2) {
            em.getTransaction().rollback();
            return null;
        } finally {
            try {
                getEm().flush();
                getEm().close();
            } catch (Exception ex) {
            }
        }
    }

    public static synchronized List<SVI_RADNICI_UK_MESECNI_SATI_ZA_SVE_STATUSE> Izvestaj_SVI_RADNICI_UK_MESECNI_SATI_ZA_SVE_STATUSE(String datumOd, String datumDo) {
        sp.izvestaji.SVI_RADNICI_UK_MESECNI_SATI_ZA_SVE_STATUSE sr_uk;
        List<SVI_RADNICI_UK_MESECNI_SATI_ZA_SVE_STATUSE> lista = new ArrayList<>();

        try {
            if (!getEm().getTransaction().isActive()) {
                getEm().getTransaction().begin();
            }

            Connection c = em.unwrap(java.sql.Connection.class);

            CallableStatement cs = c.prepareCall("{call [dbo].[UK_MESECNI_SATI_ZA_SVE_STATUSE_ORGJED](?1,?2)}");
            cs.setString(1, datumOd);
            cs.setString(2, datumDo);

            ResultSet rs = cs.executeQuery();

            while (rs.next()) {
                sr_uk = new SVI_RADNICI_UK_MESECNI_SATI_ZA_SVE_STATUSE();

                sr_uk.setIdradnik(rs.getLong(1));
                sr_uk.setIme(rs.getString(2));
                sr_uk.setPrezime(rs.getString(3));
                sr_uk.setStatus(rs.getString(4));
                sr_uk.setZnacenje(rs.getString(5));
                sr_uk.setMesec(rs.getInt(6));
                sr_uk.setSati(rs.getFloat(7));

                lista.add(sr_uk);
                sr_uk = null;
            }

            getEm().getTransaction().commit();
            return lista;
        } catch (SQLException e1) {
            try {
                getEm().getTransaction().rollback();
            } catch (Exception ex) {
            }
            return null;
        } catch (Exception e2) {
            try {
                getEm().getTransaction().rollback();
            } catch (Exception ex) {
            }
            return null;
        } finally {
            try {
                getEm().flush();
                getEm().close();
            } catch (Exception ex) {
            }
        }
    }

    public static synchronized List<UCINAK_RADNIKA_ZA_PERIOD> Izvestaj_UCINAK_RADNIKA_ZA_PERIOD(long idradnik, String datumOd, String datumDo) {
        sp.izvestaji.UCINAK_RADNIKA_ZA_PERIOD sr_uk;
        List<UCINAK_RADNIKA_ZA_PERIOD> lista = new ArrayList<>();

        try {
            if (!getEm().getTransaction().isActive()) {
                getEm().getTransaction().begin();
            }

            Connection c = em.unwrap(java.sql.Connection.class);

            CallableStatement cs = c.prepareCall("{call [dbo].[UCINAK_RADNIKA_ZA_PERIOD](?1, ?2, ?3)}");
            cs.setLong(1, idradnik);
            cs.setString(2, datumOd);
            cs.setString(3, datumDo);

            ResultSet rs = cs.executeQuery();

            while (rs.next()) {
                sr_uk = new UCINAK_RADNIKA_ZA_PERIOD();

                sr_uk.setIdk(rs.getInt(1));
                sr_uk.setKompanija(rs.getString(2));
                sr_uk.setIdfirma(rs.getInt(3));
                sr_uk.setFirma(rs.getString(4));
                sr_uk.setIdorgjed(rs.getInt(5));
                sr_uk.setOrgjed(rs.getString(6));
                sr_uk.setIdradnik(rs.getLong(7));
                sr_uk.setStatus(rs.getString(8));
                sr_uk.setZnacenje(rs.getString(9));
                sr_uk.setUksati(rs.getFloat(10));
                sr_uk.setIskoriscenost(rs.getFloat(11));

                lista.add(sr_uk);
                sr_uk = null;
            }

            getEm().getTransaction().commit();
            return lista;
        } catch (SQLException e1) {
            try {
                getEm().getTransaction().rollback();
            } catch (Exception ex) {
            }
            return null;
        } catch (Exception e2) {
            try {
                getEm().getTransaction().rollback();
            } catch (Exception ex) {
            }
            return null;
        } finally {
            try {
                getEm().flush();
                getEm().close();
            } catch (Exception ex) {
            }
        }
    }
//</editor-fold>

    //<editor-fold defaultstate="collapsed" desc="ERS-FullKD upiti !">
    public static synchronized List<Servis_Ukupan_Broj_Faktura_Za_Period> Izvestaj_Servis_Ukupan_Broj_Faktura_Za_Period(String DatumOD, String DatumDO) {
        Servis_Ukupan_Broj_Faktura_Za_Period sr_uk;
        List<Servis_Ukupan_Broj_Faktura_Za_Period> lista = new ArrayList<>();

        try {
            if (!em.getTransaction().isActive()) {
                em.getTransaction().begin();
            }

            Connection c = em.unwrap(java.sql.Connection.class);

            CallableStatement cs = c.prepareCall("{call [ERS].[dbo].[FULL_KD_Servis_Ukupan_Broj_Faktura_Za_Period] (?1, ?2)} ");
            cs.setString(1, DatumOD);
            cs.setString(2, DatumDO);

            ResultSet rs = cs.executeQuery();

            while (rs.next()) {
                sr_uk = new Servis_Ukupan_Broj_Faktura_Za_Period(rs.getInt(2), rs.getString(1));
                lista.add(sr_uk);

                sr_uk = null;
            }

            em.getTransaction().commit();

            return lista;

        } catch (SQLException e1) {
            em.getTransaction().rollback();
            return null;
        } catch (Exception e2) {
            em.getTransaction().rollback();
            return null;
        } finally {
            try {
                getEm().flush();
                getEm().close();
            } catch (Exception ex) {
            }
        }
    }

    public static synchronized List<Servis_Fakturisani_Nalozi_Po_PC> Izvestaj_Servis_Fakturisani_Nalozi_Po_PC(String DatumOD, String DatumDO) {
        Servis_Fakturisani_Nalozi_Po_PC sr_uk;
        List<Servis_Fakturisani_Nalozi_Po_PC> lista = new ArrayList<>();

        try {
            if (!em.getTransaction().isActive()) {
                em.getTransaction().begin();
            }

            Connection c = em.unwrap(java.sql.Connection.class);

            CallableStatement cs = c.prepareCall("{call [ERS].[dbo].[FULL_KD_Servis_Fakturisani_Nalozi_Po_PC] (?1, ?2)} ");
            cs.setString(1, DatumOD);
            cs.setString(2, DatumDO);

            ResultSet rs = cs.executeQuery();

            while (rs.next()) {
                sr_uk = new Servis_Fakturisani_Nalozi_Po_PC(rs.getString(1), rs.getFloat(2));
                lista.add(sr_uk);

                sr_uk = null;
            }

            em.getTransaction().commit();

            return lista;

        } catch (SQLException e1) {
            em.getTransaction().rollback();
            return null;
        } catch (Exception e2) {
            em.getTransaction().rollback();
            return null;
        } finally {
            try {
                getEm().flush();
                getEm().close();
            } catch (Exception ex) {
            }
        }
    }

    public static synchronized List<Servis_Fakturisani_Nalozi_Po_PC_Detaljno> Izvestaj_Servis_Fakturisani_Nalozi_Po_PC_Detaljno(String DatumOD, String DatumDO) {
        Servis_Fakturisani_Nalozi_Po_PC_Detaljno sr_uk;
        List<Servis_Fakturisani_Nalozi_Po_PC_Detaljno> lista = new ArrayList<>();

        try {
            if (!em.getTransaction().isActive()) {
                em.getTransaction().begin();
            }

            Connection c = em.unwrap(java.sql.Connection.class);

            CallableStatement cs = c.prepareCall("{call [ERS].[dbo].[FULL_KD_Servis_Fakturisani_Nalozi_Po_PC_Detaljno] (?1, ?2)} ");
            cs.setString(1, DatumOD);
            cs.setString(2, DatumDO);

            ResultSet rs = cs.executeQuery();

            while (rs.next()) {
                sr_uk = new Servis_Fakturisani_Nalozi_Po_PC_Detaljno(
                        rs.getString(1),
                        rs.getString(2),
                        rs.getFloat(3),
                        rs.getFloat(4),
                        rs.getFloat(5),
                        rs.getFloat(6),
                        rs.getFloat(7));

                lista.add(sr_uk);

                sr_uk = null;
            }

            em.getTransaction().commit();

            return lista;

        } catch (SQLException e1) {
            em.getTransaction().rollback();
            return null;
        } catch (Exception e2) {
            em.getTransaction().rollback();
            return null;
        } finally {
            try {
                getEm().flush();
                getEm().close();
            } catch (Exception ex) {
            }
        }
    }

    public static synchronized List<Servis_Poslovanje_Mesecno> Izvestaj_Servis_Uporedjenje_Poslovanja(String DatumOD, String DatumDO) {
        Servis_Poslovanje_Mesecno sp;
        List<Servis_Poslovanje_Mesecno> lista = new ArrayList<>();

        try {
            if (!em.getTransaction().isActive()) {
                em.getTransaction().begin();
            }

            Connection c = em.unwrap(java.sql.Connection.class);

            CallableStatement cs = c.prepareCall("{call [ERS].[dbo].[Servis_Poslovanje_Mesecno] (?1, ?2)} ");
            cs.setString(1, DatumOD);
            cs.setString(2, DatumDO);

            ResultSet rs = cs.executeQuery();

            while (rs.next()) {
                sp = new Servis_Poslovanje_Mesecno(
                        rs.getString(1),
                        rs.getInt(2),
                        rs.getInt(3),
                        rs.getDouble(4));

                lista.add(sp);

                sp = null;
            }

            em.getTransaction().commit();

            return lista;

        } catch (SQLException e1) {
            em.getTransaction().rollback();
            return null;
        } catch (Exception e2) {
            em.getTransaction().rollback();
            return null;
        } finally {
            try {
                getEm().flush();
                getEm().close();
            } catch (Exception ex) {
            }
        }
    }
    //</editor-fold>

    //<editor-fold defaultstate="collapsed" desc="EXCELL, CSV">
    public static synchronized List<TempFaktSati> tempFaktSati() throws Exception {
        return getEm().createNamedQuery("TempFaktSati.findAll")
                .getResultList();
    }

    public static synchronized void insertTempFU(FUExcelBean fu) throws Exception {
        TempFaktSati tf;

        if (!getEm().getTransaction().isActive()) {
            getEm().getTransaction().begin();
        }

        tf = new TempFaktSati();

        tf.setFKIDRadnik(radnikSifraINFSISTEM(fu.getRadnik()).getIDRadnik());
        tf.setSati(fu.getSati());
        tf.setNalog(fu.getRadniNalog());
        tf.setDatum(new SimpleDateFormat("yyyy-MM-dd").format(fu.getDatumRacuna()));
        tf.setPCentar(null);

        getEm().persist(tf);
        getEm().getTransaction().commit();
        getEm().close();
    }

    public static synchronized void insertNoveFakturisaneUslugeExcel(List<FUExcelBean> FUExcelBeans) throws Exception {
        TempFaktSati tf;

        if (!getEm().getTransaction().isActive()) {
            getEm().getTransaction().begin();
        }

        for (FUExcelBean fu : FUExcelBeans) {
            tf = new TempFaktSati();

            tf.setFKIDRadnik(radnikSifraINFSISTEM(fu.getRadnik()).getIDRadnik());
            tf.setSati(fu.getSati());
            tf.setNalog(fu.getRadniNalog());
            tf.setDatum(new SimpleDateFormat("yyyy-MM-dd").format(fu.getDatumRacuna()));
            tf.setPCentar(null);

            getEm().persist(tf);
        }

        getEm().getTransaction().commit();
        getEm().close();
    }

    public static synchronized void insertNoveFakturisaneUslugeCSV(List<FUCSVBean> FUCSVBeans) throws Exception {
        TempFaktSati tf;

        if (!getEm().getTransaction().isActive()) {
            getEm().getTransaction().begin();

            for (FUCSVBean fu : FUCSVBeans) {
                tf = new TempFaktSati();

                tf.setFKIDRadnik(radnikSifraINFSISTEM(fu.getRadnik()).getIDRadnik());
                tf.setSati(Double.parseDouble(fu.getSati()));
                tf.setNalog(fu.getRadniNalog());
                tf.setDatum(new SimpleDateFormat("yyyy-MM-dd").format(fu.getDatumRacuna()));
                tf.setPCentar(null);

                getEm().persist(tf);
            }

            getEm().getTransaction().commit();
        }

        getEm().close();
    }
    //</editor-fold>

    //<editor-fold defaultstate="collapsed" desc="JavaFX - Fin. Izveštaj">
    public static Integer UKSati(int Godina, int Mesec) {
        try {
            return Math.round(
                    ((Number) em.createNamedQuery("FaktSati.UKSati")
                    .setParameter("Godina", Godina)
                    .setParameter("Mesec", Mesec)
                    .getSingleResult()).floatValue());
        } catch (Exception e) {
            return 0;
        }
    }

    /**
     * @param Godina
     * @param Mesec
     * @return Map<Integer, DnevnoSATI_UK>
     * Svi Dani u Mesecu -> DnevnoSATI_UK
     */
    public static Map<Integer, DnevnoSATI_UK> UKDnevnaFakturisanostDS(int Godina, int Mesec) {
        Map<Integer, DnevnoSATI_UK> finalnaMapa = new TreeMap<>(DnevnoSATI_UK.getDaniMesecInitMap(Godina, Mesec));
        List<DnevnoSATI_UK> dnevnaLista;

        try {
            dnevnaLista = getEm()
                    .createNamedQuery("FaktSati.UKDnevnaFakturisanost")
                    .setParameter("Godina", Godina)
                    .setParameter("Mesec", Mesec)
                    .getResultList();

            for (DnevnoSATI_UK d : dnevnaLista) {
                finalnaMapa.put((int) d.getDay(), d);
            }

            return finalnaMapa;

        } catch (Exception e) {
            return null;
        }
    }

    /**
     * @param Godina
     * @param Mesec
     * @return Map<Integer, Integer>
     * Svi Dani u Mesecu -> UkSati
     */
    public static Map<Integer, Integer> UKDnevnaFakturisanost(int Godina, int Mesec) {
        Map<Integer, Integer> fs = new TreeMap<>();

        for (Map.Entry<Integer, DnevnoSATI_UK> e : UKDnevnaFakturisanostDS(Godina, Mesec).entrySet()) {
            fs.put(e.getKey(), Math.round((float) e.getValue().getRad()));
        }

        return fs;
    }

    public static List<Map<Integer, Integer>> Mesec_DnevnoSATI_UK_Serije(int Godina, int Mesec) {
        List<Map<Integer, Integer>> serija = new ArrayList<>(1);
        Map<Integer, Integer> s = new TreeMap<>();

        for (Map.Entry<Integer, DnevnoSATI_UK> e : UKDnevnaFakturisanostDS(Godina, Mesec).entrySet()) {
            // e.getKey() -> Dan ! (int) e.getValue() -> Rad i Materijal RESPEKTIVNO !!
            s.put(e.getKey(), Math.round((float) e.getValue().getRad()));
        }

        serija.add(s);

        return serija;
    }

    //</editor-fold>
}
