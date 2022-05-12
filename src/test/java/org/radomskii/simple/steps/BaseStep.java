package org.radomskii.simple.steps;

import org.radomskii.simple.pages.BoardsPage;
import org.radomskii.simple.pages.login.AtlassianLoginPage;
import org.radomskii.simple.pages.login.TrelloLoginPage;
import org.radomskii.simple.pages.login.TrelloStartPage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;

public class BaseStep {

    @Autowired
    @Lazy
    protected TrelloStartPage trelloStartPage;

    @Autowired
    @Lazy
    protected TrelloLoginPage trelloLoginPage;

    @Autowired
    @Lazy
    protected AtlassianLoginPage atlassianLoginPage;

    @Autowired
    @Lazy
    protected BoardsPage boardsPage;

}
