package ui.webManagerGuide;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import ui.UILaunch;

public class webManagerGuideViewController implements Initializable{
	private UILaunch application;
	
	@FXML
	private Button btn_Cancel;
	
	@FXML
	private Button btn_Customer;
	
	@FXML
	private Button btn_Hotel;
	
	@FXML
	private Button btn_StuffAdd;
	
	@FXML
	private Button btn_StuffInquire;
	
	@FXML
	private Button btn_SalesmanAdd;
	
	@FXML
	private Button btn_SalesmanInquire;
	
	public void setApp(UILaunch application){
		this.application= application;
	}
	
	@FXML
	private void btn_CancelAction(ActionEvent event) throws Exception{
		application.gotologin();
	}
	
	@FXML
	private void btn_CustomerAction(ActionEvent event) throws Exception{
		application.gotocustomerInfoInquireByM();
	}
	
	@FXML
	private void btn_HotelAction(ActionEvent event) throws Exception{
		application.gotohotelAdd();
	}
	
	@FXML
	private void btn_StuffAddAction(ActionEvent event) throws Exception{
		application.gotohotelStuffAdd();
	}
	
	@FXML
	private void btn_StuffInquireAction(ActionEvent event) throws Exception{
		application.gotohotelStuffInquire();
	}
	
	@FXML
	private void btn_SalesmanAddAction(ActionEvent event) throws Exception{
		application.gotowebSalesmanAdd();
	}
	
	@FXML
	private void btn_SalesmanInquireAction(ActionEvent event) throws Exception{
		application.gotowebSalesmanInquire();
	}
	
	

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		// TODO Auto-generated method stub
		
	}

}
