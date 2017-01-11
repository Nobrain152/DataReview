package data;

import static org.junit.Assert.*;

import java.rmi.RemoteException;
import java.util.ArrayList;

import org.junit.Before;
import org.junit.Test;

import data.userdata.LoginInpoData;
import po.LoginInPO;

public class LoginInDataTest {
	LoginInpoData impl;
	ArrayList<LoginInPO> pos ;
	LoginInPO po1,po2,po3;
	
	@Before
	public void setUp() throws RemoteException{
		impl = new LoginInpoData();
		po1 = new LoginInPO("123", "456");
		po2 = new LoginInPO("789", "123");
		po3 = new LoginInPO("abc", "def");
		pos = new ArrayList<LoginInPO>();
	}
	@Test
	public void testAdd() throws RemoteException{
		impl.addToSQL(po1);
		impl.addToSQL(po2);
		impl.addToSQL(po3);
	}
	@Test
	public void testFind() throws RemoteException{
		LoginInPO po = impl.findLoginPO("abc");
		assertEquals(po.getPassword(),po3.getPassword());
	}
	
	@Test
	public void testShow() throws RemoteException{
		ArrayList<LoginInPO> loginInPOs = new ArrayList<>();
		pos = impl.show();
		loginInPOs.add(po1);
		loginInPOs.add(po2);
		loginInPOs.add(po3);
		assertEquals(loginInPOs.get(0).getPassword(),pos.get(0).getPassword());
	}
}
