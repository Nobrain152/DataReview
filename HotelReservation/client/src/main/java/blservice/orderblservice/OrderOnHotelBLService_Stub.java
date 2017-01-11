package blservice.orderblservice;

import java.util.ArrayList;

import po.OrderPO;
import util.OrderState;
import util.ResultMsg;
import util.RoomType;
import vo.CustomerInfoVO;
import vo.OrderVO;

public class OrderOnHotelBLService_Stub implements OrderOnHotelBLService{
	OrderState orderState;

	public OrderOnHotelBLService_Stub(){

	}
	
	public OrderOnHotelBLService_Stub(OrderState orderState) {
		super();
		this.orderState = orderState;
	}
	
	@Override
	//提交界面得到修改订单状态的反馈结果
	public ResultMsg hotelOrderModify(OrderVO orderVO) {
		orderVO.setOrderState(OrderState.EXECUTED);
		if(orderVO.getOrderState() != OrderState.UNEXECUTED)
			return ResultMsg.SUCCESS;
		else
			return ResultMsg.FAIL;
	}

	@Override
	public ArrayList<OrderVO> hotelOrderScan(String ID) {
		CustomerInfoVO client = new CustomerInfoVO(ID, "123", "12345678910", "sfd", 0, false, null);
		OrderVO orderVO = new OrderVO("60000010", client, OrderState.UNEXECUTED, 100, "5000", false, "", "", "", "", 1, null, 1, RoomType.ROOM_BIGBED);
		ArrayList<OrderVO> orderVOs = new ArrayList<>();
		orderVOs.add(orderVO);
		return orderVOs;
	}

	@Override
	public OrderVO hotelOrderDetail(String ID) {
		CustomerInfoVO client = new CustomerInfoVO("1000066", "123", "12345678910", "sfd", 0, false, null);
		OrderVO orderVO = new OrderVO(ID, client, OrderState.UNEXECUTED, 100, "5000", false, "", "", "", "", 1, null, 1, RoomType.ROOM_BIGBED);
		return orderVO;
	}

	@Override
	public void update(OrderPO poTmp) {
		
	}


}
