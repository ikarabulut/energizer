package com.ikarabulut.energize.controller;

import com.codahale.metrics.annotation.Timed;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;

import java.util.UUID;

@Path("/event")
@Produces(MediaType.APPLICATION_JSON)
public class BatteryEventController {

    public BatteryEventController() {}

    @POST
    @Timed
    @Path("/{uuid}")
    public String createEvent(@PathParam("uuid") UUID id, String event) {
        System.out.println(event);
        return id.toString();
    }


}
