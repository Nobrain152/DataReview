package bl.promotionbl;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.ArrayList;

import bl.BusinessController;
import blservice.promotionblservice.PromotionHotelBLService;
import dataservice.promotiondataservice.PromotionHotelDataService;
import net.RMIManage;
import util.DataServiceType;
import util.PromotionHotelType;
import util.ResultMsg;
import vo.PromotionHotelVO;

public class PromotionHotelController extends BusinessController implements PromotionHotelBLService{

	private PromotionHotel promotionHotel;
	private PromotionHotelDataService hotelDataService;
	ResultMsg resultMsg = ResultMsg.FAIL;
	
	public PromotionHotelController() {
		this.hotelDataService = (PromotionHotelDataService)RMIManage
				.getDataService(DataServiceType.PromotionHotelDataService);
		promotionHotel = new PromotionHotel(hotelDataService);
	}

	@Override
	public ResultMsg changeBirthCut(int level, double ratio, String hotelID) {
		try {
			resultMsg = promotionHotel.changeBirthCut(level, ratio, hotelID);
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return resultMsg;
	}

	@Override
	public ResultMsg changeOverCut(int number, double ratio, String hotelID) {
		try {
			resultMsg = promotionHotel.changeOverCut(number, ratio, hotelID);
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return resultMsg;
	}

	@Override
	public ResultMsg changeJoin(String businessName, double ratio, String hotelID) {
		try {
			resultMsg = promotionHotel.changeJoin(businessName, ratio, hotelID);
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return resultMsg;
	}

	@Override
	public ResultMsg changeHotelCustomCut(String timeBegin, String timeOver, double ratio, String hotelID) {
		try {
			resultMsg = promotionHotel.changeHotelCustomCut(timeBegin, timeOver, ratio, hotelID);
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return resultMsg;
	}

	@Override
	public ResultMsg addBirthCut(int level, double ratio, String hotelID) {
		try {
			resultMsg = promotionHotel.addBirthCut(level, ratio, hotelID);
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return resultMsg;
	}

	@Override
	public ResultMsg addOverCut(int number, double ratio, String hotelID) {
		try {
			resultMsg = promotionHotel.addOverCut(number, ratio, hotelID);
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return resultMsg;
	}

	@Override
	public ResultMsg addJoin(String businessName, double ratio, String hotelID) {
		try {
			resultMsg = promotionHotel.addJoin(businessName, ratio, hotelID);
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return resultMsg;
	}

	@Override
	public ResultMsg addHotelCustomCut(String timeBegin, String timeOver, double ratio, String hotelID) {
		try {
			resultMsg = promotionHotel.addHotelCustomCut(timeBegin, timeOver, ratio, hotelID);
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return resultMsg;
	}

	@Override
	public ArrayList<PromotionHotelVO> getHotelPromotion(PromotionHotelType type, String hotelID) {
		ArrayList<PromotionHotelVO> list = null;
		try {
			list = promotionHotel.getHotelPromotion(type, hotelID);
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return list;
	}

	@Override
	public ResultMsg deleteBirthCut(int level, String hotelID) {
		try {
			resultMsg = promotionHotel.deleteBirthCut(level, hotelID);
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return resultMsg;
	}

	@Override
	public ResultMsg deleteOverCut(int number, String hotelID) {
		try {
			resultMsg = promotionHotel.deleteOverCut(number, hotelID);
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return resultMsg;
	}

	@Override
	public ResultMsg deleteJoin(String businessName, String hotelID) {
		try {
			resultMsg = promotionHotel.deleteJoin(businessName, hotelID);
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return resultMsg;
	}

	@Override
	public ResultMsg deleteHotelCustomCut(String timeBegin, String timeOver, String hotelID) {
		try {
			resultMsg = promotionHotel.deleteHotelCustomCut(timeBegin, timeOver, hotelID);
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return resultMsg;
	}

	@Override
	public void reinitDataService(Remote dataService) {
		hotelDataService = (PromotionHotelDataService) dataService;
		promotionHotel = new PromotionHotel(hotelDataService);
	}

}
