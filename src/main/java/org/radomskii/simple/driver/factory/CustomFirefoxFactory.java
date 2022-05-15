package org.radomskii.simple.driver.factory;

import com.codeborne.selenide.Browser;
import com.codeborne.selenide.Config;
import com.codeborne.selenide.webdriver.FirefoxDriverFactory;
import java.io.File;
import java.util.Map;
import javax.annotation.CheckReturnValue;
import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import lombok.extern.slf4j.Slf4j;
import org.openqa.selenium.Proxy;
import org.openqa.selenium.SessionNotCreatedException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.radomskii.simple.driver.WebDriverLogWrapper;

@Slf4j
public class CustomFirefoxFactory extends FirefoxDriverFactory {

    @Override
    @CheckReturnValue
    @Nonnull
    public WebDriver create(Config config, Browser browser, @Nullable Proxy proxy,
                            @Nullable File browserDownloadsFolder) {
        SessionNotCreatedException failure = null;
        for (int retries = 0; retries < 5; retries++) {
            try {
                return new WebDriverLogWrapper(new FirefoxDriver(createDriverService(config),
                    createCapabilities(config, browser, proxy, browserDownloadsFolder)));
            } catch (SessionNotCreatedException probablyPortAlreadyUsed) {
                log.error("Failed to start firefox", probablyPortAlreadyUsed);
                failure = probablyPortAlreadyUsed;
            }
        }
        throw failure;
    }

    @Override
    @CheckReturnValue
    @Nonnull
    public FirefoxOptions createCapabilities(Config config, Browser browser,
                                             @Nullable Proxy proxy, @Nullable File browserDownloadsFolder) {
        FirefoxOptions initialOptions = new FirefoxOptions();
        initialOptions.setHeadless(config.headless());
        setupBrowserBinary(config, initialOptions);
        setupPreferences(initialOptions);

        setupDownloadsFolder(initialOptions, browserDownloadsFolder);

        final FirefoxOptions options =
            initialOptions.merge(createCommonCapabilities(new FirefoxOptions(), config, browser, proxy));
        options.addArguments("-private");

        transferFirefoxProfileFromSystemProperties(options)
            .ifPresent(profile -> options.setProfile(profile));

        injectFirefoxPrefs(options);
        return options;
    }

    private void injectFirefoxPrefs(FirefoxOptions options) {
        if (options.getCapability("moz:firefoxOptions") != null) {
            Map<String, Map<String, Object>> mozOptions = cast(options.getCapability("moz:firefoxOptions"));

            if (mozOptions.containsKey("prefs")) {
                for (Map.Entry<String, Object> pref : mozOptions.get("prefs").entrySet()) {
                    options.addPreference(pref.getKey(), pref.getValue());
                }
            }
        }
    }
}
