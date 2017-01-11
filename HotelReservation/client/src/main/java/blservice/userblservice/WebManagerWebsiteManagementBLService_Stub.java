package blservice.userblservice;

import java.util.ArrayList;

import util.ResultMsg;
import vo.UserInfoVO;

public class WebManagerWebsiteManagementBLService_Stub implements WebManagerWebsiteManagementBLService {

	
	UserInfoVO user;
	ArrayList<UserInfoVO> scan;
	
	public WebManagerWebsiteManagementBLService_Stub(){
		
		user=new UserInfoVO("32345678","Dany","1234567898","32345678");
		scan=new ArrayList<UserInfoVO>();
		scan.add(user);
	}
	
	
	@Override
	public UserInfoVO userInfoInq(String userid) {
		
		return user;
	}

	@Override
	public ResultMsg userInfoMod(String userid, UserInfoVO vo2) {
		
		return ResultMsg.SUCCESS;
	}

	@Override
	public ArrayList<UserInfoVO> webStuffScan() {
		
		return scan;
	}

	@Override
	public String addWebStuff(UserInfoVO vo) {
		
		return "33345678";
	}

}
