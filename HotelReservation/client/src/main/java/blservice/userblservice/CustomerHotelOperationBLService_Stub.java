package blservice.userblservice;

import java.util.ArrayList;

import util.Adress;
import util.Area;
import util.ResultMsg;
import util.Sort;
import vo.HotelEvaluateVO;
import vo.HotelInfoVO;
import vo.OrderVO;
import vo.RoomInfoVO;

public class CustomerHotelOperationBLService_Stub implements CustomerHotelOperationBlService{
	
	ArrayList<HotelInfoVO> hotelInfoVOs;
	HotelInfoVO hotel;
	ArrayList<OrderVO> order;
	
	public CustomerHotelOperationBLService_Stub(){
		hotelInfoVOs=new ArrayList<HotelInfoVO>();
		hotel=new HotelInfoVO("SunHotel",Adress.BEIJING,Area.EAST,3,"nice","wifi",false,"5000",6.1,120);
		hotelInfoVOs.add(hotel);
		order=new ArrayList<OrderVO>();
	}
	

	@Override
	public ArrayList<HotelInfoVO> hotelSearch(RoomInfoVO vo1, HotelInfoVO vo, String userid) {
		return hotelInfoVOs;
	}

	@Override
	public ResultMsg orderCreat(String hotelID, OrderVO vo2) {
		
		return ResultMsg.SUCCESS;
	}

	@Override
	public void hotelEvaluate(HotelEvaluateVO vo) {
		
		
	}

	@Override
	public HotelInfoVO hotelDetail(String hotelid, String userid) {
		
		return hotel;
	}

	@Override
	public ArrayList<HotelInfoVO> sortHotel(ArrayList<HotelInfoVO> before, Sort type) {
		
		return hotelInfoVOs;
	}

	@Override
	public ArrayList<OrderVO> getHotelOrder(String hotelid, String userid) {
		
		return order;
	}

}
