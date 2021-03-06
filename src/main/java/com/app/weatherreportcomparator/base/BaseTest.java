package com.app.weatherreportcomparator.base;

import com.app.weatherreportcomparator.domain.AppMode;
import com.app.weatherreportcomparator.domain.Weather;
import com.typesafe.config.Config;
import com.typesafe.config.ConfigFactory;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.concurrent.TimeUnit;


public class BaseTest {
    private static Logger log = LoggerFactory.getLogger(BaseTest.class);

    public static WebDriver webDriver;
    public static WebDriverWait wait;
    public static Config testconfig;
    public static Weather uiWeather;
    public static Weather apiWeather;
    public static String url_celsius;
    public static String url_fahrenheit;
    private long IMPLICIT_WAIT = 20;
    private long PAGE_LOAD_WAIT = 20;


    public BaseTest(AppMode appMode){
        testconfig = ConfigFactory.load();
        String testMethod = appMode.name().toLowerCase();
        testconfig = testconfig.getConfig(testMethod.toLowerCase()).withFallback(testconfig);
        uiWeather= new Weather();
        apiWeather= new Weather();
    }

    public void initializeUi(){
        String browserName = testconfig.getString("browsername");
        System.out.println(browserName);
        if(browserName.equalsIgnoreCase("chrome")) {
            System.setProperty("webdriver.chrome.driver","src\\main\\resources\\driver\\chromedriver.exe");
            webDriver = new ChromeDriver();
            System.out.println("Loaded Chrome Driver");
        }
        else if(browserName.equalsIgnoreCase("firefox")) {
            System.setProperty("webdriver.gecko.driver","src\\main\\resources\\driver\\geckodriver.exe");
            webDriver = new FirefoxDriver();
            log.info("Loaded with Firefox");
        }
        wait = new WebDriverWait(webDriver, 10);
        webDriver.manage().window().maximize();
        webDriver.manage().deleteAllCookies();
        webDriver.manage().timeouts().implicitlyWait(IMPLICIT_WAIT, TimeUnit.SECONDS);
        webDriver.manage().timeouts().pageLoadTimeout(PAGE_LOAD_WAIT, TimeUnit.SECONDS);
        webDriver.get(testconfig.getString("hosturl"));
        uiWeather = new Weather();

    }

    public void closeBrowser() {
        webDriver.quit();
    }

    public void initializeApi() {
        apiWeather = new Weather();
        url_celsius = testconfig.getString("baseuri") +
                String.format(testconfig.getString("basepath")
                        ,testconfig.getString("city"),testconfig.getString("api_key")) +
                testconfig.getString("units_celsius");

        url_fahrenheit = testconfig.getString("baseuri") +
                String.format(testconfig.getString("basepath")
                        ,testconfig.getString("city"),testconfig.getString("api_key")) +
                testconfig.getString("units_celsius");


    }

}

