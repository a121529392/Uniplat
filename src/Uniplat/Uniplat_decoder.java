/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Uniplat;

import com.google.gson.Gson;
import java.sql.SQLException;
import java.util.List;
import models.Check_DateTime_Name_User_Model;
import models.Check_User_DateTime_Name_StTime_EdTime_Model;
import models.Check_User_DateTime_StTime_EdTime_Model;

/**
 *
 * @author Yang
 */
public class Uniplat_decoder {

    public static void decode_activities(String user, Uniplat_ActivityModel data, String date) throws SQLException {
        StringBuffer sb = new StringBuffer("insert into Summary(User_ID, DateTime, ID_Activity, Value, StartTime, Frequency,UpdateTime)" + " VALUES ");//insert data , put instruction in stringbuffer
        StringBuffer checksb = new StringBuffer("insert into Summary(User_ID, DateTime, ID_Activity, Value, StartTime, Frequency,UpdateTime)" + " VALUES ");//insert data , put instruction in stringbuffer
        Check_DateTime_Name_User_Model checkdata = new Check_DateTime_Name_User_Model();
        checkdata = MySQLConnector.Check_Uniplat_Summary(user,date);
        Gson gson = new Gson();
        config c = new config();

        sb = UniDB_Proc.dayinsert( date, user, "activeScore", data.summary.getActiveScore(), "NULL", sb, checkdata);
        sb = UniDB_Proc.dayinsert( date, user, "activityCalories", data.summary.getActivityCalories(), "NULL", sb, checkdata);
        sb = UniDB_Proc.dayinsert( date, user, "caloriesBMR", data.summary.getCaloriesBMR(), "NULL", sb, checkdata);
        sb = UniDB_Proc.dayinsert( date, user, "elevation", data.summary.getElevation(), "NULL", sb, checkdata);
        sb = UniDB_Proc.dayinsert( date, user, "fairlyActiveMinutes", data.summary.getFairlyActiveMinutes(), "NULL", sb, checkdata);
        sb = UniDB_Proc.dayinsert( date, user, "floors", data.summary.getFloors(), "NULL", sb, checkdata);
        sb = UniDB_Proc.dayinsert( date, user, "lightlyActiveMinutes", data.summary.getLightlyActiveMinutes(), "NULL", sb, checkdata);
        sb = UniDB_Proc.dayinsert( date, user, "marginalCalories", data.summary.getMarginalCalories(), "NULL", sb, checkdata);
        sb = UniDB_Proc.dayinsert( date, user, "restingHeartRate", data.summary.getRestingHeartRate(), "NULL", sb, checkdata);
        sb = UniDB_Proc.dayinsert( date, user, "sedentaryMinutes", data.summary.getSedentaryMinutes(), "NULL", sb, checkdata);
        sb = UniDB_Proc.dayinsert( date, user, "steps", data.summary.getSteps(), "NULL", sb, checkdata);
        sb = UniDB_Proc.dayinsert( date, user, "veryActiveMinutes", data.summary.getVeryActiveMinutes(), "NULL", sb, checkdata);
        if (!sb.toString().equals(checksb.toString())) {
            MySQLConnector.insertdata(sb, c);//connect mysQl , insert data to mysQl
        }
    }
    public static void decode_device(List<Uniplat_DevicesModel> data ,String user, String date) throws  SQLException {
        StringBuffer sb = new StringBuffer("insert into Devices(User_ID, DateTime, Battery, DeviceVersion, ID, LastSyncTime, Mac, Type,UpdateTime)" + " VALUES ");//insert data , put instruction in stringbuffer
        StringBuffer checksb = new StringBuffer("insert into Devices(User_ID, DateTime, Battery, DeviceVersion, ID, LastSyncTime, Mac, Type,UpdateTime)" + " VALUES ");
        Gson gson = new Gson();
        config c = new config();
        String[] checkdata;
        checkdata = MySQLConnector.Check_devices();
        for(int i=0;i<data.size();i++){
            sb=UniDB_Proc.deviceinsert(user, date, data.get(i).getBattery(), data.get(i).getDeviceVersion(), data.get(i).getID(), data.get(i).getLastSyncTime(), data.get(i).getMac(), data.get(i).getType(), sb,checkdata);        
        }
        if (!sb.toString().equals(checksb.toString())) {
            System.out.println(sb);
            MySQLConnector.insertdata(sb, c);//insert data
        }
        
    }
    public static void decode_minute_ac(Uniplat_ActivityDetailModel data, String user, String id) throws SQLException {

        Gson gson = new Gson();
        config c = new config();

        StringBuffer sb = new StringBuffer("insert into Activity_Detail(User_ID , ID_ACTIVITY, DateTime ,  Value , StartTime,EndTime ,Frequency,UpdateTime)"
                + " VALUES ");
        StringBuffer checksb = new StringBuffer("insert into Activity_Detail(User_ID , ID_ACTIVITY, DateTime ,  Value , StartTime,EndTime ,Frequency,UpdateTime)"
                + " VALUES ");
        Check_User_DateTime_Name_StTime_EdTime_Model checkdata = new Check_User_DateTime_Name_StTime_EdTime_Model();
        checkdata = MySQLConnector.Check_Uniplat_Activity_Detail(user,id);
        if ("calories".equals(id)) {//cause detaildata have many choice , so we must choice one
            for (int i = 0; i < data.calories_detail.dataset.size() ; i++) {
                sb = UniDB_Proc.acinsert( user, id, data.calories.get(0).getDateTime(), data.calories_detail.dataset.get(i).getValue(), data.calories_detail.dataset.get(i).getTime(), data.calories_detail.dataset.get(i).getTime(), data.calories_detail.getdatasetType(), sb, checkdata);

            }
        }
        if ("steps".equals(id)) {
            for (int i = 0; i < data.steps_detail.dataset.size() - 1; i++) {
                sb = UniDB_Proc.acinsert( user, id, data.steps.get(0).getDateTime(), data.steps_detail.dataset.get(i).getValue(), data.steps_detail.dataset.get(i).getTime(), data.steps_detail.dataset.get(i).getTime(), data.steps_detail.getdatasetType(), sb, checkdata);
            
            }
        }
        if ("distance".equals(id)) {
            for (int i = 0; i < data.distance_detail.dataset.size() - 1; i++) {
                sb = UniDB_Proc.acinsert( user, id, data.distance.get(0).getDateTime(), data.distance_detail.dataset.get(i).getValue(), data.distance_detail.dataset.get(i).getTime(), data.distance_detail.dataset.get(i).getTime(), data.distance_detail.getdatasetType(), sb, checkdata);
            }
        }
        if ("floors".equals(id)) {
            for (int i = 0; i < data.floors_detail.dataset.size() - 1; i++) {
                sb = UniDB_Proc.acinsert( user, id, data.floors.get(0).getDateTime(), data.floors_detail.dataset.get(i).getValue(), data.floors_detail.dataset.get(i).getTime(), data.floors_detail.dataset.get(i).getTime(), data.floors_detail.getdatasetType(), sb, checkdata);
            }
        }
        if ("elevation".equals(id)) {
            for (int i = 0; i < data.elevation_detail.dataset.size() - 1; i++) {
                sb = UniDB_Proc.acinsert( user, id, data.elevation.get(0).getDateTime(), data.elevation_detail.dataset.get(i).getValue(), data.elevation_detail.dataset.get(i).getTime(), data.elevation_detail.dataset.get(i).getTime(), data.elevation_detail.getdatasetType(), sb, checkdata);
            }
        }
        if (!sb.toString().equals(checksb.toString())) {
            //System.out.println(sb);
            MySQLConnector.insertdata(sb, c);//connect mysQl , insert data to mysQl
        }

    }

