package blservice.userblservice;

import java.util.ArrayList;

import util.Adress;
import util.Area;
import vo.HotelInfoVO;
import vo.StuffInfoVO;

public class WebManagerHotelOperationBLService_Stub implements WebManagerHotelOperationBlService {

	
	ArrayList<HotelInfoVO> hotelInfoVOs;
	HotelInfoVO hotel;
	
	public WebManagerHotelOperationBLService_Stub(){
		hotelInfoVOs=new ArrayList<HotelInfoVO>();
		hotel=new HotelInfoVO("SunHotel",Adress.BEIJING,Area.EAST,3,"nice","wifi",false,"5000",6.1,120);
		hotelInfoVOs.add(hotel);
	}
	
	
	@Override
	public ArrayList<HotelInfoVO> hotelScan() {
		
		return hotelInfoVOs;
	}

	@Override
	public String hotelAdd(HotelInfoVO vo) {
		
		return "5001";
	}

	@Override
	public String stuffAdd(StuffInfoVO vo) {
		
		return "23345678";
	}

}
