package com.ikarabulut.energize.stream;

import io.dropwizard.core.setup.Bootstrap;

public class DeviceStateStream extends StreamApp<DeviceStateStreamConf> {

    @Override
    public void initialize(Bootstrap<DeviceStateStreamConf> bootstrap) {
        bootstrap.addCommand(new DeviceStateStorageProcessor("stream",
                "Runs a Kafka stream application"));
    }

    public static void main(String[] args) throws Exception {
        new DeviceStateStream().run(args);
    }
}
