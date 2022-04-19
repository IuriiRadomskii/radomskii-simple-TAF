package org.radomskii.simple.tests;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.TestInstance.Lifecycle;
import org.radomskii.simple.driver.WebDriverWrapper;
import org.radomskii.simple.steps.TrelloSteps;
import org.springframework.beans.factory.annotation.Autowired;

@Slf4j
@TestInstance(Lifecycle.PER_CLASS)
public class BaseTest {

    @Autowired
    protected WebDriverWrapper driverWrapper;

    @Autowired
    protected TrelloSteps trelloSteps;

    @AfterAll
    public void tearDown() {
        driverWrapper.quit();
    }
}
