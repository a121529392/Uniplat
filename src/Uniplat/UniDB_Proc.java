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
public class UniDB_Proc {

    /**
     * @param args the command line arguments
     */
    public static StringBuffer dayinsert(String date, String user, String data, double value, String startTime, StringBuffer sb, Check_DateTime_Name_User_Model checkdata) throws SQLException {
        java.util.Date time = new java.util.Date();
        StringBuffer checksb = new StringBuffer("insert into Summary(User_ID, DateTime, ID_Activity, Value, StartTime, Frequency,UpdateTime)" + " VALUES ");//insert data , put instruction in stringbuffer

        if (CheckRedundancy.Check_User_DateTime_Name(checkdata, user, date, data)) {
            return sb;

        } else if (startTime.equals("NULL")) {
            if (sb.toString().equals(checksb.toString())) {
                sb.append("(").append('"').append(user).append('"').append(",").append('"').append(date).append('"').append(",").append('"').append(data).append('"').append(",").append(value).append(",").append(startTime).append(",").append('"').append("Day").append('"').append(",").append('"').append(time.toString()).append('"').append(")");
            } else {
                sb.append(",(").append('"').append(user).append('"').append(",").append('"').append(date).append('"').append(",").append('"').append(data).append('"').append(",").append(value).append(",").append(startTime).append(",").append('"').append("Day").append('"').append(",").append('"').append(time.toString()).append('"').append(")");
            }
        } else if (sb.toString().equals(checksb.toString())) {
            sb.append("(").append('"').append(user).append('"').append(",").append('"').append(date).append('"').append(",").append('"').append(data).append('"').append(",").append(value).append(",").append('"').append(startTime).append('"').append(",").append('"').append("Day").append('"').append(",").append('"').append(time.toString()).append('"').append(")");
        } else {
            sb.append(",(").append('"').append(user).append('"').append(",").append('"').append(date).append('"').append(",").append('"').append(data).append('"').append(",").append(value).append(",").append('"').append(startTime).append('"').append(",").append('"').append("Day").append('"').append(",").append('"').append(time.toString()).append('"').append(")");
        }
        return sb;
    }

    public static StringBuffer heartinsert(String user, String dateTime, String name, int max, int min, double cal, StringBuffer sb, Check_DateTime_Name_User_Model checkdata) throws SQLException {
        java.util.Date time = new java.util.Date();
        StringBuffer checksb = new StringBuffer("insert into Activity_Heart(USER_ID,DateTime,HeartrateName,Max,Min,CaloriesOut,UpdateTime)" + " VALUES ");

        if (CheckRedundancy.Check_User_DateTime_Name(checkdata, user, dateTime, name)) {
            return sb;

        } else {
            if (sb.toString().equals(checksb.toString())) {
                sb.append("(").append('"').append(user).append('"').append(",").append('"').append(dateTime).append('"').append(",").append('"').append(name).append('"').append(",").append(max).append(",").append(min).append(",").append(cal).append(",").append('"').append(time.toString()).append('"').append(")");
            } else {
                sb.append(",(").append('"').append(user).append('"').append(",").append('"').append(dateTime).append('"').append(",").append('"').append(name).append('"').append(",").append(max).append(",").append(min).append(",").append(cal).append(",").append('"').append(time.toString()).append('"').append(")");
            }
            System.out.println(sb);
            return sb;
        }

    }

    public static StringBuffer inheart_second(String user, String date, String startTime, String endTime, double value, String type, StringBuffer sb, Check_User_DateTime_StTime_EdTime_Model checkdata) throws SQLException {
        java.util.Date time = new java.util.Date();
        StringBuffer checksb = new StringBuffer("insert into Heartrate_Detail(User_Id  , DateTime , StartTime,EndTime , Value , Frequency,UpdateTime)" + " VALUES ");

        if (CheckRedundancy.Check_User_DateTime_StTime_EdTime(checkdata, user, date, startTime, endTime)) {
            return sb;

        } else {
            if (sb.toString().equals(checksb.toString())) {
                sb.append("(").append('"').append(user).append('"').append(",").append('"').append(date).append('"').append(",").append('"').append(startTime).append('"').append(",").append('"').append(endTime).append('"').append(",").append(value).append(",").append('"').append(type).append('"').append(",").append('"').append(time.toString()).append('"').append(")");
            } else {
                sb.append(",(").append('"').append(user).append('"').append(",").append('"').append(date).append('"').append(",").append('"').append(startTime).append('"').append(",").append('"').append(endTime).append('"').append(",").append(value).append(",").append('"').append(type).append('"').append(",").append('"').append(time.toString()).append('"').append(")");
            }
            return sb;
        }
    }

