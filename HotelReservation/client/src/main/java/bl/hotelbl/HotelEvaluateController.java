package bl.hotelbl;



import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.ArrayList;

import bl.BusinessController;
import blservice.hotelblservice.HotelEvaluateBLService;
import dataservice.hoteldataservice.HotelEvaluateDataService;
import net.RMIManage;
import util.DataServiceType;
import util.ResultMsg;
import vo.HotelEvaluateVO;

/**
 * 评价酒店
 * @author 曹畅
 *
 */
public class HotelEvaluateController extends BusinessController implements HotelEvaluateBLService{

	private HotelEvaluate hotelEvaluate;
	private HotelEvaluateDataService hotelEvaluateData;
	public ArrayList<HotelEvaluateVO> evaluationList;
	
	public HotelEvaluateController() {
		hotelEvaluateData = (HotelEvaluateDataService) RMIManage
				.getDataService(DataServiceType.HotelEvaluateDataService);
		hotelEvaluate = new HotelEvaluate(hotelEvaluateData);
	}

	/**
	 * 输入评价
	 * @param evaluateInfoVO
	 * @return
	 * @throws RemoteException
	 */
	@Override
	public ResultMsg inputEvaluate(HotelEvaluateVO evaluateInfoVO){
		try {
			return hotelEvaluate.inputEvaluate(evaluateInfoVO);
		} catch (RemoteException e) {
			e.printStackTrace();
			return null;
		}
		
	}

	
	/**
	 * 检查是否在已执行订单中
	 * @param evaluateInfoVO
	 * @return
	 * @throws RemoteException
	 */
	@Override
	public ResultMsg checkOrder(HotelEvaluateVO evaluateInfoVO){
		try {
			return hotelEvaluate.checkOrder(evaluateInfoVO);
		} catch (RemoteException  e) {
			e.printStackTrace();
			return null;
		}
		
	}

	
	/**
	    * 查看某一酒店的评价
	    * @param hotelid
	    * @return
	    */
	@Override
	public ArrayList<HotelEvaluateVO> getEvaluate(String hotelid) {
		try {
			return hotelEvaluate.getEvaluate(hotelid);
		} catch (RemoteException e) {
			return null;
		}
	}

	@Override
	public void reinitDataService(Remote dataService) {
		hotelEvaluateData = (HotelEvaluateDataService)dataService;
		hotelEvaluate = new HotelEvaluate(hotelEvaluateData);
	}
	
}