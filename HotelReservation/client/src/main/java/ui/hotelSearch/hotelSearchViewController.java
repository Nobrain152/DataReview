package ui.hotelSearch;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.TextField;
import ui.UILaunch;
import ui.UIhelper;
import util.Adress;
import util.Area;
import vo.HotelInfoVO;

public class hotelSearchViewController implements Initializable{
	private UILaunch application;
	private UIhelper helper;
	
	@FXML
	private ChoiceBox<String> cb_Address;
	
	@FXML
	private ChoiceBox<String> cb_Area;
	
	@FXML
	private TextField tf_name;
	
	@FXML
	private ChoiceBox<Integer> cb_Star;
	
	@FXML
	private ChoiceBox<String> cb_Score;
	
	@FXML
	private CheckBox cb_reserved;
	
	@FXML
	private Button btn_Cancel;
	
	@FXML
	private Button btn_Search;
	
	public void setApp(UILaunch application){
		this.application= application;
	}
	
	@FXML
	public void btn_CancelAction(ActionEvent ev) throws Exception{
		application.gotocustomerGuide();
	}
	
	@FXML
	public void btn_SearchAction(ActionEvent ev) throws Exception{
		Adress address = null;
		Area area = null;
		if(cb_Address.getValue().equals("南京")){
			address=Adress.NANJING;
		}
		else if(cb_Address.getValue().equals("北京")){
			address=Adress.BEIJING;
		}
		else if(cb_Address.getValue().equals("上海")){
			address=Adress.SHANGHAI;
		}
		else if(cb_Address.getValue().equals("无锡")){
			address=Adress.WUXI;
		}
		else if(cb_Address.getValue().equals("厦门")){
			address=Adress.XIAMEN;
		}
		if(cb_Area.getValue().equals("东区")){
			area=Area.EAST;
		}
		else if(cb_Area.getValue().equals("西区")){
			area=Area.WEST;
		}
		else if(cb_Area.getValue().equals("南区")){
			area=Area.SOUTH;
		}
		else if(cb_Area.getValue().equals("北区")){
			area=Area.NORTH;
		}
		
		HotelInfoVO hotelSearch=new HotelInfoVO(address,area);
		String scoreStr=cb_Score.getValue();
		
		if(scoreStr!=null){
			char charDown=scoreStr.charAt(0);
			double down = 0;
			double up = 0;
			switch(charDown){
			case '0':{
				down=0;
				up=3;
			}break;
			case '3':{
				down=3;
				up=6;
			}break;
			case '6':{
				down=6;
				up=8;
			}break;
			case '8':{
				down=8;
				up=10;
			}
			}
			hotelSearch.setUp(up);
			hotelSearch.setDown(down);
		}
		if(!(tf_name.getText().equals(""))){
			hotelSearch.setName(tf_name.getText());
		}
		if(cb_Star.getValue()!=null){
			hotelSearch.setLevel(cb_Star.getValue());
		}
		hotelSearch.setReserve(cb_reserved.isSelected());
		helper.setSearchHotel(hotelSearch);
		application.gotohotelSearchList();
	}

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		// TODO Auto-generated method stub
		helper=UIhelper.getInstance();
		
		
		cb_Address.setItems(FXCollections.observableArrayList("北京","上海","南京","无锡","厦门"));
		cb_Area.setItems(FXCollections.observableArrayList("东区","西区","南区","北区"));
		cb_Star.setItems(FXCollections.observableArrayList(1, 2,3,4,5));
		cb_Score.setItems(FXCollections.observableArrayList("0~3", "3~6","6~8","8~10"));
	}

}
