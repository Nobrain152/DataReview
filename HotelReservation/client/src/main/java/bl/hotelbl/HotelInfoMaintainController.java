
package bl.hotelbl;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.ArrayList;

import bl.BusinessController;
import blservice.hotelblservice.HotelInfoMaintainBLService;
import dataservice.hoteldataservice.HotelInfoDataService;
import net.RMIManage;
import po.HotelInfoPO;
import util.DataServiceType;
import util.ResultMsg;
import vo.HotelInfoVO;

/**
 * 
 * @author 曹畅
 *
 */
public class HotelInfoMaintainController extends BusinessController implements HotelInfoMaintainBLService{
	
	public ArrayList<HotelInfoVO> hotelList;
	private HotelInfoMaintain hotelInfoMaintain;
	private HotelInfoDataService hotelInfoData;
	
	public HotelInfoMaintainController() {
		hotelList = new ArrayList<HotelInfoVO>();
		hotelInfoData = (HotelInfoDataService)RMIManage
				.getDataService(DataServiceType.HotelInfoDataService);
		hotelInfoMaintain = new HotelInfoMaintain(hotelInfoData);
	}
	
	
	/**
	 * 输入酒店基本信息
	 * @param hotelInfoVO
	 * @return
	 * @throws RemoteException
	 */
	@Override
	public ResultMsg inputHotelInfo(HotelInfoVO hotelInfoVO){
		try {
			return hotelInfoMaintain.inputHotelInfo(hotelInfoVO);
		} catch (RemoteException  e) {
			e.printStackTrace();
		}
		return null;
	}
	
	/**
	 * 检查信息是否符合标准
	 * @param hotelInfoVO
	 * @return
	 * @throws RemoteException
	 */
	@Override
    public ResultMsg checkInfo(HotelInfoVO hotelInfoVO){
		try {
			return hotelInfoMaintain.checkInfo(hotelInfoVO);
		} catch (RemoteException  e) {
			e.printStackTrace();
		}
		return null;
    }


	/**
     * 添加酒店
     * @param hotelInfoVO
     * @return
     */
	@Override
	public String addHotel(HotelInfoVO hotelInfoVO) {
		try {
			return hotelInfoMaintain.addHotel(hotelInfoVO);
		} catch (RemoteException e) {
			return null;
		}
	}

	public HotelInfoPO find(String hotelID) {
		try {
			return hotelInfoMaintain.find(hotelID);
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}


	@Override
	public void reinitDataService(Remote dataService) {
		hotelInfoData = (HotelInfoDataService)dataService;
		hotelInfoMaintain = new HotelInfoMaintain(hotelInfoData);
	}

}