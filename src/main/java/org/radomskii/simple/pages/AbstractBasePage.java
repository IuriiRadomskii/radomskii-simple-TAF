package org.radomskii.simple.pages;

import javax.annotation.PostConstruct;
import lombok.extern.slf4j.Slf4j;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.support.PageFactory;
import org.radomskii.simple.driver.WebDriverHelper;
import org.radomskii.simple.driver.WebDriverWrapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Lazy;
import org.springframework.core.env.Environment;

@Slf4j
public abstract class AbstractBasePage {

    @Value("${baseUri}")
    protected String BASE_URI;

    @Autowired
    protected Environment env;

    @Autowired
    protected WebDriverWrapper driverWrapper;

    @Autowired
    protected WebDriverHelper driverHelper;

    @PostConstruct
    private void init() {
        log.debug("Initialize: " + getClass().getName());
        PageFactory.initElements(driverWrapper, this);
    }
}
