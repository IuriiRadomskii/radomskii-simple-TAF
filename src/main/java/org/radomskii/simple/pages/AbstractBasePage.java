package org.radomskii.simple.pages;

import static com.codeborne.selenide.Selenide.title;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.env.Environment;

@Slf4j
public abstract class AbstractBasePage {

    @Value("${baseUri}")
    protected String BASE_URI;

    @Autowired
    protected Environment env;

}
