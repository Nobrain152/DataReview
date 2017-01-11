package data;

import static org.junit.Assert.assertEquals;

import java.rmi.RemoteException;

import org.junit.Before;
import org.junit.Test;

import data.userdata.UserAndHotel;
import util.ResultMsg;

public class UserAndHotelTest {
	
	UserAndHotel po1,po2;
	
	@Before
	public void set() throws RemoteException{
		po1 = new UserAndHotel();
		po2 = new UserAndHotel();
	}
	
	@Test
	public void test() throws RemoteException{
		ResultMsg aMsg = po1.add("151250058", "3B323");
		ResultMsg bMsg = po2.add("151250058", "asfas");
		assertEquals(aMsg, ResultMsg.SUCCESS);
		assertEquals(bMsg, ResultMsg.SUCCESS);
	}
}
