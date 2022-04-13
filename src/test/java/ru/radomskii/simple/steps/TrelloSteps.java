package ru.radomskii.simple.steps;

import org.openqa.selenium.WebDriver;

public class TrelloSteps extends BaseSteps {

    public TrelloSteps(WebDriver driver) {
        super(driver);
    }

    public void openTrello() {
        driver.get("https://trello.com/ru");
    }
}
