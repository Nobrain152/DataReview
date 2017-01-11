package blservice.hotelblservice;

import po.HotelInfoPO;
import util.ResultMsg;
import vo.HotelInfoVO;

public class HotelInfoMaintainBLService_Driver {

	  public static void main(String[] args){
			
		  HotelInfoMaintainBLService a=new HotelInfoMaintainBLService_Stub();
		  HotelInfoMaintainBLService_Driver b=new HotelInfoMaintainBLService_Driver();
			b.drive(a);
		
		}
		
		public void drive(HotelInfoMaintainBLService a){
			ResultMsg resultMsg=a.inputHotelInfo(new HotelInfoVO());
			resultMsg=a.checkInfo(new HotelInfoVO());
			String string=a.addHotel(new HotelInfoVO());
			HotelInfoPO po=a.find("5000");
		}
}
