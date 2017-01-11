package dataservice.hoteldataservice;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.ArrayList;

import po.HotelInfoPO;
import util.Adress;
import util.Area;
import util.ResultMsg;

public interface HotelInfoDataService extends Remote{
	
	/**
	 * 增加
	 */
	public String insert(HotelInfoPO po) throws RemoteException;
	
	
	
	/**
	 * 更新
	 */
	public ResultMsg update(HotelInfoPO po) throws RemoteException;
	
	/**
	 * 查找
	 */
	public HotelInfoPO find(String ID) throws RemoteException;

	/**
	 * 根据订单ID查找
	 * @param ID
	 * @return
	 * @throws RemoteException
	 */
	
	/**
	 * 显示
	 */
	public ArrayList<HotelInfoPO> show() throws RemoteException;
	
	/**
	 * 根据地址和商圈搜索酒店
	 * @param area
	 * @param circle
	 * @return
	 */
	public ArrayList<HotelInfoPO> findByAreaAndCircle(Adress area,Area circle) throws RemoteException;
	
	/**
	 * 根据酒店的名称搜索酒店
	 * @param name
	 * @return
	 */
	public ArrayList<HotelInfoPO> findByName(String name) throws RemoteException;




}