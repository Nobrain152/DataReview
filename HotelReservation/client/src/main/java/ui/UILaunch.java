package ui;

import java.io.InputStream;

import bl.Update;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.fxml.JavaFXBuilderFactory;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import ui.credit.creditCheckViewController;
import ui.credit.creditRechargeViewController;
import ui.customerGuide.customerGuideViewController;
import ui.customerInfo.customerInfoModifyViewController;
import ui.customerInfo.customerInfoViewController;
import ui.customerInfoManage.customerInfoByMViewController;
import ui.customerInfoManage.customerInfoInquireByMViewController;
import ui.customerInfoManage.customerInfoModifyByMViewController;
import ui.hotelAdd.hotelAddViewController;
import ui.hotelAdd.hotelStuffAddViewController;
import ui.hotelAdd.hotelStuffInquireViewController;
import ui.hotelAdd.hotelStuffModifyViewController;
import ui.hotelEvaluate.hotelEvaluateViewController;
import ui.hotelManaged.hotelInfoMaintainViewController;
import ui.hotelManaged.hotelManagedInfoViewController;
import ui.hotelReserve.hotelReserveViewController;
import ui.hotelSearch.hotelInfoSearchedViewController;
import ui.hotelSearch.hotelSearchListViewController;
import ui.hotelSearch.hotelSearchViewController;
import ui.hotelStuffGuide.hotelStuffGuideViewController;
import ui.login.loginViewController;
import ui.login.registerViewController;
import ui.orderOnHotel.orderOnHotelInfoViewController;
import ui.orderOnHotel.orderOnHotelViewController;
import ui.orderOnUser.orderOnUserInfoViewController;
import ui.orderOnUser.orderOnUserViewController;
import ui.orderOnWeb.abnormalOrderInfoViewController;
import ui.orderOnWeb.abnormalOrderViewController;
import ui.promotionHotel.promotionHotelBirthdayViewController;
import ui.promotionHotel.promotionHotelDIYViewController;
import ui.promotionHotel.promotionHotelEnterpriseViewController;
import ui.promotionHotel.promotionHotelRoomViewController;
import ui.promotionHotel.promotionHotelViewController;
import ui.promotionWeb.promotionWebAreaViewController;
import ui.promotionWeb.promotionWebDIYViewController;
import ui.promotionWeb.promotionWebVIPViewController;
import ui.promotionWeb.promotionWebViewController;
import ui.reservedHotel.reservedHotelInfoViewController;
import ui.reservedHotel.reservedHotelListViewController;
import ui.roomAdd.roomAddViewController;
import ui.roomAdd.roomListViewController;
import ui.roomAdd.roomModifyViewController;
import ui.vip.vipRegisterViewController;
import ui.webManagerGuide.webManagerGuideViewController;
import ui.webSalesman.webSalesmanAddViewController;
import ui.webSalesman.webSalesmanInquireViewController;
import ui.webSalesman.webSalesmanModifyViewController;
import ui.webSalesmanGuide.webSalesmanGuideViewController;

public class UILaunch extends Application{
	private Stage stage;
	private final int  MINIMUM_WINDOW_WIDTH =800;
	private final int  MINIMUM_WINDOW_HEIGHT =600;
	
	
	@Override
	public void start(Stage primaryStage) throws Exception {
		new Thread(new Update()).start();
		
		stage = primaryStage;
		stage.setTitle("DIMENSION");
		stage.setMinWidth(MINIMUM_WINDOW_WIDTH);
		stage.setMinHeight(MINIMUM_WINDOW_HEIGHT);
		gotologin();	
		stage.show();
	}
	
	/**
	 * 跳转到登录界面
	 */
	public void gotologin(){
		try{
			loginViewController login=(loginViewController) replaceSceneContent("login/login.fxml");
			login.setApp(this);
		}catch(Exception ex){
			ex.printStackTrace();
		}
	}
	
	/**
	 * 跳转到注册界面
	 */
	public void gotoregister(){
		try{
			registerViewController register=(registerViewController) replaceSceneContent("login/register.fxml");
			register.setApp(this);
		}catch(Exception ex){
			ex.printStackTrace();
		}
	}
	
	/**
	 * 跳转到客户导航界面
	 */
	public void gotocustomerGuide(){
		try{
			customerGuideViewController customerGuide=(customerGuideViewController) replaceSceneContent("customerGuide/customerGuide.fxml");
			customerGuide.setApp(this);
		}catch(Exception ex){
			ex.printStackTrace();
		}
	}
	
