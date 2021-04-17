import java.util.Scanner;

public class InterpolationSearch {
    
    
    InterpolationSearch(String filename,String target){

        try{

            FiletoArray ar = new FiletoArray(filename,"Volume");
            StringHandler handler = new StringHandler();

            int[] array = handler.stringToIntArray(ar.getDate());
            
            int pos = search(array,0,array.length-1,handler.stringHandler(target));
            
            if(pos == -1)   
                System.out.println("Element not found");
            else
                System.out.println("Element found, Volume: " + ar.getVolumeVector().get(pos));
               
            
        }catch(Exception e){
            e.printStackTrace();
        }
    }

    
    private int search(int[] array,int startIndex, int endIndex, int target){
        
        //startIndex will be array[0] for the first time whereas endIndex will be array[length -1]  

        if(startIndex <= endIndex && target >= array[startIndex] && target <= array[endIndex]){

            //position variable according to the interpolation algorithm
            int position = startIndex + (((endIndex - startIndex) / (array[endIndex] - array[startIndex]))*(target -array[startIndex])); 

            if(array[position] == target){
                return position; //element found
            }
            else if(array[position] < target){
                return search(array,position+1,endIndex,target); //go to the next element in position of the left part of array
            }
            else if(array[position] > target){
                return search(array,startIndex,position-1,target); //go to the next element in position of the right part of array(starting from high)
            }

        }
        
        return -1; //element not found
    }




    public static void main(String[] args){
        Scanner input = new Scanner(System.in);

        System.out.println("Date to search for: ");
        String getInput = input.nextLine();

        input.close();
        InterpolationSearch a = new InterpolationSearch("agn.us.txt", getInput);

    }
}
