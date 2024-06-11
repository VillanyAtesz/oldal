package com.github.villany_atesz.oldal.filter;

import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
class FilterConfig {
    @Bean
    FilterRegistrationBean<BejelentkezesEllenorzo> bejelentkezesEllenorzoFilterRegBean(BejelentkezesEllenorzo bejelentkezesEllenorzo) {
        FilterRegistrationBean<BejelentkezesEllenorzo> registrationBean = new FilterRegistrationBean<>();
        registrationBean.setFilter(bejelentkezesEllenorzo);
        registrationBean.addUrlPatterns(
            "/api/*",
            "/web/*"
        );
        return registrationBean;
    }
}
