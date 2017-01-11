package ui.hotelManaged;

import java.net.URL;
import java.util.ResourceBundle;

import bl.userbl.HotelStuffHotelOperationController;
import bl.userbl.StuffInfoManagementController;
import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;
import ui.UILaunch;
import ui.UIhelper;
import util.Adress;
import util.Area;
import util.ResultMsg;
import vo.HotelInfoVO;
import vo.StuffInfoVO;

public class hotelInfoMaintainViewController implements Initializable{
	private UILaunch application;
	private UIhelper helper;
	private HotelStuffHotelOperationController hotelManage;
	private StuffInfoManagementController stuffInfo;
	private HotelInfoVO hotelvo;
	
	@FXML
	private TextField tf_name;
	
	@FXML
	private ChoiceBox<Integer> cb_star;
	
	@FXML
	private TextField tf_price;
	
	@FXML
	private ChoiceBox<String> cb_address;
	
	@FXML
	private ChoiceBox<String> cb_area;
	
	@FXML
	private TextArea ta_facility;
	
	@FXML
	private TextArea ta_introduction;
	
	@FXML
	private Button btn_Cancel;
	
	@FXML
	private Button btn_Save;
	
	@FXML
	private Button btn_home;
	
	public void setApp(UILaunch application){
		this.application= application;
	}
	
	@FXML
	public void btn_CancelAction(ActionEvent ev) throws Exception{
		application.gotohotelManagedInfo();
	}
	
	@FXML
	public void btn_homeAction(ActionEvent ev) throws Exception{
		application.gotohotelStuffGuide();
	}
	
	
	@FXML
	public void btn_SaveAction(ActionEvent ev) throws Exception{
		Adress address = null;
		Area area = null;
		if(cb_address.getValue().equals("南京")){
			address=Adress.NANJING;
		}
		else if(cb_address.getValue().equals("北京")){
			address=Adress.BEIJING;
		}
		else if(cb_address.getValue().equals("上海")){
			address=Adress.SHANGHAI;
		}
		else if(cb_address.getValue().equals("无锡")){
			address=Adress.WUXI;
		}
		else if(cb_address.getValue().equals("厦门")){
			address=Adress.XIAMEN;
		}
		if(cb_area.getValue().equals("东区")){
			area=Area.EAST;
		}
		else if(cb_area.getValue().equals("西区")){
			area=Area.WEST;
		}
		else if(cb_area.getValue().equals("南区")){
			area=Area.SOUTH;
		}
		else if(cb_area.getValue().equals("北区")){
			area=Area.NORTH;
		}
		HotelInfoVO hotelToSave=new HotelInfoVO(tf_name.getText(),address,area,cb_star.getValue(),
				ta_introduction.getText(),ta_facility.getText(),hotelvo.getIsReserved(),hotelvo.getHotelID(),
				hotelvo.getScore(),Integer.parseInt(tf_price.getText()));
		ResultMsg msg=hotelManage.hotelInfoMod(hotelToSave, helper.getUserID());
		Alert alert=new Alert(AlertType.INFORMATION);
		alert.setTitle("提示");
		alert.setHeaderText(null);
		alert.setContentText("修改成功");
		alert.showAndWait();
		application.gotohotelManagedInfo();
	}
	

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		// TODO Auto-generated method stub
		helper=UIhelper.getInstance();
		hotelManage=new HotelStuffHotelOperationController();
		stuffInfo=new StuffInfoManagementController();
		
		//获取酒店ID
		String hotelStuffID=helper.getUserID();
		StuffInfoVO vo=stuffInfo.individualInfolnq(hotelStuffID);
		String hotelID=vo.getHotel();
		hotelvo=hotelManage.hotelInfoInq(hotelID);
		
		tf_name.setText(hotelvo.getName());
		tf_price.setText(String.valueOf(hotelvo.getSP()));
		ta_facility.setText(hotelvo.getFacility());
		ta_introduction.setText(hotelvo.getIntroduction());
		cb_star.setItems(FXCollections.observableArrayList(1,2,3,4,5));
		cb_address.setItems(FXCollections.observableArrayList("南京","北京","上海","无锡","厦门"));
		cb_area.setItems(FXCollections.observableArrayList("东区","西区","南区","北区"));
		
		
	}

}
