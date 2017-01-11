package bl;

import java.rmi.RemoteException;
import java.util.ArrayList;

import blservice.creditblservice.CreditBLService;
import dataservice.orderdataservice.OrderDataService;
import net.RMIManage;
import po.CreditPO;
import po.OrderPO;
import util.Action;
import util.DataServiceType;
import util.OrderState;
import util.Today;
import vo.OrderVO;

/**
 * 如果时间在超过最晚订单执行时间后还没有办理入住，系统自动将其置为异常订单
 * @author txin15
 *
 */
public class Update implements Runnable{
	
	private OrderDataService orderDataService = (OrderDataService)RMIManage.
			getDataService(DataServiceType.OrderDataService);
	
		
	@Override
	public void run() {
		
		final long timeInterval = 120000;// 2分钟运行一次
		
		while (true) {
			
			ArrayList<OrderPO> orderPOs = null;
			try {
				orderPOs = orderDataService.showList();
				System.out.println("Success Thread");
			} catch (NullPointerException e) {
				System.out.println("No such order");
			}catch (RemoteException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			
			if(orderPOs != null) {
				for(OrderPO po : orderPOs) {
					if(po.getLatestExecutionTime().compareTo(new Today().getToday()) < 0
							&& po.getOrderState() == OrderState.UNEXECUTED) {
						po.setOrderState(OrderState.ABNORMAL);
						//记录撤销时间
						String today = new Today().getToday();
						po.setCancelledTime(today);
						
						CreditBLService controller = BusinessLogicDataFactory.getFactory().getCreditBLService();
						
						OrderVO orderVO = (OrderVO)VOPOchange.POtoVO(po);
						controller.subCredit(orderVO.getInitiator(), (int)po.getPrice()/2);
						
						ArrayList<CreditPO> creditPOs = controller.getListByUserID(po.getInitiator().getUserID());
						CreditPO creditPO = creditPOs.get(creditPOs.size()-1);
						
						//扣除一半的信用值
						creditPO.setOrderID(po.getOrderID());
						creditPO.setCreditChange("-"+(int)orderVO.getPrice()/2);
						creditPO.setCreditResult(creditPO.getCreditResult()-(int)orderVO.getPrice()/2);
						creditPO.setTime(new Today().getToday());
						creditPO.setAction(Action.Abnormal);
						controller.insert(creditPO);
						
						try {
							orderDataService.update(po);
							System.out.println("Success change");
						} catch (RemoteException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
					}
				}
			}
			
			try {
				Thread.sleep(timeInterval);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
}
