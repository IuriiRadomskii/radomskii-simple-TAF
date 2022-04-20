package org.radomskii.simple.steps;

import org.radomskii.simple.pages.TrelloLoginPage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;

public class BaseStep {

    @Autowired
    @Lazy
    protected TrelloLoginPage trelloLoginPage;

}
