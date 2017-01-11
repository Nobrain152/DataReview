package promotion;

import static org.junit.Assert.assertEquals;

import java.rmi.RemoteException;
import java.util.ArrayList;

import org.junit.Before;
import org.junit.Test;

import bl.promotionbl.PromotionHotelController;
import blservice.promotionblservice.PromotionHotelBLService;
import vo.PromotionHotelVO;
import util.PromotionHotelType;
import util.ResultMsg;

public class PromotionHotelControllerTest {
	
	PromotionHotelBLService hotel;
	PromotionHotelVO hotel1,hotel2,hotel3,hotel4;
	ResultMsg resultMsg = ResultMsg.FAIL;
	
	
	@Before
	public void setUp() throws Exception {
		hotel = new PromotionHotelController();
		hotel1 = new PromotionHotelVO(null, PromotionHotelType.BIRTH_PROMOTION, "5000", 3, 0.85);
		hotel2 = new PromotionHotelVO(null, PromotionHotelType.JOIN_PROMOTION, "5000", "univer", 0.75);
		hotel3 = new PromotionHotelVO(null, PromotionHotelType.HOTEL_CUSTOM_PROMOTION, "5000", "2016-11-11 00:00", "2016-11-11 24:00", 0.88);
		hotel4 = new PromotionHotelVO(null, PromotionHotelType.OVERTHREE_PROMOTION, "5000", 8, 0.5);
		hotel.addOverCut(8, 0.5, "5000");
		hotel.addOverCut(5, 0.85, "5000");
		hotel.addBirthCut(3, 0.85, "5000");
		hotel.addBirthCut(2,0.9,"5000");
		hotel.addJoin("univer", 0.7, "5000");
		hotel.addJoin("nanjing", 0.95, "5000");
		hotel.addHotelCustomCut("2016-11-11 00:00", "2016-11-11 24:00", 0.88, "5000");
		hotel.addHotelCustomCut("2016-12-22 00:00", "2016-12-26 24:00", 0.66, "5000");
	}

	@Test
	public void testgetHotelPromotion() throws RemoteException {
		ArrayList<PromotionHotelVO> hotelProList1 = hotel.getHotelPromotion(PromotionHotelType.BIRTH_PROMOTION,"5000");
		assertEquals(hotelProList1.get(0).getRatio(),hotel1.getRatio(),0.01);
		
		ArrayList<PromotionHotelVO> hotelProList2 = hotel.getHotelPromotion(PromotionHotelType.OVERTHREE_PROMOTION,"5000");
		assertEquals(hotelProList2.get(0).getRatio(),hotel4.getRatio(),0.01);
		
		ArrayList<PromotionHotelVO> hotelProList3 = hotel.getHotelPromotion(PromotionHotelType.HOTEL_CUSTOM_PROMOTION,"5000");
		assertEquals(hotelProList3.get(0).getTimeBegin(),hotel3.getTimeBegin());
		
		ArrayList<PromotionHotelVO> hotelProList4 = hotel.getHotelPromotion(PromotionHotelType.JOIN_PROMOTION,"5000");
		assertEquals(hotelProList4.get(0).getBusinessName(), hotel2.getBusinessName());
	}
	
	@Test
	public void testChangeBirthCut() throws RemoteException{
		resultMsg = hotel.changeBirthCut(2, 0.99, "5000");
		double ratio = 1.00;
		ArrayList<PromotionHotelVO> vos = hotel.getHotelPromotion(PromotionHotelType.BIRTH_PROMOTION, "5000");
		for(PromotionHotelVO vo : vos){
			if(vo.getLevel() == 2){
				ratio = vo.getRatio();
				break;
			}
		}
		assertEquals(ratio, 0.99, 0.01);
	}
	
	@Test
	public void testChangeJoin() throws RemoteException{
		resultMsg = hotel.changeJoin("nanjing", 0.5, "5000");
		double ratio = 1.00;
		ArrayList<PromotionHotelVO> vos = hotel.getHotelPromotion(PromotionHotelType.JOIN_PROMOTION, "5000");
		for(PromotionHotelVO vo : vos){
			if(vo.getBusinessName().equals("nanjing")){
				ratio = vo.getRatio();
				break;
			}
		}
		assertEquals(ratio, 0.5, 0.01);
	}
	
