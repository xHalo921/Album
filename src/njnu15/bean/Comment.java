package njnu15.bean;

public class Comment {
    //CommentId(int)  PhotoId(int)        User(String)    Comment(String)
    private int CommentId;
    private int PhotoId;
    private String User;
    private String Comments;

    public int getCommentId() {
        return CommentId;
    }

    public void setCommentId(int commentId) {
        CommentId = commentId;
    }

    public int getPhotoId() {
        return PhotoId;
    }

    public void setPhotoId(int photoId) {
        PhotoId = photoId;
    }

    public String getUser() {
        return User;
    }

    public void setUser(String user) {
        User = user;
    }

    public String getComments() {
        return Comments;
    }

    public void setComments(String comments) {
        Comments = comments;
    }
}
