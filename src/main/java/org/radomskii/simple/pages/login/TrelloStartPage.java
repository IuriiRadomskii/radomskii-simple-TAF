package org.radomskii.simple.pages.login;

import static com.codeborne.selenide.Selenide.$x;
import static com.codeborne.selenide.Selenide.open;

import com.codeborne.selenide.SelenideElement;
import org.radomskii.simple.pages.AbstractBasePage;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

@Lazy
@Component
public class TrelloStartPage extends AbstractBasePage {

    private SelenideElement logInButton = $x("//a[@href='/login']");

    public void openTrello() {
        open(BASE_URI);
    }

    public void clickLogInButton() {
        logInButton.click();
    }
}
