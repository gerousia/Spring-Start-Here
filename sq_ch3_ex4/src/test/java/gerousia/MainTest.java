package gerousia;

import gerousia.beans.Parrot;
import gerousia.beans.Person;
import gerousia.config.ProjectConfig;
import junit.framework.TestCase;
import junit.framework.TestSuite;
import org.junit.Assert;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * Unit test for simple App.
 */
public class MainTest {

    @Test
    public void springContext_autoWiredAnnotationTest() {

        // Given
        AnnotationConfigApplicationContext context =
                new AnnotationConfigApplicationContext(ProjectConfig.class);

        // When
        Parrot expectedValue = context.getBean(Parrot.class);
        Person person = context.getBean(Person.class);

        Parrot actualValue = person.getParrot();

        // Then
        Assert.assertEquals(expectedValue, actualValue);

        // Clean-up
        context.close();
    }
}