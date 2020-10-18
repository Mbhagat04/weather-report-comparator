package com.app.weatherreportcomparator.config;

import com.app.weatherreportcomparator.domain.AppMode;
import com.typesafe.config.Config;
import com.typesafe.config.ConfigFactory;

public class TestConfig {

    private static Config testConfig;

    private static Config getInstance(AppMode appMode) {
        testConfig = ConfigFactory.load();
        String testMethod = testConfig.getString(appMode.name().toLowerCase());
        testConfig = testConfig.getConfig(testMethod).withFallback(testConfig);
        return testConfig;
    }

}
