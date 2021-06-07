package students.training.program;

import java.text.ParseException;


public class ReportGenerator {

    public String generateStudentReport(Student student, Integer reportType) throws Exception {
        String report;

        Calculator calculator = new Calculator();

        calculator.countWorkingHoursSinceStartDate(student, Constants.END_DATE);
        calculator.countFullNumberOfTrainingHours(student);
        calculator.countTimeDifferenceWorkingAndCourseHours();

        if (reportType == 0) {
            report = student.getStudentName() + " (" + student.getCurriculum() +
                    ") - " + calculator.courseCompleteMessage + "\n";
        }else if(reportType == 1){
            report = "Student: " + student.getStudentName() + "\n" + "Working Hours: from 10 to 18\n" +
                    "Programs: " + student.returnListOfCourses() + "\nStart Date: " + student.getCourseStartDate() +
                    "\nEnd Date: " + Constants.END_DATE + "\n"+ calculator.courseCompleteMessage + "\n";
        }else{
            throw new Exception("Unexpected report type");
        }
        return report;
    }

    public String generateStudentReport(Student student) throws Exception {
        generateStudentReport(student, 0);
        return null;
    }

}
