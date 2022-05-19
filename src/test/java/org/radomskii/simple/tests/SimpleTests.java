package org.radomskii.simple.tests;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.radomskii.simple.config.TestConfig;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;

@SpringJUnitConfig(classes = TestConfig.class)
public class SimpleTests extends BaseTest {

    @BeforeEach
    public void performLogin() {
        steps.openTrello();
        steps.loginOn();
    }

    @Test
    public void createBoardTest() {

    }

}

