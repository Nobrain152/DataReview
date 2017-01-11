package blservice.hotelblservice;

import java.util.ArrayList;

import util.ResultMsg;
import vo.HotelEvaluateVO;

public class HotelEvaluateBLService_Driver {

  public static void main(String[] args){
		
	  HotelEvaluateBLService a=new HotelEvaluateBLService_Stub();
	  HotelEvaluateBLService_Driver b=new HotelEvaluateBLService_Driver();
		b.drive(a);
	
	}
	
	public void drive(HotelEvaluateBLService a){
		ResultMsg r=a.checkOrder(new HotelEvaluateVO());
		r=a.inputEvaluate(new HotelEvaluateVO());
		ArrayList<HotelEvaluateVO> arrayList=a.getEvaluate("5000");
	
	}
}
