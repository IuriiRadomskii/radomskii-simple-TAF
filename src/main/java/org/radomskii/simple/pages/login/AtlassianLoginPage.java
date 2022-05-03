package org.radomskii.simple.pages.login;

import javax.annotation.PostConstruct;
import lombok.extern.slf4j.Slf4j;
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
public class AtlassianLoginPage extends BasePage {

    @FindBy(id = "password")
    private WebElement passwordInput;

    @FindBy(id ="login-submit")
    private WebElement submitButton;

    @PostConstruct
    private void init() {
        PageFactory.initElements(driverWrapper, this);
    }

    public void sendPassword() {
        passwordInput.sendKeys(env.getProperty("trello.password"));
        submitButton.click();
        driverHelper.waitForConcretePageTitle("Boards | Trello");
    }

}
