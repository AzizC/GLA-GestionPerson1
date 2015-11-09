package persons;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import java.util.ArrayList;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import listPersons.PersonManager;
import persistence.Person;
import singletons.StartupSingleton;

/**
 *
 * @author chafi4u
 */
@ManagedBean
@RequestScoped
public class PersonsBean {

    @EJB
    private PersonManager personManager;
    
    @EJB
    private StartupSingleton singleton;
    
    /**
     * Creates a new instance of PersonsBean
     */
    public PersonsBean() {
        
    }
    
    public ArrayList<Person> allPersons(){
        return personManager.getAllPersons();
    }
    
    public String selectRandomWinner(){
        singleton.selectRandomWinner();
        return "/listpersons";
    }
    
    public Person getWinner(){
        return singleton.getWinner();
    }
}
