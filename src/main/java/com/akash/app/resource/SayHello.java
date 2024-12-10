package com.akash.app.resource;

import com.akash.app.db.DBConnection;

import javax.validation.constraints.Past;
import javax.ws.rs.ApplicationPath;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import java.sql.Connection;

@Path("/hello")
public class SayHello {
    @GET
    @Produces(MediaType.TEXT_PLAIN)
    public String sayHello(){
        Connection connection = DBConnection.getConnection();
        return "Hello";
    }
}
