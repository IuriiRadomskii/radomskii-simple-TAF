package org.radomskii.simple.webdriver.driver;

import java.time.Duration;
import java.util.function.Function;
import lombok.extern.slf4j.Slf4j;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

@Component
@Slf4j
public class WebDriverHelper {

    private static final String LOG_TEMPLATE_1 = "{}; Execution time: {}; Page: {};";
    private static final String LOG_TEMPLATE_2 = "Action: {}; Element: {}; Execution time: {}; Page: {};";

    @Autowired
    @Lazy
    private WebDriverWrapper driverWrapper;

    public void waitForPageIsCompletelyLoaded() {
        long startTime = System.currentTimeMillis();
        try {
            new FluentWait<>(driverWrapper.getDriver())
                .withTimeout(Duration.ofSeconds(10L))
                .pollingEvery(Duration.ofMillis(500L))
                .until(driver -> {
                    JavascriptExecutor js = (JavascriptExecutor) driver;
                    return js.executeScript("return document.readyState").toString().equals("complete");
                });
        } catch (TimeoutException exception) {
            log.debug(String.format("Unable to wait for page to complete:  %s", exception));
        } finally {
            log.info(LOG_TEMPLATE_1,
                "Wait for page is loaded", getTimeDifference(startTime), driverWrapper.getCurrentUrl());
        }
    }

    public void waitForConcretePageTitle(String title) {
        long startTime = System.currentTimeMillis();
        try {
            new FluentWait<>(driverWrapper.getDriver())
                .withTimeout(Duration.ofSeconds(10L))
                .pollingEvery(Duration.ofSeconds(1L))
                .until(driver -> driver.getCurrentUrl().equals(title));
        } catch (TimeoutException exception) {
            log.debug(String.format("Unable to wait for page with title:  %s", title));
        } finally {
            log.info(LOG_TEMPLATE_1,
                "Wait for concrete title", getTimeDifference(startTime), driverWrapper.getCurrentUrl());
        }
    }

    private String getTimeDifference(long startTime) {
        return String.valueOf(System.currentTimeMillis() - startTime);
    }
}
