/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package persistence;

/**
 *
 * @author cirstea
 */
import java.io.Serializable;

public class Person implements Serializable {
    
    private String firstName;
    private String lastName;
    private String nickName;

    public Person() {
    }

    public String getNickName() {
        return nickName;
    }

    public Person(String firstName, String lastName, String nickName) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.nickName = nickName;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }
}
