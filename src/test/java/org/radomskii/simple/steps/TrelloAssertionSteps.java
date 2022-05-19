package org.radomskii.simple.steps;

import static com.codeborne.selenide.Condition.attribute;
import static com.codeborne.selenide.Condition.visible;

import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

@Lazy
@Component
public class TrelloAssertionSteps extends BaseStep {

    public void assertLoggedIn() {
        boardsPage.getHeader().shouldBe(visible);
        boardsPage.getUserIcon().shouldBe(visible);
        boardsPage.getUserIcon()
                  .shouldHave(attribute("title",
                      "iura_radomskii (iura_radomskii)"));
    }

    public void assertGoogleLoginForm() {
        loginWithGooglePage.getBaseHref()
                           .shouldHave(attribute("href", "https://accounts.google.com/"));
    }
}
