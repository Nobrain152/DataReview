package dataservice.datafactoryservice;

import java.rmi.Remote;
import java.rmi.RemoteException;

import dataservice.creditdataservice.CreditDataService;
import dataservice.hoteldataservice.HotelEvaluateDataService;
import dataservice.hoteldataservice.HotelInfoDataService;
import dataservice.hoteldataservice.RoomInfoDataService;
import dataservice.orderdataservice.OrderDataService;
import dataservice.promotiondataservice.PromotionHotelDataService;
import dataservice.promotiondataservice.PromotionWebDataService;
import dataservice.userdataservice.CustomerManagementDataService;
import dataservice.userdataservice.UserManagementDataService;
import dataservice.vipdataservice.VipDataService;

public interface DataFactoryService extends Remote{
	public CreditDataService getCreditDataServiceImpl() throws RemoteException;
	
	public HotelEvaluateDataService getHotelEvaluateDataServiceImpl() throws RemoteException;
	
	public HotelInfoDataService getHotelInfoDataServiceImpl() throws RemoteException;
	
	public RoomInfoDataService getRoomInfoDataServiceImpl() throws RemoteException;
	
	public  OrderDataService getOrderDataServiceImpl() throws RemoteException;
	
	public PromotionHotelDataService getPromotionHotelDataServiceImpl() throws RemoteException;
	
	public PromotionWebDataService getPromotionWebDataServiceImpl() throws RemoteException;
	
	public CustomerManagementDataService getCustomerManagementDataServiceImpl() throws RemoteException;
	
	public UserManagementDataService getUserManagementDataServiceImpl() throws RemoteException;
	
	public  VipDataService getVipDataService() throws RemoteException;
}
