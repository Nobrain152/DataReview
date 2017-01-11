package data;

import static org.junit.Assert.*;
import java.rmi.RemoteException;
import java.util.ArrayList;
import org.junit.Before;
import org.junit.Test;

import data.creditdata.CreditDataServiceImpl;
import po.CreditPO;
import util.Action;
import util.ResultMsg;

public class CreditDataServiceImplTest {
	
	CreditDataServiceImpl impl;
	ArrayList<CreditPO> pos;
	CreditPO credit1,credit2,credit3;
	ResultMsg a;
	private ArrayList<CreditPO> ans = new ArrayList<CreditPO>();
	
	@Before
	public void setUp() throws RemoteException{
		impl = new CreditDataServiceImpl();
		credit1 = new CreditPO("151250058", "60000000", "2016-12-09-08-00", Action.Executed,
					"+100", 5000);
		credit2 = new CreditPO("151250059", "60000001", "2016-12-09-08-00", Action.Executed,
				"+100", 5000);
		credit3 = new CreditPO("151250058", "60000001", "2016-12-09-08-00", Action.Executed,
				"+100", 5000);
		pos = new ArrayList<CreditPO>();
	}
	
	@Test
	public void testAdd() throws RemoteException{
		a = impl.insert(credit1);
		impl.insert(credit2);
		impl.insert(credit3);
		assertEquals(a, ResultMsg.SUCCESS);
	}
	
	@Test
	public void testGetListByUserID() throws RemoteException{
		ArrayList<CreditPO> pos = impl.getListByUserID("151250058");
		assertEquals(credit1.getOrderID(), pos.get(0).getOrderID());
		assertEquals(credit3.getOrderID(), pos.get(1).getOrderID());
	}
	
	@Test
	public void testshow() throws RemoteException{
		pos = impl.show();
		ans= new ArrayList<CreditPO>();
		ans.add(credit1);
		ans.add(credit2);
		ans.add(credit3);
		assertEquals(pos.get(0).getOrderID(), ans.get(0).getOrderID());
		assertEquals(pos.get(1).getOrderID(), ans.get(1).getOrderID());
		assertEquals(pos.get(2).getOrderID(), ans.get(2).getOrderID());
	}
	
	@Test
	public void testGetListByOrderID() throws RemoteException{
		ArrayList<CreditPO> pos = impl.getListByOrderID("60000001");
		ans.add(credit2);
		ans.add(credit3);
		assertEquals(pos.get(0).getUserID(), ans.get(0).getUserID());
		assertEquals(pos.get(1).getUserID(), ans.get(1).getUserID());
	}

}
