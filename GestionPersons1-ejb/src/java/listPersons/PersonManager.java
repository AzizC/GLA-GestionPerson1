/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package listPersons;

import java.util.ArrayList;
import javax.ejb.Local;
import persistence.Person;

/**
 *
 * @author chafi4u
 */
@Local
public interface PersonManager {
 
    public void register(Person p);
    public ArrayList<Person> getAllPersons();
}
