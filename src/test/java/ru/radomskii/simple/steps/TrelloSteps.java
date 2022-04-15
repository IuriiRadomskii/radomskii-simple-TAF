package ru.radomskii.simple.steps;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.radomskii.simple.pages.TrelloMainPage;

@Component
public class TrelloSteps {

    @Autowired
    private TrelloMainPage trelloMainPage;

    public void openTrello() {
        trelloMainPage.openTrello();
    }
}
