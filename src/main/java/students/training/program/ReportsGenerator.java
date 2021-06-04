package students.training.program;

import java.text.ParseException;

public class ReportsGenerator {

    public void generateStudentShortReport(Student student, String endDate ) throws ParseException {

        Calculator calculator = new Calculator();

        calculator.countWorkingHoursSinceStartDate(student, endDate);
        calculator.countFullNumberOfTrainingHours(student);
        calculator.countTimeDifferenceWorkingAndCourseHours();

        String shortReport = student.getStudentName() + " (" + student.getCurriculum() +
                ") - " + calculator.courseCompleteMessage;

        System.out.println(shortReport);

    }

    public void generateStudentFullReport(Student student, String endDate ) throws ParseException{

        Calculator calculator = new Calculator();

        calculator.countWorkingHoursSinceStartDate(student, endDate);
        calculator.countFullNumberOfTrainingHours(student);
        calculator.countTimeDifferenceWorkingAndCourseHours();

        String fullReport = "Student: " + student.getStudentName() + "\n" + "Working Hours: from 10 to 18\n" +
                "Programs: " + student.returnListOfCourses() + "\nStart Date: " + student.getCourseStartDate() +
                "\nEnd Date: " + endDate + "\n"+ calculator.courseCompleteMessage;

        System.out.println(fullReport);
    }

}
