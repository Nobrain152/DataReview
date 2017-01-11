package ui.promotionHotel;

import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

import bl.userbl.HotelStuffHotelOperationController;
import bl.userbl.StuffInfoManagementController;
import javafx.beans.property.SimpleDoubleProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.cell.PropertyValueFactory;
import ui.UILaunch;
import ui.UIhelper;
import util.PromotionHotelType;
import vo.PromotionHotelVO;
import vo.StuffInfoVO;

public class promotionHotelViewController implements Initializable {
	private UILaunch application;
	private UIhelper helper;
	private HotelStuffHotelOperationController promotionManage;
	private StuffInfoManagementController stuffInfo;
	private String hotelID;

	// 会员生日优惠策略
	@FXML
	private TableView<PromotionBirthday> promotion_birthday;
	@FXML
	private TableColumn<?, ?> promotion_birthday_level;
	@FXML
	private TableColumn<?, ?> promotion_birthday_discount;
	private ObservableList<PromotionBirthday> data_birthday;
	@FXML
	private Button btn_birthday_modify;
	@FXML
	private Button btn_birthday_add;
	@FXML
	private Button btn_birthday_delete;
	@FXML
	private TextField tf_birthday_level;
	@FXML
	private TextField tf_birthday_discount;

	// 三间以上优惠策略
	@FXML
	private TableView<PromotionThreeRoom> promotion_threeroom;
	@FXML
	private TableColumn<?, ?> promotion_threeroom_number;
	@FXML
	private TableColumn<?, ?> promotion_threeroom_discount;
	private ObservableList<PromotionThreeRoom> data_threeroom;
	@FXML
	private Button btn_threeroom_modify;
	@FXML
	private Button btn_threeroom_add;
	@FXML
	private Button btn_threeroom_delete;
	@FXML
	private TextField tf_threeroom_number;
	@FXML
	private TextField tf_threeroom_discount;

	// 合作企业优惠策略
	@FXML
	private TableView<PromotionEnterprise> promotion_enterprise;
	@FXML
	private TableColumn<?, ?> promotion_enterprise_name;
	@FXML
	private TableColumn<?, ?> promotion_enterprise_discount;
	private ObservableList<PromotionEnterprise> data_enterprise;

	@FXML
	private Button btn_enterprise_modify;
	@FXML
	private Button btn_enterprise_add;
	@FXML
	private Button btn_enterprise_delete;
	@FXML
	private TextField tf_enterprise_name;
	@FXML
	private TextField tf_enterprise_discount;

	// 自定义优惠策略
	@FXML
	private TableView<PromotionDiy> promotion_diy;
	@FXML
	private TableColumn<?, ?> promotion_diy_startTime;
	@FXML
	private TableColumn<?, ?> promotion_diy_endTime;
	@FXML
	private TableColumn<?, ?> promotion_diy_discount;
	private ObservableList<PromotionDiy> data_diy;
	@FXML
	private Button btn_diy_modify;
	@FXML
	private Button btn_diy_add;
	@FXML
	private Button btn_diy_delete;
	@FXML
	private DatePicker dp_diy_start;
	@FXML
	private DatePicker dp_diy_end;
	@FXML
	private TextField tf_diy_discount;
	

	@FXML
	private Button btn_Cancel;

	public void setApp(UILaunch application) {
		this.application = application;
	}

	@FXML
	public void btn_CancelAction(ActionEvent ev) {
		application.gotohotelStuffGuide();
	}
	
	@FXML
	public void btn_birthday_modifyAction(ActionEvent ev) {
		PromotionBirthday choose=promotion_birthday.getSelectionModel().getSelectedItem();
		PromotionHotelVO toModify=new PromotionHotelVO(null,PromotionHotelType.BIRTH_PROMOTION,hotelID,choose.getLevel(),choose.getDiscount());
		helper.setPromotionHotel(toModify);
		application.gotopromotionHotelBirthday();
	}
	
	@FXML
	public void btn_birthday_addAction(ActionEvent ev) {
		PromotionHotelVO newPromotion=new PromotionHotelVO(null,PromotionHotelType.BIRTH_PROMOTION,hotelID,
				Integer.parseInt(tf_birthday_level.getText()),Double.parseDouble(tf_birthday_discount.getText()));
		boolean result=promotionManage.hotelStrategeAdd(newPromotion);
		if(result){
			data_birthday.add(new PromotionBirthday(Integer.parseInt(tf_birthday_level.getText()),Double.parseDouble(tf_birthday_discount.getText())));
			tf_birthday_level.clear();
			tf_birthday_discount.clear();
		}
		else{
			Alert alert=new Alert(AlertType.ERROR);
			alert.setTitle("错误");
			alert.setHeaderText(null);
			alert.setContentText("添加失败");
			alert.showAndWait();
		}
	}
	
