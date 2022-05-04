package org.radomskii.simple.pages.login;

import lombok.extern.slf4j.Slf4j;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.radomskii.simple.pages.AbstractBasePage;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

@Slf4j
@Lazy
@Component
public class TrelloLoginPage extends AbstractBasePage {

    @FindBy(id = "user")
    private WebElement userNameInput;

    @FindBy(xpath = "//input[contains(@value, 'Atlassian')]")
    private WebElement loginWithAtlassianButton;

    /*@PostConstruct
    private void init() {
        PageFactory.initElements(driverWrapper, this);
    }*/

    public void sendUserName() {
        userNameInput.sendKeys(env.getProperty("trello.username"));
        loginWithAtlassianButton.click();
    }

}
