package com.app.weatherreportcomparator.integration.ui;

import com.app.weatherreportcomparator.base.BaseTest;
import com.app.weatherreportcomparator.domain.AppMode;
import com.app.weatherreportcomparator.pages.HomePage;
import com.app.weatherreportcomparator.pages.WeatherPage;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;


public class TestApi extends BaseTest {
    public TestApi() {
        super(AppMode.UI);
    }

}