	@FXML
	public void btn_birthday_deleteAction(ActionEvent ev) {
		PromotionBirthday choose=promotion_birthday.getSelectionModel().getSelectedItem();
		PromotionHotelVO toDelete=new PromotionHotelVO(null,PromotionHotelType.BIRTH_PROMOTION,hotelID,choose.getLevel(),choose.getDiscount());
		boolean result=promotionManage.hotelStrategeDelete(toDelete);
		if(result){
			data_birthday.remove(choose);
			
			
		}
		else{
			System.out.println("删除失败");
		}
	}
	
	@FXML
	public void btn_diy_modifyAction(ActionEvent ev) {
		PromotionDiy choose=promotion_diy.getSelectionModel().getSelectedItem();
		PromotionHotelVO toModify=new PromotionHotelVO(null,PromotionHotelType.HOTEL_CUSTOM_PROMOTION,hotelID,choose.getStartTime(),choose.getEndTime(),choose.getDiscount());
		helper.setPromotionHotel(toModify);
		application.gotopromotionHotelDIY();
	}
	
	@FXML
	public void btn_diy_addAction(ActionEvent ev) {
		PromotionHotelVO newPromotion=new PromotionHotelVO(null,PromotionHotelType.HOTEL_CUSTOM_PROMOTION,hotelID,
				dp_diy_start.getValue().toString(),dp_diy_end.getValue().toString(),Double.parseDouble(tf_diy_discount.getText()));
		promotionManage.hotelStrategeAdd(newPromotion);
		
		data_diy.add(new PromotionDiy(dp_diy_start.getValue().toString(),dp_diy_end.getValue().toString(),Double.parseDouble(tf_diy_discount.getText())));
		tf_diy_discount.clear();
		
		
	}
	
	@FXML
	public void btn_diy_deleteAction(ActionEvent ev) {
		PromotionDiy choose=promotion_diy.getSelectionModel().getSelectedItem();
		PromotionHotelVO toDelete=new PromotionHotelVO(null,PromotionHotelType.HOTEL_CUSTOM_PROMOTION,hotelID,choose.getStartTime(),choose.getEndTime(),choose.getDiscount());
		promotionManage.hotelStrategeDelete(toDelete);
		data_diy.remove(choose);
		
	}
	
	@FXML
	public void btn_enterprise_modifyAction(ActionEvent ev) {
		PromotionEnterprise choose=promotion_enterprise.getSelectionModel().getSelectedItem();
		PromotionHotelVO toModify=new PromotionHotelVO(null,PromotionHotelType.JOIN_PROMOTION,hotelID,choose.getName(),choose.getDiscount());
		helper.setPromotionHotel(toModify);
		application.gotopromotionHotelEnterprise();
	}
	
	@FXML
	public void btn_enterprise_addAction(ActionEvent ev) {
		PromotionHotelVO newPromotion=new PromotionHotelVO(null,PromotionHotelType.JOIN_PROMOTION,hotelID,
				tf_enterprise_name.getText(),Double.parseDouble(tf_enterprise_discount.getText()));
		boolean result=promotionManage.hotelStrategeAdd(newPromotion);
		if(result){
			data_enterprise.add(new PromotionEnterprise(tf_enterprise_name.getText(),Double.parseDouble(tf_enterprise_discount.getText())));
			tf_enterprise_name.clear();
			tf_enterprise_discount.clear();
		}
		else{
			Alert alert=new Alert(AlertType.ERROR);
			alert.setTitle("错误");
			alert.setHeaderText(null);
			alert.setContentText("添加失败");
			alert.showAndWait();
		}
	}
	
	@FXML
	public void btn_enterprise_deleteAction(ActionEvent ev) {
		PromotionEnterprise choose=promotion_enterprise.getSelectionModel().getSelectedItem();
		PromotionHotelVO toDelete=new PromotionHotelVO(null,PromotionHotelType.JOIN_PROMOTION,hotelID,choose.getName(),choose.getDiscount());
		boolean result=promotionManage.hotelStrategeDelete(toDelete);
		if(result){
			data_enterprise.remove(choose);
		}
		else{
			System.out.println("删除失败");
		}
	}
	
