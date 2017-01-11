package ui;

import vo.HotelInfoVO;
import vo.PromotionHotelVO;
import vo.PromotionWebVO;

public class UIhelper {
	private static UIhelper instance;
	private UIhelper(){}
	
	private String userID;
	//用于查看酒店信息
	private String hotelID;
	private String orderID;
	//网站管理人员管理客户信息时使用
	private String customerIDbyManager;
	//网站管理人员管理酒店工作人员信息时使用
	private String hotelStuffIDbyManager;
	//网站管理人员管理网站营销人员信息时使用
	private String salesmanIDbyManager;
	//用户搜索酒店时使用
	private HotelInfoVO searchHotel;
	private String roomID;
	private PromotionHotelVO promotionHotel;
	private PromotionWebVO promotionWeb;
	
	
	public static UIhelper getInstance(){
		if(instance==null){
			instance=new UIhelper();
		}
		return instance;
	}
	
	public String getUserID(){
		return userID;
	}
	
	public void setUserID(String str){
		this.userID=str;
	}
	
	public String getHotelID(){
		return hotelID;
	}
	
	public void setHotelID(String str){
		this.hotelID=str;
	}
	
	public String getOrderID(){
		return orderID;
	}
	
	public void setOrderID(String str){
		this.orderID=str;
	}
	
	
	public String getCustomerIDbyManager(){
		return customerIDbyManager;
	}
	
	public void setCustomerIDbyManager(String str){
		this.customerIDbyManager=str;
	}
	
	public String getHotelStuffIDbyManager(){
		return hotelStuffIDbyManager;
	}
	
	public void setHotelStuffIDbyManager(String str){
		this.hotelStuffIDbyManager=str;
	}
	
	public String getSalesmanIDbyManager(){
		return salesmanIDbyManager;
	}
	
	public void setSalesmanIDbyManager(String str){
		this.salesmanIDbyManager=str;
	}
	
	public HotelInfoVO getSearchHotel(){
		return searchHotel;
	}
	
	public void setSearchHotel(HotelInfoVO hotel){
		this.searchHotel=hotel;
	}
	
	public String getRoomID(){
		return roomID;
	}
	
	public void setRoomID(String str){
		this.roomID=str;
	}
	
	public PromotionHotelVO getPromotionHotel(){
		return promotionHotel;
	}
	
	public void setPromotionHotel(PromotionHotelVO vo){
		this.promotionHotel=vo;
	}
	
	public PromotionWebVO getPromotionWeb(){
		return promotionWeb;
	}
	
	public void setPromotionWeb(PromotionWebVO vo){
		this.promotionWeb=vo;
	}
}
