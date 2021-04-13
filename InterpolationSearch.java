import java.util.Scanner;

public class InterpolationSearch {
    
    
    InterpolationSearch(String filename,String target){

        try{

            FiletoArray ar = new FiletoArray(filename,"Volume");

            int[] array = stringToIntArray(ar.getDate());
            
            int pos = search(array,0,array.length-1,stringHandler(target));
            
            if(pos == -1)   
                System.out.println("Element not found");
            else
                System.out.println("Element found in position: " + ar.getVolumeVector().get(pos));
               
            
        }catch(Exception e){
            e.printStackTrace();
        }
    }

    
    private int search(int[] array,int startIndex, int endIndex, int target){
        
        //startIndex will be array[0] for the first time whereas endIndex will be array[length -1]


        //position variable according to the interpolation algorithm
        int position = startIndex + (((endIndex - startIndex) / (array[endIndex] - array[startIndex]))*(target -array[startIndex]));   

        if(startIndex <= endIndex && target >= array[startIndex] && target <= array[endIndex]){

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


    private int[] stringToIntArray(String[] array) {

        int[] int_array = new int[array.length];

        for(int i = 0; i < array.length; i++){

            int_array[i] = stringHandler(array[i]);
        }
        return int_array;
    }


    private int stringHandler(String str) {
        String[] values = str.split("-");
        String s = "";

        for(int i=0; i<values.length ;++i) {
            s = s + values[i];
        }
        return Integer.parseInt(s);
    }


    public static void main(String[] args){
        Scanner input = new Scanner(System.in);

        System.out.println("Date to search for: ");
        String getInput = input.nextLine();

        input.close();
        InterpolationSearch a = new InterpolationSearch("agn.us.txt", getInput);

    }
}
