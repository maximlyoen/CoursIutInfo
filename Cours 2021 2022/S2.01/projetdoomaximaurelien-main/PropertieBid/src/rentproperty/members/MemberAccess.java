/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package rentproperty.members;
import java.util.ArrayList;
import java.util.HashMap;
import rentproperty.loans.LoansAccess;
import rentproperty.property.PropertyAccess;
/**
 *
 * @author mlevecq
 */
public class MemberAccess {
    private LoansAccess lAccess;
    private PropertyAccess pAccess;
    HashMap<String,Member> allMembers;

    public MemberAccess(PropertyAccess pAccess) {
        allMembers = new HashMap<>();
        this.pAccess = pAccess;
        pAccess.setMemberAccess(this);
    }

    public void setLoanAccess(LoansAccess lAccess) {
        this.lAccess = lAccess;
    }

    public Member getMumber(String name){
        return allMembers.get(name);
    }

    public void addMember(String name, String surname, String nickname, String email, String type) {
        if (allMembers.get(name)!=null) return;
        Member mb = new Member(name,surname,nickname,email,type);
        allMembers.put(name,mb);
    }

    public ArrayList<String> getAllMembers() {
        return new ArrayList(allMembers.keySet());
    }
}
