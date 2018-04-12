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
public class Uniplat_ActivityDetailModel {

    public Uniplat_ActivityDetailModel(int size, int size2) {
        for (int i = 0; i < size; ++i) {
            this.calories.add(new datatype());
            for (int j = 0; j < size2; ++j) {
                this.calories_detail.dataset.add(new detail());
            }
        }
        for (int i = 0; i < size; ++i) {
            this.elevation.add(new datatype());
            for (int j = 0; j < size2; ++j) {
                this.elevation_detail.dataset.add(new detail());
            }
        }
        for (int i = 0; i < size; ++i) {
            this.steps.add(new datatype());
            for (int j = 0; j < size2; ++j) {
                this.steps_detail.dataset.add(new detail());
            }
        }
        for (int i = 0; i < size; ++i) {
            this.distance.add(new datatype());
            for (int j = 0; j < size2; ++j) {
                this.distance_detail.dataset.add(new detail());
            }
        }
        for (int i = 0; i < size; ++i) {
            this.floors.add(new datatype());
            for (int j = 0; j < size2; ++j) {
                this.floors_detail.dataset.add(new detail());
            }
        }

    }

    @SerializedName("activities-calories")
    List<datatype> calories = new ArrayList<datatype>();
    @SerializedName("activities-calories-intraday")
    detailtype calories_detail = new detailtype();
    @SerializedName("activities-elevation")
    List<datatype> elevation = new ArrayList<datatype>();
    @SerializedName("activities-elevation-intraday")
    detailtype elevation_detail = new detailtype();
    @SerializedName("activities-steps")
    List<datatype> steps = new ArrayList<datatype>();
    @SerializedName("activities-steps-intraday")
    detailtype steps_detail = new detailtype();
    @SerializedName("activities-distance")
    List<datatype> distance = new ArrayList<datatype>();
    @SerializedName("activities-distance-intraday")
    detailtype distance_detail = new detailtype();
    @SerializedName("activities-floors")
    List<datatype> floors = new ArrayList<datatype>();
    @SerializedName("activities-floors-intraday")
    detailtype floors_detail = new detailtype();

    class detailtype implements Serializable {

        @SerializedName("dataset")
        List<detail> dataset = new ArrayList<detail>();
        @SerializedName("datasetType")
        private String datasetType;

        public String getdatasetType() {
            return datasetType;
        }

        public void setdatasetType(String datasetType) {
            this.datasetType = datasetType;
        }
    }

    class detail implements Serializable {

        @SerializedName("time")
        private String time;
        @SerializedName("value")
        private double value;

        public String getTime() {
            return time;
        }

        public void setime(String time) {
            this.time = time;
        }

        public double getValue() {
            return value;
        }

        public void setValue(double value) {
            this.value = value;
        }
    }

    class datatype implements Serializable {

        @SerializedName("dateTime")
        private String dateTime;

        public String getDateTime() {
            return dateTime;
        }

        public void setDateTime(String dateTime) {
            this.dateTime = dateTime;
        }
    }

}
