package org.radomskii.simple.steps;

import static com.codeborne.selenide.Condition.attribute;
import static com.codeborne.selenide.Condition.exist;
import static com.codeborne.selenide.Condition.visible;

import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

@Lazy
@Component
public class TrelloAssertionSteps extends BaseStep {

    public void assertLoggedIn() {
        boardsPage.getHeader().shouldBe(visible);
        boardsPage.getUserIcon().shouldBe(exist);
        boardsPage.getUserIcon()
                  .shouldHave(attribute("title",
                      "iura_radomskii (iura_radomskii)"));
    }
}
