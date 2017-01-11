package util;

/** 
 * 
 * 
 */
public enum DataServiceType {
	
	HotelEvaluateDataService("HotelEvaluateDataService"),
	HotelInfoDataService("HotelInfoDataService"),
	RoomInfoDataService("RoomInfoDataService"),
	OrderDataService("OrderDataService"),
	PromotionHotelDataService("PromotionHotelDataService"),
	PromotionWebDataService("PromotionWebDataService"),
	CustomerManagementDataService("CustomerManagementDataService"),
	UserManagementDataService("UserManagementDataService"),
	VipDataService("VipDataService"),
	CreditDataService("CreditDataService");
	
	private DataServiceType(String name){
		this.name = name;
	}
	
	private String name;
	
	public String getName(){
		return this.name;
	}
	
}
