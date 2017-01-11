package blservice.userblservice;

import java.util.ArrayList;

import po.CustomerInfoPO;
import util.ResultMsg;
import vo.CreditVO;
import vo.CustomerInfoVO;
import vo.HotelInfoVO;
import vo.OrderVO;
import vo.UserInfoVO;

public class CustomerIndividualInformationManagementBLService_Driver {
	 public static void main(String[] args){
			
		   CustomerIndividualInformationManagementBLService a=new CustomerIndividualInformationManagementBLService_Stub();
		   CustomerIndividualInformationManagementBLService_Driver b=new CustomerIndividualInformationManagementBLService_Driver();
		   b.drive(a);
		
		}
		
		public void drive(CustomerIndividualInformationManagementBLService a){
			UserInfoVO user=a.individualInfolnq("12345678");
			ResultMsg res=a.individualInfoMod("12345678",new CustomerInfoVO());
			res=a.orderCancel(new OrderVO());
			CustomerInfoPO cu=a.getCustomerInfo("12345678");
			CustomerInfoVO cu1=a.individualInfolnq("12345678");
			res=a.individualInfoMod("12345678",new CustomerInfoVO());
			ArrayList<OrderVO> o=a.individualOrderInq("12345678");
			o=a.abnormalOrderInq("12345678");
			o=a.cancelOrderInq("12345678");
			o=a.finishedOrderInq("12345678");
			o=a.unfinishedOrderInq("12345678");
			ArrayList<HotelInfoVO> h=a.individualHotelInq("12345678");
			o=a.abnormalOrderInq("12345678");
			o=a.cancelOrderInq("12345678");
			o=a.finishedOrderInq("12345678");
			o=a.unfinishedOrderInq("12345678");
			int n=a.individualCredictInq("12345678");
			ArrayList<CreditVO> c=a.individualCredictRecord("12345678");
			res=a.orderCancel(new OrderVO());
			a.setCustomerInfo("12345678",new CustomerInfoPO());
		}
}
