package bl.userbl;

import java.rmi.RemoteException;

import bl.VOPOchange;
import bl.creditbl.CreditController;
import dataservice.userdataservice.UserManagementDataService;
import po.CreditPO;
import po.CustomerInfoPO;
import util.Action;
import util.UserType;
import vo.CustomerInfoVO;


/**
 * 用户类的父类
 * @author 曹畅
 *
 */
public class User {
	
	private UserManagementDataService data;
	private CreditController creditController;
	
	public User(UserManagementDataService data){
		this.data=data;
		creditController = new CreditController();
	}
	
	/**
	 * 登录
	 * @param 登录输入信息VO
	 * @return 登录结果
	 */
    public boolean  LogIn(String id,String password)throws RemoteException{
    	String real=data.getLoginInfo(id);
    	password=MD5Util.md5Encode(password);
    	return real.equals(password);
    	
    }
	
	
    /**
	 * 登出	
	 * @param 登录输入信息VO
	 * @return 登出结果
	 */
	public boolean LogOut(boolean ok)throws RemoteException{
		if(ok){
			return true;
		}
		else{
			return false;
		}
	}
	
	
	/**
	 * 注册	
	 * @param 登录输入信息VO
	 * @return 注册结果
	 */
	public String Register(CustomerInfoVO vo)throws RemoteException{
		CustomerInfoPO po=(CustomerInfoPO)VOPOchange.VOtoPO(vo);
		po.setCredit(0);
		po.setPassword(MD5Util.md5Encode(po.getPassword()));
		String newID = data.addCustomer(po);
		CreditPO creditPO = new CreditPO(newID, "初始化", "初始化", Action.Initial, "初始化", 0);
		creditController.insert(creditPO);
		return newID;
	}
	
	/**
	 * 得到用户类型
	 * @param userid
	 * @return
	 */
	public UserType getType(String userid)throws RemoteException{
		char charge=userid.charAt(0);
		switch(charge){
		case'1':return UserType.Customer;
		case'2':return UserType.HotelStuff;
		case'3':return UserType.WebStuff;
		case'4':return UserType.WebManager;
		default:return null;
		}
	}
}
