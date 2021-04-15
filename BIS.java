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

    private int bisSearch(int[] array, int l, int r, int target){

        if(l>r || (l==r && array[l]!=target)){
            return -1;
        }
        else if(l==r && array[l] == target){
            return l;
        }
        int position = (target-array[l])/(array[r] -array[l]);

        int mid = l + position*(r-1);

        int i =1;

        if(target > array[mid]){
            int next = mid + i*(int)Math.sqrt(array.length);

            while(true){
                

                if(next>r || target<array[next])
                    break;

                if(target == array[next])
                    return next;

                i++;
                
            }
            l = mid + (i-1)*(int)Math.sqrt(array.length) + 1;
            
            r = Math.min(r,next -1);
            return bisSearch(array,l,r,target);
        }
        else if(target<array[mid]){
            int next = mid - i*(int)Math.sqrt(array.length);

            while(true) {
                

                if(next <l || target>array[next])   
                    break;
                
                if(target == array[next])   
                    return next;

                i++;
            }
            r = mid -(i-1)*(int)Math.sqrt(array.length) - 1;
            l = Math.max(l,next + 1);

            return bisSearch(array,l,r,target);
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
