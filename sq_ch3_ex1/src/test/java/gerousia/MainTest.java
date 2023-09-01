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
    public void springContext_MultipleInstancesAndRelationshipTest() {

        // Given
        String expectedValue1 = "Kiki";
        String expectedValue2 = "Pirate";

        AnnotationConfigApplicationContext context =
                new AnnotationConfigApplicationContext(ProjectConfig.class);

        // When
        Parrot parrot = context.getBean(Parrot.class);
        Person person = context.getBean(Person.class);

        String actualValue1 = parrot.getName();
        String actualValue2 = person.getName();

        // Then
        Assert.assertEquals(expectedValue1, actualValue1);
        Assert.assertEquals(expectedValue2, actualValue2);
        Assert.assertNull(person.getParrot());

        // Clean-up
        context.close();
    }
}
