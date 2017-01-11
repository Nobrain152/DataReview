package bl.promotionbl;

import java.rmi.RemoteException;
import java.util.ArrayList;

import bl.VOPOchange;
import dataservice.promotiondataservice.PromotionHotelDataService;
import po.PromotionHotelPO;
import util.PromotionHotelType;
import util.ResultMsg;
import vo.PromotionHotelVO;

/**
 * 酒店促销策略
 * @author txin15
 *
 */
public class PromotionHotel {
	
	private PromotionHotelDataService promotionHotelDataService;
	ResultMsg resultMsg = ResultMsg.FAIL;
	
	public PromotionHotel(PromotionHotelDataService promotionHotelDataService) {
		this.promotionHotelDataService = promotionHotelDataService;
	}

	/**
	 * 修改生日特惠折扣
	 * @param level
	 * @param ratio
	 * @param hotelID
	 * @return
	 * @throws RemoteException 
	 */
	public ResultMsg changeBirthCut(int level,double ratio,String hotelID) throws RemoteException {
		PromotionHotelType type = PromotionHotelType.BIRTH_PROMOTION;
		ArrayList<PromotionHotelPO> promotion = promotionHotelDataService.findByType(type,hotelID);
		for(PromotionHotelPO po : promotion) {
			if(po.getLevel() == level) {
				po.setRatio(ratio);
				resultMsg = promotionHotelDataService.update(po);
			}
		}
		return resultMsg;
	}

	/**
	 * 修改三间及以上预订特惠
	 * @param number
	 * @param ratio
	 * @param hotelID
	 * @return
	 * @throws RemoteException 
	 */
	public ResultMsg changeOverCut(int number,double ratio,String hotelID) throws RemoteException {
		PromotionHotelType type = PromotionHotelType.OVERTHREE_PROMOTION;
		ArrayList<PromotionHotelPO> promotion = promotionHotelDataService.findByType(type,hotelID);
		for(PromotionHotelPO po : promotion) {
			if(po.getNumber() == number) {
				po.setRatio(ratio);
				resultMsg = promotionHotelDataService.update(po);
			}
		}
		return resultMsg;
	}

	/**
	 * 修改双11活动折扣（在特定的期间住宿有折扣）
	 * @param timeBegin
	 * @param timeOver
	 * @param ratio
	 * @param hotelID
	 * @return
	 * @throws RemoteException 
	 */
	public ResultMsg changeHotelCustomCut(String timeBegin, String timeOver, double ratio,String hotelID) throws RemoteException {
		PromotionHotelType type = PromotionHotelType.HOTEL_CUSTOM_PROMOTION;
		ArrayList<PromotionHotelPO> promotion = promotionHotelDataService.findByType(type,hotelID);
		for(PromotionHotelPO po : promotion) {
			if(po.getTimeBegin().equals(timeBegin) && po.getTimeOver().equals(timeOver)) {
				po.setRatio(ratio);
				resultMsg = promotionHotelDataService.update(po);
			}
		}
		return resultMsg;
	}

	/**
	 * 修改合作企业客户折扣
	 * @param businessName
	 * @param ratio
	 * @param hotelID
	 * @return
	 * @throws RemoteException 
	 */
	public ResultMsg changeJoin(String businessName, double ratio,String hotelID) throws RemoteException {
		PromotionHotelType type = PromotionHotelType.JOIN_PROMOTION;
		ArrayList<PromotionHotelPO> promotion = promotionHotelDataService.findByType(type,hotelID);
		for(PromotionHotelPO po : promotion) {
			if(po.getBusinessName().equals(businessName)) {
				po.setRatio(ratio);
				resultMsg = promotionHotelDataService.update(po);
			}
		}
		return resultMsg;
	}

	/**
	 * 获取该酒店的某个策略
	 * @param type
	 * @param hotelID
	 * @return
	 * @throws RemoteException
	 */
	public ArrayList<PromotionHotelVO> getHotelPromotion(PromotionHotelType type,String hotelID) throws RemoteException {
		ArrayList<PromotionHotelPO> list = promotionHotelDataService.findByType(type,hotelID);
		ArrayList<PromotionHotelVO> voList = new ArrayList<>();
		PromotionHotelVO vo;
		for(PromotionHotelPO po : list) {
			vo = (PromotionHotelVO)VOPOchange.POtoVO(po);
			voList.add(vo);
		}
		return voList;
	}

	/**
	 * 添加生日特惠折扣
	 * @param level
	 * @param radio
	 * @param hotelID
	 * @return
	 * @throws RemoteException 
	 */
	public ResultMsg addBirthCut(int level, double ratio,String hotelID) throws RemoteException {
		PromotionHotelType type = PromotionHotelType.BIRTH_PROMOTION;
		ArrayList<PromotionHotelPO> promotion = promotionHotelDataService.findByType(type,hotelID);
		for(PromotionHotelPO po : promotion) {
			if(po.getLevel() == level) {
				return resultMsg;
			}
		}
		PromotionHotelPO po = new PromotionHotelPO(null, type, hotelID, level, ratio);
		resultMsg = promotionHotelDataService.insert(po);
		return resultMsg;
	}

