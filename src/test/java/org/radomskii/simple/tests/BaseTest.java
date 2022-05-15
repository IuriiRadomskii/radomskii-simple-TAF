package org.radomskii.simple.tests;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.webdriver.FirefoxDriverFactory;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.TestInstance.Lifecycle;
import org.radomskii.simple.driver.factory.CustomChromeFactory;
import org.radomskii.simple.driver.factory.CustomFirefoxFactory;
import org.radomskii.simple.steps.TrelloAssertionSteps;
import org.radomskii.simple.steps.TrelloSteps;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;

@Slf4j
@TestInstance(Lifecycle.PER_CLASS)
public class BaseTest {

    @Lazy
    @Autowired
    protected TrelloSteps steps;

    @Lazy
    @Autowired
    protected TrelloAssertionSteps assertionSteps;

    @BeforeAll
    public void setup() {
        Configuration.browser = CustomFirefoxFactory.class.getName();
        Configuration.timeout = 8000L;
        Configuration.pollingInterval = 500L;
        Configuration.headless = false;
        Configuration.screenshots = false;
        //Configuration.baseUrl = "https://trello.com";
    }
}
