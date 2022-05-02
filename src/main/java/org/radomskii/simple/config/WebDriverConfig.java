package org.radomskii.simple.config;

import io.github.bonigarcia.wdm.WebDriverManager;
import java.time.Duration;
import lombok.extern.slf4j.Slf4j;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.radomskii.simple.webdriver.driver.WebDriverWrapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Lazy;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;

@Slf4j
@Configuration
@PropertySource("classpath:browser.properties")
public class WebDriverConfig {

    @Value("${browserName}")
    private String browserName;

    @Autowired
    private Environment env;

    @Bean
    @Lazy
    public WebDriverWrapper webDriverWrapper() {
        switch (browserName) {
            case ("chrome"):
                log.info("Chrome driver provided");
                return initChromeDriver();
            case ("firefox"):
                log.info("Firefox driver provided");
                return initFirefoxDriver();
            default:
                log.info("Default driver provided");
                return initFirefoxDriver();
        }
    }

    private WebDriverWrapper initChromeDriver() {
        log.info("Starting initializing CHROME");
        ChromeOptions options = new ChromeOptions();
        options.addArguments(
            "--incognito",
            "--start-maximized");
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver(options);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        return new WebDriverWrapper(driver);
    }

    private WebDriverWrapper initFirefoxDriver() {
        log.info("Starting initializing FIREFOX");
        FirefoxOptions options = new FirefoxOptions();
        options.addArguments(
            "-private");
        WebDriverManager.firefoxdriver().setup();
        WebDriver driver = new FirefoxDriver(options);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(4));
        return new WebDriverWrapper(driver);
    }
}