	/**
	 * 添加三间及以上预订特惠
	 * @param number
	 * @param ratio
	 * @param hotelID
	 * @return
	 * @throws RemoteException 
	 */
	public ResultMsg addOverCut(int number, double ratio,String hotelID) throws RemoteException {
		PromotionHotelType type = PromotionHotelType.OVERTHREE_PROMOTION;
		ArrayList<PromotionHotelPO> promotion = promotionHotelDataService.findByType(type,hotelID);
		for(PromotionHotelPO po : promotion) {
			if(po.getNumber() == number) {
				return resultMsg;
			}
		}
		PromotionHotelPO po = new PromotionHotelPO(null, type, hotelID, number, ratio);
		resultMsg = promotionHotelDataService.insert(po);
		return resultMsg;
	}

	/**
	 * 添加合作企业客户折扣
	 * @param businessName
	 * @param ratio
	 * @param hotelID
	 * @return
	 * @throws RemoteException 
	 */
	public ResultMsg addJoin(String businessName, double ratio,String hotelID) throws RemoteException {
		PromotionHotelType type = PromotionHotelType.JOIN_PROMOTION;
		ArrayList<PromotionHotelPO> promotion = promotionHotelDataService.findByType(type,hotelID);
		for(PromotionHotelPO po : promotion) {
			if(po.getBusinessName().equals(businessName)) {
				return resultMsg;
			}
		}
		PromotionHotelPO po = new PromotionHotelPO(null, type, hotelID, businessName, ratio);
		resultMsg = promotionHotelDataService.insert(po);
		return resultMsg;
	}

	/**
	 * 添加双11活动折扣（在特定的期间住宿有折扣）
	 * @param timeBegin
	 * @param timeOver
	 * @param ratio
	 * @param hotelID
	 * @return
	 * @throws RemoteException 
	 */
	public ResultMsg addHotelCustomCut(String timeBegin, String timeOver, double ratio,String hotelID) throws RemoteException {
		PromotionHotelType type = PromotionHotelType.HOTEL_CUSTOM_PROMOTION;
		ArrayList<PromotionHotelPO> promotion = promotionHotelDataService.findByType(type,hotelID);
		for(PromotionHotelPO po : promotion) {
			if(po.getTimeBegin().equals(timeBegin) && po.getTimeOver().equals(timeOver)) {
				return resultMsg;
			}
		}
		PromotionHotelPO po = new PromotionHotelPO(null, type, hotelID, timeBegin, timeOver, ratio);
		resultMsg = promotionHotelDataService.insert(po);
		return resultMsg;
	}
	
	/**
	 * 删除生日特惠折扣
	 * @param level
	 * @param hotelID
	 * @return
	 * @throws RemoteException
	 */
	public ResultMsg deleteBirthCut(int level,String hotelID) throws RemoteException {
		PromotionHotelType type = PromotionHotelType.BIRTH_PROMOTION;
		ArrayList<PromotionHotelPO> promotion = promotionHotelDataService.findByType(type,hotelID);
		for(PromotionHotelPO po : promotion) {
			if(po.getLevel() == level) {
				resultMsg = promotionHotelDataService.deleteBirthCut(po.getLevel(),po.getHotelID());
			}
		}
		return resultMsg;
	}
	
	/**
	 * 删除三间及以上预订特惠
	 * @param number
	 * @param hotelID
	 * @return
	 * @throws RemoteException
	 */
	public ResultMsg deleteOverCut(int number, String hotelID) throws RemoteException {
		PromotionHotelType type = PromotionHotelType.OVERTHREE_PROMOTION;
		ArrayList<PromotionHotelPO> promotion = promotionHotelDataService.findByType(type,hotelID);
		for(PromotionHotelPO po : promotion) {
			if(po.getNumber() == number) {
				resultMsg = promotionHotelDataService.deleteOverCut(po.getNumber(),po.getHotelID());
			}
		}
		return resultMsg;
	}
	
	/**
	 * 删除合作企业客户折扣
	 * @param businessName
	 * @param hotelID
	 * @return
	 * @throws RemoteException
	 */
	public ResultMsg deleteJoin(String businessName, String hotelID) throws RemoteException {
		PromotionHotelType type = PromotionHotelType.JOIN_PROMOTION;
		ArrayList<PromotionHotelPO> promotion = promotionHotelDataService.findByType(type,hotelID);
		for(PromotionHotelPO po : promotion) {
			if(po.getBusinessName().equals(businessName)) {
				resultMsg = promotionHotelDataService.deleteJoin(po.getBusinessName(),po.getHotelID());
			}
		}
		return resultMsg;
	}
	
	/**
	 * 删除双11活动折扣（在特定的期间住宿有折扣）
	 * @param timeBegin
	 * @param timeOver
	 * @param hotelID
	 * @return
	 * @throws RemoteException
	 */
	public ResultMsg deleteHotelCustomCut(String timeBegin,String timeOver, String hotelID) throws RemoteException {
		PromotionHotelType type = PromotionHotelType.HOTEL_CUSTOM_PROMOTION;
		ArrayList<PromotionHotelPO> promotion = promotionHotelDataService.findByType(type,hotelID);
		for(PromotionHotelPO po : promotion) {
			if(po.getTimeBegin().equals(timeBegin) 
					&& po.getTimeOver().equals(timeOver)) {
				resultMsg = promotionHotelDataService.deleteHotelCustomCut(po.getTimeBegin(),po.getTimeOver(),po.getHotelID());
			}
		}
		return resultMsg;
	}

}
