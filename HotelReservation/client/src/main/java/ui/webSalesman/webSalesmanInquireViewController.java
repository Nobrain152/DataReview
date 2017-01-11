package ui.webSalesman;

import java.net.URL;
import java.util.ResourceBundle;

import bl.userbl.WebInfoManagementController;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import ui.UILaunch;
import ui.UIhelper;
import vo.UserInfoVO;

public class webSalesmanInquireViewController implements Initializable{
	private UILaunch application;
	private UIhelper helper;
	private WebInfoManagementController salesmanInfo;
	
	@FXML
	private TextField tf_ID;
	
	@FXML
	private Label lb_ID;
	
	@FXML
	private Label lb_name;
	
	@FXML
	private Label lb_contact;
	
	@FXML
	private Button btn_Search;
	
	@FXML
	private Button btn_Modify;
	
	@FXML
	private Button btn_Cancel;
	
	
	
	public void setApp(UILaunch application){
		this.application= application;
	}
	
	@FXML
	private void btn_SearchAction(ActionEvent event) throws Exception{
		UserInfoVO salesman=salesmanInfo.individualInfolnq(tf_ID.getText());
		lb_ID.setText(salesman.getUserID());
		lb_name.setText(salesman.getUsername());
		lb_contact.setText(salesman.getContact());
		tf_ID.setText("");
	}
	
	@FXML
	private void btn_ModifyAction(ActionEvent event) throws Exception{
		if(lb_ID.getText().length()!=0){
			helper.setSalesmanIDbyManager(lb_ID.getText());
			application.gotowebSalesmanModify();
		}else{
			//TODO ±¨´í
		}
		
	}
	
	@FXML
	private void btn_CancelAction(ActionEvent event) throws Exception{
		application.gotowebManagerGuide();
	}
	
	


	@Override
	public void initialize(URL location, ResourceBundle resources) {
		// TODO Auto-generated method stub
		helper=UIhelper.getInstance();
		salesmanInfo=new WebInfoManagementController();
	}

}
