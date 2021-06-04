package students.training.program;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DateConvertor {

    public Date convertStringToDateFormat(String date) throws ParseException {

        String[] splittedString = date.split(" ");
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
}
