package org.radomskii.simple.tests;

import static org.assertj.core.api.Assertions.assertThat;

import org.radomskii.simple.config.TestConfig;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;

@SpringJUnitConfig(classes = TestConfig.class)
public class SimpleApiTests extends BaseTest {

    /*@Test
    public void trelloTitleTest() {
        trelloSteps.openTrello();
        assertThat(driverWrapper.getTitle()).as("Page title incorrect").isEqualTo("Trello");
    }

    @Test
    public void trelloFailedTitleTest() {
        trelloSteps.openTrello();
        assertThat(driverWrapper.getTitle()).as("Page title incorrect").isEqualTo("Trello");
    }*/

}

