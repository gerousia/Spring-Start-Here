package org.config;

import org.beans.Parrot;
import org.junit.Assert;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class ProjectConfigTest  {

    @Test
    public void testNoArgsParrotClass_AttributeIsNull() {
        String actualOutput = new Parrot().getName();

        Assert.assertNull(actualOutput);
    }

    @Test
    public void testSpringContext_ParrotBean_IsKoko() {
        String expectedOutput = "Koko";

        // Spring Context Configuration Initialization
        AnnotationConfigApplicationContext context =
                new AnnotationConfigApplicationContext(ProjectConfig.class);

        // Bean Context invocation
        Parrot parrot = context.getBean(Parrot.class);
        String actualOutput = parrot.getName();

        Assert.assertEquals(expectedOutput, actualOutput);
    }

    @Test
    public void testSpringContext_StringBean_IsHello() {
        String expectedOutput = "Hello";

        // Spring Context Configuration Initialization
        AnnotationConfigApplicationContext context =
                new AnnotationConfigApplicationContext(ProjectConfig.class);

        // Bean Context invocation
        String actualOutput = context.getBean(String.class);

        Assert.assertEquals(expectedOutput, actualOutput);
    }

    @Test
    public void testSpringContext_IntegerBean_IsTen() {
        Integer expectedOutput = 10;

        // Spring Context Configuration Initialization
        AnnotationConfigApplicationContext context =
                new AnnotationConfigApplicationContext(ProjectConfig.class);

        // Bean Context invocation
        Integer actualOutput = context.getBean(Integer.class);

        Assert.assertEquals(expectedOutput, actualOutput);
    }

}
