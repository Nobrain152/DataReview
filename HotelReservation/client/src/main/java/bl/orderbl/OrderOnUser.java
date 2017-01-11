
package bl.orderbl;

import java.rmi.RemoteException;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Calendar;

import bl.BusinessLogicDataFactory;
import bl.VOPOchange;
import bl.creditbl.CreditController;
import bl.promotionbl.PromotionValueController;
import bl.userbl.CustomerInfoManagementController;
import dataservice.orderdataservice.OrderDataService;
import po.CreditPO;
import po.CustomerInfoPO;
import po.OrderPO;
import util.Action;
import util.OrderState;
import util.PromotionHotelType;
import util.PromotionWebType;
import util.ResultMsg;
import util.Today;
import util.VipType;
import vo.CustomerInfoVO;
import vo.OrderVO;

/**
 * 客户对订单的相关操作
 * @author txin15
 *
 */
public class OrderOnUser {
	
	private OrderDataService userDataService;
	private CreditController credit;
	private CustomerInfoManagementController customer;
	
	public OrderOnUser(OrderDataService userDataService) {
		this.userDataService = userDataService;
	}
	
	/**
	 * 客户查看个人订单信息
	 *
	 * @param ID
	 * @return 个人订单列表
	 * @throws RemoteException 
	 */
	public ArrayList<OrderVO> personalOrderScan(String ID) throws RemoteException {
		ArrayList<OrderVO> userVOs = new ArrayList<OrderVO>();
		ArrayList<OrderPO> userPOs;
		
		userPOs = userDataService.findByUserID(ID);
//		if(userPOs == null || userPOs.isEmpty()) {
//			return null;
//		}
		
		userVOs = new ArrayList<OrderVO>(userPOs.size());
		for(OrderPO userPO : userPOs) {
			userVOs.add((OrderVO)VOPOchange.POtoVO(userPO));
		}
		return userVOs;
	}
	
	/**
	 * 客户创建订单
	 *
	 * @param 个人订单
	 * @return 订单价格;促销类型
	 * @throws RemoteException 
	 */
	public String createOrder(OrderVO orderVO) throws RemoteException {
		
		customer = (CustomerInfoManagementController)BusinessLogicDataFactory.getFactory().
				getCustomerIndividualInformationManagementBLService();
		CustomerInfoPO customerInfoPO = customer.getCustomerInfo(orderVO.getInitiator().getUserID());
		
		if(customerInfoPO.getCredit() >= 0){	//信用值过低拒绝生成订单
			CustomerInfoVO customerInfoVO = (CustomerInfoVO)VOPOchange.POtoVO(customerInfoPO);
			double min = orderVO.getPrice();
			PromotionWebType promotionWebType = null;
			PromotionHotelType promotionHotelType = null;
			
			if(customerInfoVO.getIsMember()) {
				
				VipType vipType = customerInfoVO.getVipType();
				double[] price = new double[6];
				PromotionValueController pro = new PromotionValueController();
				
				//计算各个策略得到的价格
				if(vipType == VipType.COMMON_VIP) {
					
					price[0] = pro.getValue(customerInfoVO, orderVO, PromotionHotelType.BIRTH_PROMOTION);
					price[1] = pro.getValue(customerInfoVO, orderVO, PromotionHotelType.HOTEL_CUSTOM_PROMOTION);
					price[3] = pro.getValue(customerInfoVO, orderVO, PromotionHotelType.OVERTHREE_PROMOTION);
					price[4] = pro.getValue(customerInfoVO, orderVO, PromotionWebType.VIP_CIRCLE_PROMOTION);
					price[5] = pro.getValue(customerInfoVO, orderVO, PromotionWebType.VIP_LEVEL_PROMOTION);
					price[2] = pro.getValue(customerInfoVO, orderVO, PromotionWebType.WEB_CUSTOM_PROMOTION);
					
				} else if(vipType == VipType.COMPANY_VIP) {
					
					price[1] = pro.getValue(customerInfoVO, orderVO, PromotionHotelType.HOTEL_CUSTOM_PROMOTION);
					price[0] = pro.getValue(customerInfoVO, orderVO, PromotionHotelType.JOIN_PROMOTION);
					price[3] = pro.getValue(customerInfoVO, orderVO, PromotionWebType.VIP_CIRCLE_PROMOTION);
					price[2] = pro.getValue(customerInfoVO, orderVO, PromotionHotelType.OVERTHREE_PROMOTION);
					price[4] = pro.getValue(customerInfoVO, orderVO, PromotionWebType.VIP_LEVEL_PROMOTION);
					price[5] = pro.getValue(customerInfoVO, orderVO, PromotionWebType.WEB_CUSTOM_PROMOTION);
				}
				
				//得到最低价格
				int number = 0;
				for(int i = 0; i < price.length; i++) {
					if(price[i] < min) {
						min = price[i];
						number = i;
					}
				}
				
				//判断最低价格对应的促销类型
				if(vipType == VipType.COMMON_VIP) {
					switch (number) {
					case 0:	promotionHotelType = PromotionHotelType.BIRTH_PROMOTION;	break;
					case 1:	promotionHotelType = PromotionHotelType.HOTEL_CUSTOM_PROMOTION;	break;
					case 3:	promotionHotelType = PromotionHotelType.OVERTHREE_PROMOTION;	break;
					case 4:	promotionWebType = PromotionWebType.VIP_CIRCLE_PROMOTION;	break;
					case 5:	promotionWebType = PromotionWebType.VIP_LEVEL_PROMOTION;	break;
					case 2: promotionWebType = PromotionWebType.WEB_CUSTOM_PROMOTION;	break;
					default:
						break;
					}
				}else if(vipType == VipType.COMPANY_VIP) {
					switch (number) {
					case 0:	promotionHotelType = PromotionHotelType.JOIN_PROMOTION;	break;
					case 1:	promotionHotelType = PromotionHotelType.HOTEL_CUSTOM_PROMOTION;	break;
					case 2:	promotionHotelType = PromotionHotelType.OVERTHREE_PROMOTION;	break;
					case 3:	promotionWebType = PromotionWebType.VIP_CIRCLE_PROMOTION;	break;
					case 4:	promotionWebType = PromotionWebType.VIP_LEVEL_PROMOTION;	break;
					case 5: promotionWebType = PromotionWebType.WEB_CUSTOM_PROMOTION;	break;
					default:
						break;
					}
				}
			}
			
			OrderPO orderPO = (OrderPO)VOPOchange.VOtoPO(orderVO);
			
			//保证价格为两位小数
			DecimalFormat dFormat = new DecimalFormat("#.00");
			String price = dFormat.format(min);
			min = Double.valueOf(price);
			
			//修改价格，在数据库中插入
			orderPO.setPrice(min);
			orderPO.setLatestExecutionTime(orderPO.getCheckInTime().substring(0,10)+" 24:00");
			orderPO.setOrderState(OrderState.UNEXECUTED);
			
			userDataService.insert(orderPO);
			
			if(promotionHotelType == null && promotionWebType == null){
				return min + ";" + "未使用促销策略";
			}else if(promotionHotelType == null){
				return min + ";" + promotionWebType.toString();
			}else if(promotionWebType == null){
				return min + ";" + promotionHotelType.toString();
			}else{
				return null;
			}
			 
		}else{
			return null;
		}
		
	}
	
