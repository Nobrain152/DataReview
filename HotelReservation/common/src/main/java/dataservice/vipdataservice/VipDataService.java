package dataservice.vipdataservice;

import java.awt.Window.Type;
import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.ArrayList;

import po.BusinessVipPO;
import po.CommonVipPO;
import po.LevelSystemPO;
import util.ResultMsg;

/**
 * vip数据层接口
 * @author kevin
 *
 */

public interface VipDataService extends Remote{
	
	public ResultMsg insertC(CommonVipPO vip) throws RemoteException;
	
	public ResultMsg insertL(LevelSystemPO levelSystemPO) throws RemoteException;
	
	public LevelSystemPO findL(int level) throws RemoteException;
	
	public ResultMsg delete(String userid) throws RemoteException;
	
	public ResultMsg updateC(CommonVipPO vip) throws RemoteException;
	
//	public CommonVipPO findByLevelC(int level,Type type) throws RemoteException;
	
	public CommonVipPO findByUserIDC(String id) throws RemoteException;
	
	public ArrayList<CommonVipPO> showC(Type type) throws RemoteException;
	
	public ResultMsg insertB(BusinessVipPO vip) throws RemoteException;
	
	public ResultMsg updateB(BusinessVipPO vip) throws RemoteException;
	
//	public BusinessVipPO findByLevelB(int level,Type type) throws RemoteException;
	
	public BusinessVipPO findByUserIDB(String id) throws RemoteException;
	
	public ArrayList<BusinessVipPO> showB(Type type) throws RemoteException;
	
	public ResultMsg update(LevelSystemPO levelSystemPO) throws RemoteException;

	public ArrayList<LevelSystemPO> getLevelSystemPO() throws RemoteException;
}
