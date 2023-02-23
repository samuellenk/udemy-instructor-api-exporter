package training.talend.udemy.qanda;

import training.talend.udemy.qanda.courses.Course;

import java.util.List;

public class Question {

    private String _class;
    private String id;
    private String created;
    private String title;
    private String body;
    private int num_replies;
    private int num_follows;
    private int num_reply_upvotes;
    private String modified;
    private String last_activity;
    private boolean is_read;
    private boolean is_featured;
    private Course course;
    private boolean is_instructor;
    private int num_upvotes;
    private List<Replies> replies;
    private User user;
    private String related_lecture_id;
    private String related_lecture_title;
    private String related_lecture_url;

    public String get_class() {
        return _class;
    }

    public void set_class(String _class) {
        this._class = _class;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getCreated() {
        return created;
    }

    public void setCreated(String created) {
        this.created = created;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }

    public int getNum_replies() {
        return num_replies;
    }

    public void setNum_replies(int num_replies) {
        this.num_replies = num_replies;
    }

    public int getNum_follows() {
        return num_follows;
    }

    public void setNum_follows(int num_follows) {
        this.num_follows = num_follows;
    }

    public int getNum_reply_upvotes() {
        return num_reply_upvotes;
    }

    public void setNum_reply_upvotes(int num_reply_upvotes) {
        this.num_reply_upvotes = num_reply_upvotes;
    }

    public String getModified() {
        return modified;
    }

    public void setModified(String modified) {
        this.modified = modified;
    }

    public String getLast_activity() {
        return last_activity;
    }

    public void setLast_activity(String last_activity) {
        this.last_activity = last_activity;
    }

    public boolean isIs_read() {
        return is_read;
    }

    public void setIs_read(boolean is_read) {
        this.is_read = is_read;
    }

    public boolean isIs_featured() {
        return is_featured;
    }

    public void setIs_featured(boolean is_featured) {
        this.is_featured = is_featured;
    }

    public Course getCourse() {
        return course;
    }

    public void setCourse(Course course) {
        this.course = course;
    }

    public boolean isIs_instructor() {
        return is_instructor;
    }

    public void setIs_instructor(boolean is_instructor) {
        this.is_instructor = is_instructor;
    }

    public int getNum_upvotes() {
        return num_upvotes;
    }

    public void setNum_upvotes(int num_upvotes) {
        this.num_upvotes = num_upvotes;
    }

    public List<Replies> getReplies() {
        return replies;
    }

    public void setReplies(List<Replies> replies) {
        this.replies = replies;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public String getRelated_lecture_id() {
        return related_lecture_id;
    }

    public void setRelated_lecture_id(String related_lecture_id) {
        this.related_lecture_id = related_lecture_id;
    }

    public String getRelated_lecture_title() {
        return related_lecture_title;
    }

    public void setRelated_lecture_title(String related_lecture_title) {
        this.related_lecture_title = related_lecture_title;
    }

    public String getRelated_lecture_url() {
        return related_lecture_url;
    }

    public void setRelated_lecture_url(String related_lecture_url) {
        this.related_lecture_url = related_lecture_url;
    }
}
