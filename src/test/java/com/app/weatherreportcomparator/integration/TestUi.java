package com.app.weatherreportcomparator.integration;

import com.app.weatherreportcomparator.domain.AppMode;
import com.app.weatherreportcomparator.base.BaseTest;
import com.app.weatherreportcomparator.pages.HomePage;
import com.app.weatherreportcomparator.pages.WeatherPage;
import jdk.nashorn.internal.ir.annotations.Ignore;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;


public class TestUi extends BaseTest {
    HomePage homePage;
    WeatherPage weatherPage;

    public TestUi() {
        super(AppMode.UI);
        initializeUi();
    }

    @BeforeClass
    public void setup(){
        homePage = new HomePage();
        weatherPage = new WeatherPage();
    }


    @Ignore
    @Test
    public void testHomePage() {
        homePage.navigateToWeatherPage();
    }

    @Test(groups = "fetchdata", priority = 0)
    public void testLoadWeatherPage(){
        homePage.navigateToWeatherPage();
        weatherPage.navigateToCity();
        weatherPage.getWeather();
        closeBrowser();
    }

}