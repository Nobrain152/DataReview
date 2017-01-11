package bl.promotionbl;


import java.rmi.RemoteException;
import java.util.ArrayList;

import bl.VOPOchange;
import dataservice.promotiondataservice.PromotionWebDataService;
import po.PromotionWebPO;
import util.Area;
import util.PromotionWebType;
import util.ResultMsg;
import vo.PromotionWebVO;


/**
 * 酒店促销策略
 * @author txin15
 *
 */
public class PromotionWeb{

	private PromotionWebDataService promotionWebDataService;
	private ResultMsg resultMsg = ResultMsg.FAIL;
	
	public PromotionWeb(PromotionWebDataService promotionWebDataService) {
		this.promotionWebDataService = promotionWebDataService;
	}
	
	/**
	 * 修改会员等级（制定信用值满多少升下一等级）及其折扣
	 * @param level
	 * @param radio
	 * @return
	 * @throws RemoteException 
	 */
	public ResultMsg changeLevelCut(int level, double ratio) throws RemoteException {
		PromotionWebType type = PromotionWebType.VIP_LEVEL_PROMOTION;
		ArrayList<PromotionWebPO> promotion = promotionWebDataService.findByType(type);
		for(PromotionWebPO po : promotion) {
			if(po.getLevel() == level) {
				po.setRatio(ratio);
				resultMsg = promotionWebDataService.update(po);
			}
		}
		return resultMsg;
	}

	/**
	 * 修改双11活动折扣（在特定的期间预订有折扣）
	 * @param timeBegin
	 * @param timeOver
	 * @param radio
	 * @return
	 * @throws RemoteException 
	 */
	public ResultMsg changeWebCustomCut(String timeBegin, String timeOver, double ratio) throws RemoteException {
		PromotionWebType type = PromotionWebType.WEB_CUSTOM_PROMOTION;
		ArrayList<PromotionWebPO> promotion = promotionWebDataService.findByType(type);
		for(PromotionWebPO po : promotion) {
			if(po.getTimeBegin().equals(timeBegin) && po.getTimeOver().equals(timeOver)) {
				po.setRatio(ratio);
				resultMsg = promotionWebDataService.update(po);
			}
		}
		return resultMsg;
	}

	/**
	 * 修改VIP会员特定商圈专属折扣（不同等级不同商圈折扣不一样）
	 * @param location
	 * @param radio
	 * @return
	 * @throws RemoteException 
	 */
	public ResultMsg changeCircleCut(Area location, double ratio) throws RemoteException {
		PromotionWebType type = PromotionWebType.VIP_CIRCLE_PROMOTION;
		ArrayList<PromotionWebPO> promotion = promotionWebDataService.findByType(type);
		for(PromotionWebPO po : promotion) {
			if(po.getLocation().equals(location)) {
				po.setRatio(ratio);
				resultMsg = promotionWebDataService.update(po);
			}
		}
		return resultMsg;
	}

	/**
	 * 添加会员等级（制定信用值满多少升下一等级）及其折扣
	 * @param level
	 * @param d
	 * @return
	 * @throws RemoteException 
	 */
	public ResultMsg addLevelCut(int level, double ratio) throws RemoteException {
		PromotionWebType type = PromotionWebType.VIP_LEVEL_PROMOTION;
		ArrayList<PromotionWebPO> promotion = promotionWebDataService.findByType(type);
		for(PromotionWebPO po : promotion) {
			if(po.getLevel() == level) {
				return resultMsg;
			}
		}
		PromotionWebPO po = new PromotionWebPO(null, type, level, ratio);
		resultMsg = promotionWebDataService.insert(po);
		return resultMsg;
	}

