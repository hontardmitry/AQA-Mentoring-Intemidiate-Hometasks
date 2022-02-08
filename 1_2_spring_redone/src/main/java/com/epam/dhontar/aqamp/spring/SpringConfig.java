package com.epam.dhontar.aqamp.spring;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

@Configuration
@ComponentScan("com.epam.dhontar.aqamp.spring")
@PropertySource("classpath:musicPlayer.properties")
public class SpringConfig {
}
