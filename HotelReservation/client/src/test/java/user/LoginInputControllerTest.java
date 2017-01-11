package user;


import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

import bl.userbl.LoginInputController;
import util.UserType;
import util.VipType;
import vo.CustomerInfoVO;
//pass
public class LoginInputControllerTest {
        //LoginInVO vo;
		LoginInputController im;
		
		@Before
		public void setUp() {
			//vo=new LoginInVO("Tom","12345679");
			im=new LoginInputController();
		}

		@Test
		public void testLogin() {
			boolean result=im.LogIn("12345678","12345678");
			assertEquals(result,true);
		}
		
		@Test
		public void testLogout(){
			boolean result=im.LogOut(true);
			assertEquals(result,true);
		}
		
		@Test
		public void testregister(){
			CustomerInfoVO vo=new CustomerInfoVO("","Tom","12345678910","12345679",100,false,VipType.COMMON_VIP);
			//vo.setPassword("12345679");
			vo.setType(UserType.Customer);
			vo.setType(UserType.Customer);
		    String result=im.Register(vo);
		    assertEquals("10000067",result);
		}
	

}


