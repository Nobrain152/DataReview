package blservice.orderblservice;

import java.util.ArrayList;

import util.OrderState;
import util.ResultMsg;
import util.RoomType;
import vo.CustomerInfoVO;
import vo.OrderVO;

public class OrderOnUserBLService_Stub implements OrderOnUserBLService{

	OrderState orderState;

	public OrderOnUserBLService_Stub(){

	}
	
	public OrderOnUserBLService_Stub(OrderState orderState) {
		super();
		this.orderState = orderState;
	}
	


	@Override
	public ArrayList<OrderVO> personalOrderScan(String ID) {
		CustomerInfoVO client = new CustomerInfoVO("1000066", "123", "12345678910", "sfd", 0, false, null);
		OrderVO orderVO = new OrderVO("60000010", client, OrderState.UNEXECUTED, 100, "5000", false, "", "", "", "", 1, null, 1, RoomType.ROOM_BIGBED);
		ArrayList<OrderVO> orderVOs = new ArrayList<>();
		orderVOs.add(orderVO);
		return orderVOs;
	}

	@Override
	public String createOrder(OrderVO orderVO) {
		return orderVO.getPrice()+"";
	}

	@Override
	public util.ResultMsg personalOrderCancel(OrderVO orderVO) {
		return ResultMsg.SUCCESS;
	}

	@Override
	public OrderVO personalOrderDetail(String ID) {
		CustomerInfoVO client = new CustomerInfoVO("1000066", "123", "12345678910", "sfd", 0, false, null);
		OrderVO orderVO = new OrderVO("60000010", client, OrderState.UNEXECUTED, 100, "5000", false, "", "", "", "", 1, null, 1, RoomType.ROOM_BIGBED);
		return orderVO;
	}

}
