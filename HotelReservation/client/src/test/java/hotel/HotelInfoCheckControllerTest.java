package hotel;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;

import org.junit.Before;
import org.junit.Test;

import bl.hotelbl.HotelInfoCheckController;
import util.Adress;
import util.Area;
import util.ResultMsg;
import vo.HotelInfoVO;
//pass
public class HotelInfoCheckControllerTest {

	HotelInfoCheckController impl;
	ArrayList<HotelInfoVO> hotelList;
	HotelInfoVO hotel1;
	HotelInfoVO hotel2;
	HotelInfoVO hotel3;
	
	ResultMsg hotelMsg;
	
	
	
	@Before
	public void setUp() {
		hotel1=new HotelInfoVO("ИзјТ",Adress.NANJING,Area.EAST,2,"It's a wonderful hotel","cafe, garden and so on",
				true,"5000",20.1,120);
		hotel2=new HotelInfoVO("SunHotel",Adress.NANJING,Area.NORTH,4,"It's a nice hotel","cafe",
				false,"5002",77.77,100);
		hotel3=new HotelInfoVO("MoonHotel",Adress.SHANGHAI,Area.SOUTH,3,"It's a terrible hotel","nothing",
				true,"5004",88.88,300);
				
				
		impl = new HotelInfoCheckController();
		
		hotelList = impl.hotelList;
		hotelList.add(hotel1);
		hotelList.add(hotel2);
		hotelList.add(hotel3);
		
		
		hotelMsg = ResultMsg.SUCCESS;
	}
	
	@Test
	public void testcheckHotelInfo(){
		HotelInfoVO msg1 = impl.checkHotelInfo("5006");
		assertEquals(msg1.getName(),"SunHotel");
		
    }
	
	@Test
	public void testScan(){
		ArrayList<HotelInfoVO> vos=impl.hotelScan();
		boolean con=false;
		if(vos.get(0)!=null){
			con=true;
		}
		assertEquals(true,con);
	}
	
	

}
