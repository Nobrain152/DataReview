package blservice.userblservice;

import java.util.ArrayList;

import util.ResultMsg;
import util.Sort;
import vo.HotelEvaluateVO;
import vo.HotelInfoVO;
import vo.OrderVO;

public class CustomerHotelOperationBLService_Driver {

    public static void main(String[] args){
		
	   CustomerHotelOperationBlService a=new CustomerHotelOperationBLService_Stub();
	   CustomerHotelOperationBLService_Driver b=new CustomerHotelOperationBLService_Driver();
	   b.drive(a);
	
	}
	
	public void drive(CustomerHotelOperationBlService a){
		ArrayList<HotelInfoVO> hotelInfoVOs;
		HotelInfoVO hotel;
		ArrayList<OrderVO> order;
		
		hotel=a.hotelDetail("5000","12345678");
		hotelInfoVOs=a.hotelSearch(null,hotel,"12345678");
		hotelInfoVOs=a.sortHotel(hotelInfoVOs,Sort.Price_DownToUp);
		order=a.getHotelOrder("5000","12345678");
		ResultMsg res=a.orderCreat("5000",new OrderVO());
		a.hotelEvaluate(new HotelEvaluateVO());
	}
}
