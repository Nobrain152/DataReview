package data;


import static org.junit.Assert.assertEquals;

import java.rmi.RemoteException;
import java.util.ArrayList;

import org.junit.Before;
import org.junit.Test;

import com.mysql.cj.api.x.Result;

import data.userdata.CustomerManagementDataServiceImpl;
import po.CustomerInfoPO;
import util.ResultMsg;
import util.VipType;

public class CustomerManagementDataServiceImplTest {

	CustomerManagementDataServiceImpl impl;
	String id;
	CustomerInfoPO po ;
	
	@Before
	public void setUp() throws RemoteException{
		impl=new CustomerManagementDataServiceImpl();
		po = new CustomerInfoPO("19954722", "ÌÆöÎ", "18805156300", "sfd", 300, true, VipType.COMMON_VIP);
	}
	
	@Test
	public void testGetCustomerOrders() throws RemoteException{
		ArrayList<String> orders = impl.getCustomerOrders("19954722");
		assertEquals(orders.get(0), "600000007");
	}
	
	@Test
	public void testGetCustomerHotel() throws RemoteException{
		ArrayList<String> hotels = impl.getCustomerHotel("18805156300");
		assertEquals(hotels.get(0), "5002");
	}
	
	@Test
	public void testAddCustomerHotel() throws RemoteException{
		ResultMsg aMsg = impl.addCustomerHotel("10000066", "5003");
		assertEquals(ResultMsg.SUCCESS, aMsg);
	}
}
