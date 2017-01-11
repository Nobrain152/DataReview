package user;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

import bl.userbl.CustomerInfoManagementController;
import util.ResultMsg;
import util.VipType;
import vo.CustomerInfoVO;
import vo.UserInfoVO;
//pass
public class CustomerTest {
	private CustomerInfoManagementController customer;
	private UserInfoVO po;

	@Before
	public void setup(){
		customer=new CustomerInfoManagementController();
		
	}
	
	@Test
	public void testinquiry(){
		
		po = customer.individualInfolnq("12345678");
		assertEquals("12345678",po.getUserID());
		assertEquals("Jerry",po.getUsername());
		assertEquals("13067893451",po.getContact());
	}
	
	@Test
	public void testmodify(){
		CustomerInfoVO vo1=new CustomerInfoVO("12345678","Tom","13067893451","1234567",100,false,VipType.COMMON_VIP);
		ResultMsg cantest = ResultMsg.FAIL;
		cantest = customer.individualInfoMod("12345678",vo1);
		UserInfoVO po = null;
		po = customer.individualInfolnq("12345678");
		if(cantest==ResultMsg.SUCCESS){
			assertEquals("12345678",po.getUserID());
			assertEquals("Tom",po.getUsername());
			assertEquals("13067893451",po.getContact());
			
		}
	}
	
}
