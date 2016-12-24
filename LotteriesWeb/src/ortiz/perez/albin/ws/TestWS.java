/**
 * 
 */
package ortiz.perez.albin.ws;

import javax.jws.WebService;

/**
 * @author aposo
 *
 */
@WebService
public class TestWS {
    
    public void write(String text){
	System.out.println(text);
    }

}
