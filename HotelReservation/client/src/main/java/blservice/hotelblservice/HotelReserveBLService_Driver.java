package blservice.hotelblservice;

import util.ResultMsg;
import vo.OrderVO;

public class HotelReserveBLService_Driver {

	  public static void main(String[] args){
			
		  HotelReserveBLService a=new HotelReserveBLService_Stub();
		  HotelReserveBLService_Driver b=new HotelReserveBLService_Driver();
			b.drive(a);
		
		}
		
		public void drive(HotelReserveBLService a){
			ResultMsg resultMsg=a.reserveHotel(new OrderVO());
		}
}
