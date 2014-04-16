/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ERS.TimeLine.Functionalities.Adapters;

import ERS.TimeLine.Functionalities.ITimeLineCategory;
import ERS.TimeLine.Functionalities.ITimeLineObservableUnit;
import ent.Firma;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

/**
 * Adapter za klasu koja će biti kategorija u FX objektu i koja učestvuje u
 * metodu AllCategoresEvents(ITimeLineObservableUnit, String)
 *
 */
public class FirmaAdapter implements ITimeLineObservableUnit {

    private Firma firma;
    private final String datum;

    private static final String DD_STR = (new SimpleDateFormat("yyyy-MM-dd")).format(new Date());
    private static Date DANASNJI_DATUM;

    private List<ITimeLineCategory> categories;

    //<editor-fold defaultstate="collapsed" desc="Konstruktori, getters/setters">
    public FirmaAdapter(Firma Firma, String Datum) throws ParseException {
        this.datum = Datum;
        this.firma = Firma;
        DANASNJI_DATUM = new SimpleDateFormat("yyyy-MM-dd").parse(DD_STR);

        if (getDatum(this.datum).before(DANASNJI_DATUM)) {
            this.categories = RadnikAdapter.getTLCategories(ERS.queries.ERSQuery.radniciFirmeZaDatum(firma, datum));
        } else {
            this.categories = RadnikAdapter.getTLCategories(ERS.queries.ERSQuery.aktivniRadniciFirme(firma));
        }
    }

    public Firma getFirma() {
        return firma;
    }

    public void setFirma(Firma firma) {
        this.firma = firma;
    }

    @Override
    public List<ITimeLineCategory> getCategories() {
        return categories;
    }

    public void setCategories(List<ITimeLineCategory> categories) {
        this.categories = categories;
    }
    //</editor-fold>

    private Date getDatum(String Datum) throws ParseException {
        return new SimpleDateFormat("yyyy-MM-dd").parse(Datum);
    }
}
