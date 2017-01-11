package blservice.promotionblservice;

import util.PromotionHotelType;
import util.PromotionWebType;
import vo.CustomerInfoVO;

/**
 * 订单价值逻辑层接口
 * @author T5-SK
 *
 */


import vo.OrderVO;

/**
 * 计算促销策略后的价格
 * @author txin15
 *
 */
public interface PromotionValueBLService {
	
	/**
	 * 计算酒店促销策略后的价格
	 * @param user
	 * @param order
	 * @param hotelType
	 * @return
	 */
	public double getValue(CustomerInfoVO user,OrderVO order,PromotionHotelType hotelType);
	
	/**
	 * 计算网站促销策略后的价格
	 * @param user
	 * @param order
	 * @param webType
	 * @return
	 */
	public double getValue(CustomerInfoVO user,OrderVO order,PromotionWebType webType);
}
