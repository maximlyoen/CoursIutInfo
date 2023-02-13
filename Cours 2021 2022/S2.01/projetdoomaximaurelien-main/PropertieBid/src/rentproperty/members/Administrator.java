/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package rentproperty.members;

import java.util.HashMap;
import rentproperty.app.PropertyApp;

/**
 *
 * @author mlevecq
 */
public class Administrator extends Member{
    
    String type = "Administrator";
    HashMap<String,Member> administratorMembers;
    
    public Administrator(String name, String surname, String nickname, String email, String type) {
        super(name, surname, nickname, email, type);
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

    public void addAdministratorMember(String name, String surname, String nickname, String email) {
        if (administratorMembers.get(name)!=null) return;
        Member mb = new Member(name,surname,nickname,email,type);
        administratorMembers.put(name,mb);
    }

    @Override
    public String toString() {
        return "Administrateur{" + "Name=" + name + "surname=" + surname + "nickname=" + nickname + "email=" + email + "type=" + type + '}';
    }
    
    public void deleteAccount(String acount){
        
    }
    
    public void litOfAllUser(){
        
    }
    
    public void createAdminAcount(){
        
    }
    
}
