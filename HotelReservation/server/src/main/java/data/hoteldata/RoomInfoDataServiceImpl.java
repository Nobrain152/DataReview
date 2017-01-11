package data.hoteldata;

import java.rmi.RemoteException;
import java.sql.SQLException;
import java.util.ArrayList;

import dataSuper.DataSuperClass;
import dataservice.hoteldataservice.RoomInfoDataService;
import po.RoomInfoPO;
import util.ResultMsg;
import util.RoomState;
import util.RoomType;

public class RoomInfoDataServiceImpl extends DataSuperClass implements RoomInfoDataService{

	

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	public RoomInfoDataServiceImpl() throws RemoteException {
		super();
	}
	
	private final String tableName = "roomInfo";
	
	/**
	 * 添加一条roominfo信息
	 */
	@Override
	public ResultMsg insert(RoomInfoPO po) throws RemoteException {
		return addToSQL(tableName, po.getRoomID(),po.getState().toString(),po.getType().toString(),
						""+po.getPrice(),po.getHotelid());
	}
	
	/**
	 * 通过酒店和房间ID，删除一条roominfo
	 */
	@Override
	public ResultMsg delete(String hotelid, String roomid) throws RemoteException {
		sql = "DELETE FROM " + tableName + " WHERE roomID = \'" + roomid +
				"\' AND hotelID = \'" + hotelid +"\'";
		ResultMsg a = delete(sql);
		return a;
	}
	
	/**
	 * 更新房间信息
	 */
	@Override
	public ResultMsg update(RoomInfoPO po) throws RemoteException {
		return modifyFromSQL(tableName, po.getRoomID(),po.getState().toString(),po.getType().toString(),
						""+po.getPrice(),po.getHotelid());
	}
	
	/**
	 * 查找房间信息
	 */
	@Override
	public RoomInfoPO findByRoomID(String id) throws RemoteException {
		sql =  "SELECT * FROM " + tableName  + " WHERE roomID = \'" + id + "\'";
		return findMsg(sql);
	}
	
	/**
	 * 显示所有房间
	 */
	@Override
	public ArrayList<RoomInfoPO> show() throws RemoteException {
		sql = "SELECT * FROM " + tableName;
		return findMsgs(sql);
	}
	
	/**
	 * 查找一个酒店的所有房间
	 */
	@Override
	public ArrayList<RoomInfoPO> hotelRoomSearch(String hotelID) throws RemoteException {
		sql =  "SELECT * FROM " + tableName  + " WHERE hotelID = \'" + hotelID + "\'";
		return findMsgs(sql);
	}

	
	
	private RoomInfoPO findMsg(String sql) throws RemoteException{
		RoomInfoPO po = null;
		try {
			preState = conn.prepareStatement(sql);
			result = preState.executeQuery();
			while(result.next()){
				po = new RoomInfoPO(RoomState.valueOf(result.getString(2)),
								RoomType.valueOf(result.getString(3)),
								result.getString(1), Double.valueOf(result.getString(4)), 
								result.getString(5));
				break;
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return po;
	}
	
	private ArrayList<RoomInfoPO> findMsgs(String sql) throws RemoteException{
		ArrayList<RoomInfoPO> pos = new ArrayList<RoomInfoPO>();
		try {
			preState = conn.prepareStatement(sql);
			result = preState.executeQuery();
			while (result.next()) {
				pos.add(new RoomInfoPO(RoomState.valueOf(result.getString(2)),
						RoomType.valueOf(result.getString(3)),
						result.getString(1), Double.valueOf(result.getString(4)), 
						result.getString(5)));
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return pos;
	}
	
	
	private ResultMsg delete(String sql){
		try {
			preState = conn.prepareStatement(sql);
			affectRows = preState.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println("无法连接数据库");
			return ResultMsg.FAIL;
		}
		
		if(affectRows != 1){
			System.out.println("当前数据库中影响的条数为"+affectRows);
			System.out.println("在数据库中这个信息不存在或者存在多条无法定位删除，在"+tableName+"表中");
			return ResultMsg.NOT_EXIST;
		}
		
		return ResultMsg.SUCCESS;
	}
	


}