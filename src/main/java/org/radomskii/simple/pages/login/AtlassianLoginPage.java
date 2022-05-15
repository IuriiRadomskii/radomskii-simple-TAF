package org.radomskii.simple.pages.login;

import static com.codeborne.selenide.Selenide.$;

import com.codeborne.selenide.SelenideElement;
import lombok.extern.slf4j.Slf4j;
import org.openqa.selenium.By;
import org.radomskii.simple.pages.AbstractBasePage;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

@Slf4j
@Lazy
@Component
public class AtlassianLoginPage extends AbstractBasePage {

    private SelenideElement passwordInput = $(By.id("password"));

    private SelenideElement submitButton = $(By.id("login-submit"));

    public void sendPassword() {
        passwordInput.sendKeys(env.getProperty("trello.password"));
        submitButton.click();
    }
}
