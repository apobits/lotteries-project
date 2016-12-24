package ortiz.perez.albin.beans.stateless;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import ortiz.perez.albin.dtos.ResultDTO;
import ortiz.perez.albin.entities.Result;
import ortiz.perez.albin.entities.ResultPK;

/**
 * Session Bean implementation class ResultBean
 */
@Stateless
@LocalBean
public class ResultBean {

    @PersistenceContext(unitName = "LotteriesEJB")
    private EntityManager entityManager;

    private int[] firstDigit;
    private int[] secondDigit;
    private int[] thirdDigit;
    private int[] fourthDigit;

    private int[] firstDigitF;
    private int[] secondDigitF;
    private int[] thirdDigitF;
    private int[] fourthDigitF;

    private int[] firstDigitFB;
    private int[] secondDigitFB;
    private int[] thirdDigitFB;
    private int[] fourthDigitFB;

    private int[] firstDigitCountFB;
    private int[] secondDigitCountFB;
    private int[] thirdDigitCountFB;
    private int[] fourthDigitCountFB;

    private List<Integer> numberOne;

    private Integer resultCount;

    /**
     * Default constructor.
     */
    public ResultBean() {
	numberOne = new ArrayList<>();
	// TODO Auto-generated constructor stub
    }

    /**
     * Saves draw number by date and lottery name
     * 
     * @param result
     * @param lotteryName
     * @param date
     * @return
     * @throws Exception
     */
    public String saveResult(String result, String lotteryName, Date date) throws Exception {
	if (result != null && lotteryName != null && date != null) {
	    ResultPK resultPK = new ResultPK();
	    resultPK.setDrawDate(date);
	    resultPK.setLotteryName(lotteryName);
	    Result result1 = new Result();
	    result1.setId(resultPK);
	    result1.setDrawNumber(result);
	    if (entityManager.find(Result.class, resultPK) != null) {
		return "The result exists already";
	    } else {
		entityManager.persist(result1);
		return "The result has been saved succesfully";
	    }
	} else {
	    return "Result, lottery, date must not be null";
	}
    }

    /**
     * Returns the count of numbers repetition by position
     * 
     * @param lotteryName
     * @return
     */
    public List<ResultDTO> obtainCountNumbersRepetition(String lotteryName) {
	resultCount = new Integer(0);
	firstDigit = new int[10];
	secondDigit = new int[10];
	thirdDigit = new int[10];
	fourthDigit = new int[10];
	ResultDTO firstDigitDTO = new ResultDTO();
	ResultDTO secondDigitDTO = new ResultDTO();
	ResultDTO thirdDigitDTO = new ResultDTO();
	ResultDTO fourthDigitDTO = new ResultDTO();
	List<ResultDTO> countNumbersRepetition = new ArrayList<>();
	List<Result> results = getResultsList(lotteryName);
	for (Result iterateResults : results) {
	    resultCount++;
	    addNumber(Integer.valueOf(iterateResults.getDrawNumber().substring(0, 1)), 1);
	    addNumber(Integer.valueOf(iterateResults.getDrawNumber().substring(1, 2)), 2);
	    addNumber(Integer.valueOf(iterateResults.getDrawNumber().substring(2, 3)), 3);
	    addNumber(Integer.valueOf(iterateResults.getDrawNumber().substring(3, 4)), 4);
	}

	firstDigitDTO.setPosition("firstDigit");
	firstDigitDTO.setNumber0(firstDigit[0]);
	firstDigitDTO.setNumber1(firstDigit[1]);
	firstDigitDTO.setNumber2(firstDigit[2]);
	firstDigitDTO.setNumber3(firstDigit[3]);
	firstDigitDTO.setNumber4(firstDigit[4]);
	firstDigitDTO.setNumber5(firstDigit[5]);
	firstDigitDTO.setNumber6(firstDigit[6]);
	firstDigitDTO.setNumber7(firstDigit[7]);
	firstDigitDTO.setNumber8(firstDigit[8]);
	firstDigitDTO.setNumber9(firstDigit[9]);

	secondDigitDTO.setPosition("secondDigit");
	secondDigitDTO.setNumber0(secondDigit[0]);
	secondDigitDTO.setNumber1(secondDigit[1]);
	secondDigitDTO.setNumber2(secondDigit[2]);
	secondDigitDTO.setNumber3(secondDigit[3]);
	secondDigitDTO.setNumber4(secondDigit[4]);
	secondDigitDTO.setNumber5(secondDigit[5]);
	secondDigitDTO.setNumber6(secondDigit[6]);
	secondDigitDTO.setNumber7(secondDigit[7]);
	secondDigitDTO.setNumber8(secondDigit[8]);
	secondDigitDTO.setNumber9(secondDigit[9]);

	thirdDigitDTO.setPosition("thirdDigit");
	thirdDigitDTO.setNumber0(thirdDigit[0]);
	thirdDigitDTO.setNumber1(thirdDigit[1]);
	thirdDigitDTO.setNumber2(thirdDigit[2]);
	thirdDigitDTO.setNumber3(thirdDigit[3]);
	thirdDigitDTO.setNumber4(thirdDigit[4]);
	thirdDigitDTO.setNumber5(thirdDigit[5]);
	thirdDigitDTO.setNumber6(thirdDigit[6]);
	thirdDigitDTO.setNumber7(thirdDigit[7]);
	thirdDigitDTO.setNumber8(thirdDigit[8]);
	thirdDigitDTO.setNumber9(thirdDigit[9]);

	fourthDigitDTO.setPosition("fourthDigit");
	fourthDigitDTO.setNumber0(fourthDigit[0]);
	fourthDigitDTO.setNumber1(fourthDigit[1]);
	fourthDigitDTO.setNumber2(fourthDigit[2]);
	fourthDigitDTO.setNumber3(fourthDigit[3]);
	fourthDigitDTO.setNumber4(fourthDigit[4]);
	fourthDigitDTO.setNumber5(fourthDigit[5]);
	fourthDigitDTO.setNumber6(fourthDigit[6]);
	fourthDigitDTO.setNumber7(fourthDigit[7]);
	fourthDigitDTO.setNumber8(fourthDigit[8]);
	fourthDigitDTO.setNumber9(fourthDigit[9]);

	countNumbersRepetition.add(firstDigitDTO);
	countNumbersRepetition.add(secondDigitDTO);
	countNumbersRepetition.add(thirdDigitDTO);
	countNumbersRepetition.add(fourthDigitDTO);

	return countNumbersRepetition;
    }

