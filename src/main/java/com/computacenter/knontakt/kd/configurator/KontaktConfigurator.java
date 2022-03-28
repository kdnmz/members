package com.computacenter.knontakt.kd.configurator;

import org.dozer.DozerBeanMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class KontaktConfigurator {

    @Bean
    public DozerBeanMapper dozerBeanMapper(){
        return new DozerBeanMapper();
    }
}
