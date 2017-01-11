package bl.userbl;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.ArrayList;

import bl.BusinessController;
import blservice.userblservice.CustomerHotelOperationBlService;
import dataservice.userdataservice.CustomerManagementDataService;
import net.RMIManage;
import util.DataServiceType;
import util.ResultMsg;
import util.Sort;
import vo.HotelEvaluateVO;
import vo.HotelInfoVO;
import vo.OrderVO;
import vo.RoomInfoVO;


/**
 * 客户对酒店的操作
 * 
 * @author 曹畅
 *
 */
public class CustomerHotelOperationController extends BusinessController implements CustomerHotelOperationBlService {
	
	private Customer customer;
	private CustomerManagementDataService customerManagementDataService;
	
	public CustomerHotelOperationController(){
		customerManagementDataService = (CustomerManagementDataService)RMIManage.
				getDataService(DataServiceType.CustomerManagementDataService);
		customer=new Customer(customerManagementDataService);
	}

	
	/**
	 * 根据输入的酒店搜索条件返回符合条件的酒店信息VO列表
	 * @param 筛选条件VO
	 * @return 酒店信息VO列表
	 */
	public ArrayList<HotelInfoVO> hotelSearch(RoomInfoVO vo1,HotelInfoVO vo,String userid){
		try {
			return customer.hotelSearch(vo1,vo,userid);
		} catch (RemoteException e) {
			e.printStackTrace();
			return null;
		}
		
	}
	
	/**
	 * 根据输入的酒店ID和用户ID返回符合条件的酒店信息VO列表
	 * @param 筛选条件VO
	 * @return 酒店信息VO列表
	 */
	public HotelInfoVO hotelDetail(String hotelid,String userid){
		try {
			return customer.hotelDetail(hotelid, userid);
		} catch (RemoteException e) {
			return null;
		}
	}
	
	/**
	 * 根据酒店ID和用户ID返回订单列表
	 * @param hotelid
	 * @param userid
	 * @return
	 * @throws RemoteException
	 */
	public ArrayList<OrderVO> getHotelOrder(String hotelid,String userid){
		try {
			return customer.getHotelOrder(hotelid, userid);
		} catch (RemoteException e) {
			e.printStackTrace();
			return null;
		}
	}
	/**
	 * 根据排序种类返回排好序的酒店列表
	 * @param before
	 * @param type
	 * @return
	 */
	public ArrayList<HotelInfoVO> sortHotel(ArrayList<HotelInfoVO> before,Sort type){
		return customer.sortHotel(before, type);
	}
	
	
	/**
	 * 对某一酒店生成订单
	 * @param 酒店IDVO
	 * @param 订单VO
	 *
	 */
	public ResultMsg orderCreat(String hotelID,OrderVO vo2){
	   try {
		return customer.orderCreat(hotelID, vo2);
	} catch (RemoteException e) {
		e.printStackTrace();
		return ResultMsg.FAIL;
	}
		
	}
			

	/**
	 * 评价酒店	
	 * @param 酒店评价VO
	 */
	public void hotelEvaluate(HotelEvaluateVO vo){
		try {
			customer.hotelEvaluate(vo);
		} catch (RemoteException e) {
			e.printStackTrace();
		}
	}


	@Override
	public void reinitDataService(Remote dataService) {
		customerManagementDataService = (CustomerManagementDataService)dataService;
		customer = new Customer(customerManagementDataService);
	}
			
	
	
	
	

}