    public List<ResultDTO> obtainFrequencyNumbersRepetition(String lotteryName) {
	firstDigitFB = new int[10];
	secondDigitFB = new int[10];
	thirdDigitFB = new int[10];
	fourthDigitFB = new int[10];
	firstDigitF = new int[10];
	secondDigitF = new int[10];
	thirdDigitF = new int[10];
	fourthDigitF = new int[10];
	firstDigitCountFB = new int[10];
	secondDigitCountFB = new int[10];
	thirdDigitCountFB = new int[10];
	fourthDigitCountFB = new int[10];
	List<ResultDTO> frequencyRepetition = new ArrayList<>();
	ResultDTO firstDigitDTOFrequency = new ResultDTO();
	ResultDTO secondDigitDTOFrequency = new ResultDTO();
	ResultDTO thirdDigitDTOFrequency = new ResultDTO();
	ResultDTO fourthDigitDTOFrequency = new ResultDTO();
	List<Result> results = getResultsList(lotteryName);
	for (Result iterateResults : results) {
	    for (int i = 0; i < 10; i++) {
		firstDigitF[i]++;
		secondDigitF[i]++;
		thirdDigitF[i]++;
		fourthDigitF[i]++;
	    }
	    addNumberFrequency(Integer.valueOf(String.valueOf(iterateResults.getDrawNumber()).substring(0, 1)), 1);
	    addNumberFrequency(Integer.valueOf(String.valueOf(iterateResults.getDrawNumber()).substring(1, 2)), 2);
	    addNumberFrequency(Integer.valueOf(String.valueOf(iterateResults.getDrawNumber()).substring(2, 3)), 3);
	    addNumberFrequency(Integer.valueOf(String.valueOf(iterateResults.getDrawNumber()).substring(3, 4)), 4);

	}
	for (int x : numberOne) {
	    System.out.println(x);
	}

	firstDigitDTOFrequency.setPosition("firstDigit");
	firstDigitDTOFrequency.setNumber0(firstDigitFB[0] / firstDigitCountFB[0]);
	firstDigitDTOFrequency.setNumber1(firstDigitFB[1] / firstDigitCountFB[1]);
	firstDigitDTOFrequency.setNumber2(firstDigitFB[2] / firstDigitCountFB[2]);
	firstDigitDTOFrequency.setNumber3(firstDigitFB[3] / firstDigitCountFB[3]);
	firstDigitDTOFrequency.setNumber4(firstDigitFB[4] / firstDigitCountFB[4]);
	firstDigitDTOFrequency.setNumber5(firstDigitFB[5] / firstDigitCountFB[5]);
	firstDigitDTOFrequency.setNumber6(firstDigitFB[6] / firstDigitCountFB[6]);
	firstDigitDTOFrequency.setNumber7(firstDigitFB[7] / firstDigitCountFB[7]);
	firstDigitDTOFrequency.setNumber8(firstDigitFB[8] / firstDigitCountFB[8]);
	firstDigitDTOFrequency.setNumber9(firstDigitFB[9] / firstDigitCountFB[9]);

	secondDigitDTOFrequency.setPosition("secondDigit");
	secondDigitDTOFrequency.setNumber0(secondDigitFB[0] / secondDigitCountFB[0]);
	secondDigitDTOFrequency.setNumber1(secondDigitFB[1] / secondDigitCountFB[1]);
	secondDigitDTOFrequency.setNumber2(secondDigitFB[2] / secondDigitCountFB[2]);
	secondDigitDTOFrequency.setNumber3(secondDigitFB[3] / secondDigitCountFB[3]);
	secondDigitDTOFrequency.setNumber4(secondDigitFB[4] / secondDigitCountFB[4]);
	secondDigitDTOFrequency.setNumber5(secondDigitFB[5] / secondDigitCountFB[5]);
	secondDigitDTOFrequency.setNumber6(secondDigitFB[6] / secondDigitCountFB[6]);
	secondDigitDTOFrequency.setNumber7(secondDigitFB[7] / secondDigitCountFB[7]);
	secondDigitDTOFrequency.setNumber8(secondDigitFB[8] / secondDigitCountFB[8]);
	secondDigitDTOFrequency.setNumber9(secondDigitFB[9] / secondDigitCountFB[9]);

	thirdDigitDTOFrequency.setPosition("thirdDigit");
	thirdDigitDTOFrequency.setNumber0(thirdDigitFB[0] / thirdDigitCountFB[0]);
	thirdDigitDTOFrequency.setNumber1(thirdDigitFB[1] / thirdDigitCountFB[1]);
	thirdDigitDTOFrequency.setNumber2(thirdDigitFB[2] / thirdDigitCountFB[2]);
	thirdDigitDTOFrequency.setNumber3(thirdDigitFB[3] / thirdDigitCountFB[3]);
	thirdDigitDTOFrequency.setNumber4(thirdDigitFB[4] / thirdDigitCountFB[4]);
	thirdDigitDTOFrequency.setNumber5(thirdDigitFB[5] / thirdDigitCountFB[5]);
	thirdDigitDTOFrequency.setNumber6(thirdDigitFB[6] / thirdDigitCountFB[6]);
	thirdDigitDTOFrequency.setNumber7(thirdDigitFB[7] / thirdDigitCountFB[7]);
	thirdDigitDTOFrequency.setNumber8(thirdDigitFB[8] / thirdDigitCountFB[8]);
	thirdDigitDTOFrequency.setNumber9(thirdDigitFB[9] / thirdDigitCountFB[9]);

	fourthDigitDTOFrequency.setPosition("fourthDigit");
	fourthDigitDTOFrequency.setNumber0(fourthDigitFB[0] / fourthDigitCountFB[0]);
	fourthDigitDTOFrequency.setNumber1(fourthDigitFB[1] / fourthDigitCountFB[1]);
	fourthDigitDTOFrequency.setNumber2(fourthDigitFB[2] / fourthDigitCountFB[2]);
	fourthDigitDTOFrequency.setNumber3(fourthDigitFB[3] / fourthDigitCountFB[3]);
	fourthDigitDTOFrequency.setNumber4(fourthDigitFB[4] / fourthDigitCountFB[4]);
	fourthDigitDTOFrequency.setNumber5(fourthDigitFB[5] / fourthDigitCountFB[5]);
	fourthDigitDTOFrequency.setNumber6(fourthDigitFB[6] / fourthDigitCountFB[6]);
	fourthDigitDTOFrequency.setNumber7(fourthDigitFB[7] / fourthDigitCountFB[7]);
	fourthDigitDTOFrequency.setNumber8(fourthDigitFB[8] / fourthDigitCountFB[8]);
	fourthDigitDTOFrequency.setNumber9(fourthDigitFB[9] / fourthDigitCountFB[9]);

	frequencyRepetition.add(firstDigitDTOFrequency);
	frequencyRepetition.add(secondDigitDTOFrequency);
	frequencyRepetition.add(thirdDigitDTOFrequency);
	frequencyRepetition.add(fourthDigitDTOFrequency);

	return frequencyRepetition;
    }

