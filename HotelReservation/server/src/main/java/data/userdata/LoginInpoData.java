package data.userdata;

import java.rmi.RemoteException;
import java.sql.SQLException;
import java.util.ArrayList;

import dataSuper.DataSuperClass;
import po.LoginInPO;
import util.ResultMsg;

public class LoginInpoData extends DataSuperClass{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private final String tableName = "loginIn";
	
	public LoginInpoData() throws RemoteException {
		super();
	}
	
	public ResultMsg addToSQL(LoginInPO po) throws RemoteException{
		return addToSQL(tableName, po.getUsername(), po.getPassword());
	}
	
	public LoginInPO findLoginPO(String userID) throws RemoteException{
		LoginInPO po = findMes(userID);
		return po;
	}
	
	private LoginInPO findMes(String userID) throws RemoteException{
		findMes = findFromSQL(tableName,userID);
		LoginInPO po = null;
		
		if(findMes != null){
			po = new LoginInPO(findMes.get(0), findMes.get(1));
		}
		return po;
	}
	
	public ArrayList<LoginInPO> show() throws RemoteException{
		ArrayList<LoginInPO> pos = new ArrayList<LoginInPO>(30);
		
		try {
			sql = "SELECT * FROM " + tableName ;
			preState = conn.prepareStatement(sql);
			result = preState.executeQuery();
			while (result.next()) {
				pos.add(new LoginInPO(result.getString(1),result.getString(2)));
			}
		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println("从数据库中获取所有的hotel信息错误");
			return null;
		}
		
		return pos.size()==0?null:pos;
	}
	
}
