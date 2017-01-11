package blservice.userblservice;



import util.ResultMsg;
import vo.StuffInfoVO;

public class StuffIndividualInformationManagementBLService_Driver {

	 public static void main(String[] args){
			
		 StuffIndividualInformationManagementBLService a=new StuffIndividualInformationManagementBLService_Stub();
		 StuffIndividualInformationManagementBLService_Driver b=new StuffIndividualInformationManagementBLService_Driver();
		   b.drive(a);
		
		}
		
		public void drive(StuffIndividualInformationManagementBLService a){
			StuffInfoVO s=a.individualInfolnq("22345678");
			ResultMsg res=a.individualInfoMod("22345678",new StuffInfoVO());
		}
}
