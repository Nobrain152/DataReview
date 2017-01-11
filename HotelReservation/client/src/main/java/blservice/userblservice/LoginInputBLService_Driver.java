package blservice.userblservice;


import util.UserType;
import vo.CustomerInfoVO;


public class LoginInputBLService_Driver {

	 public static void main(String[] args){
			
		 LoginInputBLService a=new LoginInputBLService_Stub();
		 LoginInputBLService_Driver b=new LoginInputBLService_Driver();
		   b.drive(a);
		
		}
		
		public void drive(LoginInputBLService a){
			boolean b=a.LogIn("12345657","12345678");
			b=a.LogOut(true);
			String s=a.Register(new CustomerInfoVO());
			UserType t=a.getType("12345678");
		}
}
