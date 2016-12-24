package ortiz.perez.albin.entities;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

/**
 * The persistent class for the results database table.
 * 
 */
@Entity(name = "RESULT")
// @NamedQuery(name = "Result.findAll", query = "SELECT r FROM Result r")
public class Result implements Serializable {
    private static final long serialVersionUID = 1L;
    private ResultPK id;
    private String resultNumber;
    private Lottery lottery;

    public Result() {
    }

    @EmbeddedId
    public ResultPK getId() {
	return this.id;
    }

    public void setId(ResultPK id) {
	this.id = id;
    }

    @Column(name = "RESULT_NUMBER")
    public String getDrawNumber() {
	return this.resultNumber;
    }

    public void setDrawNumber(String drawNumber) {
	this.resultNumber = drawNumber;
    }

    // bi-directional many-to-one association to Lottery
    @ManyToOne
    @JoinColumn(name = "RESULT_LOT_NAME", insertable = false, updatable = false)
    public Lottery getLottery() {
	return this.lottery;
    }

    public void setLottery(Lottery lottery) {
	this.lottery = lottery;
    }

}