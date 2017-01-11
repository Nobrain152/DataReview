package dataservice.creditdataservice;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.ArrayList;

import po.CreditPO;
import util.ResultMsg;


public interface CreditDataService extends Remote {
	
	/**
	 * 插入一个信用值记录
	 * @param creditPO
	 * @return
	 * @throws RemoteException
	 */
	public ResultMsg insert(CreditPO creditPO) throws RemoteException;
	
	/**
	 * 获取该用户的信用值记录列表
	 * @param ID
	 * @return
	 * @throws RemoteException
	 */
	public ArrayList<CreditPO> getListByUserID(String userID) throws RemoteException;
	
	/**
	 * 获取该订单的信用值记录
	 * @param orderID
	 * @return
	 * @throws RemoteException
	 */
	public ArrayList<CreditPO> getListByOrderID(String orderID) throws RemoteException;
	
	/**
	 * 显示所有记录
	 * @return
	 * @throws RemoteException
	 */
	public ArrayList<CreditPO> show() throws RemoteException;
	
}
