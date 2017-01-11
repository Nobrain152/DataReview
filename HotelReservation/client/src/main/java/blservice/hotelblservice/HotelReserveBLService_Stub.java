package blservice.hotelblservice;

import util.ResultMsg;
import vo.OrderVO;

public class HotelReserveBLService_Stub implements HotelReserveBLService{

	@Override
	public ResultMsg reserveHotel(OrderVO vo) {
		
		return ResultMsg.SUCCESS;
	}

}
