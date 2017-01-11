package blservice.hotelblservice;

import java.util.ArrayList;

import util.Adress;
import util.Area;
import vo.HotelInfoVO;
import vo.RoomInfoVO;

public class HotelSearchBLService_Stub implements HotelSearchBLService {

	
	ArrayList<HotelInfoVO> aa;
	HotelInfoVO hh;
	
	public HotelSearchBLService_Stub() {
		hh=new HotelInfoVO("SunHotel",Adress.BEIJING,Area.EAST,3,"good","sofa",false,"5000",6.5,120);
		aa=new ArrayList<HotelInfoVO>();
		aa.add(hh);
	}
	
	@Override
	public ArrayList<HotelInfoVO> selectCondition(HotelInfoVO hotelConditionVO, RoomInfoVO vo2) {
		
		return aa;
	}

}
