package training.talend.udemy.qanda.courses;

import training.talend.udemy.qanda.User;

import java.util.List;

public class Course {

    private String _class;
    private String id;
    private String title;
    private String url;
    private boolean is_paid;
    private String published_title;
    private List<User> visible_instructors;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
         this.title = title;
    }
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

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public boolean isIs_paid() {
        return is_paid;
    }

    public void setIs_paid(boolean is_paid) {
        this.is_paid = is_paid;
    }

    public String getPublished_title() {
        return published_title;
    }

    public void setPublished_title(String published_title) {
        this.published_title = published_title;
    }

    public List<User> getVisible_instructors() {
        return visible_instructors;
    }

    public void setVisible_instructors(List<User> visible_instructors) {
        this.visible_instructors = visible_instructors;
    }

}