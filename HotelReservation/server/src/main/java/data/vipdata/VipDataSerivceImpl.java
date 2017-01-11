	package data.vipdata;

import java.awt.Window.Type;
import java.rmi.RemoteException;
import java.sql.SQLException;
import java.util.ArrayList;


import dataSuper.DataSuperClass;
import datafactory.DataFactory;
import dataservice.userdataservice.CustomerManagementDataService;
import dataservice.vipdataservice.VipDataService;
import po.BusinessVipPO;
import po.CommonVipPO;
import po.CustomerInfoPO;
import po.LevelSystemPO;
import util.OrderState;
import util.ResultMsg;
import util.RoomType;
import util.VipType;

public class VipDataSerivceImpl extends DataSuperClass implements VipDataService{


	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	CustomerManagementDataService customerManagementDataService = DataFactory.getDataFactory().getCustomerManagementDataServiceImpl();

	public VipDataSerivceImpl() throws RemoteException {
		super();
	}
	
	private final String tableName = "commonVip";
	private final String tableName2 = "businessVip";
	private LevelSystem levels = new LevelSystem();
	
	@Override
	public ResultMsg insertC(CommonVipPO vip) throws RemoteException {
		return addToSQL(tableName, vip.getUserID(),vip.getUsername(),
								vip.getPassword(),vip.getContact(),
								""+vip.getCredit(),vip.getBirthday(),
								vip.getVipType().toString());
	}

	@Override
	public ResultMsg delete(String userid) throws RemoteException {
		return delFromSQL(tableName, userid);
	}

	@Override
	public ResultMsg updateC(CommonVipPO vip) throws RemoteException {
		CustomerInfoPO po = customerManagementDataService.getCustomerInfo(vip.getUserID());
		setVipTOCustomerC(po, vip);
		ResultMsg a = customerManagementDataService.updateCustomerInfo(vip.getUserID(), po);
		if(a == ResultMsg.SUCCESS){
			return modifyFromSQL(tableName, vip.getUserID(),vip.getUsername(),
								vip.getPassword(),vip.getContact(),
								""+vip.getCredit(),vip.getBirthday(),
								vip.getVipType().toString());
		}else{
			System.out.println("vip信息更新customer信息失败");
			return ResultMsg.FAIL;
		}
		
	}

	
	/**
	 * vip信息同步到customer中
	 */
	private static CustomerInfoPO setVipTOCustomerC(CustomerInfoPO customer,CommonVipPO vipc){
		customer.setUsername(vipc.getUsername());
		customer.setPassword(vipc.getPassword());
		customer.setContact(vipc.getContact());
		customer.setCredit(vipc.getCredit());
		customer.setVipType(vipc.getVipType());
		return customer;
	}

	@Override
	public CommonVipPO findByUserIDC(String id) throws RemoteException {
		sql = "SELECT * FROM " + tableName  + " WHERE userID = \'" + id + "\'";
		CommonVipPO po = findMsgC(sql);
		return po;
	}

	@Override
	public ArrayList<CommonVipPO> showC(Type type) throws RemoteException {
		sql = "SELECT * FROM " + tableName;
		ArrayList<CommonVipPO> pos = findMsgCs(sql);
		return pos;
	}

	@Override
	public ResultMsg insertB(BusinessVipPO vip) throws RemoteException {
		return addToSQL(tableName2, vip.getUserID(),vip.getUsername(),
							vip.getPassword(),vip.getContact(),
							""+vip.getCredit(),vip.getBusinessName(),
							vip.getVipType().toString());
	}

	@Override
	public ResultMsg updateB(BusinessVipPO vip) throws RemoteException {
		CustomerInfoPO po = customerManagementDataService.getCustomerInfo(vip.getUserID());
		setVipTOCustomerB(po, vip);
		ResultMsg a = customerManagementDataService.updateCustomerInfo(vip.getUserID(), po);
		if(a == ResultMsg.SUCCESS){
			return modifyFromSQL(tableName, vip.getUserID(),vip.getUsername(),
								vip.getPassword(),vip.getContact(),
								""+vip.getCredit(),vip.getBusinessName(),
								vip.getVipType().toString());
		}else{
			System.out.println("vip信息更新customer信息失败");
			return ResultMsg.FAIL;
		}
	}
	
