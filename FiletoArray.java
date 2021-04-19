import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;


public class FiletoArray {

    private HashMap<String,Double> DateOpenMap = new LinkedHashMap<String,Double>();
    private Vector<String> date = new Vector<String>(); 
    private Vector<Integer> volume = new Vector<Integer>();
    
    
    FiletoArray(String path,String wordToAvoid) throws IOException{

        BufferedReader reader =null;
        String readline = ""; //stores a line

        int numberOfType = 0;
        try{
            
             reader = new BufferedReader(new FileReader(path));

            while((readline = reader.readLine()) != null){
                String [] types = readline.split("[,]");
                
                

                if(isFirstLine(types[1])){

                    for(int i = 0; i<types.length; ++ i){
                        if(types[i].equals(wordToAvoid))
                            numberOfType = i;
                    }
        
                }
                else{
                    if(wordToAvoid == "Volume"){
                        date.add(types[0]);
                        volume.add(Integer.parseInt(types[numberOfType]));
                        
                    }
                    else
                        DateOpenMap.put(types[0], Double.parseDouble(types[numberOfType]));
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


    public HashMap<String,Double> getMap(){
        return DateOpenMap;
    }



    public double[] getField(){
        
        Vector<Double> vec = new Vector<Double>(); 
        double[] array;

        for(Map.Entry<String,Double> mapElement : DateOpenMap.entrySet()){
            vec.add((double)mapElement.getValue());
        }

        array = new double[vec.size()];

        for(int i=0;i<vec.size();i++){
            array[i] = vec.get(i);
        }
        return array;
    }



    public String[] getDate(){
        String[] array = date.toArray(new String[date.size()]);
        return array;
    }


    public  Vector<Integer> getVolumeVector(){
        return volume;
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