	/**
	 * 跳转到信誉查看界面
	 */
	public void gotocreditCheck(){
		try{
			creditCheckViewController creditCheck=(creditCheckViewController) replaceSceneContent("credit/creditCheck.fxml");
			creditCheck.setApp(this);
		}catch(Exception ex){
			ex.printStackTrace();
		}
	}
	
	/**
	 * 跳转到信誉充值界面
	 */
	public void gotocreditRecharge(){
		try{
			creditRechargeViewController creditRecharge=(creditRechargeViewController) replaceSceneContent("credit/creditRecharge.fxml");
			creditRecharge.setApp(this);
		}catch(Exception ex){
			ex.printStackTrace();
		}
	}
	
	/**
	 * 跳转到客户信息界面
	 */
	public void gotocustomerInfo(){
		try{
			customerInfoViewController customerInfo=(customerInfoViewController) replaceSceneContent("customerInfo/customerInfo.fxml");
			customerInfo.setApp(this);
		}catch(Exception ex){
			ex.printStackTrace();
		}
	}
	
	
	/**
	 * 跳转到客户信息修改界面
	 */
	public void gotocustomerInfoModify(){
		try{
			customerInfoModifyViewController customerInfoModify=(customerInfoModifyViewController) replaceSceneContent("customerInfo/customerInfoModify.fxml");
			customerInfoModify.setApp(this);
		}catch(Exception ex){
			ex.printStackTrace();
		}
	}
	
	/**
	 * 跳转到网站管理人员视角下的客户信息界面
	 */
	public void gotocustomerInfoByM(){
		try{
			customerInfoByMViewController customerInfoByM=(customerInfoByMViewController) replaceSceneContent("customerInfoManage/customerInfoByM.fxml");
			customerInfoByM.setApp(this);
		}catch(Exception ex){
			ex.printStackTrace();
		}
	}
	
	/**
	 * 跳转到网站管理人员视角下的客户信息查询界面
	 */
	public void gotocustomerInfoInquireByM(){
		try{
			customerInfoInquireByMViewController customerInfoInquireByM=(customerInfoInquireByMViewController) replaceSceneContent("customerInfoManage/customerInfoInquireByM.fxml");
			customerInfoInquireByM.setApp(this);
		}catch(Exception ex){
			ex.printStackTrace();
		}
	}
	
	/**
	 * 跳转到网站管理人员视角下的客户信息修改界面
	 */
	public void gotocustomerInfoModifyByM(){
		try{
			customerInfoModifyByMViewController customerInfoModifyByM=(customerInfoModifyByMViewController) replaceSceneContent("customerInfoManage/customerInfoModifyByM.fxml");
			customerInfoModifyByM.setApp(this);
		}catch(Exception ex){
			ex.printStackTrace();
		}
	}
	
	/**
	 * 跳转到酒店添加界面
	 */
	public void gotohotelAdd(){
		try{
			hotelAddViewController hotelAdd=(hotelAddViewController) replaceSceneContent("hotelAdd/hotelAdd.fxml");
			hotelAdd.setApp(this);
		}catch(Exception ex){
			ex.printStackTrace();
		}
	}
	
	/**
	 * 跳转到酒店工作人员添加界面
	 */
	public void gotohotelStuffAdd(){
		try{
			hotelStuffAddViewController hotelStuffAdd=(hotelStuffAddViewController) replaceSceneContent("hotelAdd/hotelStuffAdd.fxml");
			hotelStuffAdd.setApp(this);
		}catch(Exception ex){
			ex.printStackTrace();
		}
	}
	
	/**
	 * 跳转到酒店工作人员查询界面
	 */
	public void gotohotelStuffInquire(){
		try{
			hotelStuffInquireViewController hotelStuffInquire=(hotelStuffInquireViewController) replaceSceneContent("hotelAdd/hotelStuffInquire.fxml");
			hotelStuffInquire.setApp(this);
		}catch(Exception ex){
			ex.printStackTrace();
		}
	}
	
	/**
	 * 跳转到酒店工作人员修改界面
	 */
	public void gotohotelStuffModify(){
		try{
			hotelStuffModifyViewController hotelStuffModify=(hotelStuffModifyViewController) replaceSceneContent("hotelAdd/hotelStuffModify.fxml");
			hotelStuffModify.setApp(this);
		}catch(Exception ex){
			ex.printStackTrace();
		}
	}
	
	/**
	 * 跳转到网站营销人员添加界面
	 */
	public void gotowebSalesmanAdd(){
		try{
			webSalesmanAddViewController webSalesmanAdd=(webSalesmanAddViewController) replaceSceneContent("webSalesman/webSalesmanAdd.fxml");
			webSalesmanAdd.setApp(this);
		}catch(Exception ex){
			ex.printStackTrace();
		}
	}
	
