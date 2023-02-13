package iutbx.anbriancon.school;

import java.util.Collection;
import java.util.Map;
import java.util.TreeMap;

/**
 *
 * @author annab
 */
public class School {

    final String schoolName;

    // Groupes, indexés par leur nom
    final Map<String, Group> groups = new TreeMap<>();

    public School(String schoolName) {
        this.schoolName = schoolName;
    }

    public String getSchoolName() {
        return schoolName;
    }

    /**
     * Crée et enregistre un nouveau groupe
     *
     * @param groupName nom du groupe
     * @return le groupe
     */
    public Group registerGroup(String groupName) throws GroupRegistrationException {
        Group g = new Group(groupName);
        groups.put(groupName, g);
        if (groups.containsKey(groupName)) {
            throw new GroupRegistrationException(
                    "Group " + groupName + " already present");
        }

        return g;
    }

    /**
     * Retourne les groupes enregistrés.
     *
     * @return une collection
     */
    public Collection<Group> allGroups() {
        return groups.values();
    }

    /**
     * Cherche un groupe par son nom.
     *
     * @param le nom du groupe cherché
     * @return le groupe si présent, null si absent.
     */
    public Group groupByName(String name) {
        return groups.get(name);
    }
}
