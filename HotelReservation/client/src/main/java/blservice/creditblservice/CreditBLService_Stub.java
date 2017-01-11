package blservice.creditblservice;

import java.util.ArrayList;

import po.CreditPO;
import util.Action;
import util.ResultMsg;
import vo.CreditVO;
import vo.CustomerInfoVO;


public class CreditBLService_Stub implements CreditBLService{
	String credit;
	ArrayList<String> creditNote;
	public CreditBLService_Stub(){
		credit = "0";
		creditNote = new ArrayList<String>(); 
	}
	
	public CreditBLService_Stub(String integral,ArrayList<String> integralNote){
		this.credit = integral;
		this.creditNote = integralNote;
	}

	@Override
	public int getCredit(CustomerInfoVO client) {
		return 500;
	}

	@Override
	public ResultMsg addCredit(CustomerInfoVO client, int value) {
		return ResultMsg.SUCCESS;
	}

	@Override
	public ResultMsg subCredit(CustomerInfoVO client, int value) {
		return ResultMsg.SUCCESS;
	}

	@Override
	public ResultMsg changeCredit(CustomerInfoVO client, int value) {
		return ResultMsg.SUCCESS;
	}

	@Override
	public ArrayList<CreditVO> getCreditList(String userID) {
		ArrayList<CreditVO> vos = new ArrayList<CreditVO>();
		CreditVO vo = new CreditVO("10000066", "60000005", "2016-10-02 24:00", Action.Abnormal, "+100", 5000);
		vos.add(vo);
		return vos;
	}

	@Override
	public ResultMsg insert(CreditPO creditPO) {
		return ResultMsg.SUCCESS;
	}

	@Override
	public CreditPO get(String userID) {
		CreditPO po =new CreditPO("10000066", "60000005", "2016-10-02 24:00", Action.Abnormal, "+100", 5000);
		return po;
	}

	@Override
	public ArrayList<CreditPO> getListByUserID(String userID) {
		ArrayList<CreditPO> pos = new ArrayList<CreditPO>();
		CreditPO po = new CreditPO("10000066", "60000005", "2016-10-02 24:00", Action.Abnormal, "+100", 5000);
		pos.add(po);
		return pos;
	}
}