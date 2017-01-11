package dataservice.orderdataservice;

import java.rmi.RemoteException;

import util.ResultMsg;

/*
 * Created by txin15 on 16/10/15.
 */
public class OrderDataService_Driver {

    public static void main(String[] args) {
        OrderDataService_Stub stub = new OrderDataService_Stub();
        OrderDataService_Driver driver = new OrderDataService_Driver();
        driver.drive(stub);
    }

	private void drive(OrderDataService_Stub stub) {
		ResultMsg resultMsg = ResultMsg.FAIL;
		try {
			resultMsg = stub.delete("");
		} catch (RemoteException e) {
			e.printStackTrace();
		}
		if(resultMsg == ResultMsg.SUCCESS)
			System.out.println("³É¹¦");
		else
			System.out.println("Ê§°Ü");
	}
}
