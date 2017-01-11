package user;


import static org.junit.Assert.assertEquals;

import java.util.ArrayList;

import org.junit.Before;
import org.junit.Test;

import bl.userbl.WebManagerHotelOperationController;
import bl.userbl.WebManagerWebsiteManagementController;
import util.ResultMsg;
import util.UserType;
import vo.StuffInfoVO;
import vo.UserInfoVO;

//pass
public class WebManagerWebsiteManagementControllerTest {

	WebManagerWebsiteManagementController impl;
	WebManagerHotelOperationController impl1;
	UserInfoVO info;
	StuffInfoVO stuff;
	
	@Before
	public void setUp() {
		impl=new WebManagerWebsiteManagementController();
		impl1=new WebManagerHotelOperationController();
		info=new UserInfoVO("32345678","LIly","13124567893","666666");
		stuff=new StuffInfoVO("22345679","Larry","12345678123","5002","22345679");
	}

	/*@Test
	public void testinquiry() {
		UserInfoVO vo=impl.UserInformationInquiry("42345678");
		assertEquals(vo.getUsername(),"LILY");
	}*/
	
	
	@Test
	public void testmodify(){
		info.setType(UserType.WebStuff);
		assertEquals(impl.userInfoMod("32345678", info),ResultMsg.SUCCESS);
	}
	
	
	
	/*@Test
	public void testScan(){
		ArrayList<UserInfoVO> stuff=impl.WebStuffScan();
	    assertEquals(stuff.get(0).getUsername(),"Mary");
	}*/
	
	/*@Test
	public void testadd(){
		stuff.setType(UserType.HotelStuff);
		assertEquals(impl1.StuffAdd(stuff),"20000003");
	}*/
}
