import java.io.IOException;
import java.util.*;

public class QuickSort {

    long startTime,endTime;
    QuickSort(String filename, String field) {
        try{
            FiletoArray fta = new FiletoArray(filename, field);
            double array[] = fta.getField();

            startTime = System.nanoTime();
            quickSort(array,0,array.length-1);
            endTime = System.nanoTime();
            
            SortDate order = new SortDate(array,fta.getMap());

            LinkedHashMap<String,Double> orderedMap = order.classifyDateAndField(fta.getMap(),array);


            for(Map.Entry<String,Double> entry : orderedMap.entrySet()) {
                System.out.println("Key: "+ entry.getKey() + " Value: "+ entry.getValue());
            }
        }    
        catch(IOException e){
            e.printStackTrace();
        }
    }
  


    public static int Partition(double [] array, int startIndex,int endIndex){
      double pivot=array[endIndex]; //make the last element as pivot element
      int i = (startIndex-1); 
        for (int j=startIndex; j<endIndex; j++) { 
            // If current element is smaller than the pivot
            if (array[j] <= pivot) 
            { 
               // Increment index of smaller element
                i++;  
                double temp = array[i]; 
                array[i] = array[j]; 
                array[j] = temp; 
            } 
        } 
    
        double temp = array[i+1]; 
        array[i+1] = array[endIndex]; 
        array[endIndex] = temp; 
   
        return i+1; 
  
    }


    public static void quickSort(double [] array,int startIndex,int endIndex){
        if(startIndex<endIndex){
            int pIndex= Partition(array, startIndex, endIndex); //stores the position of pivot
            quickSort(array, startIndex, pIndex-1); //sorts the left side of pivot
            quickSort(array, pIndex+1, endIndex);   //sorts the right side of pivot
        }
      
    }

    public static void main(String[] args) {  
        //QuickSort sort = new QuickSort("agn.us.txt","Volume");
        try{
            QuickSort a = new QuickSort("agn.us.txt","Open");
            System.out.println("Elapsed time: " + (a.endTime - a.startTime) +" nanoseconds");
        
        }catch(Exception e){
            e.printStackTrace();
        }
    }
}

