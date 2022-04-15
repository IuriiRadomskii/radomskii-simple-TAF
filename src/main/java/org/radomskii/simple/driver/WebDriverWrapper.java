package org.radomskii.simple.driver;

import java.util.List;
import java.util.Set;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.springframework.stereotype.Component;

@Slf4j
@AllArgsConstructor
@Component
public class WebDriverWrapper implements WebDriver {

    private static final String LOG_TEMPLATE = "Action: {}; Execution time: {}; Page: {}; Find by: {}";

    private WebDriver driver;

    @Override
    public void get(String url) {
        log.info("Opening url: " + url);
        long startTime = System.currentTimeMillis();
        try {
            driver.get(url);
        } finally {
            log.info(LOG_TEMPLATE, "Open page", getTimeDifference(startTime), url);
        }
    }

    @Override
    public String getCurrentUrl() {
        return null;
    }

    @Override
    public String getTitle() {
        return null;
    }

    @Override
    public List<WebElement> findElements(By by) {
        return null;
    }

    @Override
    public WebElement findElement(By by) {
        return null;
    }

    @Override
    public String getPageSource() {
        return null;
    }

    @Override
    public void close() {

    }

    @Override
    public void quit() {

    }

    @Override
    public Set<String> getWindowHandles() {
        return null;
    }

    @Override
    public String getWindowHandle() {
        return null;
    }

    @Override
    public TargetLocator switchTo() {
        return null;
    }

    @Override
    public Navigation navigate() {
        return null;
    }

    @Override
    public Options manage() {
        return null;
    }

    private String getTimeDifference(long startTime) {
        return String.valueOf(System.currentTimeMillis() - startTime);
    }
}
