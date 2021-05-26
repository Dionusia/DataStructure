import java.io.IOException;


public class BinarySearch {

    long startTime,endTime;
    BinarySearch(String filename,String target){
        try{
            FiletoArray ar = new FiletoArray(filename, "Volume");
            String[] array= ar.getDate();
            
            
            //position of the given array
            startTime = System.nanoTime();
            int position = binarySearch(array, target);
            endTime = System.nanoTime();



            //match the position of the date to volume
            
            if(position !=-1){
                System.out.println("Volume for the given date is: " + ar.getVolumeVector().get(position));
            }
            else
                System.out.println("Date not found");

            
        }
        catch(IOException e){}

    }
    

    
    private int binarySearch(String[] array,String target){

        int left=0;
        int right=array.length;

        while(left<right){
            int mid=(left+right) /2;

            int compare=target.compareTo(array[mid]); 
        
            if(compare==0){
                return mid;
            }
            else if(compare<0){
                right=mid-1;
            }
            else{
                left=mid+1;
            }
        }
         
        return -1;
    
    }

    public static void main(String[] args) {
        
        StringHandler handler = new StringHandler();
       
        BinarySearch a = new BinarySearch("agn.us.txt",handler.getDate());
        
        System.out.println("Elapsed time: " + (a.endTime - a.startTime) +" nanoseconds");
      
    } 
}
