package com.akash.app.catchdb;

import com.akash.app.model.Lift;
import com.akash.app.model.Request;
import java.util.*;

public class CatchDB {
    private static CatchDB catchDB;
    public static CatchDB getCatchDB(){
        if (catchDB == null){
            catchDB = new CatchDB();
        }
        return catchDB;
    }
    private List<Request> catchRequests = new ArrayList<>();

    public List<Request> getCatchRequests() {
        return catchRequests;
    }

    public void setCatchRequests(List<Request> catchRequests) {
        this.catchRequests = catchRequests;
    }


    public Lift isAvailabe(Request request) {
        Lift availableLift = null;
        //i will do process
        return availableLift;
    }
}
