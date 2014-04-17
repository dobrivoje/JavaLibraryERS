/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
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
@Table(name = "SystemTimeMonitoring")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "SystemTimeMonitoring.findAll", query = "SELECT s FROM SystemTimeMonitoring s"),
    @NamedQuery(name = "SystemTimeMonitoring.ActiveTimeScheme", query = "SELECT s FROM SystemTimeMonitoring s WHERE s.active = TRUE"),
    @NamedQuery(name = "SystemTimeMonitoring.findByIDTime", query = "SELECT s FROM SystemTimeMonitoring s WHERE s.iDTime = :IDTime")})
public class SystemTimeMonitoring implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "IDTime")
    private Integer iDTime;
    @Column(name = "SystemTimeMin")
    private String systemTimeMin;
    @Column(name = "SystemTimeMax")
    private String systemTimeMax;
    @Column(name = "SystemTimeMonitoringDuration")
    private int systemTimeMonitoringDuration;
    @Column(name = "Active")
    private boolean active;
    @Column(name = "Napomena")
    private String napomena;

    public SystemTimeMonitoring() {
    }

    public SystemTimeMonitoring(Integer iDTime) {
        this.iDTime = iDTime;
    }

    public Integer getIDTime() {
        return iDTime;
    }

    public void setIDTime(Integer iDTime) {
        this.iDTime = iDTime;
    }

    public String getSystemTimeMin() {
        return systemTimeMin;
    }

    public void setSystemTimeMin(String systemTimeMin) {
        this.systemTimeMin = systemTimeMin;
    }

    public String getSystemTimeMax() {
        return systemTimeMax;
    }

    public void setSystemTimeMax(String systemTimeMax) {
        this.systemTimeMax = systemTimeMax;
    }

    public int getSystemTimeMonitoringDuration() {
        return systemTimeMonitoringDuration;
    }

    public void setSystemTimeMonitoringDuration(int systemTimeMonitoringDuration) {
        this.systemTimeMonitoringDuration = systemTimeMonitoringDuration;
    }

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }

    public String getNapomena() {
        return napomena;
    }

    public void setNapomena(String napomena) {
        this.napomena = napomena;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (iDTime != null ? iDTime.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof SystemTimeMonitoring)) {
            return false;
        }
        SystemTimeMonitoring other = (SystemTimeMonitoring) object;
        if ((this.iDTime == null && other.iDTime != null) || (this.iDTime != null && !this.iDTime.equals(other.iDTime))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "ent.SystemTimeMonitoring[ iDTime=" + iDTime + " ]";
    }

}
