package blservice.userblservice;

import java.util.ArrayList;

import util.ResultMsg;
import vo.OrderVO;
import vo.PromotionWebVO;

public class WebStuffWebsiteManagementBLService_Stub  implements WebStuffWebsiteManagementBLService{

	
	ArrayList<PromotionWebVO> web;
	ArrayList<OrderVO> order;
	
	public WebStuffWebsiteManagementBLService_Stub(){
		web=new ArrayList<PromotionWebVO>();
		order=new ArrayList<OrderVO>();
	}
	
	@Override
	public ArrayList<PromotionWebVO> websiteStrategeInq(PromotionWebVO vo) {
		
		return web;
	}

	@Override
	public boolean websiteStrategeCreate(PromotionWebVO vo) {
		
		return true;
	}

	@Override
	public ResultMsg websiteStrategeMod(PromotionWebVO vo) {
		
		return ResultMsg.SUCCESS;
	}

	@Override
	public ResultMsg websiteStrategeDelete(PromotionWebVO vo) {
		
		return ResultMsg.SUCCESS;
	}

	@Override
	public ArrayList<OrderVO> abnormalOrderScan() {
		
		return order;
	}

	@Override
	public int userCreditInq(String userid) {
		
		return 100;
	}

	@Override
	public ResultMsg userCreditMod(String userid, int n) {
		
		return ResultMsg.SUCCESS;
	}

	@Override
	public ArrayList<OrderVO> dayUnexOrder(String today) {
		
		return order;
	}

}
