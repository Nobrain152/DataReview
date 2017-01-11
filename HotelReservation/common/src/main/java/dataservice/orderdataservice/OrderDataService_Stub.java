package dataservice.orderdataservice;

import java.rmi.RemoteException;
import java.util.ArrayList;

import po.OrderPO;
import util.ResultMsg;


/**
 * Created by txin15 on 16/10/15.
 */
public class OrderDataService_Stub implements OrderDataService {

	@Override
	public String insert(OrderPO po) throws RemoteException {
		return null;
	}


	@Override
	public ResultMsg delete(String ID) throws RemoteException {
		return ResultMsg.SUCCESS;
	}


	@Override
	public ResultMsg update(OrderPO po) throws RemoteException {
		return ResultMsg.SUCCESS;
	}


	@Override
	public OrderPO findByOrderID(String ID) throws RemoteException {
		return null;
	}


	@Override
	public ArrayList<OrderPO> findByUserID(String ID) throws RemoteException {
		return null;
	}


	@Override
	public ArrayList<OrderPO> findByHotelID(String ID) throws RemoteException {
		return null;
	}


	@Override
	public ArrayList<OrderPO> showList() throws RemoteException {
		return null;
	}
}
