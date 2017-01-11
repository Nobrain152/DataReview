package ui.orderOnUser;

import java.net.URL;
import java.util.ResourceBundle;

import bl.orderbl.OrderOnUserController;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import ui.UILaunch;
import ui.UIhelper;
import vo.OrderVO;

public class orderOnUserInfoViewController implements Initializable{
	private UILaunch application;
	private UIhelper helper;
	private OrderOnUserController orderController;
	
	@FXML
	private Label lb_ID;
	
	@FXML
	private Label lb_initiator;
	
	@FXML
	private Label lb_state;
	
	
	@FXML
	private Label lb_startTime;
	
	@FXML
	private Label lb_endTime;
	
	@FXML
	private Label lb_ddl;
	
	@FXML
	private Label lb_number;
	
	@FXML
	private Label lb_type;
	
	@FXML
	private Label lb_children;

	@FXML
	private Button btn_Cancel;
	
	@FXML
	private Button btn_home;
		
	public void setApp(UILaunch application){
		this.application= application;
	}
	
	@FXML
	public void btn_CancelAction(ActionEvent ev){
		application.gotoorderOnUser();
	}
	
	@FXML
	public void btn_homeAction(ActionEvent ev){
		application.gotocustomerGuide();
	}

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		// TODO Auto-generated method stub
		helper=UIhelper.getInstance();
		orderController=new OrderOnUserController();
		OrderVO check=orderController.personalOrderDetail(helper.getOrderID());
		lb_ID.setText(check.getOrderID());
		lb_initiator.setText(check.getInitiator().getUsername());
		lb_state.setText(check.getOrderState().toString());
		lb_startTime.setText(check.getCheckInTime());
		lb_endTime.setText(check.getCheckOutTime());
		lb_ddl.setText(check.getLatestExecutionTime());
		lb_number.setText(String.valueOf(check.getRoomNumber()));
		lb_type.setText(check.getRoomType().toString());
		lb_children.setText(String.valueOf(check.getHasChild()));
	}

}
