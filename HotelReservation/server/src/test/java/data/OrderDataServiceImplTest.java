package data;

import static org.junit.Assert.assertEquals;

import java.rmi.RemoteException;
import java.util.ArrayList;


import org.junit.Before;
import org.junit.Test;
import org.omg.PortableServer.IMPLICIT_ACTIVATION_POLICY_ID;

import data.orderdata.OrderDataServiceImpl;
import datafactory.DataFactory;
import dataservice.orderdataservice.OrderDataService;
import po.CustomerInfoPO;
import po.OrderPO;
import po.RoomInfoPO;
import util.OrderState;
import util.ResultMsg;
import util.RoomState;
import util.RoomType;
import util.VipType;

public class OrderDataServiceImplTest {

	OrderDataServiceImpl dataServiceImpl;
//	ArrayList<OrderPO> list;
	OrderPO order1;
	OrderPO order2;
	OrderPO order3;
	OrderPO order4;
	ArrayList<String> rooms;
	ArrayList<OrderPO> list;
	
	@Before
	public void setUp() throws RemoteException{
		dataServiceImpl = new OrderDataServiceImpl();
		order1 = new OrderPO("20161002", new CustomerInfoPO("19954722", "ÌÆöÎ", "sdf",
				"18805156300", 300, true, VipType.COMMON_VIP), 
				OrderState.UNEXECUTED, 99.9, "5002", false, 
				"2016-10-02 24:00", "2016-10-03 12:00", "2016-10-02 12:00", null,
				1,1, rooms,RoomType.ROOM_BIGBED);
//		order1 = new OrderPO("100001", new CustomerInfoPO("151250058","hkw", 
//				new ContactPO("13270898633", "814335296@qq.com"), 200, true,
//				VipType.COMPANY_VIP), OrderState.UNEXECUTED,
//				666.66, "151250", false, MyDate.toString(MyDate.getNowTime()),
//				MyDate.toString(MyDate.getNowTime()), MyDate.toString(MyDate.getNowTime()),
//				MyDate.toString(MyDate.getNowTime()),
//				1, 1, new RoomInfoPO(RoomState.USABLE, RoomType.ROOM_BIGBED, 
//				"3B323", 1000, "151250"));
		
		order2 =  new OrderPO("20161002", new CustomerInfoPO("100000066", "kevin", "sdf",
				"18805156300", 300, true, VipType.COMMON_VIP), 
				OrderState.UNEXECUTED, 99.9, "5002", false, 
				"2016-10-02 24:00", "2016-10-03 12:00", "2016-10-02 12:00", null,
				1,1, rooms,RoomType.ROOM_BIGBED);
		/*order1 = new OrderPO("100001", new CustomerInfoPO("151250058", "withoutBrain",
				new CreditPO("2016-11-11", "151250058", Action.Executed, 
				"creditChange", 200),100, false, VipType.COMMON_VIP), orderState, price, "1512500", false, 
				latestExecutionTime, checkInTime, checkOutTime, cancelledTime, 
				roomNumber, peopleNumber, roomInfoPO);
		*/
		/*order1 = new OrderPO(new CustomerInfoPO("123", "txin", 
				new ContactPO("18805156300", null), 100), 
				OrderState.UNEXECUTED, 100, "01", "513", false, 
				"2016-10-16 24:00", "2016-10-16 12:00", "2016-10-17 12:00", 
				1, 1, RoomType.ROOM_STANDARD);
		order2 = new OrderPO(new CustomerInfoPO("123", "txin", 
				new ContactPO("18805156300", null), 100), 
				OrderState.ABNORMAL, 100, "01", "513", false, 
				"2016-10-16 24:00", "2016-10-16 12:00", "2016-10-17 12:00", 
				1, 1, RoomType.ROOM_STANDARD);
		order3 = new OrderPO(new CustomerInfoPO("123", "txin", 
				new ContactPO("18805156300", null), 100), 
				OrderState.UNEXECUTED, 100, "01", "513", false, 
				"2016-10-16 24:00", "2016-10-16 12:00", "2016-10-17 12:00", 
				1, 1, RoomType.ROOM_STANDARD);
		order4 = new OrderPO(new CustomerInfoPO("123", "txin", 
				new ContactPO("18805156300", null), 100), 
				OrderState.CANCELLED, 100, "01", "513", false, 
				"2016-10-16 24:00", "2016-10-16 12:00", "2016-10-17 12:00", 
				1, 1, RoomType.ROOM_STANDARD);*/
//		list = new ArrayList<OrderPO>();
	}
	
