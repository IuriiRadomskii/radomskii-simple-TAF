package org.radomskii.simple.pages;

import lombok.Getter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.env.Environment;

@Getter
public abstract class AbstractBasePage {

    @Value("${baseUri}")
    protected String BASE_URI;

    @Autowired
    protected Environment env;
}
