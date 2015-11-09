/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package registration;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import listPersons.PersonManager;
import nameHandler.NameHandler;
import persistence.Person;

/**
 *
 * @author chafi4u
 */
@ManagedBean
@RequestScoped
public class RegistrationBean {
    
    private String firstname, lastname, nickname, language;
    
    @EJB
    private NameHandler nameHandlerBean;
    @EJB
    private PersonManager personManager;
    
    /**
     * Creates a new instance of RegistrationBean
     */
    public RegistrationBean() {
        
    }
    
    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        this.language = language;
    }
    
    public String registerUser(){
           
        if(nickname == null || nickname.replaceAll(" ", "").isEmpty()){
            
            nickname = nameHandlerBean.generateId(lastname);
        }
        
        personManager.register(new Person(firstname, lastname, nickname));
        
        return "registrationOK";
    }
    
    public String registeredUser(){
         return nameHandlerBean.greetingsMessage(lastname, nickname);
    }
}
