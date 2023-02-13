package filtre;
import java.util.*;

/**
 *
 * @author maxim
 */
public class FiltreBlumLinkedList {
    int nbBits;
    int nbHash;
    LinkedList<Boolean> table;
    
    public FiltreBlumLinkedList(int nbBits, int nbHash){
        this.nbBits = nbBits;
        this.nbHash = nbHash;
        this.table = new LinkedList<Boolean>();
        initLinkedList();
    }

    public void initLinkedList(){
        for(int i = 0; i < nbBits; i++){
            table.add(false);
        }
    }
    
    public void add(String s){
        for(int i = 0; i < nbHash; i++){
            int hash = hash(s, i);
            table.set(hash,true);
        }
    }
    
    public boolean contains(String s){
        for(int i = 0; i < nbHash; i++){
            int hash = hash(s, i);
            if(!table.get(hash)){
                return false;
            }
        }
        return true;
    }
    
    public void clear(){
        table.clear();
    }
    
    private int hash(String s, int i){
        int hash = 0;
        for(int j = 0; j < s.length(); j++){
            hash += s.charAt(j) * i;
        }
        return hash % nbBits;
    }
}
