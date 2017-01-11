package vo;

import util.VipType;

/**
 * 普通会员
 * @author txin15
 *
 */
public class CommonVipVO extends CustomerInfoVO {
	
	/**
	 * 普通会员生日
	 */
	String birthday;
	
	public CommonVipVO() {}

	public CommonVipVO(String userid, String username, String password,String contact,
			int credit, String birthday,VipType vipType) {
		super(userid, username, contact, password, credit, true, vipType);
		this.birthday = birthday;
	}
	
	public String getBirthday(){
		return birthday;
	}
	
	public void setBirthday(String birthday){
		this.birthday = birthday;
	}

}
