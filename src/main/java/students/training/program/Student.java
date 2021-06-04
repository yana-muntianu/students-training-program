package students.training.program;

import java.util.*;

public class Student {

    private final String studentName;
    private final String curriculum;
    private final String courseStartDate;
    private final List<HashMap <String, Integer>> courseList;

    public Student(String studentName, String curriculum, String courseStartDate, List<HashMap<String,Integer>> courseList){

        this.studentName = studentName;
        this.curriculum = curriculum;
        this.courseStartDate = courseStartDate;
        this.courseList = courseList;
    }

    public String getCourseStartDate() {
        return courseStartDate;
    }

    public List<HashMap<String, Integer>> getCourseList() {
        return courseList;
    }

    public String getStudentName() {
        return studentName;
    }

    public String getCurriculum() {
        return curriculum;
    }

    public String returnListOfCourses(){
        StringBuilder concatination = new StringBuilder();

        for (HashMap<String, Integer> course : courseList) {

            Set set = course.entrySet();
            Iterator iterator = set.iterator();
            while (iterator.hasNext()) {
                Map.Entry mentry = (Map.Entry) iterator.next();

                concatination.append("\n").append(mentry.toString().replace('=', '-')).append(" h");
            }
        }
        return concatination.toString();
    }
}
