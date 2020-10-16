package com.app.weatherreportcomparator.integration;

import com.app.weatherreportcomparator.AppMode;
import com.app.weatherreportcomparator.WeatherComparator;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.Assert;
import org.testng.TestRunner;
import org.testng.annotations.Test;

public class WeatherComparatorIT {
    Logger log = LoggerFactory.getLogger(this.getClass());

    @Test
    public void testAppMode(){
        WeatherComparator weatherComparator = WeatherComparator.getInstance(AppMode.API);
        weatherComparator.loadApi();
        log.info("TestCase Executed");
        Assert.assertTrue(true);
    }
}
