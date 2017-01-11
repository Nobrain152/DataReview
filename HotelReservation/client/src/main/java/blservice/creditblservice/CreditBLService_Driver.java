package blservice.creditblservice;

import util.ResultMsg;
import vo.CustomerInfoVO;

public class CreditBLService_Driver {
	
	public static void main(String[] args){
		
		CreditBLService a = new CreditBLService_Stub();
		CreditBLService_Driver b = new CreditBLService_Driver();
		b.drive(a);
	
	}
	
	public void drive(CreditBLService a){
		CustomerInfoVO client = new CustomerInfoVO("1000066", "123", "12345678910", "sfd", 0, false, null);
		int value = 100;
		ResultMsg resultMsg = a.addCredit(client, value);
		if(resultMsg == ResultMsg.SUCCESS)
			System.out.println("成功添加信用值");
		else
			System.out.println("添加信用值失败");
	}
	
}