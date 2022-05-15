package org.radomskii.simple.config;

import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

@Slf4j
@Configuration
@ComponentScan(basePackages = "org.radomskii.simple")
@PropertySource("classpath:browser.properties")
public class DriverConfig {
}
