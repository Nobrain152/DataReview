package blservice.userblservice;

import java.util.ArrayList;

import util.ResultMsg;
import vo.UserInfoVO;



/**
 * 网站管理人员对网站的操作
 * @author 曹畅
 *
 */
public interface WebManagerWebsiteManagementBLService{
        
	
		
		
	/**
	 * 查看用户个人信息
	 * @param 用户IDVO
	 * @return 用户个人信息VO
	 */
	public UserInfoVO userInfoInq(String userid);
		
	/**
	 * 修改用户信息
	 * @param 用户IDVO
	 * @param 用户个人信息VO
	 * @return 修改结果
	 */
	public ResultMsg userInfoMod(String userid,UserInfoVO vo2);
	
	/**
	 * 查看网站营销人员列表
	 * @return 网站营销人员列表
	 */
	public ArrayList<UserInfoVO> webStuffScan();
	
	/**
	 * 添加网站营销人员
	 * @param vo
	 * @return
	 */
	public String addWebStuff(UserInfoVO vo);
	
	
	
		
}