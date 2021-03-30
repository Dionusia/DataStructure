import java.io.IOException;

public class MergeSort {

    MergeSort(String filename, String field) {
        try{
            FiletoArray fta = new FiletoArray(filename, field);
            double array[] = fta.getField();
           

            for(double i :array) {
                System.out.println(i);
            }
              
        }catch(IOException e){
            e.printStackTrace();
        }

    }

    /*public static void merge(double[] left_array,double[] right_array, double[] array,int left_size, int right_size){
       
        int i=0; int left_array_counter=0; int right_array_counter=0;

        //
        while(left_array_counter<left_size && right_array_counter<right_size){
          
            if(left_array[left_array_counter]<right_array[left_array_counter]){
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
/*
    public static void mergeSort(double array[], int lenght){
        if (lenght <= 1){ return;} //checks if there is one element in the array
        
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
    */



     /*public static void mergeSort(double [] array){
        if (array.length <= 1) {
            for (int i = 0; i < array.length; ++i) 
                System.out.println(array[i]);
        } //checks if there is one element in the array
        
        int mid = array.length / 2;
        double  left_array[] = new double[mid];
        double  right_array[] = new double[array.length-mid];
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

      mergeSort(left_array);
      mergeSort(right_array);
      merge(left_array,right_array,array,mid,array.length-mid);
        /*int n = array.length; 
        
            System.out.println(array[i]); 
    }*/
    



    




public static void main(String[] args) {
    MergeSort a = new MergeSort("agn.us.txt", "Open");
}
}

    

    
    

 