	/**
	 * vip信息同步到customer中
	 */
	private static CustomerInfoPO setVipTOCustomerB(CustomerInfoPO customer,BusinessVipPO vipc){
		customer.setUsername(vipc.getUsername());
		customer.setPassword(vipc.getPassword());
		customer.setContact(vipc.getContact());
		customer.setCredit(vipc.getCredit());
		customer.setVipType(vipc.getVipType());
		return customer;
	}

	@Override
	public BusinessVipPO findByUserIDB(String id) throws RemoteException {
		sql = "SELECT * FROM " + tableName2  + " WHERE userID = \'" + id + "\'";
		BusinessVipPO po = findMsgB(sql);
		return po;
	}

	@Override
	public ArrayList<BusinessVipPO> showB(Type type) throws RemoteException {
		sql = "SELECT * FROM " + tableName2;
		ArrayList<BusinessVipPO> pos = findMsgBs(sql);
		return pos;
	}

	@Override
	public ResultMsg update(LevelSystemPO levelSystemPO) throws RemoteException {
		ResultMsg a = levels.updata(levelSystemPO);
		return a;
	}

	
	
	private CommonVipPO findMsgC(String sql) throws RemoteException{
		CommonVipPO po = null;
		try {
			preState = conn.prepareStatement(sql);
			result = preState.executeQuery();
			while(result.next()){
				po = new CommonVipPO(result.getString(1), result.getString(2), 
								result.getString(3), result.getString(4),
								Integer.valueOf(result.getString(5)), 
								result.getString(6), 
								VipType.valueOf(result.getString(7)));
				break;
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return po;
	}
	
	private BusinessVipPO findMsgB(String sql) throws RemoteException{
		BusinessVipPO po = null;
		try {
			preState = conn.prepareStatement(sql);
			result = preState.executeQuery();
			while(result.next()){
				po = new BusinessVipPO(result.getString(1), result.getString(2), 
								result.getString(3), result.getString(4),
								Integer.valueOf(result.getString(5)), 
								result.getString(6), 
								VipType.valueOf(result.getString(7)));
				break;
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return po;
	}
	
	private ArrayList<CommonVipPO> findMsgCs(String sql) throws RemoteException{
		ArrayList<CommonVipPO> pos = new ArrayList<CommonVipPO>();
		try {
			preState = conn.prepareStatement(sql);
			result = preState.executeQuery();
			while(result.next()){
				pos.add(new CommonVipPO(result.getString(1), result.getString(2), 
								result.getString(3), result.getString(4),
								Integer.valueOf(result.getString(5)), 
								result.getString(6), 
								VipType.valueOf(result.getString(7))));
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return pos;
	}
	
	private  ArrayList<BusinessVipPO> findMsgBs(String sql) throws RemoteException{
		ArrayList<BusinessVipPO> pos = new ArrayList<BusinessVipPO>();
		try {
			preState = conn.prepareStatement(sql);
			result = preState.executeQuery();
			while(result.next()){
				pos.add(new BusinessVipPO(result.getString(1), result.getString(2), 
								result.getString(3), result.getString(4),
								Integer.valueOf(result.getString(5)), 
								result.getString(6), 
								VipType.valueOf(result.getString(7))));
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return pos;
	}

	@Override
	public ResultMsg insertL(LevelSystemPO levelSystemPO) throws RemoteException {
		ResultMsg a = levels.insert(levelSystemPO);
		return a;
	}

	@Override
	public LevelSystemPO findL(int level) throws RemoteException {
		LevelSystem levelSystem = new LevelSystem();
		LevelSystemPO po = levelSystem.findByLevel(""+level);
		return po;
	}

	@Override
	public ArrayList<LevelSystemPO> getLevelSystemPO() throws RemoteException {
		ArrayList<LevelSystemPO> pos = levels.show();
		return pos;
	}

	
}
