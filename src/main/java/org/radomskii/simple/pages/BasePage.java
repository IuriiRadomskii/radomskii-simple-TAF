package org.radomskii.simple.pages;

import org.openqa.selenium.WebDriver;
import org.radomskii.simple.driver.WebDriverWrapper;
import org.springframework.beans.factory.annotation.Autowired;

public class BasePage {

    @Autowired
    protected WebDriver driver;

}
