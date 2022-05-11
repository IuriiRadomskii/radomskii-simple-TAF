package org.radomskii.simple.driver;

import java.time.Duration;
import lombok.extern.slf4j.Slf4j;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

@Lazy
@Component
@Slf4j
public class WebDriverHelper {

    private static final String LOG_TEMPLATE_1 = "{}; Execution time: {}; Page: {};";
    private static final String LOG_TEMPLATE_2 = "Action: {}; Element: {}; Execution time: {}; Page: {};";

    @Autowired
    @Lazy
    private WebDriverWrapper driverWrapper;

    public void waitForPageIsLoaded() {
        long startTime = System.currentTimeMillis();
        try {
            new FluentWait<>(driverWrapper.getDriver())
                .withTimeout(Duration.ofSeconds(5L))
                .pollingEvery(Duration.ofMillis(500L))
                .until(driver -> {
                    JavascriptExecutor js = (JavascriptExecutor) driver;
                    return js.executeScript("return document.readyState").toString().equals("complete");
                });
        } catch (TimeoutException exception) {
            log.debug(String.format("Unable to wait for page to complete with:  %s", exception));
        } finally {
            log.info(LOG_TEMPLATE_1,
                "Wait for page is loaded", getTimeDifference(startTime), driverWrapper.getCurrentUrl());
        }
    }

    public void waitForConcretePageTitle(String title) {
        long startTime = System.currentTimeMillis();
        try {
            new FluentWait<>(driverWrapper.getDriver())
                .withTimeout(Duration.ofSeconds(4L))
                .pollingEvery(Duration.ofMillis(500L))
                .until(driver -> driver.getCurrentUrl().equals(title));
        } catch (TimeoutException exception) {
            log.debug(String.format("Unable to wait for page with title:  %s", title));
        } finally {
            log.info(LOG_TEMPLATE_1,
                "Wait for concrete title", getTimeDifference(startTime), driverWrapper.getCurrentUrl());
        }
    }

    public String getCookie() {
        JavascriptExecutor js = (JavascriptExecutor) driverWrapper.getDriver();
        return (String) js.executeScript("return document.cookie");
    }

    public void waitForElement(By by) {
        long startTime = System.currentTimeMillis();
        try {
            new FluentWait<>(driverWrapper.getDriver())
                .withTimeout(Duration.ofSeconds(4L))
                .pollingEvery(Duration.ofMillis(500L))
                .ignoring(NoSuchElementException.class)
                .until(driver -> driver.findElement(by));
        } catch (TimeoutException exception) {
            log.debug(String.format("Unable to wait for element:  %s", by));
        } finally {
            log.info(LOG_TEMPLATE_1,
                "Wait for element", getTimeDifference(startTime), driverWrapper.getCurrentUrl());
        }
    }

    public void click(WebElement element) {
        long startTime = System.currentTimeMillis();
        try {
            new WebDriverWait(driverWrapper.getDriver(), Duration.ofSeconds(4))
                .until(ExpectedConditions.elementToBeClickable(element));
        } catch (TimeoutException exception) {
            log.debug(String.format("Unable to wait for element is clickable:  %s", exception));
        } finally {
            log.info(LOG_TEMPLATE_1,
                "Wait for element is clickable", getTimeDifference(startTime), driverWrapper.getCurrentUrl());
        }
    }

    private String getTimeDifference(long startTime) {
        return String.valueOf(System.currentTimeMillis() - startTime);
    }
}
