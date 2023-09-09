package gerousia.repository;

import gerousia.model.Comment;

public interface CommentRepository {
    void storeComment(Comment comment);
}
