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
public class Uniplat_HeartrateDetailModel {

    public Uniplat_HeartrateDetailModel(int size,int size1) {
        for(int i=0;i<size;i++){
            this.heart.add(new heart());
        }
        for(int i=0;i<size1;i++){
            this.heartrateDetail.dataset.add(new dataset());
        }
    }
    
    @SerializedName("activities-heart")
    List<heart> heart=new ArrayList<heart>(); 
    @SerializedName("activities-heart-intraday")
    heartdetail heartrateDetail=new heartdetail();    
    class heart implements Serializable{
        @SerializedName("dateTime")
        private String dateTime;
        public String getDateTime() {
            return dateTime;
        }
        public void setDateTime(String dateTime) {
            this.dateTime = dateTime;
        }
    }
    class heartdetail implements Serializable{
        @SerializedName("dataset")
        List<dataset> dataset=new ArrayList<dataset>();
        @SerializedName("datasetInterval")
        private String datasetInterval;
        @SerializedName("datasetType")
        private String datasetType;
        public String getDatasetInterval() {
            return datasetInterval;
        }
        public void setDatasetInterval(String datasetInterval) {
            this.datasetInterval = datasetInterval;
        }
        public String getDatasetType() {
            return datasetType;
        }
        public void setDatasetType(String datasetType) {
            this.datasetType = datasetType;
        }        
    }    
    class dataset implements Serializable{
        @SerializedName("time")
        private String time;
        @SerializedName("value")
        private double value;
        public String getTime() {
            return time;
        }
        public void setTime(String time) {
            this.time = time;
        }
        public double getValue() {
            return value;
        }
        public void setValue(double value) {
            this.value = value;
        }        
    }
    
}
