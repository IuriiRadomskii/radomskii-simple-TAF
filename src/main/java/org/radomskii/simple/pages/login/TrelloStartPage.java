package org.radomskii.simple.pages.login;

import static com.codeborne.selenide.Selenide.$x;
import static com.codeborne.selenide.Selenide.open;

import com.codeborne.selenide.SelenideElement;
import lombok.extern.slf4j.Slf4j;
import org.radomskii.simple.pages.AbstractBasePage;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

@Slf4j
@Lazy
@Component
public class TrelloStartPage extends AbstractBasePage {

    private SelenideElement logInButton = $x("//a[@href='/login']");

    public void openTrello() {
        open("https://trello.com");
    }

    public void clickLogInButton() {
        logInButton.click();
    }
}
