package ui.hotelManaged;

import java.net.URL;
import java.util.ResourceBundle;

import bl.userbl.HotelStuffHotelOperationController;
import bl.userbl.StuffInfoManagementController;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import ui.UILaunch;
import ui.UIhelper;
import vo.HotelInfoVO;
import vo.StuffInfoVO;

public class hotelManagedInfoViewController implements Initializable{
	private UILaunch application;
	private UIhelper helper;
	private HotelStuffHotelOperationController hotelManage;
	private StuffInfoManagementController stuffInfo;
	
	@FXML
	private Label lb_name;
	
	@FXML
	private Label lb_star;
	
	@FXML
	private Label lb_price;
	
	@FXML
	private Label lb_score;
	
	@FXML
	private Label lb_address;
	
	@FXML
	private Label lb_area;
	
	@FXML
	private Label lb_facility;
	
	@FXML
	private Label lb_introduction;
	
	@FXML
	private Button btn_Cancel;
	
	@FXML
	private Button btn_Modify;
	
	public void setApp(UILaunch application){
		this.application= application;
	}
	
	@FXML
	public void btn_CancelAction(ActionEvent ev) throws Exception{
		application.gotohotelStuffGuide();
	}
	
	@FXML
	public void btn_ModifyAction(ActionEvent ev) throws Exception{
		application.gotohotelInfoMaintain();
	}
	

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		// TODO Auto-generated method stub
		helper=UIhelper.getInstance();
		hotelManage=new HotelStuffHotelOperationController();
		stuffInfo=new StuffInfoManagementController();
		
		//ªÒ»°æ∆µÍID
		String hotelStuffID=helper.getUserID();
		StuffInfoVO vo=stuffInfo.individualInfolnq(hotelStuffID);
		String hotelID=vo.getHotel();
		
		HotelInfoVO hotelvo=hotelManage.hotelInfoInq(hotelID);
		lb_name.setText(hotelvo.getName());
		lb_star.setText(String.valueOf(hotelvo.getLevel()));
		lb_price.setText(String.valueOf(hotelvo.getSP()));
		lb_score.setText(String.valueOf(hotelvo.getScore()));
		lb_address.setText(hotelvo.getAddress().toString());
		lb_area.setText(hotelvo.getArea().toString());
		lb_facility.setText(hotelvo.getFacility());
		lb_introduction.setText(hotelvo.getIntroduction());
	}

}
