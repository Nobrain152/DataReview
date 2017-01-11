package data.userdata;

import java.rmi.RemoteException;

import dataSuper.DataSuperClass;
import util.ResultMsg;

public class UserAndHotel extends DataSuperClass{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private static final String tableName = "user-hotel";

	public UserAndHotel() throws RemoteException {
		super();
	}
	
	public ResultMsg add(String userID,String hotelID) throws RemoteException{
		return addToSQL(tableName, userID, hotelID);
	}
}
