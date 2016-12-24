/**
 * 
 */
package ortiz.perez.albin.dtos;

/**
 * @author Albin
 * 
 */
public class ResultDTO {

    private String position;

    private Integer number0;

    private Integer number1;

    private Integer number2;

    private Integer number3;

    private Integer number4;

    private Integer number5;

    private Integer number6;

    private Integer number7;

    private Integer number8;

    private Integer number9;

    public ResultDTO() {
	number0 = 0;
	number1 = 0;
	number2 = 0;
	number3 = 0;
	number4 = 0;
	number5 = 0;
	number6 = 0;
	number7 = 0;
	number8 = 0;
	number9 = 0;
    }

    /**
     * @return the position
     */
    public String getPosition() {
	return position;
    }

    /**
     * @param position
     *            the position to set
     */
    public void setPosition(String position) {
	this.position = position;
    }

    /**
     * @return the number0
     */
    public Integer getNumber0() {
	return number0;
    }

    /**
     * @param number0
     *            the number0 to set
     */
    public void setNumber0(Integer number0) {
	this.number0 = number0;
    }

    /**
     * @return the number1
     */
    public Integer getNumber1() {
	return number1;
    }

    /**
     * @param number1
     *            the number1 to set
     */
    public void setNumber1(Integer number1) {
	this.number1 = number1;
    }

    /**
     * @return the number2
     */
    public Integer getNumber2() {
	return number2;
    }

    /**
     * @param number2
     *            the number2 to set
     */
    public void setNumber2(Integer number2) {
	this.number2 = number2;
    }

    /**
     * @return the number3
     */
    public Integer getNumber3() {
	return number3;
    }

    /**
     * @param number3
     *            the number3 to set
     */
    public void setNumber3(Integer number3) {
	this.number3 = number3;
    }

    /**
     * @return the number4
     */
    public Integer getNumber4() {
	return number4;
    }

    /**
     * @param number4
     *            the number4 to set
     */
    public void setNumber4(Integer number4) {
	this.number4 = number4;
    }

    /**
     * @return the number5
     */
    public Integer getNumber5() {
	return number5;
    }

    /**
     * @param number5
     *            the number5 to set
     */
    public void setNumber5(Integer number5) {
	this.number5 = number5;
    }

    /**
     * @return the number6
     */
    public Integer getNumber6() {
	return number6;
    }

    /**
     * @param number6
     *            the number6 to set
     */
    public void setNumber6(Integer number6) {
	this.number6 = number6;
    }

    /**
     * @return the number7
     */
    public Integer getNumber7() {
	return number7;
    }

    /**
     * @param number7
     *            the number7 to set
     */
    public void setNumber7(Integer number7) {
	this.number7 = number7;
    }

    /**
     * @return the number8
     */
    public Integer getNumber8() {
	return number8;
    }

    /**
     * @param number8
     *            the number8 to set
     */
    public void setNumber8(Integer number8) {
	this.number8 = number8;
    }

    /**
     * @return the number9
     */
    public Integer getNumber9() {
	return number9;
    }

    /**
     * @param number9
     *            the number9 to set
     */
    public void setNumber9(Integer number9) {
	this.number9 = number9;
    }

    public Integer getNumber(int number) {
	switch (number) {
	case 0:
	    return getNumber0();
	case 1:
	    return getNumber1();
	case 2:
	    return getNumber2();
	case 3:
	    return getNumber3();
	case 4:
	    return getNumber4();
	case 5:
	    return getNumber5();
	case 6:
	    return getNumber6();
	case 7:
	    return getNumber7();
	case 8:
	    return getNumber8();
	case 9:
	    return getNumber9();
	default:
	    return getNumber0();
	}
    }

    public void setNumber(int number) {
	switch (number) {
	case 0:
	    setNumber0(number);
	    break;
	case 1:
	    setNumber1(number);
	    break;
	case 2:
	    setNumber2(number);
	    break;
	case 3:
	    setNumber3(number);
	    break;
	case 4:
	    setNumber4(number);
	    break;
	case 5:
	    setNumber5(number);
	    break;
	case 6:
	    setNumber6(number);
	    break;
	case 7:
	    setNumber7(number);
	    break;
	case 8:
	    setNumber8(number);
	    break;
	case 9:
	    setNumber9(number);
	    break;
	}
    }

}
