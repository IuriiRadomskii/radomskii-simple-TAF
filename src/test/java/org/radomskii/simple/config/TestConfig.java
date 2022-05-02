package org.radomskii.simple.config;

import lombok.extern.slf4j.Slf4j;
import org.radomskii.simple.pages.login.CredentialsConfig;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

@Slf4j
@Configuration
@Import({WebDriverConfig.class, CredentialsConfig.class})
@ComponentScan(basePackages = "org.radomskii.simple")
public class TestConfig {

}
