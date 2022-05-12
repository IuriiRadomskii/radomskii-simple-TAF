package org.radomskii.simple.tests;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.TestInstance.Lifecycle;
import org.radomskii.simple.steps.TrelloSteps;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;

@Slf4j
@TestInstance(Lifecycle.PER_CLASS)
public class BaseTest {

    @Lazy
    @Autowired
    protected TrelloSteps steps;
}
