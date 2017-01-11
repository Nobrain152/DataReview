package bl.orderbl;

import java.rmi.RemoteException;
import java.util.ArrayList;

import bl.BusinessLogicDataFactory;
import bl.VOPOchange;
import bl.creditbl.CreditController;
import bl.hotelbl.RoomAddController;
import dataservice.orderdataservice.OrderDataService;
import po.CreditPO;
import po.CustomerInfoPO;
import po.OrderPO;
import po.RoomInfoPO;
import util.Action;
import util.OrderState;
import util.ResultMsg;
import util.RoomState;
import util.Today;
import vo.CustomerInfoVO;
import vo.OrderVO;

/**
 * 酒店工作人员对订单的相关操作
 * @author txin15
 *
 */
public class OrderOnHotel {
	
	private OrderDataService hotelDataService;
	private RoomAddController room;
	private CreditController credit;
	
	public OrderOnHotel(OrderDataService hotelDataService) {
		this.hotelDataService = hotelDataService;
	}
	
	/**
	 * 酒店工作人员查看酒店订单列表
	 *
	 * @param ID
	 * @return 酒店订单列表
	 * @throws RemoteException 
	 */
	public ArrayList<OrderVO> hotelOrderScan(String ID) throws RemoteException {
		
		ArrayList<OrderVO> hotelVOs = new ArrayList<OrderVO>();
		ArrayList<OrderPO> hotelPOs;
		
		hotelPOs = hotelDataService.findByHotelID(ID);
		if(hotelPOs == null || hotelPOs.isEmpty()) {
			return null;
		}
		
		hotelVOs = new ArrayList<OrderVO>(hotelPOs.size());
		for(OrderPO hotelPO : hotelPOs) {
			hotelVOs.add((OrderVO)VOPOchange.POtoVO(hotelPO));
		}
		
		return hotelVOs;
	}
	
	/**
	 * 酒店工作人员查看酒店订单详情
	 *
	 * @param String 订单ID
	 * @return 酒店订单详情
	 * @throws RemoteException 
	 */
	public OrderVO hotelOrderDetail(String ID) throws RemoteException {
		OrderPO hotelPO = hotelDataService.findByOrderID(ID);
		return (OrderVO)VOPOchange.POtoVO(hotelPO);
	}
	
	/**
	 * 酒店工作人员修改订单状态
	 *
	 * @param orderVO 订单VO
	 * @return 系统提示消息
	 * @throws RemoteException 
	 */
	public ResultMsg hotelOrderModify(OrderVO orderVO) throws RemoteException {
		ResultMsg resultMsg = ResultMsg.FAIL;
		credit = (CreditController)BusinessLogicDataFactory.getFactory().getCreditBLService();
		ArrayList<CreditPO> creditPOs = credit.getListByUserID(orderVO.getInitiator().getUserID());
		CreditPO creditPO = creditPOs.get(creditPOs.size()-1);
		OrderPO orderPO = hotelDataService.findByOrderID(orderVO.getOrderID());
		ArrayList<String> roomIDs = orderVO.getRoomIDs();

		room = (RoomAddController)BusinessLogicDataFactory.getFactory().getRoomAddBLService();
		for(int i = 0; i < roomIDs.size(); i++){
			RoomInfoPO roomInfoPO = room.findByRoomID(roomIDs.get(0));
			
			//未执行的订单改为已执行
			if(orderPO.getOrderState() == OrderState.UNEXECUTED
					&& roomInfoPO.getState() == RoomState.USABLE) {
				CustomerInfoPO customerInfoPO = orderPO.getInitiator();
				CreditController controller = new CreditController();
				
				CustomerInfoVO customerInfoVO = (CustomerInfoVO)VOPOchange.POtoVO(customerInfoPO);
				controller.addCredit(customerInfoVO, (int)orderVO.getPrice());
				
				roomInfoPO.setRoomState(RoomState.UNUSABLE);
				orderPO.setOrderState(OrderState.EXECUTED);
				room.update(roomInfoPO);
				hotelDataService.update(orderPO);
				
				creditPO.setOrderID(orderVO.getOrderID());
				creditPO.setAction(Action.Executed);
				creditPO.setCreditResult(creditPO.getCreditResult() + (int)orderVO.getPrice());
				creditPO.setCreditChange("+" + (int)orderVO.getPrice());
				creditPO.setTime(new Today().getToday());
				credit.insert(creditPO);
				resultMsg = ResultMsg.SUCCESS;
			} 
			
			//已执行的订单，用户退房，修改房间信息为可用
			else if(orderPO.getOrderState() == OrderState.EXECUTED
					&& roomInfoPO.getState() == RoomState.UNUSABLE) {
				
				roomInfoPO.setRoomState(RoomState.USABLE);
				room.update(roomInfoPO);
				resultMsg = ResultMsg.SUCCESS;
				
			} 
			
			//异常订单，延迟入住
			else if(orderPO.getOrderState() == OrderState.ABNORMAL) {
				
				CustomerInfoPO customerInfoPO = orderPO.getInitiator();
				CreditController controller = new CreditController();
				
				CustomerInfoVO customerInfoVO = (CustomerInfoVO)VOPOchange.POtoVO(customerInfoPO);
				controller.addCredit(customerInfoVO, (int)orderVO.getPrice());
				
				roomInfoPO.setRoomState(RoomState.UNUSABLE);
				orderPO.setOrderState(OrderState.EXECUTED);
				room.update(roomInfoPO);
				hotelDataService.update(orderPO);
				
				creditPO.setAction(Action.Executed);
				creditPO.setCreditResult(creditPO.getCreditResult() + (int)orderVO.getPrice());
				creditPO.setCreditChange("+" + (int)orderVO.getPrice());
				creditPO.setTime(new Today().getToday());
				credit.insert(creditPO);
				
				resultMsg = ResultMsg.SUCCESS;
			}
		}
		return resultMsg;
	}

	public void update(OrderPO poTmp) throws RemoteException {
		hotelDataService.update(poTmp);
	}

}
