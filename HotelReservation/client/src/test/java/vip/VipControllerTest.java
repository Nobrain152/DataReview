
package vip;

import static org.junit.Assert.assertEquals;

import java.rmi.RemoteException;

import org.junit.Before;
import org.junit.Test;

import bl.vipbl.VipController;
import util.VipType;
import vo.CommonVipVO;
import vo.CustomerInfoVO;
import vo.LevelSystemVO;

public class VipControllerTest {
	private VipController vipController;
	CustomerInfoVO customerInfoVO;
	
	@Before
	public void setUp() throws Exception {
		vipController = new VipController();
		customerInfoVO = new CustomerInfoVO("19954722", "txin", "18805156300", "ve", 300, true, VipType.COMMON_VIP);
	}
	
	@Test
	public void testRegisterVip() throws RemoteException {
		vipController.registerVip(customerInfoVO.getUserID(), customerInfoVO.getVipType(), "1997-12-23");
		CommonVipVO commonVipVO = new CommonVipVO("19954722", "txin", "ve", "18805156300", 300, "1997-12-23", VipType.COMMON_VIP);
		assertEquals(commonVipVO.getBirthday(), "1997-12-23");
	}
	
	@Test
	public void testCreateLevelSystem() throws RemoteException{
		LevelSystemVO levelSystemVO = new LevelSystemVO(1, 100);
		vipController.createLevelSystem(levelSystemVO);
		assertEquals(levelSystemVO.getLevels(), 1);
		levelSystemVO = new LevelSystemVO(2, 200);
		vipController.createLevelSystem(levelSystemVO);
		assertEquals(levelSystemVO.getLevels(), 2);
		levelSystemVO = new LevelSystemVO(3, 250);
		vipController.createLevelSystem(levelSystemVO);
		assertEquals(levelSystemVO.getLevels(), 3);
	}
	
	@Test
	public void testSearchLevel() throws RemoteException {
		int level = vipController.searchLevel(customerInfoVO);
		assertEquals(level,3);
	}

}
