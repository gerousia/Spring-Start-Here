package gerousia;

import gerousia.config.ProjectConfig;
import gerousia.model.Comment;
import gerousia.proxies.CommentNotificationProxy;
import gerousia.proxies.EmailCommentNotificationProxy;
import gerousia.repository.CommentRepository;
import gerousia.repository.DBCommentRepository;
import gerousia.services.CommentService;
import gerousia.services.UserService;
import org.junit.Assert;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

/**
 * Unit test for simple App.
 */
public class MainTest {

    @Test
    public void springContext_prototype_NotSameInstance_test() {

        // Given
        AnnotationConfigApplicationContext context =
                new AnnotationConfigApplicationContext(ProjectConfig.class);

        // When
        CommentService commentService1 =
                context.getBean("commentService", CommentService.class);
        CommentService commentService2 =
                context.getBean("commentService", CommentService.class);

        boolean isNotCommentRepositoryFromServicesSameInstance =
               commentService1 != commentService2;

        // Then
        Assert.assertTrue(isNotCommentRepositoryFromServicesSameInstance);
    }
}
