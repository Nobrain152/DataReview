package ui.promotionHotel;

import java.net.URL;
import java.util.ResourceBundle;

import bl.userbl.HotelStuffHotelOperationController;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import ui.UILaunch;
import ui.UIhelper;
import vo.PromotionHotelVO;

public class promotionHotelDIYViewController implements Initializable{
	
	private UILaunch application;
	private UIhelper helper;
	private HotelStuffHotelOperationController controller;
	private PromotionHotelVO toModify;
	
	@FXML
	private Label lb_start;
	
	@FXML
	private Label lb_end;
	
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
		
		controller.hotelStrategeManage(toModify);
		
		application.gotopromotionHotel();
		
	}

	@FXML
	public void btn_CancelAction(ActionEvent ev) {
		application.gotopromotionHotel();
	}

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		// TODO Auto-generated method stub
		helper=UIhelper.getInstance();
		controller=new HotelStuffHotelOperationController();
		toModify=helper.getPromotionHotel();
		lb_start.setText(toModify.getTimeBegin());
		lb_end.setText(toModify.getTimeOver());
		tf_discount.setText(String.valueOf(toModify.getRatio()));
	}

}
