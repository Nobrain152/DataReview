package util;

/**
 * 可以获取的酒店促销策略的种类
 * 包括：1.会员生日促销策略 2.酒店三间以上优惠策略 3.酒店合作企业客户优惠策略 4.酒店自定义优惠策略
 * 
 * @author kevin
 */

public enum PromotionHotelType {
	BIRTH_PROMOTION,
	OVERTHREE_PROMOTION,
	JOIN_PROMOTION,
	HOTEL_CUSTOM_PROMOTION
}
