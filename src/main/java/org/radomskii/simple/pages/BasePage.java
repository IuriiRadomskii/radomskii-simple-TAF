package org.radomskii.simple.pages;

import org.openqa.selenium.WebDriver;
import org.radomskii.simple.driver.WebDriverWrapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class BasePage {

    @Autowired
    protected WebDriverWrapper driverWrapper;

}
