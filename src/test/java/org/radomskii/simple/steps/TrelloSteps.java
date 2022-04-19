package org.radomskii.simple.steps;

import org.radomskii.simple.pages.TrelloMainPage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class TrelloSteps {

    @Autowired
    private TrelloMainPage trelloMainPage;

    public void openTrello() {
        trelloMainPage.openTrello();
    }
}
