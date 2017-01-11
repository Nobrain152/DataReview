package bl.promotionbl;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.ArrayList;

import bl.BusinessController;
import blservice.promotionblservice.PromotionWebBLService;
import dataservice.promotiondataservice.PromotionWebDataService;
import net.RMIManage;
import util.Area;
import util.DataServiceType;
import util.PromotionWebType;
import util.ResultMsg;
import vo.PromotionWebVO;

public class PromotionWebController extends BusinessController implements PromotionWebBLService{
	
	private PromotionWeb promotionWeb;
	private PromotionWebDataService webDataService;
	ResultMsg resultMsg = ResultMsg.FAIL;
	
	public PromotionWebController() {
		this.webDataService = (PromotionWebDataService)RMIManage
				.getDataService(DataServiceType.PromotionWebDataService);
		promotionWeb = new PromotionWeb(webDataService);
	}
	
	@Override
	public ResultMsg changeLevelCut(int level, double ratio) {
		try {
			resultMsg = promotionWeb.changeLevelCut(level, ratio);
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return resultMsg;
	}

	@Override
	public ResultMsg changeCircleCut(Area location, double ratio) {
		try {
			resultMsg = promotionWeb.changeCircleCut(location, ratio);
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return resultMsg;
	}

	@Override
	public ResultMsg changeWebCustomCut(String timeBegin, String timeOver, double ratio) {
		try {
			resultMsg = promotionWeb.changeWebCustomCut(timeBegin, timeOver, ratio);
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return resultMsg;
	}

	@Override
	public ResultMsg addLevelCut(int level, double ratio) {
		try {
			resultMsg = promotionWeb.addLevelCut(level, ratio);
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return resultMsg;
	}

	@Override
	public ResultMsg addCircleCut(Area location, double ratio) {
		try {
			resultMsg = promotionWeb.addCircleCut(location, ratio);
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return resultMsg;
	}

	@Override
	public ResultMsg addWebCustomCut(String timeBegin, String timeOver, double ratio) {
		try {
			resultMsg = promotionWeb.addWebCustomCut(timeBegin, timeOver, ratio);
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return resultMsg;
	}

	@Override
	public ArrayList<PromotionWebVO> getWebPromotion(PromotionWebType type) {
		ArrayList<PromotionWebVO> list = null;
		try {
			list = promotionWeb.getWebPromotion(type);
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return list;
	}
	
	@Override
	public ResultMsg deleteLevelCut(int level) {
		try {
			resultMsg = promotionWeb.deleteLevelCut(level);
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return resultMsg;
	}
	
	@Override
	public ResultMsg deleteCircleCut(Area location) {
		try {
			resultMsg = promotionWeb.deleteCircleCut(location);
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return resultMsg;
	}
	
	@Override
	public ResultMsg deleteWebCustomCut(String timeBegin, String timeOver) {
		try {
			resultMsg = promotionWeb.deleteWebCustomCut(timeBegin, timeOver);
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return resultMsg;
	}

	@Override
	public void reinitDataService(Remote dataService) {
		webDataService = (PromotionWebDataService)dataService;
		promotionWeb= new PromotionWeb(webDataService);
		
	}

}
