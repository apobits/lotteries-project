/**
 * 
 */
package ortiz.perez.albin.beans.stateless;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.EJB;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import ortiz.perez.albin.entities.Result;

/**
 * @author Administrador
 *
 */
@Stateless
@LocalBean
public class ResultUtil {

	@PersistenceContext(unitName = "LotteriesEJB")
	private EntityManager entityManager;

	@EJB
	ResultBean resultBean;

	public List<Integer> getFrequencyRepetition() {
		List<Result> results = resultBean.getResultsList("play4E");
		List<Integer> frequency = new ArrayList<>();
		int count[] = new int[10];
		int i = 0;
		results.forEach(t -> {
			if (t.getDrawNumber().charAt(3) == '3') {
				frequency.add(count[2]);
				count[2] = -1;
			}
			incrementOne(count);
		});
		return null;
	}

	private void incrementOne(int count[]) {
		for (int i = 0; i < count.length; i++) {
			count[i] += 1;
		}
	}

}
