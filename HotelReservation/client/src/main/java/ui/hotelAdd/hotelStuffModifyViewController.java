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
import util.ResultMsg;
import vo.StuffInfoVO;

public class hotelStuffModifyViewController implements Initializable{
	private UILaunch application;
	private UIhelper helper;
	private StuffInfoManagementController stuffInfo;
	private StuffInfoVO stuff;
	
	@FXML
	private Label lb_stuffID;
	
	@FXML
	private Label lb_hotelID;
	
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
		stuff.setUsername(tf_name.getText());
		stuff.setContact(tf_contact.getText());
		ResultMsg msg=stuffInfo.individualInfoMod(helper.getHotelStuffIDbyManager(), stuff);
		//TODO еп╤о
		application.gotohotelStuffInquire();
	}
	
	@FXML
	private void btn_CancelAction(ActionEvent event){
		application.gotohotelStuffInquire();
	}

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		// TODO Auto-generated method stub
		helper=UIhelper.getInstance();
		stuffInfo=new StuffInfoManagementController();
		stuff=stuffInfo.individualInfolnq(helper.getHotelStuffIDbyManager());
		lb_stuffID.setText(stuff.getUserID());
		lb_hotelID.setText(stuff.getHotel());
		tf_name.setText(stuff.getUsername());
		tf_contact.setText(stuff.getContact());
	}

}
