package hotel;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;

import org.junit.Before;
import org.junit.Test;

import bl.hotelbl.HotelEvaluateController;
import util.ResultMsg;
import vo.HotelEvaluateVO;
//pass
public class HotelEvaluateControllerTest {

	HotelEvaluateController impl;
	ArrayList<HotelEvaluateVO> evList;
	HotelEvaluateVO evaluation1;
	HotelEvaluateVO evaluation2;
	
	ResultMsg evMsg;
	ResultMsg reMsg1;
	ResultMsg reMsg2;
	
	
	@Before
	public void setUp() {
		evaluation1=new HotelEvaluateVO("12345679","5000",10,"execellent",true,"41531623636");
		evaluation2=new HotelEvaluateVO("12345679","5000",8,"very good",false,"4325236526");	
		impl = new HotelEvaluateController();
		reMsg1 = ResultMsg.SUCCESS;
		reMsg2 = ResultMsg.FAIL;
		evMsg = ResultMsg.SUCCESS;
	}
	
	@Test
	public void testinputEvaluate(){
		//System.out.println(evaluation1.getIsReserved());
		ResultMsg msg1 = impl.inputEvaluate(evaluation1);
		assertEquals(msg1, evMsg);
	}
	
	@Test
	public void testscan(){
		ArrayList<HotelEvaluateVO> vos=impl.getEvaluate("5000");
		assertEquals(vos.get(0).getUserID(),"151250058");
		
		
	}

}
