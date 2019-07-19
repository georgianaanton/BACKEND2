package com.georgiana.certification.infra.configurations;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.web.client.RestTemplate;

@EnableJpaRepositories(basePackages = AppConfiguration.BASE_PACKAGES)
@ComponentScan(basePackages = AppConfiguration.BASE_PACKAGES)
public class AppConfiguration {
    static final String BASE_PACKAGES = "com.georgiana.certification";

    @Bean
    public RestTemplate restTemplate() {
        return new RestTemplate();
    }
}
