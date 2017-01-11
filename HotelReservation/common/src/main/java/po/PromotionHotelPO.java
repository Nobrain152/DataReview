package po;

import java.io.Serializable;
import util.PromotionHotelType;

/**
 * 酒店促销策略VO
 * 
 * @author kevin
 *
 */

public class PromotionHotelPO implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	/**
	 * 酒店促销策略ID
	 */
	String promotionHotelID;
	
	/**
	 * 酒店ID
	 */
	String hotelID;
	
	/**
	 * 促销策略类型
	 */
	PromotionHotelType hotelType;
	
	/**
	 * 促销策略起止时间
	 */
	String beginTime,endTime;
	
	/**
	 * 会员等级
	 */
	int level;
	
	/**
	 * 房间数量
	 */
	int number;
	
	/**
	 * 企业名称
	 */
	String businessName;
	
	/**
	 * 促销策略打折比例
	 */
	double ratio;
	
	public PromotionHotelPO() {}
	
	/**
	 * 自定义时需要所有参数
	 * @param hotelID
	 * @param hotelType
	 * @param customType
	 * @param beginTime
	 * @param endTime
	 * @param ratio
	 * @param level
	 * @param number
	 * @param businessName
	 */
	public PromotionHotelPO(String promotionHotelID,String hotelID, PromotionHotelType hotelType,
			String beginTime,String endTime,double ratio,int level,int number,String businessName) {
		this.promotionHotelID = promotionHotelID;
		this.hotelID = hotelID;
		this.hotelType = hotelType;
		this.beginTime = beginTime;
		this.endTime = endTime;
		this.ratio = ratio;
		this.level = level;
		this.number = number;
		this.businessName = businessName;
	}
	
	/**
	 * 生日折扣，超过一定数量房间的折扣
	 * @param promotionHotelType
	 * @param hotelId
	 * @param num
	 * @param ratio
	 */
	public PromotionHotelPO(String promotionHotelID,PromotionHotelType promotionHotelType,String hotelId,int num,double ratio) {
		this.promotionHotelID = promotionHotelID;
		this.hotelType = promotionHotelType;
		this.hotelID = hotelId;
		if(promotionHotelType == PromotionHotelType.BIRTH_PROMOTION)
			this.level = num;
		else if(promotionHotelType == PromotionHotelType.OVERTHREE_PROMOTION)
			this.number = num;
		this.ratio = ratio;
	}
	
	/**
	 * 合作企业折扣
	 * @param promotionHotelType
	 * @param hotelID
	 * @param businessName
	 * @param ratio
	 */
	public PromotionHotelPO(String promotionHotelID,PromotionHotelType promotionHotelType,String hotelID,String businessName,double ratio) {
		this.promotionHotelID = promotionHotelID;
		this.hotelType = promotionHotelType;
		this.hotelID = hotelID;
		this.businessName  = businessName;
		this.ratio = ratio;
	}
	
	/**
	 * 自定义折扣（某特定时间
	 * @param type
	 * @param hotelID
	 * @param beginTime
	 * @param endTime
	 * @param radio
	 */
	public PromotionHotelPO(String promotionHotelID,PromotionHotelType type,String hotelID,String beginTime,String endTime,double radio) {
		this.promotionHotelID = promotionHotelID;
		this.hotelType = type;
		this.hotelID = hotelID;
		this.beginTime = beginTime;
		this.endTime = endTime;
		this.hotelID = hotelID;
		this.ratio = radio;
	}
	
	public String getPromotionHotelID(){
		return promotionHotelID;
	}
	
	public String getHotelID() {
		return hotelID;
	}
	
	public PromotionHotelType getType(){
		return hotelType;
	}
	
	public int getNumber() {
		return number;
	}
	
	public String getBusinessName() {
		return businessName;
	}
	
	public String getTimeBegin() {
        return beginTime;
    }

    public String getTimeOver() {
        return endTime;
    }
    
    public int getLevel() {
    	return level;
    }
    
    public double getRatio() {
		return ratio;
	}
    
    public void setRatio(double ratio) {
    	this.ratio = ratio;
    }
}
