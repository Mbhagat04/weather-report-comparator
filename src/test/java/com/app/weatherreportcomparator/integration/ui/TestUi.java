package com.app.weatherreportcomparator.integration.ui;

import com.app.weatherreportcomparator.domain.AppMode;
import com.app.weatherreportcomparator.base.BaseTest;
import com.app.weatherreportcomparator.pages.HomePage;
import com.app.weatherreportcomparator.pages.WeatherPage;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;


public class TestUi extends BaseTest {
    HomePage homePage;
    WeatherPage weatherPage;

    public TestUi() {
        super(AppMode.UI);
    }

    @BeforeClass
    public void setup(){
        initializeUi();
        homePage = new HomePage();
        weatherPage = new WeatherPage();
    }

    @Test(priority = 1)
    public void testHomePage() {
       homePage.navigateToWeatherPage();
    }

    @Test(priority = 2)
    public void testLoadWeatherPage(){
        weatherPage.navigateToCity();
        weatherPage.getWeather();
        closeBrowser();
    }

}