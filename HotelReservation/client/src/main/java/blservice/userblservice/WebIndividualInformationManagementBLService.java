package blservice.userblservice;


import util.ResultMsg;
import vo.UserInfoVO;

/**
 * 网站营销人员和网站管理人员的个人信息管理
 * @author Administrator
 *
 */
public interface WebIndividualInformationManagementBLService{
		
	
	/**
	 * 查看个人信息	
	 * @param 用户IDVO
	 * @return 用户个人信息VO
	 */
	public UserInfoVO individualInfolnq(String userid);
		
	/**
	 * 修改个人信息	
	 * @param 用户IDVO
	 * @param 用户信息VO
	 * @return 修改结果
	 */
	public ResultMsg individualInfoMod(String userid,UserInfoVO vo2);
		
}