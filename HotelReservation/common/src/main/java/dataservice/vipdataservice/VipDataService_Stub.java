package dataservice.vipdataservice;

import java.awt.Window.Type;
import java.rmi.RemoteException;
import java.util.ArrayList;
import po.BusinessVipPO;
import po.CommonVipPO;
import po.LevelSystemPO;
import util.ResultMsg;

public class VipDataService_Stub implements VipDataService{

	public VipDataService_Stub(){

	}

	@Override
	public ResultMsg insertC(CommonVipPO vip) throws RemoteException {
		return ResultMsg.SUCCESS;
	}

	@Override
	public ResultMsg insertL(LevelSystemPO levelSystemPO) throws RemoteException {
		return ResultMsg.SUCCESS;
	}

	@Override
	public LevelSystemPO findL(int level) throws RemoteException {
		return null;
	}

	@Override
	public ResultMsg delete(String userid) throws RemoteException {
		return ResultMsg.SUCCESS;
	}

	@Override
	public ResultMsg updateC(CommonVipPO vip) throws RemoteException {
		return ResultMsg.SUCCESS;
	}

	@Override
	public CommonVipPO findByUserIDC(String id) throws RemoteException {
		return null;
	}

	@Override
	public ArrayList<CommonVipPO> showC(Type type) throws RemoteException {
		return null;
	}

	@Override
	public ResultMsg insertB(BusinessVipPO vip) throws RemoteException {
		return ResultMsg.SUCCESS;
	}

	@Override
	public ResultMsg updateB(BusinessVipPO vip) throws RemoteException {
		return ResultMsg.SUCCESS;
	}

	@Override
	public BusinessVipPO findByUserIDB(String id) throws RemoteException {
		return null;
	}

	@Override
	public ArrayList<BusinessVipPO> showB(Type type) throws RemoteException {
		return null;
	}

	@Override
	public ResultMsg update(LevelSystemPO levelSystemPO) throws RemoteException {
		return ResultMsg.SUCCESS;
	}

	@Override
	public ArrayList<LevelSystemPO> getLevelSystemPO() throws RemoteException {
		return null;
	}

	
}