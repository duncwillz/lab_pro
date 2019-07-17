/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package model;

import java.sql.Date;
import java.sql.Time;

/**
 * 
 * @author kwakuadjei <duncanadjei@gmail.com>
 */

public class Schedule {
    
    private Integer id;
    private Integer snumber;
    private String visit;
    private Date visitdate;
    private Date coldate;
    private Time coltime;
    private Integer parasitemia;
    private Integer genotyping;
    private Integer immunogenecity;
    private double haemoglobin;
    private Integer platelets;
    private double wbc;
    private Integer creatinine;
    private Integer alt;

    public Schedule() {
    }
//    
    
//    

    public Schedule(Integer id, Integer snumber, String visit, Date visitdate, Date coldate, Time coltime, Integer parasitemia, Integer genotyping, Integer immunogenecity, double haemoglobin, Integer platelets, double wbc, Integer creatinine, Integer alt) {
        this.id = id;
        this.snumber = snumber;
        this.visit = visit;
        this.visitdate = visitdate;
        this.coldate = coldate;
        this.coltime = coltime;
        this.parasitemia = parasitemia;
        this.genotyping = genotyping;
        this.immunogenecity = immunogenecity;
        this.haemoglobin = haemoglobin;
        this.platelets = platelets;
        this.wbc = wbc;
        this.creatinine = creatinine;
        this.alt = alt;
    }

    public Schedule(Integer snumber, String visit, Date visitdate, Date coldate, Time coltime, Integer parasitemia, Integer genotyping, Integer immunogenecity, double haemoglobin, Integer platelets, double wbc, Integer creatinine, Integer alt) {
        this.snumber = snumber;
        this.visit = visit;
        this.visitdate = visitdate;
        this.coldate = coldate;
        this.coltime = coltime;
        this.parasitemia = parasitemia;
        this.genotyping = genotyping;
        this.immunogenecity = immunogenecity;
        this.haemoglobin = haemoglobin;
        this.platelets = platelets;
        this.wbc = wbc;
        this.creatinine = creatinine;
        this.alt = alt;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getSnumber() {
        return snumber;
    }

    public void setSnumber(Integer snumber) {
        this.snumber = snumber;
    }

    public String getVisit() {
        return visit;
    }

    public void setVisit(String visit) {
        this.visit = visit;
    }

    public Date getVisitdate() {
        return visitdate;
    }

    public void setVisitdate(Date visitdate) {
        this.visitdate = visitdate;
    }

    public Date getColdate() {
        return coldate;
    }

    public void setColdate(Date coldate) {
        this.coldate = coldate;
    }

    public Time getColtime() {
        return coltime;
    }

    public void setColtime(Time coltime) {
        this.coltime = coltime;
    }

    public Integer getParasitemia() {
        return parasitemia;
    }

    public void setParasitemia(Integer parasitemia) {
        this.parasitemia = parasitemia;
    }

    public Integer getGenotyping() {
        return genotyping;
    }

    public void setGenotyping(Integer genotyping) {
        this.genotyping = genotyping;
    }

    public Integer getImmunogenecity() {
        return immunogenecity;
    }

    public void setImmunogenecity(Integer immunogenecity) {
        this.immunogenecity = immunogenecity;
    }

    public double getHaemoglobin() {
        return haemoglobin;
    }

    public void setHaemoglobin(double haemoglobin) {
        this.haemoglobin = haemoglobin;
    }

    public Integer getPlatelets() {
        return platelets;
    }

    public void setPlatelets(Integer platelets) {
        this.platelets = platelets;
    }

    public double getWbc() {
        return wbc;
    }

    public void setWbc(double wbc) {
        this.wbc = wbc;
    }

    public Integer getCreatinine() {
        return creatinine;
    }

    public void setCreatinine(Integer creatinine) {
        this.creatinine = creatinine;
    }

    public Integer getAlt() {
        return alt;
    }

    public void setAlt(Integer alt) {
        this.alt = alt;
    }
   

   
    
    
    
}
