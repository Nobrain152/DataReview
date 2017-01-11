package bl.orderbl;

import java.rmi.RemoteException;
import java.util.ArrayList;

import bl.BusinessLogicDataFactory;
import bl.VOPOchange;
import bl.creditbl.CreditController;
import dataservice.orderdataservice.OrderDataService;
import po.CreditPO;
import po.OrderPO;
import util.Action;
import util.OrderState;
import util.ResultMsg;
import util.Today;
import vo.OrderVO;

/**
 * 网站人员对订单的相关操作
 * @author txin15
 *
 */
public class OrderOnWeb {
	
	private OrderDataService webDataService;
	private CreditController credit;
	
	public OrderOnWeb(OrderDataService webDataService) {
		this.webDataService = webDataService;
	}
	
	/**
	 * 网站人员查看异常订单列表
	 *
	 * @param void
	 * @return 异常订单列表
	 * @throws RemoteException 
	 */
	public ArrayList<OrderVO> abnormalOrderScan() throws RemoteException {
		ArrayList<OrderVO> webVOs;
		ArrayList<OrderPO> webPOs;
		
		webPOs = webDataService.showList();
		
		if(webPOs == null || webPOs.isEmpty()) {
			return null;
		}
		
		webVOs = new ArrayList<OrderVO>();
		for(OrderPO webPO : webPOs){
			if(webPO.getOrderState() == OrderState.ABNORMAL)
				webVOs.add((OrderVO)VOPOchange.POtoVO(webPO));
		}
		
		return webVOs;
	}
	
	/**
	 * 网站人员浏览每日未执行订单
	 * @param today
	 * @return
	 * @throws RemoteException
	 */
	public ArrayList<OrderVO> dayUnexOrder(String today) throws RemoteException {
		ArrayList<OrderVO> webVOs;
		ArrayList<OrderPO> webPOs;
		
		webPOs = webDataService.showList();
		
		if(webPOs == null || webPOs.isEmpty()) {
			return null;
		}
		
		webVOs = new ArrayList<OrderVO>();
		for(OrderPO webPO : webPOs){
			if(webPO.getOrderState() == OrderState.UNEXECUTED 
					&& webPO.getLatestExecutionTime().substring(0,10).equals(today.substring(0,10)))
				webVOs.add((OrderVO)VOPOchange.POtoVO(webPO));
		}
		
		return webVOs;
	}
	
	/**
	 * 网站人员查看异常订单详情
	 *
	 * @param String 订单ID
	 * @return 个人订单详情
	 * @throws RemoteException 
	 */
	public OrderVO abnormalOrderDetail(String ID) throws RemoteException{
		ArrayList<OrderPO> webPOs;
		webPOs = webDataService.showList();
		
		for(OrderPO webPO : webPOs) {
			if(webPO.getOrderID().equals(ID))
				return (OrderVO)VOPOchange.POtoVO(webPO);
		}
		return null;
	}
	
	/**
	 * 网站营销人员撤销异常订单；true为恢复全部信用值，false为恢复一半
	 * @param ID
	 * @param b
	 * @return
	 * @throws RemoteException
	 */
	public ResultMsg abnormalOrderCancel(String ID,boolean b) throws RemoteException{
		ArrayList<OrderPO> webPOs;
		webPOs = webDataService.showList();
		ResultMsg resultMsg = ResultMsg.FAIL;
		for(OrderPO webPO : webPOs) {
			if(webPO.getOrderID().equals(ID)){
				OrderVO orderVO = (OrderVO)VOPOchange.POtoVO(webPO);
				credit = (CreditController)BusinessLogicDataFactory.getFactory().getCreditBLService();
				if(b){
					//修改订单状态
					webPO.setOrderState(OrderState.CANCELLED);
					//记录撤销时间
					String today = new Today().getToday();
					webPO.setCancelledTime(today);
					resultMsg = webDataService.update(webPO);
					
					credit.addCredit(orderVO.getInitiator(), (int)webPO.getPrice());
					ArrayList<CreditPO> creditPOs = credit.getListByUserID(webPO.getInitiator().getUserID());
					CreditPO creditPO = creditPOs.get(creditPOs.size()-1);
					creditPO.setOrderID(orderVO.getOrderID());
					creditPO.setCreditChange("+"+(int)orderVO.getPrice());
					creditPO.setCreditResult(creditPO.getCreditResult()+(int)orderVO.getPrice());
					creditPO.setTime(new Today().getToday());
					creditPO.setAction(Action.Cancelled);
					resultMsg = credit.insert(creditPO);
				}else{
					//修改订单状态
					webPO.setOrderState(OrderState.CANCELLED);
					//记录撤销时间
					String today = new Today().getToday();
					webPO.setCancelledTime(today);
					resultMsg = webDataService.update(webPO);
					
					CreditController controller = new CreditController();
					controller.addCredit(orderVO.getInitiator(), (int)webPO.getPrice()/2);
					ArrayList<CreditPO> creditPOs = credit.getListByUserID(webPO.getInitiator().getUserID());
					CreditPO creditPO = creditPOs.get(creditPOs.size()-1);
					creditPO.setCreditChange("+"+(int)orderVO.getPrice()/2);
					creditPO.setCreditResult(creditPO.getCreditResult()+(int)orderVO.getPrice()/2);
					creditPO.setTime(new Today().getToday());
					creditPO.setAction(Action.Cancelled);
					resultMsg = credit.insert(creditPO);
				}
				break;
			}
		}
		return resultMsg;
	}

}
