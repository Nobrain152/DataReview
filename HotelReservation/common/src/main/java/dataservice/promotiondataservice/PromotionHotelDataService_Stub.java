package dataservice.promotiondataservice;

import java.util.ArrayList;
import java.rmi.RemoteException;

import po.PromotionHotelPO;
import util.PromotionHotelType;
import util.ResultMsg;

public class PromotionHotelDataService_Stub implements PromotionHotelDataService{
	
	private PromotionHotelPO PromotionHotelPO1;
	private PromotionHotelPO PromotionHotelPO2;
	private ArrayList<PromotionHotelPO> PromotionHotelPOs;
	
	
	public PromotionHotelDataService_Stub(){
		
		PromotionHotelPOs = new ArrayList<PromotionHotelPO>();
		PromotionHotelPOs.add(PromotionHotelPO1);
		PromotionHotelPOs.add(PromotionHotelPO2);
	}

	@Override
	public ResultMsg insert(PromotionHotelPO promotion) throws RemoteException {
		return ResultMsg.SUCCESS;
	}


	@Override
	public ResultMsg deleteBirthCut(int level, String hotelID) throws RemoteException {
		return ResultMsg.SUCCESS;
	}


	@Override
	public ResultMsg deleteHotelCustomCut(String beginTime, String endTime, String hotelID) throws RemoteException {
		return ResultMsg.SUCCESS;
	}


	@Override
	public ResultMsg deleteJoin(String businessName, String hotelID) throws RemoteException {
		return ResultMsg.SUCCESS;
	}


	@Override
	public ResultMsg deleteOverCut(int num, String hotelID) throws RemoteException {
		return ResultMsg.SUCCESS;
	}


	@Override
	public ResultMsg update(PromotionHotelPO promotion) throws RemoteException {
		return ResultMsg.SUCCESS;
	}


	@Override
	public ArrayList<PromotionHotelPO> findByType(PromotionHotelType type, String hotelID) throws RemoteException {
		return null;
	}

	@Override
	public ArrayList<PromotionHotelPO> show() throws RemoteException {
		return null;
	}
	
	
}