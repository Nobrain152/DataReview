
package vo;


import util.UserType;
import util.VipType;

/**
 * 客户信息
 * 
 * @author 曹畅
 *
 */
public class CustomerInfoVO extends UserInfoVO {

	/**
	 * 客户信用值
	 */
	private int credit;
	
	/**
	 * 是否会员
	 */
	private boolean isMember;
	
	/**
	 * 会员类型
	 */
	private VipType vipType;
	
	
	public CustomerInfoVO() {}
	
	public CustomerInfoVO(String userid, String username, String contact,
			String password,int credit, boolean isMember,VipType vipType) {
		super(userid, username, contact,password);
		this.credit = credit;
		this.isMember = isMember;
		this.vipType = vipType;
		setType(UserType.Customer);
	}

	public int getCredit() {
		return credit;
	}

	public boolean getIsMember() {
		return isMember;
	}
	
	public VipType getVipType() {
		return vipType;
	}
	
	
	public void setVipType(VipType vipType) {
		this.vipType = vipType;
	}
	
	public void setIsMember(boolean isMember) {
		this.isMember = isMember;
	}
	
	public void setCredit(int c) {
		credit=c;
	}



	
}