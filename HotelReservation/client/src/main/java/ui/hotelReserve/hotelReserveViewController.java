package ui.hotelReserve;

import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

import bl.hotelbl.RoomAddController;
import bl.orderbl.OrderOnUserController;
import javafx.beans.property.SimpleDoubleProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import ui.UILaunch;
import ui.UIhelper;
import util.OrderState;
import util.RoomType;
import vo.CustomerInfoVO;
import vo.OrderVO;
import vo.RoomInfoVO;

public class hotelReserveViewController implements Initializable{
	private UILaunch application;
	private UIhelper helper;
	private RoomAddController roomController;
	private OrderOnUserController orderController;
	
	@FXML
	private ChoiceBox<RoomType> cb_room;
	
	@FXML
	private TextField tf_roomNumber;
	
	@FXML
	private TextField tf_peopleNumber;
	
	@FXML
	private DatePicker dp_start;
	
	@FXML
	private DatePicker dp_end;
	
	@FXML
	private CheckBox cb_children;
	
	
	@FXML
	private TableView<roomItem> tv_room;
	@FXML
	private TableColumn<?, ?> tc_ID;
	@FXML
	private TableColumn<?, ?> tc_type;
	@FXML
	private TableColumn<?, ?> tc_price;
	private ObservableList<roomItem> data;
	
	@FXML
	private Button btn_Reserve;
	
	@FXML
	private Button btn_Cancel;
	
	@FXML
	private Button btn_home;
	
	public void setApp(UILaunch application){
		this.application= application;
	}
	
	@FXML
	public void btn_ReserveAction(ActionEvent event){
		CustomerInfoVO tempCustomer=new CustomerInfoVO();
		tempCustomer.setUserid(helper.getUserID());
		ArrayList<RoomInfoVO> typeRoom=roomController.getTypeRoom(helper.getHotelID(), cb_room.getValue());
		RoomInfoVO tempRoom=typeRoom.get(0);
		int roomNumber=Integer.parseInt(tf_roomNumber.getText());
		double price=tempRoom.getPrice()*roomNumber;
		OrderVO newOrder=new OrderVO(null,tempCustomer,OrderState.UNEXECUTED,price,helper.getHotelID(),
				cb_children.isSelected(),null,dp_start.getValue().toString(),dp_end.getValue().toString(),
				null,Integer.parseInt(tf_roomNumber.getText()),
				null,Integer.parseInt(tf_peopleNumber.getText()),cb_room.getValue());
		String result=orderController.createOrder(newOrder);
		if(result==null){
			Alert alert = new Alert(AlertType.ERROR);
			alert.setTitle("错误");
			alert.setHeaderText("预定失败");
			alert.setContentText("信用值过低，无法进行预定");
			alert.showAndWait();
		}
		else{
			String tempStr[]=result.split(";");
			Alert alert = new Alert(AlertType.INFORMATION);
			alert.setTitle("提示");
			alert.setHeaderText("预定成功");
			alert.setContentText("订单价格： "+tempStr[0]+"\n"+"所用促销策略： "+tempStr[1]);
			alert.showAndWait();
			application.gotocustomerGuide();
		}
		
	}
	
	@FXML
	public void btn_CancelAction(ActionEvent event){
		application.gotohotelSearchList();
	}
	
	@FXML
	public void btn_homeAction(ActionEvent event){
		application.gotocustomerGuide();
	}
	

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		helper=UIhelper.getInstance();
		roomController=new RoomAddController();
		orderController=new OrderOnUserController();
		ArrayList<RoomInfoVO> room_list=roomController.getEmptyRoom(helper.getHotelID());
		ArrayList<roomItem> data_list=new ArrayList<roomItem>();
		int size=room_list.size();
		for(int i=0;i<size;i++){
			RoomInfoVO tempRoomVO=room_list.get(i);
			data_list.add(new roomItem(tempRoomVO.getRoomID(),tempRoomVO.getType().toString(),tempRoomVO.getPrice()));
		}
		
		data = FXCollections.observableArrayList(data_list);
		tc_ID.setCellValueFactory(new PropertyValueFactory<>("ID"));
		tc_type.setCellValueFactory(new PropertyValueFactory<>("type"));
		tc_price.setCellValueFactory(new PropertyValueFactory<>("price"));
		tv_room.setItems(data);
		
		cb_room.setItems(FXCollections.observableArrayList(RoomType.ROOM_STANDARD,RoomType.ROOM_BIGBED,RoomType.ROOM_BUSINESS,RoomType.ROOM_PRESIDENTIAL));
	}
	
	
	public static class roomItem{
		private SimpleStringProperty ID;
		private SimpleStringProperty type;
		private SimpleDoubleProperty price;
		
		
		private roomItem(String ID,String type,double price){
			this.ID=new SimpleStringProperty(ID);
			this.type=new SimpleStringProperty(type);
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
		
		public double getPrice(){
			return price.get();
		}
		
		public void setPrice(double n){
			price.set(n);
		}
		
		
	}


}
