package org.main;

import org.config.ProjectConfig;
import org.beans.Parrot;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * Hello world!
 *
 */
public class App {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext context =
                new AnnotationConfigApplicationContext(ProjectConfig.class);

        Parrot parrot = context.getBean(Parrot.class);
        System.out.println(parrot.getName());

        String string = context.getBean(String.class);
        System.out.println(string);

        Integer integer = context.getBean(Integer.class);
        System.out.println(integer);
    }
}
