/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package singletons;

import java.util.ArrayList;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.ejb.Singleton;
import javax.ejb.LocalBean;
import javax.ejb.Schedule;
import javax.ejb.Startup;
import listPersons.PersonManager;
import persistence.Person;

/**
 *
 * @author chafi4u
 */
@Startup
@Singleton
@LocalBean
public class StartupSingletonBean implements StartupSingleton {

    // Add business logic below. (Right-click in editor and choose
    // "Insert Code > Add Business Method")
    
    @EJB 
    private PersonManager personManager;
    
    private Person winner;
    
    @PostConstruct
    private void registerUsers(){
        personManager.register(new Person("Aziz", "Chafi", "Chafi1", "FR"));
        personManager.register(new Person("Nicolas", "Jukic", "Jukic1", "FR"));
        personManager.register(new Person("Bachir", "Arif", "Arif1", "FR"));
        personManager.register(new Person("Amine", "ElGzouli", "ElGzouli1", "FR"));
        selectRandomWinner();
    }
    
    @Override
   // @Schedule(hour="23")
    public void selectRandomWinner(){
        ArrayList<Person> alp = personManager.getAllPersons();
        int num = (int) (Math.random() * alp.size()); 
        winner = alp.get(num);
    }
    
    @Override
    public Person getWinner(){
        return winner;
    }
}

