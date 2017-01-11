package hotel;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;

import org.junit.Before;
import org.junit.Test;

import bl.hotelbl.RoomAddController;
import util.ResultMsg;
import util.RoomState;
import util.RoomType;
import vo.RoomInfoVO;
//pass
public class RoomAddControllerTest {

	RoomAddController impl;
	ArrayList<RoomInfoVO> roomList;
	RoomInfoVO room1;
	RoomInfoVO room2;
	RoomInfoVO room3;
	RoomInfoVO room4;
	
	ResultMsg roomMsg;
	ResultMsg reMsg1;
	ResultMsg reMsg2;
	
	
	
	@Before
	public void setUp() {
		room1=new RoomInfoVO(RoomState.USABLE,RoomType.ROOM_STANDARD,"461",199,"5000");
		room2=new RoomInfoVO(RoomState.USABLE,RoomType.ROOM_STANDARD,"461",1435,"5000");
		room3=new RoomInfoVO(RoomState.USABLE,RoomType.ROOM_BIGBED,"02",233,"1234567");
		room4=new RoomInfoVO(RoomState.USABLE,RoomType.ROOM_PRESIDENTIAL,"22",159999,"1234567");
				
				
		impl = new RoomAddController();
		
		roomList = impl.roomList;
		roomList.add(room1);
		roomList.add(room2);
		roomList.add(room3);
		roomList.add(room4);
		
		
		roomMsg = ResultMsg.SUCCESS;
		reMsg1 = ResultMsg.SUCCESS;
		reMsg2 = ResultMsg.FAIL;
	}

	@Test
	public  void  testaddRoom(){
		ResultMsg msg1 = impl.addRoom(room1);
		assertEquals(msg1, roomMsg);
		
	}
	
	@Test
	public void testupdateRoom(){
		ResultMsg msg1 = impl.updateRoom(room2); 
		assertEquals(msg1, reMsg1);
    }
	
	@Test
	public void testsearch(){
		ArrayList<RoomInfoVO> all=impl.HotelRoomSearch("5002");
		assertEquals(all.get(0).getRoomID(),"454");
	}
}
