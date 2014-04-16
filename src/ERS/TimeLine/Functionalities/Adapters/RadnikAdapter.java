/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ERS.TimeLine.Functionalities.Adapters;

import ERS.TimeLine.Functionalities.ITimeLineCategory;
import ent.Radnik;
import java.util.ArrayList;
import java.util.List;

/**
 * Adapter za klasu koja će biti kategorija u FX objektu i koja učestvuje u
 * metodu AllCategoresEvents(ITimeLineObservableUnit, String)
 *
 */
public class RadnikAdapter implements ITimeLineCategory {

    private Radnik radnik;

    //<editor-fold defaultstate="collapsed" desc="Konstruktori, getters/setters">
    public RadnikAdapter() {
        super();
    }

    public RadnikAdapter(Long IDRadnik) {
        this.radnik = ERS.queries.ERSQuery.radnikID(IDRadnik);
    }

    public RadnikAdapter(Radnik Radnik) {
        this.radnik = Radnik;
    }

    @Override
    public String getCategory() {
        return radnik.getImePrezime();
    }

    public Radnik getRadnik() {
        return radnik;
    }

    public void setRadnik(Radnik radnik) {
        this.radnik = radnik;
    }
    //</editor-fold>

    public static List<ITimeLineCategory> getTLCategories(List<Radnik> radnici) {
        List<ITimeLineCategory> rTL = new ArrayList<>();

        for (Radnik r : radnici) {
            rTL.add(new RadnikAdapter(r));
        }

        return rTL;
    }
}
