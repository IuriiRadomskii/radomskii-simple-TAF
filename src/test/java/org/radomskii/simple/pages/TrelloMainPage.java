package org.radomskii.simple.pages;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class TrelloMainPage extends BasePage {

    public void openTrello() {
        log.info("Opening https://trello.com ...");
        driverWrapper.get("https://trello.com");
    }
}
