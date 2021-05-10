import java.util.Date;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.text.ParseException;
import java.text.SimpleDateFormat;


public class StringHandler {

    private SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");

    
    public long[] stringToIntArray(String[] array) {

        long[] int_array = new long[array.length];

        for(int i = 0; i < array.length; i++){

            int_array[i] = stringToUnixTime(array[i]);
        }
        return int_array;
    }


    public long stringToUnixTime(String str) {
        
        try{
            Date date = formatter.parse(str);
            return date.getTime();
        }
        catch(ParseException e){
            return -1;
        }
    }

    public String dateFormat(long number){
        return formatter.format(number);
    }

    private boolean checkDateFormat(String input){
        Pattern pattern = Pattern.compile("^(19|20)\\d\\d[- /.](0[1-9]|1[012])[- /.](0[1-9]|[12][0-9]|3[01])$");
        Matcher matcher = pattern.matcher(input);
        
        return matcher.matches();
    }


    public String getDate(){
        String stringInput;
        Scanner input = new Scanner(System.in);
        while(true){
            System.out.println("Enter a date (yyyy-mm-dd): ");
            System.out.print("> ");
            stringInput = input.nextLine(); 

            if(checkDateFormat(stringInput))
                break;
            else{
                System.out.print("\033[H\033[2J");  
                System.out.flush();
                System.out.println("Please enter a valid date (yyyy-mm-dd)");
            }
        }
        return stringInput;
    }

}
