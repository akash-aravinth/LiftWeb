package com.akash.app.dao;

import com.akash.app.db.DBConnection;
import com.akash.app.model.Lift;
import com.akash.app.model.Request;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.*;

import java.sql.Connection;
import java.util.ArrayList;

public class LiftDao {
    private static LiftDao liftDao;
    private Connection connection = DBConnection.getConnection();

    public static LiftDao getLiftDao() {
        if (liftDao == null) {
            liftDao = new LiftDao();
        }
        return liftDao;
    }

    private String getLifts = "select * from lifts;";
    private String getStations = "select stationNo from stations where liftNo = ?;";

    public List<Lift> getLifts() {
        List<Lift> lifts = new ArrayList<>();
        try {
            PreparedStatement statement = connection.prepareStatement(getLifts);
            ResultSet rs = statement.executeQuery();
            while (rs.next()) {
                Lift lift = new Lift();
                lift.setLiftNo(rs.getInt(1));
                lift.setIncrement(rs.getInt(2));
                lift.setCurrentPos(rs.getInt(3));
                lift.setDestinationPos(rs.getInt(4));
                lift.setStatus(rs.getString(5));
                lift.setNoOfPassengers(rs.getInt(6));
                List<Integer> stations = getLiftStations(lift.getLiftNo());
                lift.setStations(stations);
                lifts.add(lift);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return lifts;
    }

    private List<Integer> getLiftStations(int liftNo) {
        List<Integer> stations = new ArrayList<>();
        try {
            PreparedStatement statement = connection.prepareStatement(getStations);
            statement.setInt(1, liftNo);
            ResultSet rs = statement.executeQuery();
            while (rs.next()) {
                stations.add(rs.getInt(1));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return stations;
    }

    public Lift getLiftByLiftNo(int liftNo) {
        String getLiftById = "select * from lifts where liftNo = ?;";
        Lift lift = null;
        try {
            PreparedStatement statement = connection.prepareStatement(getLiftById);
            statement.setInt(1, liftNo);
            ResultSet rs = statement.executeQuery();
            if (rs.next()) {
                lift = new Lift();
                lift.setLiftNo(rs.getInt(1));
                lift.setIncrement(rs.getInt(2));
                lift.setCurrentPos(rs.getInt(3));
                lift.setDestinationPos(rs.getInt(4));
                lift.setStatus(rs.getString(5));
                lift.setNoOfPassengers(rs.getInt(6));
                List<Integer> stations = getLiftStations(lift.getLiftNo());
                lift.setStations(stations);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return lift;
    }

    public List<Lift> getLiftsByStatus(String status) {
        String getByStatus = "select * from lifts where status = ?;";
        List<Lift> lifts = new ArrayList<>();
        try {
            PreparedStatement statement = connection.prepareStatement(getByStatus);
            statement.setString(1,status);
            ResultSet rs = statement.executeQuery();
            while (rs.next()) {
                Lift lift = new Lift();
                lift.setLiftNo(rs.getInt(1));
                lift.setIncrement(rs.getInt(2));
                lift.setCurrentPos(rs.getInt(3));
                lift.setDestinationPos(rs.getInt(4));
                lift.setStatus(rs.getString(5));
                lift.setNoOfPassengers(rs.getInt(6));
                List<Integer> stations = getLiftStations(lift.getLiftNo());
                lift.setStations(stations);
                lifts.add(lift);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return lifts;
    }


    public Lift isAvailabe(Request request) {
        Lift isAvailabe = null;
        //Process Do later
        return isAvailabe;
    }
}
