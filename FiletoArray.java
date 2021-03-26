import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;



public class FiletoArray {

    private Map<String,Double> DateOpenMap = new HashMap<String,Double>();
    //= new HashMap<String,Double>();

    FiletoArray(String path,String wordToAvoid) throws IOException{

        BufferedReader reader =null;
        String readline = ""; //stores a line

        int numberOfType = 0;
        try{
             reader = new BufferedReader(new FileReader(path));

            while((readline = reader.readLine()) != null){
                String [] types = readline.split(",");
                
                

                if(isFirstLine(types[1])){

                    for(int i = 0; i<types.length; ++ i){
                        if(types[i].equals(wordToAvoid))
                            numberOfType = i;
                    }
        
                }
                else{
                    DateOpenMap.put(types[0], Double.parseDouble(types[numberOfType]));
                    System.out.println(Double.parseDouble(types[numberOfType]));
                }
            }
        }
        catch(FileNotFoundException fe){
            fe.printStackTrace();

        }catch(IOException e){
            e.printStackTrace();
        }
       finally{
           reader.close();
           
       }
    }

    public Map<String,Double> getMap(){
        return DateOpenMap;
    }


    private boolean isFirstLine(String value){
        try{
            Double.parseDouble(value);
            return false;
        }
        catch(NumberFormatException e){
            return true;
        }
    }

}