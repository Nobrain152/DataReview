package po;

import java.io.Serializable;

/**
 * 登录信息
 * @author lenovo
 *
 */
public class LoginInPO implements Serializable{

    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/**
     * 用户名
     */
    private String username;
	
	/**
	 * 密码
	 */
	private String password;
	
	public LoginInPO() {}
	
	public LoginInPO(String username,String password){
	    this.username = username;
		this.password = password;
	}
	
	public String getUsername(){
	    return username;
	}
	
	public String getPassword(){
	    return password;
	}
}