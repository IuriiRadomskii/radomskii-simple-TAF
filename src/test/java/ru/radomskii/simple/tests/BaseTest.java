package ru.radomskii.simple.tests;

import io.github.bonigarcia.wdm.WebDriverManager;
import java.time.Duration;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import ru.radomskii.simple.steps.TrelloSteps;

public class BaseTest {

    protected WebDriver driver;
    protected TrelloSteps trelloSteps;

    @BeforeAll
    public void setUpDriver() {
        setupDriver();
        setupSteps();
    }

    @AfterAll
    public void tearDown() {
        quitDriver();
    }

    private void setupDriver() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(4));
    }

    private void setupSteps() {
        trelloSteps = new TrelloSteps(driver);
    }

    private void quitDriver() {
        driver.quit();
    }




}
