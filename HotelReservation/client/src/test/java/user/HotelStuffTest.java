package user;


import static org.junit.Assert.assertEquals;


import org.junit.Before;
import org.junit.Test;


import bl.userbl.StuffInfoManagementController;
import util.ResultMsg;
import util.UserType;
import vo.StuffInfoVO;
import vo.UserInfoVO;
//pass
public class HotelStuffTest {
	private StuffInfoManagementController service;
	
	@Before
	public void setup(){
		service=new StuffInfoManagementController();
		
	}
	
	@Test
	public void testinquiry(){
		UserInfoVO po = null;
		po = service.individualInfolnq("22345678");
		assertEquals(po.getUserID(),"22345678");
		assertEquals(po.getUsername(),"Tim");
		assertEquals(po.getContact(),"18192345782");
	}
	
	@Test
	public void testmodify(){
		StuffInfoVO vo1=new StuffInfoVO("22345678","Tim","18192345782","66666","1234567");
		vo1.setType(UserType.HotelStuff);
		ResultMsg cantest = ResultMsg.FAIL;
		cantest = service.individualInfoMod("22345678",vo1);
		UserInfoVO po = null;
		po = service.individualInfolnq("22345678");
		if(cantest==ResultMsg.SUCCESS){
			assertEquals(po.getUserID(),"22345678");
			assertEquals(po.getUsername(),"Tim");
			assertEquals(po.getContact(),"18192345782");
			
		}
	}

}
