/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package rentproperty.property;
import java.util.ArrayList;
import java.util.HashMap;
import rentproperty.loans.LoansAccess;
import rentproperty.members.MemberAccess;

/**
 *
 * @author mlevecq
 */
public class PropertyAccess {
    private LoansAccess lAccess;
    private MemberAccess mAccess;
    HashMap<String,PropertyBid> allPropertyBid;

    public PropertyAccess() {
        allPropertyBid = new HashMap<>();
    }

    public void setLoanAccess(LoansAccess lAccess) {
        this.lAccess = lAccess;
    }

    public void setMemberAccess(MemberAccess mAccess) {
        this.mAccess = mAccess;
    }

    public PropertyBid getPropertyBid(String name){
        return allPropertyBid.get(name);
    }

    public void addMember(Genre genre, String name, String adresse, String hidden , String city, String description, int maxOccupiers, int price) {
        if (allPropertyBid.get(name)!=null) return;
        PropertyBid mb = new PropertyBid(genre, name, adresse, hidden, city, description, maxOccupiers, price);
        allPropertyBid.put(name,mb);
    }



    public ArrayList<String> getAllMembers() {
        return new ArrayList(allPropertyBid.keySet());
    }
}
