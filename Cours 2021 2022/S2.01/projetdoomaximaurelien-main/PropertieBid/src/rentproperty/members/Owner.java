/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package rentproperty.members;

import java.util.ArrayList;
import java.util.HashMap;
import rentproperty.property.Genre;

/**
 *
 * @author mlevecq
 */
public class Owner extends Member{
    int wallet;
    String type = "Owner";
    HashMap<String,Member> ownerMembers;
    //Rajouter liste des propriétés.
    ArrayList<Genre> Portfolio; 
    public Owner(int wallet, String name, String surname, String nickname, String email , String type) {
        super(name, surname, nickname, email, type);
        this.wallet = wallet;
    }

    public int getWallet() {
        return wallet;
    }
    public String getName() {
        return name;
    }
    public String getSurname() {
        return surname;
    }
    public String getNickname() {
        return nickname;
    }
    public String getEmail() {
        return email;
    }
    public String getType() {
        return type;
    }

    public void addOwnerMember(String name, String surname, String nickname, String email) {
        if (ownerMembers.get(name)!=null) return;
        Member mb = new Member(name,surname,nickname,email,type);
        ownerMembers.put(name,mb);
    }

    @Override
    public String toString() {
        return "Owner{" + "wallet=" + wallet + "Name=" + name + "surname=" + surname + "nickname=" + nickname + "email=" + email + "type=" + type + '}';
    }
  
    public void propertyForRental(){
        
    }
    
    public void addProperty(){
        
    }
}
