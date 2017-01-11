package blservice.promotionblservice;

import util.Area;
import util.ResultMsg;

public class PromotionWebBLService_Driver {
	
	public static void main(String[] args){
		
		PromotionWebBLService a=new PromotionWebBLService_Stub();
		PromotionWebBLService_Driver b=new PromotionWebBLService_Driver();
		b.drive(a);
	
	}
	
	public void drive(PromotionWebBLService a){
		
		ResultMsg resultMsg = a.addCircleCut(Area.EAST, 0.9);
		if(resultMsg == ResultMsg.SUCCESS)
			System.out.println("添加成功");
		else
			System.out.println("添加失败");
	}
}