/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package interceptors;

import java.util.Date;
import javax.interceptor.AroundInvoke;
import javax.interceptor.InvocationContext;

/**
 *
 * @author chafi4u
 */
public class ApplicationLogger {
    
    @AroundInvoke
    public Object logMethodCall(InvocationContext ic) throws Exception {
        Date d = new Date();
        System.out.println("LOG: method "+ ic.getMethod().getName()+" in class "+ic.getTarget()
        +"\n called "+d.toString());
        return ic.proceed();        
    } 
}
