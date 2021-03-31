import java.io.IOException;

public class MergeSort {

    MergeSort(String filename, String field) {
        try{
            FiletoArray fta = new FiletoArray(filename, field);
            double array[] = fta.getField();
            merge(array);
            
              
        }catch(IOException e){
            e.printStackTrace();
        }

    }

    public static void mergeSort( double[] array,int left_size, int right_size){
       
        int mid = array.length/ 2;
        double  left_array[] = new double[mid];
        double  right_array[] = new double[array.length-mid];
        
        //copy data to sub arrays
        int k=0;

        for(int i = 0;i<array.length;++i){
            if(i<mid){
                left_array[i] = array[i];
            }
            else{
                right_array[k] = array[i];
                k = k+1;
            }
        }

       int i=0;
      int left_counter=0;  int right_counter=0;
        while(left_counter<left_size && right_counter<right_size){
          
            if(left_array[left_counter]<right_array[left_counter]){
                array[i++] = left_array[left_counter++];
            }
            else{
                array[i++] = right_array[right_counter++];
            }
        }
        //this while loops checks which part of right or left has not end
        while(left_counter<left_size){
            array[i++] = left_array[left_counter++];
        }
        while(right_counter<right_size){
          array[i++] = right_array[right_counter++];
        }
    }

    public static void merge(double array[]){
        if (array.length <= 1){ return;} //checks if there is one element in the array
        
        int mid = array.length/ 2;
        double  left_array[] = new double[mid];
        double  right_array[] = new double[array.length-mid];
       

      merge(left_array);
      merge(right_array);
      mergeSort(array,left_array.length,right_array.length);
      
    }

    
     
public static void main(String[] args) {
    MergeSort a = new MergeSort("agn.us.txt", "Open");
    System.out.println("Jedkeod");
}
}

    

    
    

 