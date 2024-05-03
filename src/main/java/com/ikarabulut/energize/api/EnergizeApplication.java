package com.ikarabulut.energize.api;

import com.ikarabulut.energize.api.controller.BatteryEventController;
import io.confluent.kafka.serializers.KafkaAvroSerializer;
import io.dropwizard.core.Application;
import io.dropwizard.core.setup.Bootstrap;
import io.dropwizard.core.setup.Environment;
import io.dropwizard.jdbi3.JdbiFactory;
import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.ProducerConfig;
import org.apache.kafka.common.serialization.StringSerializer;
import org.jdbi.v3.core.Jdbi;

import java.util.Properties;

public class EnergizeApplication extends Application<EnergizeConfiguration> {

    public static void main(final String[] args) throws Exception {
        new EnergizeApplication().run(args);
    }

    @Override
    public String getName() {
        return "energize";
    }

    @Override
    public void initialize(final Bootstrap<EnergizeConfiguration> bootstrap) {}

    @Override
    public void run(final EnergizeConfiguration configuration, final Environment environment) {
        final JdbiFactory factory = new JdbiFactory();
        final Jdbi jdbi = factory.build(environment, configuration.getDataSourceFactory(), "devices");

        KafkaProducer producer = createProducer(configuration);
        environment.lifecycle().manage(new CloseableManaged(producer));

        BatteryEventController resource = new BatteryEventController(producer, jdbi.onDemand(DevicesDAO.class), configuration.getDeviceTable(), configuration.getTopic());
        environment.jersey().register(resource);
    }

    private KafkaProducer createProducer(EnergizeConfiguration conf) {
        Properties props = new Properties();

        props.put(ProducerConfig.ACKS_CONFIG, "1");
        props.put(ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG, StringSerializer.class.getName());
        props.put(ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG, KafkaAvroSerializer.class.getName());

        props.putAll(conf.getKafka());
        return new KafkaProducer(props);
    }

}
