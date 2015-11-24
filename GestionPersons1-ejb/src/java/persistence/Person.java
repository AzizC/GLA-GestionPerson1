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
    private String language;

    public Person() {
    }

    public String getNickName() {
        return nickName;
    }

    public Person(String firstName, String lastName, String nickName, String language) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.nickName = nickName;
        this.language = language;
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

    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        this.language = language;
    }
}
