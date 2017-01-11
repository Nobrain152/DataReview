package dataservice.hoteldataservice;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.ArrayList;

import po.RoomInfoPO;
import util.ResultMsg;

public interface RoomInfoDataService extends Remote{
	
	/**
	 * 增加
	 */
	public ResultMsg insert(RoomInfoPO po) throws RemoteException;
		
	/**
	 * 删除
	 */
	public ResultMsg delete(String hotelid,String roomid) throws RemoteException;
	
	/**
	 * 更新
	 */
	public ResultMsg update(RoomInfoPO po) throws RemoteException;
	
	/**
	 * 查找
	 */
	public RoomInfoPO findByRoomID(String id) throws RemoteException;
	
	
	/**
	 * 显示
	 */
	public ArrayList<RoomInfoPO> show() throws RemoteException;
	
	/**
	 * 根据酒店ID查看酒店房间列表
	 * @param hotelID
	 * @return
	 * @throws RemoteException 
	 */
	public ArrayList<RoomInfoPO> hotelRoomSearch(String hotelID) throws RemoteException;
	
	



}