package vo;

import java.util.ArrayList;

import util.Adress;
import util.Area;

/**
 * 酒店信息
 * @author 曹畅
 *
 */
public class HotelInfoVO {

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
	public ArrayList<OrderVO> order;
	
	/**
	 * 酒店评分
	 */
	public double score;
	
	/**
	 * 用于搜索时保存频分区间上限和下限
	 */
	public double up;
	
	public double down;
	
	/**
	 * 酒店起价
	 */
	public int SP;
	
	
	public HotelInfoVO() {}
	
	public HotelInfoVO(String name, Adress address, Area area, int level, String introduction, String facility, boolean reserve ,String hotelID,double score,int sp) {
		this.name = name;
		this.address = address;
		this.area= area;
		this.level= level;
		this.introduction=introduction;
		this.facility=facility;
		this.reserve=reserve;
		this.hotelID = hotelID;
		this.order=new ArrayList<>();
		this.score=score;
		SP=sp;
	}

	public HotelInfoVO(String name, Adress address, Area area, int level,double up,double down){
		this.name = name;
		this.address = address;
		this.area = area;
		this.level = level;
		this.up = up;
		this.down = down;
	}
	
	public HotelInfoVO(Adress address, Area area){
		this.address=address;
		this.area=area;
		this.name =null;
		this.level= 0;
		this.introduction=null;
		this.facility=null;
		this.reserve=false;
		this.hotelID = null;
		this.order=new ArrayList<>();
		this.score=0;
		this.up = 0;
		this.down = 0;
		SP=0;
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
	
	public ArrayList<OrderVO> getOrder(){
		return order;
	}
	
	public void setOrder(ArrayList<OrderVO> vo){
		this.order=vo;
	}
	
	public double getScore(){
		return score;
	}
	
	public void setScore(double s){
		score=s;
	}

	public double getUp(){
		return up;
	}
	
	public void setUp(double s){
		up=s;
	}
	
	public double getDown(){
		return down;
	}
	
	public void setDown(double s){
		down=s;
	}
	
	public int getSP(){
		return SP;
	}
	
	public void setSP(int sp){
		SP=sp;
	}
	
	public void setName(String str){
		name=str;
	}
	
	public void setLevel(int n){
		level=n;
	}
	
	public void setReserve(boolean b){
		reserve=b;
	}

}	