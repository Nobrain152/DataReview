package bl;

import bl.creditbl.CreditController;
import bl.hotelbl.HotelEvaluateController;
import bl.hotelbl.HotelInfoCheckController;
import bl.hotelbl.HotelInfoMaintainController;
import bl.hotelbl.HotelReserveController;
import bl.hotelbl.HotelSearchController;
import bl.hotelbl.RoomAddController;
import bl.orderbl.OrderOnHotelController;
import bl.orderbl.OrderOnUserController;
import bl.orderbl.OrderOnWebController;
import bl.promotionbl.PromotionHotelController;
import bl.promotionbl.PromotionValueController;
import bl.promotionbl.PromotionWebController;
import bl.userbl.CustomerInfoManagementController;
import bl.vipbl.VipController;
import blservice.creditblservice.CreditBLService;
import blservice.hotelblservice.HotelEvaluateBLService;
import blservice.hotelblservice.HotelInfoCheckBLService;
import blservice.hotelblservice.HotelInfoMaintainBLService;
import blservice.hotelblservice.HotelReserveBLService;
import blservice.hotelblservice.HotelSearchBLService;
import blservice.hotelblservice.RoomAddBLService;
import blservice.orderblservice.OrderOnHotelBLService;
import blservice.orderblservice.OrderOnUserBLService;
import blservice.orderblservice.OrderOnWebBLService;
import blservice.promotionblservice.PromotionHotelBLService;
import blservice.promotionblservice.PromotionValueBLService;
import blservice.promotionblservice.PromotionWebBLService;
import blservice.userblservice.CustomerIndividualInformationManagementBLService;
import blservice.vipblservice.VipBLService;

/**
 * 逻辑层工厂类
 * @author txin15
 *
 */
public class BusinessLogicDataFactory {
	
	private static BusinessLogicDataFactory factory;
	
	private BusinessLogicDataFactory() {}
	
	public static BusinessLogicDataFactory getFactory(){
		if(factory == null){
			factory = new BusinessLogicDataFactory();
			//因为持有其他的引用，必须先初始化工厂后才能启动approval内的初始化
		}
		return factory;
	}
	
	public CreditBLService getCreditBLService(){
		return new CreditController();
	}
	
	public HotelEvaluateBLService getHotelEvaluateBLService(){
		return new HotelEvaluateController();
	}
	
	public HotelInfoCheckBLService getHotelInfoCheckBLService(){
		return new HotelInfoCheckController();
	}
	
	public HotelInfoMaintainBLService getHotelInfoMaintainBLService(){
		return new HotelInfoMaintainController();
	}

	public HotelReserveBLService getHotelReserveBLService(){
		return new HotelReserveController();
	}
	
	public HotelSearchBLService getHotelSearchBLService(){
		return new HotelSearchController();
	}
	
	public RoomAddBLService getRoomAddBLService(){
		return new RoomAddController();
	}
	
	public OrderOnHotelBLService getOrderOnHotelBLService(){
		return new OrderOnHotelController();
	}
	
	public OrderOnUserBLService getOrderOnUserBLService(){
		return new OrderOnUserController();
	}
	
	public OrderOnWebBLService getOrderOnWebBLService(){
		return new OrderOnWebController();
	}
	
	public PromotionHotelBLService getPromotionHotelBLService(){
		return new PromotionHotelController();
	}
	
	public PromotionValueBLService getPromotionValueBLService(){
		return new PromotionValueController();
	}
	
	public PromotionWebBLService getPromotionWebBLService(){
		return new PromotionWebController();
	}
	
	public VipBLService getVipLevelBLService(){
		return new VipController();
	}
	
	public CustomerIndividualInformationManagementBLService getCustomerIndividualInformationManagementBLService(){
		return new CustomerInfoManagementController();
	}
}
