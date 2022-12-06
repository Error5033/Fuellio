package com.example.myapplication.database;

import androidx.room.Entity;
import androidx.room.PrimaryKey;

// below line is for setting table name.
@Entity(tableName = "model")
public class ModelClass {

    @PrimaryKey(autoGenerate = true)
    private int id;
    private String type,dateTime,lat,log,postalCode,fuelPrice,address,city;

    public ModelClass(int id, String type, String dateTime, String lat, String log, String postalCode, String address, String city) {
        this.id = id;
        this.type = type;
        this.dateTime = dateTime;
        this.lat = lat;
        this.log = log;
        this.postalCode = postalCode;
        this.address = address;
        this.city = city;
    }

    public ModelClass(String type,  String lat, String log, String postalCode,String fuelPrice, String address, String city, String dateTime) {
        this.type = type;
        this.dateTime = dateTime;
        this.lat = lat;
        this.log = log;
        this.postalCode = postalCode;
        this.fuelPrice = fuelPrice;
        this.address = address;
        this.city = city;
    }

    public ModelClass() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getDateTime() {
        return dateTime;
    }

    public void setDateTime(String dateTime) {
        this.dateTime = dateTime;
    }

    public String getLat() {
        return lat;
    }

    public void setLat(String lat) {
        this.lat = lat;
    }

    public String getLog() {
        return log;
    }

    public void setLog(String log) {
        this.log = log;
    }

    public String getPostalCode() {
        return postalCode;
    }

    public void setPostalCode(String postalCode) {
        this.postalCode = postalCode;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getFuelPrice() {
        return fuelPrice;
    }

    public void setFuelPrice(String fuelPrice) {
        this.fuelPrice = fuelPrice;
    }
}