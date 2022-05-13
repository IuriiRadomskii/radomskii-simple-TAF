package org.radomskii.simple.tests;

import static com.codeborne.selenide.Selenide.$;

import com.codeborne.selenide.Condition;
import org.junit.jupiter.api.Test;
import org.radomskii.simple.config.TestConfig;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.annotation.DirtiesContext.ClassMode;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;

@SpringJUnitConfig(classes = TestConfig.class)
@DirtiesContext(classMode = ClassMode.BEFORE_EACH_TEST_METHOD)
public class SimpleLoginTests extends BaseTest {

    @Test
    public void positiveLoginTest() {
        steps.openTrello();
        steps.loginOn();
        assertionSteps.assertLoggedIn();
    }
}
