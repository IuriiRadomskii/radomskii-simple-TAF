package org.radomskii.simple.driver;

import java.time.Duration;
import lombok.extern.slf4j.Slf4j;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

@Component
@Lazy
@Slf4j
public class WebDriverHelper {

    private static final String LOG_TEMPLATE_1 = "{}; Execution time: {}; Page: {};";
    private static final String LOG_TEMPLATE_2 = "Find element: {}; Execution time: {}; Page: {};";
    private static final String LOG_TEMPLATE_3 = "Find elements: {}; Execution time: {}; Page: {};";

    @Autowired
    @Lazy
    private WebDriverWrapper driverWrapper;

    public void waitForPageIsComplete() {
        long startTime = System.currentTimeMillis();
        try {
            new WebDriverWait(driverWrapper.getDriver(), Duration.ofSeconds(4))
                .until((JavascriptExecutor) driverWrapper);
        } catch (TimeoutException exception) {
            log.debug(String.format("Unable to get JS answer %s", exception));
        } finally {
            log.info(LOG_TEMPLATE_1,
                "Wait for JS complete", getTimeDifference(startTime), driverWrapper.getCurrentUrl());
        }
    }

    private String getTimeDifference(long startTime) {
        return String.valueOf(System.currentTimeMillis() - startTime);
    }

}
