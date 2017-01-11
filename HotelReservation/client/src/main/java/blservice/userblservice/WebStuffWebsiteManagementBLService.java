package blservice.userblservice;

import java.rmi.RemoteException;
import java.util.ArrayList;

import util.ResultMsg;
import vo.OrderVO;
import vo.PromotionWebVO;



/**
 * 网站营销人员对网站的操作
 * @author 曹畅
 *
 */
public interface WebStuffWebsiteManagementBLService{
	
	
	
	/**
	 * 查看网站营销策略
	 * @return 网站营销策略列表
	 */
	public ArrayList<PromotionWebVO> websiteStrategeInq(PromotionWebVO vo);
	
	/**
	 * 创建网站促销策略
	 * @param 网站促销策略VO
	 */
	public boolean websiteStrategeCreate(PromotionWebVO vo);
	
	/**
	 * 修改网站促销策略
	 * @param 网站促销策略VO
	 */
	public ResultMsg websiteStrategeMod(PromotionWebVO vo);
	
	/**
	 * 删除网站促销策略
	 * @param 网站促销策略VO
	 */
	public ResultMsg websiteStrategeDelete(PromotionWebVO vo);
		
	/**
	 * 查看异常订单
	 * @return 订单VO列表
	 */
	public ArrayList<OrderVO> abnormalOrderScan();
	
	/**
	 * 查看用户信用值信息
	 * @param 用户IDVO
	 * @return 用户信用信息VO
	 */
	public int userCreditInq(String userid);
	
	/**
	 * 修改用户信用值
	 * @param 用户IDVO
	 * @param 增加值
	 * @return 修改后的用户信用值VO
	 */
	public ResultMsg userCreditMod(String userid,int n);
	
	/**
	 * 浏览每日未执行订单
	 * @param today
	 * @return
	 * @throws RemoteException
	 */
	public ArrayList<OrderVO> dayUnexOrder(String today);
		
		
}