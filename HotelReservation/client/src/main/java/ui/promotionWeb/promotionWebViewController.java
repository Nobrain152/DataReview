package ui.promotionWeb;

import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

import bl.userbl.WebStuffWebsiteManagementController;
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
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.cell.PropertyValueFactory;
import ui.UILaunch;
import ui.UIhelper;
import util.Area;
import util.PromotionWebType;
import util.ResultMsg;
import vo.PromotionWebVO;

public class promotionWebViewController implements Initializable {
	private UILaunch application;
	private UIhelper helper;
	WebStuffWebsiteManagementController promotionManage;

	// 会员等级优惠策略
	@FXML
	private TableView<PromotionVIP> promotion_vip;
	@FXML
	private TableColumn<?, ?> promotion_vip_level;
	@FXML
	private TableColumn<?, ?> promotion_vip_discount;
	private ObservableList<PromotionVIP> data_vip;
	@FXML
	private Button btn_vip_modify;
	@FXML
	private Button btn_vip_add;
	@FXML
	private Button btn_vip_delete;
	@FXML
	private TextField tf_vip_level;
	@FXML
	private TextField tf_vip_discount;

	// 特定商圈优惠策略
	@FXML
	private TableView<PromotionArea> promotion_area;
	@FXML
	private TableColumn<?, ?> promotion_area_name;
	@FXML
	private TableColumn<?, ?> promotion_area_discount;
	private ObservableList<PromotionArea> data_area;
	@FXML
	private Button btn_area_modify;
	@FXML
	private Button btn_area_add;
	@FXML
	private Button btn_area_delete;
	@FXML
	private ChoiceBox<Area> cb_area_name;
	@FXML
	private TextField tf_area_discount;

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
	public void btn_vip_modifyAction(ActionEvent ev) {
		PromotionVIP choose=promotion_vip.getSelectionModel().getSelectedItem();
		PromotionWebVO toModify=new PromotionWebVO(null,PromotionWebType.VIP_LEVEL_PROMOTION,choose.getLevel(),choose.getDiscount());
		helper.setPromotionWeb(toModify);
		application.gotopromotionWebVIP();
	}
	
