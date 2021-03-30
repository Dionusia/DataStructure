public class QuickSort {


   public static int Partition(int [] array, int startIndex,int endIndex){
      int pivot=array[endIndex]; //make the last element as pivot element
      int i = (startIndex-1); 
        for (int j=startIndex; j<endIndex; j++) 
        { 
            // If current element is smaller than the pivot
            if (array[j] <= pivot) 
            { 
               // Increment index of smaller element
                i++;  
                int temp = array[i]; 
                array[i] = array[j]; 
                array[j] = temp; 
            } 
        } 
    
        int temp = array[i+1]; 
        array[i+1] = array[endIndex]; 
        array[endIndex] = temp; 
   
        return i+1; 
  
       }


   public static void quickSort(int [] array,int startIndex,int endIndex){
      if(startIndex<endIndex){
         int pIndex= Partition(array, startIndex, endIndex); //stores the position of pivot
         quickSort(array, startIndex, pIndex-1); //sorts the left side of pivot
         quickSort(array, pIndex+1, endIndex);   //sorts the right side of pivot
      }
      
   }

}
