package org.radomskii.simple.pages.login;

import javax.annotation.PostConstruct;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.radomskii.simple.pages.BasePage;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

@Slf4j
@Lazy
@Component
public class TrelloStartPage extends BasePage {

    @FindBy(xpath = "//a[@href='/login']")
    private WebElement logInButton;

    @PostConstruct
    private void init() {
        PageFactory.initElements(driverWrapper, this);
    }

    public void openTrello() {
        driverWrapper.get("https://trello.com");
        driverHelper.waitForPageIsCompletelyLoaded();
    }

    public void clickLogInButton() {
        logInButton.click();
        driverHelper.waitForConcretePageTitle("Log in to Trello");
    }
}
