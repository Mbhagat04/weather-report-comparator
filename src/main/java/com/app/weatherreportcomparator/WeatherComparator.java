package com.app.weatherreportcomparator;

import com.google.inject.Guice;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class WeatherComparator {
    private static final Logger log = LoggerFactory.getLogger(WeatherComparator.class);


    public static WeatherComparator getInstance(AppMode appMode){
        log.info("Starting WeatherComparator in {} mode", appMode);
        return Guice.createInjector(new ConfigModule(appMode)).getInstance(WeatherComparator.class);
    }

    public void loadUI(){
        log.info("LoadingUI");
    }

    public void loadApi(){
        log.info("Loading API");
    }

}
