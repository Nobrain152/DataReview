package hotel;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;

import org.junit.Before;
import org.junit.Test;


import bl.hotelbl.HotelReserveController;
import util.Adress;
import util.Area;
import util.OrderState;
import util.ResultMsg;

import util.RoomType;
import util.VipType;
import vo.CustomerInfoVO;
import vo.HotelInfoVO;
import vo.OrderVO;

//pass
public class HotelReserveControllerTest {
	HotelReserveController impl;
	
	HotelInfoVO hotel1;
	HotelInfoVO hotel2;
	
	OrderVO order1;
	OrderVO order2;
	
	OrderVO orderMsg1;
	OrderVO orderMsg2;
	
	ResultMsg reMsg;
	
	
	@Before
	public void setUp() {
		impl = new HotelReserveController();
		
		hotel1=new HotelInfoVO("StarHotel",Adress.NANJING,Area.EAST,5,"It's a wonderful hotel","cafe, garden and so on",
				true,"431543263",1.1,120);
		hotel2=new HotelInfoVO("SunHotel",Adress.NANJING,Area.WEST,4,"It's a nice hotel","cafe",
				false,"452346236",1.1,120);
		
		
		ArrayList<String> ro=new ArrayList<String>();
		ro.add("456");
		CustomerInfoVO customerInfoVO=new CustomerInfoVO("12345678","Jerry","13067893451","12345678",100,false,VipType.COMMON_VIP);
		customerInfoVO.setCredit(100);
		orderMsg1=new OrderVO("60000004",customerInfoVO,OrderState.UNEXECUTED,99.9, "5002",false,"2016-10-02 24:00","2016-10-03 12:00","2016-10-02 12:00",null,1,ro,1,RoomType.ROOM_BIGBED);
		
		reMsg = ResultMsg.SUCCESS;
	}
	
	@Test
	public void testreserveHotel(){
		ResultMsg msg = impl.reserveHotel(orderMsg1); 
		//assertEquals(msg.getMessage(), reMsg.getMessage());
		assertEquals(msg, reMsg);
	}
	
	

}
