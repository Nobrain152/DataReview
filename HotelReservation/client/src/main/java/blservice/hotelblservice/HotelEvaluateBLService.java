package blservice.hotelblservice;

import java.util.ArrayList;

import util.ResultMsg;
import vo.HotelEvaluateVO;

/**
 * 评价酒店的接口
 * @author 曹畅
 *
 */
public interface HotelEvaluateBLService {
	
	/**
	 * 添加评论
	 * @param evaluateInfoVO
	 * @return
	 */
	public ResultMsg inputEvaluate(HotelEvaluateVO evaluateInfoVO);
		
   /**
    * 检查是否在已预订
    * @param orderListVO
    * @return
    */
   public ResultMsg checkOrder(HotelEvaluateVO orderListVO);
   
   /**
    * 查看某一酒店的评价
    * @param hotelid
    * @return
    */
   public ArrayList<HotelEvaluateVO> getEvaluate(String hotelid);
  
}