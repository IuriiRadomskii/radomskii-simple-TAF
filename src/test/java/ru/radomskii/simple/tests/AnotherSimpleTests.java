/*
package ru.radomskii.simple.tests;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;
import ru.radomskii.simple.config.TestConfig;
import org.springframework.test.context.ContextConfiguration;

@ContextConfiguration(classes = TestConfig.class)
public class AnotherSimpleTests extends BaseTest {

    @Test
    public void trelloTitleTest() {
        trelloSteps.openTrello();
        assertThat(driverWrapper.getTitle()).as("Page title incorrect").isEqualTo("Trello");
    }

    @Test
    public void trelloFailedTitleTest() {
        trelloSteps.openTrello();
        assertThat(driverWrapper.getTitle()).as("Page title incorrect").isEqualTo("Trellooo");
    }

}
*/
