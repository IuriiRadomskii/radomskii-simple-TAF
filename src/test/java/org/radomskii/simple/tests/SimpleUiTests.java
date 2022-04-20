package org.radomskii.simple.tests;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;
import org.radomskii.simple.config.TestConfig;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;

@SpringJUnitConfig(classes = TestConfig.class)
public class SimpleUiTests extends BaseTest {

    @Test
    public void trelloTitleTest() {
        trelloSteps.openTrello();
        trelloSteps.loginOn();
        assertThat(driverWrapper.getTitle()).as("Page title incorrect").isEqualTo("Trello");
    }

    @Test
    public void trelloFailedTitleTest() {
        trelloSteps.openTrello();
        trelloSteps.loginOn();
        assertThat(driverWrapper.getTitle()).as("Page title incorrect").isEqualTo("Trello");
    }
}
