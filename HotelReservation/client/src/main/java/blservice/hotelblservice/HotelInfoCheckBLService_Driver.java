package blservice.hotelblservice;

import java.util.ArrayList;

import vo.HotelInfoVO;

public class HotelInfoCheckBLService_Driver {

  public static void main(String[] args){
		
	  HotelInfoCheckBLService a=new HotelInfoCheckBLService_Stub();
	  HotelInfoCheckBLService_Driver b=new HotelInfoCheckBLService_Driver();
		b.drive(a);
	
	}
	
	public void drive(HotelInfoCheckBLService a){
		HotelInfoVO hotelInfoVO=a.checkHotelInfo("5000");
		ArrayList<HotelInfoVO> arrayList=a.hotelScan();
	
	}
}