	/**
	 * 客户撤销个人订单
	 *
	 * @param orderVO 订单VO
	 * @return 系统提示消息
	 * @throws RemoteException 
	 */
	public ResultMsg personalOrderCancel(OrderVO orderVO) throws RemoteException {
		OrderPO orderOnUserPO = userDataService.findByOrderID(orderVO.getOrderID());
		ResultMsg resultMsg;
		
		if(orderOnUserPO == null) {
			return ResultMsg.NOT_EXIST;
		}
		
		if(orderOnUserPO.getOrderState() == OrderState.UNEXECUTED) {
			
			//修改订单状态
			orderOnUserPO.setOrderState(OrderState.CANCELLED);
			//记录撤销时间
			String today = new Today().getToday();
			orderOnUserPO.setCancelledTime(today);
			resultMsg = userDataService.update(orderOnUserPO);
			
			//如果撤销的订单距离最晚执行时间不足6个小时，扣除信用值（订单价值的1/2），设置creditPO状态为Cancelled
			String lastTime = orderOnUserPO.getLatestExecutionTime();
			if(lastTime.compareTo(today) >= 0 && resultMsg == ResultMsg.SUCCESS) {
				int lastTimeYear = Integer.parseInt(lastTime.substring(0, 4));
				int lastTimeMonth = Integer.parseInt(lastTime.substring(5, 7));
				int lastTimeDay = Integer.parseInt(lastTime.substring(8, 10));
				int lastTimeHour = Integer.parseInt(lastTime.substring(11, 13));
				int lastTimeMin = Integer.parseInt(lastTime.substring(14));
				int todayYear = Integer.parseInt(today.substring(0, 4));
				int todayMonth = Integer.parseInt(today.substring(5, 7));
				int todayDay = Integer.parseInt(today.substring(8, 10));
				int todayHour = Integer.parseInt(today.substring(11, 13));
				int todayMin = Integer.parseInt(today.substring(14));
				Calendar lastCalendar = Calendar.getInstance();
				Calendar todayCalendar = Calendar.getInstance();
				lastCalendar.set(lastTimeYear, lastTimeMonth-1, lastTimeDay, lastTimeHour, lastTimeMin);
				todayCalendar.set(todayYear, todayMonth-1, todayDay, todayHour, todayMin);
				if(lastCalendar.getTimeInMillis()-todayCalendar.getTimeInMillis() <= 6*60*60*1000) {
					credit = (CreditController)BusinessLogicDataFactory.getFactory().getCreditBLService();
					CreditController controller = new CreditController();
					controller.subCredit(orderVO.getInitiator(), (int)orderOnUserPO.getPrice()/2);
					ArrayList<CreditPO> creditPOs = credit.getListByUserID(orderOnUserPO.getInitiator().getUserID());
					CreditPO creditPO = creditPOs.get(creditPOs.size()-1);
					creditPO.setCreditChange("-"+(int)orderVO.getPrice()/2);
					creditPO.setCreditResult(creditPO.getCreditResult()-(int)orderVO.getPrice()/2);
					creditPO.setTime(new Today().getToday());
					creditPO.setAction(Action.Cancelled);
					creditPO.setOrderID(orderVO.getOrderID());
					resultMsg = credit.insert(creditPO);
				}
			}else{
				
			}
			
		}else{
			resultMsg = ResultMsg.FAIL;
		}
		
		return resultMsg;
	}
	
	/**
	 * 客户查看个人订单详情
	 *
	 * @param String 订单ID
	 * @return 个人订单详情
	 * @throws RemoteException 
	 */
	public OrderVO personalOrderDetail(String ID) throws RemoteException {
		OrderPO userPO = userDataService.findByOrderID(ID);
		return (OrderVO)VOPOchange.POtoVO(userPO);
	}

}
