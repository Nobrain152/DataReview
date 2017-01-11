package bl.userbl;


import java.rmi.RemoteException;
import java.util.ArrayList;


import blservice.userblservice.HotelStuffHotelOperationBlService;
import dataservice.userdataservice.UserManagementDataService;
import net.RMIManage;
import util.DataServiceType;
import util.OrderState;
import util.ResultMsg;
import vo.HotelInfoVO;
import vo.OrderVO;
import vo.PromotionHotelVO;
import vo.RoomInfoVO;



/**
 * 酒店工作人员对酒店进行的操作
 * @author 曹畅
 *
 */
public class HotelStuffHotelOperationController implements HotelStuffHotelOperationBlService {

	private HotelStuff stuff;
	private UserManagementDataService userManagementDataService;
	
	
	public HotelStuffHotelOperationController(){
		userManagementDataService = (UserManagementDataService)RMIManage.
				getDataService(DataServiceType.UserManagementDataService);
		stuff=new HotelStuff(userManagementDataService);
	}
	
	
	/**
	 * 查看酒店信息	
	 * @param 酒店IDVO
	 * @return 酒店信息VO
	 */
	public HotelInfoVO hotelInfoInq(String hotelid){
		try {
			return stuff.hotelInfoInq(hotelid);
		} catch (RemoteException e) {
			e.printStackTrace();
			return null;
		}
	}
			
	/**
	 * 修改酒店信息	
	 * @param 酒店VO
	 * @param 用户IDVO
	 * @return 修改结果
	 */
	public ResultMsg hotelInfoMod(HotelInfoVO vo1,String userid){
		try {
			return stuff.hotelInfoMod(vo1, userid);
		} catch (RemoteException e) {
			e.printStackTrace();
			return null;
		}
	}
	
	/**
	 * 修改酒店房间信息
	 * @param rooms
	 * @return
	 * @throws RemoteException
	 */
	public ResultMsg setRoomInfo(ArrayList<RoomInfoVO> rooms){
		try {
			return stuff.setRoomInfo(rooms);
		} catch (RemoteException e) {
			return ResultMsg.FAIL;
		}
	}
			
	
	/**
	 * 管理酒店促销策略	
	 * @param 酒店IDVO
	 * @param 酒店促销策略VO
	 * @return 修改结果
	 */
	public boolean hotelStrategeManage(PromotionHotelVO vo){
		try {
			return stuff.hotelStrategeManage(vo);
		} catch (RemoteException e) {
			e.printStackTrace();
			return false;
		}
	}
	
	/**
	 * 删除酒店促销策略	
	 * @param 酒店IDVO
	 * @param 酒店促销策略VO
	 * @return 修改结果
	 */
	public boolean hotelStrategeDelete(PromotionHotelVO vo){
		try {
			return stuff.hotelStrategeDelete(vo);
		} catch (RemoteException e) {
			return false;
		}
	}
			
	/**
	 * 更新订单状态	
	 * @param 用户IDVO
	 * @param 订单VO
	 * @throws RemoteException 
	 */
	public ResultMsg orderStateUpdate(String userid,OrderVO vo2) throws RemoteException{
		return stuff.orderStateUpdate(userid, vo2);
	}
			
	/**
	 * 浏览酒店订单	
	 * @param 酒店IDVO
	 * @return 订单VO列表
	 */
	public ArrayList<OrderVO> orderScan(String hotelid){
		try {
			return stuff.orderScan(hotelid);
		} catch (RemoteException e) {
			e.printStackTrace();
			return null;
		}
	}
	
	/**
	 * 浏览酒店异常订单	
	 * @param 酒店IDVO
	 * @return 订单VO列表
	 */
	public ArrayList<OrderVO> abnormalOrderScan(String hotelid){
		try {
			return stuff.abnormalOrderScan(hotelid);
		} catch (RemoteException e) {
			return null;
		}
	}
	
	/**
	 * 分类浏览订单
	 * @param hotelid
	 * @param state
	 * @return
	 * @throws RemoteException
	 */
	public ArrayList<OrderVO> specialOrderScan(String hotelid,OrderState state){
		try {
			return stuff.specialOrderScan(hotelid, state);
		} catch (RemoteException e) {
			return null;
		}
	}

	/**
	 * 查看酒店促销策略
	 * @param 酒店IDVO
	 * @return 酒店促销策略列表
	 */
	public ArrayList<PromotionHotelVO> hotelPromotionInq(PromotionHotelVO promotion) {
		try {
			return stuff.hotelPromotionInq(promotion);
		} catch (RemoteException e) {
			e.printStackTrace();
			return null;
		}
	}

	/**
	 * 更新房间信息
	 * @param 房间信息VO
	 */
	public ResultMsg updateRoomState(RoomInfoVO vo) {
		try {
			return stuff.updateRoomState(vo);
		} catch (RemoteException e) {
			e.printStackTrace();
			return null;
		}
		
	}

	
	/**
	 * 录入可用房间
	 * @param rooms
	 */
	public ResultMsg typeInRoom(RoomInfoVO room){
		  try {
			return stuff.typeInRoom(room);
		} catch (RemoteException e) {
			return ResultMsg.FAIL;
		}
	}

	
	/**
	 * 查看酒店所有客房信息
	 * @param hotelid
	 * @return
	 * @throws RemoteException
	 */
	public ArrayList<RoomInfoVO> hotelRoomList(String hotelid){
		try {
			return stuff.hotelRoomList(hotelid);
		} catch (RemoteException e) {
			return null;
		}
	}
	/**
	 * 增加酒店促销策略	
	 * @param 酒店IDVO
	 * @param 酒店促销策略VO
	 * @return 修改结果
	 */
	public boolean hotelStrategeAdd(PromotionHotelVO vo) {
		try {
			return stuff.hotelStrategeAdd(vo);
		} catch (RemoteException e) {
			e.printStackTrace();
			return false;
		}
	}
	/**
	 * 酒店工作人员更改订单状态
	 * @param hotelid
	 * @param orderid
	 * @return
	 * @throws RemoteException
	 */
	public ResultMsg setAbnormalOrder(String hotelid,String orderid){
		try {
			return stuff.setAbnormalOrder(hotelid, orderid);
		} catch (RemoteException e) {
			return ResultMsg.FAIL;
		}
	}

}