    private void addNumberFrequency(int number, int position) {

	switch (number) {
	case 0:
	    if (position == 1) {
		firstDigitFB[0] += firstDigitF[0];
		firstDigitCountFB[0]++;
		firstDigitF[0] = 0;
	    } else if (position == 2) {
		secondDigitFB[0] += secondDigitF[0];
		secondDigitCountFB[0]++;
		secondDigitF[0] = 0;
	    } else if (position == 3) {
		thirdDigitFB[0] += thirdDigitF[0];
		thirdDigitCountFB[0]++;
		thirdDigitF[0] = 0;
	    } else {
		fourthDigitFB[0] += fourthDigitF[0];
		fourthDigitCountFB[0]++;
		fourthDigitF[0] = 0;
	    }
	    break;
	case 1:
	    if (position == 1) {
		firstDigitFB[1] += firstDigitF[1];
		firstDigitCountFB[1]++;
		firstDigitF[1] = 0;
	    } else if (position == 2) {
		secondDigitFB[1] += secondDigitF[1];
		secondDigitCountFB[1]++;
		secondDigitF[1] = 0;
	    } else if (position == 3) {
		thirdDigitFB[1] += thirdDigitF[1];
		thirdDigitCountFB[1]++;
		thirdDigitF[1] = 0;
	    } else {
		fourthDigitFB[1] += fourthDigitF[1];
		fourthDigitCountFB[1]++;
		numberOne.add(fourthDigitF[1]);
		fourthDigitF[1] = 0;
	    }
	    ;
	    break;
	case 2:
	    if (position == 1) {
		firstDigitFB[2] += firstDigitF[2];
		firstDigitCountFB[2]++;
		firstDigitF[2] = 0;
	    } else if (position == 2) {
		secondDigitFB[2] += secondDigitF[2];
		secondDigitCountFB[2]++;
		secondDigitF[2] = 0;
	    } else if (position == 3) {
		thirdDigitFB[2] += thirdDigitF[2];
		thirdDigitCountFB[2]++;
		thirdDigitF[2] = 0;
	    } else {
		fourthDigitFB[2] += fourthDigitF[2];
		fourthDigitCountFB[2]++;
		fourthDigitF[2] = 0;
	    }
	    ;
	    break;
	case 3:
	    if (position == 1) {
		firstDigitFB[3] += firstDigitF[3];
		firstDigitCountFB[3]++;
		firstDigitF[3] = 0;
	    } else if (position == 2) {
		secondDigitFB[3] += secondDigitF[3];
		secondDigitCountFB[3]++;
		secondDigitF[3] = 0;
	    } else if (position == 3) {
		thirdDigitFB[3] += thirdDigitF[3];
		thirdDigitCountFB[3]++;
		thirdDigitF[3] = 0;
	    } else {
		fourthDigitFB[3] += fourthDigitF[3];
		fourthDigitCountFB[3]++;
		fourthDigitF[3] = 0;
	    }
	    ;
	    break;
	case 4:
	    if (position == 1) {
		firstDigitFB[4] += firstDigitF[4];
		firstDigitCountFB[4]++;
		firstDigitF[4] = 0;
	    } else if (position == 2) {
		secondDigitFB[4] += secondDigitF[4];
		secondDigitCountFB[4]++;
		secondDigitF[4] = 0;
	    } else if (position == 3) {
		thirdDigitFB[4] += thirdDigitF[4];
		thirdDigitCountFB[4]++;
		thirdDigitF[4] = 0;
	    } else {
		fourthDigitFB[4] += fourthDigitF[4];
		fourthDigitCountFB[4]++;
		fourthDigitF[4] = 0;
	    }
	    ;
	    break;
	case 5:
	    if (position == 1) {
		firstDigitFB[5] += firstDigitF[5];
		firstDigitCountFB[5]++;
		firstDigitF[5] = 0;
	    } else if (position == 2) {
		secondDigitFB[5] += secondDigitF[5];
		secondDigitCountFB[5]++;
		secondDigitF[5] = 0;
	    } else if (position == 3) {
		thirdDigitFB[5] += thirdDigitF[5];
		thirdDigitCountFB[5]++;
		thirdDigitF[5] = 0;
	    } else {
		fourthDigitFB[5] += fourthDigitF[5];
		fourthDigitCountFB[5]++;
		fourthDigitF[5] = 0;
	    }
	    ;
	    break;
	case 6:
	    if (position == 1) {
		firstDigitFB[6] += firstDigitF[6];
		firstDigitCountFB[6]++;
		firstDigitF[6] = 0;
	    } else if (position == 2) {
		secondDigitFB[6] += secondDigitF[6];
		secondDigitCountFB[6]++;
		secondDigitF[6] = 0;
	    } else if (position == 3) {
		thirdDigitFB[6] += thirdDigitF[6];
		thirdDigitCountFB[6]++;
		thirdDigitF[6] = 0;
	    } else {
		fourthDigitFB[6] += fourthDigitF[6];
		fourthDigitCountFB[6]++;
		fourthDigitF[6] = 0;
	    }
	    ;
	    break;
	case 7:
	    if (position == 1) {
		firstDigitFB[7] += firstDigitF[7];
		firstDigitCountFB[7]++;
		firstDigitF[7] = 0;
	    } else if (position == 2) {
		secondDigitFB[7] += secondDigitF[7];
		secondDigitCountFB[7]++;
		secondDigitF[7] = 0;
	    } else if (position == 3) {
		thirdDigitFB[7] += thirdDigitF[7];
		thirdDigitCountFB[7]++;
		thirdDigitF[7] = 0;
	    } else {
		fourthDigitFB[7] += fourthDigitF[7];
		fourthDigitCountFB[7]++;
		fourthDigitF[7] = 0;
	    }
	    ;
	    break;
	case 8:
	    if (position == 1) {
		firstDigitFB[8] += firstDigitF[8];
		firstDigitCountFB[8]++;
		firstDigitF[8] = 0;
	    } else if (position == 2) {
		secondDigitFB[8] += secondDigitF[8];
		secondDigitCountFB[8]++;
		secondDigitF[8] = 0;
	    } else if (position == 3) {
		thirdDigitFB[8] += thirdDigitF[8];
		thirdDigitCountFB[8]++;
		thirdDigitF[8] = 0;
	    } else {
		fourthDigitFB[8] += fourthDigitF[8];
		fourthDigitCountFB[8]++;
		fourthDigitF[8] = 0;
	    }
	    ;
	    break;
	case 9:
	    if (position == 1) {
		firstDigitFB[9] += firstDigitF[9];
		firstDigitCountFB[9]++;
		firstDigitF[9] = 0;
	    } else if (position == 2) {
		secondDigitFB[9] += secondDigitF[9];
		secondDigitCountFB[9]++;
		secondDigitF[9] = 0;
	    } else if (position == 3) {
		thirdDigitFB[9] += thirdDigitF[9];
		thirdDigitCountFB[9]++;
		thirdDigitF[9] = 0;
	    } else {
		fourthDigitFB[9] += fourthDigitF[9];
		fourthDigitCountFB[9]++;
		fourthDigitF[9] = 0;
	    }
	    ;
	    break;
	}
    }

