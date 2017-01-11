package bl.userbl;

import java.rmi.RemoteException;
import java.util.ArrayList;

import blservice.userblservice.WebStuffWebsiteManagementBLService;
import dataservice.userdataservice.UserManagementDataService;
import net.RMIManage;
import util.DataServiceType;
import util.ResultMsg;
import vo.OrderVO;
import vo.PromotionWebVO;


/**
 * 网站营销人员对网站的操作
 * @author 曹畅
 *
 */
public class WebStuffWebsiteManagementController implements WebStuffWebsiteManagementBLService {

	private WebStuff stuff;
	private UserManagementDataService data;
	
	
	public WebStuffWebsiteManagementController(){
		data= (UserManagementDataService)RMIManage.
				getDataService(DataServiceType.UserManagementDataService);
		stuff=new WebStuff(data);
	}
	
	/**
	 * 创建网站促销策略
	 * @param 网站促销策略VO
	 */
	public boolean websiteStrategeCreate(PromotionWebVO vo){
		try {
			ResultMsg msg=stuff.websiteStrategeCreate(vo);
			if(msg==ResultMsg.SUCCESS){
				return  true;
			}
			return false;
		} catch (RemoteException e) {
			e.printStackTrace();
			return false;
			
		}
	}
	
	/**
	 * 修改网站促销策略
	 * @param 网站促销策略VO
	 */
	public ResultMsg websiteStrategeMod(PromotionWebVO vo){
		try {
			return stuff.websiteStrategeMod(vo);
		} catch (RemoteException e) {
			return ResultMsg.FAIL;
		}
	}
	
	/**
	 * 删除网站促销策略
	 * @param 网站促销策略VO
	 */
	public ResultMsg websiteStrategeDelete(PromotionWebVO vo){
		try {
			return stuff.websiteStrategeDelete(vo);
		} catch (RemoteException e) {
			return ResultMsg.FAIL;
		}
	}
			
	/**
	 * 查看异常订单
	 * @return 订单VO列表
	 */
	public ArrayList<OrderVO> abnormalOrderScan(){
		try {
			return stuff.abnormalOrderScan();
		} catch (RemoteException e) {
			e.printStackTrace();
			return null;
		}
	}
			
	/**
	 * 修改用户信用值
	 * @param 用户IDVO
	 * @param 增加值
	 * @return 修改后的用户信用值VO
	 */
	public ResultMsg userCreditMod(String userid,int n){
		try {
			return stuff.userCreditMod(userid, n);
		} catch (RemoteException e) {
			e.printStackTrace();
			return null;
		}
	}


	/**
	 * 查看网站营销策略
	 * @return 网站营销策略列表
	 */
	public ArrayList<PromotionWebVO> websiteStrategeInq(PromotionWebVO vo) {
		try {
			return stuff.websiteStrategeInq(vo);
		} catch (RemoteException e) {
			e.printStackTrace();
			return null;
		}
	}

	/**
	 * 查看用户信用值信息
	 * @param 用户IDVO
	 * @return 用户信用信息VO
	 */
	public int userCreditInq(String userid) {
		try {
			return stuff.userCreditInq(userid);
		} catch (RemoteException e) {
			e.printStackTrace();
			return -10000000;
		}
	}
	
	
	/**
	 * 浏览每日未执行订单
	 * @param today
	 * @return
	 * @throws RemoteException
	 */
	public ArrayList<OrderVO> dayUnexOrder(String today){
		try {
			return stuff.dayUnexOrder(today);
		} catch (RemoteException e) {
			return null;
		}
	}
}
