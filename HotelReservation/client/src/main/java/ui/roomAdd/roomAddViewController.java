package ui.roomAdd;

import java.net.URL;
import java.util.ResourceBundle;

import bl.userbl.HotelStuffHotelOperationController;
import bl.userbl.StuffInfoManagementController;
import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;
import ui.UILaunch;
import ui.UIhelper;
import util.ResultMsg;
import util.RoomState;
import util.RoomType;
import vo.RoomInfoVO;
import vo.StuffInfoVO;

public class roomAddViewController implements Initializable{
	private UILaunch application;
	private UIhelper helper;
	private HotelStuffHotelOperationController stuffOperation;
	private StuffInfoManagementController stuffInfoController;
	
	@FXML
	private TextField tf_roomID;
	
	@FXML
	private TextField tf_price;
	
	@FXML
	private ChoiceBox<RoomType> cb_type;
	
	@FXML
	private ChoiceBox<RoomState> cb_state;
	
	
	
	@FXML
	private Button btn_Save;
	
	@FXML
	private Button btn_Cancel;
	
	public void setApp(UILaunch application){
		this.application= application;
	}
	
	@FXML
	private void btn_SaveAction(ActionEvent event) throws Exception{
		StuffInfoVO stuffVO=stuffInfoController.individualInfolnq(helper.getUserID());
		RoomInfoVO updateRoom=new RoomInfoVO(cb_state.getValue(),cb_type.getValue(),tf_roomID.getText(),
				Double.parseDouble(tf_price.getText()),stuffVO.getHotel());
		ResultMsg msg=stuffOperation.typeInRoom(updateRoom);//TODO еп╤о
		application.gotoroomList();
	}
	
	@FXML
	private void btn_CancelAction(ActionEvent event) throws Exception{
		application.gotoroomList();
	}

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		// TODO Auto-generated method stub
		helper=UIhelper.getInstance();
		stuffOperation=new HotelStuffHotelOperationController();
		stuffInfoController=new StuffInfoManagementController();
		
		
		cb_type.setItems(FXCollections.observableArrayList(RoomType.ROOM_STANDARD,RoomType.ROOM_BIGBED,RoomType.ROOM_BUSINESS,RoomType.ROOM_PRESIDENTIAL));
		cb_state.setItems(FXCollections.observableArrayList(RoomState.USABLE,RoomState.UNUSABLE));
	}

}
