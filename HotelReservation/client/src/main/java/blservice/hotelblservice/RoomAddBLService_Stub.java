package blservice.hotelblservice;

import java.util.ArrayList;

import po.RoomInfoPO;
import util.ResultMsg;
import util.RoomState;
import util.RoomType;
import vo.RoomInfoVO;

public class RoomAddBLService_Stub implements RoomAddBLService{

	
	ArrayList<RoomInfoVO> aa;
	RoomInfoPO po;
	
	public RoomAddBLService_Stub() {
		aa=new ArrayList<RoomInfoVO>();
		po=new RoomInfoPO(RoomState.USABLE,RoomType.ROOM_BIGBED,"456",120,"5000");
	}
	@Override
	public ResultMsg addRoom(RoomInfoVO roomInfoVO) {
		
		return ResultMsg.SUCCESS;
	}

	@Override
	public ResultMsg updateRoom(RoomInfoVO roomInfoVO) {
		
		return ResultMsg.SUCCESS;
	}

	@Override
	public ArrayList<RoomInfoVO> HotelRoomSearch(String hotelID) {
		
		return aa;
	}

	@Override
	public ResultMsg HotelRoomMod(String hotelid, ArrayList<RoomInfoVO> po) {
		
		return ResultMsg.SUCCESS;
	}

	@Override
	public ArrayList<RoomInfoVO> getEmptyRoom(String hotelid) {
		
		return aa;
	}

	@Override
	public ArrayList<RoomInfoVO> getTypeRoom(String hotelid, RoomType type) {
		
		return aa;
	}

	@Override
	public RoomInfoPO findByRoomID(String string) {
		
		return po;
	}

	@Override
	public void update(RoomInfoPO roomInfoPO) {
		
	}

}
