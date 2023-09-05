package gerousia.proxies;

import gerousia.model.Comment;

public interface CommentNotificationProxy {
    void sendComment(Comment comment);
}
