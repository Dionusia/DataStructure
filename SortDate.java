import java.util.*;


public class SortDate {


    //K,V generics -> Function to get the key of a value in the map
    private static <K, V> K getKey(HashMap<K, V> map, V value) {

        for (K key: map.keySet()){
            if (value.equals(map.get(key))){
                return key;
            }
        }
        return null;

    }

    public LinkedHashMap<String,Double> classifyDateAndField(HashMap<String,Double>map,double[] array){

        LinkedHashMap<String,Double> sortedMap = new LinkedHashMap<String,Double>();

        for(double number : array){
            sortedMap.put(getKey(map,number),number);
        }
        return sortedMap;
    }


    public LinkedHashMap<Double,Integer> classifyArray(HashMap<Double,Integer> map, int[] array){

        LinkedHashMap<Double,Integer> sortedMap = new LinkedHashMap<Double,Integer>();

        for(int number : array){
            sortedMap.put(getKey(map,number),number);
        }

        return sortedMap;
    }


    public double[] getDoubleArray(LinkedHashMap<Double,Integer> map){
        
        
        Vector<Double> vec = new Vector<Double>(); 
        double[] array;

        for(Map.Entry<Double,Integer> mapElement : map.entrySet()){
            vec.add((double)mapElement.getKey());
        }

        array = new double[vec.size()];

        for(int i=0;i<vec.size();i++){
            array[i] = vec.get(i);
        }
        return array;
    }

}
