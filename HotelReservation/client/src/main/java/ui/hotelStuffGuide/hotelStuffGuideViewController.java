package ui.hotelStuffGuide;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import ui.UILaunch;

public class hotelStuffGuideViewController implements Initializable{
	private UILaunch application;
	
	@FXML
	private Button btn_Cancel;
	
	@FXML
	private Button btn_Order;
	
	@FXML
	private Button btn_Room;
	
	@FXML
	private Button btn_Hotel;
	
	@FXML
	private Button btn_Promotion;
	
	public void setApp(UILaunch application){
		this.application= application;
	}
	
	@FXML
	private void btn_CancelAction(ActionEvent event) throws Exception{
		application.gotologin();
	}
	
	@FXML
	private void btn_OrderAction(ActionEvent event) throws Exception{
		application.gotoorderOnHotel();
	}
	
	@FXML
	private void btn_RoomAction(ActionEvent event) throws Exception{
		application.gotoroomList();
	}
	
	@FXML
	private void btn_HotelAction(ActionEvent event) throws Exception{
		application.gotohotelManagedInfo();
	}
	
	@FXML
	private void btn_PromotionAction(ActionEvent event) throws Exception{
		application.gotopromotionHotel();
	}

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		// TODO Auto-generated method stub
		
	}

}
