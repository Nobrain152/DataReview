package bl.userbl;

import java.rmi.RemoteException;
import java.util.ArrayList;


import bl.BusinessLogicDataFactory;
import bl.VOPOchange;
import bl.creditbl.CreditController;
import bl.hotelbl.HotelEvaluateController;
import bl.hotelbl.HotelInfoCheckController;
import bl.hotelbl.HotelReserveController;
import bl.hotelbl.HotelSearchController;
import bl.orderbl.OrderOnUserController;
import dataservice.userdataservice.CustomerManagementDataService;
import po.CustomerInfoPO;
import util.OrderState;
import util.ResultMsg;
import util.Sort;
import vo.CustomerInfoVO;
import vo.HotelEvaluateVO;
import vo.HotelInfoVO;
import vo.CreditVO;
import vo.OrderVO;
import vo.RoomInfoVO;
/**
 * 客户类
 * @author 曹畅
 *
 */
public class Customer extends User {
	private HotelSearchController hotel;
	private HotelEvaluateController eval;
	private ArrayList<HotelInfoVO> hotelInfoVOs;
	private CreditController integral;
	private CustomerManagementDataService userdataservice;
	private OrderOnUserController order;
	private HotelInfoCheckController hotelinfo;
	private HotelReserveController reserve;
	private BusinessLogicDataFactory factory=BusinessLogicDataFactory.getFactory();
	
	/**
	 * 构造方法
	 * @param 用户ID
	 */
	public Customer(CustomerManagementDataService userdataservice){
		super(userdataservice);
		this.userdataservice=userdataservice;
	}
	
	/**
	 * 根据输入的酒店搜索条件返回符合条件的酒店信息VO列表
	 * @param 筛选条件VO
	 * @return 酒店信息VO列表
	 */
	public ArrayList<HotelInfoVO> hotelSearch(RoomInfoVO vo1,HotelInfoVO vo,String userid)throws RemoteException{
		hotel=(HotelSearchController)factory.getHotelSearchBLService();
		ArrayList<HotelInfoVO> hotelInfoVOs= hotel.selectCondition(vo,vo1);
		return hotelInfoVOs;
	}		
	
	
	
	/**
	 * 根据输入的酒店ID和用户ID返回符合条件的酒店信息VO列表
	 * @param 筛选条件VO
	 * @return 酒店信息VO列表
	 */
	public HotelInfoVO hotelDetail(String hotelid,String userid)throws RemoteException{
		ArrayList<String> hotel=userdataservice.getCustomerHotel(userid);
		boolean wrong=true;
		for(String s:hotel){
			if(s.equals(hotelid)){
				wrong=false;
				break;
			}
		}
		if(wrong){
			return null;
		}
		hotelinfo=(HotelInfoCheckController)factory.getHotelInfoCheckBLService();
		HotelInfoVO vo=hotelinfo.checkHotelInfo(hotelid);
		return vo;
	}
	
	/**
	 * 根据酒店ID和用户ID返回订单列表
	 * @param hotelid
	 * @param userid
	 * @return
	 * @throws RemoteException
	 */
	public ArrayList<OrderVO> getHotelOrder(String hotelid,String userid)throws RemoteException{
		ArrayList<OrderVO> ord=individualOrderInq(userid);
		ArrayList<OrderVO> n=new ArrayList<OrderVO>();
		for(OrderVO v:ord){
			if(v.getHotelID().equals(hotelid)){
				n.add(v);
			}
		}
		return n;
	}
	/**
	 * 根据排序种类返回排好序的酒店列表
	 * @param before
	 * @param type
	 * @return
	 */
	public ArrayList<HotelInfoVO> sortHotel(ArrayList<HotelInfoVO> before,Sort type){
		HotelInfoVO temp;
		if(type==Sort.Price_DownToUp){
			for(int i=0;i<before.size();i++){
				for(int j=0;j<before.size();j++){
					if(before.get(i).getSP()>before.get(j).getSP()){
						temp=before.get(i);
						before.set(i,before.get(j));
						before.set(j,temp);
					}
				}
			}
			return before;
		}
		
		if(type==Sort.Price_UpToDown){
			for(int i=0;i<before.size();i++){
				for(int j=0;j<before.size();j++){
					if(before.get(i).getSP()<before.get(j).getSP()){
						temp=before.get(i);
						before.set(i,before.get(j));
						before.set(j,temp);
					}
				}
			}
			return before;
		}
		
		if(type==Sort.Score_DownToUp){
			for(int i=0;i<before.size();i++){
				for(int j=0;j<before.size();j++){
					if(before.get(i).getScore()>before.get(j).getScore()){
						temp=before.get(i);
						before.set(i,before.get(j));
						before.set(j,temp);
					}
				}
			}
			return before;
		}
		
		if(type==Sort.Score_UpToDown){
			for(int i=0;i<before.size();i++){
				for(int j=0;j<before.size();j++){
					if(before.get(i).getScore()<before.get(j).getScore()){
						temp=before.get(i);
						before.set(i,before.get(j));
						before.set(j,temp);
					}
				}
			}
			return before;
		}
		
		if(type==Sort.Star_DownToUp){
			for(int i=0;i<before.size();i++){
				for(int j=0;j<before.size();j++){
					if(before.get(i).getLevel()>before.get(j).getLevel()){
						temp=before.get(i);
						before.set(i,before.get(j));
						before.set(j,temp);
					}
				}
			}
			return before;
		}
		
		else{
			for(int i=0;i<before.size();i++){
				for(int j=0;j<before.size();j++){
					if(before.get(i).getLevel()<before.get(j).getLevel()){
						temp=before.get(i);
						before.set(i,before.get(j));
						before.set(j,temp);
					}
				}
			}
			return before;
		}
		
	}
	
