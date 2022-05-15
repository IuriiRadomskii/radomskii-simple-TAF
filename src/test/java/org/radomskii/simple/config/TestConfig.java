package org.radomskii.simple.config;

import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

@Slf4j
@Configuration
@ComponentScan(basePackages = "org.radomskii.simple")
@Import(DriverConfig.class)
public class TestConfig {

}
