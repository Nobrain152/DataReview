package ui.hotelSearch;

import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

import bl.userbl.CustomerHotelOperationController;
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

public class hotelSearchListViewController implements Initializable{
	private UILaunch application;
	private UIhelper helper;
	private CustomerHotelOperationController customerOperation;
	
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
	private TableColumn<?, ?> tc_isReserved;
	@FXML
	private TableColumn<?, ?> tc_price;
	
	private ObservableList<hotelItem> data;
	
	@FXML
	private Button btn_Info;
	
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
	public void btn_InfoAction(ActionEvent ev){
		hotelItem select=tv_hotel.getSelectionModel().getSelectedItem();
		helper.setHotelID(select.getID());
		application.gotohotelInfoSearched();
	}
	
	@FXML
	public void btn_ReserveAction(ActionEvent ev){
		hotelItem select=tv_hotel.getSelectionModel().getSelectedItem();
		helper.setHotelID(select.getID());
		application.gotohotelReserve();
	}
	
	@FXML
	public void btn_CancelAction(ActionEvent ev) {
		application.gotohotelSearch();
	}
	
	@FXML
	public void btn_homeAction(ActionEvent ev) {
		application.gotocustomerGuide();
	}
	
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		// TODO Auto-generated method stub
		helper=UIhelper.getInstance();
		customerOperation=new CustomerHotelOperationController();
		
		HotelInfoVO hotelCondition=helper.getSearchHotel();
		ArrayList<HotelInfoVO> hotelList=new ArrayList<HotelInfoVO>();
		hotelList=customerOperation.hotelSearch(null, hotelCondition,helper.getUserID());
		ArrayList<hotelItem> data_list=new ArrayList<hotelItem>();
		int size=hotelList.size();
		for(int i=0;i<size;i++){
			HotelInfoVO tempHotelVO=hotelList.get(i);
			String isReserve=null;
			if(tempHotelVO.getIsReserved()){
				isReserve="预定过";
			}else{
				isReserve="未预定过";
			}
			data_list.add(new hotelItem(tempHotelVO.getHotelID(),tempHotelVO.getName(),tempHotelVO.getLevel(),tempHotelVO.getScore(),isReserve,tempHotelVO.getSP()));
		}		
		data = FXCollections.observableArrayList(data_list);
		tc_ID.setCellValueFactory(new PropertyValueFactory<>("ID"));
		tc_name.setCellValueFactory(new PropertyValueFactory<>("name"));
		tc_star.setCellValueFactory(new PropertyValueFactory<>("star"));
		tc_score.setCellValueFactory(new PropertyValueFactory<>("score"));
		tc_isReserved.setCellValueFactory(new PropertyValueFactory<>("isReserved"));
		tc_price.setCellValueFactory(new PropertyValueFactory<>("price"));
		tv_hotel.setItems(data);
	}
	
	
	public static class hotelItem{
		private SimpleStringProperty ID;
		private SimpleStringProperty name;
		private SimpleIntegerProperty star;
		private SimpleDoubleProperty score;
		private SimpleStringProperty isReserved;
		private SimpleIntegerProperty price;
		
		
		private hotelItem(String ID,String name,int star,double score,String isReserved,int price){
			this.ID=new SimpleStringProperty(ID);
			this.name=new SimpleStringProperty(name);
			this.star=new SimpleIntegerProperty(star);
			this.score=new SimpleDoubleProperty(score);
			this.isReserved=new SimpleStringProperty(isReserved);
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
		
		public String getIsReserved(){
			return isReserved.get();
		}
		
		public void setIsReserved(String str){
			isReserved.set(str);
		}
		
		public int getPrice(){
			return price.get();
		}
		
		public void setPrice(int n){
			price.set(n);
		}
		
		
	}

}
