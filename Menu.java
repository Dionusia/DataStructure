import java.io.IOException;
import java.util.*;


public class Menu {

    
    StringHandler handler = new StringHandler();
    GoBackToMenu goBack;
    Scanner input = new Scanner(System.in);
    String stringInput;
    BSTVolume volumeTree = new BSTVolume();
    BinarySearchTree tree = new BinarySearchTree();
    int intInput = 0;
    FiletoArray ar;
    Hash hashTable = new Hash();

    Menu(){
        try{
            ar = new FiletoArray("agn.us.txt","Volume");

    
            long[] array = handler.stringToIntArray(ar.getDate());
            String[] arrayDate = ar.getDate();

            for(int i=0; i<array.length; i++) {
                tree.addNode(array[i], ar.getVolumeVector().get(i)); 
            }

            long[] array_volume = handler.stringToIntArray(ar.getDate());

            Vector<Integer> getVolume = ar.getVolumeVector();

            for(int i=0; i<getVolume.size(); i++) {
                volumeTree.addNodeVolume(array_volume[i],getVolume.get(i));
            }

            for(int i=0; i<arrayDate.length; i++){
                hashTable.put(arrayDate[i], getVolume.get(i));
            }

            treeOrHash();


        }catch(IOException e){
            e.printStackTrace();
        }

    }

    //choose tree or hash implementation
    private void treeOrHash(){
        Scanner input = new Scanner(System.in);
        while(true){
            System.out.print("\033[H\033[2J");   
            System.out.flush();

            System.out.println("Choose Tree or Hash(Type \"Tree\" or \"Hash\")");
            System.out.print(">> ");
            stringInput = input.nextLine();

            if(stringInput.equals("Tree")){
                initialMenu();
                break;
            }
            else if(stringInput.equals("Hash")){
                hashMenu();
                break;
            }
        }
        input.close();

    }

