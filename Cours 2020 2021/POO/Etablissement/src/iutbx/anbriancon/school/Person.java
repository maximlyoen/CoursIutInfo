
package iutbx.anbriancon.school;

/**
 *
 * @author annab
 */
public class Person {

    final String nom;
    final String prenom;

    Person(String nom, String prenom) {
        this.nom = nom;
        this.prenom = prenom;
    }

    
    public String getNom(){
        return this.nom;
    }
    public String getPrenom(){
        return this.prenom;
    }
}
