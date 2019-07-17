package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.Log;
import model.Schedule;
import model.Subjects;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Duncan Adjei
 */
public abstract class ConnectAbstract {

    protected abstract Connection connect();
  public boolean create(Subjects model) {
        try {
            String sql = "INSERT INTO subjects (subjectid, dob, gender, subjectgroup) VALUES (?,?,?,?)";
            PreparedStatement s = connect().prepareStatement(sql, ResultSet.TYPE_FORWARD_ONLY, ResultSet.CONCUR_READ_ONLY);
            s.setFetchSize(1);
            s.setInt(1, model.getSubjectid());
            s.setDate(2, model.getDob());
            s.setString(3, model.getGender());
            s.setString(4, model.getGroup());
            return s.executeUpdate() > 0;
        } catch (SQLException ex) {
            Logger.getLogger(DBConnect.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
    }

    public boolean update(Subjects model) {
        try {
            String sql = "UPDATE subjects SET subjectid = ?,  dob = ?, gender = ?,  subjectgroup = ? WHERE id = ?";
            PreparedStatement s = connect().prepareStatement(sql, ResultSet.TYPE_FORWARD_ONLY, ResultSet.CONCUR_READ_ONLY);
            s.setFetchSize(1);
            s.setInt(1, model.getSubjectid());
            s.setDate(2, model.getDob());
            s.setString(3, model.getGender());
            s.setString(4, model.getGroup());
            s.setInt(5, model.getId());
            return s.executeUpdate() > 0;
        } catch (SQLException ex) {
            Logger.getLogger(DBConnect.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
    }

    public boolean delete(Subjects model) {
        try {
            String sql = "DELETE FROM subjects WHERE subjectid = ?";
            PreparedStatement s = connect().prepareStatement(sql, ResultSet.TYPE_FORWARD_ONLY, ResultSet.CONCUR_READ_ONLY);
            s.setFetchSize(1);
            s.setInt(1, model.getSubjectid());

            return s.executeUpdate() > 0;
        } catch (SQLException ex) {
            Logger.getLogger(DBConnect.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
    }

    public List<Subjects> findAllSubjects() {
        List<Subjects> data = new ArrayList();
        try {
            String sql = "SELECT * FROM subjects";
            PreparedStatement s = connect().prepareStatement(sql, ResultSet.TYPE_FORWARD_ONLY, ResultSet.CONCUR_READ_ONLY);
            s.setFetchSize(1);
            ResultSet rs = s.executeQuery();
            while (rs.next()) {
                Subjects model = new Subjects();
                model.setSubjectid(rs.getInt("subjectid"));
                model.setDob(rs.getDate("dob"));
                model.setGender(rs.getString("gender"));
                model.setGroup(rs.getString("subjectgroup"));
                data.add(model);
            }
        } catch (SQLException ex) {
            Logger.getLogger(DBConnect.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
        return data;
    }
 public List<Subjects> getSubjectByID(int index) {
        List<Subjects> data = new ArrayList();
        try {
            String sql = "SELECT * FROM subjects WHERE subjectid=?";
            PreparedStatement s = connect().prepareStatement(sql, ResultSet.TYPE_FORWARD_ONLY, ResultSet.CONCUR_READ_ONLY);
            s.setFetchSize(1);
            s.setInt(1, index);
            ResultSet rs = s.executeQuery();
            while (rs.next()) {
                 Subjects model = new Subjects();
                 model.setId(rs.getInt("id"));
                model.setSubjectid(rs.getInt("subjectid"));
                model.setDob(rs.getDate("dob"));
                model.setGender(rs.getString("gender"));
                model.setGroup(rs.getString("subjectgroup"));
                data.add(model);
            }
        } catch (SQLException ex) {
            Logger.getLogger(DBConnect.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
        return data;
    }
      
  public boolean create(Log model) {
        try {
            String sql = "INSERT INTO log (lognumber, subjectid,  requsitionnumber, collectiondate, parasite, trackingnumber, collectiontime, parasitology) VALUES (?,?,?,?,?,?,?,?)";
            PreparedStatement s = connect().prepareStatement(sql, ResultSet.TYPE_FORWARD_ONLY, ResultSet.CONCUR_READ_ONLY);
            s.setFetchSize(1);
            s.setInt(1, model.getLognumber());
            s.setInt(2, model.getSubjectid());
            s.setInt(3, model.getRequsitionnumber());
            s.setDate(4, model.getCollectiondate());
            s.setString(5, model.getParasite());
            s.setInt(6,model.getTrackingnumber());
            s.setTime(7,model.getCollectiontime());
            s.setInt(8, model.getParasitology());
            return s.executeUpdate() > 0;
        } catch (SQLException ex) {
            Logger.getLogger(DBConnect.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
    }

    public boolean update(Log model) {
        try {
            String sql = "UPDATE log SET lognumber=?, subjectid=? , requsitionnumber = ?, collectiondate = ?, parasite = ?, trackingnumber = ?, collectiontime = ?, parasitology = ? WHERE id = ?";
            PreparedStatement s = connect().prepareStatement(sql, ResultSet.TYPE_FORWARD_ONLY, ResultSet.CONCUR_READ_ONLY);
            s.setFetchSize(1);
            s.setInt(1, model.getLognumber());
            s.setInt(2,model.getSubjectid());
            s.setInt(3, model.getRequsitionnumber());
            s.setDate(4, model.getCollectiondate());
            s.setString(5, model.getParasite());
            s.setInt(6,model.getTrackingnumber());
            s.setTime(7, model.getCollectiontime());
            s.setInt(8, model.getParasitology());
            s.setInt(9, model.getId());
            return s.executeUpdate() > 0;
        } catch (SQLException ex) {
            Logger.getLogger(DBConnect.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
    }

    public boolean delete(Log model) {
        try {
            String sql = "DELETE FROM log WHERE id = ?";
            PreparedStatement s = connect().prepareStatement(sql, ResultSet.TYPE_FORWARD_ONLY, ResultSet.CONCUR_READ_ONLY);
            s.setFetchSize(1);
            s.setInt(1, model.getId());
            return s.executeUpdate() > 0;
        } catch (SQLException ex) {
            Logger.getLogger(DBConnect.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
    }

    public List<Log> findAllLog(int subjectid) {
        List<Log> data = new ArrayList();
        try {
            String sql = "SELECT * FROM log WHERE subjectid =? ORDER BY lognumber";
            PreparedStatement s = connect().prepareStatement(sql, ResultSet.TYPE_FORWARD_ONLY, ResultSet.CONCUR_READ_ONLY);
            s.setFetchSize(1);
            s.setInt(1, subjectid);
            ResultSet rs = s.executeQuery();
            while (rs.next()) {
                Log model = new Log();
                model.setId(rs.getInt("id"));
                model.setLognumber(rs.getInt("lognumber"));
                model.setSubjectid(rs.getInt("subjectid"));
                model.setRequsitionnumber(rs.getInt("requsitionnumber"));
                model.setCollectiondate(rs.getDate("collectiondate"));
                model.setCollectiontime (rs.getTime("collectiontime"));
                model.setParasite(rs.getString("parasite"));
                model.setTrackingnumber(rs.getInt("trackingnumber"));
                model.setParasitology(rs.getInt("parasitology"));
                data.add(model);
            }
        } catch (SQLException ex) {
            Logger.getLogger(DBConnect.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
        return data;
    }  
    
    public List<Log> findAllLogOfSubject(int subjectid, int logid) {
        List<Log> data = new ArrayList();
        try {
            String sql = "SELECT * FROM log WHERE subjectid =? AND id = ?";
            PreparedStatement s = connect().prepareStatement(sql, ResultSet.TYPE_FORWARD_ONLY, ResultSet.CONCUR_READ_ONLY);
            s.setFetchSize(1);
            s.setInt(1, subjectid);
            s.setInt(2,logid);
            ResultSet rs = s.executeQuery();
            while (rs.next()) {
                Log model = new Log();
                model.setId(rs.getInt("id"));
                model.setLognumber(rs.getInt("lognumber"));
                model.setSubjectid(rs.getInt("subjectid"));
                model.setRequsitionnumber(rs.getInt("requsitionnumber"));
                model.setCollectiondate(rs.getDate("collectiondate"));
                model.setCollectiontime (rs.getTime("collectiontime"));
                model.setParasite(rs.getString("parasite"));
                model.setTrackingnumber(rs.getInt("trackingnumber"));
                model.setParasitology(rs.getInt("parasitology"));
                data.add(model);
            }
        } catch (SQLException ex) {
            Logger.getLogger(DBConnect.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
        return data;
    }  

    public int logsCountForSubject(int subjectid) {
        int count = 0;
        try {
            String sql = "SELECT COUNT(*) AS counting FROM log WHERE subjectid = ?";
            PreparedStatement s = connect().prepareStatement(sql, ResultSet.TYPE_FORWARD_ONLY, ResultSet.CONCUR_READ_ONLY);
            s.setFetchSize(1);
            s.setInt(1, subjectid);

            ResultSet rs = s.executeQuery();
            while (rs.next()) {
                count = rs.getInt("counting");
                return count;
            }
        } catch (SQLException ex) {
            Logger.getLogger(DBConnect.class.getName()).log(Level.SEVERE, null, ex);
            return 0;
        }
        return count;
    }    
     public boolean updateJoin(Log model,int previousSubjectid) {
        try {
            String sql = "UPDATE log AS l\n" +
                                "INNER JOIN subjects AS s ON l.subjectid = s.subjectid\n" +
                                "SET l.subjectid = ? WHERE l.subjectid=?";
            PreparedStatement s = connect().prepareStatement(sql, ResultSet.TYPE_FORWARD_ONLY, ResultSet.CONCUR_READ_ONLY);
            s.setFetchSize(1);
            s.setInt(1, model.getSubjectid());
            s.setInt(2, previousSubjectid);
            return s.executeUpdate() > 0;
        } catch (SQLException ex) {
            Logger.getLogger(DBConnect.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
    }

//   SCHEDULES
     public boolean create(Schedule model) {
        try {
            String sql = "INSERT INTO scheduled (snumber, visit,  coldate, timecol, parasitemia, genotype, immunogenecity, hemo, alt, creatine, wbc, plates, datecreated) VALUES (?,?,?,?,?,?,?,?,?,?,?,?,NOW())";
            PreparedStatement s = connect().prepareStatement(sql, ResultSet.TYPE_FORWARD_ONLY, ResultSet.CONCUR_READ_ONLY);
            s.setFetchSize(1);
            s.setInt(1, model.getSnumber());
            s.setString(2, model.getVisit());
            s.setDate(3, model.getColdate());
            s.setTime(4, model.getColtime());
            s.setInt(5, model.getParasitemia());
            s.setInt(6,model.getGenotyping());
            s.setInt(7,model.getImmunogenecity());
            s.setDouble(8, model.getHaemoglobin());
            s.setInt(9, model.getAlt());
            s.setInt(10, model.getCreatinine());
            s.setDouble(11, model.getWbc());
            s.setInt(12, model.getPlatelets());
            return s.executeUpdate() > 0;
        } catch (SQLException ex) {
            Logger.getLogger(DBConnect.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
    }

    public boolean update(Schedule model) {
        try {
            String sql = "UPDATE scheduled SET snumber = ?, visit = ?,  coldate = ?, timecol = ?, parasitemia = ?, genotype = ?, immunogenecity = ?, hemo = ?, alt = ?, creatine = ?, wbc = ?, plates = ?, WHERE id = ?";
            PreparedStatement s = connect().prepareStatement(sql, ResultSet.TYPE_FORWARD_ONLY, ResultSet.CONCUR_READ_ONLY);
            s.setFetchSize(1);
            s.setInt(1, model.getSnumber());
            s.setString(2, model.getVisit());
            s.setDate(3, model.getColdate());
            s.setTime(4, model.getColtime());
            s.setInt(5, model.getParasitemia());
            s.setInt(6,model.getGenotyping());
            s.setInt(7,model.getImmunogenecity());
            s.setDouble(8, model.getHaemoglobin());
            s.setInt(9, model.getAlt());
            s.setInt(10, model.getCreatinine());
            s.setDouble(11, model.getWbc());
            s.setInt(12, model.getPlatelets());
            s.setInt(13, model.getId());
            return s.executeUpdate() > 0;
        } catch (SQLException ex) {
            Logger.getLogger(DBConnect.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
    }

    public boolean delete(Schedule model) {
        try {
            String sql = "DELETE FROM scheduled WHERE id = ?";
            PreparedStatement s = connect().prepareStatement(sql, ResultSet.TYPE_FORWARD_ONLY, ResultSet.CONCUR_READ_ONLY);
            s.setFetchSize(1);
            s.setInt(1, model.getId());
            return s.executeUpdate() > 0;
        } catch (SQLException ex) {
            Logger.getLogger(DBConnect.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
    }

    public List<Schedule> findScheduleBySubject(int subjectid) {
        List<Schedule> data = new ArrayList();
        try {
            String sql = "SELECT * FROM scheduled WHERE subjectid =? ORDER BY visit";
            PreparedStatement s = connect().prepareStatement(sql, ResultSet.TYPE_FORWARD_ONLY, ResultSet.CONCUR_READ_ONLY);
            s.setFetchSize(1);
            s.setInt(1, subjectid);
            ResultSet rs = s.executeQuery();
            while (rs.next()) {
                Schedule model = new Schedule();
                model.setId(rs.getInt("id"));
                model.setSnumber(rs.getInt("snumber"));
                model.setVisit(rs.getString("visit"));
                model.setColdate(rs.getDate("coldate"));
                model.setColtime(rs.getTime("timecol"));
                model.setParasitemia(rs.getInt("parasitemia"));
                model.setGenotyping(rs.getInt("genotype"));
                model.setImmunogenecity(rs.getInt("immunogenecity"));
                model.setHaemoglobin(rs.getDouble("hemo"));
                model.setAlt(rs.getInt("alt"));
                model.setCreatinine(rs.getInt("creatine"));
                model.setWbc(rs.getDouble("wbc"));
                model.setPlatelets(rs.getInt("plates"));
                data.add(model);
            }
        } catch (SQLException ex) {
            Logger.getLogger(DBConnect.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
        return data;
    }  
    
  

}
