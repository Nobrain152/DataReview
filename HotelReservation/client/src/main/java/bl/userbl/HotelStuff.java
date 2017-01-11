package bl.userbl;

import java.rmi.RemoteException;
import java.util.ArrayList;

import bl.BusinessLogicDataFactory;
import bl.VOPOchange;
import bl.hotelbl.HotelInfoCheckController;
import bl.hotelbl.HotelInfoMaintainController;
import bl.hotelbl.RoomAddController;
import bl.orderbl.OrderOnHotelController;
import bl.promotionbl.PromotionHotelController;
import dataservice.userdataservice.UserManagementDataService;
import po.StuffInfoPO;
import util.OrderState;
import util.PromotionHotelType;
import util.ResultMsg;
import util.UserType;
import vo.HotelInfoVO;
import vo.OrderVO;
import vo.PromotionHotelVO;
import vo.RoomInfoVO;
import vo.StuffInfoVO;



/**
 * 酒店管理人员类
 * @author 曹畅
 *
 */
public class HotelStuff extends User {
	private HotelInfoMaintainController mod;
	private HotelInfoCheckController hotel;
	private OrderOnHotelController order;
	private RoomAddController room;
	private StuffInfoVO userInfoVO;
	private UserManagementDataService userDataService;
	private PromotionHotelController promotion;
	private BusinessLogicDataFactory factory=BusinessLogicDataFactory.getFactory();;
	
	
	public HotelStuff(UserManagementDataService user){
		super(user);
		this.userDataService=user;
	}
	
	
	/**
	 * 查看酒店信息	
	 * @param 酒店IDVO
	 * @return 酒店信息VO
	 */
	public HotelInfoVO hotelInfoInq(String hotelid)throws RemoteException{
		hotel=(HotelInfoCheckController)factory.getHotelInfoCheckBLService();
		return hotel.checkHotelInfo(hotelid);
	}
			
	/**
	 * 修改酒店信息	
	 * @param 酒店VO
	 * @param 用户IDVO
	 * @return 修改结果
	 */
	public ResultMsg hotelInfoMod(HotelInfoVO vo1,String userid)throws RemoteException{
		if(userid.charAt(0)=='2'){
			mod=(HotelInfoMaintainController)factory.getHotelInfoMaintainBLService();
			return mod.inputHotelInfo(vo1);
		}
		return ResultMsg.UNAUYHORIZED;
	}
			
	
	/**
	 * 修改酒店促销策略	
	 * @param 酒店IDVO
	 * @param 酒店促销策略VO
	 * @return 修改结果
	 */
	public boolean hotelStrategeManage(PromotionHotelVO vo)throws RemoteException{
		PromotionHotelType type=vo.getType();
		ResultMsg msg=null;
		promotion=(PromotionHotelController)factory.getPromotionHotelBLService();
		if(type==PromotionHotelType.BIRTH_PROMOTION){
			msg=promotion.changeBirthCut(vo.getLevel(),vo.getRatio(),vo.getHotelID());
		}
		else if(type==PromotionHotelType.OVERTHREE_PROMOTION){
			msg=promotion.changeOverCut(vo.getNumber(),vo.getRatio(),vo.getHotelID());
		}
		else if(type==PromotionHotelType.JOIN_PROMOTION){
			msg=promotion.changeJoin(vo.getBusinessName(),vo.getRatio(),vo.getHotelID());
		}
		else{
			promotion.changeHotelCustomCut(vo.getTimeBegin(),vo.getTimeOver(),vo.getRatio(),vo.getHotelID());
		}
		
		if(msg==ResultMsg.SUCCESS){
			return true;
		}
		else{
			return false;
		}
	}
	
