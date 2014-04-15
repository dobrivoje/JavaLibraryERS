/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ERS.TimeLine;

/**
 *
 * @author dobri
 */
public class IDS {

    private int RBr;
    private int IDStatus;

    //<editor-fold defaultstate="collapsed" desc="KOnstruktor, gettters/setters">
    public IDS(int RBr, int IDStatus) {
        this.RBr = RBr;
        this.IDStatus = IDStatus;
    }

    public int getRBr() {
        return RBr;
    }

    public void setRBr(int RBr) {
        this.RBr = RBr;
    }

    public int getIDStatus() {
        return IDStatus;
    }

    public void setIDStatus(int IDStatus) {
        this.IDStatus = IDStatus;
    }
    //</editor-fold>
}
