package gerousia.services;

import gerousia.model.Comment;
import gerousia.proxies.CommentNotificationProxy;
import gerousia.repository.CommentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

@Service
@Lazy
public class CommentService {
    @Autowired
    private CommentRepository commentRepository;
    @Autowired
    @Qualifier("PUSH")
    private CommentNotificationProxy commentNotificationProxy;

    public void publishComment(Comment comment) {
        commentRepository.storeComment(comment);
        commentNotificationProxy.sendComment(comment);
    }

    public CommentRepository getCommentRepository() {
        return commentRepository;
    }
}
