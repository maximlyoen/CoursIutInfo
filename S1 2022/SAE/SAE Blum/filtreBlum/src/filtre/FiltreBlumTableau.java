package filtre;
  
/**
 *
 * @author maxim
 */
public class FiltreBlumTableau{
    public int nbBits;
    public int nbHash;
    public boolean[] table;
    
    public FiltreBlumTableau(int nbBits, int nbHash){
        this.nbBits = nbBits;
        this.nbHash = nbHash;
        this.table = new boolean[nbBits];
    }
    
    public void add(String s){
        for(int i = 0; i < nbHash; i++){
            int hash = hash(s, i);
            table[hash] = true;
        }
    }
    
    public boolean contains(String s){
        for(int i = 0; i < nbHash; i++){
            int hash = hash(s, i);
            if(!table[hash]){
                return false;
            }
        }
        return true;
    }
    
    public void clear(){
        for(int i = 0; i < nbBits; i++){
            table[i] = false;
        }
    }
    
    private int hash(String s, int i){
        int hash = 0;
        for(int j = 0; j < s.length(); j++){
            hash += s.charAt(j) * i;
        }
        return hash % nbBits;
    }
}