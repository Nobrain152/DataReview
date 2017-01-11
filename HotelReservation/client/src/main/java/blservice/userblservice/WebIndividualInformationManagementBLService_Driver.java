package blservice.userblservice;



import util.ResultMsg;
import vo.UserInfoVO;

public class WebIndividualInformationManagementBLService_Driver {

	 public static void main(String[] args){
			
		 WebIndividualInformationManagementBLService a=new WebIndividualInformationManagementBLService_Stub();
		 WebIndividualInformationManagementBLService_Driver b=new WebIndividualInformationManagementBLService_Driver();
		   b.drive(a);
		
		}
		
		public void drive(WebIndividualInformationManagementBLService a){
			UserInfoVO u=a.individualInfolnq("32345678");
			ResultMsg res=a.individualInfoMod("32345678",new UserInfoVO());
		}
}
