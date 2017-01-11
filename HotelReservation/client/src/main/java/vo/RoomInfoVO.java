package vo;


import util.RoomState;
import util.RoomType;

/**
 * 房间信息
 * @author 曹畅
 *
 */
public class RoomInfoVO {

	/**
	 * 房间状态
	 */
	private RoomState state;
	
	/**
	 * 房间号
	 */
	private String roomID;

	/**
	 * 房间类型
	 */
	private RoomType type;
	
	/**
	 * 价格
	 */
	private double price;
	
	
	
	/**
	 * 房间隶属的酒店ID
	 */
	private String hotelid;
	
	public RoomInfoVO() {}

	public RoomInfoVO(RoomState state, RoomType type, String roomID, double price,String hotelid ) {
		this.state = state;
		this.type = type;
		this.roomID= roomID;
		this.price= price;
		this.hotelid=hotelid;
	}

	public RoomState getState() {
		return state;
	}

	public RoomType getType() {
		return type;
	}
	
	public String getNumber() {
		return roomID;
	}
	
	public double getPrice() {
		return price;
	}
	
	public String getRoomID() {
		return roomID;
	}
	
	public String getHotelid(){
		return hotelid;
	}
	
	public void setState(RoomState s){
		state=s;
	}
}	