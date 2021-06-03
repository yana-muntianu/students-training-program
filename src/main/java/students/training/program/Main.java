package students.training.program;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Main {

    public static Student createNewStudent(){

        String studentName = "Jack Been";
        String curriculum = "Java SE";
        String courseStartDate = "1 May 2021 - Thursday";

        HashMap<String, Integer> course = new HashMap<>();
        List<HashMap<String, Integer>> listOfCourses = new ArrayList<>();

        course.put("Java", 18);
        course.put("OOP", 16);
        course.put("Testing", 10);

        listOfCourses.add(course);

        return new Student(studentName,curriculum,courseStartDate,listOfCourses);
    }

    public static void main (String[] args) throws ParseException {

        Calculator calculator = new Calculator();
        Student student = createNewStudent();
        calculator.countTimeSinceStartDate(student);

    }


}
