package org.radomskii.simple.driver;

import java.util.List;
import java.util.Set;
import javax.annotation.PreDestroy;
import lombok.AllArgsConstructor;
import lombok.Getter;
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

    @Getter
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
        return driver.getCurrentUrl();
    }

    @Override
    public String getTitle() {
        return driver.getTitle();
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
        return driver.getPageSource();
    }

    @Override
    public void close() {
        log.info("Closing browser ... " + driver.toString());
        long startTime = System.currentTimeMillis();
        try {
            driver.quit();
        } finally {
            log.info(LOG_TEMPLATE, "Close driver", getTimeDifference(startTime));
        }
    }

    @Override
    public void quit() {
        log.info("Quiting driver ... " + driver.toString());
        long startTime = System.currentTimeMillis();
        try {
            driver.quit();
        } finally {
            log.info(LOG_TEMPLATE, "Quit driver", getTimeDifference(startTime));
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
