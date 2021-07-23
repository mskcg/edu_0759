package com.hfad.carsapplication;

import java.io.Serializable;
import java.util.UUID;

public class Car implements Serializable {
    private UUID uuid;
    private String number;
    private String model;
    private String color;
    private int year;
    public Car(){
        this.uuid = UUID.randomUUID();
    }
    public Car(UUID uuid) { this.uuid = uuid; }

    public UUID getUuid() {return uuid;}

    public String getNumber() {return number;}

    public void setNumber(String number) {this.number = number;}

    public String getModel() {return model;}

    public void setModel(String model) {this.model = model;}

    public String getColor() {return color;}

    public void setColor(String color) {this.color = color;}

    public int getYear() {return year;}

    public void setYear(int year) {this.year = year;}
}
