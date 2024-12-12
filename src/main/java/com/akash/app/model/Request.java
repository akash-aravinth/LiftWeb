package com.akash.app.model;

import java.util.HashMap;
import java.util.Map;

public class Request {
    private int reqNo;
    private int source;
    private int destination;
    private int noOfPassengers;
    private String status;
    private int liftNo;
    private Map<Integer,Integer> passengers;

    public Request(){
        passengers = new HashMap<>();
    }

    public int getNoOfPassengers() {
        return noOfPassengers;
    }

    public void setNoOfPassengers(int noOfPassengers) {
        this.noOfPassengers = noOfPassengers;
    }

    public Map<Integer, Integer> getPassengers() {
        return passengers;
    }

    public void setPassengers(Map<Integer, Integer> passengers) {
        this.passengers = passengers;
    }

    public int getLiftNo() {
        return liftNo;
    }

    public void setLiftNo(int liftNo) {
        this.liftNo = liftNo;
    }

    public int getReqNo() {
        return reqNo;
    }

    public void setReqNo(int reqNo) {
        this.reqNo = reqNo;
    }

    public int getSource() {
        return source;
    }

    public void setSource(int source) {
        this.source = source;
    }

    public int getDestination() {
        return destination;
    }

    public void setDestination(int destination) {
        this.destination = destination;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
