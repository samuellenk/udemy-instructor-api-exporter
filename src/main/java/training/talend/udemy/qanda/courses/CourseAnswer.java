package training.talend.udemy.qanda.courses;

import java.util.List;

public class CourseAnswer {

    private int count;
    private String next;
    private String previous;
    private List<Course> results;

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public String getNext() {
        return next;
    }

    public void setNext(String next) {
        this.next = next;
    }

    public String getPrevious() {
        return previous;
    }

    public void setPrevious(String previous) {
        this.previous = previous;
    }

    public List<Course> getResults() {
        return results;
    }

    public void setResults(List<Course> results) {
        this.results = results;
    }
}
