package bl.userbl;

import java.rmi.RemoteException;

import blservice.userblservice.StuffIndividualInformationManagementBLService;
import dataservice.userdataservice.UserManagementDataService;
import net.RMIManage;
import util.DataServiceType;
import util.ResultMsg;
import vo.StuffInfoVO;


/**
 * 酒店管理人员管理个人信息
 * @author 曹畅
 *
 */
public class StuffInfoManagementController implements StuffIndividualInformationManagementBLService {

	private HotelStuff stuff;
	private UserManagementDataService userManagementDataService;
	
	
	public StuffInfoManagementController(){
		userManagementDataService = (UserManagementDataService)RMIManage.
				getDataService(DataServiceType.UserManagementDataService);
		stuff=new HotelStuff(userManagementDataService);
	}
	
	/**
	 * 查看个人基本信息
	 * @param 用户IDVO
	 * @return 酒店管理人员信息VO
	 */
	public StuffInfoVO individualInfolnq(String userid){
		try {
			return stuff.individualInfolnq(userid);
		} catch (RemoteException e) {
			e.printStackTrace();
			return null;
		}
	}
			
	
	/**
	 * 修改个人信息
	 * @param 用户IDVO
	 * @param 酒店管理人员信息VO
	 * @return 修改结果
	 */
	public ResultMsg individualInfoMod(String userid,StuffInfoVO vo2){
		try {
			return stuff.individualInfoMod(userid, vo2);
		} catch (RemoteException e) {
			e.printStackTrace();
			return ResultMsg.FAIL;
		}
	}
			
}
