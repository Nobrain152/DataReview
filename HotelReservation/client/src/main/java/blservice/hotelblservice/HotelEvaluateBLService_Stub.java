package blservice.hotelblservice;

import java.util.ArrayList;

import util.ResultMsg;
import vo.HotelEvaluateVO;

public class HotelEvaluateBLService_Stub implements HotelEvaluateBLService {

	ArrayList<HotelEvaluateVO> ee;
	
   public HotelEvaluateBLService_Stub(){
		ee=new ArrayList<HotelEvaluateVO>();
	}
	
	@Override
	public ResultMsg inputEvaluate(HotelEvaluateVO evaluateInfoVO) {
		return ResultMsg.SUCCESS;
	}

	@Override
	public ResultMsg checkOrder(HotelEvaluateVO orderListVO) {
		
		return ResultMsg.SUCCESS;
	}

	@Override
	public ArrayList<HotelEvaluateVO> getEvaluate(String hotelid) {
		
		return ee;
	}

}
