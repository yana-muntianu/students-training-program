package students.training.program;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Random;

public class Main {

    public static void main (String[] args) throws Exception {

        Student student1 = new Student("Ivanov Ivan", "Java SE", Constants.COURSE_START_DATE,
                generateCourseList());
        Student student2 = new Student("Sidorov Ivan", "AQE", Constants.COURSE_START_DATE,
                generateCourseList());
        ReportGenerator reportGenerator = new ReportGenerator();

        reportGenerator.generateStudentReport(student1, 0);
        reportGenerator.generateStudentReport(student1, 1);

        reportGenerator.generateStudentReport(student2);
        reportGenerator.generateStudentReport(student2, 1);
    }

    public static List<HashMap<String, Integer>> generateCourseList(){

        HashMap<String, Integer> course = new HashMap<>();
        List<HashMap<String, Integer>> listOfCourses = new ArrayList<>();
        Random rand = new Random();

        int upperbound = 20;

        course.put("Test design", rand.nextInt(upperbound));
        course.put("Page Object", rand.nextInt(upperbound));
        course.put("Selenium", rand.nextInt(upperbound));
        listOfCourses.add(course);

        return listOfCourses;
    }


}
