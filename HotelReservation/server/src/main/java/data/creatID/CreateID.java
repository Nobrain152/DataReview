package data.creatID;

import java.rmi.RemoteException;
import java.sql.SQLException;
import java.util.ArrayList;

import dataSuper.DataSuperClass;
import util.ResultMsg;
/**
 * 为了获得必须唯一的ID而创建的一个类
 * @author T5-SK
 *
 */
public class CreateID extends DataSuperClass{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private static CreateID createID;
	
	private static String tableName = "createID";
	
	private static final String flag = "1";
	
	
	private CreateID() throws RemoteException {
		super();
	}
	
	
	/**
	 * 单件模式
	 * @throws RemoteException
	 */
	public static CreateID getCreateID() throws RemoteException {
		if(createID == null){
			createID = new CreateID();
		}
		return createID;
	}
	
	/**
	 * 初始化数据库中存放的ID
	 * user           八位，开头为1
	 * hotelStuff     八位，开头为2
	 * webStuff       八位，开头为3
	 * webManager     八位，开头为4
	 * hotelID        四位，开头为5
	 * orderID        八位，开头为6
	 * promotionHotel 八位，开头为7
	 * promotionWeb   八位，开头为8
	 * @return 创建好的新的对应ID
	 */
	public ResultMsg initialize() throws RemoteException{
		ResultMsg a = initialFromSQL(tableName);
		if(a != ResultMsg.SUCCESS){
			return ResultMsg.FAIL;
		}
		ResultMsg b = addToSQL(tableName, "1","10000020","20000000","30000000","40000000","5001","60000000","70000000","80000000");
		return b;
	}
	
	public String getNewCustomerID() throws RemoteException{
		sql = "SELECT * FROM " + tableName;
		findMes = findMes(sql);
		ResultMsg aMsg  = modifyFromSQL(tableName, flag,""+(Integer.valueOf(findMes.get(0))+1),findMes.get(1),
									findMes.get(2),findMes.get(3),findMes.get(4),findMes.get(5),findMes.get(6),findMes.get(7));
		
		
		if(aMsg == ResultMsg.SUCCESS){
			return ""+(Integer.valueOf(findMes.get(0))+1);
		}else{
			return null;
		}
	}
	
	public String getNewHotelStuffID() throws RemoteException{
		sql = "SELECT * FROM " + tableName;
		findMes = findMes(sql);
		ResultMsg aMsg = modifyFromSQL(tableName, flag,findMes.get(0),""+(Integer.valueOf(findMes.get(1))+1),
									findMes.get(2),findMes.get(3),findMes.get(4),findMes.get(5),findMes.get(6),findMes.get(7));
		
		if(aMsg == ResultMsg.SUCCESS){
			return ""+(Integer.valueOf(findMes.get(1))+1);
		}else{
			return null;
		}
	}
	
	public String getNewWebStuffID() throws RemoteException{
		sql = "SELECT * FROM " + tableName;
		findMes = findMes(sql);
		ResultMsg aMsg = modifyFromSQL(tableName, flag,findMes.get(0),findMes.get(1),
									""+(Integer.valueOf(findMes.get(2))+1),findMes.get(3),
									findMes.get(4),findMes.get(5),findMes.get(6),findMes.get(7));
		
		if(aMsg == ResultMsg.SUCCESS){
			return ""+(Integer.valueOf(findMes.get(2))+1);
		}else{
			return null;
		}
	}
	
	public String getNewWebManagerID() throws RemoteException{
		sql = "SELECT * FROM " + tableName;
		findMes = findMes(sql);
		ResultMsg aMsg = modifyFromSQL(tableName, flag,findMes.get(0),findMes.get(1),
									findMes.get(2),""+(Integer.valueOf(findMes.get(3))+1),
									findMes.get(4),findMes.get(5),findMes.get(6),findMes.get(7));
		
		if(aMsg == ResultMsg.SUCCESS){
			return ""+(Integer.valueOf(findMes.get(3))+1);
		}else{
			return null;
		}
	}
	
	public String getNewHotelID() throws RemoteException{
		sql = "SELECT * FROM " + tableName;
		findMes = findMes(sql);
		ResultMsg aMsg = modifyFromSQL(tableName, flag,findMes.get(0),findMes.get(1),
									findMes.get(2),findMes.get(3),
									""+(Integer.valueOf(findMes.get(4))+1),findMes.get(5),
									findMes.get(6),findMes.get(7));
		
		if(aMsg == ResultMsg.SUCCESS){
			return ""+(Integer.valueOf(findMes.get(4))+1);
		}else{
			return null;
		}
	}
	
	public String getNewOrderID() throws RemoteException{
		sql = "SELECT * FROM " + tableName;
		findMes = findMes(sql);
		ResultMsg aMsg = modifyFromSQL(tableName, flag,findMes.get(0),findMes.get(1),
									findMes.get(2),findMes.get(3),
									findMes.get(4),""+(Integer.valueOf(findMes.get(5))+1),
									findMes.get(6),findMes.get(7));
		
		if(aMsg == ResultMsg.SUCCESS){
			return ""+(Integer.valueOf(findMes.get(5))+1);
		}else{
			return null;
		}
	}
	
	public String getNewPromotionHotelID() throws RemoteException{
		sql = "SELECT * FROM " + tableName;
		findMes = findMes(sql);
		ResultMsg aMsg = modifyFromSQL(tableName, flag,findMes.get(0),findMes.get(1),
									findMes.get(2),findMes.get(3),
									findMes.get(4),findMes.get(5),
									""+(Integer.valueOf(findMes.get(6))+1),findMes.get(7));
		
		if(aMsg == ResultMsg.SUCCESS){
			return ""+(Integer.valueOf(findMes.get(6))+1);
		}else{
			return null;
		}
	}
	
	public String getNewPromotionWebID() throws RemoteException{
		sql = "SELECT * FROM " + tableName;
		findMes = findMes(sql);
		ResultMsg aMsg = modifyFromSQL(tableName, flag,findMes.get(0),findMes.get(1),
									findMes.get(2),findMes.get(3),
									findMes.get(4),findMes.get(5),
									findMes.get(6),""+(Integer.valueOf(findMes.get(7))+1));
		
		if(aMsg == ResultMsg.SUCCESS){
			return ""+(Integer.valueOf(findMes.get(7))+1);
		}else{
			return null;
		}
	}
	
	/**
	 * 从数据库中调取sql代表的信息
	 * @param sql
	 * @return
	 */
	public ArrayList<String> findMes(String sql) throws RemoteException{
		ArrayList<String> ans = null;
		try {
			preState = conn.prepareStatement(sql);
			result = preState.executeQuery();
			int size = getResultSize(tableName);
			ans = new ArrayList<String>(size);
			while(result.next()){
				for(int i=0; i<size; i++){
					ans.add(result.getString(i+1));
				}
			}
			
		} catch (SQLException e) {
			System.out.println("从createID库调取数据出错");
			e.printStackTrace();
		}
		
		//去除掉flag的ans
		ArrayList<String> finalAns = new ArrayList<String>();
		for(int i=0;i<ans.size();i++){
			if(i!=0){
				finalAns.add(ans.get(i));
			}
		}
		
		return finalAns;
	}
	
	//test
	public static void main(String[] args) throws RemoteException{
		CreateID createID = CreateID.getCreateID();
		createID.initialize();
		String ID = createID.getNewHotelID();
		System.out.println(ID);
	} 
}
