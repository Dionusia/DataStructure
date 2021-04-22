import java.io.IOException;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Menu {

    
    StringHandler handler = new StringHandler();
    Scanner input = new Scanner(System.in);
    String stringInput;
    BinarySearchTree volumeTree = new BinarySearchTree();
    BinarySearchTree tree = new BinarySearchTree();
    int intInput = 0;


    Menu(){
        try{
            FiletoArray ar = new FiletoArray("agn.us.txt","Volume");
            

            int[] array = handler.stringToIntArray(ar.getDate());

            Vector<Integer> volume = new Vector<Integer>();

            for(int i=0; i<volume.size(); i++) {
                tree.addNode(array[i], ar.getVolumeVector().get(i)); 
                volumeTree.addNode(volume.get(i),array[i]);
            }

            /*for(int i=0; i<ar.getVolumeVector().size(); i++){
                volumeTree.addNode(ar.getVolumeVector().get(i), ar.getDate()s);
            }*/


            initialMenu();


        }catch(IOException e){}

    }


    private void initialMenu(){
        while(true){
            System.out.println("Choose which menu you want: ");
            System.out.println("1 --> BTS which keeps the record Date,Volume sorted by Date: ");
            System.out.println("2 --> BTS which keeps the record Date,Volume sorted by Volume: ");
            System.out.println("3 --> Hashing which keeps the record Date,Volume sorted by Date: ");
            System.out.print(">> ");

            stringInput = input.nextLine();

            try {
                intInput = Integer.parseInt(stringInput);
                
                if(intInput <= 0 || intInput > 3){
                    System.out.print("\033[H\033[2J");   
                    System.out.flush();
                    System.out.println("Integer should be between 1 and 3");
                }
                else
                    break;

            }catch (Exception e){
                System.out.print("\033[H\033[2J");   
                System.out.flush();
                System.out.println("Please type an integer from 1-3");
            }
        }

        initialChoiseHandler();

    } 

    private void initialChoiseHandler(){
        switch (intInput) {

            case 1:
                createMenu();
                break;
            case 2:
                createVolumeMenu();
                break;

        }
    }


    private void createMenu(){
       
        while(true){
            System.out.println("Main menu with BST: (pick from 1 to 5)");
            System.out.println("1 --> Display BST with in order traverse");
            System.out.println("2 --> Search for a Volume by date");
            System.out.println("3 --> Change Volume of a date");
            System.out.println("4 --> Delete a record by date");
            System.out.println("5 --> exit");
            System.out.print(">> ");    

            

            stringInput = input.nextLine();

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
        choiceHandler();
    }

    
    private void choiceHandler(){
        
        switch (intInput) {

            case 1:
                System.out.println("You picked display BST");
                tree.inOrderTraverseTree(tree.root);
                goBackToMenu();

                break;
            case 2:
                
                int dateToInt = handler.stringHandler(getDate());
    
                System.out.println(tree.findNode(dateToInt));

                goBackToMenu();

                break;
            case 3:
                
                dateToInt = handler.stringHandler(getDate());

                getInteger();

                tree.changeNode(dateToInt,intInput);
            
                goBackToMenu();

                break;
            case 4:
                dateToInt = handler.stringHandler(getDate());
                
                tree.deleteNode(tree.root,dateToInt);

                goBackToMenu();
                break; 

            case 5:
                System.exit(0);
                break;
            default:
                break;
        }
    }

    private void createVolumeMenu(){
        while(true){

            System.out.println("1 --> Find Date sorted by the minimum Volume: ");
            System.out.println("2 --> Find Date sorted by the maximum Volume: ");
        

            stringInput = input.nextLine();

            try {
                intInput = Integer.parseInt(stringInput);
                
                if(intInput <= 0 || intInput > 2){
                    System.out.print("\033[H\033[2J");   
                    System.out.flush();
                    System.out.println("Integer should be between 1 and 2");
                }
                else
                    break;

            }catch (Exception e){
                System.out.print("\033[H\033[2J");   
                System.out.flush();
                System.out.println("Please type an integer from 1-2");
            }

        }

        switch (intInput){
            case 1:
               volumeTree.findMinimum(volumeTree.root);
               break;
            
            case 2:
               volumeTree.findMaximum(volumeTree.root);
               break;

        }

    }


    private void goBackToMenu(){

        while(true) {
            System.out.println("Type \"back\" to go back in menu or \"exit\" to close the programm");
            System.out.print("> ");
            stringInput = input.nextLine();

            if(stringInput.equals("back")){
                System.out.print("\033[H\033[2J");  
                System.out.flush();
                createMenu();
                break;
            }
            else if(stringInput.equals("exit")){
                System.exit(0);
                break;
            }
        }
    }


    private void getInteger(){

        while (true){
            try{
                System.out.println("Enter a new Volume to modify:  (only integer value)");
                System.out.print("> ");
                stringInput = input.nextLine();

                intInput = Integer.parseInt(stringInput);
                break;
            }catch(Exception exe){
                System.out.print("\033[H\033[2J");  
                System.out.flush();
                System.out.println("Please type an integer!");
            }

        }
    }


    private boolean checkDateFormat(String input){
        Pattern pattern = Pattern.compile("^(19|20)\\d\\d[- /.](0[1-9]|1[012])[- /.](0[1-9]|[12][0-9]|3[01])$");
        Matcher matcher = pattern.matcher(input);
        
        return matcher.matches();
    }


    private String getDate(){

        while(true){
            System.out.println("Enter a date (yyyy-mm-dd): ");
            System.out.print("> ");
            stringInput = input.nextLine(); 

            if(checkDateFormat(stringInput))
                break;
            else{
                System.out.print("\033[H\033[2J");  
                System.out.flush();
                System.out.println("Please enter a valid date (yyyy-mm-dd)");
            }
        }
        return stringInput;
    }

    public static void main(String[] args) {
        Menu a = new Menu();

        
    }
}
