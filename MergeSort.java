import java.io.IOException;

public class MergeSort {

    MergeSort(String filename, String field) {
        try{
            FiletoArray fta = new FiletoArray(filename, field);
            double array[] = fta.getField();
            mergeSort(array);
            
            for(double i : array) {
                System.out.println(i);
            }
              
        }catch(IOException e){
            e.printStackTrace();
        }

    }

    public static void merge(double[] left_array,double[] right_array,double[] array){

        int i=0;
        int left_counter=0;  int right_counter=0;
        while(left_counter < left_array.length && right_counter < right_array.length){

            if(left_array[left_counter]<right_array[left_counter]){
                array[i++] = left_array[left_counter++];
            }
            else{
                array[i++] = right_array[right_counter++];
            }
        }
        //this while loops checks which part of right or left has not end
        while(left_counter<left_array.length){
            array[i++] = left_array[left_counter++];
        }
        while(right_counter<right_array.length){
          array[i++] = right_array[right_counter++];
        }
    }

        

    public static double[] mergeSort(double[] array){

        int array_length = array.length;
        int k = 0;

        if(array_length < 2)
            return array;

        int mid_element = array_length / 2;

        double[] left_array = new double[mid_element];
        double[] right_array = new double[array.length - mid_element];

        for(int i=0; i<array_length; i++){
            if(i<mid_element){
                left_array[i] = array[i];
            }
            else{
                right_array[k] = array[i];
                ++k;
            }
        }


        mergeSort(left_array);
        mergeSort(right_array);
        merge(left_array, right_array,array);

        return array;
    }
    
         
    public static void main(String[] args) {
        MergeSort a = new MergeSort("agn.us.txt", "Open");
    }
}

    

    
    

 