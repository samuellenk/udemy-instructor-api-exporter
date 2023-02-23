package training.talend.udemy.qanda;

import com.google.gson.Gson;
import training.talend.udemy.qanda.courses.Course;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URLEncoder;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.nio.charset.Charset;
import java.util.List;

public class GetQuestionsAndAnswers {

    private static final String ROOT_ENDPOINT = "https://www.udemy.com/instructor-api/v1";
    private String token;
    private String courseId;
    private String path;
    private String course_endpoint;

    private StringBuilder sb = new StringBuilder();

    private FileWriter wr;

    public GetQuestionsAndAnswers(String[] args) {
        for (int i = 0; i < args.length; i++) {
            if (args[i].startsWith("path=")) {
                this.path = args[i].substring(args[i].indexOf("=") + 1);
            } else if (args[i].startsWith("token=")) {
                this.token = args[i].substring(args[i].indexOf("=") + 1);
            } else if (args[i].startsWith("course=")) {
                this.courseId = args[i].substring(args[i].indexOf("=") + 1);
            }
        }
    }

    public void run() throws IOException, InterruptedException, URISyntaxException {
        course_endpoint  = ROOT_ENDPOINT + "/courses/" + courseId + "/questions/" + "?fields[question]=@all&fields[answer]=@all&fields[user]=@all";

        String extension = ".csv";

        File f = new File(path + "Q&A_" + courseId + extension);
        f.getParentFile().mkdirs();
        wr = new FileWriter(f);


        sb.append("\"course_id\";\"");
        sb.append("course_title\";\"");
        sb.append("course_url\";\"");
        sb.append("user_id\";\"");
        sb.append("user_title\";\"");
        sb.append("user_name\";\"");
        sb.append("user_locale\";\"");
        sb.append("_class\";\"");
        sb.append("id\";\"");
        sb.append("created\";\"");
        sb.append("title\";\"");
        sb.append("body\";\"");
        sb.append("num_replies\";\"");
        sb.append("num_follows\";\"");
        sb.append("num_reply_upvotes\";\"");
        sb.append("modified\";\"");
        sb.append("last_activity\";\"");
        sb.append("is_read\";\"");
        sb.append("is_featured\";\"");
        sb.append("is_instructor\";\"");
        sb.append("is_top_answer\";\"");
        sb.append("is_upvoted\";\"");
        sb.append("num_upvotes\";\"");
        sb.append("related_lecture_id\";\"");
        sb.append("related_lecture_title\";\"");
        sb.append("related_lecture_url\"");

        sb.append(System.getProperty("line.separator"));
        wr.write(sb.toString());
        sb.setLength(0);

        getNextPage();

        wr.close();

        System.out.println("File ready: '" + f.getAbsolutePath() + "'");

    }

    private void getNextPage() throws URISyntaxException, IOException, InterruptedException {

        HttpRequest getRequest = HttpRequest.newBuilder()
                .uri(new URI(course_endpoint))
                .header("Authorization", "bearer " + token)
                .GET()
                .build();
        HttpClient httpClient = HttpClient.newHttpClient();

        HttpResponse<String> getResponse = httpClient.send(getRequest, HttpResponse.BodyHandlers.ofString());
        int code = getResponse.statusCode();
        if (code != 200) {
            System.err.println("status code from server: " + code);
            System.exit(code);
        }

        Gson gson = new Gson();
        QuestionAnswer answer = gson.fromJson(getResponse.body(), QuestionAnswer.class);

        extractData(answer);

        course_endpoint = answer.getNext();
        while (null != course_endpoint) {
            getNextPage();
        }
    }

    private void extractData(QuestionAnswer answer) throws IOException {
        // extract data from response

        Question[] questions = answer.getResults();

        for (Question q : questions) {
            Course c = q.getCourse();
            sb.append("\"" + c.getId() + "\";\"");
            sb.append(c.getTitle() + "\";\"");
            sb.append(c.getUrl() + "\";\"");

            User u = q.getUser();
            sb.append(u.getId() + "\";\"");
            sb.append(u.getTitle() + "\";\"");
            sb.append(u.getName() + "\";\"");
            sb.append(u.getLocale() + "\";\"");

            sb.append(q.get_class() + "\";\"");
            sb.append(q.getId() + "\";\"");
            sb.append(q.getCreated() + "\";\"");
            sb.append(q.getTitle() + "\";\"");
            sb.append(q.getBody().replaceAll("\"", "") + "\";\"");
            sb.append(q.getNum_replies() + "\";\"");
            sb.append(q.getNum_follows() + "\";\"");
            sb.append(q.getNum_reply_upvotes() + "\";\"");
            sb.append(q.getModified() + "\";\"");
            sb.append(q.getLast_activity() + "\";\"");
            sb.append(q.isIs_read() + "\";\"");
            sb.append(q.isIs_featured() + "\";\"");
            sb.append(q.isIs_instructor() + "\";\"");
            sb.append("\";\"");
            sb.append("\";\"");
            sb.append(q.getNum_upvotes() + "\";\"");
            sb.append(q.getRelated_lecture_id() + "\";\"");
            sb.append(q.getRelated_lecture_title() + "\";\"");
            sb.append(q.getRelated_lecture_url() + "\"");

            sb.append(System.getProperty("line.separator"));
            wr.write(sb.toString());
            sb.setLength(0);

            List<Replies> replies = q.getReplies();
            for (Replies r : replies) {
                sb.append("\"" + c.getId() + "\";\"");
                sb.append(c.getTitle() + "\";\"");
                sb.append(c.getUrl() + "\";\"");

                User u2 = r.getUser();
                sb.append(u2.getId() + "\";\"");
                sb.append(u2.getTitle() + "\";\"");
                sb.append(u2.getName() + "\";\"");
                sb.append(u2.getLocale() + "\";\"");

                sb.append(r.get_class() + "\";\"");
                sb.append(r.getId() + "\";\"");
                sb.append(r.getCreated() + "\";\"");
                sb.append("\";\"");
                sb.append(r.getBody() + "\";\"");
                sb.append("\";\"");
                sb.append("\";\"");
                sb.append("\";\"");
                sb.append("\";\"");
                sb.append(q.getLast_activity() + "\";\"");
                sb.append("\";\"");
                sb.append("\";\"");
                sb.append("\";\"");
                sb.append(r.isIs_top_answer() + "\";\"");
                sb.append(r.getIs_upvoted() + "\";\"");
                sb.append(r.getNum_upvotes() + "\";\"");
                sb.append("\";\"");
                sb.append("\";\"");
                sb.append("\"");

                sb.append(System.getProperty("line.separator"));
                wr.write(sb.toString());
                sb.setLength(0);
            }
        }
    }
}