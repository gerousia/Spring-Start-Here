package gerousia.repository;

import gerousia.model.Comment;

import java.util.ArrayList;
import java.util.List;

public class DBCommentRepository implements CommentRepository {
    private final List<Comment> commentList;

    public DBCommentRepository() {
        this.commentList = new ArrayList<>();
    }

    @Override
    public void storeComment(Comment comment) {
        System.out.println("Storing: " + comment.getText());
    }
}
