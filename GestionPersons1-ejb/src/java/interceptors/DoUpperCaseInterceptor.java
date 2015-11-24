/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package interceptors;

import interceptors.DoUpperCaseInterceptor.DoUpper;
import static java.lang.annotation.ElementType.METHOD;
import static java.lang.annotation.ElementType.TYPE;
import java.lang.annotation.Retention;
import static java.lang.annotation.RetentionPolicy.RUNTIME;
import java.lang.annotation.Target;
import javax.interceptor.AroundInvoke;
import javax.interceptor.Interceptor;
import javax.interceptor.InterceptorBinding;
import javax.interceptor.InvocationContext;
import persistence.Person;

/**
 *
 * @author aziz
 */
@DoUpper
@Interceptor
public class DoUpperCaseInterceptor {
    
    @InterceptorBinding
    @Target({TYPE, METHOD})
    @Retention(RUNTIME)
    public @interface DoUpper {}
    
    @AroundInvoke
    public Object doUpperCase(InvocationContext ic) throws Exception {      
        Person p = (Person) ic.getParameters()[0];
        String language = p.getLanguage();
        if(!language.matches("[A-Z]+")){
            p.setLanguage(language.toUpperCase());
        }
        return ic.proceed(); 
    } 
}
