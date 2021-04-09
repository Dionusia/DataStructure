import java.io.IOException;
import java.util.*;

public class CountingSort {

      private HashMap<Double,Integer> DClose_ICloseMap = new LinkedHashMap<Double,Integer>();

    CountingSort(String filename, String field) {
        try{
            FiletoArray fta = new FiletoArray(filename, field);
            double array[] = fta.getField();
            int[] int_array= new int [array.length];
            
            for(int i=0; i<array.length; i++){
                DClose_ICloseMap.put(array[i],getInt(array[i]));
                int_array[i] = getInt(array[i]);

            }
            countingSort(int_array);
            

            SortDate sortDoubleInt = new SortDate(int_array,DClose_ICloseMap);
            
            LinkedHashMap<Double,Integer> orderedMap = sortDoubleInt.classifyArray(DClose_ICloseMap, int_array);
            
            double[] arr1 = sortDoubleInt.getDoubleArray(orderedMap);

            LinkedHashMap<String,Double> orderedMap1 = sortDoubleInt.classifyDateAndField(fta.getMap(), arr1);

            for(Map.Entry<String,Double> entry : orderedMap1.entrySet()) {
                System.out.println("Key: "+ entry.getKey() + " Value: "+ entry.getValue());
            }
             
        }catch(IOException e){
            e.printStackTrace();
        }

    }


    public  void countingSort(int[] array){
        

        //find the maximum value on the given array
        int max=array[0];
        for(int i=1; i<array.length; i++){
            if(max<array[i]){
                max=array[i];
            }
        }

        //create an empty index array of max+1 size
        int[] index_array= new int[max+1];

        //fill index array with the number of occurrences
        for(int i = 0; i < index_array.length; i++){
            int counter = 0;
            for(int j = 0; j < array.length; j++){
                if(array[j] == i){
                    counter++;
                }
                index_array[i] = counter;
            }
        } 

        //sum up the index array values with previous values
        for (int i = 1; i <= max; i++) {
            index_array[i]= index_array[i]+index_array[i-1];
          }

        //create output array to store sorted values 
        int[] output_array = new int[array.length];
        
        //map the value of the given array with index array and put the value in the output array
        for (int i = array.length-1; i>=0; i--) {
            output_array[index_array[array[i]] - 1] = array[i];
            index_array[array[i]]--; //decrement index array value
        }


        for (int i = 0; i <array.length; ++i){
            array[i] = output_array[i];
            
        }
            
    }
        

    private int getInt(double i){
        return (int)Math.ceil(i); 
    
    }


    public static void main(String[] args) {
        
        CountingSort cs= new CountingSort("agn.us.txt","Close");
    }


}

