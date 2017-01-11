package blservice.promotionblservice;

import java.util.ArrayList;

import util.PromotionHotelType;
import util.ResultMsg;
import vo.PromotionHotelVO;

public class PromotionHotelBLService_Driver {
	
	public static void main(String[] args){
		
		PromotionHotelBLService a = new PromotionHotelBLService_Stub();
		PromotionHotelBLService_Driver b = new PromotionHotelBLService_Driver();
		b.drive(a);
	
	}
	
	public void drive(PromotionHotelBLService a){
	
		ArrayList<PromotionHotelVO> promotionHotelVOs = new ArrayList<>();
		PromotionHotelVO promotionHotelVO = new PromotionHotelVO("5000", PromotionHotelType.BIRTH_PROMOTION, "5000", 1, 0.9);
		promotionHotelVOs.add(promotionHotelVO);
		
		ResultMsg resultMsg = a.addJoin("5000", 0.9, "5000");
		if(resultMsg == ResultMsg.SUCCESS)
			System.out.println("添加成功");
		else
			System.out.println("添加失败");
		
		resultMsg = a.deleteBirthCut(1, "5000");
		if(resultMsg == ResultMsg.SUCCESS)
			System.out.println("添加成功");
		else
			System.out.println("添加失败");
	}
}