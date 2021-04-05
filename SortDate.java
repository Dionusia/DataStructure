import java.util.*;


public class SortDate {

    double array[];
    HashMap<String,Double> map = new LinkedHashMap<String,Double>();

    SortDate(double[] array,HashMap<String,Double> map) {
    
        this.array = array;
        this.map = map;
    }

    //K,V generics -> Function to get the key of a value in the map
    private static <K, V> K getKey(HashMap<K, V> map, V value) {

        for (K key: map.keySet()){
            if (value.equals(map.get(key))){
                return key;
            }
        }
        return null;

    }

    public LinkedHashMap<String,Double> classifyDateAndField(){

        LinkedHashMap<String,Double> sortedMap = new LinkedHashMap<String,Double>();

        for(double number : array){
            sortedMap.put(getKey(map,number),number);
        }
        return sortedMap;
    }
    
}
