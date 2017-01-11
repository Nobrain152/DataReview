package blservice.hotelblservice;

import java.util.ArrayList;

import po.RoomInfoPO;
import util.ResultMsg;
import util.RoomType;
import vo.RoomInfoVO;

public class RoomAddBLService_Driver {

	  public static void main(String[] args){
			
		  RoomAddBLService a=new RoomAddBLService_Stub();
		  RoomAddBLService_Driver b=new RoomAddBLService_Driver();
			b.drive(a);
		
		}
		
		public void drive(RoomAddBLService a){
			ResultMsg resultMsg=a.addRoom(new RoomInfoVO());
			resultMsg=a.updateRoom(new RoomInfoVO());
			ArrayList<RoomInfoVO> arrayList=a.HotelRoomSearch("5000");
			arrayList=a.getEmptyRoom("5000");
			arrayList=a.getTypeRoom("5000",RoomType.ROOM_BIGBED);
			RoomInfoPO po=a.findByRoomID("456");
			a.update(new RoomInfoPO());
		
		}
}
