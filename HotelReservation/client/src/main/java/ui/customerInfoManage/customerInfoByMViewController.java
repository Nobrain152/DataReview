package ui.customerInfoManage;

import java.net.URL;
import java.util.ResourceBundle;

import bl.userbl.CustomerInfoManagementController;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import ui.UILaunch;
import ui.UIhelper;
import vo.CustomerInfoVO;

public class customerInfoByMViewController implements Initializable{
	private UILaunch application;
	private UIhelper helper;
	private CustomerInfoManagementController customerInfo;
	
	@FXML
	private Label lb_ID;
	
	@FXML
	private Label lb_name;
	
	@FXML
	private Label lb_contact;
	
	@FXML
	private Label lb_credit;
	
	@FXML
	private Button btn_Cancel;
	
	@FXML
	private Button btn_Modify;
	
	@FXML
	private Button btn_home;
	
	public void setApp(UILaunch application){
		this.application= application;
	}

	@FXML
	private void btn_CancelAction(ActionEvent event) throws Exception{
		application.gotocustomerInfoInquireByM();
	}
	
	@FXML
	private void btn_ModifyAction(ActionEvent event) throws Exception{
		application.gotocustomerInfoModifyByM();
	}
	
	@FXML
	private void btn_homeAction(ActionEvent event) throws Exception{
		application.gotowebManagerGuide();
	}
	
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		// TODO Auto-generated method stub
		helper=UIhelper.getInstance();
		customerInfo=new CustomerInfoManagementController();
		String customerID=helper.getCustomerIDbyManager();
		CustomerInfoVO customer =customerInfo.individualInfolnq(customerID);
		lb_ID.setText(customer.getUserID());
		lb_name.setText(customer.getUsername());		
		lb_contact.setText(customer.getContact());
		lb_credit.setText(String.valueOf(customer.getCredit()));
	}

}
