package blservice.userblservice;

import util.UserType;
import vo.CustomerInfoVO;

public class LoginInputBLService_Stub implements LoginInputBLService{

	
	@Override
	public boolean LogIn(String id, String password) {
		
		return true;
	}

	@Override
	public boolean LogOut(boolean ok) {
		
		return true;
	}

	@Override
	public String Register(CustomerInfoVO vo) {
		
		return "10000000";
	}

	@Override
	public UserType getType(String userid) {
		
		return UserType.Customer;
	}

}
