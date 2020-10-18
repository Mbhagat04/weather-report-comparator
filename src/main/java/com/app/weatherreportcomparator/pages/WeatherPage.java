package com.app.weatherreportcomparator.pages;

import com.app.weatherreportcomparator.base.BaseTest;
import com.app.weatherreportcomparator.domain.AppMode;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class WeatherPage extends BaseTest {
    private Logger log = LoggerFactory.getLogger(this.getClass());

    @FindBy(id = "searchBox")
    WebElement searchBox;

    @FindBy(xpath = "//div[@title()= 'Bengaluru']")
    WebElement cityWeather;


    @FindBy(xpath = "//div[text()= 'Bengaluru']")
    WebElement cityContainer;

    @FindBy(xpath = "//*[@id=\"map_canvas\"]/div[1]/div[6]/div/div[1]")
    WebElement weatherCondition;

    public WeatherPage() {
        super(AppMode.UI);
        PageFactory.initElements(webDriver,this);

    }

    public void navigateToCity(){
        wait.until(ExpectedConditions.elementToBeClickable(searchBox));
        searchBox.clear();
        searchBox.sendKeys(testconfig.getString("city"));
        searchBox.sendKeys(Keys.ENTER);
    }

    public void getWeather(){
        cityContainer.click();
        String weather_container = weatherCondition.getText();
        uiWeather.setCity(weather_container.split("\n")[0]);
        uiWeather.setCondition(weather_container.split("\n")[1].split(":")[1]);
        uiWeather.setWind(weather_container.split("\n")[2].split(":")[1]);
        uiWeather.setHumidity(Integer.parseInt(weather_container.split("\n")[3].split(":")[1].replace("%","").trim()));
        uiWeather.setTemperatureInDegree(Integer.parseInt(weather_container.split("\n")[4].split(":")[1].trim()));
        uiWeather.setTemperatureInFahrenheit(Integer.parseInt(weather_container.split("\n")[5].split(":")[1].trim()));
    }
}
