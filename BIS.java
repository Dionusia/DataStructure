import java.util.Scanner;

public class BIS {
    
    long startTime,endTime;
    BIS(String filename, String target){
        
        try{

            FiletoArray ar = new FiletoArray(filename,"Volume");
            StringHandler handler = new StringHandler();

            long[] array = handler.stringToIntArray(ar.getDate());
            
            startTime = System.nanoTime(); 
            long pos = bisSearch(array,0,array.length -1,handler.stringHandler(target));
            
            endTime = System.nanoTime();
            
            if(pos == -1)   
                System.out.println("Element not found");
            else
                System.out.println("Element found, Volume: " + ar.getVolumeVector().get((int)pos));
            
        }catch(Exception e){
            e.printStackTrace();
        }

    }

    private long bisSearch(long[] array, long left, long right, long target){

        
        if(left>right || (left==right && array[(int)left]!=target)){            
            return -1;
        }
        else if(left==right && array[(int)left] == target){    
            return left;
        }

        long position = (target-array[(int)left])/(array[(int)right] -array[(int)left]);

        long mid = left + position*(right-1);

        int i =1;

        if(target > array[(int)mid]){
            long next = mid + i*(int)Math.sqrt(array.length);

            while(true){
                

                if(next>right || target<array[(int)next])
                    break;

                if(target == array[(int)next]){
                    return next;
                }

                i = i++;
                
            }
            left = mid + (i-1)*(int)Math.sqrt(array.length) + 1;
            
            right = Math.min(right,next -1);
            return bisSearch(array,left,right,target);
        }
        else if(target<array[(int)mid]){
            long next = mid - i*(int)Math.sqrt(array.length);

            while(true) {
                

                if(next <left || target>array[(int)next])   
                    break;
                
                if(target == array[(int)next]){
                    return next;
                }

                i = i++;
            }
            right = mid -(i-1)*(int)Math.sqrt(array.length) - 1;
            left = Math.max(left,next + 1);

            return bisSearch(array,left,right,target);
        }
        else{
            
            return mid;
        }
        
        
        
    }


    public static void main(String[] args){
        Scanner input = new Scanner(System.in);
        
        System.out.println("Date to search for: ");
        String getInput = input.nextLine();

        input.close();
        BIS a = new BIS("agn.us.txt", getInput);

        System.out.println("Elapsed time: " + (a.endTime - a.startTime) +" milliseconds");

    }

}
