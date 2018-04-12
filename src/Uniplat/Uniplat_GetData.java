/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Uniplat;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import models.Fitbit_HeartrateDetailModel;
import models.Fitbit_HeartrateModel;
import models.Fitbit_ActivityModel;
import models.Fitbit_SleepModel;
import models.Fitbit_ActivityDetailModel;
import models.Fitbit_DeviceModel;

/**
 *
 * @author Yang
 */
public class Uniplat_GetData {

    public static void Fitbitac_to_Uniac(String user, Fitbit_ActivityModel data, String date) throws SQLException {

        Uniplat_ActivityModel uni = new Uniplat_ActivityModel();
        uni.summary.setActiveScore(data.summary.getActiveScore());
        uni.summary.setActivityCalories(data.summary.getActivityCalories());
        uni.summary.setCaloriesBMR(data.summary.getCaloriesBMR());
        uni.summary.setElevation(data.summary.getElevation());
        uni.summary.setFairlyActiveMinutes(data.summary.getFairlyActiveMinutes());
        uni.summary.setFloors(data.summary.getFloors());
        uni.summary.setLightlyActiveMinutes(data.summary.getLightlyActiveMinutes());
        uni.summary.setMarginalCalories(data.summary.getMarginalCalories());
        uni.summary.setRestingHeartRate(data.summary.getRestingHeartRate());
        uni.summary.setSedentaryMinutes(data.summary.getSedentaryMinutes());
        uni.summary.setSteps(data.summary.getSteps());
        uni.summary.setVeryActiveMinutes(data.summary.getVeryActiveMinutes());
        Uniplat_decoder.decode_activities(user, uni, date);

    }

    public static void FitbitDevices_to_UniDevices(String user, Fitbit_DeviceModel[] data, String date) throws SQLException {
        System.out.println(data.length);
        List<Uniplat_DevicesModel> uni=new ArrayList();
        //System.out.println(uni[0].battery);
        //uni[0].setBattery(data[0].getBattery());
        for (int i = 0; i < data.length; i++) {
            //uni[i].getBattery();
            uni.add(new Uniplat_DevicesModel());
            uni.get(i).setBattery(data[i].getBattery());

            uni.get(i).setDeviceVersion(data[i].getDeviceVersion());
            uni.get(i).setID(data[i].getID());
            uni.get(i).setLastSyncTime(data[i].getLastSyncTime());
            uni.get(i).setMac(data[i].getMac());
            uni.get(i).setType(data[i].getType());
        }/**/

      // Uniplat_decoder.decode_device( uni,user, date);

    }

    public static void Fitbitminac_to_Uniminac(String user, Fitbit_ActivityDetailModel data, String id) throws SQLException {
        if ("calories".equals(id)) {
            Uniplat_ActivityDetailModel uni = new Uniplat_ActivityDetailModel(data.calories.size(), data.calories_detail.dataset.size());
            for (int i = 0; i < data.calories.size(); i++) {
                uni.calories.get(i).setDateTime(data.calories.get(i).getDateTime());
            }
            for (int i = 0; i < data.calories_detail.dataset.size(); i++) {
                uni.calories_detail.dataset.get(i).setime(data.calories_detail.dataset.get(i).getTime());
                uni.calories_detail.dataset.get(i).setValue(data.calories_detail.dataset.get(i).getValue());
                uni.calories_detail.setdatasetType(data.calories_detail.getdatasetType());

            }
            Uniplat_decoder.decode_minute_ac(uni, user, id);
        }
        if ("steps".equals(id)) {
            Uniplat_ActivityDetailModel uni = new Uniplat_ActivityDetailModel(data.steps.size(), data.steps_detail.dataset.size());
            for (int i = 0; i < data.steps.size(); i++) {
                uni.steps.get(i).setDateTime(data.steps.get(i).getDateTime());
            }
            for (int i = 0; i < data.steps_detail.dataset.size(); i++) {
                uni.steps_detail.dataset.get(i).setime(data.steps_detail.dataset.get(i).getTime());
                uni.steps_detail.dataset.get(i).setValue(data.steps_detail.dataset.get(i).getValue());
                uni.steps_detail.setdatasetType(data.steps_detail.getdatasetType());

            }
            Uniplat_decoder.decode_minute_ac(uni, user, id);
        }
        if ("distance".equals(id)) {
            Uniplat_ActivityDetailModel uni = new Uniplat_ActivityDetailModel(data.distance.size(), data.distance_detail.dataset.size());
            for (int i = 0; i < data.distance.size(); i++) {
                uni.distance.get(i).setDateTime(data.distance.get(i).getDateTime());
            }
            for (int i = 0; i < data.distance_detail.dataset.size(); i++) {
                uni.distance_detail.dataset.get(i).setime(data.distance_detail.dataset.get(i).getTime());
                uni.distance_detail.dataset.get(i).setValue(data.distance_detail.dataset.get(i).getValue());
                uni.distance_detail.setdatasetType(data.distance_detail.getdatasetType());
            }
            Uniplat_decoder.decode_minute_ac(uni, user, id);
        }
        if ("floors".equals(id)) {
            Uniplat_ActivityDetailModel uni = new Uniplat_ActivityDetailModel(data.floors.size(), data.floors_detail.dataset.size());
            for (int i = 0; i < data.floors.size(); i++) {
                uni.floors.get(i).setDateTime(data.floors.get(i).getDateTime());
            }
            for (int i = 0; i < data.floors_detail.dataset.size(); i++) {
                uni.floors_detail.dataset.get(i).setime(data.floors_detail.dataset.get(i).getTime());
                uni.floors_detail.dataset.get(i).setValue(data.floors_detail.dataset.get(i).getValue());
                uni.floors_detail.setdatasetType(data.floors_detail.getdatasetType());
            }
            Uniplat_decoder.decode_minute_ac(uni, user, id);
        }
        if ("elevation".equals(id)) {
            Uniplat_ActivityDetailModel uni = new Uniplat_ActivityDetailModel(data.elevation.size(), data.elevation_detail.dataset.size());
            for (int i = 0; i < data.elevation.size(); i++) {
                uni.elevation.get(i).setDateTime(data.elevation.get(i).getDateTime());
            }
            for (int i = 0; i < data.elevation_detail.dataset.size(); i++) {
                uni.elevation_detail.dataset.get(i).setime(data.elevation_detail.dataset.get(i).getTime());
                uni.elevation_detail.dataset.get(i).setValue(data.elevation_detail.dataset.get(i).getValue());
                uni.elevation_detail.setdatasetType(data.elevation_detail.getdatasetType());
            }
            Uniplat_decoder.decode_minute_ac(uni, user, id);
        }

    }

