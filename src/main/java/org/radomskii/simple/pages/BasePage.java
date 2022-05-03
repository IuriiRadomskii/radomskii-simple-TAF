package org.radomskii.simple.pages;

import org.radomskii.simple.driver.WebDriverHelper;
import org.radomskii.simple.driver.WebDriverWrapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;

public abstract class BasePage {

    @Autowired
    protected Environment env;

    @Autowired
    protected WebDriverWrapper driverWrapper;

    @Autowired
    protected WebDriverHelper driverHelper;

}
