import java.io.IOException;
import java.util.*;

public class Menu {
    
    public static void main(String[] args) {
        
        BinarySearchTree tree = new BinarySearchTree();
        try{
            FiletoArray ar = new FiletoArray("agn.us.txt","Volume");
            StringHandler handler = new StringHandler();

            int[] array = handler.stringToIntArray(ar.getDate());


            for(int i=0; i<array.length; i++) {
                tree.addNode(array[i], ar.getVolumeVector().get(i)); 
    
            }

        }catch(IOException e){}
        
        int intInput = 0;
        while(true){
            System.out.println("Main menu: (pick from 1 to 5)");
            System.out.println("1 --> Display BST with in order traverse");
            System.out.println("2 --> Search for a Volume by date");
            System.out.println("3 --> Change Volume of a date");
            System.out.println("4 --> Delete a record by date");
            System.out.println("5 --> exit");
            System.out.print(">> ");    

            Scanner input = new Scanner(System.in);

            String stringInput = input.nextLine();

            try {
                intInput = Integer.parseInt(stringInput);
                
                if(intInput <= 0 || intInput > 5){
                    System.out.print("\033[H\033[2J");   
                    System.out.flush();
                    System.out.println("Integer should be between 1 and 5");
                }
                else
                    break;

            }catch (Exception e){
                System.out.print("\033[H\033[2J");   
                System.out.flush();
                System.out.println("Please type an integer from 1-5");
            }

        }

        switch (intInput) {

            case 1:
                System.out.println("You picked display BST");
                tree.inOrderTraverseTree(tree.root);

            case 2:
            StringHandler handler = new StringHandler();
            Scanner date = new Scanner(System.in);
            System.out.println("Enter a date(example:2007-04-17): ");
            String before = date.nextLine(); 
            int after = handler.stringHandler(before);
            
            System.out.println(tree.findNode(after));

            case 3:
            Scanner date1 = new Scanner(System.in);
            System.out.println("Enter a date(example:2007-04-17): ");
            String before1 = date1.nextLine(); 
            StringHandler handler1 = new StringHandler();
            int after1 = handler1.stringHandler(before1);

            Scanner volume = new Scanner(System.in);
            System.out.println("Enter a new Volume to modify:  (only integer value)");
            int value = volume.nextInt();

            tree.changeNode(after1,value);
    
                break;
        
            default:
                break;
        }


    }
}
