package data;

import static org.junit.Assert.assertEquals;

import java.rmi.RemoteException;
import java.util.ArrayList;

import org.junit.Before;
import org.junit.Test;

import data.hoteldata.RoomInfoDataServiceImpl;
import po.RoomInfoPO;
import util.ResultMsg;
import util.RoomState;
import util.RoomType;

public class RoomInfoDataServiceImplTest {

	RoomInfoDataServiceImpl impl;
	ArrayList<RoomInfoPO> list;
	RoomInfoPO room1;
	RoomInfoPO room2;
	RoomInfoPO room3;
	RoomInfoPO room4;
	
	@Before
	public void setUp() throws RemoteException{
		impl = new RoomInfoDataServiceImpl();
		room1=new RoomInfoPO(RoomState.USABLE,RoomType.ROOM_STANDARD,"60161002",99.9,"5000");
		room2=new RoomInfoPO(RoomState.UNUSABLE,RoomType.ROOM_STANDARD,"453",1435,"12345678");
		room3=new RoomInfoPO(RoomState.USABLE,RoomType.ROOM_BIGBED,"455",233,"1234567");
		room4=new RoomInfoPO(RoomState.USABLE,RoomType.ROOM_PRESIDENTIAL,"435",159999,"1234567");
		list = new ArrayList<RoomInfoPO>();
	}
	
	@Test
	public void testInsert() throws RemoteException{
		ResultMsg b = impl.insert(room1);
		impl.insert(room2);
		impl.insert(room3);
		impl.insert(room4);
		assertEquals(b, ResultMsg.SUCCESS);
	}
	
	@Test
	public void testDelete() throws RemoteException{
		ResultMsg b = impl.delete(room1.getHotelid(),room1.getRoomID());
		assertEquals(b, ResultMsg.SUCCESS);
	}
	
	@Test
	public void testUpdate() throws RemoteException{
		room1.setRoomState(RoomState.UNUSABLE);
		ResultMsg b = impl.update(room1);
		assertEquals(b, ResultMsg.SUCCESS);
	}
	
	@Test
	public void testFindByRoomID() throws RemoteException{
		RoomInfoPO po = impl.findByRoomID("60161002");
		System.out.println(po);
		assertEquals(po.getHotelid(), "5000");
	}

	@Test
	public void testShow() throws RemoteException{
		list.add(room1);
		list.add(room2);
		list.add(room3);
		list.add(room4);
		ArrayList<RoomInfoPO> arrayList = impl.show();
		assertEquals(list.get(0).getHotelid(), arrayList.get(3).getHotelid());
	}
	
	@Test
	public void testHotelRoomSearch() throws RemoteException{
		ArrayList<RoomInfoPO> arrayList = impl.hotelRoomSearch("5002");
		assertEquals("5002", arrayList.get(0).getHotelid());
	}
}
