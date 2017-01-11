package ui.customerInfo;

import java.net.URL;
import java.util.ResourceBundle;

import bl.userbl.CustomerInfoManagementController;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;
import ui.UILaunch;
import ui.UIhelper;
import util.ResultMsg;
import vo.CustomerInfoVO;

public class customerInfoModifyViewController implements Initializable{
	private UILaunch application;
	private UIhelper helper;
	private CustomerInfoManagementController customerInfo;
	private CustomerInfoVO customer;
	
	
	@FXML
	private TextField name;
	
	@FXML
	private TextField contact;
	
	@FXML
	private Button btn_Cancel;
	
	@FXML
	private Button btn_Save;
	
	public void setApp(UILaunch application){
		this.application= application;
	}
	
	@FXML
	private void btn_CancelAction(ActionEvent event){
		application.gotocustomerInfo();
	}
	
	@FXML
	private void btn_SaveAction(ActionEvent event){
		customer.setUsername(name.getText());
		customer.setContact(contact.getText());
		ResultMsg msg=customerInfo.individualInfoMod(helper.getUserID(), customer);
		if(msg==ResultMsg.SUCCESS){
			Alert alert=new Alert(AlertType.INFORMATION);
			alert.setTitle("提示");
			alert.setHeaderText(null);
			alert.setContentText("修改成功！");
			alert.showAndWait();
			application.gotocustomerInfo();
		}
		else{
			Alert alert=new Alert(AlertType.ERROR);
			alert.setTitle("错误");
			alert.setHeaderText("修改失败！");
			alert.setContentText("修改信息不符合格式");
			alert.showAndWait();
		}
		
	}
	
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		// TODO Auto-generated method stub
		helper=UIhelper.getInstance();
		customerInfo=new CustomerInfoManagementController();
		customer=customerInfo.individualInfolnq(helper.getUserID());
		name.setText(customer.getUsername());
		contact.setText(customer.getContact());
	}

}