    public static StringBuffer acinsert(String user, String id, String dateTime, double value, String starttime, String endtime, String datasetType, StringBuffer sb, Check_User_DateTime_Name_StTime_EdTime_Model checkdata) throws SQLException {
        java.util.Date time1 = new java.util.Date();
        StringBuffer checksb = new StringBuffer("insert into Activity_Detail(User_ID , ID_ACTIVITY, DateTime ,  Value , StartTime,EndTime ,Frequency,UpdateTime)"
                + " VALUES ");
        if (CheckRedundancy.Check_User_DateTime_Name_StTime_EdTime(checkdata, user, dateTime, id, starttime, endtime)) {
            return sb;

        } else {

            if (sb.toString().equals(checksb.toString())) {
                sb.append("(").append('"').append(user).append('"').append(",").append('"').append(id).append('"').append(",").append('"').append(dateTime).append('"').append(",").append(value).append(",").append('"').append(starttime).append('"').append(",").append('"').append(endtime).append('"').append(",").append('"').append(datasetType).append('"').append(",").append('"').append(time1.toString()).append('"').append(")");
            } else {
                sb.append(",(").append('"').append(user).append('"').append(",").append('"').append(id).append('"').append(",").append('"').append(dateTime).append('"').append(",").append(value).append(",").append('"').append(starttime).append('"').append(",").append('"').append(endtime).append('"').append(",").append('"').append(datasetType).append('"').append(",").append('"').append(time1.toString()).append('"').append(")");
            }
            return sb;
        }
    }

    public static StringBuffer inSleepMinutesData(String dateOfSleep, String logId, String startTime, String endTime, double value, String user, StringBuffer sb, Check_User_DateTime_StTime_EdTime_Model checkdata) throws SQLException {
        java.util.Date time = new java.util.Date();
        StringBuffer checksb = new StringBuffer("insert into Sleep_Detail(User_Id , Log_ID , ID_Activity ,  DateTime , StartTime,EndTime , Value , Frequency,UpdateTime)" + " VALUES");

        if (CheckRedundancy.Check_User_DateTime_StTime_EdTime(checkdata, user, dateOfSleep, startTime, endTime)) {
            return sb;

        } else {
            if (sb.toString().equals(checksb.toString())) {
                sb.append("(").append('"').append(user).append('"').append(",").append('"').append(logId).append('"').append(",").append('"').append("minuteData").append('"').append(",").append('"').append(dateOfSleep).append('"').append(",").append('"').append(startTime).append('"').append(",").append('"').append(endTime).append('"').append(",").append(value).append(",").append('"').append("minutes").append('"').append(",").append('"').append(time.toString()).append('"').append(")");
            } else {
                sb.append(",(").append('"').append(user).append('"').append(",").append('"').append(logId).append('"').append(",").append('"').append("minuteData").append('"').append(",").append('"').append(dateOfSleep).append('"').append(",").append('"').append(startTime).append('"').append(",").append('"').append(endTime).append('"').append(",").append(value).append(",").append('"').append("minutes").append('"').append(",").append('"').append(time.toString()).append('"').append(")");
            }
            return sb;
        }

    }

    public static StringBuffer deviceinsert(String user, String date, String battery, String deviceVersion, String id, String lastSyncTime, String mac, String type, StringBuffer sb, String[] checkdata) throws SQLException {
        java.util.Date time = new java.util.Date();
        StringBuffer checksb = new StringBuffer("insert into Devices(User_ID, DateTime, Battery, DeviceVersion, ID, LastSyncTime, Mac, Type,UpdateTime)" + " VALUES ");

        if (CheckRedundancy.Check_Devices(checkdata, id)) {
            StringBuffer updatesb = new StringBuffer("UPDATE Devices set Battery = ").append('"').append(battery).append('"').append(",").append("UpdateTime=").append('"').append(time.toString()).append('"')
                    .append("where ID=").append('"').append(id).append('"');
            sb = updatesb;
            return sb;

        } else {
            if (sb.toString().equals(checksb.toString())) {
                sb.append("(").append('"').append(user).append('"').append(",").append('"').append(date).append('"').append(",").append('"').append(battery).append('"').append(",").append('"').append(deviceVersion).append('"')
                        .append(",").append('"').append(id).append('"').append(",").append('"').append(lastSyncTime).append('"').append(",").append('"').append(mac).append('"').append(",").append('"').append(type).append('"')
                        .append(",").append('"').append(time.toString()).append('"').append(")");
            } else {
                sb.append(",(").append('"').append(user).append('"').append(",").append('"').append(date).append('"').append(",").append('"').append(battery).append('"').append(",").append('"').append(deviceVersion)
                        .append('"').append(",").append('"').append(id).append('"').append(",").append('"').append(lastSyncTime).append('"').append(",").append('"').append(mac).append('"').append(",").append('"')
                        .append(type).append('"').append(",").append('"').append(time.toString()).append('"').append(")");
            }
            return sb;
        }
    }

}