	@Test
	public void testGetMsg() throws RemoteException{
		OrderPO orderPO = dataServiceImpl.findByOrderID("20161002");
		assertEquals(orderPO.getHotelID(), "5000");
	}
	
	@Test
	public void testInsert() throws RemoteException{
		String ans = dataServiceImpl.insert(order1);
		assertEquals(ans, "60000004");
	}
	
	
	
	@Test
	public void testDelete() throws RemoteException{
		ResultMsg b = dataServiceImpl.delete("60000003");
		assertEquals(b, ResultMsg.SUCCESS);
	}
	
	
	public void testFindByOrderID2() throws RemoteException{
		dataServiceImpl.insert(order1);
		dataServiceImpl.insert(order2);
		OrderPO order = dataServiceImpl.findByOrderID("100010");
	}
	
	
	@Test
	public void testFindByOrderID() throws RemoteException{
		dataServiceImpl.insert(order1);
		dataServiceImpl.insert(order2);
		System.out.println("³É¹¦");
		OrderPO arrayList = dataServiceImpl.findByOrderID(order1.getOrderID());
		System.out.println(arrayList.getHotelID());
		dataServiceImpl.delete(order1.getOrderID());
		dataServiceImpl.delete(order2.getOrderID());
		assertEquals(arrayList.getHotelID(), order1.getHotelID());
	}
	
	
	@Test
	public void testFindByUserID() throws RemoteException{
		dataServiceImpl.insert(order1);
		dataServiceImpl.insert(order2);
		ArrayList<OrderPO> arrayList = dataServiceImpl.findByUserID("45234");
		list.add(order1);
		list.add(order2);
		assertEquals(list.get(0), arrayList.get(0));
		assertEquals(list.get(1), arrayList.get(1));
	}
	
	@Test
	public void testFindByHotelID() throws RemoteException{
		dataServiceImpl.insert(order1);
		dataServiceImpl.insert(order2);
		ArrayList<OrderPO> arrayList = dataServiceImpl.findByUserID("45234");
		list.add(order1);
		list.add(order2);
		assertEquals(list.get(0), arrayList.get(0));
		assertEquals(list.get(1), arrayList.get(1));
	}
	
	@Test
	public void testShowList2() throws RemoteException{
		dataServiceImpl.insert(order1);
		dataServiceImpl.insert(order2);
		dataServiceImpl.insert(order3);
		dataServiceImpl.insert(order4);
		list.add(order1);
		list.add(order2);
		list.add(order3);
		list.add(order4);
		ArrayList<OrderPO> arrayList = dataServiceImpl.showList();
		assertEquals(list, arrayList);
	}
	
	@Test
	public void testFindByID() throws RemoteException{
		OrderPO po = dataServiceImpl.findByOrderID("60000004");
		assertEquals(po.getHotelID(), "5000");
	}
	
	@Test 
	public void testShowList() throws RemoteException{
		ArrayList<OrderPO> arrayList = dataServiceImpl.showList();
		assertEquals(arrayList.get(0).getHotelID(), "5000");
	}
	
	@Test
	public void testUpdate() throws RemoteException{
		OrderPO po = dataServiceImpl.findByOrderID("60161002");
		po.setOrderState(OrderState.ABNORMAL);
		ResultMsg resultMsg = dataServiceImpl.update(po);
		assertEquals(ResultMsg.SUCCESS, resultMsg);
	}
	
}
