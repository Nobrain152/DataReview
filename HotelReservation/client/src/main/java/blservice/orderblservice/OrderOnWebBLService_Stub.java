package blservice.orderblservice;

import java.util.ArrayList;

import util.OrderState;
import util.ResultMsg;
import util.RoomType;
import vo.CustomerInfoVO;
import vo.OrderVO;

public class OrderOnWebBLService_Stub implements OrderOnWebBLService{

	OrderState orderState;

	public OrderOnWebBLService_Stub(){

	}
	
	public OrderOnWebBLService_Stub(OrderState orderState) {
		super();
		this.orderState = orderState;
	}
	
	@Override
	public ArrayList<OrderVO> dayUnexOrder(String today) {
		CustomerInfoVO client = new CustomerInfoVO("1000066", "123", "12345678910", "sfd", 0, false, null);
		OrderVO orderVO = new OrderVO("60000010", client, OrderState.UNEXECUTED, 100, "5000", false, "", "", "", "", 1, null, 1, RoomType.ROOM_BIGBED);
		ArrayList<OrderVO> orderVOs = new ArrayList<>();
		orderVOs.add(orderVO);
		return orderVOs;
	}

	@Override
	public OrderVO abnormalOrderDetail(String ID) {
		CustomerInfoVO client = new CustomerInfoVO("1000066", "123", "12345678910", "sfd", 0, false, null);
		OrderVO orderVO = new OrderVO("60000010", client, OrderState.UNEXECUTED, 100, "5000", false, "", "", "", "", 1, null, 1, RoomType.ROOM_BIGBED);
		return orderVO;
	}

	@Override
	public util.ResultMsg abnormalOrderCancel(String ID, boolean b) {
		return ResultMsg.SUCCESS;
	}

	@Override
	public ArrayList<OrderVO> abnormalOrderScan() {
		CustomerInfoVO client = new CustomerInfoVO("1000066", "123", "12345678910", "sfd", 0, false, null);
		OrderVO orderVO = new OrderVO("60000010", client, OrderState.ABNORMAL, 100, "5000", false, "", "", "", "", 1, null, 1, RoomType.ROOM_BIGBED);
		ArrayList<OrderVO> orderVOs = new ArrayList<>();
		orderVOs.add(orderVO);
		return orderVOs;
	}
	
	

}
