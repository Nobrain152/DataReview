package dataservice.creditdataservice;

import java.rmi.RemoteException;
import java.util.ArrayList;

import po.CreditPO;
import util.ResultMsg;

public class CreditDataService_Stub implements CreditDataService{

	@Override
	public ResultMsg insert(CreditPO creditPO) throws RemoteException {
		return ResultMsg.SUCCESS;
	}

	@Override
	public ArrayList<CreditPO> getListByUserID(String userID) throws RemoteException {
		return null;
	}

	@Override
	public ArrayList<CreditPO> getListByOrderID(String orderID) throws RemoteException {
		return null;
	}

	@Override
	public ArrayList<CreditPO> show() throws RemoteException {
		return null;
	}
	

	
}