package com.akash.app.db;

import com.akash.app.model.Lift;
import com.akash.app.model.Request;

import java.util.*;

public class Database {
    private List<Lift> lifts = new ArrayList<>();

    public List<Lift> getLifts() {
        return lifts;
    }

    public void setLifts(List<Lift> lifts) {
        this.lifts = lifts;
    }
    private Deque<Request> requests = new LinkedList<>();

    public Deque<Request> getRequests() {
        return requests;
    }

    public void setRequests(Deque<Request> requests) {
        this.requests = requests;
    }
}
