package utils;

/**
 *
 * @author michelle
 */
public class HashMap {
    private static final int DEFAULT_CAPACITY = 20;
    private Entry [] data;
    private int size;
    
    public HashMap(){
        data = new Entry[DEFAULT_CAPACITY];
    }
    
    public HashMap(int capacity){
        if(capacity <= 0){
            throw new IllegalArgumentException("Map capacity cannot be less than 1");
        }
        data = new Entry[capacity];
    }
    
    public int size(){
        return size;
    }
    
    private int hashFunction(String key){
        int hash = key.hashCode();
        hash = Math.abs(hash) % data.length;
        return hash;
    }
    
    public String put(String key, String value){
        int calculatedSlot = hashFunction(key);
        if(data[calculatedSlot] == null){
            Entry newEntry = new Entry(key, value);
            data[calculatedSlot] = newEntry;
            size++;
            return null;
        }else{
            String oldValue = data[calculatedSlot].updateValue(value);
            return oldValue;
        }
    }
    
    private static class Entry{
        private String key;
        private String value;
        
        public Entry(String key, String value){
            this.key = key;
            this.value = value;
        }
        
        public String getKey(){
            return key;
        }
        public String getValue(){
            return value;
        }
        public String updateValue(String newValue){
            String oldValue = value;
            this.value = newValue;
            return oldValue;
        }
    }
}