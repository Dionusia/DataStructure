import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.LinkedList;

class DateVolume {

	int volume;
	String date;
	
    public void setDate(String date) {
    	this.date=date;
    }
    public String getDate() {
    	return date;
    }
    public void setVolume(int volume) {
    	this.volume=volume;
    }
    public double getVolume() {
    	return volume;
    }
}

public class Hash{
    public static final int capacity = 25;
    @SuppressWarnings({"unchecked"})
    LinkedList<DateVolume>[] hashTable = new LinkedList[capacity];
    public Hash() {
        
        for(int i=0; i<capacity; i++) {
            hashTable[i] = null;
        }
    }
    //Converts a date to an int using the ascii value of the digits
    public int HashFunction(String date) {
    	
		SimpleDateFormat dfDate  = new SimpleDateFormat("dd/MMM/yyyy HH:mm:ss");
        String data="";
        Calendar c = Calendar.getInstance(); 
        data=dfDate.format(c.getTime());
		int value=0;
		int counter=0;
		for(int i=0;i<data.length();i++) {
			value=value+(int)data.charAt(i);
			counter++;
		}
    	return value%(counter+1);
    }

    public void put(String date, int volume) {
        int index = HashFunction(date);
        LinkedList<DateVolume> items = hashTable[index];
 
        if(items == null) {
            items = new LinkedList<DateVolume>();
 
            DateVolume item = new DateVolume();
            item.date = date;
            item.volume= volume;
 
            items.add(item);
 
            hashTable[index] = items;
        }
        else {
            for(DateVolume item : items) {
                if(item.date.equals(date)) {
                    item.volume = volume;
                    return;
                }
            }
 
            DateVolume item = new DateVolume();
            item.date = date;
            item.volume=volume;
 
            items.add(item);
        }
    }
    //Find volume using a given date
    public int findVolume(String date) {
    	int v = 0;
    	int index = HashFunction(date);
        for(DateVolume item:hashTable[index]) {
        	if(item.date.equals(date)) {
        		 v=item.volume;
        	}
        }
		return v;
    }
    
   //Delete a record
    
    public void delete(String date) {
    	int index = HashFunction(date);
        LinkedList<DateVolume> items = hashTable[index];
 
        if(items == null)
            return;
 
        for(DateVolume item : items) {
            if (item.date.equals(date)) {
                items.remove(item);
                return;
            }
        }
    }
    
    //change a volume of a given date
    public void changeVolume(String date,int volume) {
    	int index = HashFunction(date);
    	LinkedList<DateVolume> items = hashTable[index];
    	
    	 if(items == null)
             return;
  
         for(DateVolume item : items) {
             if (item.date.equals(date)) {
                 item.setVolume(volume);
                 return;
             }
         }
    }

}
