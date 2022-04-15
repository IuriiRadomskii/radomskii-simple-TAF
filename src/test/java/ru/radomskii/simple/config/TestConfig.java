package ru.radomskii.simple.config;

import io.github.bonigarcia.wdm.WebDriverManager;
import java.time.Duration;
import lombok.extern.slf4j.Slf4j;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.radomskii.simple.config.WebDriverConfig;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.context.annotation.PropertySource;

@Slf4j
@Configuration
@ComponentScan(basePackages = "ru.radomskii.simple")
public class TestConfig {

    @Bean
    WebDriver webDriver() {
        log.info("Starting driver");
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(4));
        return driver;
    }

}
