package blservice.userblservice;

import java.rmi.RemoteException;
import java.util.ArrayList;

import util.Adress;
import util.Area;
import util.OrderState;
import util.ResultMsg;
import vo.HotelInfoVO;
import vo.OrderVO;
import vo.PromotionHotelVO;
import vo.RoomInfoVO;

public class HotelStuffHotelOperationBLService_Stub implements HotelStuffHotelOperationBlService {

	
	ArrayList<HotelInfoVO> hotelInfoVOs;
	HotelInfoVO hotel;
	ArrayList<OrderVO> order;
	ArrayList<PromotionHotelVO> pro;
	ArrayList<RoomInfoVO> room;
	
	public  HotelStuffHotelOperationBLService_Stub() {
		hotelInfoVOs=new ArrayList<HotelInfoVO>();
		hotel=new HotelInfoVO("SunHotel",Adress.BEIJING,Area.EAST,3,"nice","wifi",false,"5000",6.1,120);
		hotelInfoVOs.add(hotel);
		order=new ArrayList<OrderVO>();
		pro=new ArrayList<PromotionHotelVO>();
		room=new ArrayList<RoomInfoVO>();
	}
	
	@Override
	public HotelInfoVO hotelInfoInq(String hotelid) {
		
		return hotel;
	}

	@Override
	public ResultMsg hotelInfoMod(HotelInfoVO vo1, String userid) {
		
		return ResultMsg.SUCCESS;
	}

	@Override
	public boolean hotelStrategeDelete(PromotionHotelVO vo) {
		
		return true;
	}

	@Override
	public ResultMsg setRoomInfo(ArrayList<RoomInfoVO> rooms) {
		
		return ResultMsg.SUCCESS;
	}

	@Override
	public ArrayList<PromotionHotelVO> hotelPromotionInq(PromotionHotelVO vo) {
		
		return pro;
	}

	@Override
	public boolean hotelStrategeManage(PromotionHotelVO vo) {
		
		return true;
	}

	@Override
	public boolean hotelStrategeAdd(PromotionHotelVO vo) {
		
		return true;
	}

	@Override
	public ResultMsg orderStateUpdate(String userid, OrderVO vo2) throws RemoteException {
		
		return ResultMsg.SUCCESS;
	}

	@Override
	public ArrayList<OrderVO> orderScan(String hotelid) {
		
		return order;
	}

	@Override
	public ArrayList<OrderVO> abnormalOrderScan(String hotelid) {
		
		return order;
	}

	@Override
	public ArrayList<OrderVO> specialOrderScan(String hotelid, OrderState state) {
		
		return order;
	}

	@Override
	public ResultMsg updateRoomState(RoomInfoVO vo) {
		
		return ResultMsg.SUCCESS;
	}

	@Override
	public ResultMsg typeInRoom(RoomInfoVO room) {
		
		return ResultMsg.SUCCESS;
	}

	@Override
	public ArrayList<RoomInfoVO> hotelRoomList(String hotelid) {
		
		return room;
	}

	@Override
	public ResultMsg setAbnormalOrder(String hotelid, String orderid) {
		
		return ResultMsg.SUCCESS;
	}

}
