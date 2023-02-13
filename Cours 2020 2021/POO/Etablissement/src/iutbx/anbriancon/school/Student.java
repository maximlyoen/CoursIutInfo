package iutbx.anbriancon.school;

import java.util.Map;
import java.util.TreeMap;

/**
 *
 * @author annab
 */
public class Student {

    final Map<String, Group> etd = new TreeMap<>();
    public Student(Person personne, Group groupe){
    // super(this);
    }

    /**
     * Enregistre un étudiant et l'affecte à un groupe.
     *
     * @param firstName
     * @param lastName
     * @param group
     * @throws StudentRegistrationException si déjà dans un groupe
     */
    public Person registerStudent(String firstName,String lastName, String group) throws GroupRegistrationException {
        Person e = new Person(firstName, lastName);
        etd.put(firstName, e);
        if (etd.containsKey(firstName)) {
            throw new GroupRegistrationException(
                    "Group " + firstName+lastName + " already present");
        }

        return e;
    }
}
