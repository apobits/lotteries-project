package ortiz.perez.albin.beans.stateless;

import java.text.SimpleDateFormat;
import java.util.Date;

import javax.annotation.Resource;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.ejb.TransactionManagement;
import javax.ejb.TransactionManagementType;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.transaction.SystemException;
import javax.transaction.UserTransaction;

/**
 * Session Bean implementation class Load
 */
@Stateless
@LocalBean
@TransactionManagement(TransactionManagementType.BEAN)
public class Load {

	@PersistenceContext(unitName = "LotteriesEJB")
	private EntityManager em;

	@Resource
	private UserTransaction userTransaction;

	/**
	 * Default constructor.
	 */
	public Load() {
		// TODO Auto-generated constructor stub
	}

	public void saveResults(byte[] results, String lottery) {
		boolean counterDate = true;
		int counter = 0;
		StringBuilder result = new StringBuilder();
		try {
			for (int i = 0; i < new String(results).length(); i++) {
				if (results[i] != 9 && results[i] != 45 && results[i] != 13 && results[i] != 10)
					result.append((char) results[i]);
				if (result.length() > 7) {
					Date date = new SimpleDateFormat("MM/dd/yy").parse(result.toString());
					char time = (char) 9;
					char firstDigit = (char) 9;
					char secondDigit = (char) 9;
					char thirdDigit = (char) 9;
					char fourthDigit = (char) 9;
					for (int j = i + 1; j < results.length; j++) {
						if (results[j] != 9 && results[j] != 45 && results[j] != 13 && results[j] != 10
								&& time == (char) 9) {
							time = (char) results[j];
						} else if (results[j] != 9 && results[j] != 45 && results[j] != 13 && results[j] != 10
								&& time != (char) 9 && firstDigit == (char) 9) {
							firstDigit = (char) results[j];
						} else if (results[j] != 9 && results[j] != 45 && results[j] != 13 && results[j] != 10
								&& time != (char) 9 && firstDigit != (char) 9 && secondDigit == (char) 9) {
							secondDigit = (char) results[j];
						} else if (results[j] != 9 && results[j] != 45 && results[j] != 13 && results[j] != 10
								&& time != (char) 9 && firstDigit != (char) 9 && secondDigit != (char) 9
								&& thirdDigit == (char) 9) {
							thirdDigit = (char) results[j];
						} else if (results[j] != 9 && results[j] != 45 && results[j] != 13 && results[j] != 10
								&& time != (char) 9 && firstDigit != (char) 9 && secondDigit != (char) 9
								&& thirdDigit != (char) 9 && fourthDigit == (char) 9) {
							fourthDigit = (char) results[j];
							String number = new StringBuilder().append(firstDigit).append(secondDigit)
									.append(thirdDigit).append(fourthDigit).toString();
							saveResult(date, number, lottery, String.valueOf(time));
							i = j;
							result.delete(0, result.length());
							break;
						}
					}

				}
			}
		} catch (Exception e) {
			System.out.println(e);
		}
	}

	private void saveResult(Date date, String number, String lottery, String time) {
		if (lottery.equals("play4") && time.equals("E"))
			persistResult(date, number, "play4E");
		else if (lottery.equals("play4") && time.equals("M")) {
			persistResult(date, number, "play4M");
		}
	}

	private void persistResult(Date date, String number, String lottery) {
		try {
			userTransaction.begin();
			Query query = em.createNativeQuery(
					"insert into apo.result(result_date, result_number, result_lot_name) values(?,?,?)");
			query.setParameter(1, date);
			query.setParameter(2, number);
			query.setParameter(3, lottery);
			query.executeUpdate();
			userTransaction.commit();
		} catch (Exception e) {
			System.out.println(e);
			try {
				userTransaction.rollback();
			} catch (IllegalStateException | SecurityException | SystemException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}
	}

}
