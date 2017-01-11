package hotel;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;

import org.junit.Before;
import org.junit.Test;

import bl.hotelbl.HotelSearchController;
import util.Adress;
import util.Area;
import util.ResultMsg;
import vo.HotelInfoVO;
import vo.RoomInfoVO;
//pass
public class HotelSearchControllerTest {

	HotelSearchController impl;
	ArrayList<HotelInfoVO> hotelList;
	HotelInfoVO hotel1;
	HotelInfoVO hotel2;
	HotelInfoVO hotel3;
	RoomInfoVO roomInfoVO;
	
	ResultMsg hotelMsg;
	
	
	
	@Before
	public void setUp() {
		//String s;
		hotel1=new HotelInfoVO("SunHotel",Adress.NANJING,Area.EAST,2,"It's a wonderful hotel","cafe, garden and so on",
				false,"431543263",20.1,120);
		hotel1.setDown(10);
		hotel1.setUp(30);
		hotel2=new HotelInfoVO(null, Adress.BEIJING, Area.EAST, 3, null, null, true, "", 0, 0);
		hotel3=new HotelInfoVO("MoonHotel",Adress.NANJING,Area.NORTH,-1,"It's a terrible hotel","nothing",
				true,"234655754634",1.1,120);
				
		roomInfoVO=null;		
		impl = new HotelSearchController();
		
		hotelList = impl.hotelList;
		hotelList.add(hotel1);
		hotelList.add(hotel2);
		hotelList.add(hotel3);
		
		
		hotelMsg = ResultMsg.SUCCESS;
	}
	
	@Test
	public void testselectCondition(){
		ArrayList<HotelInfoVO> msg1 = impl.selectCondition(hotel2,roomInfoVO);
		assertEquals(msg1.get(0).getName(),"SunHotel");
	}
	
//	@Test
//	public void showList(){
//		ArrayList<HotelInfoVO> hotels =impl. selectCondition(hotel2,roomInfoVO);
//		assertEquals(hotels.get(0).getArea(),Area.NORTH);
//    }

}
