package com.akash.app.model;

import java.util.ArrayList;
import java.util.List;

public class Lift {
    private int liftNo;
    private List<Integer> stations;
    private int stepsToMove;
    private int currentPos;
    private int destinationPos;
    public Lift(){
        stations = new ArrayList<>();
    }

    public int getLiftNo() {
        return liftNo;
    }

    public void setLiftNo(int liftNo) {
        this.liftNo = liftNo;
    }

    public List<Integer> getStations() {
        return stations;
    }

    public void setStations(List<Integer> stations) {
        this.stations = stations;
    }

    public int getStepsToMove() {
        return stepsToMove;
    }

    public void setStepsToMove(int stepsToMove) {
        this.stepsToMove = stepsToMove;
    }

    public int getCurrentPos() {
        return currentPos;
    }

    public void setCurrentPos(int currentPos) {
        this.currentPos = currentPos;
    }

    public int getDestinationPos() {
        return destinationPos;
    }

    public void setDestinationPos(int destinationPos) {
        this.destinationPos = destinationPos;
    }
}
