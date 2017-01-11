package blservice.promotionblservice;

import util.OrderState;
import util.PromotionHotelType;
import util.RoomType;
import vo.CustomerInfoVO;
import vo.OrderVO;

public class PromotionValueBLService_Driver {
	
	public static void main(String[] args){
	
		PromotionValueBLService_Stub a=new PromotionValueBLService_Stub();
		PromotionValueBLService_Driver b=new PromotionValueBLService_Driver();
		b.drive(a);
	
	}
	
	public void drive(PromotionValueBLService a){
		CustomerInfoVO client = new CustomerInfoVO("1000066", "123", "12345678910", "sfd", 0, false, null);
		OrderVO orderVO = new OrderVO("60000010", client, OrderState.UNEXECUTED, 100, "5000", false, "", "", "", "", 1, null, 1, RoomType.ROOM_BIGBED);
	
		double re = a.getValue(client, orderVO, PromotionHotelType.BIRTH_PROMOTION);
		if(re == 0)
			System.out.println("得到价格成功");
		else
			System.out.println("失败");
	}
}