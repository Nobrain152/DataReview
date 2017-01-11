package blservice.promotionblservice;

import java.util.ArrayList;

import util.PromotionHotelType;
import util.ResultMsg;
import vo.PromotionHotelVO;

/**
 * 酒店促销策略逻辑层接口
 * @author txin15
 *
 */

public interface PromotionHotelBLService {
	/**
	 * 修改促销策略
	 * @param ratio
	 * @param hotelID
	 * @return
	 */
	public ResultMsg changeBirthCut(int level,double ratio,String hotelID);
	
	public ResultMsg changeOverCut(int number,double ratio,String hotelID);
	
	public ResultMsg changeJoin(String businessName,double ratio,String hotelID) ;
	
	public ResultMsg changeHotelCustomCut (String timeBegin,String timeOver, double ratio,String hotelID);

	/**
	 * 增加促销策略
	 * @param hotelID
	 * @param ratio
	 * @return
	 */
	public ResultMsg addBirthCut(int level,double ratio,String hotelID);
	
	public ResultMsg addOverCut(int number,double ratio,String hotelID);
	
	public ResultMsg addJoin(String businessName,double ratio,String hotelID) ;
	
	public ResultMsg addHotelCustomCut(String timeBegin,String timeOver, double ratio,String hotelID);
	
	
	/**
	 * 删除促销策略
	 * @param hotelID
	 * @return
	 */
	public ResultMsg deleteBirthCut(int level, String hotelID);
	
	public ResultMsg deleteOverCut(int number, String hotelID);
	
	public ResultMsg deleteJoin(String businessName, String hotelID);
	
	public ResultMsg deleteHotelCustomCut(String timeBegin,String timeOver, String hotelID);
	
	/**
	 * 获取相应促销策略列表
	 * @param type
	 * 0:表示会员生日促销策略
	 * 1:表示三间以上优惠策略
	 * 2:表示合作企业促销策略
	 * 3:表示自定义促销策略
	 * @return 
	 */
	public ArrayList<PromotionHotelVO> getHotelPromotion(PromotionHotelType type,String hotelID);
}
