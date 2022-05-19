package org.radomskii.simple.pages.login.sideLoginResources;

import static com.codeborne.selenide.Selenide.$x;

import com.codeborne.selenide.SelenideElement;
import lombok.Getter;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

@Lazy
@Component
@Getter
public class LoginWithGooglePage {

    private SelenideElement baseHref = $x("//base[@href='https://accounts.google.com/']");

}
