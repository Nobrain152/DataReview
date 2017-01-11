package user;


import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

import bl.userbl.WebInfoManagementController;
import util.UserType;
import vo.UserInfoVO;
//pass
public class WebInfoManagementControllerTest {

	WebInfoManagementController impl;
	
	@Before
	public void setUp() {
		impl=new WebInfoManagementController();
	}

	
	@Test
	public void testmodify(){
		UserInfoVO v=new UserInfoVO("42345678","LILY","15160897654","6666");
		v.setType(UserType.WebManager);
		impl.individualInfoMod("42345678", v);
		assertEquals(v.getUsername(),"LILY");
		
	}
	
	

}
