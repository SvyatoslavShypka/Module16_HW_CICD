package com.goit.module15_hw_sprinbootsecurity.configuration;

import org.springframework.boot.ApplicationContextFactory;
import org.springframework.boot.WebApplicationType;
import org.springframework.context.ConfigurableApplicationContext;

public class ContextFactory implements ApplicationContextFactory {

    @Override
    public ConfigurableApplicationContext create(WebApplicationType webApplicationType) {
        LoggerConfiguration.setupLogger();
        return ApplicationContextFactory.DEFAULT.create(webApplicationType);
    }
}
