package ru.radomskii.simple.tests;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;
import ru.radomskii.simple.config.TestConfig;

@SpringJUnitConfig(classes = TestConfig.class)
public class SimpleTests extends BaseTest {

    @Test
    public void trelloTitleTest() {
        trelloSteps.openTrello();
        assertThat(driver.getTitle()).as("Page title incorrect").isEqualTo("Trello");
    }

    @Test
    public void trelloFailedTitleTest() {
        trelloSteps.openTrello();
        assertThat(driver.getTitle()).as("Page title incorrect").isEqualTo("Trello");
    }
}
