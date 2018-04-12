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
public class Uniplat_HeartrateModel {

    public Uniplat_HeartrateModel(int size1) {
            this.heart.add(new heart());
            for(int j=0;j<size1;j++){
                this.heart.get(0).value.heartRateZones.add(new heartrate());
            }
    }
    
    @SerializedName("activities-heart")
    List<heart> heart=new ArrayList<heart>(); 
    class heart implements Serializable{
        @SerializedName("dateTime")
        private String dateTime;
        @SerializedName("value")
        ValueType value=new ValueType();        
        public String getDateTime() {
            return dateTime;
        }
        public void setDateTime(String dateTime) {
            this.dateTime = dateTime;
        }
    }
    class ValueType implements Serializable{
        @SerializedName("heartRateZones")
        List<heartrate> heartRateZones=new ArrayList<heartrate>();
    }
    class heartrate implements Serializable{
        @SerializedName("caloriesOut")  
        private double caloriesOut;
        @SerializedName("max")
        private int max;
        @SerializedName("min")
        private int min;
        @SerializedName("minutes")
        private String minutes;
        @SerializedName("name")
        private String name;
        public double getCaloriesOut() {
            return caloriesOut;
        }
        public void setCaloriesOut(double caloriesOut) {
            this.caloriesOut = caloriesOut;
        }
         public int getMax() {
            return max;
        }
        public void setMax(int max) {
            this.max = max;
        }
        public int getMin() {
            return min;
        }
        public void setMin(int min) {
            this.min = min;
        }
        public String getMinutes() {
            return minutes;
        }
        public void setMinutes(String minutes) {
            this.minutes = minutes;
        }
        public String getName() {
            return name;
        }
        public void setName(String name) {
            this.name = name;
        }
    }
    
}