	@FXML
	public void btn_threeroom_modifyAction(ActionEvent ev) {
		PromotionThreeRoom choose=promotion_threeroom.getSelectionModel().getSelectedItem();
		PromotionHotelVO toModify=new PromotionHotelVO(null,PromotionHotelType.OVERTHREE_PROMOTION,hotelID,choose.getNumber(),choose.getDiscount());
		helper.setPromotionHotel(toModify);
		application.gotopromotionHotelRoom();
	}
	
	@FXML
	public void btn_threeroom_addAction(ActionEvent ev) {
		PromotionHotelVO newPromotion=new PromotionHotelVO(null,PromotionHotelType.OVERTHREE_PROMOTION,hotelID,
				Integer.parseInt(tf_threeroom_number.getText()),Double.parseDouble(tf_threeroom_discount.getText()));
		boolean result=promotionManage.hotelStrategeAdd(newPromotion);
		if(result){
			data_threeroom.add(new PromotionThreeRoom(Integer.parseInt(tf_threeroom_number.getText()),Double.parseDouble(tf_threeroom_discount.getText())));
			tf_threeroom_number.clear();
			tf_threeroom_discount.clear();
		}
		else{
			Alert alert=new Alert(AlertType.ERROR);
			alert.setTitle("错误");
			alert.setHeaderText(null);
			alert.setContentText("添加失败");
			alert.showAndWait();
		}
	}
	
	@FXML
	public void btn_threeroom_deleteAction(ActionEvent ev) {
		PromotionThreeRoom choose=promotion_threeroom.getSelectionModel().getSelectedItem();
		PromotionHotelVO toDelete=new PromotionHotelVO(null,PromotionHotelType.OVERTHREE_PROMOTION,hotelID,choose.getNumber(),choose.getDiscount());
		boolean result=promotionManage.hotelStrategeDelete(toDelete);
		if(result){
			data_threeroom.remove(choose);
		}
		else{
			System.out.println("删除失败");
		}
	}

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		// TODO Auto-generated method stub
		helper=UIhelper.getInstance();
		promotionManage=new HotelStuffHotelOperationController();
		stuffInfo=new StuffInfoManagementController();
		
		//获取酒店ID
		String hotelStuffID=helper.getUserID();
		StuffInfoVO vo=stuffInfo.individualInfolnq(hotelStuffID);
		hotelID=vo.getHotel();
		
		
		PromotionHotelVO vo_birthday=new PromotionHotelVO();
		vo_birthday.setType(PromotionHotelType.BIRTH_PROMOTION);
		vo_birthday.setHotelID(hotelID);
		ArrayList<PromotionHotelVO> promotion_birthdayList=promotionManage.hotelPromotionInq(vo_birthday);
		ArrayList<PromotionBirthday> data_birthdayList = new ArrayList<PromotionBirthday>();
		int size_birthday=promotion_birthdayList.size();
		for(int i=0;i<size_birthday;i++){
			PromotionHotelVO tempPromotionVO=promotion_birthdayList.get(i);
			data_birthdayList.add(new PromotionBirthday(tempPromotionVO.getLevel(),tempPromotionVO.getRatio()));
		}
		data_birthday=FXCollections.observableArrayList(data_birthdayList);		
		promotion_birthday_level.setCellValueFactory(new PropertyValueFactory<>("level"));
		promotion_birthday_discount.setCellValueFactory(new PropertyValueFactory<>("discount"));
		promotion_birthday.setItems(data_birthday);
		
		PromotionHotelVO vo_threeroom=new PromotionHotelVO();
		vo_threeroom.setType(PromotionHotelType.OVERTHREE_PROMOTION);
		vo_threeroom.setHotelID(hotelID);
		ArrayList<PromotionHotelVO> promotion_threeroomList=promotionManage.hotelPromotionInq(vo_threeroom);
		ArrayList<PromotionThreeRoom> data_threeroomList = new ArrayList<PromotionThreeRoom>();
		int size_threeroom=promotion_threeroomList.size();
		for(int i=0;i<size_threeroom;i++){
			PromotionHotelVO tempPromotionVO=promotion_threeroomList.get(i);
			data_threeroomList.add(new PromotionThreeRoom(tempPromotionVO.getNumber(),tempPromotionVO.getRatio()));
		}
		data_threeroom=FXCollections.observableArrayList(data_threeroomList);		
		promotion_threeroom_number.setCellValueFactory(new PropertyValueFactory<>("number"));
		promotion_threeroom_discount.setCellValueFactory(new PropertyValueFactory<>("discount"));
		promotion_threeroom.setItems(data_threeroom);
		
