import java.io.IOException;

public class QuickSort {

    QuickSort(String filename, String field) {
        try{
            FiletoArray fta = new FiletoArray(filename, field);
            double array[] = fta.getField();
            quickSort(array,0,array.length-1);

            for(double i: array){
                System.out.println(i);
            }
        }    
        catch(IOException e){
            e.printStackTrace();
        }
    }
  


   public static int Partition(double [] array, int startIndex,int endIndex){
      double pivot=array[endIndex]; //make the last element as pivot element
      int i = (startIndex-1); 
        for (int j=startIndex; j<endIndex; j++) 
        { 
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
            FiletoArray fta = new FiletoArray("agn.us.txt","Volume");
            double[] array = fta.getField();

            for(double i : array){
                System.out.println(i);
            }
        }catch(Exception e){}
    }
}

