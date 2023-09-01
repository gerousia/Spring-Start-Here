package gerousia.config;

import gerousia.beans.Parrot;
import gerousia.beans.Person;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ProjectConfig {

    @Bean
    Parrot parrot() {
        Parrot parrot = new Parrot();
        parrot.setName("Kiki");
        return parrot;
    }

    @Bean
    Person person(Parrot parrot) { // Dependency Injection
        Person person = new Person();
        person.setName("Pirate");
        person.setParrot(parrot);
        return person ;
    }
}
