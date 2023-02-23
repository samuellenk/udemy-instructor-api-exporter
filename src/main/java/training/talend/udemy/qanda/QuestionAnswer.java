package training.talend.udemy.qanda;

import training.talend.udemy.qanda.courses.Course;

import java.util.List;

public class QuestionAnswer {

    private int count;
    private String next;
    private String previous;
    private Question[] results;

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

    public Question[] getResults() {
        return results;
    }

    public void setResults(Question[] results) {
        this.results = results;
    }
}
