package ui.customerInfo;

import java.net.URL;
import java.util.ResourceBundle;

import bl.userbl.CustomerInfoManagementController;
import bl.vipbl.VipController;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import ui.UILaunch;
import ui.UIhelper;
import vo.CustomerInfoVO;

public class customerInfoViewController implements Initializable{
	private UILaunch application;
	private UIhelper helper;
	private CustomerInfoManagementController customerInfo;
	private VipController vip;
	
	@FXML
	private Label lb_name;
	
	@FXML
	private Label lb_userID;
	
	@FXML
	private Label lb_contact;
	
	@FXML
	private Label lb_credit;
	
	@FXML
	private Label lb_level;
	
	@FXML
	private Button button_Credit;
	
	@FXML
	private Button button_Modify;
	
	@FXML
	private Button button_Cancel;
	
	public void setApp(UILaunch application){
		this.application= application;
	}
	
	@FXML
	private void button_CreditAction(ActionEvent event) throws Exception{
		application.gotocreditCheck();
	}
	
	@FXML
	private void button_ModifyAction(ActionEvent event) throws Exception{
		application.gotocustomerInfoModify();
	}
	
	@FXML
	private void button_CancelAction(ActionEvent event) throws Exception{
		application.gotocustomerGuide();
	}

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		// TODO Auto-generated method stub
		helper=UIhelper.getInstance();
		customerInfo=new CustomerInfoManagementController();
		vip=new VipController();
		String ID=helper.getUserID();
		CustomerInfoVO customer =customerInfo.individualInfolnq(ID);
		lb_name.setText(customer.getUsername());
		lb_userID.setText(customer.getUserID());
		lb_contact.setText(customer.getContact());
		lb_credit.setText(String.valueOf(customer.getCredit()));
		lb_level.setText(String.valueOf(vip.searchLevel(customer)));
	}

}
