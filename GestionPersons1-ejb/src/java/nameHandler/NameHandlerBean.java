/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package nameHandler;

import interceptors.DoUpperCaseInterceptor.DoUpper;
import interceptors.ProfilingInterceptor.Profile;
import interceptors.UpperCaseVerificationInterceptor.VerifUpper;
import javax.ejb.Stateless;

/**
 *
 * @author chafi4u
 */
@Profile
@Stateless
public class NameHandlerBean implements NameHandler {

    // Add business logic below. (Right-click in editor and choose
    // "Insert Code > Add Business Method")
    
    @Override
    public String generateId(String userName){
        int lower = 0;
        int higher = 1000;
        int random = (int)(Math.random() * (higher-lower)) + lower;
        return userName+""+random;
    }
    
    @VerifUpper
    @Override
    public String greetingsMessage(String userName, String id, String language){
        return "Bonjour "+userName+" ("+id+")"+" ! (Language = "+language+" )";
    }
}
