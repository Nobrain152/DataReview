package po;

import java.io.Serializable;

import util.Area;
import util.PromotionWebType;


/**
 * 网站促销策略VO
 * 
 * @author kevin
 *
 */

public class PromotionWebPO implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	/**
	 * 网站促销策略ID
	 */
	String promotionWebID;
	
	/**
	 * 促销策略类型
	 */
	PromotionWebType hotelType;
	
	/**
	 * 促销策略起止时间
	 */
	String beginTime,endTime;
	
	/**
	 * 会员等级
	 */
	int level;
	
	/**
	 * 商圈
	 */
	Area location;
	
	/**
	 * 促销策略打折比例
	 */
	double ratio;
	
	public PromotionWebPO() {}
	
	public PromotionWebPO(String promotionWebID,PromotionWebType hotelType,
			String beginTime,String endTime,double ratio,int level,Area location) {
		this.promotionWebID = promotionWebID;
		this.hotelType = hotelType;
		this.beginTime = beginTime;
		this.endTime = endTime;
		this.ratio = ratio;
		this.level = level;
		this.location = location;
	}
	
	public PromotionWebPO(String promotionWebID,PromotionWebType promotionWebType,Integer level,double ratio) {
		this.promotionWebID = promotionWebID;
		this.hotelType = promotionWebType;
		this.level = level;
		this.ratio = ratio;
	}
	
	public PromotionWebPO(String promotionWebID,PromotionWebType promotionWebType,Area location,double ratio) {
		this.promotionWebID = promotionWebID;
		this.hotelType = promotionWebType;
		this.location  = location;
		this.ratio = ratio;
	}
	
	public PromotionWebPO(String promotionWebID,PromotionWebType type,String beginTime,String endTime,double radio) {
		this.promotionWebID = promotionWebID;
		this.hotelType = type;
		this.beginTime = beginTime;
		this.endTime = endTime;
		this.ratio = radio;
	}
	
	public String getPromotionWebID(){
		return promotionWebID;
	}
	
	public PromotionWebType getType(){
		return hotelType;
	}
	
	public Area getLocation() {
		return location;
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