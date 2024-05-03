package com.ikarabulut.energize.api.controller;

import com.codahale.metrics.annotation.Timed;
import com.google.common.collect.ImmutableMap;
import com.ikarabulut.energize.api.DevicesDAO;
import com.ikarabulut.energize.api.avro.BatteryEvent;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.Context;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.ProducerRecord;
import org.apache.kafka.clients.producer.RecordMetadata;

import java.io.IOException;
import java.nio.ByteBuffer;
import java.time.Instant;
import java.util.Map;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;

import static org.apache.commons.compress.utils.IOUtils.toByteArray;

@Path("/event")
@Produces(MediaType.APPLICATION_JSON)
public class BatteryEventController {
    protected final KafkaProducer producer;
    private final DevicesDAO db;
    private final String table;
    protected final String topic;

    public BatteryEventController(KafkaProducer producer, DevicesDAO db, String table, String topic) {
        this.producer = producer;
        this.db = db;
        this.table = table;
        this.topic = topic;
    }

    @POST
    @Timed
    @Path("/{uuid}")
    public Response createEvent(@PathParam("uuid") String id, @Context HttpServletRequest request) throws IOException, ExecutionException, InterruptedException {
        ByteBuffer body = ByteBuffer.wrap(toByteArray(request.getInputStream()));
        BatteryEvent payload = new BatteryEvent(id, Instant.now().toEpochMilli(), body);

        ProducerRecord record = new ProducerRecord(topic, id, payload);
        Future<RecordMetadata> metadata = producer.send(record);

        return Response.ok().entity(serialize(metadata.get())).build();
    }

    @GET
    @Path("/state")
    public Response getStatus(@QueryParam("uuid") String uuid) {
        return Response.ok().entity(db.getDeviceState(table, uuid)).build();
    }

    protected Map<String, Object> serialize(RecordMetadata metadata) {
        return ImmutableMap.<String, Object>builder()
                .put("offset", metadata.offset())
                .put("partition", metadata.partition())
                .put("topic", metadata.topic())
                .put("timestamp", metadata.timestamp())
                .build();
    }


}
