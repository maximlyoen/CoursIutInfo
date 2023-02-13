package TPTris;

import java.util.Arrays;

/**
 * Différents tris.
 */
enum Sort {

    TRI_SELECTION,
    TRI_BULLE,
    TRI_COMPTAGE,
    TRI_RAPIDE,
    TRI_PAR_INSERTION,
    TRI_FUSION,
    TRI_JAVA;

    /**
     * Trier un tableau, en choisissant un algorithme.
     *
     * @param tab le tableau à trier
     * @param typeTri l'algorithme de tri à appliquer
     */
    static void tri(int[] tab, Sort typeTri) {
        switch (typeTri) {
            case TRI_SELECTION:
                Sort.triParSelection(tab);
                break;
            case TRI_BULLE:
                Sort.triABulle(tab);
                break;
            case TRI_COMPTAGE:
                Sort.triComptage(tab);
                break;
            case TRI_JAVA:
                Sort.triJava(tab);
                break;
            default:
                System.out.println("Type de tri non supporte : ");
        }
    }

    /**
     * Echanger deux éléments dans un tableau.
     *
     * @param tab le tableau
     * @param i l'indice du premier élément à échanger
     * @param j l'indice du deuxoème élément à échanger
     */
    static void echanger(int[] tab, int i, int j) {
        int tmp = tab[i];
        tab[i] = tab[j];
        tab[j] = tmp;
    }

    /**
     * Tri par sélection.
     *
     * @param tab le tableau à trier
     */
    static void triParSelection(int tab[]) {
        for (int i = 0; i < tab.length - 1; i++)  
          {
               int index = i;  
               for (int j = i + 1; j < tab.length; j++)
               {
                    if (tab[j] < tab[index]){ 
                         index = j;
                    }
               }
 
               int min = tab[index];
               tab[index] = tab[i]; 
               tab[i] = min;
          }
    }

    /**
     * Tri à bulle.
     *
     * @param tab le tableau à trier
     */
    static void triABulle(int tab[]) {
        int taille = tab.length;  
        int tmp = 0;  
        for(int i=0; i < taille; i++) 
        {
                for(int j=1; j < (taille-i); j++)
                {  
                        if(tab[j-1] > tab[j])
                        {
                                //echanges des elements
                                tmp = tab[j-1];  
                                tab[j-1] = tab[j];  
                                tab[j] = tmp;  
                        }
 
                }
        }
    }

    /**
     * Tri par comptage.
     *
     * @param tab le tableau à trier
     */
    static void triComptage(int[] tab) {
        // TODO
    }
    
    /**
     * Tri par insertion.
     *
     * @param tab le tableau à trier
     */
    static void triparinsertion(int[] tab) {
        int taille = tab.length;  
        
          for (int i = 1; i < taille; i++)
          { 
               int index = tab[i];  
               int j = i-1;  
            
               while(j >= 0 && tab[j] > index)  
               {
                    tab[j+1] = tab[j];  
                    j--;  
               }  
               tab[j+1] = index; 
        }  
    }
    
    public static void triFusion(int tableau[])
        {
        int longueur=tableau.length;
        if (longueur>0)
            {
            triFusion(tableau,0,longueur-1);
            }
        }

    static void triFusion(int tableau[],int deb,int fin)
        {
        if (deb!=fin)
            {
            int milieu=(fin+deb)/2;
            triFusion(tableau,deb,milieu);
            triFusion(tableau,milieu+1,fin);
            fusion(tableau,deb,milieu,fin);
            }
        }

    static void fusion(int tableau[],int deb1,int fin1,int fin2)
        {
        int deb2=fin1+1;

        //on recopie les éléments du début du tableau
        int table1[]=new int[fin1-deb1+1];
        for(int i=deb1;i<=fin1;i++)
            {
            table1[i-deb1]=tableau[i];
            }
        
        int compt1=deb1;
        int compt2=deb2;
        
        for(int i=deb1;i<=fin2;i++)
            {        
            if (compt1==deb2) //c'est que tous les éléments du premier tableau ont été utilisés
                {
                break; //tous les éléments ont donc été classés
                }
            else if (compt2==(fin2+1)) //c'est que tous les éléments du second tableau ont été utilisés
                {
                tableau[i]=table1[compt1-deb1]; //on ajoute les éléments restants du premier tableau
                compt1++;
                }
            else if (table1[compt1-deb1]<tableau[compt2])
                {
                tableau[i]=table1[compt1-deb1]; //on ajoute un élément du premier tableau
                compt1++;
                }
            else
                {
                tableau[i]=tableau[compt2]; //on ajoute un élément du second tableau
                compt2++;
                }
            }
        }
    
    
    static void échangerÉléments(int[] t, int m, int n) {
    int temp = t[m];

    t[m] = t[n];
    t[n] = temp;
  }

  static int partition(int[] t, int m, int n) {
    int v = t[m];                 // valeur pivot
    int i = m-1;
    int j = n+1;                  // indice final du pivot

    while (true) {
      do {
        j--;
      } while (t[j] > v);
      do {
        i++;
      } while (t[i] < v);
      if (i<j) {
        échangerÉléments(t, i, j);
      } else {
        return j;
      }
    }
  }

  static void triRapide(int[] t, int m, int n) {
    if (m<n) {
      int p = partition(t, m, n);
      triRapide(t, m, p);
      triRapide(t, p+1, n);
    }
  }
    
    /**
     * Tri par défaut de Java.
     *
     * @param tab tableau à trier
     */
    static void triJava(int[] tab) {
        Arrays.sort(tab);
    }
}
