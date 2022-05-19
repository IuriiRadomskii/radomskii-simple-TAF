package org.radomskii.simple.pages.login;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$x;

import com.codeborne.selenide.SelenideElement;
import lombok.Getter;
import org.radomskii.simple.pages.AbstractBasePage;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

@Lazy
@Component
@Getter
public class TrelloLoginPage extends AbstractBasePage {

    private SelenideElement userNameInput = $("#user");
    private SelenideElement loginWithAtlassianButton = $x("//input[contains(@value, 'Atlassian')]");
    private SelenideElement continueWithGoogleButton = $("#googleButton");

    public void sendUserName() {
        userNameInput.sendKeys(env.getProperty("trello.user.USERNAME"));
        loginWithAtlassianButton.click();
    }

    public void clickContinueWithGoogle() {
        continueWithGoogleButton.click();
    }
}
