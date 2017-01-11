package bl.vipbl;

import java.rmi.Remote;
import java.rmi.RemoteException;

import bl.BusinessController;
import blservice.vipblservice.VipBLService;
import net.RMIManage;
import po.BusinessVipPO;
import po.CommonVipPO;
import dataservice.vipdataservice.VipDataService;
import util.DataServiceType;
import util.ResultMsg;
import util.VipType;
import vo.CustomerInfoVO;
import vo.LevelSystemVO;

public class VipController extends BusinessController implements VipBLService{
	
	private Vip vip;
	private VipDataService vipDataService;
	
	public VipController() {
		vipDataService = (VipDataService)RMIManage.
				getDataService(DataServiceType.VipDataService);
		vip = new Vip(vipDataService);
	}

	@Override
	public int searchLevel(CustomerInfoVO user) {
		int level = 0;
		try {
			level = vip.searchLevel(user);
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return level;
	}

	@Override
	public ResultMsg registerVip(String userID,VipType type,String str) {
		ResultMsg resultMsg = ResultMsg.FAIL;
		try {
			resultMsg = vip.registerVip(userID, type, str);
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return resultMsg;
	}

	@Override
	public ResultMsg createLevelSystem(LevelSystemVO levelSystemVO) {
		ResultMsg resultMsg = ResultMsg.FAIL;
		try {
			resultMsg = vip.createLevelSystem(levelSystemVO);
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return resultMsg;
	}

	@Override
	public CommonVipPO findByUserIDC(String userID) {
		try {
			return vipDataService.findByUserIDC(userID);
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public ResultMsg updateC(CommonVipPO commonVipPO) {
		try {
			return vipDataService.updateC(commonVipPO);
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public BusinessVipPO findByUserIDB(String userID) {
		try {
			return vipDataService.findByUserIDB(userID);
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public ResultMsg updateB(BusinessVipPO businessVipPO) {
		try {
			return vipDataService.updateB(businessVipPO);
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public void reinitDataService(Remote dataService) {
		vipDataService = (VipDataService)dataService;
		vip = new Vip(vipDataService);
	}

}
