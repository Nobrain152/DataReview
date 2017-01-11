

package po;

import java.io.Serializable;
import java.util.ArrayList;

import util.OrderState;
import util.RoomType;

/**
 * 订单
 * 
 * @author txin
 *
 */
public class OrderPO implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = -4372713957287414663L;

	/**
	 * 订单发起人
	 */
	public CustomerInfoPO initiator;

	/**
	 * 订单ID
	 */
	public String orderID;

	/**
	 * 酒店ID
	 */
	public String hotelID;

	/**
	 * 价格
	 */
	public double price;

	/**
	 * 订单状态
	 */
	public OrderState orderState;

	/**
	 * 入住时间
	 */
	public String checkInTime;

	/**
	 * 退房时间
	 */
	public String checkOutTime;

	/**
	 * 最晚执行时间
	 */
	public String latestExecutionTime;
	
	/**
	 * 订单撤销时间
	 */
	public String cancelledTime;

	/**
	 * 房间数量
	 */
	public int roomNumber;

	/**
	 * 入住人数
	 */
	public int peopleNumber;

	/**
	 * 是否携带儿童
	 */
	public boolean hasChild;

	/**
	 * 房间信息
	 */
	public ArrayList<String> roomIDs;
	
	/**
	 * 房间类型
	 */
	public RoomType roomType;
	
	public OrderPO() {}
	
	public OrderPO(String orderID,CustomerInfoPO customerInfoPO, 
			OrderState orderState,double price,String hotelID, boolean hasChild,
			String latestExecutionTime, String checkInTime, String checkOutTime,
			String cancelledTime,int roomNumber, int peopleNumber,ArrayList<String> roomIDs,RoomType roomType){
		this.initiator = customerInfoPO;
		this.orderState = orderState;
		this.price = price;
		this.orderID = orderID;
		this.hotelID = hotelID;
		this.hasChild = hasChild;
		this.roomIDs = roomIDs;
		this.latestExecutionTime = latestExecutionTime;
		this.checkInTime = checkInTime;
		this.checkOutTime = checkOutTime;
		this.cancelledTime = cancelledTime;
		this.roomNumber = roomNumber;
		this.peopleNumber = peopleNumber;
		this.roomType = roomType;
	}
	
	public RoomType getRoomType() {
		return roomType;
	}
	
	public void setRoomType(RoomType roomType) {
		this.roomType = roomType;
	}

	public CustomerInfoPO getInitiator() {
		return initiator;
	}

	public OrderState getOrderState() {
		return orderState;
	}

	public double getPrice() {
		return price;
	}

	public String getOrderID() {
		return orderID;
	}

	public String getHotelID() {
		return hotelID;
	}
	
	public ArrayList<String> getRoomIDs() {
		return roomIDs;
	}
	
	public void setRoomIDs(ArrayList<String> roomIDs) {
		this.roomIDs = roomIDs;
	}

	public boolean getHasChild() {
		return hasChild;
	}

	public String getLatestExecutionTime() {
		return latestExecutionTime;
	}

	public int getRoomNumber() {
		return roomNumber;
	}

	public int getPeopleNumber() {
		return peopleNumber;
	}

	public String getCheckInTime() {
		return checkInTime;
	}

	public String getCheckOutTime() {
		return checkOutTime;
	}

	public String getCancelledTime() {
		return cancelledTime;
	}
	
	public void setCancelledTime(String cancelledTime) {
		this.cancelledTime = cancelledTime;
	}
	
	public void setInitiator(CustomerInfoPO initiator) {
		this.initiator = initiator;
	}

	public void setOrderState(OrderState orderState) {
		this.orderState = orderState;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public void setRoomNumber(int roomNumber) {
		this.roomNumber = roomNumber;
	}

	public void setHasChild(boolean hasChild) {
		this.hasChild = hasChild;
	}

	public void setLatestExecutionTime(String lastestExecutionTime) {
		this.latestExecutionTime = lastestExecutionTime;
	}

	public void setPeopleNumber(int peopleNumber) {
		this.peopleNumber = peopleNumber;
	}

	public void setCheckInTime(String checkInTime) {
		this.checkInTime = checkInTime;
	}

	public void setCheckOutTime(String checkOutTime) {
		this.checkOutTime = checkOutTime;
	}
}
