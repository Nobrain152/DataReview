package data;

import static org.junit.Assert.*;

import java.rmi.RemoteException;
import java.util.ArrayList;

import org.junit.Before;
import org.junit.Test;

import data.promotiondata.PromotionHotelDataServiceImpl;
import po.PromotionHotelPO;
import util.MyDate;
import util.PromotionHotelType;
import util.ResultMsg;

public class PromotionHotelDataServiceImplTest {

	PromotionHotelDataServiceImpl impl;
	PromotionHotelPO po;
	
	@Before
	public void setUp() throws Exception {
		impl = new PromotionHotelDataServiceImpl();
//		po = new PromotionHotelPO(PromotionHotelType.OVERTHREE_PROMOTION, "5004", 3, 2.33);
		po = new PromotionHotelPO("111111111",PromotionHotelType.HOTEL_CUSTOM_PROMOTION,"5000",
				MyDate.getNowTime().toString(),MyDate.getNowTime().toString() , 0.9);
	}

	@Test
	public void testInsert() throws RemoteException {
		ResultMsg aMsg = impl.insert(po);
		assertEquals(aMsg, ResultMsg.SUCCESS);
	}
	
	@Test
	public void testDeleteOverCut() throws RemoteException {
		ResultMsg aMsg = impl.deleteOverCut(3, "5002");
		assertEquals(aMsg, ResultMsg.SUCCESS);
	}
	
	@Test
	public void testFindByType() throws RemoteException{
		ArrayList<PromotionHotelPO> arr = impl.findByType(PromotionHotelType.BIRTH_PROMOTION, "5000");
		assertEquals(2, arr.get(0).getLevel());
	}
	
	@Test
	public void testUpdate() throws RemoteException{
		ResultMsg resultMsg = impl.update(po);
		assertEquals(ResultMsg.SUCCESS, resultMsg);
	}
	
	@Test
	public void testDeleteBirthCut() throws RemoteException {
		ResultMsg aMsg = impl.deleteBirthCut(3, "5002");
		assertEquals(aMsg, ResultMsg.SUCCESS);
	}

}
