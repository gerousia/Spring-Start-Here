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
    public void springContext_multipleInstances_directMethodWiringTest() {

        // Given
        AnnotationConfigApplicationContext context =
                new AnnotationConfigApplicationContext(ProjectConfig.class);

        // When
        Parrot expectedObject = context.getBean(Parrot.class);
        Person person = context.getBean(Person.class);
        Parrot actualObject = person.getParrot();

        // Then
        Assert.assertEquals(expectedObject, actualObject);

        // Clean-up
        context.close();
    }
}
