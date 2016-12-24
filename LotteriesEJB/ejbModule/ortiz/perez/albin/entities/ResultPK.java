package ortiz.perez.albin.entities;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * The primary key class for the results database table.
 * 
 */
@Embeddable
public class ResultPK implements Serializable {
    // default serial version id, required for serializable classes.
    private static final long serialVersionUID = 1L;
    private java.util.Date drawDate;
    private String lotteryName;

    public ResultPK() {
    }

    @Temporal(TemporalType.DATE)
    @Column(name = "RESULT_DATE")
    public java.util.Date getDrawDate() {
	return this.drawDate;
    }

    public void setDrawDate(java.util.Date drawDate) {
	this.drawDate = drawDate;
    }

    @Column(name = "RESULT_LOT_NAME")
    public String getLotteryName() {
	return this.lotteryName;
    }

    public void setLotteryName(String lotteryName) {
	this.lotteryName = lotteryName;
    }

    public boolean equals(Object other) {
	if (this == other) {
	    return true;
	}
	if (!(other instanceof ResultPK)) {
	    return false;
	}
	ResultPK castOther = (ResultPK) other;
	return this.drawDate.equals(castOther.drawDate) && this.lotteryName.equals(castOther.lotteryName);
    }

    public int hashCode() {
	final int prime = 31;
	int hash = 17;
	hash = hash * prime + this.drawDate.hashCode();
	hash = hash * prime + this.lotteryName.hashCode();

	return hash;
    }
}