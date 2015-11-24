/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package interceptors;

import interceptors.ProfilingInterceptor.Profile;
import interceptors.UpperCaseVerificationInterceptor.VerifUpper;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;
import static java.lang.annotation.ElementType.METHOD;
import static java.lang.annotation.ElementType.TYPE;
import static java.lang.annotation.RetentionPolicy.RUNTIME;
import javax.interceptor.InterceptorBinding;
import javax.interceptor.AroundInvoke;
import javax.interceptor.Interceptor;
import javax.interceptor.InvocationContext;
import persistence.Person;

/**
 *
 * @author chafi4u
 */
@VerifUpper
@Interceptor
public class UpperCaseVerificationInterceptor {
    
    @InterceptorBinding
    @Target({TYPE, METHOD})
    @Retention(RUNTIME)
    @Profile
    public @interface VerifUpper {}
    
    @AroundInvoke
    public Object upperCaseVerif(InvocationContext ic) throws Exception {
        Object[] params = ic.getParameters();
        String language = (String) params[2];
        if(!language.matches("[A-Z]+")){
            System.out.println("CAPITALIZE: Oups, parameters of "+ic.getTarget()+" are not in capitals !!!");
        }
        return ic.proceed();        
    } 
}
