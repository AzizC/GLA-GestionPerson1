/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package nameHandler;

import javax.ejb.Local;

/**
 *
 * @author chafi4u
 */
@Local
public interface NameHandler {
    
    public String generateId(String userName);
    public String greetingsMessage(String userName, String id, String language);
}