    private void addNumber(int number, int position) {

	switch (number) {
	case 0:
	    if (position == 1) {
		firstDigit[0]++;
	    } else if (position == 2) {
		secondDigit[0]++;
	    } else if (position == 3) {
		thirdDigit[0]++;
	    } else {
		fourthDigit[0]++;
	    }
	    ;
	    break;
	case 1:
	    if (position == 1) {
		firstDigit[1]++;
	    } else if (position == 2) {
		secondDigit[1]++;
	    } else if (position == 3) {
		thirdDigit[1]++;
	    } else {
		fourthDigit[1]++;
	    }
	    ;
	    break;
	case 2:
	    if (position == 1) {
		firstDigit[2]++;
	    } else if (position == 2) {
		secondDigit[2]++;
	    } else if (position == 3) {
		thirdDigit[2]++;
	    } else {
		fourthDigit[2]++;
	    }
	    ;
	    break;
	case 3:
	    if (position == 1) {
		firstDigit[3]++;
	    } else if (position == 2) {
		secondDigit[3]++;
	    } else if (position == 3) {
		thirdDigit[3]++;
	    } else {
		fourthDigit[3]++;
	    }
	    ;
	    break;
	case 4:
	    if (position == 1) {
		firstDigit[4]++;
	    } else if (position == 2) {
		secondDigit[4]++;
	    } else if (position == 3) {
		thirdDigit[4]++;
	    } else {
		fourthDigit[4]++;
	    }
	    ;
	    break;
	case 5:
	    if (position == 1) {
		firstDigit[5]++;
	    } else if (position == 2) {
		secondDigit[5]++;
	    } else if (position == 3) {
		thirdDigit[5]++;
	    } else {
		fourthDigit[5]++;
	    }
	    ;
	    break;
	case 6:
	    if (position == 1) {
		firstDigit[6]++;
	    } else if (position == 2) {
		secondDigit[6]++;
	    } else if (position == 3) {
		thirdDigit[6]++;
	    } else {
		fourthDigit[6]++;
	    }
	    ;
	    break;
	case 7:
	    if (position == 1) {
		firstDigit[7]++;
	    } else if (position == 2) {
		secondDigit[7]++;
	    } else if (position == 3) {
		thirdDigit[7]++;
	    } else {
		fourthDigit[7]++;
	    }
	    ;
	    break;
	case 8:
	    if (position == 1) {
		firstDigit[8]++;
	    } else if (position == 2) {
		secondDigit[8]++;
	    } else if (position == 3) {
		thirdDigit[8]++;
	    } else {
		fourthDigit[8]++;
	    }
	    ;
	    break;
	case 9:
	    if (position == 1) {
		firstDigit[9]++;
	    } else if (position == 2) {
		secondDigit[9]++;
	    } else if (position == 3) {
		thirdDigit[9]++;
	    } else {
		fourthDigit[9]++;
	    }
	    ;
	    break;
	}
    }

