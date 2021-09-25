package com.njbdk.Carmax;

import java.time.Duration;

public class CarPart {
    private String name; //name of part
    private String id;

    private boolean isWorking = true; //if the part is working
    private Duration eta = Duration.ZERO;
    private String condition = "";
    private double cost = 0.0;

    //convert name to camel case
    private String toCamel(String s) {
        String[] words = s.split("[\\W_]+");

        StringBuilder builder = new StringBuilder();

        for(int i = 0; i < words.length; i++) {
            if (i == 0) {
                builder.append(words[i].toLowerCase());
            } else {
                builder.append(Character.toUpperCase(words[i].charAt(0)) + words[i].substring(1).toLowerCase());
            }
        }
        
        return builder.toString();
    }

    //constructor that sets name
    public CarPart(String name) {
        this.name = name;
        this.id = toCamel(name);
    }

    //getter to return name
    //returns String name
    public String name() {
        return this.name;
    }

    public String id() {
        return this.id;
    }

    //setter to change status
    //returns void
    public void setWorking(boolean working) {
        this.isWorking = working;
    }

    //setter to mark part fixed
    public void setFixed() {
        this.isWorking = true;
        this.eta = Duration.ZERO;
        this.condition = "";
        this.cost = 0.0;
    }

    //setter to mark part damaged
    public void setDamaged(Duration eta, String condition, double cost) {
        this.isWorking = false;
        this.eta = eta;
        this.condition = condition;
        this.cost = cost;
    }

    //getter to check if the part is working
    //returns boolean true if working
    public boolean isWorking() {
        return this.isWorking;
    }

    //getter to check ETA until part is fixed
    public Duration eta() {
        return this.eta;
    }

    //getter to check condition of part
    public String condition() {
        return this.condition;
    }

    //getter to check cost to fix/replace part
    public double cost() {
        return this.cost;
    }
}
