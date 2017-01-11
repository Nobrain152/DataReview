package dataservice.promotiondataservice;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.ArrayList;

import po.PromotionHotelPO;
import util.PromotionHotelType;
import util.ResultMsg;

/**
 * 酒店营销策略的数据层接口
 * @author kevin
 *
 */

public interface PromotionHotelDataService extends Remote{
	
	public ResultMsg insert(PromotionHotelPO promotion) throws RemoteException;
	
	public ResultMsg deleteBirthCut(int level, String hotelID) throws RemoteException;
	
	public ResultMsg deleteHotelCustomCut(String beginTime,String endTime,String hotelID) throws RemoteException;
	
	public ResultMsg deleteJoin(String businessName,String hotelID) throws RemoteException;
	
	public ResultMsg deleteOverCut(int num,String hotelID) throws RemoteException;
	
	public ResultMsg update(PromotionHotelPO promotion) throws RemoteException;
	
	public ArrayList<PromotionHotelPO> findByType(PromotionHotelType type,String hotelID) throws RemoteException;
	
	public ArrayList<PromotionHotelPO> show() throws RemoteException;
	
	
}
