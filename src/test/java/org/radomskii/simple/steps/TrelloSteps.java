package org.radomskii.simple.steps;

import static com.codeborne.selenide.Selenide.page;

import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

@Lazy
@Component
public class TrelloSteps extends BaseStep {

    public void openTrello() {
        trelloStartPage.openTrello();
    }

    public void loginOn() {
        trelloStartPage.clickLogInButton();
        trelloLoginPage.sendUserName();
        atlassianLoginPage.sendPassword();
    }

    public void clickLogInButton() {
        trelloStartPage.clickLogInButton();
    }

    public void clickContinueWithGoogle() {
        trelloLoginPage.clickContinueWithGoogle();
    }
}
