package students.training.program;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Main {

    public static void main (String[] args) throws ParseException {

        String endDate = "1 May 2021 - Thursday";
        Student student1 = createFirstStudent();
        Student student2 = createSecondStudent();
        ReportsGenerator reportsGenerator = new ReportsGenerator();

        reportsGenerator.generateStudentShortReport(student1, endDate);
        reportsGenerator.generateStudentFullReport(student1, endDate);

        reportsGenerator.generateStudentShortReport(student2, endDate);
        reportsGenerator.generateStudentFullReport(student2, endDate);
    }

    public static Student createFirstStudent(){

        String studentName = "Ivanov Ivan";
        String curriculum = "Java SE";
        String courseStartDate = "1 June 2021 - Tuesday";

        HashMap<String, Integer> course = new HashMap<>();
        List<HashMap<String, Integer>> listOfCourses = new ArrayList<>();

        course.put("Java", 16);
        course.put("JDBC", 24);
        course.put("Spring", 16);

        listOfCourses.add(course);

        return new Student(studentName,curriculum,courseStartDate,listOfCourses);
    }

    public static Student createSecondStudent(){

        String studentName = "Sidorov Ivan";
        String curriculum = "AQE";
        String courseStartDate = "1 June 2021 - Tuesday";

        HashMap<String, Integer> course = new HashMap<>();
        List<HashMap<String, Integer>> listOfCourses = new ArrayList<>();

        course.put("Test design", 10);
        course.put("Page Object", 16);
        course.put("Selenium", 16);

        listOfCourses.add(course);

        return new Student(studentName,curriculum,courseStartDate,listOfCourses);
    }

}
