import java.io.IOException;
import java.util.*;

public class CountingSort {

    CountingSort(String filename, String field) {
        try{
            FiletoArray fta = new FiletoArray(filename, field);
            double array[] = fta.getField();
            countingSort(array);
            /*
            double [] array1=new double[array.length]; 
            for(int i=0; i<array.length; i++){
                double value= array[i];
                array1[i]=value;
            }*/
            for(double i: array){
                System.out.println(i);
            }

           /* SortDate order = new SortDate(array,fta.getMap());

            LinkedHashMap<String,Double> orderedMap = order.classifyDateAndField();


            for(Map.Entry<String,Double> entry : orderedMap.entrySet()) {
                System.out.println("Key: "+ entry.getKey() + " Value: "+ entry.getValue());
            }
           */   
        }catch(IOException e){
            e.printStackTrace();
        }

    }


    public static void countingSort(double[] array){
        
        //returns the nearest integer and put it into a new array
        int [] arr=new int[array.length]; 
        for(int i=0; i<array.length; i++){
            int value= (int)Math.round (array[i]);
            arr[i]=value;
        }
        

        //find the maximum value on the given array
        int max=arr[0];
        for(int i=1; i<arr.length; i++){
            if(max<arr[i]){
                max=arr[i];
            }
        }

        //create an empty index array of max+1 size
        int[] index_array= new int[max+1];
        for(int i=0; i<max; i++){
            index_array[i]=0;
        }

        //fill index array with the number of occurrences
        for(int i=0; i<arr.length; i++){
            int current = arr[i];;
            if (current == arr[i])
            {
                index_array[arr[i]]++;
            }
        }

        //sum up the index array values with previous values
        for (int i = 1; i <= max; i++) {
            index_array[i]= index_array[i]+index_array[i-1];
          }

        //create output array to store sorted values 
        int[] output_array = new int[arr.length];
        
        //map the value of the given array with index array and put the value in the output array
        for (int i = arr.length - 1; i >= 0; i--) {
            output_array[index_array[arr[i]] - 1] = arr[i];
            index_array[arr[i]]--; //decrement index array value
        }
        for (int i = 0; i <arr.length; ++i){
            arr[i] = output_array[i];
        }
            
}

    public static void main(String[] args) {
        CountingSort a = new CountingSort("agn.us.txt", "Open");
    }

 


}

