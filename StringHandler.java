import java.util.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;


public class StringHandler {

    SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
    public long[] stringToIntArray(String[] array) {

        long[] int_array = new long[array.length];

        for(int i = 0; i < array.length; i++){

            int_array[i] = stringHandler(array[i]);
        }
        return int_array;
    }


    public long stringHandler(String str) {
        
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
}
