package org.radomskii.simple.tests;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.TestInstance.Lifecycle;
import org.radomskii.simple.driver.WebDriverWrapper;
import org.radomskii.simple.steps.TrelloSteps;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;

@Slf4j
@TestInstance(Lifecycle.PER_CLASS)
public class BaseTest {

    @Autowired
    protected WebDriverWrapper driverWrapper;

    @Lazy
    @Autowired
    protected TrelloSteps steps;

    @AfterEach
    public void cleanUpAfterTest() {
        log.info("Clean up after test");
        driverWrapper.manage().deleteAllCookies();
    }

    @AfterAll
    public void tearDown() {
        log.info("Tearing down in @AfterAll");
        driverWrapper.quit();
    }
}
