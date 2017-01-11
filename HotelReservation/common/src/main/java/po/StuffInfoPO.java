package po;

import java.io.Serializable;

import po.UserInfoPO;

/**
 * 酒店管理人员，网站管理人员，网站营销人员的信息
 * @author 曹畅
 *
 */
public class StuffInfoPO extends UserInfoPO implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	
	/**
	 * 酒店工作人员的隶属酒店ID
	 */
	private String hotel;
	
	public StuffInfoPO() {}
	
	public StuffInfoPO(String userid,String username,String contact,String VO,String password){
	    super(userid, username, contact,password);
		this.hotel = VO;
	}
	
	public String getHotel(){
		return hotel;
	}	
	
	public void setHotel(String vo){
		hotel = vo;
	}
	
	
}