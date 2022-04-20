package org.radomskii.simple.pages;

import org.radomskii.simple.driver.WebDriverWrapper;
import org.springframework.beans.factory.annotation.Autowired;

public class BasePage {

    @Autowired
    protected WebDriverWrapper driverWrapper;

}
