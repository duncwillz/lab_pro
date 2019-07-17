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
 * @author Kwaku Adjei <duncanadjei@gmail.com>
 */

public class Log 
{
    private Integer id;
    private Integer lognumber;
    private int requsitionnumber;
    private Date collectiondate;
    private Integer subjectid;
    private Time collectiontime;
    private String parasite;
    private Integer trackingnumber;
    private Integer parasitology;

    public Log() {
    }

    public Log(Integer id) {
        this.id = id;
    }

    public Integer getSubjectid() {
        return subjectid;
    }

    public void setSubjectid(Integer subjectid) {
        this.subjectid = subjectid;
    }

    public Log(Integer lognumber, int requsitionnumber, Date collectiondate, Integer subjectid, Time collectiontime, String parasite, Integer trackingnumber, Integer parasitology) {
        this.lognumber = lognumber;
        this.requsitionnumber = requsitionnumber;
        this.collectiondate = collectiondate;
        this.subjectid = subjectid;
        this.collectiontime = collectiontime;
        this.parasite = parasite;
        this.trackingnumber = trackingnumber;
        this.parasitology = parasitology;
    }

    public Time getCollectiontime() {
        return collectiontime;
    }

    public void setCollectiontime(Time collectiontime) {
        this.collectiontime = collectiontime;
    }

    public String getParasite() {
        return parasite;
    }

    public void setParasite(String parasite) {
        this.parasite = parasite;
    }

    public Integer getTrackingnumber() {
        return trackingnumber;
    }

    public void setTrackingnumber(Integer trackingnumber) {
        this.trackingnumber = trackingnumber;
    }

    public Integer getLognumber() {
        return lognumber;
    }

    public void setLognumber(Integer lognumber) {
        this.lognumber = lognumber;
    }

   

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public int getRequsitionnumber() {
        return requsitionnumber;
    }

    public void setRequsitionnumber(int requsitionnumber) {
        this.requsitionnumber = requsitionnumber;
    }

    public Date getCollectiondate() {
        return collectiondate;
    }

    public void setCollectiondate(Date collectiondate) {
        this.collectiondate = collectiondate;
    }

    public Integer getParasitology() {
        return parasitology;
    }

    public void setParasitology(Integer parasitology) {
        this.parasitology = parasitology;
    }

  
}
