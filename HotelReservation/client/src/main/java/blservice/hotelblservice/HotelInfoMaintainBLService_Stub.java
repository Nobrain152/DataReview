package blservice.hotelblservice;

import po.HotelInfoPO;
import util.Adress;
import util.Area;
import util.ResultMsg;
import vo.HotelInfoVO;

public class HotelInfoMaintainBLService_Stub implements HotelInfoMaintainBLService{

	
	HotelInfoPO hh;
	
	public HotelInfoMaintainBLService_Stub() {
		hh=new HotelInfoPO("5011","SunHotel",Adress.BEIJING,Area.EAST,3,"good","sofa",false,6.5,120);
	}
	@Override
	public ResultMsg inputHotelInfo(HotelInfoVO hotelInfoVO) {
		
		return ResultMsg.SUCCESS;
	}

	@Override
	public ResultMsg checkInfo(HotelInfoVO hotelInfoVO) {
		
		return ResultMsg.SUCCESS;
	}

	@Override
	public String addHotel(HotelInfoVO hotelInfoVO) {
		
		return "5011";
	}

	@Override
	public HotelInfoPO find(String hotelID) {
		return hh;
	}

}
