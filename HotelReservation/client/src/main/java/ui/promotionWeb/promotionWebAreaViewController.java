package ui.promotionWeb;

import java.net.URL;
import java.util.ResourceBundle;

import bl.userbl.WebStuffWebsiteManagementController;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import ui.UILaunch;
import ui.UIhelper;
import util.ResultMsg;
import vo.PromotionWebVO;

public class promotionWebAreaViewController implements Initializable{
	private UILaunch application;
	private UIhelper helper;
	private WebStuffWebsiteManagementController controller;
	private PromotionWebVO toModify;
	
	@FXML
	private Label lb_name;
	
	@FXML
	private TextField tf_discount;
	
	@FXML
	private Button btn_Modify;
	
	@FXML
	private Button btn_Cancel;

	public void setApp(UILaunch application) {
		this.application = application;
	}
	
	@FXML
	public void btn_ModifyAction(ActionEvent ev) {
		
		toModify.setRatio(Double.parseDouble(tf_discount.getText()));
		
		ResultMsg msg=controller.websiteStrategeMod(toModify);
		if(msg==ResultMsg.SUCCESS){
			application.gotopromotionWeb();
		}
		else{
			System.out.println("Ê§°Ü");
		}
	}

	@FXML
	public void btn_CancelAction(ActionEvent ev) {
		application.gotopromotionWeb();
	}

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		// TODO Auto-generated method stub
		helper=UIhelper.getInstance();
		controller=new WebStuffWebsiteManagementController();
		toModify=helper.getPromotionWeb();
		lb_name.setText(toModify.getLocation().toString());	
		tf_discount.setText(String.valueOf(toModify.getRatio()));
	}

}
