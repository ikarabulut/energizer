package com.ikarabulut.energize.api;

import com.ikarabulut.energize.api.controller.BatteryEventController;
import io.dropwizard.core.Application;
import io.dropwizard.core.setup.Bootstrap;
import io.dropwizard.core.setup.Environment;
import io.dropwizard.jdbi3.JdbiFactory;
import org.jdbi.v3.core.Jdbi;

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
        BatteryEventController resource = new BatteryEventController();
        environment.jersey().register(resource);
    }

}
