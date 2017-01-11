package data;

import static org.junit.Assert.assertEquals;

import java.rmi.RemoteException;
import java.util.ArrayList;

import org.junit.Before;
import org.junit.Test;

import data.hoteldata.HotelInfoDataServiceImpl;
import po.HotelInfoPO;
import util.Adress;
import util.Area;
import util.ResultMsg;

public class HotelInfoDataServiceImplTest {

	HotelInfoDataServiceImpl impl;
	ArrayList<HotelInfoPO> list;
	HotelInfoPO hotel1;
	HotelInfoPO hotel2;
	HotelInfoPO hotel3;
	HotelInfoPO hotel4;
	
	@Before
	public void setUp() throws RemoteException{
		impl = new HotelInfoDataServiceImpl();
		hotel1=new HotelInfoPO("5001","StarHotel",Adress.BEIJING,Area.EAST,5,"It's a wonderful hotel","cafe, garden and so on",
				true,66.6,200);
		hotel2=new HotelInfoPO("5003","SunHotel",Adress.NANJING,Area.NORTH,4,"It's a nice hotel","cafe",
				false,77.77,100);
		hotel3=new HotelInfoPO("5004","MoonHotel",Adress.SHANGHAI,Area.SOUTH,3,"It's a terrible hotel","nothing",
				true,88.88,300);
		
		list = new ArrayList<HotelInfoPO>();
	}
	@Test
	public void testInsert() throws RemoteException{
		String b = impl.insert(hotel2);
		String c = impl.insert(hotel3);
		assertEquals(b, "5003");
		assertEquals(c, "5004");
	}
	
	
	
	@Test
	public void testUpdate() throws RemoteException{
		impl.insert(hotel1);
		hotel1.setName("adsfklasjfl ");;
		ResultMsg b = impl.update(hotel1);
		assertEquals(b, ResultMsg.SUCCESS);
	}
	
	@Test
	public void testFind() throws RemoteException{
		HotelInfoPO arrayList = impl.find("5004");
		assertEquals(arrayList.getName(), "MoonHotel");
	}
	
	@Test
	public void testShow() throws RemoteException{
	}
	
	@Test
	public void testFindByAreaAndCircle() throws RemoteException{
		ArrayList<HotelInfoPO> po = impl.findByAreaAndCircle(Adress.BEIJING, Area.EAST);
		assertEquals(po.get(1).getName(), "SunHotel");
	}

	
	@Test
	public void testFindByName() throws RemoteException{
		ArrayList<HotelInfoPO> pos = impl.findByName("LALALA");
		assertEquals(pos.get(1).getHotelID(), "5002");
	}
	
	
}