	/**
	 * 跳转到网站营销人员查询界面
	 */
	public void gotowebSalesmanInquire(){
		try{
			webSalesmanInquireViewController webSalesmanInquire=(webSalesmanInquireViewController) replaceSceneContent("webSalesman/webSalesmanInquire.fxml");
			webSalesmanInquire.setApp(this);
		}catch(Exception ex){
			ex.printStackTrace();
		}
	}
	
	/**
	 * 跳转到网站营销人员修改界面
	 */
	public void gotowebSalesmanModify(){
		try{
			webSalesmanModifyViewController webSalesmanModify=(webSalesmanModifyViewController) replaceSceneContent("webSalesman/webSalesmanModify.fxml");
			webSalesmanModify.setApp(this);
		}catch(Exception ex){
			ex.printStackTrace();
		}
	}
	
	/**
	 * 跳转到酒店评价界面
	 */
	public void gotohotelEvaluate(){
		try{
			hotelEvaluateViewController hotelEvaluate=(hotelEvaluateViewController) replaceSceneContent("hotelEvaluate/hotelEvaluate.fxml");
			hotelEvaluate.setApp(this);
		}catch(Exception ex){
			ex.printStackTrace();
		}
	}
	
	/**
	 * 跳转到维护酒店基本信息界面
	 */
	public void gotohotelInfoMaintain(){
		try{
			hotelInfoMaintainViewController hotelInfoMaintain=(hotelInfoMaintainViewController) replaceSceneContent("hotelManaged/hotelInfoMaintain.fxml");
			hotelInfoMaintain.setApp(this);
		}catch(Exception ex){
			ex.printStackTrace();
		}
	}
	
	/**
	 * 跳转到管理的酒店界面
	 */
	public void gotohotelManagedInfo(){
		try{
			hotelManagedInfoViewController hotelManagedInfo=(hotelManagedInfoViewController) replaceSceneContent("hotelManaged/hotelManagedInfo.fxml");
			hotelManagedInfo.setApp(this);
		}catch(Exception ex){
			ex.printStackTrace();
		}
	}
	
	/**
	 * 跳转到酒店预定界面
	 */
	public void gotohotelReserve(){
		try{
			hotelReserveViewController hotelReserve=(hotelReserveViewController) replaceSceneContent("hotelReserve/hotelReserve.fxml");
			hotelReserve.setApp(this);
		}catch(Exception ex){
			ex.printStackTrace();
		}
	}
	
	/**
	 * 跳转到搜索到的酒店信息界面
	 */
	public void gotohotelInfoSearched(){
		try{
			hotelInfoSearchedViewController hotelInfoSearched=(hotelInfoSearchedViewController) replaceSceneContent("hotelSearch/hotelInfoSearched.fxml");
			hotelInfoSearched.setApp(this);
		}catch(Exception ex){
			ex.printStackTrace();
		}
	}
	
	/**
	 * 跳转到酒店搜索界面
	 */
	public void gotohotelSearch(){
		try{
			hotelSearchViewController hotelSearch=(hotelSearchViewController) replaceSceneContent("hotelSearch/hotelSearch.fxml");
			hotelSearch.setApp(this);
		}catch(Exception ex){
			ex.printStackTrace();
		}
	}
	
	/**
	 * 跳转到搜索到的酒店列表界面
	 */
	public void gotohotelSearchList(){
		try{
			hotelSearchListViewController hotelSearchList=(hotelSearchListViewController) replaceSceneContent("hotelSearch/hotelSearchList.fxml");
			hotelSearchList.setApp(this);
		}catch(Exception ex){
			ex.printStackTrace();
		}
	}
	
	/**
	 * 跳转到酒店工作人员导航界面
	 */
	public void gotohotelStuffGuide(){
		try{
			hotelStuffGuideViewController hotelStuffGuide=(hotelStuffGuideViewController) replaceSceneContent("hotelStuffGuide/hotelStuffGuide.fxml");
			hotelStuffGuide.setApp(this);
		}catch(Exception ex){
			ex.printStackTrace();
		}
	}
	
	/**
	 * 跳转到酒店订单界面
	 */
	public void gotoorderOnHotel(){
		try{
			orderOnHotelViewController orderOnHotel=(orderOnHotelViewController) replaceSceneContent("orderOnHotel/orderOnHotel.fxml");
			orderOnHotel.setApp(this);
		}catch(Exception ex){
			ex.printStackTrace();
		}
	}
	
