package filtreblum;
import filtre.FiltreBlumArrayList;
import filtre.FiltreBlumTableau;
import filtre.FiltreBlumLinkedList;

/**
 *
 * @author maxim
 */
public class main {
    public static void main(String[] args) {
        test();
    }
    public static void test(){
        main m = new main();
        System.out.println("nombre de test : 100000");
        System.out.println("nombre de hash : 10");
        System.out.println("taille du tableau : 10000");
        m.testarray(100000, 10, 10000);
        m.testlinked(100000, 10, 10000);
        m.testtab(100000, 10, 10000);
        m.testtauxerreur(100000, 10, 10000);
    }

    public void testtab(int nbtest,int nbHash, int tabtaille){
        FiltreBlumTableau tab = new FiltreBlumTableau(tabtaille ,nbHash);
        int total=0;
        tab.add("Bonjour");
        for(int i = 0; i < nbtest; i++){
            int debut = (int) System.currentTimeMillis();
            tab.contains("Bonjour");
            int fin = (int) System.currentTimeMillis();
            total += (fin - debut);
        }
        System.out.println("Temps d'exécution du tableau : " + (total) + " ms");
    }

    public void testlinked(int nbtest,int nbHash, int linkedtaille){
        FiltreBlumLinkedList linked = new FiltreBlumLinkedList(linkedtaille, nbHash);
        int total=0;
        linked.add("Bonjour");
        for(int i = 0; i < nbtest; i++){
            int debut = (int) System.currentTimeMillis();
            linked.contains("Bonjour");
            int fin = (int) System.currentTimeMillis();
            total += (fin - debut);
        }
        System.out.println("Temps d'exécution de la liste chainée : " + (total) + " ms");
    }

    public void testarray(int nbtest,int nbHash, int arraytaille){
        FiltreBlumArrayList array = new FiltreBlumArrayList(arraytaille, nbHash);
        int total=0;
        array.add("Bonjour");
        for(int i = 0; i < nbtest; i++){
            int debut = (int) System.currentTimeMillis();
            array.contains("Bonjour");
            int fin = (int) System.currentTimeMillis();
            total += (fin - debut);
        }
        System.out.println("Temps d'exécution de l'arrayList : " + (total) + " ms");
    }

    public void testtauxerreur(int nbtest,int nbHash, int arraytaille){
        FiltreBlumArrayList array = new FiltreBlumArrayList(arraytaille, nbHash);
        int total=0;
        for(int i = 0; i < nbtest; i++){
            array.add("Bonjour");
            if(array.contains("Bonjour")){
                total++;
            }
        }
        System.out.println("Taux d'erreur : " + (total/nbtest) + " %");
    }

}