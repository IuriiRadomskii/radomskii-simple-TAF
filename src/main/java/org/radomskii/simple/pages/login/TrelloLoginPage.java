package org.radomskii.simple.pages.login;

import javax.annotation.PostConstruct;
import lombok.extern.slf4j.Slf4j;
import org.openqa.selenium.UsernameAndPassword;
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
public class TrelloLoginPage extends BasePage {

    @FindBy(id = "user")
    private WebElement userNameInput;

    @FindBy(id = "login")
    private WebElement loginWithAtlassianButton;

    @PostConstruct
    private void init() {
        PageFactory.initElements(driverWrapper, this);
    }

    public void sendUserName() {
        userNameInput.sendKeys(env.getProperty("trello.username"));
        driverHelper.waitForPageIsCompletelyLoaded();
        loginWithAtlassianButton.click();
        driverHelper.waitForConcretePageTitle("Log in to continue - Log in with Atlassian account");
    }

}
