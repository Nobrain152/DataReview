package ui.roomAdd;

import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

import bl.userbl.HotelStuffHotelOperationController;
import bl.userbl.StuffInfoManagementController;
import javafx.beans.property.SimpleDoubleProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import ui.UILaunch;
import ui.UIhelper;
import vo.RoomInfoVO;
import vo.StuffInfoVO;

public class roomListViewController implements Initializable{
	private UILaunch application;
	private UIhelper helper;
	private HotelStuffHotelOperationController addRoom;
	private StuffInfoManagementController stuffInfoController;
	
	@FXML
	private TableView<roomItem> tv_room;
	@FXML
	private TableColumn<?, ?> tc_ID;
	@FXML
	private TableColumn<?, ?> tc_type;
	@FXML
	private TableColumn<?, ?> tc_state;
	@FXML
	private TableColumn<?, ?> tc_price;
	private ObservableList<roomItem> data;
	
	@FXML
	private Button btn_Cancel;
	
	@FXML
	private Button btn_Add;
	
	@FXML
	private Button btn_Modify;
	
	public void setApp(UILaunch application){
		this.application= application;
	}
	
	@FXML
	private void btn_CancelAction(ActionEvent event){
		application.gotohotelStuffGuide();
	}
	
	@FXML
	private void btn_AddAction(ActionEvent event){
		application.gotoroomAdd();
	}
	
	@FXML
	private void btn_ModifyAction(ActionEvent event){
		roomItem choose=tv_room.getSelectionModel().getSelectedItem();
		helper.setRoomID(choose.getID());
		application.gotoroomModify();
	}

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		// TODO Auto-generated method stub
		helper=UIhelper.getInstance();
		addRoom=new HotelStuffHotelOperationController();
		stuffInfoController=new StuffInfoManagementController();
		
		StuffInfoVO stuffVO=stuffInfoController.individualInfolnq(helper.getUserID());
		ArrayList<RoomInfoVO> room_list=addRoom.hotelRoomList(stuffVO.getHotel());
		ArrayList<roomItem> data_list=new ArrayList<roomItem>();
		int size=room_list.size();
		for(int i=0;i<size;i++){
			RoomInfoVO tempRoomVO=room_list.get(i);
			data_list.add(new roomItem(tempRoomVO.getRoomID(),tempRoomVO.getType().toString(),tempRoomVO.getState().toString(),
					tempRoomVO.getPrice()));
		}
		
		data = FXCollections.observableArrayList(data_list);
		tc_ID.setCellValueFactory(new PropertyValueFactory<>("ID"));
		tc_type.setCellValueFactory(new PropertyValueFactory<>("type"));
		tc_state.setCellValueFactory(new PropertyValueFactory<>("state"));
		tc_price.setCellValueFactory(new PropertyValueFactory<>("price"));
		tv_room.setItems(data);
	}
	
	public static class roomItem{
		private SimpleStringProperty ID;
		private SimpleStringProperty type;
		private SimpleStringProperty state;
		private SimpleDoubleProperty price;
		
		
		private roomItem(String ID,String type,String state,double price){
			this.ID=new SimpleStringProperty(ID);
			this.type=new SimpleStringProperty(type);
			this.state=new SimpleStringProperty(state);
			this.price=new SimpleDoubleProperty(price);
			
			
		}
		
		public String getID(){
			return ID.get();
		}
		
		public void setID(String str){
			ID.set(str);
		}
		
		public String getType(){
			return type.get();
		}
		
		public void setType(String str){
			type.set(str);
		}
		
		public String getState(){
			return state.get();
		}
		
		public void setState(String str){
			state.set(str);
		}
		
		public double getPrice(){
			return price.get();
		}
		
		public void setPrice(double n){
			price.set(n);
		}
		
		
	}

}
