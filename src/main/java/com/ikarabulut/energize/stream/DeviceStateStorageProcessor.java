package com.ikarabulut.energize.stream;

import com.codahale.metrics.MetricRegistry;
import com.codahale.metrics.jmx.JmxReporter;
import com.ikarabulut.energize.api.DevicesDAO;
import com.ikarabulut.energize.api.avro.BatteryEvent;
import io.confluent.kafka.streams.serdes.avro.SpecificAvroSerde;
import org.apache.kafka.common.serialization.Serde;
import org.apache.kafka.common.serialization.Serdes;
import org.apache.kafka.streams.KafkaStreams;
import org.apache.kafka.streams.StreamsBuilder;
import org.apache.kafka.streams.kstream.Consumed;
import org.jdbi.v3.core.Jdbi;
import org.jdbi.v3.sqlobject.SqlObjectPlugin;

import java.util.Properties;

class DeviceStateStorageProcessor extends StreamProcessor<DeviceStateStreamConf> {

    private String table;
    private DevicesDAO db;

    protected DeviceStateStorageProcessor(String name, String description) {
        super(name, description);
    }

    @Override
    protected KafkaStreams buildStream(DeviceStateStreamConf conf, Properties props) {
        createDatabase(conf);

        final Serde<BatteryEvent> valueSpecificAvroSerde = new SpecificAvroSerde<>();
        configureAvroSerde(conf, valueSpecificAvroSerde, false);

        BytesToJson toJson = new BytesToJson();
        StreamsBuilder builder = new StreamsBuilder();
        builder.stream(conf.getSource(),
                        Consumed.with(Serdes.String(), valueSpecificAvroSerde))
                .mapValues(rawRecord -> toJson.apply(rawRecord.getBody()))
                .flatMapValues(i -> i)
                .foreach((uuid, value) -> {
                    long charging = Long.valueOf(value.get("charging").toString());
                    db.setDeviceState(table, uuid, charging > 0);
                });


        return new KafkaStreams(builder.build(), props);
    }

    private void createDatabase(DeviceStateStreamConf conf) {
        MetricRegistry registry = new MetricRegistry();
        final JmxReporter reporter = JmxReporter.forRegistry(registry).build();
        reporter.start();

        this.table = conf.getDeviceTable();
        final Jdbi jdbi = Jdbi.create(conf.getDataSourceFactory().build(registry, "device-db"));
        jdbi.installPlugin(new SqlObjectPlugin());
        this.db = jdbi.onDemand(DevicesDAO.class);
    }
}
