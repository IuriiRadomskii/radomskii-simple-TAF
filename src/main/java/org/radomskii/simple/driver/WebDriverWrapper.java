package org.radomskii.simple.driver;

import java.time.Duration;
import java.util.List;
import java.util.Set;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.extern.slf4j.Slf4j;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.FluentWait;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

@Slf4j
@AllArgsConstructor
@Lazy
@Component
public class WebDriverWrapper implements WebDriver {

    private static final String LOG_TEMPLATE_1 = "{}; Execution time: {}; Page: {};";
    private static final String LOG_TEMPLATE_2 = "Find element: {}; Execution time: {}; Page: {};";
    private static final String LOG_TEMPLATE_3 = "Find elements: {}; Execution time: {}; Page: {};";

    @Getter
    private WebDriver driver;

    @Override
    public void get(String url) {
        log.debug("Opening url: " + url);
        long startTime = System.currentTimeMillis();
        try {
            driver.get(url);
        } finally {
            log.info(LOG_TEMPLATE_1, "Open page", getTimeDifference(startTime), url);
        }
    }

    @Override
    public String getCurrentUrl() {
        return driver.getCurrentUrl();
    }

    @Override
    public String getTitle() {
        return driver.getTitle();
    }

    @Override
    public List<WebElement> findElements(By by) {
        log.debug("Finding elements: " + by);
        long startTime = System.currentTimeMillis();
        try {
            return new FluentWait<>(driver)
                .withTimeout(Duration.ofSeconds(5))
                .pollingEvery(Duration.ofMillis(500))
                .until(driver -> driver.findElements(by));
        } finally {
            log.info(LOG_TEMPLATE_3, by, getTimeDifference(startTime), getCurrentUrl());
        }
    }

    @Override
    public WebElement findElement(By by) {
        log.debug("Finding element: " + by);
        long startTime = System.currentTimeMillis();
        try {
            return new FluentWait<>(driver)
                .withTimeout(Duration.ofSeconds(5))
                .pollingEvery(Duration.ofMillis(500))
                .until(driver -> driver.findElement(by));
        } finally {
            log.info(LOG_TEMPLATE_2, by, getTimeDifference(startTime), getCurrentUrl());
        }
    }

    @Override
    public String getPageSource() {
        return driver.getPageSource();
    }

    @Override
    public void close() {
        log.debug("Closing browser ... " + driver.toString());
        long startTime = System.currentTimeMillis();
        try {
            driver.close();
        } finally {
            log.info(LOG_TEMPLATE_1, "Close driver", getTimeDifference(startTime));
        }
    }

    @Override
    public void quit() {
        log.debug("Quiting driver ... " + driver.toString());
        long startTime = System.currentTimeMillis();
        try {
            driver.quit();
        } finally {
            log.info(LOG_TEMPLATE_1, "Quit driver", getTimeDifference(startTime));
        }
    }

    @Override
    public Set<String> getWindowHandles() {
        return driver.getWindowHandles();
    }

    @Override
    public String getWindowHandle() {
        return driver.getWindowHandle();
    }

    @Override
    public TargetLocator switchTo() {
        return driver.switchTo();
    }

    @Override
    public Navigation navigate() {
        return driver.navigate();
    }

    @Override
    public Options manage() {
        return driver.manage();
    }

    private String getTimeDifference(long startTime) {
        return String.valueOf(System.currentTimeMillis() - startTime);
    }
}
