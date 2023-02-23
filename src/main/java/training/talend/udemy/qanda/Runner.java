package training.talend.udemy.qanda;

import training.talend.udemy.qanda.courses.GetCourses;

import java.io.IOException;
import java.net.URISyntaxException;

public class Runner {

    public static void main(String[] args) throws IOException, URISyntaxException, InterruptedException {
        String mode = parse(args);
        if (null == mode) {
            System.exit(1);
        } else if (mode.equals("courses")) {
            System.out.println("Will get courses.csv");
            GetCourses gc = new GetCourses(args);
            gc.run();
        } else if (mode.equals("qa")) {
            System.out.println("Will get Q&A for the specified course");
            GetQuestionsAndAnswers gqa = new GetQuestionsAndAnswers(args);
            gqa.run();
        }
    }

    private static String parse(String[] args) {
        if (args.length == 2) {
            return "courses";
        } else if (args.length == 3) {
            return "qa";
        } else {
            System.err.println("Found more or less parameters than expected");
            System.err.println("Please provide like this to get a courses.csv:");
            System.err.println("java -jar QA.jar path=/home/user/folder/ token=your_api_token");
            System.err.println("Please provide this way to get Q&A for a course:");
            System.err.println("java -jar QA.jar path=/home/user/folder/ token=your_api_token course=your_course_id");
            System.err.println("Note: use double quotes around a path that includes spaces");

            return null;
        }
    }
}
