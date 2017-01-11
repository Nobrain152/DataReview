package ui.reservedHotel;

import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

import bl.userbl.CustomerInfoManagementController;
import javafx.beans.property.SimpleDoubleProperty;
import javafx.beans.property.SimpleIntegerProperty;
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
import vo.HotelInfoVO;

public class reservedHotelListViewController implements Initializable{
	private UILaunch application;
	private UIhelper helper;
	private CustomerInfoManagementController customerInfo;
	
	@FXML
	private TableView<hotelItem> tv_hotel;
	
	@FXML
	private TableColumn<?, ?> tc_ID;	
	@FXML
	private TableColumn<?, ?> tc_name;	
	@FXML
	private TableColumn<?, ?> tc_star;
	@FXML
	private TableColumn<?, ?> tc_score;
	@FXML
	private TableColumn<?, ?> tc_condition;
	@FXML
	private TableColumn<?, ?> tc_price;
	
	private ObservableList<hotelItem> data;
	
	@FXML
	private Button btn_Info;
	
	
	
	@FXML
	private Button btn_Cancel;
	
	public void setApp(UILaunch application){
		this.application= application;
	}
	
	@FXML
	public void btn_InfoAction(ActionEvent ev){
		hotelItem chosenItem=tv_hotel.getSelectionModel().getSelectedItem();
		String chosenHotelID=chosenItem.getID();
		helper.setHotelID(chosenHotelID);
		application.gotoreservedHotelInfo();
	}
	
	
	
	@FXML
	public void btn_CancelAction(ActionEvent ev){
		application.gotocustomerGuide();
	}

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		// TODO Auto-generated method stub
		helper=UIhelper.getInstance();
		customerInfo=new CustomerInfoManagementController();
		
		ArrayList<hotelItem> data_List=new ArrayList<hotelItem>();
		
		ArrayList<HotelInfoVO> hotel_executedList=customerInfo.finishedHotelInq(helper.getUserID());		
		int size_executed=hotel_executedList.size();
		for(int i=0;i<size_executed;i++){
			HotelInfoVO tempHotelVO=hotel_executedList.get(i);			
			data_List.add(new hotelItem(tempHotelVO.getHotelID(),tempHotelVO.getName(),tempHotelVO.getLevel(),tempHotelVO.getScore(),"正常订单",tempHotelVO.getSP()));
		}
		
		ArrayList<HotelInfoVO> hotel_waitingList=customerInfo.unfinishedHotelInq(helper.getUserID());		
		int size_waiting=hotel_waitingList.size();
		for(int i=0;i<size_waiting;i++){
			HotelInfoVO tempHotelVO=hotel_waitingList.get(i);			
			data_List.add(new hotelItem(tempHotelVO.getHotelID(),tempHotelVO.getName(),tempHotelVO.getLevel(),tempHotelVO.getScore(),"正常订单",tempHotelVO.getSP()));
		}
		
		ArrayList<HotelInfoVO> hotel_canceledList=customerInfo.cancelHotelInq(helper.getUserID());		
		int size_canceled=hotel_canceledList.size();
		for(int i=0;i<size_canceled;i++){
			HotelInfoVO tempHotelVO=hotel_canceledList.get(i);			
			data_List.add(new hotelItem(tempHotelVO.getHotelID(),tempHotelVO.getName(),tempHotelVO.getLevel(),tempHotelVO.getScore(),"撤销订单",tempHotelVO.getSP()));
		}
		
		ArrayList<HotelInfoVO> hotel_abnormalList=customerInfo.abnormalHotelInq(helper.getUserID());		
		int size_abnormal=hotel_abnormalList.size();
		for(int i=0;i<size_abnormal;i++){
			HotelInfoVO tempHotelVO=hotel_abnormalList.get(i);			
			data_List.add(new hotelItem(tempHotelVO.getHotelID(),tempHotelVO.getName(),tempHotelVO.getLevel(),tempHotelVO.getScore(),"异常订单",tempHotelVO.getSP()));
		}
		
		data = FXCollections.observableArrayList(data_List);
		tc_ID.setCellValueFactory(new PropertyValueFactory<>("ID"));
		tc_name.setCellValueFactory(new PropertyValueFactory<>("name"));
		tc_star.setCellValueFactory(new PropertyValueFactory<>("star"));
		tc_score.setCellValueFactory(new PropertyValueFactory<>("score"));
		tc_condition.setCellValueFactory(new PropertyValueFactory<>("condition"));
		tc_price.setCellValueFactory(new PropertyValueFactory<>("price"));
		tv_hotel.setItems(data);
	}
	
	public static class hotelItem{
		private SimpleStringProperty ID;
		private SimpleStringProperty name;
		private SimpleIntegerProperty star;
		private SimpleDoubleProperty score;
		private SimpleStringProperty condition;
		private SimpleIntegerProperty price;
		
		private hotelItem(String ID,String name,int star,double score,String condition,int price){
			this.ID=new SimpleStringProperty(ID);
			this.name=new SimpleStringProperty(name);
			this.star=new SimpleIntegerProperty(star);
			this.score=new SimpleDoubleProperty(score);
			this.condition=new SimpleStringProperty(condition);
			this.price=new SimpleIntegerProperty(price);
		}
		
		public String getID(){
			return ID.get();
		}
		
		public void setID(String str){
			ID.set(str);
		}
		
		public String getName(){
			return name.get();
		}
		
		public void setName(String str){
			name.set(str);
		}
		
		public int getStar(){
			return star.get();
		}
		
		public void setStar(int n){
			star.set(n);
		}
		
		public double getScore(){
			return score.get();
		}
		
		public void setScore(double n){
			score.set(n);
		}
		
		public String getCondition(){
			return condition.get();
		}
		
		public void setCondition(String str){
			condition.set(str);
		}
		
		public int getPrice(){
			return price.get();
		}
		
		public void setPrice(int n){
			price.set(n);
		}
		
		
	}


}
