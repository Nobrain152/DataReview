package po;

import java.io.Serializable;

import util.UserType;
import util.VipType;

public class CommonVipPO extends CustomerInfoPO implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	/**
	 * 普通会员生日
	 */
	String birthday;
	
	/**
	 * 用户类型
	 */
	UserType type;
	
	public CommonVipPO() {}

	public CommonVipPO(String userid, String username,String password,String contact,
			int credit, String birthday,VipType vipType) {
		super(userid, username, contact,password, credit, true, vipType);
		this.birthday = birthday;
		this.type = UserType.Customer;
	}
	
	public String getBirthday(){
		return birthday;
	}
	
	public void setBirthday(String birthday){
		this.birthday = birthday;
	}

}
