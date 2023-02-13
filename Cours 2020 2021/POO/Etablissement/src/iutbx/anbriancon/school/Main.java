
package iutbx.anbriancon.school;

/**
 *
 * @author annab
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws GroupRegistrationException {
        //test1();
        //test2();
        test3();
        testetd();
    }

    static void test1() throws GroupRegistrationException {
        School s = new School("BigSchool");
        s.registerGroup("S2A");
        s.registerGroup("S2B");
        s.registerGroup("S2C"); // oups
        for (Group get : s.allGroups()) {
            System.out.println(get.getName());
        }
    }

    public static void test2() {
        try {
            School s = new School("BigSchool");
            s.registerGroup("S2A");
            s.registerGroup("S2B");
            s.registerGroup("S2C"); // oups
            for (Group get : s.allGroups()) {
                System.out.println(get.getName());
            }

        } catch (GroupRegistrationException e) {
            System.out.println("Erreur enregistrement: " + e.getMessage());
        }
    }

    public static void test3() {

        School s = new School("BigSchool");
        addIfPossible(s, "S2B");
        addIfPossible(s, "S2A");
        addIfPossible(s, "S2B");
        System.out.println("Liste des groupes :");
        for (Group get : s.allGroups()) {
            System.out.println(get.getName());
        }

    }
    public static void testetd() {

        School s = new School("BigSchool");
        addIfPossible(s, "S2B");
        addIfPossible(s, "S2A");
        addIfPossible(s, "S2B");
        System.out.println("Liste des groupes :");
        for (Group get : s.allGroups()) {
            System.out.println(get.getName());
        }

    }

    public static void addIfPossible(School schoolName, String groupName) {
        try {
            boolean trouve = false;

            for (Group get : schoolName.allGroups()) {
                if (get.toString().equals(groupName)) {
                    trouve = true;
                }
            }
            if (!trouve) {
                schoolName.registerGroup(groupName);
            }
        } catch (GroupRegistrationException e) {
            System.out.println("Ajout impossible, le groupe: " + groupName + " existe déjà");
        }
    }
}