    public static void decode_heartrate(Uniplat_HeartrateModel[] data, String user) throws SQLException {
        StringBuffer sb = new StringBuffer("insert into Activity_Heart(USER_ID,DateTime,HeartrateName,Max,Min,CaloriesOut,UpdateTime)" + " VALUES ");
        StringBuffer checksb = new StringBuffer("insert into Activity_Heart(USER_ID,DateTime,HeartrateName,Max,Min,CaloriesOut,UpdateTime)" + " VALUES ");
        Check_DateTime_Name_User_Model checkdata = new Check_DateTime_Name_User_Model();

        config c = new config();

        for (int i = 0; i < data.length; i++) {//decode data to stringbuffer
                    checkdata = MySQLConnector.Check_uniplat_Activity_Heart(user,data[i].heart.get(0).getDateTime());
            for (int j = 0; j < data[i].heart.get(0).value.heartRateZones.size(); j++) {
                sb = UniDB_Proc.heartinsert(user, data[i].heart.get(0).getDateTime(), data[i].heart.get(0).value.heartRateZones.get(j).getName(), data[i].heart.get(0).value.heartRateZones.get(j).getMax(), data[i].heart.get(0).value.heartRateZones.get(j).getMin(), data[i].heart.get(0).value.heartRateZones.get(j).getCaloriesOut(), sb, checkdata);
            }
        }
        if (!sb.toString().equals(checksb.toString())) {
            MySQLConnector.insertdata(sb, c);//connect mysQl , insert data to mysQl
        }
    }

