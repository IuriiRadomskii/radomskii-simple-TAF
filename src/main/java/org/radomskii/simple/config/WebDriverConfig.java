package org.radomskii.simple.config;

import io.github.bonigarcia.wdm.WebDriverManager;
import java.time.Duration;
import lombok.extern.slf4j.Slf4j;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.radomskii.simple.driver.WebDriverWrapper;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Slf4j
@Configuration
public class WebDriverConfig {

    @Value("browser")
    private String browserName;

    @Bean
    public WebDriverWrapper webDriverWrapper() {
        switch (browserName) {
            case ("chrome"):
                log.info("Chrome driver provided");
                initChromeDriver();
                break;
            case ("firefox"):
                log.info("Firefox driver provided");
                initFirefoxDriver();
                break;
            default:
                log.info("Default driver provided");
                initChromeDriver();
        }
        return null;
    }

    private WebDriverWrapper initChromeDriver() {
        log.info("Starting initializing CHROME");
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(4));
        return new WebDriverWrapper(driver);
    }

    private WebDriverWrapper initFirefoxDriver() {
        log.info("Starting initializing FIREFOX");
        WebDriverManager.firefoxdriver().setup();
        WebDriver driver = new FirefoxDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(4));
        return new WebDriverWrapper(driver);
    }
}
