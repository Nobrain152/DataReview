package ui.hotelAdd;

import java.net.URL;
import java.util.ResourceBundle;

import bl.userbl.WebManagerHotelOperationController;
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
import util.Adress;
import util.Area;
import vo.HotelInfoVO;

public class hotelAddViewController implements Initializable{
	private UILaunch application;
	private WebManagerHotelOperationController addHotel;
	
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
	private Button btn_Add;
	
	@FXML
	private Button btn_Cancel;
		
	public void setApp(UILaunch application){
		this.application= application;
	}
	
	@FXML
	private void btn_AddAction(ActionEvent event) throws Exception{
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
		
		HotelInfoVO newHotel=new HotelInfoVO(tf_name.getText(),address,area,cb_star.getValue(),
				ta_introduction.getText(),ta_facility.getText(),false,null,10,Integer.parseInt(tf_price.getText()));
		String ID= addHotel.hotelAdd(newHotel);//TODO 显示注册成功的ID；
		Alert alert=new Alert(AlertType.INFORMATION);
		alert.setTitle("提示");
		alert.setHeaderText("添加成功！");
		alert.setContentText("酒店ID为： "+ID);
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
		addHotel=new WebManagerHotelOperationController();
		
		cb_address.setItems(FXCollections.observableArrayList("北京","上海","南京","无锡","厦门"));
		cb_area.setItems(FXCollections.observableArrayList("东区","西区","南区","北区"));
		cb_star.setItems(FXCollections.observableArrayList(1, 2,3,4,5));
	}

}
