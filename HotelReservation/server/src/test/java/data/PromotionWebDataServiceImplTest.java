package data;

import static org.junit.Assert.*;

import java.rmi.RemoteException;
import java.util.ArrayList;import javax.naming.spi.DirStateFactory.Result;

import org.junit.Before;
import org.junit.Test;

import data.promotiondata.PromotionWebDataServiceImpl;
import po.PromotionWebPO;
import util.Area;
import util.PromotionWebType;
import util.ResultMsg;

public class PromotionWebDataServiceImplTest {
	
	PromotionWebDataServiceImpl impl;
	PromotionWebPO po;

	@Before
	public void setUp() throws Exception {
		impl = new PromotionWebDataServiceImpl();
		po = new PromotionWebPO(null, PromotionWebType.VIP_CIRCLE_PROMOTION, Area.WEST,0.9);
	}

	@Test
	public void testInsert() throws RemoteException{
		ResultMsg resultMsg = impl.insert(po);
		assertEquals(ResultMsg.SUCCESS, resultMsg);
	}
	
	@Test
	public void testGet() throws RemoteException{
		ArrayList<PromotionWebPO> pos = impl.findByType(PromotionWebType.VIP_CIRCLE_PROMOTION);
		assertEquals(pos.get(0).getRatio(), 0.95,0.01);
	}
	
	@Test
	public void testDelete() throws RemoteException{
		ResultMsg resultMsg = impl.deleteLevelCut(1);
		assertEquals(ResultMsg.SUCCESS, resultMsg);
	}
	
	@Test
	public void testFindByType() throws RemoteException{
		ArrayList<PromotionWebPO> pos = impl.findByType(PromotionWebType.VIP_CIRCLE_PROMOTION);
		assertEquals(pos.get(0).getType(),PromotionWebType.VIP_CIRCLE_PROMOTION);
	}

}
