package data.creditdata;

import java.rmi.RemoteException;
import java.sql.SQLException;
import java.util.ArrayList;

import dataSuper.DataSuperClass;
import dataservice.creditdataservice.CreditDataService;
import po.CreditPO;
import util.Action;
import util.ResultMsg;
/**
 * creditDataService实现
 * @author T5-SK
 *
 */
public class CreditDataServiceImpl extends DataSuperClass implements CreditDataService{
	
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private String tableName = "credit";
	
	public CreditDataServiceImpl() throws RemoteException{
		super();
	}
	
	
	/**
	 * 添加一条信用记录
	 */
	@Override
	public ResultMsg insert(CreditPO creditPO) throws RemoteException {
		return addToSQL(tableName, creditPO.getUserID(),creditPO.getOrderID(),
				creditPO.getTime(),creditPO.getAction().toString(),
				creditPO.getCreditChange(),""+creditPO.getCreditResult());
	}

	/**
	 * 用userID获取其全部信用记录变化
	 */
	@Override
	public ArrayList<CreditPO> getListByUserID(String userID) throws RemoteException {
		ArrayList<CreditPO> pos = new ArrayList<CreditPO>(50);
		
		try {
			sql = "SELECT * FROM " + tableName  + " WHERE userID = \'" + userID + "\'";
			preState = conn.prepareStatement(sql);
			result = preState.executeQuery();
			while (result.next()) {
					pos.add(new CreditPO(result.getString(1), result.getString(2),
							result.getString(3), Action.valueOf(result.getString(4)),
							result.getString(5), 
							Integer.valueOf(result.getString(6))));
			}
		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println("信用信息从数据库中查找出错");
		}
		
		return pos;
	}


	/**
	 * 显示当前数据库中所有的信用记录
	 */
	@Override
	public ArrayList<CreditPO> show() throws RemoteException {
		ArrayList<CreditPO> pos = new ArrayList<CreditPO>(50);
		
		try {
			sql = "SELECT * FROM " + tableName ;
			preState = conn.prepareStatement(sql);
			result = preState.executeQuery();
			
			while (result.next()) {
				pos.add(new CreditPO(result.getString(1), result.getString(2),
							result.getString(3), Action.valueOf(result.getString(4)),
							result.getString(5), 
							Integer.valueOf(result.getString(6))));
			}
		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println("信用信息从数据库中查找出错");
		}
		return pos.size()==0?null:pos;
	}
	
	/**
	 * 用orderID获取其全部信用记录变化
	 */
	@Override
	public ArrayList<CreditPO> getListByOrderID(String orderID) throws RemoteException {
		ArrayList<CreditPO> pos = new ArrayList<CreditPO>(50);
		
		try {
			sql = "SELECT * FROM " + tableName + " WHERE orderID = \'" + orderID + "\'";
			preState = conn.prepareStatement(sql);
			result = preState.executeQuery();
			
			while (result.next()) {
					pos.add(new CreditPO(result.getString(1), result.getString(2),
							result.getString(3), Action.valueOf(result.getString(4)),
							result.getString(5), 
							Integer.valueOf(result.getString(6))));
			}
		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println("信用信息从数据库中查找出错");
		}
		
		return pos.size()==0?null:pos;
	}

}
