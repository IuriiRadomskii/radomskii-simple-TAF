package ru.radomskii.simple.tests;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;

public class SimpleTest extends BaseTest {

    @Test
    public void trelloTitleTest() {
        trelloSteps.openTrello();
        assertThat(driver.getTitle()).as("Page title incorrect").isEqualTo("Trello");
    }



}