	/**
	 * 跳转到酒店订单详情界面
	 */
	public void gotoorderOnHotelInfo(){
		try{
			orderOnHotelInfoViewController orderOnHotelInfo=(orderOnHotelInfoViewController) replaceSceneContent("orderOnHotel/orderOnHotelInfo.fxml");
			orderOnHotelInfo.setApp(this);
		}catch(Exception ex){
			ex.printStackTrace();
		}
	}
		
	/**
	 * 跳转到用户订单界面
	 */
	public void gotoorderOnUser(){
		try{
			orderOnUserViewController orderOnUser=(orderOnUserViewController) replaceSceneContent("orderOnUser/orderOnUser.fxml");
			orderOnUser.setApp(this);
		}catch(Exception ex){
			ex.printStackTrace();
		}
	}
	
	/**
	 * 跳转到用户订单详情界面
	 */
	public void gotoorderOnUserInfo(){
		try{
			orderOnUserInfoViewController orderOnUserInfo=(orderOnUserInfoViewController) replaceSceneContent("orderOnUser/orderOnUserInfo.fxml");
			orderOnUserInfo.setApp(this);
		}catch(Exception ex){
			ex.printStackTrace();
		}
	}
	
	/**
	 * 跳转到异常订单管理界面界面
	 */
	public void gotoabnormalOrder(){
		try{
			abnormalOrderViewController abnormalOrder=(abnormalOrderViewController) replaceSceneContent("orderOnWeb/abnormalOrder.fxml");
			abnormalOrder.setApp(this);
		}catch(Exception ex){
			ex.printStackTrace();
		}
	}
	
	/**
	 * 跳转到异常订单信息界面
	 */
	public void gotoabnormalOrderInfo(){
		try{
			abnormalOrderInfoViewController abnormalOrderInfo=(abnormalOrderInfoViewController) replaceSceneContent("orderOnWeb/abnormalOrderInfo.fxml");
			abnormalOrderInfo.setApp(this);
		}catch(Exception ex){
			ex.printStackTrace();
		}
	}
	
	/**
	 * 跳转到预定过的酒店信息界面
	 */
	public void gotoreservedHotelInfo(){
		try{
			reservedHotelInfoViewController reservedHotelInfo=(reservedHotelInfoViewController) replaceSceneContent("reservedHotel/reservedHotelInfo.fxml");
			reservedHotelInfo.setApp(this);
		}catch(Exception ex){
			ex.printStackTrace();
		}
	}
	
	/**
	 * 跳转到预定过的酒店列表界面
	 */
	public void gotoreservedHotelList(){
		try{
			reservedHotelListViewController reservedHotelList=(reservedHotelListViewController) replaceSceneContent("reservedHotel/reservedHotelList.fxml");
			reservedHotelList.setApp(this);
		}catch(Exception ex){
			ex.printStackTrace();
		}
	}
	
	/**
	 * 跳转到添加可用客房界面
	 */
	public void gotoroomAdd(){
		try{
			roomAddViewController roomAdd=(roomAddViewController) replaceSceneContent("roomAdd/roomAdd.fxml");
			roomAdd.setApp(this);
		}catch(Exception ex){
			ex.printStackTrace();
		}
	}
	
	/**
	 * 跳转到修改客房信息界面
	 */
	public void gotoroomModify(){
		try{
			roomModifyViewController roomModify=(roomModifyViewController) replaceSceneContent("roomAdd/roomModify.fxml");
			roomModify.setApp(this);
		}catch(Exception ex){
			ex.printStackTrace();
		}
	}
	
	
	/**
	 * 跳转到添加可用客房列表界面
	 */
	public void gotoroomList(){
		try{
			roomListViewController roomList=(roomListViewController) replaceSceneContent("roomAdd/roomList.fxml");
			roomList.setApp(this);
		}catch(Exception ex){
			ex.printStackTrace();
		}
	}
	
	/**
	 * 跳转到注册会员界面
	 */
	public void gotovipRegister(){
		try{
			vipRegisterViewController vip=(vipRegisterViewController) replaceSceneContent("vip/vipRegister.fxml");
			vip.setApp(this);
		}catch(Exception ex){
			ex.printStackTrace();
		}
	}
	
	/**
	 * 跳转到网站管理人员导航界面
	 */
	public void gotowebManagerGuide(){
		try{
			webManagerGuideViewController webManagerGuide=(webManagerGuideViewController) replaceSceneContent("webManagerGuide/webManagerGuide.fxml");
			webManagerGuide.setApp(this);
		}catch(Exception ex){
			ex.printStackTrace();
		}
	}
	
