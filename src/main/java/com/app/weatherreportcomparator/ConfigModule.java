package com.app.weatherreportcomparator;

import com.github.racc.tscg.TypesafeConfigModule;
import com.google.inject.AbstractModule;

import com.typesafe.config.Config;
import com.typesafe.config.ConfigFactory;
import org.apache.log4j.BasicConfigurator;
import org.apache.log4j.PropertyConfigurator;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ConfigModule extends AbstractModule {
    private final Logger log = LoggerFactory.getLogger(this.getClass());
    private final AppMode appMode;

    public ConfigModule(AppMode appMode) {
        this.appMode = appMode;
    }

    @Override
    protected void configure() {
        Config conf = ConfigFactory.load();
        log.debug("Loading config...");
        install(TypesafeConfigModule.fromConfigUsingClasspathScanner(conf,"com.app.weatherreportcomparator"));
        log.debug("Loaded Config successfully");

    }
}
