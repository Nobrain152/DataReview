package ui.customerInfoManage;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import ui.UILaunch;
import ui.UIhelper;

public class customerInfoInquireByMViewController implements Initializable{
	private UILaunch application;
	private UIhelper helper;
	
	@FXML
	private Button btn_Cancel;
	
	@FXML
	private Button btn_Inquire;
	
	@FXML 
	private TextField tf_ID;
	
	public void setApp(UILaunch application){
		this.application= application;
	}
	
	@FXML
	private void btn_CancelAction(ActionEvent event) throws Exception{
		application.gotowebManagerGuide();
	}
	
	@FXML
	private void btn_InquireAction(ActionEvent event) throws Exception{
		//TODO 判断是否有这个用户
		helper.setCustomerIDbyManager(tf_ID.getText());
		application.gotocustomerInfoByM();
		
	}

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		// TODO Auto-generated method stub
		helper=UIhelper.getInstance();
		
	}

}
