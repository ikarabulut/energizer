package com.ikarabulut.energize;

import com.ikarabulut.energize.controller.BatteryEventController;
import io.dropwizard.core.Application;
import io.dropwizard.core.setup.Bootstrap;
import io.dropwizard.core.setup.Environment;

public class EnergizeApplication extends Application<EnergizeConfiguration> {

    public static void main(final String[] args) throws Exception {
        new EnergizeApplication().run(args);
    }

    @Override
    public String getName() {
        return "energize";
    }

    @Override
    public void initialize(final Bootstrap<EnergizeConfiguration> bootstrap) {
        // TODO: application initialization
    }

    @Override
    public void run(final EnergizeConfiguration configuration,
                    final Environment environment) {

        BatteryEventController resource = new BatteryEventController();
        environment.jersey().register(resource);
    }

}
