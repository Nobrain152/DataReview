package po;

import java.io.Serializable;

import util.UserType;

/**
 * 用户父类
 * @author 曹畅
 *
 */
public class UserInfoPO implements Serializable{
	
	private static final long serialVersionUID = -7187002330817151504L;
	/**
	 * 用户ID
	 */
	private String userID;

	/**
	 * 用户姓名
	 */
	private String username;
	
	/**
	 * 密码
	 */
	private String password;

	/**
	 * 联系方式
	 */
	private String contact;
	
	/**
	 * 用户类型
	 */
	public UserType type;
	
	
	public UserInfoPO() {}

	public UserInfoPO(String userID, String username, String  contact,String password) {
		this.userID = userID;
		this.username = username;
		this.contact = contact;
		this.password=password;
	}

	public String getUserID() {
		return userID;
	}

	public String getUsername() {
		return username;
	}

	public String getContact() {
		return contact;
	}
	
	public String getPassword(){
		return password;
	}
	
	public void setUserid(String userID) {
		this.userID = userID;
	}
	
	public void setUsername(String username) {
		this.username = username;
	}
	
	public void setContact(String contact) {
		this.contact = contact;
	}
	
	public void setPassword(String pass){
		password=pass;
	}
	
	public UserType getType(){
		return type;
	}
	
	public void setType(UserType ty){
		type=ty;
	}
	
}