	@Test
	public void testChangeOverCut() throws RemoteException{
		resultMsg = hotel.changeOverCut(5, 0.88, "5000");
		double ratio = 1.00;
		ArrayList<PromotionHotelVO> vos = hotel.getHotelPromotion(PromotionHotelType.OVERTHREE_PROMOTION, "5000");
		for(PromotionHotelVO vo : vos){
			if(vo.getNumber() == 5){
				ratio = vo.getRatio();
				break;
			}
		}
		assertEquals(ratio, 0.88, 0.01);
	}
	
	@Test
	public void testChangeHotelCustomCut() throws RemoteException{
		resultMsg = hotel.changeHotelCustomCut("2016-12-22 00:00", "2016-12-26 24:00", 0.12, "5000");
		double ratio = 1.00;
		ArrayList<PromotionHotelVO> vos = hotel.getHotelPromotion(PromotionHotelType.HOTEL_CUSTOM_PROMOTION, "5000");
		for(PromotionHotelVO vo : vos){
			if(vo.getTimeBegin().equals("2016-12-22 00:00")
					&& vo.getTimeOver().equals("2016-12-26 24:00")){
				ratio = vo.getRatio();
				break;
			}
		}
		assertEquals(ratio, 0.12, 0.01);
	}
	
	@Test 
	public void testAddBirthCut() throws RemoteException{
		resultMsg = hotel.addBirthCut(1, 0.9, "5000");
		double ratio = 1.00;
		ArrayList<PromotionHotelVO> vos = hotel.getHotelPromotion(PromotionHotelType.BIRTH_PROMOTION, "5000");
		for(PromotionHotelVO vo : vos){
			if(vo.getLevel() == 1){
				ratio = vo.getRatio();
				break;
			}
		}
		assertEquals(ratio, 0.9, 0.01);
	}
	
	@Test 
	public void testAddJoin() throws RemoteException{
		resultMsg = hotel.addJoin("software",0.9,"5000");
		double ratio = 1.00;
		ArrayList<PromotionHotelVO> vos = hotel.getHotelPromotion(PromotionHotelType.JOIN_PROMOTION, "5000");
		for(PromotionHotelVO vo : vos){
			if(vo.getBusinessName().equals("software")){
				ratio = vo.getRatio();
				break;
			}
		}
		assertEquals(ratio, 0.9, 0.01);
	}
	
	@Test
	public void testAddOverCut() throws RemoteException{
		resultMsg = hotel.addOverCut(3, 0.95, "5000");
		double ratio = 1.00;
		ArrayList<PromotionHotelVO> vos = hotel.getHotelPromotion(PromotionHotelType.OVERTHREE_PROMOTION, "5000");
		for(PromotionHotelVO vo : vos){
			if(vo.getNumber() == 3){
				ratio = vo.getRatio();
				break;
			}
		}
		assertEquals(ratio, 0.95, 0.01);
	}

	@Test
	public void testAddHotelCustomCut() throws RemoteException{
		resultMsg = hotel.addHotelCustomCut("2016-12-27 00:00", "2016-12-27 24:00", 0.77, "5000");
		double ratio = 1.00;
		ArrayList<PromotionHotelVO> vos = hotel.getHotelPromotion(PromotionHotelType.HOTEL_CUSTOM_PROMOTION, "5000");
		for(PromotionHotelVO vo : vos){
			if(vo.getTimeBegin().equals("2016-12-27 00:00") && vo.getTimeOver().equals("2016-12-27 24:00")){
				ratio = vo.getRatio();
				break;
			}
		}
		assertEquals(ratio, 0.77, 0.01);
	}
	
	@Test
	public void testDeleteBirthCut() throws RemoteException{
		resultMsg = hotel.deleteBirthCut(2, "5000");
		assertEquals(ResultMsg.SUCCESS, resultMsg);
		
	}
	
	@Test
	public void testDeleteJoin() throws RemoteException{
		resultMsg = hotel.deleteJoin("nanjing", "5000");
		assertEquals(ResultMsg.SUCCESS, resultMsg);
	}
	
	@Test
	public void testDeleteOverCut() throws RemoteException{
		resultMsg = hotel.deleteOverCut(5, "5000");
		assertEquals(ResultMsg.SUCCESS, resultMsg);
	}
	
	@Test
	public void testDeleteHotelCustomCut() throws RemoteException{
		resultMsg = hotel.deleteHotelCustomCut("2016-12-22 00:00", "2016-12-26 24:00", "5000");
		assertEquals(ResultMsg.SUCCESS, resultMsg);
	}
}
