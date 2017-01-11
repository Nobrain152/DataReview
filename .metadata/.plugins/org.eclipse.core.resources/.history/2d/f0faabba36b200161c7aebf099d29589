package bl.hotelbl;



import java.util.ArrayList;

import blservice.hotelblservice.HotelEvaluateBLService;
import dataservice.hoteldataservice.HotelEvaluateDataService;
import util.EvaluationMsg;
import util.ResultMsg;
import vo.HotelEvaluateVO;

public class HotelEvaluateController implements HotelEvaluateBLService{
	public ArrayList<HotelEvaluateVO> evaluationList;
	private HotelEvaluate hotelEvaluate;
	private HotelEvaluateDataService hotelEvaluateDataService;
	
	public HotelEvaluateController() {
		evaluationList = new ArrayList<HotelEvaluateVO>();
	}
	
	/**
	 * 输入评价
	 *
	 */
	@Override
	public EvaluationMsg inputEvaluate(HotelEvaluateVO evaluateInfoVO){
		return new EvaluationMsg(evaluateInfoVO.getScore(),evaluateInfoVO.getComment(),
				evaluateInfoVO.isReserved());
	}
	
	
   /**
     * 检查是否在已执行订单中
     * 
     */
	@Override
   public ResultMsg checkOrder(HotelEvaluateVO evaluateInfoVO){
	   if(evaluateInfoVO.isReserved()){
		   return new ResultMsg(true,"完成评价");
	   }
	   else{
		   return new ResultMsg(false,"评价出错");
	   }
   }
   
   
  
	
}