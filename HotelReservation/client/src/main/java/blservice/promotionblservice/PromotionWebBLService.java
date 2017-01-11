package blservice.promotionblservice;

import java.util.ArrayList;

import util.Area;
import util.PromotionWebType;
import util.ResultMsg;
import vo.PromotionWebVO;

/**
 * 网站促销策略
 * @author txin15
 *
 */

public interface PromotionWebBLService {
	
	/**
	 * 修改促销策略
	 * @param ratio
	 * @return
	 */
	public ResultMsg changeLevelCut(int level,double ratio);
	
	public ResultMsg changeCircleCut(Area location,double ratio);
	
	public ResultMsg changeWebCustomCut(String timeBegin,String timeOver, double ratio);
	
	/**
	 * 增加促销策略
	 * @param ratio
	 * @return
	 */
	public ResultMsg addLevelCut(int level,double ratio);
	
	public ResultMsg addCircleCut(Area location,double ratio);
	
	public ResultMsg addWebCustomCut(String timeBegin,String timeOver, double ratio);
	
	/**
	 * 删除促销策略
	 * @return
	 */
	public ResultMsg deleteLevelCut(int level);
	
	public ResultMsg deleteCircleCut(Area location);
	
	public ResultMsg deleteWebCustomCut(String timeBegin,String timeOver);
	
	/**
	 * 获取相应促销策略列表
	 * @param type
	 * 0:表示会员等级优惠策略
	 * 1:表示特定区域优惠策略
	 * 2:表示自定义促销策略
	 * @return 
	 */
	public ArrayList<PromotionWebVO> getWebPromotion(PromotionWebType type);
}
