package blservice.userblservice;

import java.util.ArrayList;

import util.ResultMsg;
import vo.HotelInfoVO;
import vo.OrderVO;
import vo.PromotionWebVO;

public class WebStuffWebsiteManagementBLService_Driver {

	 public static void main(String[] args){
			
		 WebStuffWebsiteManagementBLService a=new WebStuffWebsiteManagementBLService_Stub();
		 WebStuffWebsiteManagementBLService_Driver b=new WebStuffWebsiteManagementBLService_Driver();
		   b.drive(a);
		
		}
		
		public void drive(WebStuffWebsiteManagementBLService a){
			ArrayList<HotelInfoVO> hotelInfoVOs;
			HotelInfoVO hotel;
			ArrayList<OrderVO> order;
			ArrayList<PromotionWebVO> pp;
			pp=a.websiteStrategeInq(new PromotionWebVO());
			boolean bb=a.websiteStrategeCreate(new PromotionWebVO());
			ResultMsg res=a.websiteStrategeDelete(new PromotionWebVO());
			res=a.websiteStrategeMod(new PromotionWebVO());
			order=a.abnormalOrderScan();
			int ii=a.userCreditInq("12345678");
			res=a.userCreditMod("12345678",100);
			order=a.dayUnexOrder("");
		}
}
