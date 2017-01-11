package blservice.promotionblservice;


import util.PromotionHotelType;
import util.PromotionWebType;
import vo.CustomerInfoVO;
import vo.OrderVO;

public class PromotionValueBLService_Stub implements PromotionValueBLService{
	String ratio;
	String time;
	PromotionWebType type;
	@Override
	public double getValue(CustomerInfoVO user, OrderVO order, PromotionHotelType hotelType) {
		return 0;
	}
	@Override
	public double getValue(CustomerInfoVO user, OrderVO order, PromotionWebType webType) {
		return 0;
	}
	
	
}