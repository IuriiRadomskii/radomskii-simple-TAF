package org.radomskii.simple.tests;

import org.junit.jupiter.api.Test;
import org.radomskii.simple.config.TestConfig;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.annotation.DirtiesContext.ClassMode;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;

@SpringJUnitConfig(classes = TestConfig.class)
@DirtiesContext(classMode = ClassMode.BEFORE_CLASS)
public class SimpleLoginTests extends BaseTest {

    @Test
    public void positiveLoginTest() {
        steps.openTrello();
        steps.loginOn();
        assertionSteps.assertLoggedIn();
    }

    @Test
    public void googleLoginFormTest() {
        steps.openTrello();
        steps.clickLogInButton();
        steps.clickContinueWithGoogle();
        assertionSteps.assertGoogleLoginForm();

    }
}