		PromotionHotelVO vo_enterprise=new PromotionHotelVO();
		vo_enterprise.setType(PromotionHotelType.JOIN_PROMOTION);
		vo_enterprise.setHotelID(hotelID);
		ArrayList<PromotionHotelVO> promotion_enterpriseList=promotionManage.hotelPromotionInq(vo_enterprise);
		ArrayList<PromotionEnterprise> data_enterpriseList = new ArrayList<PromotionEnterprise>();
		int size_enterprise=promotion_enterpriseList.size();
		for(int i=0;i<size_enterprise;i++){
			PromotionHotelVO tempPromotionVO=promotion_enterpriseList.get(i);
			data_enterpriseList.add(new PromotionEnterprise(tempPromotionVO.getBusinessName(),tempPromotionVO.getRatio()));
		}
		data_enterprise=FXCollections.observableArrayList(data_enterpriseList);		
		promotion_enterprise_name.setCellValueFactory(new PropertyValueFactory<>("name"));
		promotion_enterprise_discount.setCellValueFactory(new PropertyValueFactory<>("discount"));
		promotion_enterprise.setItems(data_enterprise);

		PromotionHotelVO vo_diy=new PromotionHotelVO();
		vo_diy.setType(PromotionHotelType.HOTEL_CUSTOM_PROMOTION);
		vo_diy.setHotelID(hotelID);
		ArrayList<PromotionHotelVO> promotion_diyList=promotionManage.hotelPromotionInq(vo_diy);
		ArrayList<PromotionDiy> data_diyList = new ArrayList<PromotionDiy>();
		int size_diy=promotion_diyList.size();
		for(int i=0;i<size_diy;i++){
			PromotionHotelVO tempPromotionVO=promotion_diyList.get(i);
			data_diyList.add(new PromotionDiy(tempPromotionVO.getTimeBegin(),tempPromotionVO.getTimeOver(),tempPromotionVO.getRatio()));
		}
		data_diy=FXCollections.observableArrayList(data_diyList);		
		promotion_diy_startTime.setCellValueFactory(new PropertyValueFactory<>("startTime"));
		promotion_diy_endTime.setCellValueFactory(new PropertyValueFactory<>("endTime"));
		promotion_diy_discount.setCellValueFactory(new PropertyValueFactory<>("discount"));
		promotion_diy.setItems(data_diy);
	}
	
	public static class PromotionBirthday {
		private SimpleIntegerProperty level;
		private SimpleDoubleProperty discount;
		
		private PromotionBirthday(int level,double discount){
			this.level=new SimpleIntegerProperty(level);
			this.discount=new SimpleDoubleProperty(discount);
		}
		
		public int getLevel(){
			return level.get();
		}
		
		public void setLevel(int n){
			level.set(n);
		}
		
		public double getDiscount(){
			return discount.get();
		}
		
		public void setDiscount(double n){
			discount.set(n);
		}
	}
	
	public static class PromotionThreeRoom {
		private SimpleIntegerProperty number;
		private SimpleDoubleProperty discount;
		
		private PromotionThreeRoom(int number,double discount){
			this.number=new SimpleIntegerProperty(number);
			this.discount=new SimpleDoubleProperty(discount);
		}
		
		public int getNumber(){
			return number.get();
		}
		
		public void setNumber(int n){
			number.set(n);
		}
		
		public double getDiscount(){
			return discount.get();
		}
		
		public void setDiscount(double n){
			discount.set(n);
		}
	}
	
	public static class PromotionEnterprise {
		private SimpleStringProperty name;
		private SimpleDoubleProperty discount;
		
		private PromotionEnterprise(String name,double discount){
			this.name=new SimpleStringProperty(name);
			this.discount=new SimpleDoubleProperty(discount);
		}
		
		public String getName(){
			return name.get();
		}
		
		public void setName(String str){
			name.set(str);
		}
		
		public double getDiscount(){
			return discount.get();
		}
		
		public void setDiscount(double n){
			discount.set(n);
		}
	}
	
	public static class PromotionDiy{
		private SimpleStringProperty startTime;
		private SimpleStringProperty endTime;
		private SimpleDoubleProperty discount;
		
		private PromotionDiy(String startTime,String endTime,double discount){
			this.startTime=new SimpleStringProperty(startTime);
			this.endTime=new SimpleStringProperty(endTime);
			this.discount=new SimpleDoubleProperty(discount);
		}
		
		public String getStartTime(){
			return startTime.get();
		}
		
		public void setStartTime(String str){
			startTime.set(str);
		}
		
		public String getEndTime(){
			return endTime.get();
		}
		
		public void setEndTime(String str){
			endTime.set(str);
		}
		
		public double getDiscount(){
			return discount.get();
		}
		
		public void setDiscount(double n){
			discount.set(n);
		}
	}

}
