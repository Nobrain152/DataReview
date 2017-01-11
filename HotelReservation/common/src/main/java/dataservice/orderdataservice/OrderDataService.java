/**
 * 处理客户订单
 * @author txin
 * @date 2016/10/15
 */
package dataservice.orderdataservice;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.ArrayList;

import po.OrderPO;
import util.ResultMsg;

public interface OrderDataService extends Remote{

	/**
	 * 在数据库中插入单一持久化对象
	 * @param po
	 * @return
	 * @throws RemoteException
	 */
	public String insert(OrderPO po) throws RemoteException;

	/**
	 * 在数据库中删除单一持久化对象
	 * @param orderID
	 * @return
	 * @throws RemoteException
	 */
	public ResultMsg delete(String ID) throws RemoteException;

	/**
	 * 在数据库中更新单一持久化对象
	 * @param po
	 * @return
	 * @throws RemoteException
	 */
	public ResultMsg update(OrderPO po) throws RemoteException;
	
	/**
	 * 按订单ID进行查找返回相应的OrderPO结果
	 * @param ID
	 * @return
	 * @throws RemoteException
	 */
	public OrderPO findByOrderID(String ID) throws RemoteException;

	/**
	 * 按用户ID进行查找返回相应的OrderPO结果
	 * @param ID
	 * @return 该用户的所有订单
	 * @throws RemoteException
	 */
	public ArrayList<OrderPO> findByUserID(String ID) throws RemoteException;

	/**
	 * @param ID
	 * @return 该酒店的所有订单
	 * @throws RemoteException
	 */
	public ArrayList<OrderPO> findByHotelID(String ID) throws RemoteException;
	
	/**
	 * 返回所有订单PO
	 * @return
	 * @throws RemoteException
	 */
	public ArrayList<OrderPO> showList() throws RemoteException;
}
