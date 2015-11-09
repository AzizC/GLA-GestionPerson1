/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package singletons;

import javax.ejb.Local;
import persistence.Person;

/**
 *
 * @author aziz
 */
@Local
public interface StartupSingleton {
    
    public void selectRandomWinner();
    public Person getWinner();
}
