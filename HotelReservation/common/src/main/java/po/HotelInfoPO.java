package po;

import java.io.Serializable;
import java.util.ArrayList;

import util.Adress;
import util.Area;


/**
 * 酒店信息
 * @author 曹畅
 *
 */
public class HotelInfoPO implements Serializable{

	
	private static final long serialVersionUID = 1L;

	/**
	 * 酒店名称
	 */
	public String name;

	/**
	 * 酒店地址
	 */
	public Adress address;
	
	/**
	 * 所属商圈
	 */
	public Area area;
	
	/**
	 * 星级
	 */
	public int level;
	
	/**
	 * 简介
	 */
	public String introduction;
	
	/**
	 * 服务设施
	 */
	public String facility;

	/**
	 * 是否订过
	 */
	public boolean reserve;
	
	/**
	 * 酒店ID
	 */
	public String hotelID;
	
	/**
	 * 用于界面调用时返回对应用户在该酒店的订单信息
	 */
	public ArrayList<OrderPO> order;
	
	/**
	 * 酒店评分
	 */
	public double score;
	
	/**
	 * 酒店起价
	 */
	public int SP;
	
	public HotelInfoPO() {}
	
	public HotelInfoPO(String hotelID,String name, Adress address, Area area, int level, String introduction, String facility, boolean reserve,double score,int SP) {
		this.name = name;
		this.address = address;
		this.area= area;
		this.level= level;
		this.introduction=introduction;
		this.facility=facility;
		this.reserve=reserve;
		this.hotelID = hotelID;
		this.score=score;
		this.SP=SP;
	}

	public String getName() {
		return name;
	}

	public Adress getAddress() {
		return address;
	}
	
	public Area getArea() {
		return area;
	}
	
	public int getLevel() {
		return level;
	}
	
	public String getIntroduction() {
		return introduction;
	}
	
	public String getFacility() {
		return facility;
	}
	
	public boolean getIsReserved(){
		return reserve;
	}

	public String getHotelID() {
		return hotelID;
	}

	
	public void setHotelID(String newID) {
		this.hotelID = newID;
	}
	
	public void setName(String newName) {
		this.name = newName;
	}

	public void setAddress(Adress newAddress) {
		this.address = newAddress;
	}
	
	public void setArea(Area newArea) {
		this.area = newArea;
	}
	
	public void setLevel(int newLevel) {
		this.level = newLevel;
	}
	
	public void setIntroduction(String newIntroduction) {
		this.introduction = newIntroduction;
	}
	
	public void setFacility(String newFacility) {
		this.facility = newFacility;
	}
	
	public void setIsReserved(boolean newReserved){
		this.reserve = newReserved;
	}
	
	public double getScore(){
		return score;
	}
	
	public void setScore(double s){
		score=s;
	}
	
	public int getSP(){
		return SP;
	}
	
	public void setSP(int sp){
		SP=sp;
	}
	
	public ArrayList<OrderPO> getOrder(){
		return order;
	}
	
	public void setOrder(ArrayList<OrderPO> vo){
		this.order=vo;
	}
}	