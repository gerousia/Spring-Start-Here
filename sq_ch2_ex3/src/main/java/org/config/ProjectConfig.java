package org.config;

import org.beans.Parrot;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

@Configuration
public class ProjectConfig {

    @Bean
    @Primary
    Parrot parrot1() {
        Parrot parrot = new Parrot();
        parrot.setName("Koko");
        return parrot;
    }

    @Bean(value = "Miki")
    Parrot parrot2() {
        Parrot parrot = new Parrot();
        parrot.setName("Miki");
        return parrot;
    }

    @Bean
    Parrot parrot3() {
        Parrot parrot = new Parrot();
        parrot.setName("Riki");
        return parrot;
    }
}
