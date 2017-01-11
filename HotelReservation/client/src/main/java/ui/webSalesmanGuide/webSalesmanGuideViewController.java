package ui.webSalesmanGuide;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import ui.UILaunch;

public class webSalesmanGuideViewController implements Initializable{
	private UILaunch application;
	
	@FXML
	private Button btn_Order;
	
	@FXML
	private Button btn_Credit;
	
	@FXML
	private Button btn_Promotion;
	
	@FXML
	private Button btn_Cancel;
	
	public void setApp(UILaunch application){
		this.application= application;
	}
	
	@FXML
	public void btn_OrderAction(ActionEvent ev){
		application.gotoabnormalOrder();
	}
	
	@FXML
	public void btn_CreditAction(ActionEvent ev){
		application.gotocreditRecharge();
	}
	
	@FXML
	public void btn_PromotionAction(ActionEvent ev){
		application.gotopromotionWeb();
	}
	
	@FXML
	public void btn_CancelAction(ActionEvent ev){
		application.gotologin();
	}

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		// TODO Auto-generated method stub
		
	}

}