    @SuppressWarnings("unchecked")
    public List<Result> getResultsList(String lotteryName) {
	return entityManager.createQuery("SELECT R FROM RESULT R where R.id.lotteryName ='" + lotteryName + "' order by R.id.drawDate desc").getResultList();
    }

    private List<String> getNumbersToPlay(String lotteryName) {

	List<ResultDTO> countNumbers = obtainCountNumbersRepetition(lotteryName);
	int[] orderNumbersFD = new int[10];
	orderNumbersFD[0] = countNumbers.get(0).getNumber0();
	for (int i = 0; i < 10; i++) {

	}

	return null;

    }

    public ResultDTO getNumbersRepetition(List<Result> results) {
	ResultDTO result = new ResultDTO();
	for (Result x : results) {
	    update(x, 0, result);
	    update(x, 1, result);
	    update(x, 2, result);
	    update(x, 3, result);
	}
	return result;
    }

    private ResultDTO update(Result result, int position, ResultDTO resultDTO) {
	switch (result.getDrawNumber().charAt(position)) {
	case '0':
	    resultDTO.setNumber0(resultDTO.getNumber0() + 1);
	    break;
	case '1':
	    resultDTO.setNumber1(resultDTO.getNumber1() + 1);
	    break;
	case '2':
	    resultDTO.setNumber2(resultDTO.getNumber2() + 1);
	    break;
	case '3':
	    resultDTO.setNumber3(resultDTO.getNumber3() + 1);
	    break;
	case '4':
	    resultDTO.setNumber4(resultDTO.getNumber4() + 1);
	    break;
	case '5':
	    resultDTO.setNumber5(resultDTO.getNumber5() + 1);
	    break;
	case '6':
	    resultDTO.setNumber6(resultDTO.getNumber6() + 1);
	    break;
	case '7':
	    resultDTO.setNumber7(resultDTO.getNumber7() + 1);
	    break;
	case '8':
	    resultDTO.setNumber8(resultDTO.getNumber8() + 1);
	    break;
	case '9':
	    resultDTO.setNumber9(resultDTO.getNumber9() + 1);
	    break;
	}
	return resultDTO;
    }

}
