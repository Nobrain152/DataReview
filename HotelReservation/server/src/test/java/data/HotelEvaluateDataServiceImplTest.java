package data;

import static org.junit.Assert.assertEquals;

import java.rmi.RemoteException;
import java.util.ArrayList;

import org.junit.Before;
import org.junit.Test;

import data.hoteldata.HotelEvaluateDataServiceImpl;
import po.HotelEvaluatePO;
import util.ResultMsg;

public class HotelEvaluateDataServiceImplTest {
	

	HotelEvaluateDataServiceImpl impl;
	ArrayList<HotelEvaluatePO> list;
	HotelEvaluatePO evaluation1;
	HotelEvaluatePO evaluation2;
	
	@Before
	public void setUp() throws RemoteException{
		impl = new HotelEvaluateDataServiceImpl();
		evaluation1=new HotelEvaluatePO("151250058","20000001",10,"execellent",true,"60000000");
		evaluation2=new HotelEvaluatePO("151250059","20000002",8,"very good",false,"60000001");
		list = new ArrayList<HotelEvaluatePO>();
	}
	
	@Test
	public void testInsert() throws RemoteException{
		ResultMsg b = impl.insert(evaluation1);
		impl.insert(evaluation2);
		assertEquals(b, ResultMsg.SUCCESS);
	}
	
	@Test
	public void testFindByID() throws RemoteException{
		impl.insert(evaluation1);
		HotelEvaluatePO po= impl.findByID("60000000");
		assertEquals(po.getHotelID(), "20000001");
		assertEquals(po.getScore(), 10);
		assertEquals(po.getComment(), "execellent");
		assertEquals(po.getIsReserved(), true);
		assertEquals(po.getOrderID(), "60000000");
	}
	
	

	@Test
	public void testShow() throws RemoteException{
		impl.insert(evaluation1);
		ArrayList<HotelEvaluatePO> pos= impl.show("20000001");
		assertEquals(pos.get(0).getHotelID(), "20000001");
		assertEquals(pos.get(0).getScore(), 10);
		assertEquals(pos.get(0).getComment(), "execellent");
		assertEquals(pos.get(0).getIsReserved(), true);
		assertEquals(pos.get(0).getOrderID(), "60000000");
	}
	
	

}
