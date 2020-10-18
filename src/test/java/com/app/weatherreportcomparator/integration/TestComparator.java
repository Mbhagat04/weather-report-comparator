package com.app.weatherreportcomparator.integration;

import com.app.weatherreportcomparator.base.BaseTest;
import com.app.weatherreportcomparator.domain.AppMode;
import org.testng.annotations.Test;

public class TestComparator extends BaseTest {

    public TestComparator() {
        super(AppMode.NULL);
    }

    @Test(priority = 3)
    public void testComparison() {
        System.out.println(uiWeather);
        System.out.println(apiWeather);
    }
}
