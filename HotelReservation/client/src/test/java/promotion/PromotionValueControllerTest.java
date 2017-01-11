package promotion;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import bl.promotionbl.PromotionValueController;
import util.OrderState;
import util.PromotionHotelType;
import util.PromotionWebType;
import util.RoomType;
import util.VipType;
import vo.CustomerInfoVO;
import vo.OrderVO;

public class PromotionValueControllerTest {
	PromotionValueController promotionImpl;
	CustomerInfoVO customerInfoVO1,customerInfoVO2;
	OrderVO orderVO1,orderVO2,orderVO3,orderVO4,orderVO5,orderVO6,orderVO7;
	
	
	@Before
	public void setUp() throws Exception {
		promotionImpl = new PromotionValueController();
		
		customerInfoVO1 = new CustomerInfoVO("19954722", "txin", "sdf","18805156300", 300, true, VipType.COMMON_VIP);
		customerInfoVO2 = new CustomerInfoVO("19954723", "nanjing", "12345678910", "lo", 300, true, VipType.COMPANY_VIP);
		
		orderVO1 = new OrderVO("20161222",customerInfoVO1, 
				OrderState.UNEXECUTED, 99.9, "5000", false, 
				"2016-12-23 24:00", "2016-12-23 12:00", "2016-12-24 12:00", null,
				1, null,1,RoomType.ROOM_STANDARD);
		
		orderVO2 = new OrderVO("20161223", customerInfoVO2, 
				OrderState.UNEXECUTED, 200, "5000", false,
				"2016-12-23 24:00", "2016-12-23 12:00", "2016-12-24 12:00", null,
				1, null, 5,RoomType.ROOM_STANDARD);
		
		orderVO3 = new OrderVO("20161223", customerInfoVO2, 
				OrderState.UNEXECUTED, 200, "5000", false,
				"2016-12-23 24:00", "2016-12-23 12:00", "2016-12-24 12:00", null,
				3, null, 5,RoomType.ROOM_STANDARD);
		
		orderVO4 = new OrderVO("20161222",customerInfoVO1, 
				OrderState.UNEXECUTED, 99.9, "5000", false, 
				"2016-12-23 24:00", "2016-12-23 12:00", "2016-12-24 12:00", null,
				1, null,1,RoomType.ROOM_STANDARD);
		
		orderVO5 = new OrderVO("20161222",customerInfoVO1, 
				OrderState.UNEXECUTED, 99.9, "5000", false, 
				"2016-12-23 24:00", "2016-12-23 12:00", "2016-12-24 12:00", null,
				1, null,1,RoomType.ROOM_STANDARD);
		
		orderVO6 = new OrderVO("20161222",customerInfoVO1, 
				OrderState.UNEXECUTED, 99.9, "5000", false, 
				"2016-12-23 24:00", "2016-12-23 12:00", "2016-12-24 12:00", null,
				1, null,1,RoomType.ROOM_STANDARD);
		
		orderVO7 = new OrderVO("20161222",customerInfoVO1, 
				OrderState.UNEXECUTED, 99.9, "5000", false, 
				"2016-12-23 24:00", "2016-12-23 12:00", "2016-12-24 12:00", null,
				1, null,1,RoomType.ROOM_STANDARD);
	}

	@Test
	public void testGetValue() {
		double d1 = promotionImpl.getValue(customerInfoVO1, orderVO1,PromotionHotelType.BIRTH_PROMOTION);
		assertEquals(d1,99.9*0.85,0.01);
		
		
		double d4 = promotionImpl.getValue(customerInfoVO1, orderVO4,PromotionHotelType.HOTEL_CUSTOM_PROMOTION);
		assertEquals(d4,99.9*0.12,0.01);
		
		double d2 = promotionImpl.getValue(customerInfoVO2, orderVO2,PromotionHotelType.JOIN_PROMOTION);
		assertEquals(d2,200*0.5,0.01);
		
		double d3 = promotionImpl.getValue(customerInfoVO1, orderVO3,PromotionHotelType.OVERTHREE_PROMOTION);
		assertEquals(d3,200*0.95,0.01);
		
		double d5 = promotionImpl.getValue(customerInfoVO1, orderVO5, PromotionWebType.VIP_LEVEL_PROMOTION);
		assertEquals(d5, 99.9*0.9,0.01);
		
		double d6 = promotionImpl.getValue(customerInfoVO1, orderVO6, PromotionWebType.VIP_CIRCLE_PROMOTION);
		assertEquals(d6, 99.9*0.8,0.01);
		
		double d7 = promotionImpl.getValue(customerInfoVO1, orderVO7, PromotionWebType.WEB_CUSTOM_PROMOTION);
		assertEquals(d7, 99.9*0.95,0.01);
		
	}

}
