package blservice.hotelblservice;

import java.util.ArrayList;

import vo.HotelInfoVO;
import vo.RoomInfoVO;

public class HotelSearchBLService_Driver {

	  public static void main(String[] args){
			
		  HotelSearchBLService a=new HotelSearchBLService_Stub();
		  HotelSearchBLService_Driver b=new HotelSearchBLService_Driver();
			b.drive(a);
		
		}
		
		public void drive(HotelSearchBLService a){
			ArrayList<HotelInfoVO> arrayList=a.selectCondition(new HotelInfoVO(),new RoomInfoVO());
		}
}
