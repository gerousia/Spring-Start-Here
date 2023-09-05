package gerousia;

import gerousia.proxies.EmailCommentNotificationProxy;
import gerousia.repository.DBCommentRepository;
import gerousia.services.CommentService;
import gerousia.model.Comment;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.PrintStream;

/**
 * Unit test for simple App.
 */
public class MainTest {

    @Test
    public void projectStructure_structuralPattern_Test() {

        // Given
        ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outContent));

        DBCommentRepository commentRepository =
                new DBCommentRepository();
        EmailCommentNotificationProxy commentNotificationProxy =
                new EmailCommentNotificationProxy();

        CommentService commentService =
                new CommentService(
                        commentRepository,
                        commentNotificationProxy);

        // When
        String commentAuthor = "Author";
        String commentText = "Demo comment";

        Comment comment = new Comment();
        comment.setAuthor(commentAuthor);
        comment.setText(commentText);

        commentService.publishComment(comment);

        String expectedCommentServiceOutput = String.join( "\n",
                "Storing: " + commentText,
                "Sending notification for comment: " + commentText,
                "");
        String actualCommentServiceOutput = outContent.toString();

        // Then
        Assert.assertEquals(expectedCommentServiceOutput, actualCommentServiceOutput);
    }

}
