package promotion;

import static org.junit.Assert.assertEquals;

import java.rmi.RemoteException;
import java.util.ArrayList;

import org.junit.Before;
import org.junit.Test;

import bl.promotionbl.PromotionWebController;
import blservice.promotionblservice.PromotionWebBLService;
import po.PromotionWebPO;
import vo.PromotionWebVO;
import util.Area;
import util.PromotionWebType;
import util.ResultMsg;

public class PromotionWebControllerTest {

	PromotionWebBLService web;
	PromotionWebVO web1,web2,web3;
	ResultMsg resultMsg = ResultMsg.FAIL;
	
	@Before
	public void setUp() throws Exception {
		web = new PromotionWebController();
		web1 = new PromotionWebVO(null, PromotionWebType.VIP_CIRCLE_PROMOTION, Area.EAST, 0.8);
		web2 = new PromotionWebVO(null, PromotionWebType.VIP_LEVEL_PROMOTION,1,0.95);
		web3 = new PromotionWebVO(null, PromotionWebType.WEB_CUSTOM_PROMOTION,"2016-12-22 00:00","2016-12-26 24:00", 0.77);
		web.addCircleCut(Area.EAST, 0.8);
		web.addLevelCut(1, 0.95);
		web.addWebCustomCut("2016-12-22 00:00", "2016-12-26 24:00", 0.95);
		web.addCircleCut(Area.NORTH, 0.5);
		web.addLevelCut(3, 0.5);
		web.addWebCustomCut("2016-11-11 00:00", "2016-11-11 24:00", 0.5);
	}

	
	@Test
	public void testChangeCircleCut() throws RemoteException{
		double ratio = 1.00;
		resultMsg = web.changeCircleCut(Area.NORTH, 0.9);
		ArrayList<PromotionWebVO> vos = web.getWebPromotion(PromotionWebType.VIP_CIRCLE_PROMOTION);
		for(PromotionWebVO vo : vos){
			if(vo.getLocation() == Area.NORTH){
				ratio = vo.getRatio();
				break;
			}
		}
		assertEquals(ratio, 0.9, 0.01);
	}
	
	@Test
	public void testChangeLevelCut() throws RemoteException{
		double ratio = 1.00;
		resultMsg = web.changeLevelCut(3, 0.9);
		ArrayList<PromotionWebVO> vos = web.getWebPromotion(PromotionWebType.VIP_LEVEL_PROMOTION);
		for(PromotionWebVO vo : vos){
			if(vo.getLevel() == 3){
				ratio = vo.getRatio();
				break;
			}
		}
		assertEquals(ratio, 0.9, 0.01);
	}
	
	@Test
	public void testChangeWebCustomCut() throws RemoteException{
		double ratio = 1.00;
		resultMsg = web.changeWebCustomCut("2016-11-11 00:00", "2016-11-11 24:00", 0.9);
		ArrayList<PromotionWebVO> vos = web.getWebPromotion(PromotionWebType.WEB_CUSTOM_PROMOTION);
		for(PromotionWebVO vo : vos){
			if(vo.getTimeBegin().equals("2016-11-11 00:00")
					&& vo.getTimeOver().equals("2016-11-11 24:00")){
				ratio = vo.getRatio();
				break;
			}
		}
		assertEquals(ratio, 0.9, 0.01);
	}
	
	@Test
	public void testAddLevelCut() throws RemoteException{
		resultMsg = web.addLevelCut(2, 0.85);
		double ratio = 1.00;
		ArrayList<PromotionWebVO> vos = web.getWebPromotion(PromotionWebType.VIP_LEVEL_PROMOTION);
		for(PromotionWebVO vo : vos){
			if(vo.getLevel() == 2){
				ratio = vo.getRatio();
				break;
			}
		}
		assertEquals(ratio, 0.85, 0.01);
	}
	
	@Test
	public void testAddCircleCut() throws RemoteException{
		resultMsg = web.addCircleCut(Area.WEST, 0.9);
		double ratio = 1.00;
		ArrayList<PromotionWebVO> vos = web.getWebPromotion(PromotionWebType.VIP_CIRCLE_PROMOTION);
		for(PromotionWebVO vo : vos){
			if(vo.getLocation() == Area.WEST){
				ratio = vo.getRatio();
				break;
			}
		}
		assertEquals(ratio, 0.9, 0.01);
	}
	
	@Test
	public void testAddWebCustomCut() throws RemoteException{
		resultMsg = web.addWebCustomCut("2016-12-27 00:00", "2016-12-27 24:00", 0.66);
		double ratio = 1.00;
		ArrayList<PromotionWebVO> vos = web.getWebPromotion(PromotionWebType.WEB_CUSTOM_PROMOTION);
		for(PromotionWebVO vo : vos){
			if(vo.getTimeBegin().equals("2016-12-27 00:00")
					&& vo.getTimeOver().equals("2016-12-27 24:00")){
				ratio = vo.getRatio();
				break;
			}
		}
		assertEquals(ratio, 0.66, 0.01);
	}
	
	@Test
	public void testDeleteLevelCut() throws RemoteException{
		resultMsg = web.deleteLevelCut(1);
		assertEquals(ResultMsg.SUCCESS, resultMsg);
	}
	
	@Test
	public void testDeleteCircleCut() throws RemoteException{
		resultMsg = web.deleteCircleCut(Area.EAST);
		assertEquals(ResultMsg.SUCCESS, resultMsg);
	}
	
	@Test
	public void testDeleteWebCustomCut() throws RemoteException{
		resultMsg = web.deleteWebCustomCut("2016-12-22 00:00", "2016-12-26 24:00");
		assertEquals(ResultMsg.SUCCESS, resultMsg);
	}
	
	@Test
	public void testGetWebPromotion() throws RemoteException{
		ArrayList<PromotionWebVO> webProList1 = web.getWebPromotion(PromotionWebType.VIP_CIRCLE_PROMOTION);
		assertEquals(webProList1.size(),3);
		
		ArrayList<PromotionWebVO> webProList2 = web.getWebPromotion(PromotionWebType.VIP_LEVEL_PROMOTION);
		assertEquals(webProList2.size(),3);
		
		ArrayList<PromotionWebVO> webProList3 = web.getWebPromotion(PromotionWebType.WEB_CUSTOM_PROMOTION);
		assertEquals(webProList3.size(),3);
		
	}
}
