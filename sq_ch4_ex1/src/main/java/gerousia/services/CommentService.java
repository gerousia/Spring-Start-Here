package gerousia.services;

import gerousia.model.Comment;
import gerousia.proxies.CommentNotificationProxy;
import gerousia.repository.CommentRepository;

public class CommentService {
    private CommentRepository commentRepository;
    private CommentNotificationProxy commentNotificationProxy;

    public CommentService(
            CommentRepository repository,
            CommentNotificationProxy notification) {
        this.commentRepository = repository;
        this.commentNotificationProxy = notification;

    }
    public void publishComment(Comment comment) {
        commentRepository.storeComment(comment);
        commentNotificationProxy.sendComment(comment);
    }
}
