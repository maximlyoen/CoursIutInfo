/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package rentproperty.members;

import java.util.ArrayList;

/**
 *
 * @author mlevecq
 */
public class Member {
    String name; 
    String surname; 
    String nickname;
    String email; 
    String type;

    ArrayList<Member> allMember = new ArrayList<>();

    public Member(String name, String surname, String nickname, String email ,String type) {
        this.name = name;
        this.surname = surname;
        this.nickname = nickname;
        this.email = email;
        this.type = type;
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

    @Override
    public String toString() {
        return "Owner{" + "Name=" + name + "surname=" + surname + "nickname=" + nickname + "email=" + email + "type=" + type + '}';
    }
    
    
}
