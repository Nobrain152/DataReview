package po;

import java.io.Serializable;
import java.util.ArrayList;

import util.UserType;
import util.VipType;

/**
 * 客户信息
 * @author 曹畅
 *
 */
public class CustomerInfoPO extends UserInfoPO implements Serializable{
    
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

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
	
	/**
	 * 客户的订单ID列表
	 */
	ArrayList<String> orderIDList;
	
	/**
	 * 客户预订过的酒店ID列表
	 */
	ArrayList<String> hotelIDList;
	
	
	
	public CustomerInfoPO() {}

	public CustomerInfoPO(String userid, String username, String contact,
			String password,int credit, boolean isMember,VipType vipType) {
		super(userid, username, contact,password);
		this.credit = credit;
		this.isMember = isMember;
		this.vipType = vipType;
		this.orderIDList = new ArrayList<String>();
		this.hotelIDList = new ArrayList<String>();
		this.type = UserType.Customer;
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
	
	public ArrayList<String> getOrderIDList() {
		return orderIDList;
	}

	public ArrayList<String> getHotelIDList() {
		return hotelIDList;
	}
	
	
	
	public void setVipType(VipType vipType) {
		this.vipType = vipType;
	}
	
	public void setIsMember(boolean isMember) {
		this.isMember = isMember;
	}

	public void addOrderID(String id) {
		if (orderIDList.indexOf(id) == -1) {
			orderIDList.add(id);
		}
	}

	public void addHotelID(String id) {
		if (hotelIDList.indexOf(id) == -1) {
			hotelIDList.add(id);
		}
	}
	
	public void setCredit(int credit) {
		this.credit = credit;
	}
	
}