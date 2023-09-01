package org.config;

import org.beans.Parrot;
import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.NoSuchBeanDefinitionException;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class ProjectConfigTest {

    @Test
    public void testSpringContext_Parrot1BeanName() {

        // Given
        String expectedOutput = "Koko";
        // Spring Context Configuration Initialization
        AnnotationConfigApplicationContext context =
                new AnnotationConfigApplicationContext(ProjectConfig.class);

        // When
        Parrot parrot = context.getBean("parrot1", Parrot.class);
        String actualOutput = parrot.getName();

        // Then
        Assert.assertEquals(expectedOutput, actualOutput);

        context.close();
    }

    @Test
    public void testSpringContext_Parrot1Bean_IsPrimary() {

        // Given
        String expectedOutput = "Koko";
        // Spring Context Configuration Initialization
        AnnotationConfigApplicationContext context =
                new AnnotationConfigApplicationContext(ProjectConfig.class);

        // When
        Parrot parrot = context.getBean(Parrot.class);
        String actualOutput = parrot.getName();

        // Then
        Assert.assertEquals(expectedOutput, actualOutput);

        // Clean-up
        context.close();

    }

    @Test
    public void testSpringContext_Parrot2BeanName_ValueSet() {

        // Given
        String expectedOutput = "Miki";
        // Spring Context Configuration Initialization
        AnnotationConfigApplicationContext context =
                new AnnotationConfigApplicationContext(ProjectConfig.class);

        // When
        Parrot parrot = context.getBean("Miki", Parrot.class);
        String actualOutput = parrot.getName();

        // Then
        Assert.assertEquals(expectedOutput, actualOutput);

        // Clean-up
        context.close();
    }

    @Test
    public void testSpringContext_Parrot2Beans_NameNotParrot2() {
        String beanName = "parrot2";

        // When
        // Spring Context Configuration Initialization
        AnnotationConfigApplicationContext context =
                new AnnotationConfigApplicationContext(ProjectConfig.class);

        // Given
        Exception exception = Assert.assertThrows(NoSuchBeanDefinitionException.class, () -> {
            Parrot parrot = context.getBean(beanName, Parrot.class);
        });

        String expectedMessage = "No bean named '" + beanName + "' available";
        String actualMessage = exception.getMessage();

        // Then
        Assert.assertTrue(actualMessage.contains(expectedMessage));

        // Clean-up
        context.close();
    }

    @Test
    public void testSpringContext_Parrot3BeanName() {

        // Given
        String expectedOutput = "Riki";
        // Spring Context Configuration Initialization
        AnnotationConfigApplicationContext context =
                new AnnotationConfigApplicationContext(ProjectConfig.class);

        // When
        Parrot parrot = context.getBean("parrot3", Parrot.class);
        String actualOutput = parrot.getName();

        // Then
        Assert.assertEquals(expectedOutput, actualOutput);

        // Clean-up
        context.close();
    }
}
