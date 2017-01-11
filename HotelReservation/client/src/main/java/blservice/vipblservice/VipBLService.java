package blservice.vipblservice;

import po.BusinessVipPO;
import po.CommonVipPO;

/**
 * 会员业务逻辑层接口
 * @author kevin
 *
 */


import util.ResultMsg;
import util.VipType;
import vo.CustomerInfoVO;
import vo.LevelSystemVO;

/**
 * 会员
 * @author txin15
 *
 */
public interface VipBLService {
	
	/**
	 * 获得用户当前信用值对应的等级
	 * @param user
	 * @return
	 */
	public int searchLevel(CustomerInfoVO user);
	
	/**
	 * 注册会员
	 * @param userID
	 * @param str
	 * @return
	 */
	public ResultMsg registerVip(String userID,VipType type,String str);
	
	/**
	 * 制定等级制度
	 * @param levelSystemVO
	 */
	public ResultMsg createLevelSystem(LevelSystemVO levelSystemVO);

	/**
	 * 查找普通会员
	 * @param userID
	 * @return
	 */
	public CommonVipPO findByUserIDC(String userID);
	
	/**
	 * 查找企业会员
	 * @param userID
	 * @return
	 */
	public BusinessVipPO findByUserIDB(String userID);
	
	/**
	 * 更新普通会员信息
	 * @param commonVipPO
	 * @return
	 */
	public ResultMsg updateC(CommonVipPO commonVipPO);
	
	/**
	 * 更新企业会员信息
	 * @param businessVipPO
	 * @return
	 */
	public ResultMsg updateB(BusinessVipPO businessVipPO);
}
