
/*public interface BinarySearch {
    
    public static double binarySearch(String [] array,String target){

        

        int left=0;
        int right=array.length-1;

        while(left<right){
            int mid=(left+right) /2;
        }
        if(array[mid]==target){
            return mid;
        }
        else if(target<array[mid]){
            right=mid-1;
        }
        else{
            left=mid+1;
        }
        return -1;
    }

    public static void main(String args[])
    {
        BinarySearch ob = new BinarySearch();
        int arr[] = { 2, 3, 4, 10, 40 };
        int n = arr.length;
        int x = 10;
        int result = ob.binarySearch(arr, 0, n - 1, x);
        if (result == -1)
            System.out.println("Element not present");
        else
            System.out.println("Element found at index " + result);
    }
}*/
