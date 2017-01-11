package ui.hotelAdd;

import java.net.URL;
import java.util.ResourceBundle;

import bl.userbl.StuffInfoManagementController;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import ui.UILaunch;
import ui.UIhelper;
import vo.StuffInfoVO;

public class hotelStuffInquireViewController implements Initializable{
	private UILaunch application;
	private UIhelper helper;
	private StuffInfoManagementController stuffInfo;
	
	@FXML
	private TextField tf_ID;
	
	@FXML
	private Label lb_ID;
	
	@FXML
	private Label lb_name;
	
	@FXML
	private Label lb_contact;
	
	@FXML
	private Label lb_hotelID;
	
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
		StuffInfoVO stuff=stuffInfo.individualInfolnq(tf_ID.getText());
		lb_ID.setText(stuff.getUserID());
		lb_name.setText(stuff.getUsername());
		lb_contact.setText(stuff.getContact());
		lb_hotelID.setText(stuff.getHotel());
		tf_ID.setText("");
	}

	@FXML
	private void btn_ModifyAction(ActionEvent event) throws Exception{
		if(lb_ID.getText().length()!=0){
			helper.setHotelStuffIDbyManager(lb_ID.getText());
			application.gotohotelStuffModify();
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
		stuffInfo=new StuffInfoManagementController();
	}

}