    public static void decode_intraday(Uniplat_HeartrateDetailModel data, String user) throws SQLException {
        StringBuffer sb = new StringBuffer("insert into Heartrate_Detail(User_Id  , DateTime , StartTime,EndTime , Value , Frequency,UpdateTime)" + " VALUES ");
        StringBuffer checksb = new StringBuffer("insert into Heartrate_Detail(User_Id  , DateTime , StartTime,EndTime , Value , Frequency,UpdateTime)" + " VALUES ");
        Check_User_DateTime_StTime_EdTime_Model checkdata = new Check_User_DateTime_StTime_EdTime_Model();
        checkdata = MySQLConnector.Check_uniplat_Heartrate_Detail(user,data.heart.get(0).getDateTime());
        config c = new config();
        for (int k = 0; k < data.heartrateDetail.dataset.size(); k++) {
            sb = UniDB_Proc.inheart_second( user, data.heart.get(0).getDateTime(), data.heartrateDetail.dataset.get(k).getTime(), data.heartrateDetail.dataset.get(k).getTime(), data.heartrateDetail.dataset.get(k).getValue(), data.heartrateDetail.getDatasetType(), sb, checkdata);
        }
        if (!sb.toString().equals(checksb.toString())) {
            MySQLConnector.insertdata(sb, c);//connect mysQl , insert data to mysQl
        }

    }

