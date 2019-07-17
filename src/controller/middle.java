/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import javafx.scene.control.ComboBox;

/**
 *
 * @author Kwaku Adjei <duncanadjei@gmail.com>
 */
public class middle {

     private static final middle MD = new middle();
     String backUpName;
      SimpleDateFormat simpleDateformat;
    private middle() {
    }

    public static middle md() {
        return MD;
    }
    

    public java.sql.Date getCoverted(String... data) throws ParseException {
        String time = data[0] + ":" + data[1];
         simpleDateformat = new SimpleDateFormat("hh:mm");
        java.util.Date date = simpleDateformat.parse(time);
        java.sql.Date toReturn = new java.sql.Date(date.getTime());
        return toReturn;
    }

    public boolean isFriday() {
        Date now = new Date();
         simpleDateformat = new SimpleDateFormat("E"); // the day of the week abbreviated
        System.out.println(simpleDateformat.format(now));
        return simpleDateformat.format(now).equals("Thu");
    }
    
    public String getBackUpName(){
        Date now = new Date();
         simpleDateformat = new SimpleDateFormat("E, dd-MMM-yyyy"); 
         return simpleDateformat.format(now);
    }
    
    

    public void backUpData() {
        String dbName = "lab_pro";
        String dbUser = "root";
        String dbPass = "";
        String path = "C:\\Users\\dell\\Documents\\Backup\\"+getBackUpName()+".sql";
        String executeCmd = "C:\\xampp\\mysql\\bin\\mysqldump "+dbName +" -u " + dbUser + " -p" + dbPass +"-r " + path;
        try {
            Process runtimeProcess = Runtime.getRuntime().exec(executeCmd);

            int processComplete = runtimeProcess.waitFor();
//            runtimeProcess.getOutputStream().write(13);
            if (processComplete == 0) {
                System.out.println("Backup taken successfully");
            } else {
                System.out.println("Could not take mysql backup");
            }
        } catch (IOException | InterruptedException ex) {
           ex.printStackTrace();
        }

    }
}