	/**
	 * 添加VIP会员特定商圈专属折扣（不同等级不同商圈折扣不一样）
	 * @param location
	 * @param radio
	 * @return
	 * @throws RemoteException 
	 */
	public ResultMsg addCircleCut(Area location, double radio) throws RemoteException {
		PromotionWebType type = PromotionWebType.VIP_CIRCLE_PROMOTION;
		ArrayList<PromotionWebPO> promotion = promotionWebDataService.findByType(type);
		for(PromotionWebPO po : promotion) {
			if(po.getLocation().equals(location)) {
				return resultMsg;
			}
		}
		PromotionWebPO po = new PromotionWebPO(null, type, location, radio);
		resultMsg = promotionWebDataService.insert(po);
		return resultMsg;
	}

	/**
	 * 添加双11活动折扣（在特定的期间预订有折扣）
	 * @param timeBegin
	 * @param timeOver
	 * @param radio
	 * @return
	 * @throws RemoteException 
	 */
	public ResultMsg addWebCustomCut(String timeBegin, String timeOver, double ratio) throws RemoteException {
		PromotionWebType type = PromotionWebType.WEB_CUSTOM_PROMOTION;
		ArrayList<PromotionWebPO> promotion = promotionWebDataService.findByType(type);
		for(PromotionWebPO po : promotion) {
			if(po.getTimeBegin().equals(timeBegin) && po.getTimeOver().equals(timeOver)) {
				return resultMsg;
			}
		}
		PromotionWebPO po = new PromotionWebPO(null, type, timeBegin,timeOver, ratio);
		resultMsg = promotionWebDataService.insert(po);
		return resultMsg;
	}

	/**
	 * 获得该网站的促销策略
	 * @param type
	 * @return
	 * @throws RemoteException 
	 */
	public ArrayList<PromotionWebVO> getWebPromotion(PromotionWebType type) throws RemoteException {
		ArrayList<PromotionWebPO> list = promotionWebDataService.findByType(type);
		ArrayList<PromotionWebVO> voList = new ArrayList<>();
		PromotionWebVO vo;
		for(PromotionWebPO po : list) {
			vo = (PromotionWebVO)VOPOchange.POtoVO(po);
			voList.add(vo);
		}
		return voList;	
	}
	
	/**
	 * 删除会员等级（制定信用值满多少升下一等级）及其折扣
	 * @param level
	 * @return
	 * @throws RemoteException
	 */
	public ResultMsg deleteLevelCut(int level) throws RemoteException {
		PromotionWebType type = PromotionWebType.VIP_LEVEL_PROMOTION;
		ArrayList<PromotionWebPO> promotion = promotionWebDataService.findByType(type);
		for(PromotionWebPO po : promotion) {
			if(po.getLevel() == level) {
				resultMsg = promotionWebDataService.deleteLevelCut(po.getLevel());
			}
		}
		return resultMsg;
	}
	
	/**
	 * 删除VIP会员特定商圈专属折扣（不同等级不同商圈折扣不一样）
	 * @param location
	 * @return
	 * @throws RemoteException
	 */
	public ResultMsg deleteCircleCut(Area location) throws RemoteException {
		PromotionWebType type = PromotionWebType.VIP_CIRCLE_PROMOTION;
		ArrayList<PromotionWebPO> promotion = promotionWebDataService.findByType(type);
		for(PromotionWebPO po : promotion) {
			if(po.getLocation().equals(location)) {
				resultMsg = promotionWebDataService.deleteCircleCut(po.getLocation());
			}
		}
		return resultMsg;
	}
	
	/**
	 * 删除双11活动折扣（在特定的期间预订有折扣）
	 * @param timeBegin
	 * @param timeOver
	 * @return
	 * @throws RemoteException
	 */
	public ResultMsg deleteWebCustomCut(String timeBegin,String timeOver) throws RemoteException {
		PromotionWebType type = PromotionWebType.WEB_CUSTOM_PROMOTION;
		ArrayList<PromotionWebPO> promotion = promotionWebDataService.findByType(type);
		for(PromotionWebPO po : promotion) {
			if(po.getTimeBegin().equals(timeBegin) && po.getTimeOver().equals(timeOver)) {
				resultMsg = promotionWebDataService.deleteWebCustomCut(po.getTimeBegin(), po.getTimeOver());
			}
		}
		return resultMsg;
	}
}
