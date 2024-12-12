package com.akash.app.dao;

import com.akash.app.db.DBConnection;
import com.akash.app.model.Request;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.*;

public class RequestDao {
    private Connection connection = DBConnection.getConnection();
    private static RequestDao requestDao;
    public static RequestDao getRequestDao(){
        if (requestDao == null){
            requestDao = new RequestDao();
        }
        return requestDao;
    }
    private String getRequests = "select * from requests;";
    private String getPassengers = "select * from passengers where requestno = ?;";
    public Deque<Request> getRequests() {
        Deque<Request> requests = new LinkedList<>();
        try {
            PreparedStatement statement = connection.prepareStatement(getRequests);
            ResultSet rs = statement.executeQuery();
            while (rs.next()){
                Request request = new Request();
                request.setReqNo(rs.getInt(1));
                request.setSource(rs.getInt(2));
                request.setDestination(rs.getInt(3));
                request.setStatus(rs.getString(4));
                request.setLiftNo(rs.getInt(5));
                PreparedStatement stops = connection.prepareStatement(getPassengers);
                stops.setInt(1,request.getReqNo());
                Map<Integer,Integer> map = new HashMap<>();
                ResultSet set = stops.executeQuery();
                while (set.next()){
                    int destination = set.getInt(2);
                    int count = set.getInt(3);
                    map.put(destination,count);
                }
                request.setPassengers(map);
                requests.addLast(request);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return requests;
    }
}
