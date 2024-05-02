package com.ikarabulut.energize;

import com.ikarabulut.energize.controller.BatteryEventController;
import io.dropwizard.core.Application;
import io.dropwizard.core.setup.Bootstrap;
import io.dropwizard.core.setup.Environment;

public class energizeApplication extends Application<energizeConfiguration> {

    public static void main(final String[] args) throws Exception {
        new energizeApplication().run(args);
    }

    @Override
    public String getName() {
        return "energize";
    }

    @Override
    public void initialize(final Bootstrap<energizeConfiguration> bootstrap) {
        // TODO: application initialization
    }

    @Override
    public void run(final energizeConfiguration configuration,
                    final Environment environment) {

        BatteryEventController resource = new BatteryEventController();
        environment.jersey().register(resource);
    }

}
