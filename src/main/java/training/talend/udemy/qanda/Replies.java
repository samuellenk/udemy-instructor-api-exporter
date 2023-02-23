package training.talend.udemy.qanda;

import java.util.List;

public class Replies {

    private String _class;
    private String id;
    private String  created;
    private String last_activity;
    private User user;
    private boolean is_top_answer;
    private String body;
    private String is_upvoted;
    private int num_upvotes;

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

    public String getLast_activity() {
        return last_activity;
    }

    public void setLast_activity(String last_activity) {
        this.last_activity = last_activity;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public boolean isIs_top_answer() {
        return is_top_answer;
    }

    public void setIs_top_answer(boolean is_top_answer) {
        this.is_top_answer = is_top_answer;
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }

    public String getIs_upvoted() {
        return is_upvoted;
    }

    public void setIs_upvoted(String is_upvoted) {
        this.is_upvoted = is_upvoted;
    }

    public int getNum_upvotes() {
        return num_upvotes;
    }

    public void setNum_upvotes(int num_upvotes) {
        this.num_upvotes = num_upvotes;
    }
}
