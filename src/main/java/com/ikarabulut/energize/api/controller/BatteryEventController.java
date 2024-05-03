package com.ikarabulut.energize.controller;

import com.codahale.metrics.annotation.Timed;
import com.ikarabulut.energize.avro.BatteryEvent;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.Context;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

import java.io.IOException;
import java.nio.ByteBuffer;
import java.time.Instant;
import java.util.UUID;

import static org.apache.commons.compress.utils.IOUtils.toByteArray;

@Path("/event")
@Produces(MediaType.APPLICATION_JSON)
public class BatteryEventController {

    public BatteryEventController() {}

    @POST
    @Timed
    @Path("/{uuid}")
    public Response createEvent(@PathParam("uuid") UUID id, @Context HttpServletRequest request) throws IOException {
        ByteBuffer body = ByteBuffer.wrap(toByteArray(request.getInputStream()));
        BatteryEvent payload = new BatteryEvent(id.toString(), Instant.now().toEpochMilli(), body);
        return Response.ok().entity(id).build();
    }


}
