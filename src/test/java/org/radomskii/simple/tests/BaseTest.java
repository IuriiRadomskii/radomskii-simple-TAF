package org.radomskii.simple.tests;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.TestInstance.Lifecycle;
import org.radomskii.simple.driver.WebDriverWrapper;
import org.radomskii.simple.steps.TrelloSteps;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.test.annotation.DirtiesContext;

@Slf4j
@TestInstance(Lifecycle.PER_CLASS)
@DirtiesContext
public class BaseTest {

    @Autowired
    @Lazy
    protected WebDriverWrapper driverWrapper;

    @Lazy
    @Autowired
    protected TrelloSteps trelloSteps;

    @AfterAll
    public void tearDown() {
        log.info("Tearing down in @AfterAll");
        driverWrapper.quit();
    }

}
