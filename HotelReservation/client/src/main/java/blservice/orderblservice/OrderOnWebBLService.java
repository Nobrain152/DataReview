package blservice.orderblservice;

import java.rmi.RemoteException;
import java.util.ArrayList;

import util.ResultMsg;
import vo.OrderVO;

/**
 * 网站营销人员查看申诉列表并处理，查看一场订单列表及详情
 * 
 * @author txin15
 *
 */
public interface OrderOnWebBLService {
	
	/**
	 * 网站营销人员查看异常订单列表
	 *
	 * @param void
	 * @return 异常订单列表
	 */
	public ArrayList<OrderVO> abnormalOrderScan();
	
	/**
	 * 浏览每日未执行订单
	 * @param today
	 * @return
	 * @throws RemoteException
	 */	
	public ArrayList<OrderVO> dayUnexOrder(String today);
	
	/**
	 * 网站营销人员查看异常订单详情
	 *
	 * @param orderVO 订单VO
	 * @return 个人订单详情
	 */
	public OrderVO abnormalOrderDetail(String ID);
	
	/**
	 * 网站营销人员撤销异常订单
	 * 
	 * @param ID
	 * @param b
	 * @return
	 */
	public ResultMsg abnormalOrderCancel(String ID,boolean b);
	
}
