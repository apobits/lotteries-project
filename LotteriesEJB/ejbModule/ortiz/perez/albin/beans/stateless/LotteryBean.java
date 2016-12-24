package ortiz.perez.albin.beans.stateless;

import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import ortiz.perez.albin.entities.Lottery;

/**
 * Session Bean implementation class LotteryBean
 */
@Stateless
@LocalBean
// @Interceptors(Interceptor1.class)
public class LotteryBean {

    @PersistenceContext(unitName = "LotteriesEJB")
    private EntityManager entityManager;

    /**
     * Default constructor.
     */
    public LotteryBean() {
	// TODO Auto-generated constructor stub
    }

    public String saveLottery(String lotteryName) {
	if (entityManager.find(Lottery.class, lotteryName) == null) {
	    Lottery lottery = new Lottery();
	    lottery.setLottery_name(lotteryName);
	    entityManager.persist(lottery);
	    return "Lottery " + lotteryName + " has been saved successfully";
	} else {
	    return "Lottery " + lotteryName + " exists already";
	}
    }

    @SuppressWarnings("unchecked")
    public List<Lottery> getLotteries() {
	List<Lottery> lotteries = (List<Lottery>) entityManager.createQuery("SELECT l FROM Lottery l").getResultList();
	return lotteries;
    }

}
