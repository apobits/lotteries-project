package ortiz.perez.albin.interceptor;

import javax.interceptor.AroundInvoke;
import javax.interceptor.Interceptor;
import javax.interceptor.InvocationContext;

@Interceptor
public class Interceptor1 {
    @AroundInvoke
    public Object log(InvocationContext ic){
	System.out.println("Interceptor 1 "+ic.getParameters()[0]);
	try {
	    return ic.proceed();
	} catch (Exception e) {
	    // TODO Auto-generated catch block
	    e.printStackTrace();
	}
	return null;
    }

}
