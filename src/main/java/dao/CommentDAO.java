package dao;

import bean.Category;
import bean.Comment;
import db.DBContext;
import db.JDBIConnector;
import org.jdbi.v3.core.Jdbi;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class CommentDAO {

    public void addComment(Comment comment) {
        Connection conn = DBContext.getConnection();
        String sql = "INSERT INTO comments (username, comment_text, email) VALUES (?, ?, ?)";
        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, comment.getUsername());
            ps.setString(2, comment.getCommentText());
            ps.setString(3, comment.getEmail());
            ps.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }


    public List<Comment> getAllComments() {
        List<Comment> comments = new ArrayList<>();
        Connection conn = DBContext.getConnection();
        String sql = "SELECT * FROM comments";
        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ResultSet resultSet = ps.executeQuery();

            while (resultSet.next()) {
                Comment comment = new Comment();
                comment.setId(resultSet.getInt("id"));
                comment.setUsername(resultSet.getString("username"));
                comment.setCommentText(resultSet.getString("comment_text"));
                comment.setCreatedAt(resultSet.getTimestamp("created_at"));
                comments.add(comment);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return comments;
    }
}
