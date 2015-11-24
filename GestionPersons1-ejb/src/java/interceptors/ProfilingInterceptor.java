/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package interceptors;

import interceptors.ProfilingInterceptor.Profile;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;
import static java.lang.annotation.ElementType.METHOD;
import static java.lang.annotation.ElementType.TYPE;
import static java.lang.annotation.RetentionPolicy.RUNTIME;
import javax.interceptor.AroundInvoke;
import javax.interceptor.Interceptor;
import javax.interceptor.InterceptorBinding;
import javax.interceptor.InvocationContext;

/**
 *
 * @author chafi4u
 */
@Profile
@Interceptor
public class ProfilingInterceptor {
    
    @InterceptorBinding
    @Target({TYPE, METHOD})
    @Retention(RUNTIME)
    public @interface Profile {}
    
    @AroundInvoke
    public Object profileMethodCall(InvocationContext ic) throws Exception {

        double startTime = 0;
        
        try {
            startTime = System.currentTimeMillis();  
            return ic.proceed();    
        } finally {
            
            double finTime = System.currentTimeMillis();
            double totalTime = (double) ((finTime - startTime)); 
            System.out.println("PROFILING: method "+ ic.getMethod().getName()+" from "+ic.getTarget()
            +"\n executed in "+totalTime+" ms");
        }    
    } 
}
