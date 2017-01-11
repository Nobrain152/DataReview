package data.orderdata;

import java.rmi.RemoteException;
import java.sql.SQLException;
import java.util.ArrayList;

import dataSuper.DataSuperClass;
import util.RoomType;

public class OrderRoom extends DataSuperClass{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private static final String tableName = "orderRoom";
	
	
	public OrderRoom() throws RemoteException {
		super();
	}
	
	public String addLink(String hotelID,String orderID,RoomType roomType,int num) throws RemoteException{
		ArrayList<String> roomIDs = new ArrayList<String>();
		sql = "SELECT * FROM roominfo WHERE hotelID = \'" + hotelID + "\' AND type = \'" + roomType.toString() + "\' AND stateName = \'USABLE\'";
		roomIDs = findMsgs2(sql,num);
		for(int i =0;i < roomIDs.size();i++){
			addToSQL(tableName, hotelID,orderID,roomIDs.get(i),roomType.toString());
		}
		
		
		return orderID;
	}

	public ArrayList<String> getLink(String orderID) throws RemoteException {
		ArrayList<String> roomIDs = new ArrayList<String>();
		sql =  "SELECT * FROM " + tableName  + " WHERE orderID = \'" + orderID + "\'";
		roomIDs = findMsgs(sql);
		return roomIDs;
	}
	
	private ArrayList<String> findMsgs(String sql) throws RemoteException{
		ArrayList<String> roomIDs = new ArrayList<String>();
		try {
			preState = conn.prepareStatement(sql);
			result = preState.executeQuery();
			while (result.next()) {
				roomIDs.add(result.getString(3));
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return roomIDs;
	}
	private ArrayList<String> findMsgs2(String sql,int number) throws RemoteException{
		ArrayList<String> roomIDs = new ArrayList<String>();
		int i=0;
		try {
			preState = conn.prepareStatement(sql);
			result = preState.executeQuery();
			while (result.next() && (i<number)) {
				roomIDs.add(result.getString(1));
				i++;
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return roomIDs;
	}
	
}
