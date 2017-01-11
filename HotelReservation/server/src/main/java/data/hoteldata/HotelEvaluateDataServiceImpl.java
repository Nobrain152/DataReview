package data.hoteldata;

import java.rmi.RemoteException;
import java.sql.SQLException;
import java.util.ArrayList;

import dataSuper.DataSuperClass;
import dataservice.hoteldataservice.HotelEvaluateDataService;
import po.HotelEvaluatePO;
import util.ResultMsg;
/**
 * 酒店评价数据层实现
 * @author T5-SK
 *
 */
public class HotelEvaluateDataServiceImpl extends DataSuperClass implements HotelEvaluateDataService{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private String tableName = "hotelEvaluate";
	
	public HotelEvaluateDataServiceImpl() throws RemoteException {
		super();
	}
	
	/**
	 * 添加酒店评价
	 */
	@Override
	public ResultMsg insert(HotelEvaluatePO po) throws RemoteException {
		return addToSQL(tableName, po.getUserID(),po.getHotelID(),""+po.getScore(),
						po.getComment(),""+po.getIsReserved(),po.getOrderID());
	}

	
	/**
	 * 根据orderID查找酒店评价
	 */
	@Override
	public HotelEvaluatePO findByID(String ID) throws RemoteException {
		//根据orderID寻找
		sql = "SELECT * FROM " + tableName  + " WHERE orderID = \'" + ID + "\'";
		HotelEvaluatePO po = findMsg(sql);
		return po;
	}
	
	
	/**
	 * 显示酒店的所有评价
	 */
	@Override
	public ArrayList<HotelEvaluatePO> show(String hotelid) throws RemoteException {
		sql = "SELECT * FROM " + tableName  + " WHERE hotelID = \'" + hotelid + "\'";
		ArrayList<HotelEvaluatePO> pos = findMsgs(sql);
		return pos;
	}
	
	private HotelEvaluatePO findMsg(String sql) throws RemoteException{
		HotelEvaluatePO po = null;
		try {
			preState = conn.prepareStatement(sql);
			result = preState.executeQuery();
			while(result.next()){
				po = new HotelEvaluatePO(result.getString(1), result.getString(2), 
								Integer.valueOf(result.getString(3)),result.getString(4),
								Boolean.valueOf(result.getString(5)),result.getString(6));
				break;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return po;
	}
	
	private ArrayList<HotelEvaluatePO> findMsgs(String sql) throws RemoteException{
		ArrayList<HotelEvaluatePO> pos = new ArrayList<HotelEvaluatePO>();
		try {
			preState = conn.prepareStatement(sql);
			result = preState.executeQuery();
			while (result.next()) {
				pos.add(new HotelEvaluatePO(result.getString(1), result.getString(2), 
								Integer.valueOf(result.getString(3)),result.getString(4),
								Boolean.valueOf(result.getString(5)),result.getString(6)));
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return pos;
	}
}	