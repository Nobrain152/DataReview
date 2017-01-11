package bl.userbl;

import java.rmi.RemoteException;
import java.util.ArrayList;

import blservice.userblservice.WebManagerHotelOperationBlService;
import dataservice.userdataservice.UserManagementDataService;
import net.RMIManage;
import util.DataServiceType;
import vo.HotelInfoVO;
import vo.StuffInfoVO;


/**
 * 网站管理人员对酒店的操作
 * @author 曹畅
 *
 */
public class WebManagerHotelOperationController implements WebManagerHotelOperationBlService {

	private WebManager manager;
	private UserManagementDataService data;
	
	
	public WebManagerHotelOperationController(){
		data= (UserManagementDataService)RMIManage.
				getDataService(DataServiceType.UserManagementDataService);
		manager=new WebManager(data);
	}
	
	/**
	 * 添加酒店	
	 * @param 酒店信息VO
	 */
	public String hotelAdd(HotelInfoVO vo){
		try {
			return manager.hotelAdd(vo);
		} catch (RemoteException e) {
			return null;
		}
	}
			
	


	/**
	 * 查看酒店列表
	 * @return 酒店信息列表
	 */
	public ArrayList<HotelInfoVO> hotelScan() {
		try {
			return manager.hotelScan();
		} catch (RemoteException e) {
			e.printStackTrace();
			return null;
		}
	}

	/**
	 * 添加酒店工作人员
	 * @param 酒店IDVO
	 * @param 用户IDVO
	 */
	public String stuffAdd(StuffInfoVO vo) {
		try {
			return manager.stuffAdd(vo);
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			return null;
		}
	}

}
