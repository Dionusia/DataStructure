import java.io.IOException;
import java.util.*;


public class MergeSort {

    long startTime,endTime;

    MergeSort(String filename, String field) {
        try{
            FiletoArray fta = new FiletoArray(filename, field);
            double array[] = fta.getField();

            startTime = System.nanoTime(); 
            
            mergeSort(array,array.length);
            endTime = System.nanoTime();
            SortDate order = new SortDate();

            LinkedHashMap<String,Double> orderedMap = order.classifyDateAndField(fta.getMap(),array);


            for(Map.Entry<String,Double> entry : orderedMap.entrySet()) {
                System.out.println("Key: "+ entry.getKey() + " Value: "+ entry.getValue());
            }
              
        }catch(IOException e){
            e.printStackTrace();
        }

    }
    
    private static void merge(double[] left_array,double[] right_array, double[] array,int left_size, int right_size){
        
        int i=0; int left_array_counter=0; int right_array_counter=0;

        while(left_array_counter<left_size && right_array_counter<right_size){
        
            if(left_array[left_array_counter]<right_array[right_array_counter]){
                array[i++] = left_array[left_array_counter++];
            }
            else{
                array[i++] = right_array[right_array_counter++];
            }
        }
        //this while loops checks which part of right or left has not end
        while(left_array_counter<left_size){
            array[i++] = left_array[left_array_counter++];
        }
        while(right_array_counter<right_size){
        array[i++] = right_array[right_array_counter++];
        }
    }


    private void mergeSort(double array[], int lenght){

        if (lenght <= 1){
            return;
        } //checks if there is one element in the array
        
        int mid = lenght / 2;
        double  left_array[] = new double[mid];
        double  right_array[] = new double[lenght-mid];
        int k=0;

        for(int i = 0;i<lenght;++i){
            if(i<mid){
                left_array[i] = array[i];
            }
            else{
                right_array[k] = array[i];
                k = k+1;
            }
        }

        mergeSort(left_array,mid);
        mergeSort(right_array,lenght-mid);
        merge(left_array,right_array,array,mid,lenght-mid);
    }

  
    public static void main(String[] args) {
        MergeSort a = new MergeSort("agn.us.txt", "Open");

        System.out.println("Elapsed time: " + (a.endTime - a.startTime) +" nanoseconds");
    }
}

    

    
    

 