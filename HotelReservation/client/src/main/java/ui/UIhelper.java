package ui;

import vo.HotelInfoVO;
import vo.PromotionHotelVO;
import vo.PromotionWebVO;

public class UIhelper {
	private static UIhelper instance;
	private UIhelper(){}
	
	private String userID;
	//���ڲ鿴�Ƶ���Ϣ
	private String hotelID;
	private String orderID;
	//��վ������Ա�����ͻ���Ϣʱʹ��
	private String customerIDbyManager;
	//��վ������Ա�����Ƶ깤����Ա��Ϣʱʹ��
	private String hotelStuffIDbyManager;
	//��վ������Ա������վӪ����Ա��Ϣʱʹ��
	private String salesmanIDbyManager;
	//�û������Ƶ�ʱʹ��
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