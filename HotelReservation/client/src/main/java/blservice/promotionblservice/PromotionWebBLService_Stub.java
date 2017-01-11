package blservice.promotionblservice;
import java.util.ArrayList;

import util.Area;
import util.PromotionWebType;
import util.ResultMsg;
import vo.PromotionWebVO;


public class PromotionWebBLService_Stub implements PromotionWebBLService{
	String ratio;
	String timeBegin;
	String timeOver;
	int maxLevel = 10;
	int minLevel = 1;
	public PromotionWebBLService_Stub(){
		ratio = "0";
		timeBegin = "2016/10/10";
		timeOver = "2016/10/16";
	}
	public PromotionWebBLService_Stub(String ratio,String timeBegin,String timeOver){
		this.ratio = ratio;
		this.timeBegin = timeBegin;
		this.timeOver = timeOver;
	}
	@Override
	public ResultMsg changeLevelCut(int level, double ratio) {
		return ResultMsg.SUCCESS;
	}
	@Override
	public ResultMsg changeCircleCut(Area location, double ratio) {
		return ResultMsg.SUCCESS;
	}
	@Override
	public ResultMsg changeWebCustomCut(String timeBegin, String timeOver, double ratio) {
		return ResultMsg.SUCCESS;
	}
	@Override
	public ResultMsg addLevelCut(int level, double ratio) {
		return ResultMsg.SUCCESS;
	}
	@Override
	public ResultMsg addCircleCut(Area location, double ratio) {
		return ResultMsg.SUCCESS;
	}
	@Override
	public ResultMsg addWebCustomCut(String timeBegin, String timeOver, double ratio) {
		return ResultMsg.SUCCESS;
	}
	@Override
	public ResultMsg deleteLevelCut(int level) {
		return ResultMsg.SUCCESS;
	}
	@Override
	public ResultMsg deleteCircleCut(Area location) {
		return ResultMsg.SUCCESS;
	}
	@Override
	public ResultMsg deleteWebCustomCut(String timeBegin, String timeOver) {
		return ResultMsg.SUCCESS;
	}
	@Override
	public ArrayList<PromotionWebVO> getWebPromotion(PromotionWebType type) {
		return null;
	}


	
}