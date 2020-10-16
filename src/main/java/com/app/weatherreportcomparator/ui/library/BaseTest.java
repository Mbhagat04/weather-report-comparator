package com.app.weatherreportcomparator.ui.library;

import com.github.racc.tscg.TypesafeConfig;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class BaseTest {
    private static final Logger log = LoggerFactory.getLogger(BaseTest.class);
    private static WebDriver driver;

    public BaseTest(WebDriver driver) {
        this.driver = driver;
    }

    public static void initialize(@TypesafeConfig("browserName") String browserName){
        if (browserName.equalsIgnoreCase("chrome")){
            System.setProperty("webdriver.chrome.driver", "");
            log.info("Chrome Driver Initialized");
            driver = new ChromeDriver();
        } else if (browserName.equalsIgnoreCase("firefox")){
            System.setProperty("webdriver.gecko.driver", " ");
            log.info("Firefox Driver initialized");
            driver = new FirefoxDriver();
        }
    }
}
