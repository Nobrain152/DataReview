package bl.userbl;

import java.rmi.RemoteException;
import java.util.ArrayList;

import blservice.userblservice.WebManagerWebsiteManagementBLService;
import dataservice.userdataservice.UserManagementDataService;
import net.RMIManage;
import util.DataServiceType;
import util.ResultMsg;
import vo.UserInfoVO;



/**
 * 网站管理人员对网站的操作
 * @author 曹畅
 *
 */
public class WebManagerWebsiteManagementController implements WebManagerWebsiteManagementBLService {

	private WebManager manager;
	private UserManagementDataService data;
	
	
	public WebManagerWebsiteManagementController(){
		data= (UserManagementDataService)RMIManage.
				getDataService(DataServiceType.UserManagementDataService);
		manager=new WebManager(data);
	}
	
	/**
	 * 查看用户个人信息
	 * @param 用户IDVO
	 * @return 用户个人信息VO
	 */
	public UserInfoVO userInfoInq(String userid){
		try {
			return manager.userInfoInq(userid);
		} catch (RemoteException e) {
			e.printStackTrace();
			return null;
		}
	}
			
	
	/**
	 * 修改用户信息
	 * @param 用户IDVO
	 * @param 用户个人信息VO
	 * @return 修改结果
	 */
	public ResultMsg userInfoMod(String userid,UserInfoVO vo2){
		try {
			//System.out.println(userid);
			//return ResultMsg.SUCCESS;
			return manager.userInfoMod(userid, vo2);
		} catch (RemoteException e) {
			e.printStackTrace();
			return ResultMsg.FAIL;
		}
	}
			
	/**
	 * 添加网站营销人员
	 * @param vo
	 * @return
	 */
	public String addWebStuff(UserInfoVO vo){
		try {
			return manager.addWebStuff(vo);
		} catch (RemoteException e) {
			return null;
		}
	}
	
	
	/**
	 * 查看网站营销人员列表
	 * @return 网站营销人员列表
	 */
	public ArrayList<UserInfoVO> webStuffScan() {
		try {
			return manager.webStuffScan();
		} catch (RemoteException e) {
			e.printStackTrace();
			return null;
		}
	}
}
