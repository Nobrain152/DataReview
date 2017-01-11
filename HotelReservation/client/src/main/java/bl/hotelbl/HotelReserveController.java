package bl.hotelbl;

import java.rmi.Remote;
import java.rmi.RemoteException;

import bl.BusinessController;
import blservice.hotelblservice.HotelReserveBLService;
import dataservice.hoteldataservice.HotelInfoDataService;
import net.RMIManage;
import util.DataServiceType;
import util.ResultMsg;
import vo.OrderVO;


/**
 * Ô¤¶¨¾Æµê
 * @author ²Ü³©
 *
 */
public class HotelReserveController extends BusinessController implements HotelReserveBLService{
	private HotelReserve hotelReserve;
	private HotelInfoDataService hotelInfoData;
	
	public HotelReserveController() {
		hotelInfoData = (HotelInfoDataService) RMIManage
				.getDataService(DataServiceType.HotelInfoDataService);
		hotelReserve = new HotelReserve(hotelInfoData);
	}

	/**
	 * Ô¤¶¨¾Æµê
	 *
	 */
	
	public ResultMsg reserveHotel(OrderVO vo){
		try {
			return hotelReserve.reserveHotel(vo);
		} catch (RemoteException  e) {
			e.printStackTrace();
			return ResultMsg.FAIL;
		}
		
	}

	@Override
	public void reinitDataService(Remote dataService) {
		hotelInfoData = (HotelInfoDataService)dataService;
		hotelReserve = new HotelReserve(hotelInfoData);
	}
	
      
}