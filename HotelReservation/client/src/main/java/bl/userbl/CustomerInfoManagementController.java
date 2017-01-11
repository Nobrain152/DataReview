package bl.userbl;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.ArrayList;

import bl.BusinessController;
import blservice.userblservice.CustomerIndividualInformationManagementBLService;
import dataservice.userdataservice.CustomerManagementDataService;
import dataservice.userdataservice.UserManagementDataService;
import net.RMIManage;
import po.CustomerInfoPO;
import util.DataServiceType;
import util.OrderState;
import util.ResultMsg;
import vo.CreditVO;
import vo.CustomerInfoVO;
import vo.HotelInfoVO;
import vo.OrderVO;


/**
 * 客户对个人信息的操作
 * @author 曹畅
 *
 */
public class CustomerInfoManagementController extends BusinessController
		implements CustomerIndividualInformationManagementBLService {
	
	private Customer customer;
	private CustomerManagementDataService customerManagementDataService;
	private UserManagementDataService userManagementDataService;
	
	/**
	 * 构造方法
	 * @param 用户ID
	 */
	public CustomerInfoManagementController(){
		customerManagementDataService = (CustomerManagementDataService)RMIManage.
				getDataService(DataServiceType.CustomerManagementDataService);
		userManagementDataService = (UserManagementDataService)RMIManage.
				getDataService(DataServiceType.UserManagementDataService);
		customer=new Customer(customerManagementDataService);
	}
	
	
	/**
	 * 查询个人基本信息
	 * @param userid
	 * @return 个人基本信息
	 */
	public CustomerInfoVO individualInfolnq(String userid){
		try {
			return customer.individualInfolnq(userid);
		} catch (RemoteException e) {
			e.printStackTrace();
			return null;
		}
	}
			
	/**
	 * 修改个人基本信息
	 * @param userid
	 * @param 客户基本信息
	 * @return 修改结果
	 */
	public ResultMsg individualInfoMod(String userid,CustomerInfoVO vo2){
		try {
			return customer.individualInfoMod(userid, vo2);
		} catch (RemoteException e) {
			e.printStackTrace();
			return ResultMsg.FAIL;
		}
	}
			
	/**
	 * 查询个人订单信息
	 * @param userid
	 * @return 个人订单列表
	 */
	public ArrayList<OrderVO> individualOrderInq(String userid){
		try {
			return customer.individualOrderInq(userid);
		} catch (RemoteException e) {
			e.printStackTrace();
			return null;
		}
	}
	
	/**
	 * 查询个人未执行订单信息
	 * @param userid
	 * @return 个人订单列表
	 */
	public ArrayList<OrderVO> unfinishedOrderInq(String userid){
		try {
			return customer.specialOrderInq(userid,OrderState.UNEXECUTED);
		} catch (RemoteException e) {
			return null;
		}
	}
	
	/**
	 * 查询个人已执行订单信息
	 * @param userid
	 * @return 个人订单列表
	 */
	public ArrayList<OrderVO> finishedOrderInq(String userid){
		try {
			return customer.specialOrderInq(userid,OrderState.EXECUTED);
		} catch (RemoteException e) {
			return null;
		}
	}
	
	/**
	 * 查询个撤销订单信息
	 * @param userid
	 * @return 个人订单列表
	 */
	public ArrayList<OrderVO> cancelOrderInq(String userid){
		try {
			return customer.specialOrderInq(userid,OrderState.CANCELLED);
		} catch (RemoteException e) {
			return null;
		}
	}
	
	/**
	 * 查询个人异常订单信息
	 * @param userid
	 * @return 个人订单列表
	 */
	public ArrayList<OrderVO> abnormalOrderInq(String userid){
		try {
			return customer.specialOrderInq(userid,OrderState.ABNORMAL);
		} catch (RemoteException e) {
			return null;
		}
	}
			
	/**
	 * 查询个人酒店信息
	 * @param userid
	 * @return 个人酒店信息列表
	 */
	public ArrayList<HotelInfoVO> individualHotelInq(String userid){
		try {
			return customer.individualHotelInq(userid);
		} catch (RemoteException e) {
			e.printStackTrace();
			return null;
		}
	}
	
	/**
	 * 查询个人未执行酒店信息
	 * @param userid
	 * @return 个人订单列表
	 */
	public ArrayList<HotelInfoVO> unfinishedHotelInq(String userid){
		try {
			return customer.specialHotelInq(userid,OrderState.UNEXECUTED);
		} catch (RemoteException e) {
			return null;
		}
	}
	
	/**
	 * 查询个人已执行酒店信息
	 * @param userid
	 * @return 个人订单列表
	 */
	public ArrayList<HotelInfoVO> finishedHotelInq(String userid){
		try {
			return customer.specialHotelInq(userid,OrderState.EXECUTED);
		} catch (RemoteException e) {
			return null;
		}
	}
	
	/**
	 * 查询个人异常酒店信息
	 * @param userid
	 * @return 个人订单列表
	 */
	public ArrayList<HotelInfoVO> abnormalHotelInq(String userid){
		try {
			return customer.specialHotelInq(userid,OrderState.ABNORMAL);
		} catch (RemoteException e) {
			return null;
		}
	}
	
	/**
	 * 查询个撤销酒店信息
	 * @param userid
	 * @return 个人订单列表
	 */
	public ArrayList<HotelInfoVO> cancelHotelInq(String userid){
		try {
			return customer.specialHotelInq(userid,OrderState.CANCELLED);
		} catch (RemoteException e) {
			return null;
		}
	}
			
	/**
	 * 查询个人信用
	 * @param userid
	 * @return 个人信用信息
	 */
	public int individualCredictInq(String userid){
		try {
			int result= customer.individualCredictInq(userid);
			return result;
		} catch (RemoteException e) {
			return -1;
		}
	}


	/**
	 * 查询个人信用记录
	 * @param userid
	 * @return 个人信用信息
	 */
	public ArrayList<CreditVO> individualCredictRecord(String userid) {
		try {
			return customer.individualCredictRecord(userid);
		} catch (RemoteException e) {
			return null;
		}
	}


	/**
	 * 撤销个人订单
	 * @param orderVO
	 * @return
	 */
	public ResultMsg orderCancel(OrderVO orderVO){
		try {
			return customer.orderCancel(orderVO);
		} catch (RemoteException e) {
			return ResultMsg.FAIL;
		}
	}


	@Override
	public CustomerInfoPO getCustomerInfo(String userID) {
		try {
			return userManagementDataService.getCustomerInfo(userID);
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}


	@Override
	public void setCustomerInfo(String userID, CustomerInfoPO customerInfoPO) {
		try {
			userManagementDataService.updateCustomerInfo(userID, customerInfoPO);
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}


	@Override
	public void reinitDataService(Remote dataService) {
		customerManagementDataService = (CustomerManagementDataService)dataService;
		customer = new Customer(customerManagementDataService);
	}


	
			
}
