/**
 * 
 */
package ortiz.perez.albin.managedbeans;

import java.util.Date;
import java.util.List;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.context.FacesContext;

import org.primefaces.context.RequestContext;

import ortiz.perez.albin.beans.stateless.LotteryBean;
import ortiz.perez.albin.beans.stateless.ResultBean;
import ortiz.perez.albin.entities.Lottery;

/**
 * @author Albin
 * 
 */
@ManagedBean
public class LotteryMB {
    @EJB
    LotteryBean lotteryBean;

    @EJB
    ResultBean resultBean;

    private Date date;

    private String lotteryName;

    private String saveLotteryStatus;

    private String resultNumber;

    private String saveResultStatus;

    private Lottery lottery;

    FacesContext facesContext;

    public LotteryMB() {
	lottery = new Lottery();
    }

    /**
     * @return the date
     */
    public Date getDate() {
	return date;
    }

    /**
     * @param date
     *            the date to set
     */
    public void setDate(Date date) {
	this.date = date;
    }

    /**
     * @return the lotteryName
     */
    public String getLotteryName() {
	return lotteryName;
    }

    /**
     * @param lotteryName
     *            the lotteryName to set
     */
    public void setLotteryName(String lotteryName) {
	this.lotteryName = lotteryName;
    }

    /**
     * @return the saveLotteryStatus
     */
    public String getSaveLotteryStatus() {
	return saveLotteryStatus;
    }

    /**
     * @param saveLotteryStatus
     *            the saveLotteryStatus to set
     */
    public void setSaveLotteryStatus(String saveLotteryStatus) {
	this.saveLotteryStatus = saveLotteryStatus;
    }

    /**
     * @return the resultNumber
     */
    public String getResultNumber() {
	return resultNumber;
    }

    /**
     * @param resultNumber
     *            the resultNumber to set
     */
    public void setResultNumber(String resultNumber) {
	this.resultNumber = resultNumber;
    }

    /**
     * @return the saveResultStatus
     */
    public String getSaveResultStatus() {
	return saveResultStatus;
    }

    /**
     * @param saveResultStatus
     *            the saveResultStatus to set
     */
    public void setSaveResultStatus(String saveResultStatus) {
	this.saveResultStatus = saveResultStatus;
    }

    public void saveLotteryM() {
	saveLotteryStatus = lotteryBean.saveLottery(lotteryName);
	RequestContext rc = RequestContext.getCurrentInstance();
	rc.update("Lottery:lotteryStatus");
	rc.execute("PF('lotStatus').show()");
    }

    public void saveResultM() throws Exception {
	saveResultStatus = resultBean.saveResult(resultNumber, lotteryName, date);
	RequestContext rc = RequestContext.getCurrentInstance();
	rc.update("Result:resultStatus");
	rc.execute("PF('res').show()");

    }

    public List<Lottery> getLotteries() {
	return lotteryBean.getLotteries();
    }

    public Lottery getLottery() {
	return lottery;
    }

    public void setLottery(Lottery lottery) {
	this.lottery = lottery;
    }
}
