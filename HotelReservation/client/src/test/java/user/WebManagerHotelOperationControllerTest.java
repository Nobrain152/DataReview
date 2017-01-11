package user;


import static org.junit.Assert.assertEquals;

import java.util.ArrayList;

import org.junit.Before;
import org.junit.Test;

import bl.userbl.WebManagerHotelOperationController;
import util.Adress;
import util.Area;
import vo.HotelInfoVO;

public class WebManagerHotelOperationControllerTest {

	WebManagerHotelOperationController impl;
	
	@Before
	public void setUp() {
		impl=new WebManagerHotelOperationController();
	
	}

	@Test
	public void testHotelAdd() {
		HotelInfoVO vo=new HotelInfoVO("如家",Adress.NANJING,Area.EAST,2,"环境优美","空调",false,null,20.1,120);
		String id=impl.hotelAdd(vo);
		if(id!=null){
			testscan();
		}
	}
	
	
	
	@Test
	public void testscan(){
		ArrayList<HotelInfoVO> hotelInfoVOs=new ArrayList<HotelInfoVO>();
	    assertEquals(hotelInfoVOs.get(0).getName(),"如家");
	}


}
