package blservice.orderblservice;


import java.util.ArrayList;

import blservice.orderblservice.OrderOnHotelBLService;
import util.OrderState;
import util.ResultMsg;
import util.RoomType;
import vo.CustomerInfoVO;
import vo.OrderVO;

public class OrderOnHotelBLService_Driver {
	
	public static void main(String[] args){
		OrderOnHotelBLService a = new OrderOnHotelBLService_Stub();
		OrderOnHotelBLService_Driver driver = new OrderOnHotelBLService_Driver();
		driver.drive(a);
	}
	
	public void drive(OrderOnHotelBLService OrderOnHotelBLService){
		CustomerInfoVO client = new CustomerInfoVO("1000066", "123", "12345678910", "sfd", 0, false, null);
		OrderVO orderVO = new OrderVO("60000010", client, OrderState.UNEXECUTED, 100, "5000", false, "", "", "", "", 1, null, 1, RoomType.ROOM_BIGBED);
				
		ResultMsg result = OrderOnHotelBLService.hotelOrderModify(orderVO);
		if(result == ResultMsg.SUCCESS)
			System.out.println("–ﬁ∏ƒ∂©µ•◊¥Ã¨≥…π¶");
		else
			System.out.println("–ﬁ∏ƒ ß∞‹");
		
		OrderVO orderVO2 = OrderOnHotelBLService.hotelOrderDetail(orderVO.getOrderID());
		if(orderVO2.getOrderID().equals(orderVO.getOrderID()))
			System.out.println("œ‘ ææ∆µÍ∂©µ•œÍ«È");
		else
			System.out.println("œ‘ æ ß∞‹");
		
		String ID = "5000";
		ArrayList<OrderVO> orderVOs = OrderOnHotelBLService.hotelOrderScan(ID);
		if(orderVOs.get(0).getOrderID().equals(orderVO.getOrderID()))
			System.out.println("‰Ø¿¿∂©µ•≥…π¶");
		else
			System.out.println("‰Ø¿¿∂©µ• ß∞‹");
		
	}
}
