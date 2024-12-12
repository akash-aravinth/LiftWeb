package com.akash.app.resource;

import com.akash.app.dao.LiftDao;
import com.akash.app.model.Lift;
import java.util.*;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path("/lifts")
public class LiftResource {
    private LiftDao liftDao = LiftDao.getLiftDao();
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response getLifts(){
        List<Lift> lifts = liftDao.getLifts();
        if (lifts.isEmpty()){
            return Response.ok(lifts).entity("Lifts Are Empty").build();
        }
        return Response.ok(lifts).build();
    }
}
