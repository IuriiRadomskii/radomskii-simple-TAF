package org.radomskii.simple.pages.login;

import lombok.extern.slf4j.Slf4j;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.radomskii.simple.pages.AbstractBasePage;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

@Slf4j
@Lazy
@Component
public class AtlassianLoginPage extends AbstractBasePage {

    @FindBy(id = "password")
    private WebElement passwordInput;

    @FindBy(id ="login-submit")
    private WebElement submitButton;

    private By trelloHeader = By.id("header");

    /*@PostConstruct
    private void init() {
        PageFactory.initElements(driverWrapper, this);
    }*/

    public void sendPassword() {
        passwordInput.sendKeys(env.getProperty("trello.password"));
        submitButton.click();
        driverHelper.waitForElement(trelloHeader);
    }

}
