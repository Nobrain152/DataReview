package ui.orderOnUser;

import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

import bl.hotelbl.HotelInfoCheckController;
import bl.orderbl.OrderOnUserController;
import bl.userbl.CustomerInfoManagementController;
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
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import ui.UILaunch;
import ui.UIhelper;
import util.OrderState;
import util.ResultMsg;
import vo.OrderVO;

public class orderOnUserViewController implements Initializable{
	private UILaunch application;
	private UIhelper helper;
	private CustomerInfoManagementController orderManage;
	private HotelInfoCheckController hotelInfo;
	private OrderOnUserController orderController;
	
	//全部订单
	@FXML
	private TableView<OrderInTable> order_all;	
	@FXML
	private TableColumn<?, ?> order_all_ID;
	@FXML
	private TableColumn<?, ?> order_all_hotelName;
	@FXML
	private TableColumn<?, ?> order_all_time;
	@FXML
	private TableColumn<?, ?> order_all_price;
	private ObservableList<OrderInTable> data_all;
	@FXML
	private Button btn_all_info;
	
	//已执行订单
	@FXML
	private TableView<OrderInTable> order_executed;	
	@FXML
	private TableColumn<?, ?> order_executed_ID;
	@FXML
	private TableColumn<?, ?> order_executed_hotelName;
	@FXML
	private TableColumn<?, ?> order_executed_time;
	@FXML
	private TableColumn<?, ?> order_executed_price;
	private ObservableList<OrderInTable> data_executed;
	@FXML
	private Button btn_executed_info;
	
	//未执行订单
	@FXML
	private TableView<OrderInTable> order_waiting;	
	@FXML
	private TableColumn<?, ?> order_waiting_ID;
	@FXML
	private TableColumn<?, ?> order_waiting_hotelName;
	@FXML
	private TableColumn<?, ?> order_waiting_time;
	@FXML
	private TableColumn<?, ?> order_waiting_price;
	private ObservableList<OrderInTable> data_waiting;
	@FXML
	private Button btn_waiting_info;
	
	//已撤销订单
	@FXML
	private TableView<OrderInTable> order_canceled;	
	@FXML
	private TableColumn<?, ?> order_canceled_ID;
	@FXML
	private TableColumn<?, ?> order_canceled_hotelName;
	@FXML
	private TableColumn<?, ?> order_canceled_time;
	@FXML
	private TableColumn<?, ?> order_canceled_price;
	private ObservableList<OrderInTable> data_canceled;
	@FXML
	private Button btn_canceled_info;
	
	//异常订单
	@FXML
	private TableView<OrderInTable> order_abnormal;	
	@FXML
	private TableColumn<?, ?> order_abnormal_ID;
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
	private Button btn_SetCanceled;
	
	
	@FXML
	private Button btn_Cancel;
	
	public void setApp(UILaunch application){
		this.application= application;
	}
	
	@FXML
	public void btn_all_infoAction(ActionEvent ev) throws Exception {
		OrderInTable choose=order_all.getSelectionModel().getSelectedItem();
		helper.setOrderID(choose.getID());
		application.gotoorderOnUserInfo();
	}
	
	@FXML
	public void btn_executed_infoAction(ActionEvent ev) throws Exception {
		OrderInTable choose=order_executed.getSelectionModel().getSelectedItem();
		helper.setOrderID(choose.getID());
		application.gotoorderOnUserInfo();
	}
	
	@FXML
	public void btn_waiting_infoAction(ActionEvent ev) throws Exception {
		OrderInTable choose=order_waiting.getSelectionModel().getSelectedItem();
		helper.setOrderID(choose.getID());
		application.gotoorderOnUserInfo();
	}
	
	@FXML
	public void btn_canceled_infoAction(ActionEvent ev) throws Exception {
		OrderInTable choose=order_canceled.getSelectionModel().getSelectedItem();
		helper.setOrderID(choose.getID());
		application.gotoorderOnUserInfo();
	}
	
	@FXML
	public void btn_abnormal_infoAction(ActionEvent ev) throws Exception {
		OrderInTable choose=order_abnormal.getSelectionModel().getSelectedItem();
		helper.setOrderID(choose.getID());
		application.gotoorderOnUserInfo();
	}
	
	@FXML
	public void btn_SetCanceledAction(ActionEvent ev){
		OrderInTable choose=order_waiting.getSelectionModel().getSelectedItem();
		OrderVO tempOrder=orderController.personalOrderDetail(choose.getID());
		tempOrder.setOrderState(OrderState.CANCELLED);
		ResultMsg msg=orderController.personalOrderCancel(tempOrder);
		if(msg==ResultMsg.SUCCESS){
			data_waiting.remove(choose);
			data_canceled.add(choose);
			Alert alert=new Alert(AlertType.INFORMATION);
			alert.setTitle("提示");
			alert.setHeaderText(null);
			alert.setContentText("操作成功！");
			alert.showAndWait();
		}
		
	}
	
	@FXML
	public void btn_CancelAction(ActionEvent ev){
		application.gotocustomerGuide();
		//OrderInTable result= order_all.getSelectionModel().getSelectedItem();
		
	}

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		// TODO Auto-generated method stub
		helper=UIhelper.getInstance();
		orderManage=new CustomerInfoManagementController();
		hotelInfo=new HotelInfoCheckController();
		orderController=new OrderOnUserController();
		
