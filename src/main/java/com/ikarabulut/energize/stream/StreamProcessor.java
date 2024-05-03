package com.ikarabulut.energize.stream;

import io.confluent.kafka.streams.serdes.avro.SpecificAvroSerde;
import io.dropwizard.core.cli.ConfiguredCommand;
import io.dropwizard.core.setup.Bootstrap;
import net.sourceforge.argparse4j.inf.Namespace;
import org.apache.avro.generic.GenericRecord;
import org.apache.kafka.common.serialization.Serde;
import org.apache.kafka.common.serialization.Serdes;
import org.apache.kafka.streams.KafkaStreams;
import org.apache.kafka.streams.StreamsConfig;
import org.apache.kafka.streams.errors.LogAndFailExceptionHandler;

import java.util.Collections;
import java.util.Map;
import java.util.Properties;

import static org.apache.kafka.streams.StreamsConfig.DEFAULT_KEY_SERDE_CLASS_CONFIG;
import static org.apache.kafka.streams.StreamsConfig.DEFAULT_VALUE_SERDE_CLASS_CONFIG;

public abstract class StreamProcessor<T extends StreamConfiguration>
        extends ConfiguredCommand<T> {

    protected StreamProcessor(String name, String description) {
        super(name, description);
    }

    @Override
    protected void run(Bootstrap<T> bootstrap, Namespace namespace, T configuration)
            throws Exception {
        Properties props = bootstrapProperties(configuration);
        props.put(DEFAULT_KEY_SERDE_CLASS_CONFIG, getKeySerde());
        props.put(DEFAULT_VALUE_SERDE_CLASS_CONFIG, getValueSerde());

        KafkaStreams streams = buildStream(configuration, props);
        Runtime.getRuntime().addShutdownHook(new Thread(streams::close));

        streams.start();
    }

    public static <T extends StreamConfiguration> Properties bootstrapProperties(T configuration){
        Properties props = new Properties();
        // Set a few key parameters
        props.put(StreamsConfig.APPLICATION_ID_CONFIG, configuration.getApplicationId());
        props.put(StreamsConfig.BOOTSTRAP_SERVERS_CONFIG,
                configuration.getKafka().getBootstrapServers());
        props.put("schema.registry.url", configuration.getKafka().getSchemaRegistry());

        props.put(
                StreamsConfig.DEFAULT_DESERIALIZATION_EXCEPTION_HANDLER_CLASS_CONFIG,
                LogAndFailExceptionHandler.class.getName()
        );

        props.putAll(configuration.getKafka().getOverrides());
        return props;
    }

    public static <T extends GenericRecord> Serde<T> configureAvroSerde(StreamConfiguration conf,
                                                                        Serde<T> avro, boolean isKey){
        final Map<String, String> serdeConfig = Collections.singletonMap("schema.registry.url",
                conf.getKafka().getSchemaRegistry());
        avro.configure(serdeConfig, isKey);
        return avro;
    }

    protected Class<? extends Serde> getKeySerde() {
        return Serdes.String().getClass();
    }

    protected Class<? extends Serde> getValueSerde() {
        return SpecificAvroSerde.class;
    }

    protected abstract KafkaStreams buildStream(T configuration, Properties props);
}
