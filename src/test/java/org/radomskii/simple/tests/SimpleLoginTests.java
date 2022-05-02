package org.radomskii.simple.tests;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;
import org.radomskii.simple.config.TestConfig;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.annotation.DirtiesContext.ClassMode;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;

@SpringJUnitConfig(classes = TestConfig.class)
@DirtiesContext(classMode = ClassMode.BEFORE_EACH_TEST_METHOD)
public class SimpleLoginTests extends BaseTest {

    @Test
    public void positiveLoginTest() {
        steps.openTrello();
        steps.loginOn();
        assertThat(driverWrapper.getTitle()).as("Page title incorrect").isEqualTo("Boards | Trello");
    }

    @Test
    public void negativeLoginTest() {
        steps.openTrello();
        steps.loginOn();
        assertThat(driverWrapper.getTitle()).as("Page title incorrect").isEqualTo("Boards | Trello");
    }
}
