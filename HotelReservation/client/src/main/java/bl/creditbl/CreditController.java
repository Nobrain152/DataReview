package bl.creditbl;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.ArrayList;

import bl.BusinessController;
import blservice.creditblservice.CreditBLService;
import dataservice.creditdataservice.CreditDataService;
import net.RMIManage;
import po.CreditPO;
import util.DataServiceType;
import util.ResultMsg;
import vo.CreditVO;
import vo.CustomerInfoVO;

public class CreditController extends BusinessController implements CreditBLService{

	private Credit credit;
	private CreditDataService creditDataService;
	
	public CreditController() {
		creditDataService = (CreditDataService)RMIManage.
				getDataService(DataServiceType.CreditDataService);
		credit = new Credit(creditDataService);
	}
	
	@Override
	public int getCredit(CustomerInfoVO client) {
		try {
			return credit.getCredit(client);
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return 0;
	}

	@Override
	public ResultMsg addCredit(CustomerInfoVO client, int value) {
		try {
			return credit.addCredit(client, value);
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return ResultMsg.FAIL;
	}

	@Override
	public ResultMsg subCredit(CustomerInfoVO client, int value) {
		try {
			return credit.subCredit(client, value);
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return ResultMsg.FAIL;
	}

	@Override
	public ResultMsg changeCredit(CustomerInfoVO client, int value) {
		try {
			return credit.changeCredit(client, value);
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return ResultMsg.FAIL;
	}

	@Override
	public ArrayList<CreditVO> getCreditList(String userID) {
		ArrayList<CreditVO> creditVOs = new ArrayList<>();
		try {
			creditVOs = credit.getCreditList(userID);
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return creditVOs;
	}

	@Override
	public ResultMsg insert(CreditPO creditPO) {
		try {
			return creditDataService.insert(creditPO);
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public CreditPO get(String userID) {
		try {
			ArrayList<CreditPO> arrayList = creditDataService.getListByUserID(userID);
			return arrayList.get(arrayList.size()-1);
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public ArrayList<CreditPO> getListByUserID(String userID) {
		try {
			return creditDataService.getListByUserID(userID);
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public void reinitDataService(Remote dataService) {
		creditDataService = (CreditDataService)dataService;
		credit = new Credit(creditDataService);
		
	}

}
