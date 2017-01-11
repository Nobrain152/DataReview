package bl.userbl;

import java.rmi.RemoteException;

import blservice.userblservice.LoginInputBLService;
import dataservice.userdataservice.UserManagementDataService;
import net.RMIManage;
import util.DataServiceType;
import util.UserType;
import vo.CustomerInfoVO;


/**
 * 用户登录
 * @author 曹畅
 *
 */
public class LoginInputController implements LoginInputBLService {

	private User user;
	private UserManagementDataService data;
	
	/**
	 * 构造方法
	 * @param 用户ID
	 */
	public LoginInputController(){
		data= (UserManagementDataService)RMIManage.
				getDataService(DataServiceType.UserManagementDataService);
		user=new User(data);
	}
	
	
	/**
	 * 登录
	 * @param 登录输入信息VO
	 * @return 登录结果
	 */
    public boolean  LogIn(String id,String password){
    	try {
			return user.LogIn(id,password);
		} catch (RemoteException e) {
			e.printStackTrace();
			return false;
		}
    }
	
	
    /**
	 * 登出	
	 * @param 登录输入信息VO
	 * @return 登出结果
	 */
	public boolean LogOut(boolean ok){
		try {
			return user.LogOut(ok);
		} catch (RemoteException e) {
			e.printStackTrace();
			return false;
		}
	}
	
	
	/**
	 * 注册	
	 * @param 登录输入信息VO
	 * @return 注册结果
	 */
	public String Register(CustomerInfoVO vo){
		try {
			return user.Register(vo);
		} catch (RemoteException e) {
			e.printStackTrace();
			return null;
		}
	}
	
	/**
	 * 得到用户类型
	 * @param userid
	 * @return
	 */
	public UserType getType(String userid){
		try {
			return user.getType(userid);
		} catch (RemoteException e) {
			return null;
		}
	}
}
