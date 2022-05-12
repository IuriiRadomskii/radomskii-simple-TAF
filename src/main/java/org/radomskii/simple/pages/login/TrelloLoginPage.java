package org.radomskii.simple.pages.login;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$x;

import com.codeborne.selenide.SelenideElement;
import lombok.extern.slf4j.Slf4j;
import org.openqa.selenium.By;
import org.radomskii.simple.pages.AbstractBasePage;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

@Slf4j
@Lazy
@Component
public class TrelloLoginPage extends AbstractBasePage {

    private SelenideElement userNameInput = $(By.id("user"));

    private SelenideElement loginWithAtlassianButton = $x("//input[contains(@value, 'Atlassian')]");

    public void sendUserName() {
        userNameInput.sendKeys(env.getProperty("trello.username"));
        loginWithAtlassianButton.click();
    }
}
