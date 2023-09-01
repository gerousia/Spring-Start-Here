package gerousia;

import gerousia.beans.Parrot;
import gerousia.config.ProjectConfig;
import junit.framework.TestCase;
import junit.framework.TestSuite;
import org.junit.Assert;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.function.Supplier;

/**
 * Unit test for simple App.
 */
public class MainTest {

    @Test
    public void springContext_registerBeanTest_PreCreateObject() {

         // Given
        String expectedValue = "Kiki";
        AnnotationConfigApplicationContext context =
                new AnnotationConfigApplicationContext(ProjectConfig.class);

        // When
        final Parrot parrot = new Parrot();
        parrot.setName("Kiki");

        context.registerBean(
                "parrot1",
                Parrot.class,
                (() -> parrot)
        );

        Parrot parrot1 = context.getBean(Parrot.class);
        String actualValue = parrot1.getName();

        // Then
        Assert.assertEquals(expectedValue, actualValue);

        // Clean-up
        context.close();
    }

    @Test
    public void springContext_registerBeanTest_PreCreateObject_VerboseSupplier() {

        // Given
        String expectedValue = "Kiki";
        AnnotationConfigApplicationContext context =
                new AnnotationConfigApplicationContext(ProjectConfig.class);

        // When
        final Parrot parrot = new Parrot();
        parrot.setName("Kiki");

        Supplier<Parrot> parrotSupplier = () -> parrot;

        context.registerBean(
                "parrot1",
                Parrot.class,
                parrotSupplier
        );

        Parrot parrot1 = context.getBean(Parrot.class);
        String actualValue = parrot1.getName();

        // Then
        Assert.assertEquals(expectedValue, actualValue);

        // Clean-up
        context.close();

    }

    @Test
    public void springContext_registerBeanTest_NewObjectPerInvocation() {

        // Given
        String expectedValue = "Kiki";
        AnnotationConfigApplicationContext context =
                new AnnotationConfigApplicationContext(ProjectConfig.class);

        // When
        context.registerBean(
                "parrot1",
                Parrot.class,
                (() -> {
                    Parrot parrot = new Parrot();
                    parrot.setName("Kiki");
                    return parrot;
                })
        );

        Parrot parrot1 = context.getBean(Parrot.class);
        String actualValue = parrot1.getName();

        // Then
        Assert.assertEquals(expectedValue, actualValue);

        // Clean-up
        context.close();
    }

    @Test
    public void springContext_registerBeanTest_getBeanWithName() {

        // Given
        String expectedValue = "Kiki";
        AnnotationConfigApplicationContext context =
                new AnnotationConfigApplicationContext(ProjectConfig.class);

        // When
        final Parrot parrot = new Parrot();
        parrot.setName("Kiki");

        context.registerBean(
                "parrot1",
                Parrot.class,
                (() -> parrot)
        );

        Parrot parrot1 = context.getBean("parrot1", Parrot.class);
        String actualValue = parrot1.getName();

        // Then
        Assert.assertEquals(expectedValue, actualValue);

        // Clean-up
        context.close();
    }

    @Test
    public void springContext_registerBeanTest_getBeanWithConfigurator() {

        // Given
        String expectedValue = "Kiki";
        AnnotationConfigApplicationContext context =
                new AnnotationConfigApplicationContext(ProjectConfig.class);

        // When
        final Parrot parrot = new Parrot();
        parrot.setName("Kiki");

        context.registerBean(
                "parrot1",
                Parrot.class,
                (() -> parrot),
                bean -> bean.setPrimary(true)
        );

        Parrot parrot1 = context.getBean("parrot1", Parrot.class);
        String actualValue = parrot1.getName();

        // Then
        Assert.assertEquals(expectedValue, actualValue);

        // Clean-up
        context.close();
    }
}
