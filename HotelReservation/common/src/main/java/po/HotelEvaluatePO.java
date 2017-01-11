package po;

import java.io.Serializable;

/**
 * 酒店评价
 * @author gyf
 *
 */
public class HotelEvaluatePO implements Serializable{

	
	private static final long serialVersionUID = 1L;

	/**
	 * 用户ID
	 */
	private String userID;
	
	/**
	 * 酒店ID
	 */
	private String hotelID;

	/**
	 * 评分
	 */
	private int score;

	/**
	 * 评论
	 */
	private String comment;
	
	/**
	 * 是否预定过
	 */
	private boolean reserve;
	
	/**
	 * 订单ID
	 */
	private String orderID;
	
	public HotelEvaluatePO() {}

	public HotelEvaluatePO(String userID,String hotelID, int score, String comment, boolean reserve, String orderID) {
		this.userID = userID;
		this.hotelID = hotelID;
		this.score = score;
		this.comment = comment;
		this.reserve = reserve;
		this.orderID = orderID;
	}
	
	public String getUserID(){
		return userID;
	}
	
	public String getHotelID(){
		return hotelID;
	}

	public int getScore() {
		return score;
	}

	public String getComment() {
		return comment;
	}

	public boolean getIsReserved(){
		return reserve;
	}
	
	public String getOrderID() {
		return orderID;
	}
	
}	