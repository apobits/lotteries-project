/**
 * 
 */
package ortiz.perez.albin.managedbeans;

import javax.faces.bean.ManagedBean;
import javax.faces.context.FacesContext;

/**
 * @author Administrador
 *
 */
@ManagedBean
public class Home {

	private String test;

	public String manageLotteries() {
		FacesContext.getCurrentInstance().getExternalContext().getFlash().put("test", test);
		return "LotteryCRUD";
	}

	/**
	 * @return the test
	 */
	public String getTest() {
		return test;
	}

	/**
	 * @param test
	 *            the test to set
	 */
	public void setTest(String test) {
		this.test = test;
	}
}
