/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package model;

import java.sql.Date;
import java.util.List;

/**
 * 
 * @author Kwaku Adjei <duncanadjei@gmail.com>
 */public class Subjects  {

    private Integer id;
    private int subjectid;
    private Date dob;
    private String gender;
    private String group;
    private List<Log> logCollection;

    public Subjects() {
    }

    public Subjects(Integer id) {
        this.id = id;
    }

    public Subjects(Integer id, int subjectid, Date dob, String gender, String group) {
        this.id = id;
        this.subjectid = subjectid;
        this.dob = dob;
        this.gender = gender;
        this.group = group;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public int getSubjectid() {
        return subjectid;
    }

    public void setSubjectid(int subjectid) {
        this.subjectid = subjectid;
    }

    public Date getDob() {
        return dob;
    }

    public void setDob(Date dob) {
        this.dob = dob;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getGroup() {
        return group;
    }

    public void setGroup(String group) {
        this.group = group;
    }


    public void setLogCollection(List<Log> logCollection) {
        this.logCollection = logCollection;
    }
    
     public List<Log> gettLogCollection() {
        return logCollection;
    }

}
