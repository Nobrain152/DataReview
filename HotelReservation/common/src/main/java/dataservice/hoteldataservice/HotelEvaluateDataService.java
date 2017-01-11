package dataservice.hoteldataservice;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.ArrayList;

import po.HotelEvaluatePO;
import util.ResultMsg;

public interface HotelEvaluateDataService extends Remote {

	/**
	 * 增加
	 * @param po
	 * @return
	 * @throws RemoteException
	 */
	public ResultMsg insert(HotelEvaluatePO po) throws RemoteException;
	
		/**
	 * 根据订单ID查找
	 * @param ID
	 * @return
	 * @throws RemoteException
	 */
	public HotelEvaluatePO findByID(String ID) throws RemoteException;
	
	/**
	 * 显示
	 * @return ArrayList<HotelEvaluatePO>
	 * @throws RemoteException
	 */
	public ArrayList<HotelEvaluatePO> show(String hotelid) throws RemoteException;




}	