	/**
	 * 对某一酒店生成订单
	 * @param 酒店IDVO
	 * @param 订单VO
	 *
	 */
	public ResultMsg orderCreat(String userid,OrderVO vo2)throws RemoteException{
		reserve=(HotelReserveController)factory.getHotelReserveBLService();
		ResultMsg r1=reserve.reserveHotel(vo2);
	    if(r1==ResultMsg.SUCCESS){
	    	order=(OrderOnUserController)factory.getOrderOnUserBLService();
	    	order.createOrder(vo2);
	    	ResultMsg r2=userdataservice.addCustomerHotel(userid,vo2.getHotelID());
	        return r2;
	    }
	    return ResultMsg.FAIL;
		
	}
			

	/**
	 * 评价酒店	
	 * @param 酒店评价VO
	 */
	public void hotelEvaluate(HotelEvaluateVO vo)throws RemoteException{
		eval=(HotelEvaluateController)factory.getHotelEvaluateBLService();
		eval.inputEvaluate(vo);
	}
			
	
	
	

	/**
	 * 查询个人基本信息
	 * @param userid
	 * @return 个人基本信息
	 */
	public CustomerInfoVO individualInfolnq(String userid)throws RemoteException{
		CustomerInfoPO userInfoPO = userdataservice.getCustomerInfo(userid);
		CustomerInfoVO vo = (CustomerInfoVO)VOPOchange.POtoVO(userInfoPO);
		return vo;
	}
			
	/**
	 * 修改个人基本信息
	 * @param userid
	 * @param 客户基本信息
	 * @return 修改结果
	 */
	public ResultMsg individualInfoMod(String userid,CustomerInfoVO vo2)throws RemoteException{
		CustomerInfoPO past= userdataservice.getCustomerInfo(userid);
		if((past.getIsMember()!=vo2.getIsMember())||(past.getCredit()!=vo2.getCredit())||(!past.getUserID().equals(vo2.getUserID())||(past.getVipType()!=vo2.getVipType()))){
			return ResultMsg.UNAUYHORIZED;
		}
		if(vo2.getContact()!=null){
			if(vo2.getContact().length()!=11){
				return ResultMsg.WRONG_PHONENUMBER;
			}
			past.setContact(vo2.getContact());
		}
		if(vo2.getUsername()!=null){
			past.setUsername(vo2.getUsername());
		}
		return userdataservice.updateCustomerInfo(userid,past);
		
	}
			
	/**
	 * 查询个人订单信息
	 * @param userid
	 * @return 个人订单列表
	 */
	public ArrayList<OrderVO> individualOrderInq(String userid)throws RemoteException{
		order=(OrderOnUserController)factory.getOrderOnUserBLService();
		return order.personalOrderScan(userid);
	}
	
	/**
	 * 查询个人某一类订单信息
	 * @param userid
	 * @return 个人订单列表
	 */
	public ArrayList<OrderVO> specialOrderInq(String userid,OrderState state)throws RemoteException{
		order=(OrderOnUserController)factory.getOrderOnUserBLService();
		ArrayList<OrderVO> all= order.personalOrderScan(userid);
		ArrayList<OrderVO> special=new ArrayList<OrderVO>();
		for(OrderVO vo:all){
			if(vo.getOrderState()==state){
				special.add(vo);
			}
		}
		return special;
	}
	
	
	
	
	/**
	 * 查询个人酒店信息
	 * @param userid
	 * @return 个人酒店信息列表
	 */
	public ArrayList<HotelInfoVO> individualHotelInq(String userid)throws RemoteException{
		ArrayList<String> hotel=userdataservice.getCustomerHotel(userid);
		hotelinfo=(HotelInfoCheckController)factory.getHotelInfoCheckBLService();
		for(int i=0;i<hotel.size();i++){
			hotelInfoVOs.add(hotelinfo.checkHotelInfo(hotel.get(i)));
		}
		return hotelInfoVOs;
	}
	
	/**
	 * 查询个人某一类酒店信息
	 * @param userid
	 * @return 个人订单列表
	 */
	public ArrayList<HotelInfoVO> specialHotelInq(String userid,OrderState state)throws RemoteException{
		ArrayList<OrderVO> special=specialOrderInq(userid, state);
		ArrayList<HotelInfoVO> hvo=new ArrayList<HotelInfoVO>();
		hotelinfo=(HotelInfoCheckController)factory.getHotelInfoCheckBLService();
		for(OrderVO vo:special){
			hvo.add(hotelinfo.checkHotelInfo(vo.getHotelID()));
		}
		return hvo;
	}
	
			
	/**
	 * 查询个人信用
	 * @param userid
	 * @return 个人信用信息
	 */
	public int individualCredictInq(String userid)throws RemoteException{
		integral=(CreditController)factory.getCreditBLService();
		return	integral.getCredit((CustomerInfoVO)VOPOchange.POtoVO(userdataservice.getCustomerInfo(userid)));
	}
	
	
	/**
	 * 查询个人信用记录
	 * @param userid
	 * @return 个人信用信息
	 */
	public ArrayList<CreditVO> individualCredictRecord(String userid)throws RemoteException{
		integral=(CreditController)factory.getCreditBLService();
		return integral.getCreditList(userid);
	}
	
	/**
	 * 撤销个人订单
	 * @param orderVO
	 * @return
	 */
	public ResultMsg orderCancel(OrderVO orderVO)throws RemoteException{
		order=(OrderOnUserController)factory.getOrderOnUserBLService();
		return order.personalOrderCancel(orderVO);
	}
	
	
	
}
