/**
 * 
 */
package ortiz.perez.albin.managedbeans;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.ejb.EJB;
import javax.enterprise.context.ApplicationScoped;
import javax.faces.bean.ManagedBean;

import ortiz.perez.albin.beans.stateless.ResultBean;
import ortiz.perez.albin.dtos.ResultDTO;
import ortiz.perez.albin.entities.Result;

/**
 * @author Albin
 * 
 */
@ManagedBean
@ApplicationScoped
public class StatisticalMB implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@EJB
	ResultBean resultBean;

	private String lotteryName;

	private List<ResultDTO> numberRepetition;

	private List<ResultDTO> numberFrequencyRepetition;

	private List<Result> results = new ArrayList<Result>();

	private Integer page;

	private List<ResultDTO> numbersToPlay;

	public StatisticalMB() {
	}

	public void obtainNumbersRepetition() {
		numberRepetition = resultBean.obtainCountNumbersRepetition(lotteryName);
		// RequestContext rc = RequestContext.getCurrentInstance();
		// rc.update("reps:table");
		// numberFrequencyRepetition = resultBean
		// .obtainFrequencytRepetitionNumbers(lotteryName);
	}

	public void obtainFrequencyNumbersRepetition() {
		numberFrequencyRepetition = resultBean.obtainFrequencyNumbersRepetition(lotteryName);
	}

	/**
	 * @return the numberRepetition
	 */
	public List<ResultDTO> getNumberRepetition() {
		return numberRepetition;
	}

	/**
	 * @param numberRepetition
	 *            the numberRepetition to set
	 */
	public void setNumberRepetition(List<ResultDTO> numberRepetition) {
		this.numberRepetition = numberRepetition;
	}

	/**
	 * @return the results
	 */
	public List<Result> getResults() {
		return results;
	}

	/**
	 * @param results
	 *            the results to set
	 */
	public void setResults(List<Result> results) {
		this.results = results;
	}

	public void getResultsList() {
		results = resultBean.getResultsList(lotteryName);
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
	 * @return the page
	 */
	public Integer getPage() {
		return page;
	}

	/**
	 * @param page
	 *            the page to set
	 */
	public void setPage(Integer page) {
		this.page = page;
	}

	/**
	 * @return the numberFrequencyRepetition
	 */
	public List<ResultDTO> getNumberFrequencyRepetition() {
		return numberFrequencyRepetition;
	}

	/**
	 * @param numberFrequencyRepetition
	 *            the numberFrequencyRepetition to set
	 */
	public void setNumberFrequencyRepetition(List<ResultDTO> numberFrequencyRepetition) {
		this.numberFrequencyRepetition = numberFrequencyRepetition;
	}

	// public void obtainNumbersToPlay() {
	// numbersToPlay = resultBean.getNumbersToPlay(lotteryName);
	// }

	/**
	 * @return the numbersToPlay
	 */
	public List<ResultDTO> getNumbersToPlay() {
		return numbersToPlay;
	}

	/**
	 * @param numbersToPlay
	 *            the numbersToPlay to set
	 */
	public void setNumbersToPlay(List<ResultDTO> numbersToPlay) {
		this.numbersToPlay = numbersToPlay;
	}

	public ResultDTO getResultDTO() {
		return resultBean.getNumbersRepetition(resultBean.getResultsList(lotteryName));
	}

	public void processNumbersToPlay() {
		numbersToPlay = resultBean.getNumbersDelayed(lotteryName);
	}

}
