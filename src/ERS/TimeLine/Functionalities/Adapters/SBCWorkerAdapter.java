/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ERS.TimeLine.Functionalities.Adapters;

import ERS.TimeLine.Functionalities.ITimeLineDuration;
import ERS.TimeLine.SBCWorkerTimeLine;

/**
 * SBCWorkerTimeLine - Adapter klasa interfejsa ITimeLineDuration kao priprema
 * za FX Stacked Bar Category TimeLine objekat
 *
 */
public class SBCWorkerAdapter implements ITimeLineDuration {

    private final SBCWorkerTimeLine SBCWTimeLine;

    public SBCWorkerAdapter(SBCWorkerTimeLine SBCWTimeLine) {
        this.SBCWTimeLine = SBCWTimeLine;
    }

    @Override
    public int getDuration() {
        return SBCWTimeLine.getTrajanje() != null ? SBCWTimeLine.getTrajanje().intValue() : -1;
    }

    @Override
    public int getStatusID() {
        return SBCWTimeLine.getStatus().getIDStatus();
    }

    @Override
    public String toString() {
        return "[St.ID-" + getStatusID() + "] [" + getDuration() + "]";
    }
}
