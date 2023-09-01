package gerousia.config;

import gerousia.beans.Parrot;
import org.junit.Assert;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class ProjectConfigTest {

    @Test
    public void springContext_componentTest() {

        // Given
        AnnotationConfigApplicationContext context =
                new AnnotationConfigApplicationContext(ProjectConfig.class);

        // When
        Parrot parrot = context.getBean(Parrot.class);
        String actualValue = parrot.getName();

        // Then
        Assert.assertNull(actualValue);
    }
}
