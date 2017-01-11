package blservice.userblservice;

import java.util.ArrayList;

import po.CustomerInfoPO;
import util.ResultMsg;
import vo.CreditVO;
import vo.CustomerInfoVO;
import vo.HotelInfoVO;
import vo.OrderVO;


/**
 * 客户管理个人信息
 * @author 曹畅
 *
 */
public interface CustomerIndividualInformationManagementBLService{
        
	/**
	 * 查询个人基本信息
	 * @param 用户IDVO
	 * @return 用户基本信息VO
	 */
	public CustomerInfoVO individualInfolnq(String userid);
		
	/**
	 * 修改个人基本信息
	 * @param 用户IDVO
	 * @param 客户个人信息VO
	 * @return 修改成功与否
	 */
	public ResultMsg individualInfoMod(String userid,CustomerInfoVO vo2);
		
	/**
	 * 查询个人订单
	 * @param 用户IDVO
	 * @return 订单VO列表
	 */
	public ArrayList<OrderVO> individualOrderInq(String userid);
		
	
	/**
	 * 查询个人未执行订单信息
	 * @param userid
	 * @return 个人订单列表
	 */
	public ArrayList<OrderVO> unfinishedOrderInq(String userid);
	
	
	/**
	 * 查询个人已执行订单信息
	 * @param userid
	 * @return 个人订单列表
	 */
	public ArrayList<OrderVO> finishedOrderInq(String userid);
	
	
	/**
	 * 查询个撤销订单信息
	 * @param userid
	 * @return 个人订单列表
	 */
	public ArrayList<OrderVO> cancelOrderInq(String userid);
	
	
	/**
	 * 查询个人异常订单信息
	 * @param userid
	 * @return 个人订单列表
	 */
	public ArrayList<OrderVO> abnormalOrderInq(String userid);
	
	
	/**
	 * 查询预定过的酒店	
	 * @param 用户IDVO
	 * @return 酒店信息列表
	 */
	public ArrayList<HotelInfoVO> individualHotelInq(String userid);
	
	/**
	 * 查询个人未执行酒店信息
	 * @param userid
	 * @return 个人订单列表
	 */
	public ArrayList<HotelInfoVO> unfinishedHotelInq(String userid);
	
	/**
	 * 查询个人已执行酒店信息
	 * @param userid
	 * @return 个人订单列表
	 */
	public ArrayList<HotelInfoVO> finishedHotelInq(String userid);
	
	/**
	 * 查询个人异常酒店信息
	 * @param userid
	 * @return 个人订单列表
	 */
	public ArrayList<HotelInfoVO> abnormalHotelInq(String userid);
	
	/**
	 * 查询个撤销酒店信息
	 * @param userid
	 * @return 个人订单列表
	 */
	public ArrayList<HotelInfoVO> cancelHotelInq(String userid);
		
	/**
	 * 查询个人信用信息	
	 * @param 用户IDVO
	 * @return 信用VO
	 */
	public int individualCredictInq(String userid);
	
	/**
	 * 查询个人信用信息记录	
	 * @param 用户IDVO
	 * @return 信用VO
	 */
	public ArrayList<CreditVO> individualCredictRecord(String userid);
	
	/**
	 * 删除个人订单
	 * @param orderVO
	 * @return
	 */
	public ResultMsg orderCancel(OrderVO orderVO);

	/**
	 * 得到用户信息
	 * @param userID
	 * @return
	 */
	CustomerInfoPO getCustomerInfo(String userID);

	/*
	 * 设置个人信息
	 */
	void setCustomerInfo(String userID, CustomerInfoPO customerInfoPO);

	
			
}