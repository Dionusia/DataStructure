import java.util.Scanner;

public class BIS {
    

    BIS(String filename, String target){
        
        try{

            FiletoArray ar = new FiletoArray(filename,"Volume");
            StringHandler handler = new StringHandler();

            int[] array = handler.stringToIntArray(ar.getDate());
            
            int pos = bisSearch(array,1,array.length ,handler.stringHandler(target));
            
            if(pos == -1)   
                System.out.println("Element not found");
            else
                System.out.println("Element found, Volume: " + ar.getVolumeVector().get(pos));
            
        }catch(Exception e){
            e.printStackTrace();
        }

    }

    private int bisSearch(int[] array, int l, int r, int target){

        int left = l;
        int right = r;

        int size = right - left;

        int next = (int) (size * ((target - array[left])/(array[right] - array[left]))) + 1;

        while(target != array[next]){

            int i =0;
            
            /*if(size<=3){
                //boolean found = false;
                int k =left;

                while(k<right){
                    if(array[k] == target){
                        return k;
                    }
                    k++;
                }
                return -1;
            }*/

            if(target >= array[next]){

                while(target > array[next + i*((int)Math.sqrt(size)) -1]){
                   i++;
                }
                right = next + (int)(i* Math.sqrt(size));
                left = next + (int)((i -1)* Math.sqrt(size));
            }

            else if(target < array[next]){
                
                while(target < array[next - i*((int)Math.sqrt(size) +1)]){
                    i++;
                }
                right = next - (int)((i -1)* Math.sqrt(size));
                left = next - (int)(i* Math.sqrt(size));
            }
            next = (int) (left +((right -left +1)*(target - array[left])/(array[right] - array[left]))) -1;
        }

        if(target == array[next]){
            return next;
        }
        else 
            return -1;
    }


    public static void main(String[] args){
        Scanner input = new Scanner(System.in);

        System.out.println("Date to search for: ");
        String getInput = input.nextLine();

        input.close();
        BIS a = new BIS("agn.us.txt", getInput);

    }

}
