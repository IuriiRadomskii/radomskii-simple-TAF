package org.radomskii.simple.steps;

import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

@Lazy
@Component
public class TrelloSteps extends BaseStep {

    public void openTrello() {
        trelloLoginPage.openTrello();
    }

    public void loginOn() {
        trelloLoginPage.loginOn();
    }
}
