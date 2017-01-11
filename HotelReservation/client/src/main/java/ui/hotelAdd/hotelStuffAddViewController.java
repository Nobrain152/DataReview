package ui.hotelAdd;

import java.net.URL;
import java.util.ResourceBundle;

import bl.userbl.WebManagerHotelOperationController;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;
import ui.UILaunch;
import vo.StuffInfoVO;

public class hotelStuffAddViewController implements Initializable{
	private UILaunch application;
	private WebManagerHotelOperationController addHotelStuff;
	
	@FXML
	private TextField tf_name;
	
	@FXML
	private PasswordField pf_password;
	
	@FXML
	private TextField tf_contact;
	
	@FXML
	private TextField tf_hotelID;
	
	@FXML
	private Button btn_Add;
	
	@FXML
	private Button btn_Cancel;
	
	public void setApp(UILaunch application){
		this.application= application;
	}
	
	@FXML
	private void btn_AddAction(ActionEvent event) throws Exception{
		StuffInfoVO newStuff=new StuffInfoVO(null,tf_name.getText(),tf_contact.getText(),tf_hotelID.getText(),pf_password.getText());
		String stuffID=addHotelStuff.stuffAdd(newStuff);//TODO 用对话框显示
		Alert alert=new Alert(AlertType.INFORMATION);
		alert.setTitle("提示");
		alert.setHeaderText("添加成功！");
		alert.setContentText("酒店工作人员的账户ID为： "+stuffID);
		alert.showAndWait();
		application.gotowebManagerGuide();
	}
	
	@FXML
	private void btn_CancelAction(ActionEvent event) throws Exception{
		application.gotowebManagerGuide();
	}
	

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		// TODO Auto-generated method stub
		addHotelStuff=new WebManagerHotelOperationController();
	}

}
