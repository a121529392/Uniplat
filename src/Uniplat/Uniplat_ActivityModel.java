/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Uniplat;

import com.google.gson.annotations.SerializedName;
import java.io.Serializable;

/**
 *
 * @author Yang
 */
public class Uniplat_ActivityModel {
    

    @SerializedName("summary")
    public sum summary= new sum();




    class sum implements Serializable {

        @SerializedName("activeScore")
        private double activeScore;
        @SerializedName("activityCalories")
        private double activityCalories;
        @SerializedName("caloriesBMR")
        private double caloriesBMR;
        @SerializedName("elevation")
        private double elevation;
        @SerializedName("fairlyActiveMinutes")
        private double fairlyActiveMinutes;
        @SerializedName("floors")
        private double floors;
        @SerializedName("lightlyActiveMinutes")
        private double lightlyActiveMinutes;
        @SerializedName("marginalCalories")
        private double marginalCalories;
        @SerializedName("restingHeartRate")
        private double restingHeartRate;
        @SerializedName("sedentaryMinutes")
        private double sedentaryMinutes;
        @SerializedName("steps")
        private double steps;
        @SerializedName("veryActiveMinutes")
        private double veryActiveMinutes;

        public double getActiveScore() {
            return activeScore;
        }

        public void setActiveScore(double a) {
            this.activeScore = a;
        }

        public double getActivityCalories() {
            return activityCalories;
        }

        public void setActivityCalories(double activityCalories) {
            this.activityCalories = activityCalories;
        }

        public double getCaloriesBMR() {
            return caloriesBMR;
        }

        public void setCaloriesBMR(double caloriesBMR) {
            this.caloriesBMR = caloriesBMR;
        }

        public double getElevation() {
            return elevation;
        }

        public void setElevation(double elevation) {
            this.elevation = elevation;
        }

        public double getFairlyActiveMinutes() {
            return fairlyActiveMinutes;
        }

        public void setFairlyActiveMinutes(double fairlyActiveMinutes) {
            this.fairlyActiveMinutes = fairlyActiveMinutes;
        }

        public double getFloors() {
            return floors;
        }

        public void setFloors(double floors) {
            this.floors = floors;
        }

        public double getLightlyActiveMinutes() {
            return lightlyActiveMinutes;
        }

        public void setLightlyActiveMinutes(double lightlyActiveMinutes) {
            this.lightlyActiveMinutes = lightlyActiveMinutes;
        }

        public double getMarginalCalories() {
            return marginalCalories;
        }

        public void setMarginalCalories(double marginalCalories) {
            this.marginalCalories = marginalCalories;
        }

        public double getRestingHeartRate() {
            return restingHeartRate;
        }

        public void setRestingHeartRate(double restingHeartRate) {
            this.restingHeartRate = restingHeartRate;
        }

        public double getSedentaryMinutes() {
            return sedentaryMinutes;
        }

        public void setSedentaryMinutes(double sedentaryMinutes) {
            this.sedentaryMinutes = sedentaryMinutes;
        }

        public double getSteps() {
            return steps;
        }

        public void setSteps(double steps) {
            this.steps = steps;
        }

        public double getVeryActiveMinutes() {
            return veryActiveMinutes;
        }

        public void setVeryActiveMinutes(double veryActiveMinutes) {
            this.veryActiveMinutes = veryActiveMinutes;
        }
    }

}