	@FXML
	public void btn_vip_addAction(ActionEvent ev) {
		PromotionWebVO newPromotion=new PromotionWebVO(null,PromotionWebType.VIP_LEVEL_PROMOTION,
				Integer.parseInt(tf_vip_level.getText()),Double.parseDouble(tf_vip_discount.getText()));
		boolean result=promotionManage.websiteStrategeCreate(newPromotion);
		
		
		if(result){
			data_vip.add(new PromotionVIP(Integer.parseInt(tf_vip_level.getText()),Double.parseDouble(tf_vip_discount.getText())));
			tf_vip_level.clear();
			tf_vip_discount.clear();
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
	public void btn_vip_deleteAction(ActionEvent ev) {
		PromotionVIP choose=promotion_vip.getSelectionModel().getSelectedItem();
		PromotionWebVO toDelete=new PromotionWebVO(null,PromotionWebType.VIP_LEVEL_PROMOTION,choose.getLevel(),choose.getDiscount());
		ResultMsg msg=promotionManage.websiteStrategeDelete(toDelete);
		if(msg==ResultMsg.SUCCESS){
			data_vip.remove(choose);		
		}
		else{
			System.out.println("删除失败");
		}
	}
	
	@FXML
	public void btn_area_modifyAction(ActionEvent ev) {
		PromotionArea choose=promotion_area.getSelectionModel().getSelectedItem();
		Area area=null;
		String areaStr=choose.getName();
		if(areaStr.equals("东区")){
			area=Area.EAST;
		}
		else if(areaStr.equals("西区")){
			area=Area.WEST;
		}
		else if(areaStr.equals("南区")){
			area=Area.SOUTH;
		}
		else if(areaStr.equals("北区")){
			area=Area.NORTH;
		}
		PromotionWebVO toModify=new PromotionWebVO(null,PromotionWebType.VIP_CIRCLE_PROMOTION,area,choose.getDiscount());
		helper.setPromotionWeb(toModify);
		application.gotopromotionWebArea();
	}
	
	@FXML
	public void btn_area_addAction(ActionEvent ev) {
		PromotionWebVO newPromotion=new PromotionWebVO(null,PromotionWebType.VIP_CIRCLE_PROMOTION,
				cb_area_name.getValue(),Double.parseDouble(tf_area_discount.getText()));
		boolean result=promotionManage.websiteStrategeCreate(newPromotion);
		
		
		if(result){
			Area area=cb_area_name.getValue();
			String areaStr=null;
			switch(area){
			case EAST: areaStr="东区";break;
			case WEST: areaStr="西区";break;
			case SOUTH: areaStr="南区";break;
			case NORTH: areaStr="北区";
			}
			data_area.add(new PromotionArea(areaStr,Double.parseDouble(tf_area_discount.getText())));
			tf_area_discount.clear();
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
	public void btn_area_deleteAction(ActionEvent ev) {
		PromotionArea choose=promotion_area.getSelectionModel().getSelectedItem();
		Area area=null;
		String areaStr=choose.getName();
		if(areaStr.equals("东区")){
			area=Area.EAST;
		}
		else if(areaStr.equals("西区")){
			area=Area.WEST;
		}
		else if(areaStr.equals("南区")){
			area=Area.SOUTH;
		}
		else if(areaStr.equals("北区")){
			area=Area.NORTH;
		}
		PromotionWebVO toDelete=new PromotionWebVO(null,PromotionWebType.VIP_CIRCLE_PROMOTION,area,choose.getDiscount());
		ResultMsg msg=promotionManage.websiteStrategeDelete(toDelete);
		if(msg==ResultMsg.SUCCESS){
			data_area.remove(choose);		
		}
		else{
			System.out.println("删除失败");
		}
	}
	
	@FXML
	public void btn_diy_modifyAction(ActionEvent ev) {
		PromotionDiy choose=promotion_diy.getSelectionModel().getSelectedItem();
		PromotionWebVO toModify=new PromotionWebVO(null,PromotionWebType.WEB_CUSTOM_PROMOTION,choose.getStartTime(),choose.getEndTime(),choose.getDiscount());
		helper.setPromotionWeb(toModify);		
		application.gotopromotionWebDIY();
	}
	
	@FXML
	public void btn_diy_addAction(ActionEvent ev) {
		PromotionWebVO newPromotion=new PromotionWebVO(null,PromotionWebType.WEB_CUSTOM_PROMOTION,
				dp_diy_start.getValue().toString(),dp_diy_end.getValue().toString(),Double.parseDouble(tf_diy_discount.getText()));
		boolean result=promotionManage.websiteStrategeCreate(newPromotion);
		if(result){
			data_diy.add(new PromotionDiy(dp_diy_start.getValue().toString(),dp_diy_end.getValue().toString(),Double.parseDouble(tf_diy_discount.getText())));
			tf_diy_discount.clear();
		}else{
			Alert alert=new Alert(AlertType.ERROR);
			alert.setTitle("错误");
			alert.setHeaderText(null);
			alert.setContentText("添加失败");
			alert.showAndWait();
		}
			
	}
	
	@FXML
	public void btn_diy_deleteAction(ActionEvent ev) {
		PromotionDiy choose=promotion_diy.getSelectionModel().getSelectedItem();
		PromotionWebVO toDelete=new PromotionWebVO(null,PromotionWebType.WEB_CUSTOM_PROMOTION,choose.getStartTime(),choose.getEndTime(),choose.getDiscount());
		ResultMsg msg=promotionManage.websiteStrategeDelete(toDelete);
		if(msg==ResultMsg.SUCCESS){
			data_diy.remove(choose);
		}
		else{
			System.out.println("删除失败");
		}
	}

	@FXML
	public void btn_CancelAction(ActionEvent ev) {
		application.gotowebSalesmanGuide();
	}

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		// TODO Auto-generated method stub
		helper=UIhelper.getInstance();
		promotionManage=new WebStuffWebsiteManagementController();
		
		cb_area_name.setItems(FXCollections.observableArrayList(Area.EAST,Area.WEST,Area.NORTH,Area.SOUTH));
		
		PromotionWebVO vo_vip=new PromotionWebVO();
		vo_vip.setType(PromotionWebType.VIP_LEVEL_PROMOTION);
		ArrayList<PromotionWebVO> promotion_vipList=promotionManage.websiteStrategeInq(vo_vip);
		ArrayList<PromotionVIP> data_vipList=new ArrayList<PromotionVIP>();
		int size_vip=promotion_vipList.size();
		for(int i=0;i<size_vip;i++){
			PromotionWebVO tempPromotionVO=promotion_vipList.get(i);
			data_vipList.add(new PromotionVIP(tempPromotionVO.getLevel(),tempPromotionVO.getRatio()));
		}
		data_vip=FXCollections.observableArrayList(data_vipList);		
		promotion_vip_level.setCellValueFactory(new PropertyValueFactory<>("level"));
		promotion_vip_discount.setCellValueFactory(new PropertyValueFactory<>("discount"));
		promotion_vip.setItems(data_vip);
		
		PromotionWebVO vo_area=new PromotionWebVO();
		vo_area.setType(PromotionWebType.VIP_CIRCLE_PROMOTION);
		ArrayList<PromotionWebVO> promotion_areaList=promotionManage.websiteStrategeInq(vo_area);
		ArrayList<PromotionArea> data_areaList=new ArrayList<PromotionArea>();
		int size_area=promotion_areaList.size();
		for(int i=0;i<size_area;i++){
			PromotionWebVO tempPromotionVO=promotion_areaList.get(i);
			Area area=tempPromotionVO.getLocation();
			String areaStr=null;			
			switch(area){
			case EAST: areaStr="东区";break;
			case WEST: areaStr="西区";break;
			case SOUTH: areaStr="南区";break;
			case NORTH: areaStr="北区";
			}
			data_areaList.add(new PromotionArea(areaStr,tempPromotionVO.getRatio()));
		}
		data_area=FXCollections.observableArrayList(data_areaList);		
		promotion_area_name.setCellValueFactory(new PropertyValueFactory<>("name"));
		promotion_area_discount.setCellValueFactory(new PropertyValueFactory<>("discount"));
		promotion_area.setItems(data_area);
		
		PromotionWebVO vo_diy=new PromotionWebVO();
		vo_diy.setType(PromotionWebType.WEB_CUSTOM_PROMOTION);
		ArrayList<PromotionWebVO> promotion_diyList=promotionManage.websiteStrategeInq(vo_diy);
		ArrayList<PromotionDiy> data_diyList=new ArrayList<PromotionDiy>();
		int size_diy=promotion_diyList.size();
		for(int i=0;i<size_diy;i++){
			PromotionWebVO tempPromotionVO=promotion_diyList.get(i);
			data_diyList.add(new PromotionDiy(tempPromotionVO.getTimeBegin(),tempPromotionVO.getTimeOver(),tempPromotionVO.getRatio()));
		}
		data_diy=FXCollections.observableArrayList(data_diyList);		
		promotion_diy_startTime.setCellValueFactory(new PropertyValueFactory<>("startTime"));
		promotion_diy_endTime.setCellValueFactory(new PropertyValueFactory<>("endTime"));
		promotion_diy_discount.setCellValueFactory(new PropertyValueFactory<>("discount"));
		promotion_diy.setItems(data_diy);
	}
	
	public static class PromotionVIP{
		private SimpleIntegerProperty level;
		private SimpleDoubleProperty discount;
		
		private PromotionVIP(int level,double discount){
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
	
	public static class PromotionArea {
		private SimpleStringProperty name;
		private SimpleDoubleProperty discount;
		
		private PromotionArea(String name,double discount){
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
