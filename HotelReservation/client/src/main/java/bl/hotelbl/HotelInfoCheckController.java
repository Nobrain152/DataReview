package bl.hotelbl;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.ArrayList;

import bl.BusinessController;
import blservice.hotelblservice.HotelInfoCheckBLService;
import dataservice.hoteldataservice.HotelInfoDataService;
import net.RMIManage;
import util.DataServiceType;
import vo.HotelInfoVO;

/**
 * 
 * @author 曹畅
 *
 */
public class HotelInfoCheckController extends BusinessController implements HotelInfoCheckBLService{
	public ArrayList<HotelInfoVO> hotelList;
	private HotelInfoCheck hotelInfoCheck;
	private HotelInfoDataService hotelInfoData;
	
	public HotelInfoCheckController() {
		hotelList = new ArrayList<HotelInfoVO>();
		hotelInfoData = (HotelInfoDataService) RMIManage
				.getDataService(DataServiceType.HotelInfoDataService);
		hotelInfoCheck = new HotelInfoCheck(hotelInfoData);
	}

	/**
	 * 查看酒店信息
	 * @param hotelInfoVO
	 * @return
	 * @throws RemoteException
	 */
	@Override
    public HotelInfoVO checkHotelInfo(String hotelid){
    	try {
			return hotelInfoCheck.checkHotelInfo(hotelid);
		} catch (RemoteException  e) {
			e.printStackTrace();
		}
		return null;
    }


	/**
	 * 查看所有注册的酒店列表
	 * @return
	 */
	@Override
	public ArrayList<HotelInfoVO> hotelScan() {
		try {
			return hotelInfoCheck.hotelScan();
		} catch (RemoteException e) {
			return null;
		}
	}

	@Override
	public void reinitDataService(Remote dataService) {
		hotelInfoData = (HotelInfoDataService)dataService;
		hotelInfoCheck = new HotelInfoCheck(hotelInfoData);
	}
      
}