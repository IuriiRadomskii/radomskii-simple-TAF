package ru.radomskii.simple.tests;

import io.github.bonigarcia.wdm.WebDriverManager;
import java.time.Duration;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.TestInstance.Lifecycle;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.radomskii.simple.driver.WebDriverWrapper;
import org.springframework.beans.factory.annotation.Autowired;
import ru.radomskii.simple.steps.TrelloSteps;

@Slf4j
@TestInstance(Lifecycle.PER_CLASS)
public class BaseTest {

    @Autowired
    protected WebDriver driver;

    @Autowired
    protected TrelloSteps trelloSteps;

    @AfterAll
    public void tearDown() {
        quitDriver();
    }


    private void quitDriver() {
        log.info("Quit driver");
        driver.quit();
    }
}
