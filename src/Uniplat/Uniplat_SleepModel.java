/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Uniplat;

import com.google.gson.annotations.SerializedName;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Yang
 */
public class Uniplat_SleepModel {

    public Uniplat_SleepModel(int size) {
        this.sleep.add(new sleep());
        for(int i=0;i<size;i++){
            this.sleep.get(0).minuteData.add(new minuteData());
        }
    }

    @SerializedName("sleep")
    List<sleep> sleep = new ArrayList<sleep>();

    class sleep implements Serializable {

        @SerializedName("awakeCount")
        private double awakeCount;
        @SerializedName("awakeDuration")
        private double awakeDuration;
        @SerializedName("awakeningsCount")
        private double awakeningsCount;
        @SerializedName("dateOfSleep")
        private String dateOfSleep;
        @SerializedName("duration")
        private double duration;
        @SerializedName("efficiency")
        private double efficiency;
        @SerializedName("minuteData")
        List<minuteData> minuteData=new ArrayList<minuteData>();
        @SerializedName("minutesAfterWakeup")
        private double minutesAfterWakeup;
        @SerializedName("minutesAsleep")
        private double minutesAsleep;
        @SerializedName("minutesAwake")
        private double minutesAwake;
        @SerializedName("minutesToFallAsleep")
        private double minutesToFallAsleep;
        @SerializedName("restlessCount")
        private double restlessCount;
        @SerializedName("restlessDuration")
        private double restlessDuration;
        @SerializedName("startTime")
        private String startTime;
        @SerializedName("logId")
        private String logId;

        public String getLogId() {
            return logId;
        }

        public void setLogId(String logId) {
            this.logId = logId;
        }

        public String getStartTime() {
            return startTime;
        }

        public void setStartTime(String startTime) {
            this.startTime = startTime;
        }

        public double getAwakeCount() {
            return awakeCount;
        }

        public void setAwakeCount(double awakeCount) {
            this.awakeCount = awakeCount;
        }

        public double getAwakeDuration() {
            return awakeDuration;
        }

        public void setAwakeDuration(double awakeDuration) {
            this.awakeDuration = awakeDuration;
        }

        public double getAwakeningsCount() {
            return awakeningsCount;
        }

        public void setAwakeningsCount(double awakeningsCount) {
            this.awakeningsCount = awakeningsCount;
        }

        public String getDateOfSleep() {
            return dateOfSleep;
        }

        public void setDateOfSleep(String dateOfSleep) {
            this.dateOfSleep = dateOfSleep;
        }

        public double getDuration() {
            return duration;
        }

        public void setDuration(double duration) {
            this.duration = duration;
        }

        public double getEfficiency() {
            return efficiency;
        }

        public void setEfficiency(double efficiency) {
            this.efficiency = efficiency;
        }

        public double getRestlessDuration() {
            return restlessDuration;
        }

        public void setRestlessDuration(double restlessDuration) {
            this.restlessDuration = restlessDuration;
        }

        public double getMinutesAfterWakeup() {
            return minutesAfterWakeup;
        }

        public void setMinutesAfterWakeup(double minutesAfterWakeup) {
            this.minutesAfterWakeup = minutesAfterWakeup;
        }

        public double getMinutesAsleep() {
            return minutesAsleep;
        }

        public void setMinutesAsleep(double minutesAsleep) {
            this.minutesAsleep = minutesAsleep;
        }

        public double getMinutesAwake() {
            return minutesAwake;
        }

        public void setMinutesAwake(double minutesAwake) {
            this.minutesAwake = minutesAwake;
        }

        public double getMinutesToFallAsleep() {
            return minutesToFallAsleep;
        }

        public void setMinutesToFallAsleep(double minutesToFallAsleep) {
            this.minutesToFallAsleep = minutesToFallAsleep;
        }

        public double getRestlessCount() {
            return restlessCount;
        }

        public void setRestlessCount(double restlessCount) {
            this.restlessCount = restlessCount;
        }

    }

    class minuteData implements Serializable {

        @SerializedName("dateTime")
        private String dateTime;
        @SerializedName("value")
        private double value;

        public String getDateTime() {
            return dateTime;
        }

        public void setDateTime(String dateTime) {
            this.dateTime = dateTime;
        }

        public double getValue() {
            return value;
        }

        public void setValue(double value) {
            this.value = value;
        }
    }

}
