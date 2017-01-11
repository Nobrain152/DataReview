package net;

import java.net.MalformedURLException;
import java.rmi.NotBoundException;
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
import util.DataServiceType;

public class RMIServiceFactory {
	public static HotelEvaluateDataService hotelEvaluateDataService;
	public static HotelInfoDataService hotelInfoDataService;
	public static RoomInfoDataService roomInfoDataService;
	public static OrderDataService orderDataService;
	public static PromotionHotelDataService promotionHotelDataService;
	public static PromotionWebDataService promotionWebDataService;
	public static CustomerManagementDataService customerManagementDataService;
	public static UserManagementDataService userDataService;
	public static VipDataService vipDataService;
	public static CreditDataService creditDataService;
	
	private static RMIServiceFactory rmiServiceFactory;
	
	
	private RMIServiceFactory() {
		try {
			hotelEvaluateDataService = (HotelEvaluateDataService) RMIManage.mygetDataService(DataServiceType.HotelEvaluateDataService);
			hotelInfoDataService = (HotelInfoDataService) RMIManage.mygetDataService(DataServiceType.HotelInfoDataService);
			roomInfoDataService = (RoomInfoDataService) RMIManage.mygetDataService(DataServiceType.RoomInfoDataService);
			orderDataService = (OrderDataService) RMIManage.mygetDataService(DataServiceType.OrderDataService);
			promotionHotelDataService = (PromotionHotelDataService) RMIManage.mygetDataService(DataServiceType.PromotionHotelDataService);
			promotionWebDataService = (PromotionWebDataService) RMIManage.mygetDataService(DataServiceType.PromotionWebDataService);
			customerManagementDataService = (CustomerManagementDataService) RMIManage.mygetDataService(DataServiceType.CustomerManagementDataService);
			userDataService = (UserManagementDataService) RMIManage.mygetDataService(DataServiceType.UserManagementDataService);
			vipDataService = (VipDataService) RMIManage.mygetDataService(DataServiceType.VipDataService);
			creditDataService = (CreditDataService) RMIManage.mygetDataService(DataServiceType.CreditDataService);
		} catch (MalformedURLException | RemoteException | NotBoundException e) {
			
		}
	}
	static{
		try {
			hotelEvaluateDataService = (HotelEvaluateDataService) RMIManage.mygetDataService(DataServiceType.HotelEvaluateDataService);
			hotelInfoDataService = (HotelInfoDataService) RMIManage.mygetDataService(DataServiceType.HotelInfoDataService);
			roomInfoDataService = (RoomInfoDataService) RMIManage.mygetDataService(DataServiceType.RoomInfoDataService);
			orderDataService = (OrderDataService) RMIManage.mygetDataService(DataServiceType.OrderDataService);
			promotionHotelDataService = (PromotionHotelDataService) RMIManage.mygetDataService(DataServiceType.PromotionHotelDataService);
			promotionWebDataService = (PromotionWebDataService) RMIManage.mygetDataService(DataServiceType.PromotionWebDataService);
			customerManagementDataService = (CustomerManagementDataService) RMIManage.mygetDataService(DataServiceType.CustomerManagementDataService);
			userDataService = (UserManagementDataService) RMIManage.mygetDataService(DataServiceType.UserManagementDataService);
			vipDataService = (VipDataService) RMIManage.mygetDataService(DataServiceType.VipDataService);
			creditDataService = (CreditDataService) RMIManage.mygetDataService(DataServiceType.CreditDataService);
		} catch (MalformedURLException e) {
			e.printStackTrace();
		} catch (RemoteException e) {
			e.printStackTrace();
		} catch (NotBoundException e) {
			e.printStackTrace();
		}
		
		
	}
	
	public static void getServiceAgain(){
		getAgain();
	}
	
	private static void getAgain(){
		try {
			hotelEvaluateDataService = (HotelEvaluateDataService) RMIManage.mygetDataService(DataServiceType.HotelEvaluateDataService);
			hotelInfoDataService = (HotelInfoDataService) RMIManage.mygetDataService(DataServiceType.HotelInfoDataService);
			roomInfoDataService = (RoomInfoDataService) RMIManage.mygetDataService(DataServiceType.RoomInfoDataService);
			orderDataService = (OrderDataService) RMIManage.mygetDataService(DataServiceType.OrderDataService);
			promotionHotelDataService = (PromotionHotelDataService) RMIManage.mygetDataService(DataServiceType.PromotionHotelDataService);
			promotionWebDataService = (PromotionWebDataService) RMIManage.mygetDataService(DataServiceType.PromotionWebDataService);
			customerManagementDataService = (CustomerManagementDataService) RMIManage.mygetDataService(DataServiceType.CustomerManagementDataService);
			userDataService = (UserManagementDataService) RMIManage.mygetDataService(DataServiceType.UserManagementDataService);
			vipDataService = (VipDataService) RMIManage.mygetDataService(DataServiceType.VipDataService);
			creditDataService = (CreditDataService) RMIManage.mygetDataService(DataServiceType.CreditDataService);
		} catch (MalformedURLException | RemoteException | NotBoundException e) {
			getAgain();
		}
	}
}
