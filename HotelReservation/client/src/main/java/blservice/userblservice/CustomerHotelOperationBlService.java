package blservice.userblservice;

import java.rmi.RemoteException;
import java.util.ArrayList;

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
public interface CustomerHotelOperationBlService{
        
	/**
	 * 根据输入的酒店搜索条件返回符合条件的酒店信息VO列表
	 * @param 筛选条件VO
	 * @return 酒店信息VO列表
	 */
	public ArrayList<HotelInfoVO> hotelSearch(RoomInfoVO vo1,HotelInfoVO vo,String userid);
	
	
	/**
	 * 对某一酒店生成订单
	 * @param 酒店IDVO
	 * @param 订单VO
	 *
	 */
	public ResultMsg orderCreat(String hotelID,OrderVO vo2);
		
	/**
	 * 评价酒店	
	 * @param 酒店评价VO
	 */
	public void hotelEvaluate(HotelEvaluateVO vo);
	
	/**
	 * 根据输入的酒店ID和用户ID返回符合条件的酒店信息VO列表
	 * @param 筛选条件VO
	 * @return 酒店信息VO列表
	 */
	public HotelInfoVO hotelDetail(String hotelid,String userid);
	
	
	/**
	 * 根据排序种类返回排好序的酒店列表
	 * @param before
	 * @param type
	 * @return
	 */
	public ArrayList<HotelInfoVO> sortHotel(ArrayList<HotelInfoVO> before,Sort type);
	
	/**
	 * 根据酒店ID和用户ID返回订单列表
	 * @param hotelid
	 * @param userid
	 * @return
	 * @throws RemoteException
	 */
	public ArrayList<OrderVO> getHotelOrder(String hotelid,String userid);	
			
}