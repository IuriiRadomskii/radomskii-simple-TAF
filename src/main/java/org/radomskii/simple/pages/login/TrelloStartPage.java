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
public class TrelloStartPage extends AbstractBasePage {

    @FindBy(xpath = "//a[@href='/login']")
    private WebElement logInButton;

    /*@PostConstruct
    private void init() {
        PageFactory.initElements(driverWrapper, this);
    }*/

    public void openTrello() {
        driverWrapper.get(BASE_URI);
        driverHelper.waitForPageIsLoaded();
    }

    public void clickLogInButton() {
        logInButton.click();
    }
}
