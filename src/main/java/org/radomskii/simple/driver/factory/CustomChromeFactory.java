package org.radomskii.simple.driver.factory;

import static org.apache.commons.lang3.StringUtils.isNotEmpty;

import com.codeborne.selenide.Browser;
import com.codeborne.selenide.Config;
import com.codeborne.selenide.webdriver.ChromeDriverFactory;
import java.io.File;
import javax.annotation.CheckReturnValue;
import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import lombok.extern.slf4j.Slf4j;
import org.openqa.selenium.MutableCapabilities;
import org.openqa.selenium.Proxy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.radomskii.simple.driver.WebDriverLogWrapper;

@Slf4j
public class CustomChromeFactory extends ChromeDriverFactory {

    @Override
    @CheckReturnValue
    @Nonnull
    @SuppressWarnings("deprecation")
    public WebDriver create(Config config, Browser browser, @Nullable Proxy proxy,
                            @Nullable File browserDownloadsFolder) {
        MutableCapabilities chromeOptions = createCapabilities(config, browser, proxy, browserDownloadsFolder);
        log.debug("Chrome options: {}", chromeOptions);
        return new WebDriverLogWrapper(new ChromeDriver(buildService(config), chromeOptions));
    }

    @Override
    @CheckReturnValue
    @Nonnull
    public MutableCapabilities createCapabilities(Config config, Browser browser,
                                                  @Nullable Proxy proxy, @Nullable File browserDownloadsFolder) {
        ChromeOptions commonCapabilities = createCommonCapabilities(new ChromeOptions(), config, browser, proxy);

        ChromeOptions options = new ChromeOptions();
        options.setHeadless(config.headless());
        if (isNotEmpty(config.browserBinary())) {
            log.info("Using browser binary: {}", config.browserBinary());
            options.setBinary(config.browserBinary());
        }
        options.addArguments(createChromeArguments(config, browser));
        options.addArguments(
            "--incognito",
            "--start-maximized");
        options.setExperimentalOption("excludeSwitches", excludeSwitches(commonCapabilities));
        options.setExperimentalOption("prefs",
            prefs(browserDownloadsFolder, System.getProperty("chromeoptions.prefs", "")));

        return options.merge(commonCapabilities);
    }
}