    private void hashMenu(){
        
        while(true){
            System.out.print("\033[H\033[2J");   
            System.out.flush();

            System.out.println("Main hash menu(choose between 1 and 5)...");
            System.out.println("1 --> Search for a Volume based on a date");
            System.out.println("2 --> Change Volume according to a date");
            System.out.println("3 --> Delete Volume based on a date");
            System.out.println("4 --> Go back to \"Tree or Hash\" Menu <-|");
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

        hashMenuHandler(intInput);

    }


    //handle hash options
    private void hashMenuHandler(int number){
        goBack = ()->hashMenu();
        String givenString;
        int result;

        switch (number){
            case 1:
                givenString = handler.getDate();
                result = hashTable.findVolume(givenString);

                if(result != 0)
                    System.out.println("Volume of " + givenString + " is: " + result);
                else
                    System.out.println("This date does not exist");

                goBackToMenu();
                break;

            case 2:
                givenString = handler.getDate();
                result = hashTable.findVolume(givenString);

                if(result != 0){
                    getInteger();
                    hashTable.changeTemp(givenString,intInput);
                    System.out.println("Volume of date: " + givenString + " changed to " + intInput + ".");

                }
                else{
                    System.out.println("This date does not exist!");
                }
                goBackToMenu();
                break;
            
            case 3:
                givenString = handler.getDate();
                result = hashTable.findVolume(givenString);

                if(result != 0){
                    hashTable.delete(givenString);
                    System.out.println("Record with date: " + givenString + " and volume: " + result + " deleted.");
                }
                else{
                    System.out.println("This date does not exist!");
                }
                goBackToMenu();
                break;
            
            case 4:
                System.out.print("\033[H\033[2J");   
                System.out.flush();
                treeOrHash();
                break;
            case 5:
                System.exit(0);
                break;
        }
    }


    //initial bst menu
    private void initialMenu(){
        while(true){
            System.out.print("\033[H\033[2J");   
            System.out.flush();

            System.out.println("Choose tree representation(Type integer between 1 and 4)...");
            System.out.println("1 --> BST which keeps the record Date,Volume sorted by Date: ");
            System.out.println("2 --> BST which keeps the record Date,Volume sorted by Volume: ");
            System.out.println("3 --> Go back <-|");
            System.out.println("4 --> exit");
            System.out.print(">> ");

            stringInput = input.nextLine();

            try {
                intInput = Integer.parseInt(stringInput);
                
                if(intInput <= 0 || intInput > 4){
                    System.out.print("\033[H\033[2J");   
                    System.out.flush();
                    System.out.println("Integer should be between 1 and 4");
                }
                else
                    break;

            }catch (Exception e){
                System.out.print("\033[H\033[2J");   
                System.out.flush();
                System.out.println("Please type an integer from 1-4");
            }
        }

        initialChoiceHandler();

    } 

    //implement bst menu choices
    private void initialChoiceHandler(){
        switch (intInput) {

            case 1:
                createMenu();
                break;
            case 2:
                createVolumeMenu();
                break;
            case 3:
                System.out.print("\033[H\033[2J");   
                System.out.flush();
                treeOrHash();
                break;
            case 4:
                System.exit(0);
                break;
        }
    }

    //Create bst menu
    private void createMenu(){
       
        while(true){
            System.out.print("\033[H\033[2J");   
            System.out.flush();

            System.out.println("Main menu with BST: (pick from 1 to 6)");
            System.out.println("1 --> Display BST with in order traverse");
            System.out.println("2 --> Search for a Volume by date");
            System.out.println("3 --> Change Volume of a date");
            System.out.println("4 --> Delete a record by date");
            System.out.println("5 --> Go back to initial Menu <-|");
            System.out.println("6 --> exit");
            
            System.out.print(">> ");    

            

            stringInput = input.nextLine();

            try {
                intInput = Integer.parseInt(stringInput);
                
                if(intInput <= 0 || intInput > 6){
                    System.out.print("\033[H\033[2J");   
                    System.out.flush();
                    System.out.println("Integer should be between 1 and 6");
                }
                else
                    break;

            }catch (Exception e){
                System.out.print("\033[H\033[2J");   
                System.out.flush();
                System.out.println("Please type an integer from 1-6");
            }

        }
        choiceHandler();
    }

    //implement choices of bst menu
    private void choiceHandler(){
        
        goBack = ()->createMenu();
        String date;
        long dateToInt;
        switch (intInput) {

            case 1:
                System.out.println("You picked display BST");
                tree.inOrderTraverseTree(tree.root);
                goBackToMenu();

                break;
            case 2:
                dateToInt = handler.stringToUnixTime(handler.getDate());
    
                System.out.println(tree.findNode(dateToInt));

                goBackToMenu();

                break;
            case 3:
                date = handler.getDate();
                dateToInt = handler.stringToUnixTime(date);

                getInteger();

                tree.changeNode(dateToInt,intInput);

                goBackToMenu();

                break;
            case 4:
                date = handler.getDate();
                dateToInt = handler.stringToUnixTime(date);
                
                tree.deleteNode(tree.root,dateToInt);

                System.out.println("Volume of date: " + date + " deleted.");
                goBackToMenu();
                break; 

            case 5:
                System.out.print("\033[H\033[2J");   
                System.out.flush();
                initialMenu();

                break;

            case 6:
                System.exit(0);
                break;
            default:
                break;
        }
    }

    //create menu sorted by volume
    private void createVolumeMenu(){
        goBack = ()->createVolumeMenu();
        while(true){
            System.out.print("\033[H\033[2J");   
            System.out.flush();

            System.out.println("1 --> Find Date sorted by the minimum Volume: ");
            System.out.println("2 --> Find Date sorted by the maximum Volume: ");
            System.out.println("3 --> Go back to initial Menu <-|");
            System.out.println("4 --> exit");
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

        switch (intInput){
            case 1:
               System.out.println(volumeTree.findMinimum(volumeTree.root));
               goBackToMenu();
               break;
            
            case 2:
               System.out.println(volumeTree.findMaximum(volumeTree.root));
               goBackToMenu();
               break;
            case 3:
                System.out.print("\033[H\033[2J");   
                System.out.flush();
                initialMenu();
                break;
            case 4:
                System.exit(0);
                break;
        }

    }


    //general purpose function to go back to the previous menu(takes advantage of interface)
    private void goBackToMenu(){
        Scanner input = new Scanner(System.in);
        while(true) {
            System.out.println("Type \"back\" to go back in menu or \"exit\" to close the programm");
            System.out.print("> ");
            stringInput = input.nextLine();

            if(stringInput.equals("back")){
                System.out.print("\033[H\033[2J");  
                System.out.flush();
                goBack.goBack();
                break;
            }
            else if(stringInput.equals("exit")){
                System.exit(0);
                break;
            }
        }
        input.close();
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


    public static void main(String[] args) {
        Menu a = new Menu();
    }
}

interface GoBackToMenu{
    void goBack();
}
