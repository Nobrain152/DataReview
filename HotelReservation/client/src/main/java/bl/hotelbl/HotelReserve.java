package bl.hotelbl;

import java.rmi.RemoteException;
import java.util.ArrayList;

import bl.BusinessLogicDataFactory;
import dataservice.hoteldataservice.HotelInfoDataService;
import util.ResultMsg;
import util.RoomState;
import vo.OrderVO;
import vo.RoomInfoVO;


/**
 * Ô¤¶©¾Æµê
 * @author ²Ü³©
 *
 */
public class HotelReserve {
	private HotelInfoDataService hotelInfoData;
	private RoomAddController roomcon;
	private BusinessLogicDataFactory factory=BusinessLogicDataFactory.getFactory();
	
	public HotelReserve(HotelInfoDataService hotelInfoDataService){
		this.hotelInfoData=hotelInfoDataService;
	}
	
	/**
	 * Ô¤¶©¾Æµê²¢ÐÞ¸Ä·¿¼äÐÅÏ¢
	 * @param vo
	 * @return
	 * @throws RemoteException
	 */
	public ResultMsg reserveHotel(OrderVO vo) throws RemoteException{
		int cre=vo.getInitiator().getCredit();
		if(cre<0){
			//System.out.println("here");
			return ResultMsg.FAIL;
		}
		String hotelid=vo.getHotelID();
		int number=vo.getRoomNumber();
		roomcon=(RoomAddController)factory.getRoomAddBLService();
		ArrayList<RoomInfoVO> room=roomcon.HotelRoomSearch(hotelid);
		//System.out.println(room.size());
		for(int i=0;i<room.size();i++ ){
			RoomInfoVO v=room.get(i);
			if(v.getType()==vo.getRoomType()){
				//System.out.println("here");
				if(v.getState()==RoomState.USABLE){
					v.setState(RoomState.UNUSABLE);
					room.set(i,v);
					number--;
					if(number==0){
						roomcon.HotelRoomMod(hotelid, room);
						return ResultMsg.SUCCESS;
					}	
				}
			}
		}
		//System.out.println(number);
		return ResultMsg.FAIL;
	}
	

}
