package com.goit.module15_hw_sprinbootsecurity;

import com.goit.module15_hw_sprinbootsecurity.configuration.ContextFactory;
import org.springframework.boot.Banner;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.flyway.FlywayAutoConfiguration;
import org.springframework.boot.builder.SpringApplicationBuilder;


@SpringBootApplication(exclude = FlywayAutoConfiguration.class)
public class Module16HwSpringBootSecurityCICDApplication {

    public static void main(String[] args) {

        new SpringApplicationBuilder()
            .sources(Module16HwSpringBootSecurityCICDApplication.class)
            .bannerMode(Banner.Mode.OFF)
            .contextFactory(new ContextFactory())
            .build()
            .run(args);
    }
}
