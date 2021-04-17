import java.util.Scanner;

public class BIS {
    

    BIS(String filename, String target){
        
        try{

            FiletoArray ar = new FiletoArray(filename,"Volume");
            StringHandler handler = new StringHandler();

            int[] array = handler.stringToIntArray(ar.getDate());
            
            int pos = bisSearch(array,0,array.length -1,handler.stringHandler(target));
            
            if(pos == -1)   
                System.out.println("Element not found");
            else
                System.out.println("Element found, Volume: " + ar.getVolumeVector().get(pos));
            
        }catch(Exception e){
            e.printStackTrace();
        }

    }

    private int bisSearch(int[] array, int left, int right, int target){

        if(left>right || (left==right && array[left]!=target)){
            return -1;
        }
        else if(left==right && array[left] == target){
            return left;
        }
        int position = (target-array[left])/(array[right] -array[left]);

        int mid = left + position*(right-1);

        int i =1;

        if(target > array[mid]){
            int next = mid + i*(int)Math.sqrt(array.length);

            while(true){
                

                if(next>right || target<array[next])
                    break;

                if(target == array[next])
                    return next;

                i = i++;
                
            }
            left = mid + (i-1)*(int)Math.sqrt(array.length) + 1;
            
            right = Math.min(right,next -1);
            return bisSearch(array,left,right,target);
        }
        else if(target<array[mid]){
            int next = mid - i*(int)Math.sqrt(array.length);

            while(true) {
                

                if(next <left || target>array[next])   
                    break;
                
                if(target == array[next])   
                    return next;

                i = i++;
            }
            right = mid -(i-1)*(int)Math.sqrt(array.length) - 1;
            left = Math.max(left,next + 1);

            return bisSearch(array,left,right,target);
        }
        else
            return mid;
        
    }


    public static void main(String[] args){
        Scanner input = new Scanner(System.in);

        System.out.println("Date to search for: ");
        String getInput = input.nextLine();

        input.close();
        BIS a = new BIS("agn.us.txt", getInput);

    }

}
