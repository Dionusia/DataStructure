import java.util.Scanner;

public class InterpolationSearch {
    
    
    long startTime,endTime;

    InterpolationSearch(String filename,String target){

        try{

            FiletoArray ar = new FiletoArray(filename,"Volume");
            StringHandler handler = new StringHandler();

            long[] array = handler.stringToIntArray(ar.getDate());
            
            startTime = System.nanoTime();
            long pos = search(array,0,array.length-1,handler.stringToUnixTime(target));
            endTime = System.nanoTime();

            if(pos == -1)   
                System.out.println("Element not found");
            else
                System.out.println(target +", Volume: " + ar.getVolumeVector().get((int)pos));
               
            
        }catch(Exception e){
            e.printStackTrace();
        }
    }

    
    private long search(long[] array,long startIndex, long endIndex, long target){
        
        //startIndex will be array[0] for the first time whereas endIndex will be array[length -1]  

        if(array[(int)startIndex] == array[(int)endIndex]){
            return endIndex;
        }
        else if(startIndex <= endIndex && target >= array[(int)startIndex] && target <= array[(int)endIndex]){

            //position variable according to the interpolation algorithm
            long position = startIndex + (((endIndex - startIndex) / (array[(int)endIndex] - array[(int)startIndex]))*(target -array[(int)startIndex])); 


            if(array[(int)position] == target){
                return position; //element found
            }
            /*else if(array[(int)position] == endIndex)
                return search(array,position,endIndex,target);*/
            else if(array[(int)position] < target){
                return search(array,position+1,endIndex,target); //go to the next element in position of the left part of array
            }
            else if(array[(int)position] > target){
                return search(array,startIndex,position-1,target); //go to the next element in position of the right part of array(starting from high)
            }
            

        }
        
        return -1; //element not found
    }


    public static void main(String[] args){
        
        StringHandler handler = new StringHandler();
        
        InterpolationSearch a = new InterpolationSearch("agn.us.txt", handler.getDate());
           
        
        System.out.println("Elapsed time: " + (a.endTime - a.startTime) +" nanoseconds");
    }
}
