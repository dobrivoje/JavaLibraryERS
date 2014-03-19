/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ERS.BusinessBeans;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

/**
 *
 * @author root
 */
public class DnevnoSATI_UK extends Base4BusinessBeans {

    private double Rad;

    //<editor-fold defaultstate="collapsed" desc="konstruktor, getters/setters">
    public DnevnoSATI_UK(int Godina, int Mesec, int Dan, double Rad) {
        super(Godina, Mesec, Dan);
        this.Rad = Rad;
    }

    public double getRad() {
        return Rad;
    }

    public void setRad(double Rad) {
        this.Rad = Rad;
    }
    //</editor-fold>

    public static List<DnevnoSATI_UK> getDaniMesecInit(int Godina, int Mesec) {
        lastDayOfMonth = getLastDayOfMonth(Godina, Mesec);

        List<DnevnoSATI_UK> L = new ArrayList(lastDayOfMonth);

        for (int i = 0; i < lastDayOfMonth; i++) {
            L.add(i, new DnevnoSATI_UK(Godina, Mesec, /* indeks=0, dan=index+1*/ i + 1, 0d));
        }

        return L;
    }

    public static Map<Integer, DnevnoSATI_UK> getDaniMesecInitMap(int Godina, int Mesec) {
        Map<Integer, DnevnoSATI_UK> M = new TreeMap();

        for (DnevnoSATI_UK d : getDaniMesecInit(Godina, Mesec)) {
            M.put(d.getDay(), new DnevnoSATI_UK(Godina, Mesec, d.getDay(), 0d));
        }

        return M;
    }

    @Override
    public String toString() {
        return year + ". " + month + ". " + day + " [" + decimalFormat.format(Rad) + "]";
    }
}
