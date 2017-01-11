package data.hoteldata;

import java.rmi.RemoteException;
import java.sql.SQLException;
import java.util.ArrayList;

import data.creatID.CreateID;
import dataSuper.DataSuperClass;
import dataservice.hoteldataservice.HotelInfoDataService;
import po.HotelInfoPO;
import util.Adress;
import util.Area;
import util.ResultMsg;
/**
 * 获取酒店基本信息
 * @author T5-SK
 *
 */
public class HotelInfoDataServiceImpl extends DataSuperClass implements HotelInfoDataService{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private final String tableName = "hotelInfo";
	
	ArrayList<HotelInfoPO> hotelPOs;
	
	public HotelInfoDataServiceImpl() throws RemoteException{
		super();
	}
	
	/**
	 * 增加酒店信息
	 * @return 新的酒店ID 
	 */
	public String insert(HotelInfoPO po) throws RemoteException{
		String newID = CreateID.getCreateID().getNewHotelID();
		ResultMsg bMsg = addToSQL(tableName, newID,po.getName(),
				po.getAddress().toString(),po.getArea().toString(),
				""+po.getLevel(),po.getIntroduction(),po.getFacility(),
				Boolean.toString(po.getIsReserved()),""+po.getScore(),""+po.getSP());
		if(bMsg == ResultMsg.SUCCESS){
			return newID;
		}else{
			return null;
		}
		
	}
	
	
	
	
	/**
	 * 更新酒店信息
	 */
	public ResultMsg update(HotelInfoPO po) throws RemoteException{
		return modifyFromSQL(tableName, po.getHotelID(),po.getName(),
				po.getAddress().toString(),po.getArea().toString(),
				""+po.getLevel(),po.getIntroduction(),po.getFacility(),
				Boolean.toString(po.getIsReserved()),""+po.getScore(),""+po.getSP());
	}
	
	/**
	 * 根据hotelID查找酒店信息
	 * @return 对应酒店基本信息
	 */
	@Override
	public HotelInfoPO find(String ID) throws RemoteException {
		HotelInfoPO hotelInfo = findMsg(ID);
		return hotelInfo;
	}
	
		
	
	private HotelInfoPO findMsg(String ID) throws RemoteException{
		findMes = findFromSQL(tableName,ID);
		HotelInfoPO hotelInfoPO = null;
		
		if(findMes != null){
			hotelInfoPO = new HotelInfoPO(findMes.get(0), findMes.get(1), 
								Adress.valueOf(findMes.get(2)), Area.valueOf(findMes.get(3)),
								Integer.valueOf(findMes.get(4)), findMes.get(5), 
								findMes.get(6),Boolean.valueOf(findMes.get(7)),
								Double.parseDouble(findMes.get(8)),Integer.valueOf(findMes.get(9)));
		}
		
		return hotelInfoPO;
	}

	/**
	 * 显示所有酒店的信息
	 */
	public ArrayList<HotelInfoPO> show() throws RemoteException{
		ArrayList<HotelInfoPO> pos = new ArrayList<HotelInfoPO>();
		
		try {
			sql = "SELECT * FROM " + tableName ;
			preState = conn.prepareStatement(sql);
			result = preState.executeQuery();
			while (result.next()) {
				pos.add(new HotelInfoPO(result.getString(1), result.getString(2),
						Adress.valueOf(result.getString(3)), Area.valueOf(result.getString(4)),
						Integer.valueOf(result.getString(5)),result.getString(6),
						result.getString(7),Boolean.valueOf(result.getString(8)),
						Double.parseDouble(result.getString(9)),
						Integer.valueOf(result.getString(10))));
			}
		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println("从数据库中获取所有的hotel信息错误");
			return null;
		}
		
		return pos.size()==0?null:pos;
	}


	/**
	 * 通过酒店位置和商圈进行酒店基本信息的查找
	 * @return 所有满足信息的酒店信息列表
	 */
	@Override
	public ArrayList<HotelInfoPO> findByAreaAndCircle(Adress area,Area circle) throws RemoteException{
		ArrayList<HotelInfoPO> pos = new ArrayList<HotelInfoPO>();
		
		try {
			sql = "SELECT * FROM " + tableName + " WHERE address = \'" + area + "\' AND area = \'" + circle + "\'";
			preState = conn.prepareStatement(sql);
			result = preState.executeQuery();
			while (result.next()) {
				pos.add(new HotelInfoPO(result.getString(1), result.getString(2),
						Adress.valueOf(result.getString(3)), Area.valueOf(result.getString(4)),
						Integer.valueOf(result.getString(5)),result.getString(6),
						result.getString(7),Boolean.valueOf(result.getString(8)),
						Double.parseDouble(result.getString(9)),
						Integer.valueOf(result.getString(10))));
			}
		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println("酒店信息从数据库中查找出错");
			return null;
		}
		return pos;
	}

	@Override
	public ArrayList<HotelInfoPO> findByName(String name) throws RemoteException{
		ArrayList<HotelInfoPO> pos = new ArrayList<HotelInfoPO>();
		
		try {
			sql = "SELECT * FROM " + tableName + " WHERE name = \'" + name + "\'";
			preState = conn.prepareStatement(sql);
			result = preState.executeQuery();
			while (result.next()) {
				pos.add(new HotelInfoPO(result.getString(1), result.getString(2),
						Adress.valueOf(result.getString(3)), Area.valueOf(result.getString(4)),
						Integer.valueOf(result.getString(5)),result.getString(6),
						result.getString(7),Boolean.valueOf(result.getString(8)),
						Double.parseDouble(result.getString(9)),
						Integer.valueOf(result.getString(10))));
			}
		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println("酒店信息从数据库中查找出错");
			return null;
		}
		return pos.size()==0?null:pos;
	}

	

	

}