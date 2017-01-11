package ui.orderOnWeb;

import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

import bl.hotelbl.HotelInfoCheckController;
import bl.orderbl.OrderOnWebController;
import bl.userbl.WebStuffWebsiteManagementController;
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
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import ui.UILaunch;
import util.OrderState;
import util.ResultMsg;
import util.Today;
import vo.OrderVO;

public class abnormalOrderViewController implements Initializable{
	private UILaunch application;
	private WebStuffWebsiteManagementController salesmanManage;
	private HotelInfoCheckController hotelInfo;
	private OrderOnWebController orderController;
	
	@FXML
	private TableView<OrderInTable> order_waiting;	
	@FXML
	private TableColumn<?, ?> order_waiting_ID;
	@FXML
	private TableColumn<?, ?> order_waiting_userName;
	@FXML
	private TableColumn<?, ?> order_waiting_hotelName;
	@FXML
	private TableColumn<?, ?> order_waiting_time;
	@FXML
	private TableColumn<?, ?> order_waiting_price;
	private ObservableList<OrderInTable> data_waiting;
	@FXML
	private Button btn_waiting_info;
	
	@FXML
	private TableView<OrderInTable> order_abnormal;	
	@FXML
	private TableColumn<?, ?> order_abnormal_ID;
	@FXML
	private TableColumn<?, ?> order_abnormal_userName;
	@FXML
	private TableColumn<?, ?> order_abnormal_hotelName;
	@FXML
	private TableColumn<?, ?> order_abnormal_time;
	@FXML
	private TableColumn<?, ?> order_abnormal_price;
	private ObservableList<OrderInTable> data_abnormal;
	@FXML
	private Button btn_abnormal_info;
	
	@FXML
	private ChoiceBox<String> cb_Recover;
	
	@FXML
	private Button btn_SetCanceled;
	
	@FXML
	private Button btn_Cancel;
	
	public void setApp(UILaunch application){
		this.application= application;
	}
	
	@FXML
	public void btn_waiting_infoAction(ActionEvent ev){
		application.gotoabnormalOrderInfo();
	}
	
	@FXML
	public void btn_abnormal_infoAction(ActionEvent ev){
		application.gotoabnormalOrderInfo();
	}
	
	@FXML
	public void btn_SetCanceledAction(ActionEvent ev){
		OrderInTable choose=order_abnormal.getSelectionModel().getSelectedItem();
		String recoverStr=cb_Recover.getValue();
		boolean recover=false;
		if(recoverStr.equals("恢复全部信用")){
			recover=true;
		}
		else if(recoverStr.equals("恢复一半信用")){
			recover=false;
		}
		ResultMsg msg=orderController.abnormalOrderCancel(choose.getID(),recover);
		if(msg==ResultMsg.SUCCESS){
			data_abnormal.remove(choose);
			Alert alert=new Alert(AlertType.INFORMATION);
			alert.setTitle("提示");
			alert.setHeaderText(null);
			alert.setContentText("操作成功！");
			alert.showAndWait();
		}
	}
	
	@FXML
	public void btn_CancelAction(ActionEvent ev){
		application.gotowebSalesmanGuide();
	}

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		// TODO Auto-generated method stub
		salesmanManage=new WebStuffWebsiteManagementController();
		hotelInfo=new HotelInfoCheckController();
		Today date=new Today();
		String today=date.getToday().substring(0,10);
		orderController=new OrderOnWebController();
		
		
		ArrayList<OrderVO> order_waitingList=salesmanManage.dayUnexOrder(today);
		ArrayList<OrderInTable> data_waitingList=new ArrayList<OrderInTable>();
		int size_waiting=order_waitingList.size();
		for(int i=0;i<size_waiting;i++){
			OrderVO tempOrderVO=order_waitingList.get(i);
			String hotelName=hotelInfo.checkHotelInfo(tempOrderVO.getHotelID()).getName();//TODO 可优化
			data_waitingList.add(new OrderInTable(tempOrderVO.getOrderID(),tempOrderVO.getInitiator().getUsername(),hotelName,tempOrderVO.getCheckInTime(),tempOrderVO.getPrice()));
		}		
		data_waiting=FXCollections.observableArrayList(data_waitingList);
		order_waiting_ID.setCellValueFactory(new PropertyValueFactory<>("ID"));
		order_waiting_userName.setCellValueFactory(new PropertyValueFactory<>("userName"));
		order_waiting_hotelName.setCellValueFactory(new PropertyValueFactory<>("hotelName"));
		order_waiting_time.setCellValueFactory(new PropertyValueFactory<>("time"));
		order_waiting_price.setCellValueFactory(new PropertyValueFactory<>("price"));
		order_waiting.setItems(data_waiting);
		
		ArrayList<OrderVO> order_abnormalList=salesmanManage.abnormalOrderScan();
		ArrayList<OrderInTable> data_abnormalList=new ArrayList<OrderInTable>();
		int size_abnormal=order_waitingList.size();
		for(int i=0;i<size_abnormal;i++){
			OrderVO tempOrderVO=order_abnormalList.get(i);
			String hotelName=hotelInfo.checkHotelInfo(tempOrderVO.getHotelID()).getName();//TODO 可优化
			data_abnormalList.add(new OrderInTable(tempOrderVO.getOrderID(),tempOrderVO.getInitiator().getUsername(),hotelName,tempOrderVO.getCheckInTime(),tempOrderVO.getPrice()));
		}		
		data_abnormal=FXCollections.observableArrayList(data_abnormalList);
		order_abnormal_ID.setCellValueFactory(new PropertyValueFactory<>("ID"));
		order_abnormal_userName.setCellValueFactory(new PropertyValueFactory<>("userName"));
		order_abnormal_hotelName.setCellValueFactory(new PropertyValueFactory<>("hotelName"));
		order_abnormal_time.setCellValueFactory(new PropertyValueFactory<>("time"));
		order_abnormal_price.setCellValueFactory(new PropertyValueFactory<>("price"));
		order_abnormal.setItems(data_abnormal);
		
		cb_Recover.setItems(FXCollections.observableArrayList("恢复全部信用","恢复一半信用"));
	}
	
public static class OrderInTable {
		
		private SimpleStringProperty ID;
		private SimpleStringProperty userName;
		private SimpleStringProperty hotelName;
		private SimpleStringProperty time;
		private SimpleDoubleProperty price;
		
		private OrderInTable(String ID,String userName,String hotelName,String time,double price){
			this.ID=new SimpleStringProperty(ID);
			this.userName=new SimpleStringProperty(userName);
			this.hotelName=new SimpleStringProperty(hotelName);
			this.time=new SimpleStringProperty(time);
			this.price=new SimpleDoubleProperty(price);
		}
		
		public String getID(){
			return ID.get();
		}
		
		public void setID(String str){
			ID.set(str);
		}
		
		public String getUserName() {
			return userName.get();
		}

		public void setUserName(String str) {
			userName.set(str);
		}

		public String getHotelName() {
			return hotelName.get();
		}

		public void setHotelName(String str) {
			hotelName.set(str);
		}

		public String getTime() {
			return time.get();
		}

		public void setTime(String str) {
			time.set(str);
		}

		public double getPrice() {
			return price.get();
		}

		public void setPrice(double n) {
			price.set(n);
		}
	}

}
