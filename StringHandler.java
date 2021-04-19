public class StringHandler {


    public int[] stringToIntArray(String[] array) {

        int[] int_array = new int[array.length];

        for(int i = 0; i < array.length; i++){

            int_array[i] = stringHandler(array[i]);
        }
        return int_array;
    }


    public int stringHandler(String str) {
        String[] values = str.split("-");
        String s = "";

        for(int i=0; i<values.length ;++i) {
            s = s + values[i];
        }
        return Integer.parseInt(s);
    }

    public String dateFormat(int number){

        String s = Integer.toString(number);

        String str1 = s.substring(0, 4) + "-";
        String str2 = s.substring(4,6) + "-";
        String str3 = s.substring(6);
        
        s = str1 + str2 + str3;
        return s;
    }
}
