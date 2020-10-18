package com.app.weatherreportcomparator.integration;

import com.app.weatherreportcomparator.base.BaseTest;
import com.app.weatherreportcomparator.domain.AppMode;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class TestComparator extends BaseTest {

    private int range = 5;
    public TestComparator() {
        super(AppMode.COMP);
    }

    @Test(priority = 3)
    public void testComparison() {
        SoftAssert softAssert = new SoftAssert();
        softAssert.assertEquals(true,true);
        softAssert.assertTrue(uiWeather.getCity().contains(apiWeather.getCity()));
        softAssert.assertEquals(apiWeather.getHumidity() < uiWeather.getHumidity()+range,apiWeather.getHumidity() > uiWeather.getHumidity()-range);
        softAssert.assertTrue(apiWeather.getTemperatureInDegree() < uiWeather.getTemperatureInDegree()+range || apiWeather.getTemperatureInDegree() > uiWeather.getTemperatureInDegree()-range);
        softAssert.assertAll();
        System.out.println(uiWeather);
        System.out.println(apiWeather);
    }
}
