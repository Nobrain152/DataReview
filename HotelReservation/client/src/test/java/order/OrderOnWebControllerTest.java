package order;

import static org.junit.Assert.assertEquals;

import java.rmi.RemoteException;
import java.util.ArrayList;

import org.junit.Before;
import org.junit.Test;

import bl.orderbl.OrderOnWebController;
import util.OrderState;
import util.ResultMsg;
import util.RoomType;
//import util.RoomState;
//import util.RoomType;
import util.VipType;
import vo.CustomerInfoVO;
import vo.OrderVO;
//import vo.RoomInfoVO;

public class OrderOnWebControllerTest {

	OrderOnWebController webBLServiceImpl;
	ArrayList<OrderVO> webList;
	OrderVO order1,order2,order3,order4;
	ResultMsg resultMsg;
	
	@Before
	public void setUp(){
		webBLServiceImpl = new OrderOnWebController();
		webList = new ArrayList<>();
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
//		order2 = new OrderVO("20161005", new CustomerInfoVO("19954722", "txin", "ve",
//				"18805156300", 300, true, VipType.COMMON_VIP), 
//				OrderState.UNEXECUTED, 99.9, "5000", false, 
//				"2016-12-16 24:00", "2016-12-16 12:00", "2016-12-17 12:00", null,
//				1, new RoomInfoVO(RoomState.USABLE, RoomType.ROOM_STANDARD, "513", 99.9, "5000"),1);
		order3 = new OrderVO("60161004", new CustomerInfoVO("19954722", "txin", "ve",
				"18805156300", 300, true, VipType.COMMON_VIP), 
				OrderState.ABNORMAL, 99.9, "014", false, 
				"2016-10-04 24:00", "2016-10-04 12:00", "2016-10-05 12:00", null,
				1,arrayList2,1,RoomType.ROOM_STANDARD);
		order4 = new OrderVO("60161003", new CustomerInfoVO("19954722", "txin", "ve",
				"18805156300", 300, true, VipType.COMMON_VIP), 
				OrderState.EXECUTED, 99.9, "5000", false, 
				"2016-10-03 24:00", "2016-10-03 12:00", "2016-10-04 12:00", null,
				1, arrayList3,1,RoomType.ROOM_STANDARD);

		webList.add(order1);
//		webList.add(order2);
		webList.add(order3);
		webList.add(order4);
		
		resultMsg = ResultMsg.SUCCESS;
	}
	
	@Test
	public void testAbnormalOrderScan() throws RemoteException{
		ArrayList<OrderVO> webs = webBLServiceImpl.abnormalOrderScan();
		assertEquals(webs.get(0).getOrderID(), order3.getOrderID());
	}
	
	@Test
	public void testAbnormalOrderDetail() throws RemoteException{
		OrderVO m1 = webBLServiceImpl.abnormalOrderDetail("60161004");
		assertEquals(m1.getCheckInTime(), order3.getCheckInTime());
	}
	
	@Test
	public void testDayUnexOrder() throws RemoteException{
		ArrayList<OrderVO> vos = webBLServiceImpl.dayUnexOrder("2016-12-23");
		assertEquals(vos.get(0).getOrderID(), order1.getOrderID());
	}

}
