package bl.userbl;

import java.rmi.RemoteException;
import java.util.ArrayList;

import bl.BusinessLogicDataFactory;
import bl.VOPOchange;
import bl.hotelbl.HotelInfoCheckController;
import bl.hotelbl.HotelInfoMaintainController;
import dataservice.userdataservice.UserManagementDataService;
import po.CustomerInfoPO;
import po.StuffInfoPO;
import po.UserInfoPO;
import util.ResultMsg;
import util.UserType;
import vo.HotelInfoVO;
import vo.StuffInfoVO;
import vo.UserInfoVO;

/**
 * 网站管理人员类
 * @author 曹畅
 * 
 *
 */

public class WebManager extends User {
	private UserManagementDataService data;
	private HotelInfoCheckController check;
	private HotelInfoMaintainController main;
	private BusinessLogicDataFactory factory=BusinessLogicDataFactory.getFactory();
	
	public WebManager(UserManagementDataService data){
		super(data);
		this.data=data;
	}
	/**
	 * 查看个人信息	
	 * @param 用户IDVO
	 * @return 用户个人信息VO
	 */
	public UserInfoVO individualInfolnq(String userid)throws RemoteException{
		UserInfoPO po= data.getWebManagerInfo(userid);
		UserInfoVO vo=(UserInfoVO)VOPOchange.POtoVO(po);
		return vo;
	}
			
	/**
	 * 修改个人信息	
	 * @param 用户IDVO
	 * @param 用户信息VO
	 * @return 修改结果
	 */
	public ResultMsg individualInfoMod(String userid,UserInfoVO vo2)throws RemoteException{
		UserInfoPO past= data.getWebManagerInfo(userid);
		past.setType(UserType.WebManager);
		if(vo2.getContact()!=null){
			if(vo2.getContact().length()!=11){
				return ResultMsg.WRONG_PHONENUMBER;
			}
			past.setContact(vo2.getContact());
		}
		if(vo2.getUsername()!=null){
			past.setUsername(vo2.getUsername());
		}
		return data.updateWebManagerInfo(userid, past);
	}
		
	/**
	 * 添加酒店	
	 * @param 酒店信息VO
	 */
	public String hotelAdd(HotelInfoVO vo)throws RemoteException{
		main=(HotelInfoMaintainController)factory.getHotelInfoMaintainBLService();
		return main.addHotel(vo);
	}
			
	/**
	 * 添加酒店工作人员
	 * @param 酒店IDVO
	 * @param 用户IDVO
	 */
	public String stuffAdd(StuffInfoVO vo)throws RemoteException{
		ArrayList<StuffInfoPO> already=data.hotelStuffScan();
		if(already!=null){
			for(StuffInfoPO p:already){
				if(p.getHotel().equals(vo.getHotel()))
					return null;
			}
		}
		StuffInfoPO po=(StuffInfoPO)VOPOchange.VOtoPO(vo);
		po.setPassword(MD5Util.md5Encode(po.getPassword()));
		String id= data.addHotelStuff(po);
		return id;
	}


	/**
	 * 查看酒店列表
	 * @return 酒店信息列表
	 */
	public ArrayList<HotelInfoVO> hotelScan()throws RemoteException {
		check=(HotelInfoCheckController)factory.getHotelInfoCheckBLService();
		return check.hotelScan();
	}
	
	/**
	 * 查看用户个人信息
	 * @param 用户IDVO
	 * @return 用户个人信息VO
	 */
	public UserInfoVO userInfoInq(String userid)throws RemoteException{
		char c=userid.charAt(0);
		UserInfoPO po;
		switch(c){
		case'1': po=data.getCustomerInfo(userid);break;
		case'2': po=data.getHotelStuffInfo(userid);break;
		case'3': po=data.getWebStuffInfo(userid);break;
		case'4': po=data.getWebManagerInfo(userid);break;
		default: po=null;
		}
		UserInfoVO vo=(UserInfoVO)VOPOchange.POtoVO(po);
		return vo;
	}
			
	
	/**
	 * 修改用户信息
	 * @param 用户IDVO
	 * @param 用户个人信息VO
	 * @return 修改结果
	 */
	public ResultMsg userInfoMod(String userid,UserInfoVO vo2)throws RemoteException{
		UserInfoPO po1=(UserInfoPO)VOPOchange.VOtoPO(vo2);
		char c=userid.charAt(0);
		CustomerInfoPO cu;
		StuffInfoPO stuff;
		UserInfoPO user;
		if(c=='1'){
			cu=data.getCustomerInfo(userid);
			cu.setType(UserType.Customer);
			if(po1.getContact()!=null){
				if(po1.getContact().length()!=11){
					return ResultMsg.WRONG_PHONENUMBER;
				}
				cu.setContact(po1.getContact());
			}
			if(po1.getUsername()!=null){
				cu.setUsername(po1.getUsername());
			}
			return data.updateCustomerInfo(userid,cu);
		}
		if(c=='2'){
			stuff=data.getHotelStuffInfo(userid);
			stuff.setType(UserType.HotelStuff);
			if(po1.getContact()!=null){
				if(po1.getContact().length()!=11){
					return ResultMsg.WRONG_PHONENUMBER;
				}
				stuff.setContact(po1.getContact());
			}
			if(po1.getUsername()!=null){
				stuff.setUsername(po1.getUsername());
			}
			return data.updateHotelStuffInfo(userid, stuff);
		}
		if(c=='3'){
			user=data.getWebStuffInfo(userid);
			user.setType(UserType.WebStuff);
			if(po1.getContact()!=null){
				if(po1.getContact().length()!=11){
					return ResultMsg.WRONG_PHONENUMBER;
				}
				user.setContact(po1.getContact());
			}
			if(po1.getUsername()!=null){
				user.setUsername(po1.getUsername());
			}
			//System.out.println(userid);
			//return ResultMsg.SUCCESS;
			return data.updateWebStuffInfo(userid, user);
		}
		if(c=='4'){
			user=data.getWebManagerInfo(userid);
			user.setType(UserType.WebManager);
			if(po1.getContact()!=null){
				if(po1.getContact().length()!=11){
					return ResultMsg.WRONG_PHONENUMBER;
				}
				user.setContact(po1.getContact());
			}
			if(po1.getUsername()!=null){
				user.setUsername(po1.getUsername());
			}
			return data.updateWebManagerInfo(userid, user);
		}
		
		return ResultMsg.FAIL;
		
		
	}
			
	/**
	 * 添加网站营销人员
	 * @param vo
	 * @return
	 */
	public String addWebStuff(UserInfoVO vo)throws RemoteException{
		vo.setType(UserType.WebStuff);
		UserInfoPO po=(UserInfoPO)VOPOchange.VOtoPO(vo);
		po.setPassword(MD5Util.md5Encode(po.getPassword()));
		String id= data.addWebStuff(po);
		return id;
	}
	

	/**
	 * 查看网站营销人员列表
	 * @return 网站营销人员列表
	 */
	public ArrayList<UserInfoVO> webStuffScan() throws RemoteException{
		ArrayList<UserInfoPO> pos=data.webStuffScan();
		ArrayList<UserInfoVO> vos=new ArrayList<UserInfoVO>();
		for(int i=0;i<pos.size();i++){
			vos.add((UserInfoVO)VOPOchange.POtoVO(pos.get(i)));
		}
		return vos;
	}

}
