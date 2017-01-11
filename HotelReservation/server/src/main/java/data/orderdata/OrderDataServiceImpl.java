package data.orderdata;

import java.rmi.RemoteException;
import java.sql.SQLException;
import java.util.ArrayList;

import data.creatID.CreateID;
import dataSuper.DataSuperClass;
import datafactory.DataFactory;
import dataservice.hoteldataservice.RoomInfoDataService;
import dataservice.orderdataservice.OrderDataService;
import dataservice.userdataservice.CustomerManagementDataService;
import po.OrderPO;
import util.OrderState;
import util.ResultMsg;
import util.RoomType;

public class OrderDataServiceImpl extends DataSuperClass implements OrderDataService{
	
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private final String tableName = "orderList";
	
	CustomerManagementDataService customer = DataFactory.getDataFactory().getCustomerManagementDataServiceImpl();
	RoomInfoDataService room =  DataFactory.getDataFactory().getRoomInfoDataServiceImpl();
	OrderRoom orderRoom = new OrderRoom();
	
	public OrderDataServiceImpl() throws RemoteException {
		super();
	}
	
	@Override
	public String insert(OrderPO po) throws RemoteException {
		String newID = CreateID.getCreateID().getNewOrderID();
		ResultMsg bMsg = addToSQL(tableName,newID,po.getInitiator().getUserID(),po.getOrderState().toString(),""+po.getPrice(),
										po.hotelID,"" + po.getHasChild(),po.getLatestExecutionTime(),po.getCheckInTime(),
										po.getCheckOutTime(),po.getCancelledTime(),""+ po.getRoomNumber(),
										""+po.getPeopleNumber(),orderRoom.addLink(po.getHotelID(),newID, po.getRoomType(),po.getRoomNumber()),
										po.getRoomType().toString());
		if(bMsg == ResultMsg.SUCCESS){
			return newID;
		}else{
			return null;
		}
	}

	@Override
	public ResultMsg delete(String ID) throws RemoteException {
		return delFromSQL(tableName, ID);
	}

	@Override
	public ResultMsg update(OrderPO po) throws RemoteException {
		return modifyFromSQL(tableName, po.getOrderID(),po.getInitiator().getUserID(),po.getOrderState().toString(),""+po.getPrice(),
									po.hotelID,"" + po.getHasChild(),po.getLatestExecutionTime(),po.getCheckInTime(),
									po.getCheckOutTime(),po.getCancelledTime(),""+ po.getRoomNumber(),
									""+po.getPeopleNumber(),orderRoom.addLink(po.getHotelID(),po.getOrderID(), po.getRoomType(),po.getRoomNumber()),
									po.getRoomType().toString());
	}

	@Override
	public OrderPO findByOrderID(String ID) throws RemoteException {
		sql = "SELECT * FROM " + tableName  + " WHERE orderID = \'" + ID + "\'";
		OrderPO orderPO = getMsg(sql);
		if(orderPO == null){
			return null;
		}
		return orderPO;
	}
	
	
	
	@Override
	public ArrayList<OrderPO> findByUserID(String ID) throws RemoteException {
		ArrayList<OrderPO> pos = new ArrayList<OrderPO>();
		sql = "SELECT * FROM " + tableName  + " WHERE customerInfoPO = \'" + ID + "\'";
//		System.out.println(sql);
		pos = getMsgs(sql);
		return pos;
	}

	@Override
	public ArrayList<OrderPO> findByHotelID(String ID) throws RemoteException {
		ArrayList<OrderPO> pos = new ArrayList<OrderPO>();
		sql = "SELECT * FROM " + tableName + " WHERE hotelID = \'" + ID + "\'";
		pos = getMsgs(sql);
		return pos.size()==0?null:pos;
	}

	@Override
	public ArrayList<OrderPO> showList() throws RemoteException {
		ArrayList<OrderPO> pos = new ArrayList<OrderPO>();
		sql = "SELECT * FROM " + tableName ;
		pos = getMsgs(sql);
		return pos.size()==0?null:pos;
	}
	
	private OrderPO getMsg(String sql) throws RemoteException{
		OrderPO orderPO = null;
		try {
			preState = conn.prepareStatement(sql);
			result = preState.executeQuery();
			
			while (result.next()) {
					orderPO = new OrderPO(result.getString(1), 
							customer.getCustomerInfo(result.getString(2))/*需要返回customerinfo*/, 
							OrderState.valueOf(result.getString(3)),
							Double.valueOf(result.getString(4)), result.getString(5), 
							Boolean.valueOf(result.getString(6)), result.getString(7), 
							result.getString(8), result.getString(9), 
							result.getString(10),
							Integer.valueOf(result.getString(11)),
							Integer.valueOf(result.getString(12)),
							orderRoom.getLink(result.getString(13)),
							RoomType.valueOf(result.getString(14)));
				
			}
		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println("订单信息从数据库中查找出错");
		}
		return orderPO;
	}
	
	private ArrayList<OrderPO> getMsgs(String sql) throws RemoteException{
		ArrayList<OrderPO> pos = new ArrayList<OrderPO>();
		OrderPO orderPO = null;
		try {
			preState = conn.prepareStatement(sql);
			result = preState.executeQuery();
			while (result.next()) {
					orderPO = new OrderPO(result.getString(1), 
							customer.getCustomerInfo(result.getString(2))/*需要返回customerinfo*/, 
							OrderState.valueOf(result.getString(3)),
							Double.valueOf(result.getString(4)), result.getString(5), 
							Boolean.valueOf(result.getString(6)), result.getString(7), 
							result.getString(8), result.getString(9), 
							result.getString(10),
							Integer.valueOf(result.getString(11)),
							Integer.valueOf(result.getString(12)),
							orderRoom.getLink(result.getString(13)),
							RoomType.valueOf(result.getString(14)));
					pos.add(orderPO);
			}
		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println("订单信息从数据库中查找出错");
		}
		return pos;
	}

	
}

