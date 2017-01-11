package blservice.userblservice;

import java.util.ArrayList;

import po.CustomerInfoPO;
import util.Adress;
import util.Area;
import util.ResultMsg;
import util.VipType;
import vo.CreditVO;
import vo.CustomerInfoVO;
import vo.HotelInfoVO;
import vo.OrderVO;

public class CustomerIndividualInformationManagementBLService_Stub implements CustomerIndividualInformationManagementBLService{

	CustomerInfoVO customer;
	ArrayList<OrderVO> order;
	ArrayList<HotelInfoVO> hotelInfoVOs;
	HotelInfoVO hotel;
	ArrayList<CreditVO> credit;
	CustomerInfoPO cPo;
	
	public CustomerIndividualInformationManagementBLService_Stub(){
		customer=new CustomerInfoVO("12345678","Lary","12345678909","12345678",100, false,VipType.COMMON_VIP);
		order = new ArrayList<OrderVO>();
		hotelInfoVOs=new ArrayList<HotelInfoVO>();
		hotel=new HotelInfoVO("SunHotel",Adress.BEIJING,Area.EAST,3,"nice","wifi",false,"5000",6.1,120);
		hotelInfoVOs.add(hotel);
		credit=new ArrayList<CreditVO>();
		cPo=new CustomerInfoPO("12345678","Lary","12345678909","12345678",100, false,VipType.COMMON_VIP);
	}
	
	@Override
	public CustomerInfoVO individualInfolnq(String userid) {
		
		return customer;
	}

	@Override
	public ResultMsg individualInfoMod(String userid, CustomerInfoVO vo2) {
		
		return ResultMsg.SUCCESS;
	}

	@Override
	public ArrayList<OrderVO> individualOrderInq(String userid) {
		
		return order;
	}

	@Override
	public ArrayList<OrderVO> unfinishedOrderInq(String userid) {
		
		return order;
	}

	@Override
	public ArrayList<OrderVO> finishedOrderInq(String userid) {
		
		return order;
	}

	@Override
	public ArrayList<OrderVO> cancelOrderInq(String userid) {
		
		return order;
	}

	@Override
	public ArrayList<OrderVO> abnormalOrderInq(String userid) {
		
		return order;
	}

	@Override
	public ArrayList<HotelInfoVO> individualHotelInq(String userid) {
		
		return hotelInfoVOs;
	}

	@Override
	public ArrayList<HotelInfoVO> unfinishedHotelInq(String userid) {
		
		return hotelInfoVOs;
	}

	@Override
	public ArrayList<HotelInfoVO> finishedHotelInq(String userid) {
		
		return hotelInfoVOs;
	}

	@Override
	public ArrayList<HotelInfoVO> abnormalHotelInq(String userid) {
		
		return hotelInfoVOs;
	}

	@Override
	public ArrayList<HotelInfoVO> cancelHotelInq(String userid) {
		
		return hotelInfoVOs;
	}

	@Override
	public int individualCredictInq(String userid) {
		
		return 100;
	}

	@Override
	public ArrayList<CreditVO> individualCredictRecord(String userid) {
		return credit;
	}

	@Override
	public ResultMsg orderCancel(OrderVO orderVO) {
		
		return ResultMsg.SUCCESS;
	}

	@Override
	public CustomerInfoPO getCustomerInfo(String userID) {
		
		return cPo;
	}

	@Override
	public void setCustomerInfo(String userID, CustomerInfoPO customerInfoPO) {
		
	}

}
