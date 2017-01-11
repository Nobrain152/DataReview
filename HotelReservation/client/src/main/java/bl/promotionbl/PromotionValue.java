package bl.promotionbl;


import java.rmi.RemoteException;
import java.util.ArrayList;

import bl.BusinessLogicDataFactory;
import bl.hotelbl.HotelInfoMaintainController;
import bl.vipbl.VipController;
import dataservice.promotiondataservice.PromotionHotelDataService;
import dataservice.promotiondataservice.PromotionWebDataService;
import po.PromotionHotelPO;
import po.PromotionWebPO;
import util.Area;
import util.PromotionHotelType;
import util.PromotionWebType;
import util.VipType;
import vo.CustomerInfoVO;
import vo.OrderVO;

/**
 * 计算促销值
 * @author txin15
 *
 */
public class PromotionValue {

	private PromotionHotelDataService promotionHotelDataService;
	private VipController vip;
	private HotelInfoMaintainController hotelInfo;
	
	public PromotionValue(PromotionHotelDataService promotionHotelDataService) {
		this.promotionHotelDataService = promotionHotelDataService;
	}
	
	/**
	 * 获得网站促销策略的价格
	 * @param user
	 * @param order
	 * @param hotelType
	 * @return
	 * @throws RemoteException
	 */
	public double getValue(CustomerInfoVO user, OrderVO order, PromotionHotelType hotelType) throws RemoteException {
		ArrayList<PromotionHotelPO> po = promotionHotelDataService.
				findByType(hotelType, order.getHotelID());;
		double ratio = 1;
		
		switch(hotelType) {
		
			case BIRTH_PROMOTION:
				
				vip = (VipController)BusinessLogicDataFactory.getFactory().getVipLevelBLService();
				
				if(user.getIsMember() && user.getVipType() == VipType.COMMON_VIP) {
					for(PromotionHotelPO hotelPO : po) {
						int level = vip.searchLevel(user);
						if(hotelPO.getLevel() == level) {
							ratio = hotelPO.getRatio();
							break;
						}
					}
					return order.getPrice()*ratio;
				}
				break;
				
			case OVERTHREE_PROMOTION:
				
				if(user.getIsMember()){
					for(PromotionHotelPO hotelPO : po) {
						if(hotelPO.getNumber() <= order.getRoomNumber()) {
							ratio = hotelPO.getRatio();
							continue;
						}
					}
					return order.getPrice()*ratio;
				}
				break;
				
			case HOTEL_CUSTOM_PROMOTION:
				
				if(user.getIsMember()) {
					for(PromotionHotelPO hotelPO : po) {
						if(hotelPO.getTimeBegin().compareTo(order.getCheckInTime()) <= 0
								&& hotelPO.getTimeOver().compareTo(order.getCheckOutTime()) >= 0) {
							ratio = hotelPO.getRatio();
							break;
						}
					}
					return order.getPrice()*ratio;
				}
				break;
				
			case JOIN_PROMOTION:
				if(user.getIsMember()) {
					String businessName = user.getUsername();
					for(PromotionHotelPO hotelPO : po) {
						if(hotelPO.getBusinessName().equals(businessName)) {
							ratio = hotelPO.getRatio();
							break;
						}
					}
					return order.getPrice()*ratio;
				}
				break;
				
			default:
				break;
		}

		return order.getPrice()*ratio;
	}

	private PromotionWebDataService promotionWebDataService;
	
	public PromotionValue(PromotionWebDataService promotionWebDataService) {
		this.promotionWebDataService = promotionWebDataService;
	}
	
	/**
	 * 获得酒店促销策略的价格
	 * @param user
	 * @param order
	 * @param webType
	 * @return
	 * @throws RemoteException
	 */
	public double getValue(CustomerInfoVO user, OrderVO order, PromotionWebType webType) throws RemoteException {
		ArrayList<PromotionWebPO> po = promotionWebDataService.
				findByType(webType);;
		double ratio = 1;
		
		switch(webType) {
		
			case VIP_CIRCLE_PROMOTION:
				
				if(user.getIsMember()) {
					for(PromotionWebPO hotelPO : po) {
						hotelInfo = (HotelInfoMaintainController)BusinessLogicDataFactory.getFactory().
								getHotelInfoMaintainBLService();
						Area location = hotelInfo.find(order.getHotelID()).getArea();
						if(hotelPO.getLocation() == location) {
							ratio = hotelPO.getRatio();
							break;
						}
					}
					return order.getPrice()*ratio;
				}
				break;
				
			case VIP_LEVEL_PROMOTION:
				
				vip = (VipController)BusinessLogicDataFactory.getFactory().getVipLevelBLService();
				
				if(user.getIsMember()){
					for(PromotionWebPO hotelPO : po) {
						if(hotelPO.getLevel() == vip.searchLevel(user)) {
							ratio = hotelPO.getRatio();
							break;
						}
					}
					return order.getPrice()*ratio;
				}
				break;
				
			case WEB_CUSTOM_PROMOTION:
				
				if(user.getIsMember()) {
					for(PromotionWebPO hotelPO : po) {
						if(hotelPO.getTimeBegin().compareTo(order.getCheckInTime()) <= 0
								&& hotelPO.getTimeOver().compareTo(order.getCheckOutTime()) >= 0) {
							ratio = hotelPO.getRatio();
							break;
						}
					}
					return order.getPrice()*ratio;
				}
				break;
				
			default:
				break;
		}
		
		return order.getPrice()*ratio;
	}

}
