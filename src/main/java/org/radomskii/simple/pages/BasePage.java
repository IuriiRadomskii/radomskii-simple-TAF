package org.radomskii.simple.pages;

import org.radomskii.simple.webdriver.driver.WebDriverHelper;
import org.radomskii.simple.webdriver.driver.WebDriverWrapper;
import org.springframework.beans.factory.annotation.Autowired;

public class BasePage {

    @Autowired
    protected WebDriverWrapper driverWrapper;

    @Autowired
    protected WebDriverHelper driverHelper;

}
