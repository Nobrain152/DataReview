package blservice.hotelblservice;

import java.rmi.RemoteException;
import java.util.ArrayList;

import po.RoomInfoPO;
import util.ResultMsg;
import util.RoomType;
import vo.RoomInfoVO;

/**
 * 添加可用客房的接口
 * @author 曹畅
 *
 */
public interface RoomAddBLService {
	
	/**
	 * 添加可用客房
	 * @param roomInfoVO
	 * @return
	 */
	public ResultMsg addRoom(RoomInfoVO roomInfoVO);
	
	/**
	 * 更新客房信息
	 * @param roomInfoVO
	 * @return
	 */
    public ResultMsg updateRoom(RoomInfoVO roomInfoVO);
    
    /**
	 * 根据酒店ID查看酒店房间列表
	 * @param hotelID
	 * @return
	 */
	public ArrayList<RoomInfoVO> HotelRoomSearch(String hotelID);
	
	/**
	 * 修改酒店房间列表
	 * @param hotelid
	 * @param po
	 * @return
	 */
	public ResultMsg HotelRoomMod(String hotelid,ArrayList<RoomInfoVO> po);
   
	
	/**
	 * 根据输入的时间判断酒店这一时间段可预订的空房
	 * @param hotelid
	 * @param intime
	 * @param outtime
	 * @return
	 * @throws RemoteException
	 */

	public ArrayList<RoomInfoVO> getEmptyRoom(String hotelid);
	
	/**
	 * 返回特定房间类型的空房间列表
	 * @param hotelid
	 * @param intime
	 * @param outtime
	 * @param type
	 * @return
	 * @throws RemoteException
	 */
	public ArrayList<RoomInfoVO> getTypeRoom(String hotelid,RoomType type);

	public RoomInfoPO findByRoomID(String string);

	public void update(RoomInfoPO roomInfoPO);

	
}