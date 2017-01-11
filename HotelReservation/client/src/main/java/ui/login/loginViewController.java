package ui.login;

import java.net.URL;
import java.util.ResourceBundle;

import bl.userbl.LoginInputController;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import ui.UILaunch;
import ui.UIhelper;
import util.UserType;

public class loginViewController implements Initializable{
	private UILaunch application;
	private UIhelper helper;
	
	
	
	private LoginInputController login;
	
	@FXML
	private TextField userid;
	
	@FXML
	private PasswordField password;
	
	@FXML
	private Button btn_login;
	
	@FXML
	private Button btn_register;
	

	
	
	
	public void setApp(UILaunch application){
		this.application= application;		
		
	}
	
	@FXML
	public void btn_loginAction(ActionEvent event){
		
		String id=userid.getText();
		String key=password.getText();
		if(login.LogIn(id, key)){
			helper.setUserID(id);
			UserType type=login.getType(id);
			switch(type){
			case Customer:    application.gotocustomerGuide();break;
			case HotelStuff:  application.gotohotelStuffGuide();break;
			case WebStuff:    application.gotowebSalesmanGuide();break;
			case WebManager:  application.gotowebManagerGuide();
			}
		}else{
			Alert alert=new Alert(AlertType.ERROR);
			alert.setTitle("¥ÌŒÛ");
			alert.setHeaderText(null);
			alert.setContentText("’ÀªßªÚ√‹¬Î¥ÌŒÛ");
			alert.showAndWait();
		}
		
		
	}
	
	@FXML
	public void btn_registerAction(ActionEvent event){
		
		application.gotoregister();
	}

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		// TODO Auto-generated method stub
		helper=UIhelper.getInstance();		
		login=new LoginInputController();
	

	}

}
