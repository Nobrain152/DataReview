package ui.webSalesman;

import java.net.URL;
import java.util.ResourceBundle;

import bl.userbl.WebInfoManagementController;
import bl.userbl.WebManagerWebsiteManagementController;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import ui.UILaunch;
import ui.UIhelper;
import util.ResultMsg;
import vo.UserInfoVO;

public class webSalesmanModifyViewController implements Initializable{
	private UILaunch application;	
	private UIhelper helper;
	private WebManagerWebsiteManagementController salesmanInfo;
	private UserInfoVO salesman;
	
	@FXML
	private Label lb_salesmanID;
	
	@FXML
	private TextField tf_name;
	
	@FXML
	private TextField tf_contact;
	
	@FXML
	private Button btn_Modify;
	
	@FXML
	private Button btn_Cancel;
	
	public void setApp(UILaunch application){
		this.application= application;
	}
	
	@FXML
	private void btn_ModifyAction(ActionEvent event){
		salesman.setUsername(tf_name.getText());
		salesman.setContact(tf_contact.getText());
		ResultMsg msg=salesmanInfo.userInfoMod(helper.getSalesmanIDbyManager(), salesman);
		//TODO еп╤о
		application.gotowebSalesmanInquire();
	}
	
	@FXML
	private void btn_CancelAction(ActionEvent event) throws Exception{
		application.gotowebSalesmanInquire();
	}


	@Override
	public void initialize(URL location, ResourceBundle resources) {
		// TODO Auto-generated method stub
		helper=UIhelper.getInstance();
		salesmanInfo=new WebManagerWebsiteManagementController();
		salesman=salesmanInfo.userInfoInq(helper.getSalesmanIDbyManager());
		lb_salesmanID.setText(salesman.getUserID());
		tf_name.setText(salesman.getUsername());
		tf_contact.setText(salesman.getContact());
	}

}
