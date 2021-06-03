package students.training.program;

import java.util.*;

public class Student {

    private final String studentName;
    private final String curriculum;
    private final String courseStartDate;
    private final List<HashMap <String, Integer>> courseList;

    //TODO: implement list of maps as a param


    public Student(String studentName, String curriculum, String courseStartDate, List<HashMap<String,Integer>> courseList){

        this.studentName = studentName;
        this.curriculum = curriculum;
        this.courseStartDate = courseStartDate;
        //TODO: here ->
        this.courseList = courseList;
    }
    public String getCourseStartDate() {
        return courseStartDate;
    }

    @Override
    public String toString(){
        String concatination = "";

        for (HashMap hmap:courseList) {

            Set set = hmap.entrySet();
            Iterator iterator = set.iterator();
            while (iterator.hasNext()) {
                Map.Entry mentry = (Map.Entry) iterator.next();

                concatination = concatination + "\n" + mentry.toString().replace('=', ' ');
            }
        }
        return "Student: " + studentName + "\nCurriculum: " + curriculum +
                "\nStart Date: " + courseStartDate + "\nCourse: "
                + concatination;
    }
}
