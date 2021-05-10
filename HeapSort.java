import java.io.IOException;
import java.util.*;

public class HeapSort {

    long startTime,endTime;
    HeapSort(String filename, String field) {
        try{
            FiletoArray fta = new FiletoArray(filename, field);
            double array[] = fta.getField();

            startTime = System.nanoTime();
            heapSort(array);
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



    private static void heapify(double [] array,int current,int size ){
        
        int largest=current; //parent
        int left=2*current+1; //left child
        int right=2*current+2; //right child
        
        //check which of the two childs is greater than the current element
        if(left<size && array[left]>array[largest]){
            largest=left;
        }
        if(right<size && array[right]>array[largest]){
            largest=right;
        }
        
        //swaps the elements
        if(largest!=current){
            double temp=array[current];
            array[current]=array[largest];
            array[largest]=temp;

            heapify(array,largest,size);
        }

    }

    private void heapSort(double [] array){

        for (int i = (array.length / 2) - 1; i >= 0; i--)
            heapify(array,i,array.length);
        
        for(int i= array.length-1; i>0; --i){
            double temp=array[0];
            array[0]=array[i];
            array[i]=temp;

            heapify(array,0,i); //heapify root(in our case array[0] element) with i
        }
    }

    public static void main(String[] args) {
        HeapSort a = new HeapSort("agn.us.txt", "Close");
        System.out.println("Elapsed time: " + (a.endTime - a.startTime) +" nanoseconds");
    }
}
