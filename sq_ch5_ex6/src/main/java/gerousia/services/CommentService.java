package gerousia.services;

import gerousia.CommentProcess;
import gerousia.model.Comment;
import gerousia.proxies.CommentNotificationProxy;
import gerousia.repository.CommentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

@Service
public class CommentService {

    @Autowired
    private CommentProcess commentProcess;

    public void sendComment(Comment comment) {
        commentProcess.setComment(comment);
        commentProcess.processComment(comment);
        commentProcess.validateComment(comment);
        Comment updatedComment = commentProcess.getComment();
    }


    /*
    @Autowired
    private ApplicationContext context;

    public void sendComment(Comment comment) {
        CommentProcess commentProcess = context.getBean(CommentProcess.class);

        commentProcess.setComment(comment);
        commentProcess.processComment(comment);
        commentProcess.validateComment(comment);
        Comment updatedComment = commentProcess.getComment();
    }
    */
}
