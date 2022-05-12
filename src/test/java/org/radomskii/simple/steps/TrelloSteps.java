package org.radomskii.simple.steps;

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
}
