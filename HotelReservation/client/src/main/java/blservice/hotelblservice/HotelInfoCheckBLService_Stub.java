package blservice.hotelblservice;

import java.util.ArrayList;

import util.Adress;
import util.Area;
import vo.HotelInfoVO;

public class HotelInfoCheckBLService_Stub implements HotelInfoCheckBLService{

	HotelInfoVO hh;
	ArrayList<HotelInfoVO> aa;
	
	public HotelInfoCheckBLService_Stub() {
		hh=new HotelInfoVO("SunHotel",Adress.BEIJING,Area.EAST,3,"good","sofa",false,"5000",6.5,120);
		aa=new ArrayList<HotelInfoVO>();
		aa.add(hh);
	}
	
	
	@Override
	public HotelInfoVO checkHotelInfo(String hotelid) {
		
		return hh;
	}

	@Override
	public ArrayList<HotelInfoVO> hotelScan() {
		
		return aa;
	}

}
