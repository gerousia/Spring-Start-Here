package gerousia;

import gerousia.config.ProjectConfig;
import gerousia.model.Comment;
import gerousia.proxies.CommentNotificationProxy;
import gerousia.proxies.EmailCommentNotificationProxy;
import gerousia.repository.CommentRepository;
import gerousia.repository.DBCommentRepository;
import gerousia.services.CommentService;
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

    /*
    @Test
    public void springContext_Beans_Test() {

        // Given
        ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outContent));

        AnnotationConfigApplicationContext context =
                new AnnotationConfigApplicationContext(ProjectConfig.class);

        // When
        CommentRepository dBCommentRepository =
                new DBCommentRepository();

        context.registerBean(
                "commentRepository",
                CommentRepository.class,
                (() -> dBCommentRepository));

        CommentNotificationProxy emailCommentNotificationProxy =
                new EmailCommentNotificationProxy();

        context.registerBean(
                "commentNotificationProxy",
                CommentNotificationProxy.class,
                (() -> emailCommentNotificationProxy));

        context.registerBean(
                "commentService",
                CommentService.class
        );

        CommentService commentService = context.getBean(CommentService.class);
        commentService.publishComment(createTestComment());

        // Then
        String expectedCommentServiceOutput = String.join( "\n",
                "Storing: " + "Demo comment",
                "Sending notification for comment: " + "Demo comment",
                "");
        String actualCommentServiceOutput = outContent.toString();

        Assert.assertEquals(expectedCommentServiceOutput, actualCommentServiceOutput);
    }
   s */

    @Test
    public void springContext_dependencyInjection_autowiredAnnotation_test() {

        // Given
        ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outContent));

        AnnotationConfigApplicationContext context =
                new AnnotationConfigApplicationContext(ProjectConfig.class);

        // When
        CommentService commentService = context.getBean(CommentService.class);
        commentService.publishComment(createTestComment());

        // Then
        String expectedCommentServiceOutput = String.join( "\n",
                "Storing: " + "Demo comment",
                "Sending notification for comment: " + "Demo comment",
                "");
        String actualCommentServiceOutput = outContent.toString();

        Assert.assertEquals(expectedCommentServiceOutput, actualCommentServiceOutput);

    }

    private Comment createTestComment() {
        Comment comment = new Comment();
        comment.setAuthor("Author");
        comment.setText("Demo comment");
        return comment;
    }
}