		ArrayList<OrderVO> order_allList=orderManage.individualOrderInq(helper.getUserID());
		ArrayList<OrderInTable> data_allList=new ArrayList<OrderInTable>();
		int size_all=order_allList.size();
		for(int i=0;i<size_all;i++){
			OrderVO tempOrderVO=order_allList.get(i);
			String hotelName=hotelInfo.checkHotelInfo(tempOrderVO.getHotelID()).getName();//TODO 可优化
			data_allList.add(new OrderInTable(tempOrderVO.getOrderID(),hotelName,tempOrderVO.getCheckInTime(),tempOrderVO.getPrice()));
		}
		data_all=FXCollections.observableArrayList(data_allList);		
		order_all_ID.setCellValueFactory(new PropertyValueFactory<>("ID"));
		order_all_hotelName.setCellValueFactory(new PropertyValueFactory<>("hotelName"));
		order_all_time.setCellValueFactory(new PropertyValueFactory<>("time"));
		order_all_price.setCellValueFactory(new PropertyValueFactory<>("price"));
		order_all.setItems(data_all);
		
		ArrayList<OrderVO> order_executedList=orderManage.finishedOrderInq(helper.getUserID());
		ArrayList<OrderInTable> data_executedList=new ArrayList<OrderInTable>();
		int size_executed=order_executedList.size();
		for(int i=0;i<size_executed;i++){
			OrderVO tempOrderVO=order_executedList.get(i);
			String hotelName=hotelInfo.checkHotelInfo(tempOrderVO.getHotelID()).getName();
			data_executedList.add(new OrderInTable(tempOrderVO.getOrderID(),hotelName,tempOrderVO.getCheckInTime(),tempOrderVO.getPrice()));
		}
		data_executed=FXCollections.observableArrayList(data_executedList);
		order_executed_ID.setCellValueFactory(new PropertyValueFactory<>("ID"));
		order_executed_hotelName.setCellValueFactory(new PropertyValueFactory<>("hotelName"));
		order_executed_time.setCellValueFactory(new PropertyValueFactory<>("time"));
		order_executed_price.setCellValueFactory(new PropertyValueFactory<>("price"));
		order_executed.setItems(data_executed);
		
		ArrayList<OrderVO> order_waitingList=orderManage.unfinishedOrderInq(helper.getUserID());
		ArrayList<OrderInTable> data_waitingList=new ArrayList<OrderInTable>();
		int size_waiting=order_waitingList.size();
		for(int i=0;i<size_waiting;i++){
			OrderVO tempOrderVO=order_waitingList.get(i);
			String hotelName=hotelInfo.checkHotelInfo(tempOrderVO.getHotelID()).getName();
			data_waitingList.add(new OrderInTable(tempOrderVO.getOrderID(),hotelName,tempOrderVO.getCheckInTime(),tempOrderVO.getPrice()));
		}
		data_waiting=FXCollections.observableArrayList(data_waitingList);
		order_waiting_ID.setCellValueFactory(new PropertyValueFactory<>("ID"));
		order_waiting_hotelName.setCellValueFactory(new PropertyValueFactory<>("hotelName"));
		order_waiting_time.setCellValueFactory(new PropertyValueFactory<>("time"));
		order_waiting_price.setCellValueFactory(new PropertyValueFactory<>("price"));
		order_waiting.setItems(data_waiting);
		
		ArrayList<OrderVO> order_canceledList=orderManage.cancelOrderInq(helper.getUserID());
		ArrayList<OrderInTable> data_canceledList=new ArrayList<OrderInTable>();
		int size_canceled=order_canceledList.size();
		for(int i=0;i<size_canceled;i++){
			OrderVO tempOrderVO=order_canceledList.get(i);
			String hotelName=hotelInfo.checkHotelInfo(tempOrderVO.getHotelID()).getName();
			data_canceledList.add(new OrderInTable(tempOrderVO.getOrderID(),hotelName,tempOrderVO.getCheckInTime(),tempOrderVO.getPrice()));
		}
		data_canceled=FXCollections.observableArrayList(data_canceledList);
		order_canceled_ID.setCellValueFactory(new PropertyValueFactory<>("ID"));
		order_canceled_hotelName.setCellValueFactory(new PropertyValueFactory<>("hotelName"));
		order_canceled_time.setCellValueFactory(new PropertyValueFactory<>("time"));
		order_canceled_price.setCellValueFactory(new PropertyValueFactory<>("price"));
		order_canceled.setItems(data_canceled);
		
		ArrayList<OrderVO> order_abnormalList=orderManage.abnormalOrderInq(helper.getUserID());
		ArrayList<OrderInTable> data_abnormalList=new ArrayList<OrderInTable>();
		int size_abnormal=order_abnormalList.size();
		for(int i=0;i<size_abnormal;i++){
			OrderVO tempOrderVO=order_abnormalList.get(i);
			String hotelName=hotelInfo.checkHotelInfo(tempOrderVO.getHotelID()).getName();
			data_abnormalList.add(new OrderInTable(tempOrderVO.getOrderID(),hotelName,tempOrderVO.getCheckInTime(),tempOrderVO.getPrice()));
		}
		data_abnormal=FXCollections.observableArrayList(data_abnormalList);
		order_abnormal_ID.setCellValueFactory(new PropertyValueFactory<>("ID"));
		order_abnormal_hotelName.setCellValueFactory(new PropertyValueFactory<>("hotelName"));
		order_abnormal_time.setCellValueFactory(new PropertyValueFactory<>("time"));
		order_abnormal_price.setCellValueFactory(new PropertyValueFactory<>("price"));
		order_abnormal.setItems(data_abnormal);
	}
	
	/**
	 * 内部类，为了显示列表中的订单信息
	 */
	public static class OrderInTable {
		
		private SimpleStringProperty ID;
		private SimpleStringProperty hotelName;
		private SimpleStringProperty time;
		private SimpleDoubleProperty price;
		
		private OrderInTable(String ID,String hotelName,String time,double price){
			this.ID=new SimpleStringProperty(ID);
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


