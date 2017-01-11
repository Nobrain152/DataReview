package data;


import static org.junit.Assert.assertEquals;

import java.rmi.RemoteException;

import javax.lang.model.element.Parameterizable;

import org.junit.Before;
import org.junit.Test;

import data.userdata.UserManagementDataServiceImpl;
import po.CustomerInfoPO;
import po.LoginInPO;
import util.ResultMsg;
import util.VipType;

public class UserManagementDataServiceImplTest {

	UserManagementDataServiceImpl impl ;
	LoginInPO log;
	CustomerInfoPO po;
	
	@Before
	public void setUp() throws RemoteException{
		impl=new UserManagementDataServiceImpl();
		po = new CustomerInfoPO("19954722", "ÌÆöÎ", "18805156300", "sfd", 300, true, VipType.COMMON_VIP);
	}
	
	@Test
	public void test() throws RemoteException{
		String ID = impl.addCustomer(po);
		assertEquals(ID, "60000055");
	}
	
	@Test
	public void testGetLoginInfo() throws RemoteException{
		assertEquals(impl.getLoginInfo("123"),"456");
	}
	
	@Test
	public void testGetCustomerInfo() throws RemoteException{
		CustomerInfoPO ans = impl.getCustomerInfo("19954722");
		assertEquals(ans.getUsername(), po.getUsername());
	}
	
	@Test
	public void testAddUser() throws RemoteException{
		//assertEquals(impl.AddUser(po),"000000000");
	}
	
	
	
	@Test
	public void testGetUserBaseInfo() throws RemoteException{
		//assertEquals(impl.GetUserBaseInfo(po),null);
	}

	@Test
	public void testSetUserBaseInfo() throws RemoteException{
		//UserInfoPO v=new UserInfoPO("123456798","Lily",new ContactPO("12345678765",null));
		//assertEquals(impl.SetUserBaseInfo(po, v),true);
	}
	
	@Test
	public void testSeTCustomerInfo() throws RemoteException{
		CustomerInfoPO po = new CustomerInfoPO("10000065", "kevin", "18805156300", "sfd", 400, true, null);
		ResultMsg aMsg = impl.updateCustomerInfo("10000065", po);
		assertEquals(aMsg, ResultMsg.SUCCESS);
	}
	
	@Test
	public void testaddHotelStuff() throws RemoteException{
		//assertEquals(impl.addHotelStuff(o,po),true);
	}
	
	public void testaddWebStuff() throws RemoteException{
		//assertEquals(impl.addWebStuff(po),true);
	}
}
