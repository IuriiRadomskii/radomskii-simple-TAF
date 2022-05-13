package org.radomskii.simple.pages;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$x;

import com.codeborne.selenide.SelenideElement;
import lombok.Getter;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

@Slf4j
@Lazy
@Component
@Getter
public class BoardsPage extends AbstractBasePage {

    private SelenideElement header = $("div#header");
    private SelenideElement userIcon = $x("//span[contains(@style, '32px')]");
}
