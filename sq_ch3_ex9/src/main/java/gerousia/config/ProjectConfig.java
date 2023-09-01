package gerousia.config;

import gerousia.beans.Parrot;
import gerousia.beans.Person;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ProjectConfig {

    @Bean
    Parrot parrot1() {
        Parrot parrot = new Parrot();
        parrot.setName("Kiki");
        return parrot;
    }

    @Bean
    Parrot parrot2() {
        Parrot parrot = new Parrot();
        parrot.setName("Miki");
        return parrot;
    }

    @Bean
    Person person(
            @Qualifier("parrot2")
            Parrot parrot) {
        Person person = new Person();
        person.setName("Pirate");
        person.setParrot(parrot);
        return person;
    }
}