    public static void decode_sleep(Uniplat_SleepModel[] data, String user) throws SQLException {

        config c = new config();

        StringBuffer sb1 = new StringBuffer("insert into Sleep_Detail(User_Id , Log_ID , ID_Activity ,  DateTime , StartTime,EndTime , Value , Frequency,UpdateTime)" + " VALUES");
        StringBuffer sb = new StringBuffer("insert into Summary(User_ID, DateTime, ID_Activity, Value, StartTime, Frequency,UpdateTime)" + " VALUES ");
        StringBuffer checksb1 = new StringBuffer("insert into Sleep_Detail(User_Id , Log_ID , ID_Activity ,  DateTime , StartTime,EndTime , Value , Frequency,UpdateTime)" + " VALUES");
        StringBuffer checksb = new StringBuffer("insert into Summary(User_ID, DateTime, ID_Activity, Value, StartTime, Frequency,UpdateTime)" + " VALUES ");
        Check_User_DateTime_StTime_EdTime_Model checkdata1 = new Check_User_DateTime_StTime_EdTime_Model();
        
        Check_DateTime_Name_User_Model checkdata = new Check_DateTime_Name_User_Model();
        
        for (int i = 0; i < data.length; i++) {
            checkdata = MySQLConnector.Check_Uniplat_Summary(user,data[i].sleep.get(0).getDateOfSleep());
            sb = UniDB_Proc.dayinsert( data[i].sleep.get(0).getDateOfSleep(), user, "awakeCount", data[i].sleep.get(0).getAwakeCount(), data[i].sleep.get(0).getStartTime(), sb,checkdata);
            sb = UniDB_Proc.dayinsert( data[i].sleep.get(0).getDateOfSleep(), user, "awakeningsCount", data[i].sleep.get(0).getAwakeningsCount(), data[i].sleep.get(0).getStartTime(), sb,checkdata);
            sb = UniDB_Proc.dayinsert( data[i].sleep.get(0).getDateOfSleep(), user, "duration", data[i].sleep.get(0).getDuration(), data[i].sleep.get(0).getStartTime(), sb,checkdata);
            sb = UniDB_Proc.dayinsert( data[i].sleep.get(0).getDateOfSleep(), user, "awakeDuration", data[i].sleep.get(0).getAwakeDuration(), data[i].sleep.get(0).getStartTime(), sb,checkdata);
            sb = UniDB_Proc.dayinsert( data[i].sleep.get(0).getDateOfSleep(), user, "efficiency", data[i].sleep.get(0).getEfficiency(), data[i].sleep.get(0).getStartTime(), sb,checkdata);
            sb = UniDB_Proc.dayinsert( data[i].sleep.get(0).getDateOfSleep(), user, "minutesAfterWakeup", data[i].sleep.get(0).getMinutesAfterWakeup(), data[i].sleep.get(0).getStartTime(), sb,checkdata);
            sb = UniDB_Proc.dayinsert( data[i].sleep.get(0).getDateOfSleep(), user, "minutesAsleep", data[i].sleep.get(0).getMinutesAsleep(), data[i].sleep.get(0).getStartTime(), sb,checkdata);
            sb = UniDB_Proc.dayinsert( data[i].sleep.get(0).getDateOfSleep(), user, "minutesAwake", data[i].sleep.get(0).getMinutesAwake(), data[i].sleep.get(0).getStartTime(), sb,checkdata);
            sb = UniDB_Proc.dayinsert( data[i].sleep.get(0).getDateOfSleep(), user, "minutesToFallAsleep", data[i].sleep.get(0).getMinutesToFallAsleep(), data[i].sleep.get(0).getStartTime(), sb,checkdata);
            sb = UniDB_Proc.dayinsert( data[i].sleep.get(0).getDateOfSleep(), user, "restlessCount", data[i].sleep.get(0).getRestlessCount(), data[i].sleep.get(0).getStartTime(), sb,checkdata);
            sb = UniDB_Proc.dayinsert( data[i].sleep.get(0).getDateOfSleep(), user, "restlessDuration", data[i].sleep.get(0).getRestlessDuration(), data[i].sleep.get(0).getStartTime(), sb,checkdata);
            checkdata1 = MySQLConnector.Check_uniplat_Sleep_Detial(user,data[i].sleep.get(0).getDateOfSleep());
            for (int j = 0; j < data[i].sleep.get(0).minuteData.size(); j++) {
                
                sb1 = UniDB_Proc.inSleepMinutesData(data[i].sleep.get(0).getDateOfSleep(), data[i].sleep.get(0).getLogId(), data[i].sleep.get(0).minuteData.get(j).getDateTime(), data[i].sleep.get(0).minuteData.get(j).getDateTime(), data[i].sleep.get(0).minuteData.get(j).getValue(), user, sb1,checkdata1);
            }

        }
        System.out.println("Here sb1: "+sb1);
        System.out.println("Here checksb1: "+checksb1);
         System.out.println(sb1.toString().equals(checksb1.toString()));
        if (!sb.toString().equals(checksb.toString())) {
            MySQLConnector.insertdata(sb, c);//connect mysQl , insert data to mysQl
        }
        if (!sb1.toString().equals(checksb1.toString())) {
            MySQLConnector.insertdata(sb1, c);//connect mysQl , insert data to mysQl
        }

    }

}