    public static void FitbitHeatrate_to_UniHeatrate(Fitbit_HeartrateModel data, String user) throws SQLException {

        Uniplat_HeartrateModel[] uni = new Uniplat_HeartrateModel[data.heart.size()];
        for (int i = 0; i < data.heart.size(); i++) {
            uni[i] = new Uniplat_HeartrateModel(data.heart.get(i).value.heartRateZones.size());
        }
        for (int i = 0; i < data.heart.size(); i++) {
            uni[i].heart.get(0).setDateTime(data.heart.get(i).getDateTime());
            for (int j = 0; j < data.heart.get(0).value.heartRateZones.size(); j++) {
                uni[i].heart.get(0).value.heartRateZones.get(j).setMax(data.heart.get(i).value.heartRateZones.get(j).getMax());
                uni[i].heart.get(0).value.heartRateZones.get(j).setMin(data.heart.get(i).value.heartRateZones.get(j).getMin());
                uni[i].heart.get(0).value.heartRateZones.get(j).setCaloriesOut(data.heart.get(i).value.heartRateZones.get(j).getCaloriesOut());
                uni[i].heart.get(0).value.heartRateZones.get(j).setName(data.heart.get(i).value.heartRateZones.get(j).getName());
            }
        }
        Uniplat_decoder.decode_heartrate(uni, user);

    }

    public static void FitbitDetailHeatrate_to_UniDetailHeatrate(Fitbit_HeartrateDetailModel data, String user) throws SQLException {

        Uniplat_HeartrateDetailModel uni = new Uniplat_HeartrateDetailModel(data.heart.size(), data.heartrateDetail.dataset.size());

        for (int i = 0; i < data.heart.size(); i++) {
            uni.heart.get(i).setDateTime(data.heart.get(i).getDateTime());
        }
        for (int i = 0; i < data.heartrateDetail.dataset.size(); i++) {
            uni.heartrateDetail.dataset.get(i).setTime(data.heartrateDetail.dataset.get(i).getTime());
            uni.heartrateDetail.dataset.get(i).setValue(data.heartrateDetail.dataset.get(i).getValue());
            uni.heartrateDetail.setDatasetType(data.heartrateDetail.getDatasetType());

        }
        Uniplat_decoder.decode_intraday(uni, user);
    }

    public static void FitbitSleep_to_UniSleep(Fitbit_SleepModel data, String user) throws SQLException {

        Uniplat_SleepModel[] uni = new Uniplat_SleepModel[data.sleep.size()];

        for (int i = 0; i < data.sleep.size(); i++) {
            uni[i] = new Uniplat_SleepModel(data.sleep.get(i).minuteData.size());
        }
        for (int i = 0; i < data.sleep.size(); i++) {
            uni[i].sleep.get(0).setAwakeCount(data.sleep.get(i).getAwakeCount());
            uni[i].sleep.get(0).setStartTime(data.sleep.get(i).getStartTime());
            uni[i].sleep.get(0).setAwakeDuration(data.sleep.get(i).getAwakeDuration());
            uni[i].sleep.get(0).setAwakeningsCount(data.sleep.get(i).getAwakeningsCount());
            uni[i].sleep.get(0).setDuration(data.sleep.get(i).getDuration());
            uni[i].sleep.get(0).setEfficiency(data.sleep.get(i).getEfficiency());
            uni[i].sleep.get(0).setMinutesAfterWakeup(data.sleep.get(i).getMinutesAfterWakeup());
            uni[i].sleep.get(0).setMinutesAsleep(data.sleep.get(i).getMinutesAsleep());
            uni[i].sleep.get(0).setMinutesAwake(data.sleep.get(i).getMinutesAwake());
            uni[i].sleep.get(0).setMinutesToFallAsleep(data.sleep.get(i).getMinutesToFallAsleep());
            uni[i].sleep.get(0).setRestlessCount(data.sleep.get(i).getRestlessCount());
            uni[i].sleep.get(0).setRestlessDuration(data.sleep.get(i).getRestlessDuration());
            uni[i].sleep.get(0).setLogId(data.sleep.get(i).getLogId());
            uni[i].sleep.get(0).setDateOfSleep(data.sleep.get(i).getDateOfSleep());

            for (int j = 0; j < data.sleep.get(i).minuteData.size(); j++) {
                uni[i].sleep.get(0).minuteData.get(j).setDateTime(data.sleep.get(i).minuteData.get(j).getDateTime());
                uni[i].sleep.get(0).minuteData.get(j).setValue(data.sleep.get(i).minuteData.get(j).getValue());
            }

        }
        Uniplat_decoder.decode_sleep(uni, user);
    }

}
