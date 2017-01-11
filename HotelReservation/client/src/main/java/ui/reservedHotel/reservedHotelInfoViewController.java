package ui.reservedHotel;

import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

import bl.hotelbl.HotelInfoCheckController;
import bl.userbl.CustomerHotelOperationController;
import javafx.beans.property.SimpleDoubleProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import ui.UILaunch;
import ui.UIhelper;
import vo.HotelInfoVO;
import vo.OrderVO;

public class reservedHotelInfoViewController implements Initializable{
	private UILaunch application;
	private UIhelper helper;
	private HotelInfoCheckController hotelInfo;
	private CustomerHotelOperationController controller;
	
	@FXML
	private Label label_hotelName;
	
	@FXML
	private Label label_price;
	
	@FXML
	private Label label_star;
	
	@FXML
	private Label label_score;
	
	@FXML
	private Label label_address;
	
	@FXML
	private Label label_area;
	
	@FXML
	private Label label_facility;
	
	@FXML
	private Label label_introduction;
	
	@FXML
	private Button btn_Evaluate;
	
	@FXML
	private Button btn_Cancel;
	
	@FXML
	private Button btn_home;
	
	@FXML
	private TableView<orderItem> order;
	@FXML
	private TableColumn<?, ?> order_ID;
	@FXML
	private TableColumn<?, ?> order_time;
	@FXML
	private TableColumn<?, ?> order_condition;
	@FXML
	private TableColumn<?, ?> order_price;
	private ObservableList<orderItem> data;
	
	public void setApp(UILaunch application){
		this.application= application;
	}
	
	@FXML
	public void btn_EvaluateAction(ActionEvent ev){
		orderItem choose=order.getSelectionModel().getSelectedItem();
		helper.setOrderID(choose.getID());
		application.gotohotelEvaluate();
	}
	
	
	
	@FXML
	public void btn_CancelAction(ActionEvent ev) {
		application.gotoreservedHotelList();
	}
	
	@FXML
	public void btn_homeAction(ActionEvent ev) {
		application.gotocustomerGuide();
	}

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		// TODO Auto-generated method stub
		helper=UIhelper.getInstance();
		hotelInfo=new HotelInfoCheckController();
		controller=new CustomerHotelOperationController();
		
		HotelInfoVO hotel=hotelInfo.checkHotelInfo(helper.getHotelID());
		label_hotelName.setText(hotel.getName());
		label_price.setText(String.valueOf(hotel.getSP()));
		label_star.setText(String.valueOf(hotel.getLevel()));
		label_score.setText(String.valueOf(hotel.getScore()));
		label_address.setText(hotel.getAddress().toString());
		label_area.setText(hotel.getArea().toString());
		label_facility.setText(hotel.getFacility());
		label_introduction.setText(hotel.getIntroduction());
		
		ArrayList<orderItem> data_List=new ArrayList<orderItem>();
		
		
		ArrayList<OrderVO> order_List=controller.getHotelOrder(hotel.getHotelID(), helper.getUserID());
		
		int size=order_List.size();
		for(int i=0;i<size;i++){
			OrderVO tempOrderVO=order_List.get(i);			
			data_List.add(new orderItem(tempOrderVO.getOrderID(),tempOrderVO.getCheckInTime(),tempOrderVO.getOrderState().toString(),tempOrderVO.getPrice()));
		}
		data = FXCollections.observableArrayList(data_List);
		order_ID.setCellValueFactory(new PropertyValueFactory<>("ID"));		
		order_time.setCellValueFactory(new PropertyValueFactory<>("time"));
		order_condition.setCellValueFactory(new PropertyValueFactory<>("condition"));
		order_price.setCellValueFactory(new PropertyValueFactory<>("price"));
		order.setItems(data);
	}
	
	public static class orderItem{
		private SimpleStringProperty ID;
		private SimpleStringProperty time;
		private SimpleStringProperty condition;
		private SimpleDoubleProperty price;
		
		private orderItem(String ID,String time,String condition,double price){
			this.ID = new SimpleStringProperty(ID);			
			this.time = new SimpleStringProperty(time);
			this.condition = new SimpleStringProperty(condition);
			this.price = new SimpleDoubleProperty(price);
		}
		
		public String getID() {
			return ID.get();
		}

		public void setID(String str) {
			ID.set(str);
		}

		

		public String getTime() {
			return time.get();
		}

		public void setTime(String str) {
			time.set(str);
		}
		
		public String getCondition() {
			return condition.get();
		}

		public void setCondition(String str) {
			condition.set(str);
		}

		public double getPrice() {
			return price.get();
		}

		public void setPrice(double n) {
			price.set(n);
		}
	}

}
