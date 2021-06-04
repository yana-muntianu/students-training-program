package students.training.program;

import java.text.ParseException;
import java.time.LocalDateTime;
import java.util.*;

public class Calculator {

    private int workingHours = 0;
    private int trainingHours = 0;
    public String courseCompleteMessage;

    public void countWorkingHoursSinceStartDate(Student student, String date) throws ParseException {
        /*/
           Count how many days passed from the startDate and exclude weekends
        */
        DateConvertor dateConvertor = new DateConvertor();

        Calendar startDate = Calendar.getInstance();
        Calendar endDate = Calendar.getInstance();
        startDate.setTime(dateConvertor.convertStringToDateFormat(student.getCourseStartDate()));
        endDate.setTime(dateConvertor.convertStringToDateFormat(date));

        int numberOfDays = 0;

        while (startDate.before(endDate)) {
            if ((Calendar.SATURDAY != startDate.get(Calendar.DAY_OF_WEEK))
                    && (Calendar.SUNDAY != startDate.get(Calendar.DAY_OF_WEEK))) {
                numberOfDays++;
            }
            startDate.add(Calendar.DATE, 1);
        }
            /*/
                Count how much time is it in current day. Then count how much working hours passed since 10AM and display
                full days from the startDate and whole hours / whole working hours
             */
        int hours = LocalDateTime.now().getHour();

        if(hours<10){
            workingHours = (numberOfDays - 1) * 8;

        }else if(10<=hours && hours <= 18){
            workingHours = ((numberOfDays - 1) * 8) + (hours - 10);

        }else{
            workingHours = numberOfDays * 8;
        }

    }

    public void countFullNumberOfTrainingHours(Student student){

        Integer[] courseHours = null;

        for (HashMap<String, Integer> course: student.getCourseList()) {
            courseHours = course.values().toArray(new Integer[0]);
        }
        for (int i = 0; i< Objects.requireNonNull(courseHours).length; i++){
            trainingHours = trainingHours +courseHours[i];
        }
    }

    public void countTimeDifferenceWorkingAndCourseHours(){
        int hoursDifference = workingHours - trainingHours;

        if((hoursDifference)>=0) {
            int days = hoursDifference / 8;
            int hours = hoursDifference % 8;

            if(days == 0) {
                courseCompleteMessage = "Training completed. " + hours + " hours have passed since the end.";
            }else if(hours == 0){
                courseCompleteMessage = "Training completed. " + days + " d have passed since the end.";
            }else{
                courseCompleteMessage = "Training completed. " + days + " d " + hours + " hours have passed since the end.";
            }
        }else if ((hoursDifference)<0) {
            int days = Math.abs(hoursDifference) / 8;
            int hours = Math.abs(hoursDifference) % 8;

            if(days == 0) {
                courseCompleteMessage = "Training is not finished. " + hours + " hours are left until the end.";
            }else if(hours == 0){
                courseCompleteMessage = "Training is not finished. " + days + " d are left until the end.";
            }else{
                courseCompleteMessage = "Training is not finished. " + days + " d " + hours + " hours are left until the end.";
            }
        }
    }

}