	/**
	 * 增加酒店促销策略	
	 * @param 酒店IDVO
	 * @param 酒店促销策略VO
	 * @return 修改结果
	 */
	public boolean hotelStrategeAdd(PromotionHotelVO vo)throws RemoteException{
		PromotionHotelType type=vo.getType();
		ResultMsg msg=null;
		promotion=(PromotionHotelController)factory.getPromotionHotelBLService();
		if(type==PromotionHotelType.BIRTH_PROMOTION){
			msg=promotion.addBirthCut(vo.getLevel(),vo.getRatio(),vo.getHotelID());
		}
		else if(type==PromotionHotelType.OVERTHREE_PROMOTION){
			msg=promotion.addOverCut(vo.getNumber(),vo.getRatio(),vo.getHotelID());
		}
		else if(type==PromotionHotelType.JOIN_PROMOTION){
			msg=promotion.addJoin(vo.getBusinessName(),vo.getRatio(),vo.getHotelID());
		}
		else{
			promotion.addHotelCustomCut(vo.getTimeBegin(),vo.getTimeOver(),vo.getRatio(),vo.getHotelID());
		}
		
		if(msg==ResultMsg.SUCCESS){
			return true;
		}
		else{
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
		if(userid.charAt(0)=='2'){
			order=(OrderOnHotelController)factory.getOrderOnHotelBLService();
			return order.hotelOrderModify(vo2);
		}
		return ResultMsg.FAIL;
	}
			
	/**
	 * 浏览酒店订单	
	 * @param 酒店IDVO
	 * @return 订单VO列表
	 */
	public ArrayList<OrderVO> orderScan(String hotelid)throws RemoteException{
		order=(OrderOnHotelController)factory.getOrderOnHotelBLService();
		return order.hotelOrderScan(hotelid);
	}
	
	
	/**
	 * 分类浏览订单
	 * @param hotelid
	 * @param state
	 * @return
	 * @throws RemoteException
	 */
	public ArrayList<OrderVO> specialOrderScan(String hotelid,OrderState state)throws RemoteException{
		ArrayList<OrderVO> all=orderScan(hotelid);
		ArrayList<OrderVO> res=new ArrayList<OrderVO>();
		for(int i=0;i<all.size();i++){
			if(all.get(i).orderState==state){
				res.add(all.get(i));
			}
		}
		return res;
	}
	
	/**
	 * 浏览酒店异常订单	
	 * @param 酒店IDVO
	 * @return 订单VO列表
	 */
	public ArrayList<OrderVO> abnormalOrderScan(String hotelid)throws RemoteException{
		order=(OrderOnHotelController)factory.getOrderOnHotelBLService();
		ArrayList<OrderVO> all = order.hotelOrderScan(hotelid);
		ArrayList<OrderVO> res=new ArrayList<OrderVO>();
		for(OrderVO vo:all){
			if(vo.getOrderState()==OrderState.ABNORMAL){
				res.add(vo);
			}
		}
		return res;
	}
	
	/**
	 * 酒店工作人员更改订单状态
	 * @param hotelid
	 * @param orderid
	 * @return
	 * @throws RemoteException
	 */
	public ResultMsg setAbnormalOrder(String hotelid,String orderid)throws RemoteException{
		ArrayList<OrderVO> all=abnormalOrderScan(hotelid);
		for(OrderVO vo:all){
			if(vo.getOrderID().equals(orderid)){
				order=(OrderOnHotelController)factory.getOrderOnHotelBLService();
				return order.hotelOrderModify(vo);
			}
		}
		return ResultMsg.FAIL;
	}

	/**
	 * 查看酒店促销策略
	 * @param 酒店IDVO
	 * @return 酒店促销策略列表
	 */
	public ArrayList<PromotionHotelVO> hotelPromotionInq(PromotionHotelVO vo)throws RemoteException {
		promotion=(PromotionHotelController)factory.getPromotionHotelBLService();
		return promotion.getHotelPromotion(vo.getType(),vo.getHotelID());
	}

	/**
	 * 更新房间信息
	 * @param 房间信息VO
	 */
	public ResultMsg updateRoomState(RoomInfoVO vo)throws RemoteException {
		room=(RoomAddController)factory.getRoomAddBLService();
		return room.updateRoom(vo);
		
	}
	
	/**
	 * 录入可用房间
	 * @param rooms
	 */
	public ResultMsg typeInRoom(RoomInfoVO roo)throws RemoteException{
		room=(RoomAddController)factory.getRoomAddBLService();
		return room.addRoom(roo);
	}
	
	
	/**
	 * 查看酒店所有客房信息
	 * @param hotelid
	 * @return
	 * @throws RemoteException
	 */
	public ArrayList<RoomInfoVO> hotelRoomList(String hotelid)throws RemoteException{
		room=(RoomAddController)factory.getRoomAddBLService();
		return room.HotelRoomSearch(hotelid);
	}
	
	/**
	 * 修改酒店房间信息
	 * @param rooms
	 * @return
	 * @throws RemoteException
	 */
	public ResultMsg setRoomInfo(ArrayList<RoomInfoVO> rooms)throws RemoteException{
		room=(RoomAddController)factory.getRoomAddBLService();
		return room.HotelRoomMod(rooms.get(0).getHotelid(), rooms);
	}
	
	/**
	 * 查看个人基本信息
	 * @param 用户IDVO
	 * @return 酒店管理人员信息VO
	 */
	public StuffInfoVO individualInfolnq(String userid)throws RemoteException{
		StuffInfoPO userInfoPO = userDataService.getHotelStuffInfo(userid);
		userInfoVO = (StuffInfoVO)VOPOchange.POtoVO(userInfoPO);
		return  userInfoVO;
	}
			
	
	/**
	 * 修改个人信息
	 * @param 用户IDVO
	 * @param 酒店管理人员信息VO
	 * @return 修改结果
	 */
	public ResultMsg individualInfoMod(String userid,StuffInfoVO vo2)throws RemoteException{
		StuffInfoPO past= userDataService.getHotelStuffInfo(userid);
		past.setType(UserType.HotelStuff);
		if(vo2.getContact()!=null){
			if(vo2.getContact().length()!=11){
				return ResultMsg.WRONG_PHONENUMBER;
			}
			past.setContact(vo2.getContact());
		}
		if(vo2.getUsername()!=null){
			past.setUsername(vo2.getUsername());
		}
		return userDataService.updateHotelStuffInfo(userid, past);
		
	}
	
	/**
	 * 删除酒店促销策略	
	 * @param 酒店IDVO
	 * @param 酒店促销策略VO
	 * @return 修改结果
	 */
	public boolean hotelStrategeDelete(PromotionHotelVO vo)throws RemoteException{
		PromotionHotelType type=vo.getType();
		ResultMsg msg=null;
		promotion=(PromotionHotelController)factory.getPromotionHotelBLService();
		if(type==PromotionHotelType.BIRTH_PROMOTION){
			msg=promotion.deleteBirthCut(vo.getLevel(),vo.getHotelID());
		}
		else if(type==PromotionHotelType.OVERTHREE_PROMOTION){
			msg=promotion.deleteOverCut(vo.getNumber(),vo.getHotelID());
		}
		else if(type==PromotionHotelType.JOIN_PROMOTION){
			msg=promotion.deleteJoin(vo.getBusinessName(),vo.getHotelID());
		}
		else{
			promotion.deleteHotelCustomCut(vo.getTimeBegin(),vo.getTimeOver(),vo.getHotelID());
		}
		
		if(msg==ResultMsg.SUCCESS){
			return true;
		}
		else{
			return false;
		}
	}
	
}
