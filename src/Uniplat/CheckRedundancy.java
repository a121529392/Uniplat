/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Uniplat;

import java.sql.SQLException;
import java.util.Vector;
import models.Check_DateTime_Name_User_Model;
import models.Check_User_DateTime_Name_StTime_EdTime_Model;
import models.Check_User_DateTime_StTime_EdTime_Model;

/**
 *
 * @author Yang
 */
public class CheckRedundancy {

    static boolean Check_User_DateTime_Name(Check_DateTime_Name_User_Model data, String user, String date, String name) throws SQLException {
        if (data.dateTime.length == 0) {
            return false;
        }

        for (int i = 0; i < data.dateTime.length; i++) {
            if (data.dateTime[i].equals(date) && data.name[i].equals(name) && data.user[i].equals(user)) {
                return true;
            }
        }
        return false;

    }

    static boolean Check_Devices(String[] data, String id) throws SQLException {
        if (data.length == 0) {
            return false;
        }

        for (int i = 0; i < data.length; i++) {
            if (data[i].equals(id)) {
                return true;
            }
        }
        return false;

    }

    public static boolean Check_User_DateTime_Name_StTime_EdTime(Check_User_DateTime_Name_StTime_EdTime_Model data, String user, String date, String name, String sttime, String edtime) throws SQLException {
        if (data.dateTime.length == 0) {
            return false;
        }
        for (int i = 0; i < data.dateTime.length; i++) {
            if (data.dateTime[i].equals(date) && data.name[i].equals(name) && data.user[i].equals(user) && data.starttime[i].equals(sttime) && data.endtime[i].equals(edtime)) {
                return true;
            }
        }
        return false;

    }

    public static boolean Check_User_DateTime_StTime_EdTime(Check_User_DateTime_StTime_EdTime_Model data, String user, String date, String sttime, String edtime) throws SQLException {
        if (data.dateTime.length == 0) {
            return false;
        }
        for (int i = 0; i < data.dateTime.length; i++) {
            if (data.dateTime[i].equals(date) && data.user[i].equals(user) && data.starttime[i].equals(sttime) && data.endtime[i].equals(edtime)) {
                return true;
            }
        }
        return false;

    }

}
