package org.radomskii.simple.pages;

import javax.annotation.PostConstruct;
import lombok.extern.slf4j.Slf4j;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

@Slf4j
@Lazy
@Component
public class TrelloLoginPage extends BasePage {

    @FindBy(xpath = "//a[@href='/login']")
    private WebElement loginOnTrelloButton;

    @FindBy(id = "use-sso-button")
    private WebElement useSsoButton;

    @FindBy(id = "user")
    private WebElement userNameInput;

    @FindBy(id = "login")
    private WebElement loginWithAtlassianButton;

    @FindBy(id = "password")
    private WebElement passwordInput;

    @FindBy(id = "login-submit")
    private WebElement loginButton;

    @PostConstruct
    private void init() {
        PageFactory.initElements(driverWrapper.getDriver(), this);
    }

    public void openTrello() {
        driverWrapper.get("https://trello.com");
    }

    public void loginOn() {
        loginOnTrelloButton.click();
        useSsoButton.click();
        userNameInput.sendKeys(""); //TODO Add password and username injections
        loginWithAtlassianButton.click();
        passwordInput.sendKeys("");
        loginButton.click();
    }
}
