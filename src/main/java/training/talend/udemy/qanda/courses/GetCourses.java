package training.talend.udemy.qanda.courses;

import com.google.gson.Gson;
import training.talend.udemy.qanda.User;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.nio.charset.Charset;
import java.util.List;

public class GetCourses {

    private final String ROOT_ENDPOINT = "https://www.udemy.com/instructor-api/v1";
    private String token;
    private String path;
    private StringBuilder sb = new StringBuilder();

    public GetCourses(String[] args) {
        for (int i = 0; i < args.length; i++) {
            if (args[i].startsWith("path=")) {
                this.path = args[i].substring(args[i].indexOf("=") + 1);
            } else if (args[i].startsWith("token=")) {
                this.token = args[i].substring(args[i].indexOf("=") + 1);
            }
        }
    }

    public void run() throws IOException, InterruptedException, URISyntaxException {

        String nameAndExtension = "courses.csv";
        File f = new File(path + nameAndExtension);
        f.getParentFile().mkdirs();
        FileWriter wr = new FileWriter(f, Charset.forName("UTF8"), false);

        String course_endpoint = ROOT_ENDPOINT + "/taught-courses/courses/";
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
        CourseAnswer answer = gson.fromJson(getResponse.body(), CourseAnswer.class);
        List<Course> courses = answer.getResults();

        sb.append("course_id;course_title;course_url;is_paid;instructor_id;instructor_title;instructor_name;instructor_locale");
        sb.append(System.getProperty("line.separator"));
        wr.write(sb.toString());
        sb.setLength(0);

        for (Course c : courses) {
            sb.append(c.getId() + ";");
            sb.append(c.getTitle() + ";");
            sb.append(c.getUrl() + ";");
            sb.append(c.isIs_paid() + ";");
            sb.append(c.getPublished_title());
            List<User> instructors = c.getVisible_instructors();
            for (User i : instructors) {
                sb.append(i.getId() + ";");
                sb.append(i.getTitle() + ";");
                sb.append(i.getName() + ";");
                sb.append(i.getLocale());

                sb.append(System.getProperty("line.separator"));
                wr.write(sb.toString());
                sb.setLength(0);
            }
        }
        wr.write(sb.toString());

        wr.close();

        System.out.println("File ready: '" + f.getAbsolutePath() + "'");

    }
}
