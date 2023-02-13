/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package rentproperty.members;

import java.util.HashMap;

/**
 *
 * @author mlevecq
 */
public class Tenant extends Member{
    int wallet; 
 
    String type = "Tenant";
    HashMap<String,Member> tenantMembers;

    public Tenant(int wallet, String name, String surname, String nickname, String email, String type) {
        super(name, surname, nickname, email , type);
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

    public void addTenantMember(String name, String surname, String nickname, String email) {
        if (tenantMembers.get(name)!=null) return;
        Member mb = new Member(name,surname,nickname,email,type);
        tenantMembers.put(name,mb);
    }

    @Override
    public String toString() {
        return "Tenant{" + "wallet=" + wallet + "Name=" + name + "surname=" + surname + "nickname=" + nickname + "email=" + email + "type=" + type + '}';
    }
 
    public void rentProperty(){
        
    }
}
