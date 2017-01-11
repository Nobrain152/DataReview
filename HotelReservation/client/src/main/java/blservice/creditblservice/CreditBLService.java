package blservice.creditblservice;

import java.util.ArrayList;

import po.CreditPO;
import util.ResultMsg;
import vo.CreditVO;
import vo.CustomerInfoVO;

/**
 * 积分业务逻辑接口
 * @author txin
 *
 */
public interface CreditBLService{
	/**
	 * 获得信用值
	 * 
	 */
	public int getCredit(CustomerInfoVO client);
	
	/**
	 * 增加信用值
	 */
	public ResultMsg addCredit(CustomerInfoVO client,int value);
	
	/**
	 * 减少信用值
	 */
	public ResultMsg subCredit(CustomerInfoVO client,int value);
	
	/**
	 * 修改信用值
	 */
	public ResultMsg changeCredit(CustomerInfoVO client,int value);

	/**
	 * 获取信用值列表
	 * @param userID
	 * @return
	 */
	public ArrayList<CreditVO> getCreditList(String userID);
	
	/**
	 * 插入信用值
	 * @param creditPO
	 * @return
	 */
	public ResultMsg insert(CreditPO creditPO);
	
	/**
	 * 获取用户的一条信用值记录
	 * @param userID
	 * @return
	 */
	public CreditPO get(String userID);

	/**
	 * 获取用户的信用值列表
	 * @param userID
	 * @return
	 */
	public ArrayList<CreditPO> getListByUserID(String userID);
	
}
