package dataservice.creditdataservice;

import java.rmi.RemoteException;

import util.ResultMsg;

public class CreditDataService_Driver {
	
	public CreditDataService_Driver(){

	}
	
	 public void drive(CreditDataService creditDataService) throws RemoteException {
        ResultMsg resultMsg = creditDataService.insert(null);
        if(resultMsg == ResultMsg.SUCCESS)
        	System.out.println("³É¹¦");
        else
        	System.out.println("Ê§°Ü");
    }

	public static void main(String[] args) throws RemoteException {
        CreditDataService_Stub stub = new CreditDataService_Stub();
        CreditDataService_Driver driver = new CreditDataService_Driver();
        driver.drive(stub);
    }
	
	
}