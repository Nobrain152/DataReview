package blservice.orderblservice;

import java.rmi.RemoteException;
import java.util.ArrayList;

import util.ResultMsg;
import vo.OrderVO;

/**
 * 客户查询个人订单信息及详情，执行订单的撤销
 * 
 * @author txin15
 *
 */
public interface OrderOnUserBLService {
	
	/**
	 * 客户查看个人订单信息
	 *
	 * @param void
	 * @return 个人订单列表
	 */
	public ArrayList<OrderVO> personalOrderScan(String ID);
	
	/**
	 * 客户创建订单
	 *
	 * @param 个人订单
	 * @return void
	 * @throws RemoteException 
	 */
	public String createOrder(OrderVO orderVO);
	
	/**
	 * 客户撤销个人订单
	 *
	 * @param orderVO 订单VO
	 * @return 系统提示消息
	 */
	public ResultMsg personalOrderCancel(OrderVO orderVO);
	
	/**
	 * 客户查看个人订单详情
	 *
	 * @param OrderVO 订单VO
	 * @return 个人订单详情
	 */
	public OrderVO personalOrderDetail(String ID);
	
}
