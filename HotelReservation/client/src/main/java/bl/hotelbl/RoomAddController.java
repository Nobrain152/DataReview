package bl.hotelbl;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.ArrayList;

import bl.BusinessController;
import blservice.hotelblservice.RoomAddBLService;
import dataservice.hoteldataservice.RoomInfoDataService;
import net.RMIManage;
import po.RoomInfoPO;
import util.DataServiceType;
import util.ResultMsg;
import util.RoomType;
import vo.RoomInfoVO;

/**
 * 
 * @author 曹畅
 *
 */
public class RoomAddController extends BusinessController implements RoomAddBLService{
	public ArrayList<RoomInfoVO> roomList;
	private RoomAdd roomAdd;
	private RoomInfoDataService roomInfoData;
	
	public RoomAddController() {
		roomList = new ArrayList<RoomInfoVO>();
		roomInfoData = (RoomInfoDataService) RMIManage
				.getDataService(DataServiceType.RoomInfoDataService);
		roomAdd = new RoomAdd(roomInfoData);
	}
	
	/**
	 * 添加客房
	 * @param roomInfoVO
	 * @return
	 * @throws RemoteException
	 */
	@Override
	public ResultMsg addRoom(RoomInfoVO roomInfoVO){
		try {
			return roomAdd.addRoom(roomInfoVO);
		} catch (RemoteException  e) {
			e.printStackTrace();
		}
		return null;
	}

	/**
	 * 更新客房信息
	 * @param roomInfoVO
	 * @return
	 * @throws RemoteException
	 */
	@Override
    public ResultMsg updateRoom(RoomInfoVO roomInfoVO){
		try {
			return roomAdd.updateRoom(roomInfoVO);
		} catch (RemoteException  e) {
			e.printStackTrace();
		}
		return null;
    }
	
	/**
	 * 根据酒店ID查看酒店房间列表
	 * @param hotelID
	 * @return
	 */
	public ArrayList<RoomInfoVO> HotelRoomSearch(String hotelID){
		try {
			return roomAdd.HotelRoomSearch(hotelID);
		} catch (RemoteException e) {
			return null;
		}
	}
	
	/**
	 * 修改酒店房间列表
	 * @param hotelid
	 * @param po
	 * @return
	 */
	public ResultMsg HotelRoomMod(String hotelid,ArrayList<RoomInfoVO> vo){
		try {
			return roomAdd.HotelRoomMod(hotelid, vo);
		} catch (RemoteException e) {
			return ResultMsg.FAIL;
		}
	}
	
	/**
	 * 根据输入的时间判断酒店这一时间段可预订的空房
	 * @param hotelid
	 * @param intime
	 * @param outtime
	 * @return
	 * @throws RemoteException
	 */
	public ArrayList<RoomInfoVO> getEmptyRoom(String hotelid){
		try {
			return roomAdd.getEmptyRoom(hotelid);
		} catch (RemoteException e) {
			return null;
		}
	}
	
	/**
	 * 返回特定房间类型的空房间列表
	 * @param hotelid
	 * @param intime
	 * @param outtime
	 * @param type
	 * @return
	 * @throws RemoteException
	 */
	public ArrayList<RoomInfoVO> getTypeRoom(String hotelid,RoomType type){
		try {
			return roomAdd.getTypeRoom(hotelid, type);
		} catch (RemoteException e) {
			
			e.printStackTrace();
			return null;
		}
	}

	@Override
	public RoomInfoPO findByRoomID(String string) {
		try {
			return roomAdd.findByRoomID(string);
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public void update(RoomInfoPO roomInfoPO) {
		try {
			roomAdd.update(roomInfoPO);
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	public void reinitDataService(Remote dataService) {
		roomInfoData = (RoomInfoDataService)dataService;
		roomAdd = new RoomAdd(roomInfoData);
		
	}
	
}