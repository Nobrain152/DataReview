package blservice.userblservice;

import java.util.ArrayList;

import util.ResultMsg;
import vo.UserInfoVO;

public class WebManagerWebsiteManagementBLService_Driver {

	 public static void main(String[] args){
			
		 WebManagerWebsiteManagementBLService a=new WebManagerWebsiteManagementBLService_Stub();
		 WebManagerWebsiteManagementBLService_Driver b=new WebManagerWebsiteManagementBLService_Driver();
		   b.drive(a);
		
		}
		
		public void drive(WebManagerWebsiteManagementBLService a){
			ArrayList<UserInfoVO> u;
			
			u=a.webStuffScan();
			UserInfoVO uu=a.userInfoInq("32345678");
			ResultMsg res=a.userInfoMod("32345678",new UserInfoVO());
			String ss=a.addWebStuff(new UserInfoVO());
		}
}
