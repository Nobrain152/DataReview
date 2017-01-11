package vo;

/**
 * 登录信息
 * @author 曹畅
 *
 */
public class LoginInVO {

    /**
     * 用户名
     */
    private String username;
	
	/**
	 * 密码
	 */
	private String password;
	
	public LoginInVO() {}
	
	public LoginInVO(String username,String password){
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