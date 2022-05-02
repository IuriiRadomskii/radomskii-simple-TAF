package org.radomskii.simple.pages.login;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

@Configuration
@PropertySource("classpath:credentials.properties")
public class CredentialsConfig {
}
