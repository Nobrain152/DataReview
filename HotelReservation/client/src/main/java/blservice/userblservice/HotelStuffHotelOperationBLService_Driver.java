package blservice.userblservice;

import java.rmi.RemoteException;
import java.util.ArrayList;

import util.OrderState;
import util.ResultMsg;
import util.Sort;
import vo.HotelEvaluateVO;
import vo.HotelInfoVO;
import vo.OrderVO;
import vo.PromotionHotelVO;
import vo.RoomInfoVO;

public class HotelStuffHotelOperationBLService_Driver {

	 public static void main(String[] args){
			
		 HotelStuffHotelOperationBlService a=new HotelStuffHotelOperationBLService_Stub();
		 HotelStuffHotelOperationBLService_Driver b=new HotelStuffHotelOperationBLService_Driver();
		   b.drive(a);
		
		}
		
		public void drive(HotelStuffHotelOperationBlService a){
			ArrayList<HotelInfoVO> hotelInfoVOs;
			HotelInfoVO hotel;
			ArrayList<OrderVO> order;
			
			hotel=a.hotelInfoInq("5000");
			boolean b=a.hotelStrategeDelete(new PromotionHotelVO());
			b=a.hotelStrategeAdd(new PromotionHotelVO());
			b=a.hotelStrategeManage(new PromotionHotelVO());
			ArrayList<PromotionHotelVO> p=a.hotelPromotionInq(new PromotionHotelVO());
			ArrayList<RoomInfoVO> r=a.hotelRoomList("5000");
			order=a.orderScan("5000");
			order=a.abnormalOrderScan("5000");
			order=a.specialOrderScan("5000",OrderState.ABNORMAL);
			ResultMsg res=a.hotelInfoMod(new HotelInfoVO(),"22345678");
			res=a.setRoomInfo(new ArrayList<RoomInfoVO>());
			res=a.updateRoomState(new RoomInfoVO());
			res=a.typeInRoom(new RoomInfoVO());
			res=a.setAbnormalOrder("5000","1234567890");
			try {
				res=a.orderStateUpdate("22345678",new OrderVO());
			} catch (RemoteException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
}
