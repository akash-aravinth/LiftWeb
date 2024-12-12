package com.akash.app.resource;

import com.akash.app.catchdb.CatchDB;
import com.akash.app.dao.LiftDao;
import com.akash.app.model.Lift;
import com.akash.app.model.Request;
import com.akash.app.thread.ProcessThread;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path("/requests")
public class RequestSource {
    boolean start = true;
    @POST
    @Consumes(MediaType.APPLICATION_FORM_URLENCODED)
    @Produces(MediaType.APPLICATION_JSON)
    public Response getResponse(@FormParam("source") int source, @FormParam("destination") int destination, @FormParam("noOfPassengers") int noOfPassengers){
        if (start){
            Thread thread = new Thread(new ProcessThread());
            thread.start();
            start = false;
        }
        Request request = new Request();
        request.setSource(source);
        request.setDestination(destination);
        request.setNoOfPassengers(noOfPassengers);
        if (source == destination){
            return Response.ok().entity("Lift Assigned").build();
        } else if (source < destination) {
            request.setStatus("up");
        }else {
            request.setStatus("down");
        }
        boolean success = processReques(request);
        if (!success){
            processReques(request);
        }
        return Response.ok().entity("").build();
    }

    private boolean processReques(Request request) {
        Lift catcheLift = CatchDB.getCatchDB().isAvailabe(request);
        if (catcheLift != null){
            //Process Request with Catche
            return true;
        }
        Lift idleLift = LiftDao.getLiftDao().isAvailabe(request);
        if (idleLift != null){
            //Prcess Request with new Lift
            return true;
        }
        return false;
    }
}
