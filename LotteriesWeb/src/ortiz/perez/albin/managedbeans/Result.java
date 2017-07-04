/**
 * 
 */
package ortiz.perez.albin.managedbeans;

import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.context.FacesContext;

import org.primefaces.model.UploadedFile;

import ortiz.perez.albin.beans.stateless.Load;

/**
 * @author Administrador
 *
 */
@ManagedBean
public class Result {

	@EJB
	private Load load;

	private UploadedFile results;

	private String lottery;

	/**
	 * @return the results
	 */
	public UploadedFile getResults() {
		return results;
	}

	/**
	 * @param results
	 *            the results to set
	 */
	public void setResults(UploadedFile results) {
		this.results = results;
	}

	public void upload() {
		if (results != null) {
			load.saveResults(results.getContents(), lottery);
			FacesMessage message = new FacesMessage("Successful", results.getFileName() + " uploaded");
			FacesContext.getCurrentInstance().addMessage(null, message);
		}
	}

	/**
	 * @return the lottery
	 */
	public String getLottery() {
		return lottery;
	}

	/**
	 * @param lottery
	 *            the lottery to set
	 */
	public void setLottery(String lottery) {
		this.lottery = lottery;
	}

}