	/**
	 * 跳转到网站营销人员导航界面
	 */
	public void gotowebSalesmanGuide(){
		try{
			webSalesmanGuideViewController webSalesmanGuide=(webSalesmanGuideViewController) replaceSceneContent("webSalesmanGuide/webSalesmanGuide.fxml");
			webSalesmanGuide.setApp(this);
		}catch(Exception ex){
			ex.printStackTrace();
		}
	}
	
	/**
	 * 跳转到酒店优惠策略界面
	 */
	public void gotopromotionHotel(){
		try{
			promotionHotelViewController promotionHotel=(promotionHotelViewController) replaceSceneContent("promotionHotel/promotionHotel.fxml");
			promotionHotel.setApp(this);
		}catch(Exception ex){
			ex.printStackTrace();
		}
	}
	
	/**
	 * 跳转到网站优惠策略界面
	 */
	public void gotopromotionWeb(){
		try{
			promotionWebViewController promotionWeb=(promotionWebViewController) replaceSceneContent("promotionWeb/promotionWeb.fxml");
			promotionWeb.setApp(this);
		}catch(Exception ex){
			ex.printStackTrace();
		}
	}
	
	public void gotopromotionHotelBirthday(){
		try{
			promotionHotelBirthdayViewController promotionHotelBirthday=(promotionHotelBirthdayViewController) replaceSceneContent("promotionHotel/promotionHotelBirthday.fxml");
			promotionHotelBirthday.setApp(this);
		}catch(Exception ex){
			ex.printStackTrace();
		}
	}
	
	public void gotopromotionHotelDIY(){
		try{
			promotionHotelDIYViewController promotionHotelDIY=(promotionHotelDIYViewController) replaceSceneContent("promotionHotel/promotionHotelDIY.fxml");
			promotionHotelDIY.setApp(this);
		}catch(Exception ex){
			ex.printStackTrace();
		}
	}
	
	public void gotopromotionHotelEnterprise(){
		try{
			promotionHotelEnterpriseViewController promotionHotelEnterprise=(promotionHotelEnterpriseViewController) replaceSceneContent("promotionHotel/promotionHotelEnterprise.fxml");
			promotionHotelEnterprise.setApp(this);
		}catch(Exception ex){
			ex.printStackTrace();
		}
	}
	
	public void gotopromotionHotelRoom(){
		try{
			promotionHotelRoomViewController promotionHotelRoom=(promotionHotelRoomViewController) replaceSceneContent("promotionHotel/promotionHotelRoom.fxml");
			promotionHotelRoom.setApp(this);
		}catch(Exception ex){
			ex.printStackTrace();
		}
	}
	
	public void gotopromotionWebArea(){
		try{
			promotionWebAreaViewController promotionWebArea=(promotionWebAreaViewController) replaceSceneContent("promotionWeb/promotionWebArea.fxml");
			promotionWebArea.setApp(this);
		}catch(Exception ex){
			ex.printStackTrace();
		}
	}
	
	public void gotopromotionWebDIY(){
		try{
			promotionWebDIYViewController promotionWebDIY=(promotionWebDIYViewController) replaceSceneContent("promotionWeb/promotionWebDIY.fxml");
			promotionWebDIY.setApp(this);
		}catch(Exception ex){
			ex.printStackTrace();
		}
	}
	
	public void gotopromotionWebVIP(){
		try{
			promotionWebVIPViewController promotionWebVIP=(promotionWebVIPViewController) replaceSceneContent("promotionWeb/promotionWebVIP.fxml");
			promotionWebVIP.setApp(this);
		}catch(Exception ex){
			ex.printStackTrace();
		}
	}
	
    private Initializable replaceSceneContent(String fxml) throws Exception{
    	FXMLLoader loader = new FXMLLoader();
		InputStream in = UILaunch.class.getResourceAsStream(fxml);
		loader.setBuilderFactory(new JavaFXBuilderFactory());
		loader.setLocation(UILaunch.class.getResource(fxml));
		AnchorPane page;
		try{
			page = (AnchorPane) loader.load(in);
		} finally {
			in.close();
		}
		Scene scene = new Scene(page,MINIMUM_WINDOW_WIDTH,MINIMUM_WINDOW_HEIGHT);
		stage.setScene(scene);
		stage.sizeToScene();
		return (Initializable)loader.getController();
	}
    
	public static void main(String[] args){
		launch(args);
	}
	

}