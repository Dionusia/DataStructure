import java.util.LinkedList;

class Entry< K, V>{
    StringHandler handler = new StringHandler();
    K key; V value;

    int hash;
    public Entry(K key, V value){
        this.key=key;
        this.value=value;
        this.hash=key.hashCode();
    }

    //check if the element exist or not
    public boolean equals(Entry <K, V> other){
        if(hash !=other.hash)  return false;
        return key.equals(other.key);
    }

   /* public String toString(){
        return handler.dateFormat(key) + "->" +value;
    }*/
}

public class Hash <K,V>{

    private LinkedList<Entry< K, V> >[] array;
    private static final int INITIAL_SIZE = 11;
    private int size=0;

    public Hash(){
        for(int i=0; i<INITIAL_SIZE; i++) {
            array[i] = null;
        }
    }

    public int HashFunction(String key) {
    	
		String s=key.toGMTString();
		int value=0;
		int counter=0;
		for(int i=0;i<s.length();i++) {
			value=value+(int)key.charAt(i);
			counter++;
		}
    	return value%(counter+1);
    }

}

