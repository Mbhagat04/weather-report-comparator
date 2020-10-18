package com.app.weatherreportcomparator.pages;

import com.app.weatherreportcomparator.base.BaseTest;
import com.app.weatherreportcomparator.domain.AppMode;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class HomePage extends BaseTest {

    private Logger log = LoggerFactory.getLogger(this.getClass());

    @FindBy(xpath = "//a[text()='WEATHER']")
    WebElement weather_menu;

    @FindBy(xpath = "//*[@id=\"h_sub_menu\"]")
    WebElement submenu;

    public HomePage() {
        super(AppMode.UI);
        PageFactory.initElements(webDriver,this);
    }

    public void navigateToWeatherPage() {
        wait.until(ExpectedConditions.elementToBeClickable(submenu));
        submenu.click();
        wait.until(ExpectedConditions.visibilityOf(weather_menu));
        weather_menu.click();
    }



}

