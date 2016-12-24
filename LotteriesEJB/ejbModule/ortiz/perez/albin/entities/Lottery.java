package ortiz.perez.albin.entities;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.validation.constraints.Null;

/**
 * The persistent class for the lottery database table.
 * 
 */
@Entity(name = "Lottery")

public class Lottery implements Serializable {

    private static final long serialVersionUID = 1L;

    private String lottery_name;

    private String lot_desc;

    private List<Result> results;

    public Lottery() {
    }

    @Id
    // @GeneratedValue(strategy = GenerationType.AUTO, generator =
    // "lotterySequence") left to remember
    // @SequenceGenerator(name = "lotterySequence", sequenceName =
    // "LOTTERY_SEQ", schema = "apo") left to remember
    public String getLottery_name() {
	return lottery_name;
    }

    public void setLottery_name(String lottery_name) {
	this.lottery_name = lottery_name;
    }

    public String getLot_desc() {
	return lot_desc;
    }

    public void setLot_desc(String lot_desc) {
	this.lot_desc = lot_desc;
    }

    // bi-directional many-to-one association to Result
    @OneToMany(mappedBy = "lottery")
    public List<Result> getResults() {
	return this.results;
    }

    public void setResults(List<Result> results) {
	this.results = results;
    }

    public Result addResult(Result result) {
	getResults().add(result);
	result.setLottery(this);

	return result;
    }

    public Result removeResult(Result result) {
	getResults().remove(result);
	result.setLottery(null);

	return result;
    }

}