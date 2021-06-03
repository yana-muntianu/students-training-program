package students.training.program;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.util.Calendar;
import java.util.Date;

public class Calculator {

    public Date convertStringToDateFormat(Student student) throws ParseException {

        String[] splittedString = student.getCourseStartDate().split(" ");
        String monthAsNumber = " ";

        String monthAsString = splittedString[1];
        switch (monthAsString){
            case "January": monthAsNumber = "01";
                break;
            case "February": monthAsNumber = "02";
                break;
            case "March": monthAsNumber = "03";
                break;
            case "April": monthAsNumber = "04";
                break;
            case "May": monthAsNumber = "05";
                break;
            case "June": monthAsNumber = "06";
                break;
            case "July": monthAsNumber = "07";
                break;
            case "August": monthAsNumber = "08";
                break;
            case "September": monthAsNumber = "09";
                break;
            case "October": monthAsNumber = "10";
                break;
            case "November": monthAsNumber = "11";
                break;
            case "December": monthAsNumber = "12";
                break;
            default:
        }
        String dateString = splittedString[0] + "-" + monthAsNumber + "-" + splittedString[2];

        SimpleDateFormat format = new SimpleDateFormat();
        format.applyPattern("dd-MM-yyyy");

        return format.parse(dateString);
    }

    public String countTimeSinceStartDate(Student student) throws ParseException {

        /*/
           Count how many days passed from the startDate and exclude weekends
        */
        Calendar startDate = Calendar.getInstance();
        Calendar currentDate = Calendar.getInstance();
        startDate.setTime(convertStringToDateFormat(student));

        int numberOfDays = 0;
        if (startDate.after(currentDate)) {
            System.out.println("Error: Incorrect Start Date");
        } else {
            while (startDate.before(currentDate)) {
                if ((Calendar.SATURDAY != startDate.get(Calendar.DAY_OF_WEEK))
                        && (Calendar.SUNDAY != startDate.get(Calendar.DAY_OF_WEEK))) {
                    numberOfDays++;
                }
                startDate.add(Calendar.DATE, 1);
            }
            /*/
                Count how much time is it in current day. Then count how much working hours passed since 10AM and display
                full days from the startDate and whole hours
             */
            int hours = LocalDateTime.now().getHour();
            if(hours<=10){
                numberOfDays = numberOfDays - 1;
                System.out.println(numberOfDays + " full working days");
            }else if(10<hours && hours <= 18){
                    System.out.println(numberOfDays + " full working days and " + (hours - 10) + " hours");
            }else{
                System.out.println(numberOfDays + " full working days");
            }

        }
        return "";
    }

}
