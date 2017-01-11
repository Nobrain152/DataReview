package order;

import static org.junit.Assert.assertEquals;

import java.rmi.RemoteException;
import java.util.ArrayList;

import org.junit.Before;
import org.junit.Test;

import bl.orderbl.OrderOnHotelController;
//import bl.orderbl.OrderOnUserController;
import blservice.orderblservice.OrderOnHotelBLService;
//import blservice.orderblservice.OrderOnUserBLService;
import util.OrderState;
import util.ResultMsg;
import util.RoomType;
//import util.RoomState;
//import util.RoomType;
import util.VipType;
import vo.CustomerInfoVO;
import vo.OrderVO;
//import vo.RoomInfoVO;

public class OrderOnHotelControllerTest {

	private OrderOnHotelBLService onHotelBLService;
//	private OrderOnUserBLService onUserBLService;
	ArrayList<OrderVO> hotelList;
	OrderVO order1;
//	OrderVO order2;
	OrderVO order3;
	OrderVO order4;
//	OrderVO testOrder;
	ResultMsg resultMsg;
	
	
	@Before
	public void setUp() throws RemoteException {
		ArrayList<String> arrayList1 = new ArrayList<>();
		arrayList1.add("60161002");
		ArrayList<String> arrayList2 = new ArrayList<>();
		arrayList2.add("60161004");
		ArrayList<String> arrayList3 = new ArrayList<>();
		arrayList3.add("60161003");
		order1 = new OrderVO("60161002", new CustomerInfoVO("19954722", "txin", "ve",
				"18805156300", 300, true, VipType.COMMON_VIP), 
				OrderState.UNEXECUTED, 99.9, "5000", false, 
				"2016-12-23 24:00", "2016-12-23 12:00", "2016-12-24 12:00", null,
				1, arrayList1,1,RoomType.ROOM_STANDARD);
//		order2 = new OrderVO("201612112014", new CustomerInfoVO("19954722", "txin", "ve",
//				"18805156300", 300, true, VipType.COMMON_VIP), 
//				OrderState.CANCELLED, 99.9, "014", false, 
//				"2016-12-16 24:00", "2016-12-16 12:00", "2016-12-17 12:00", null,
//				1, new RoomInfoVO(RoomState.USABLE, RoomType.ROOM_STANDARD, "513", 99.9, "014"),1);
		order3 = new OrderVO("60161004", new CustomerInfoVO("19954722", "txin", "ve",
				"18805156300", 300, true, VipType.COMMON_VIP), 
				OrderState.ABNORMAL, 99.9, "5000", false, 
				"2016-10-04 24:00", "2016-10-03 12:00", "2016-10-04 12:00", null,
				1, arrayList2,1,RoomType.ROOM_STANDARD);
		order4 = new OrderVO("60161003", new CustomerInfoVO("19954722", "txin", "ve",
				"18805156300", 300, true, VipType.COMMON_VIP), 
				OrderState.EXECUTED, 99.9, "5000", false, 
				"2016-10-03 24:00", "2016-10-04 12:00", "2016-10-03 12:00", null,
				1, arrayList3,1,RoomType.ROOM_STANDARD);
		onHotelBLService = new OrderOnHotelController();
//		onUserBLService = new OrderOnUserController();
//		onUserBLService.createOrder(order1);
		
		resultMsg = ResultMsg.SUCCESS;
		
		hotelList = new ArrayList<OrderVO>();
		hotelList.add(order1);
//		hotelList.add(order2);
		hotelList.add(order3);
		hotelList.add(order4);
		
//		testOrder = new OrderVO("201612062014",new CustomerInfoVO("19954722", "txin","ve", 
//				"18805156300", 300, true, VipType.COMMON_VIP), 
//				OrderState.UNEXECUTED, 99.9, "014", false, 
//				"2016-12-16 24:00", "2016-12-16 12:00", "2016-12-17 12:00", null,
//				1, new RoomInfoVO(RoomState.USABLE, RoomType.ROOM_STANDARD, "513", 99.9, "014"),1);
	}

	@Test
	public void testHotelOrderScan() throws RemoteException {
		ArrayList<OrderVO> hotels = onHotelBLService.hotelOrderScan("5000");
		assertEquals(hotels.get(0).getOrderID(), hotelList.get(0).getOrderID());
	}
	
	@Test
	public void testHotelOrderDetail() throws RemoteException{
		OrderVO order = onHotelBLService.hotelOrderDetail("60161002");
		assertEquals(order.getOrderState(), OrderState.UNEXECUTED);
	}
	
	@Test
	public void testHotelOrderModify() throws RemoteException{
		resultMsg = onHotelBLService.hotelOrderModify(order1);
		assertEquals(resultMsg, ResultMsg.SUCCESS);
		resultMsg = onHotelBLService.hotelOrderModify(order4);
		assertEquals(resultMsg, ResultMsg.SUCCESS);
		resultMsg = onHotelBLService.hotelOrderModify(order3);
		assertEquals(resultMsg, ResultMsg.SUCCESS);
	}

}
