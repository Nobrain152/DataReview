package blservice.userblservice;

import java.util.ArrayList;


import vo.HotelInfoVO;
import vo.StuffInfoVO;

public class WebManagerHotelOperationBLService_Driver {

	 public static void main(String[] args){
			
		 WebManagerHotelOperationBlService a=new WebManagerHotelOperationBLService_Stub();
		 WebManagerHotelOperationBLService_Driver b=new WebManagerHotelOperationBLService_Driver();
		   b.drive(a);
		
		}
		
		public void drive(WebManagerHotelOperationBlService a){
			ArrayList<HotelInfoVO> hotelInfoVOs;
			hotelInfoVOs=a.hotelScan();
			String s=a.hotelAdd(new HotelInfoVO());
			s=a.stuffAdd(new StuffInfoVO());
		}
}
