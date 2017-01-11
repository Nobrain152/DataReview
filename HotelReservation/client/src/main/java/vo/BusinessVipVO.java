package vo;

import util.VipType;

/**
 * 企业会员
 * @author txin15
 *
 */
public class BusinessVipVO extends CustomerInfoVO {
	
	/**
	 * 企业会员名称
	 */
	String businessName;
	
	public BusinessVipVO() {}

	public BusinessVipVO(String userid, String username, String password,String contact,
			int credit, String businessName,VipType vipType) {
		super(userid, username, contact, password, credit, true ,vipType);
		this.businessName = businessName;
	}
	
	public String getBusinessName(){
		return businessName;
	}
	
	public void setBusinessName(String businessName){
		this.businessName = businessName;
	}

}
